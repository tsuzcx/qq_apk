package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI
  extends MMActivity
{
  private String afRB = null;
  private b afRM;
  private String[] afRN;
  boolean afRO = false;
  private ListView afRz;
  int hAN = 1;
  private int hYb = 2;
  private TextView lNm;
  private boolean nWh = false;
  private int zQC = -1;
  
  private static String[] ac(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39578);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(39578);
      return paramArrayOfString;
    }
    Log.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = aa.getDisplayName(str1);
      Log.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!au.bwE(str1)))
      {
        Log.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str1)));
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(39578);
    return paramArrayOfString;
  }
  
  private void ad(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39583);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.afRM != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.afRM.bDr(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.lNm.setVisibility(0);
      if (this.afRB != null) {
        this.lNm.setText(this.afRB);
      }
    }
    for (;;)
    {
      if (this.afRM != null)
      {
        paramArrayOfString = this.afRM;
        paramArrayOfString.aeaP = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.NTq = null;
        paramArrayOfString.fSd();
        paramArrayOfString.Ek(false);
      }
      AppMethodBeat.o(39583);
      return;
      this.lNm.setText(getString(R.l.gqx));
      continue;
      this.lNm.setVisibility(8);
    }
  }
  
  static boolean bDs(String paramString)
  {
    AppMethodBeat.i(39582);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bh.bCz().oit.a(ab.ojZ, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!au.bwE(str)) {
          localArrayList2.add(str);
        }
        Log.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(str)));
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = bh.bCz().oiu.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      Log.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
      if (i + j <= 1)
      {
        AppMethodBeat.o(39582);
        return true;
      }
      AppMethodBeat.o(39582);
    }
  }
  
  public int getLayoutId()
  {
    return R.i.goZ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39577);
    this.afRz = ((ListView)findViewById(R.h.gdb));
    this.lNm = ((TextView)findViewById(R.h.fGG));
    this.afRN = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.afRB = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.zQC = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.hAN = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.hAN == 1)
    {
      i = 2;
      this.hYb = i;
      this.afRO = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      Log.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.hAN), Boolean.valueOf(this.afRO) });
      this.afRM = new b(getApplicationContext(), this.hAN);
      this.afRM.Nh(false);
      localLinkedList = new LinkedList();
      switch (this.hAN)
      {
      case 1: 
      default: 
        label216:
        if (this.afRM != null) {
          this.afRM.nM(localLinkedList);
        }
        this.afRz.setAdapter(this.afRM);
        this.lNm.setVisibility(8);
        Log.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.zQC);
        if (this.hAN == 2)
        {
          setMMTitle("");
          this.afRN = ac(this.afRN);
        }
        break;
      }
    }
    for (;;)
    {
      setMMTitle(getString(R.l.goZ));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39574);
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = h.OAn;
            localStringBuilder = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) != null) {
              break label122;
            }
          }
          label122:
          for (int i = 0;; i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length)
          {
            paramAnonymousMenuItem.kvStat(10452, i + ",0");
            if (VoiceSearchResultUI.e(VoiceSearchResultUI.this)) {
              VoiceSearchResultUI.this.moveTaskToBack(true);
            }
            VoiceSearchResultUI.this.finish();
            AppMethodBeat.o(39574);
            return true;
          }
        }
      });
      this.afRz.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39575);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          int i;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = h.OAn;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) == null)
            {
              i = 0;
              paramAnonymousAdapterView.kvStat(10452, i + "," + paramAnonymousInt);
            }
          }
          else
          {
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).TF(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((az)localObject).field_username;
            localObject = ((au)localObject).aSV();
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0)) {
              break label219;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(39575);
            return;
            i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length;
            break;
            label219:
            Log.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(paramAnonymousView)));
            if (paramAnonymousAdapterView.hAN == 3)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
              paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
              paramAnonymousAdapterView.finish();
            }
            else if ((paramAnonymousAdapterView.hAN == 1) || (ab.IW(paramAnonymousView)) || (ab.IS(paramAnonymousView)) || (au.bwE(paramAnonymousView)) || (ab.IQ(paramAnonymousView)) || (VoiceSearchResultUI.bDs((String)localObject)))
            {
              if (paramAnonymousAdapterView.hAN == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
                if (ab.IQ(paramAnonymousView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousView);
                  if (paramAnonymousAdapterView.afRO)
                  {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                    paramAnonymousAdapterView.finish();
                  }
                  else
                  {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  }
                }
              }
              else if (paramAnonymousAdapterView.hAN == 2)
              {
                if (Util.isNullOrNil(paramAnonymousView))
                {
                  Log.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramAnonymousView)));
                }
                else if (au.bvV(paramAnonymousView))
                {
                  if (z.bBq())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bvX(paramAnonymousView))
                {
                  if (z.bBn())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bvW(paramAnonymousView))
                {
                  com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (au.bwb(paramAnonymousView))
                {
                  MMAppMgr.iH(paramAnonymousView);
                  com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (au.bvS(paramAnonymousView))
                {
                  if (z.bBB()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bwg(paramAnonymousView))
                {
                  if (z.bBu())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 20);
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bwo(paramAnonymousView))
                {
                  if (z.bBv())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 11);
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bvY(paramAnonymousView))
                {
                  com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (au.bvZ(paramAnonymousView))
                {
                  if (z.bBx()) {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (au.bwf(paramAnonymousView))
                {
                  if (z.bBr()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if ((au.bwd(paramAnonymousView)) || (au.bwe(paramAnonymousView)) || (au.bwa(paramAnonymousView)) || (au.bwi(paramAnonymousView)) || (au.bwj(paramAnonymousView)) || (au.bvT(paramAnonymousView)) || (au.bwr(paramAnonymousView)))
                {
                  com.tencent.mm.br.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else
                {
                  paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                }
              }
            }
            else
            {
              paramAnonymousView = new Intent(paramAnonymousAdapterView, SearchConversationResultUI.class);
              paramAnonymousView.putExtra("SearchConversationResult_User", (String)localObject);
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
      });
      ad(this.afRN);
      AppMethodBeat.o(39577);
      return;
      i = 1;
      break;
      localLinkedList.add("lbsapp");
      localLinkedList.add("shakeapp");
      localLinkedList.add("qqfriend");
      localLinkedList.add("facebookapp");
      localLinkedList.add("feedsapp");
      localLinkedList.add("fmessage");
      localLinkedList.add("voipapp");
      localLinkedList.add("voicevoipapp");
      localLinkedList.add("voiceinputapp");
      localLinkedList.add("linkedinplugin");
      localLinkedList.add("notifymessage");
      localLinkedList.add("appbrand_notify_message");
      i = z.bBf();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!ab.bBR()) || ((i & 0x2) != 0)) {
        localLinkedList.add("tmessage");
      }
      if ((i & 0x20) != 0) {
        localLinkedList.add("qmessage");
      }
      if ((i & 0x80) != 0) {
        localLinkedList.add("qqsync");
      }
      if ((i & 0x10) != 0) {
        localLinkedList.add("medianote");
      }
      if ((0x80000 & i) != 0) {
        localLinkedList.add("newsapp");
      }
      if (((0x40000 & i) != 0) || (!ab.bBQ())) {
        localLinkedList.add("blogapp");
      }
      if ((i & 0x10000) != 0) {
        localLinkedList.add("masssendapp");
      }
      localLinkedList.add("voiceinputapp");
      break label216;
      setMMTitle(getString(R.l.goZ));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39576);
    super.onCreate(paramBundle);
    initView();
    this.nWh = false;
    AppMethodBeat.o(39576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39579);
    super.onDestroy();
    this.afRM.fSd();
    AppMethodBeat.o(39579);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39581);
    if (4 == paramInt)
    {
      h localh;
      StringBuilder localStringBuilder;
      if (!this.nWh)
      {
        localh = h.OAn;
        localStringBuilder = new StringBuilder().append(this.hYb).append(",").append(this.zQC).append(",");
        if (this.afRN != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.afRN.length)
      {
        localh.kvStat(10452, i + ",0");
        if (!this.afRO) {
          break;
        }
        moveTaskToBack(true);
        finish();
        AppMethodBeat.o(39581);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(39581);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39580);
    super.onPause();
    this.nWh = true;
    AppMethodBeat.o(39580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI
 * JD-Core Version:    0.7.0.1
 */