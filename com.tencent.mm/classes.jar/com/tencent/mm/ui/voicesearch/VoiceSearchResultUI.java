package com.tencent.mm.ui.voicesearch;

import android.app.Activity;
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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
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
  private ListView XZD;
  private String XZF = null;
  private b XZQ;
  private String[] XZR;
  private boolean XZS = false;
  boolean XZT = false;
  private int fSe = 2;
  int fwp = 1;
  private TextView jkI;
  private int wuw = -1;
  
  private static String[] aa(String[] paramArrayOfString)
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
      String str2 = aa.PJ(str1);
      Log.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!ab.Lj(str1)))
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
  
  private void ab(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39583);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.XZQ != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.XZQ.bAY(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.jkI.setVisibility(0);
      if (this.XZF != null) {
        this.jkI.setText(this.XZF);
      }
    }
    for (;;)
    {
      if (this.XZQ != null)
      {
        paramArrayOfString = this.XZQ;
        paramArrayOfString.Wtw = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.HWE = null;
        paramArrayOfString.eKd();
        paramArrayOfString.za(false);
      }
      AppMethodBeat.o(39583);
      return;
      this.jkI.setText(getString(R.l.enx));
      continue;
      this.jkI.setVisibility(8);
    }
  }
  
  static boolean bAZ(String paramString)
  {
    AppMethodBeat.i(39582);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bh.beI().lqS.a(ab.lsA, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!ab.Lj(str)) {
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
      arrayOfCursor[1] = bh.beI().lqT.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
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
    return R.i.elV;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39577);
    this.XZD = ((ListView)findViewById(R.h.eal));
    this.jkI = ((TextView)findViewById(R.h.dFA));
    this.XZR = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.XZF = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.wuw = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.fwp = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.fwp == 1)
    {
      i = 2;
      this.fSe = i;
      this.XZT = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      Log.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.fwp), Boolean.valueOf(this.XZT) });
      this.XZQ = new b(getApplicationContext(), this.fwp);
      this.XZQ.Hl(false);
      localLinkedList = new LinkedList();
      switch (this.fwp)
      {
      case 1: 
      default: 
        label216:
        if (this.XZQ != null) {
          this.XZQ.kw(localLinkedList);
        }
        this.XZD.setAdapter(this.XZQ);
        this.jkI.setVisibility(8);
        Log.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.wuw);
        if (this.fwp == 2)
        {
          setMMTitle("");
          this.XZR = aa(this.XZR);
        }
        break;
      }
    }
    for (;;)
    {
      setMMTitle(getString(R.l.elV));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39574);
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = h.IzE;
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
      this.XZD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39575);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = h.IzE;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) == null)
            {
              i = 0;
              paramAnonymousAdapterView.kvStat(10452, i + "," + paramAnonymousInt);
            }
          }
          else
          {
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).Qx(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((ax)localObject).field_username;
            localObject = ((as)localObject).ays();
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
            if (paramAnonymousAdapterView.fwp == 3)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
              paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
              paramAnonymousAdapterView.finish();
            }
            else if ((paramAnonymousAdapterView.fwp == 1) || (ab.QY(paramAnonymousView)) || (ab.Qm(paramAnonymousView)) || (ab.Lj(paramAnonymousView)) || (ab.Qj(paramAnonymousView)) || (VoiceSearchResultUI.bAZ((String)localObject)))
            {
              if (paramAnonymousAdapterView.fwp == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
                if (ab.Qj(paramAnonymousView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousView);
                  if (paramAnonymousAdapterView.XZT)
                  {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                    paramAnonymousAdapterView.finish();
                  }
                  else
                  {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  }
                }
              }
              else if (paramAnonymousAdapterView.fwp == 2)
              {
                if (Util.isNullOrNil(paramAnonymousView))
                {
                  Log.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramAnonymousView)));
                }
                else if (ab.Qr(paramAnonymousView))
                {
                  if (z.bdy())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.Qt(paramAnonymousView))
                {
                  if (z.bdv())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.Qs(paramAnonymousView))
                {
                  com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (ab.Qx(paramAnonymousView))
                {
                  MMAppMgr.hg(paramAnonymousView);
                  com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (ab.Qp(paramAnonymousView))
                {
                  if (z.bdJ()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.QC(paramAnonymousView))
                {
                  if (z.bdC())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 20);
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.QK(paramAnonymousView))
                {
                  if (z.bdD())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 11);
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.Qu(paramAnonymousView))
                {
                  com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (ab.Qv(paramAnonymousView))
                {
                  if (z.bdF()) {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (ab.QB(paramAnonymousView))
                {
                  if (z.bdz()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if ((ab.Qz(paramAnonymousView)) || (ab.QA(paramAnonymousView)) || (ab.Qw(paramAnonymousView)) || (ab.QE(paramAnonymousView)) || (ab.QF(paramAnonymousView)) || (ab.Qq(paramAnonymousView)) || (ab.QN(paramAnonymousView)))
                {
                  com.tencent.mm.by.c.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
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
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
      });
      ab(this.XZR);
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
      i = z.bdn();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!ab.bea()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!ab.bdZ())) {
        localLinkedList.add("blogapp");
      }
      if ((i & 0x10000) != 0) {
        localLinkedList.add("masssendapp");
      }
      localLinkedList.add("voiceinputapp");
      break label216;
      setMMTitle(getString(R.l.elV));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39576);
    super.onCreate(paramBundle);
    initView();
    this.XZS = false;
    AppMethodBeat.o(39576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39579);
    super.onDestroy();
    this.XZQ.eKd();
    AppMethodBeat.o(39579);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39581);
    if (4 == paramInt)
    {
      h localh;
      StringBuilder localStringBuilder;
      if (!this.XZS)
      {
        localh = h.IzE;
        localStringBuilder = new StringBuilder().append(this.fSe).append(",").append(this.wuw).append(",");
        if (this.XZR != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.XZR.length)
      {
        localh.kvStat(10452, i + ",0");
        if (!this.XZT) {
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
    this.XZS = true;
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