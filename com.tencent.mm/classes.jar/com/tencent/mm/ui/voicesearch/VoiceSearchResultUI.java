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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
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
  private ListView LlW;
  private String LlY = null;
  private b Lmj;
  private String[] Lmk;
  private boolean Lml = false;
  boolean Lmm = false;
  private int dGC = 2;
  int dmr = 1;
  private TextView pbK;
  private int rmW = -1;
  
  private static String[] Z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39578);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(39578);
      return paramArrayOfString;
    }
    ae.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = w.zP(str1);
      ae.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!x.wb(str1)))
      {
        ae.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str1)));
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(39578);
    return paramArrayOfString;
  }
  
  static boolean aZe(String paramString)
  {
    AppMethodBeat.i(39582);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bc.aCg().hHd.a(x.hHV, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!x.wb(str)) {
          localArrayList2.add(str);
        }
        ae.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(str)));
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = bc.aCg().hHe.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      ae.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
      if (i + j <= 1)
      {
        AppMethodBeat.o(39582);
        return true;
      }
      AppMethodBeat.o(39582);
    }
  }
  
  private void aa(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39583);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.Lmj != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.Lmj.aZd(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.pbK.setVisibility(0);
      if (this.LlY != null) {
        this.pbK.setText(this.LlY);
      }
    }
    for (;;)
    {
      if (this.Lmj != null)
      {
        paramArrayOfString = this.Lmj;
        paramArrayOfString.JPd = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.xYX = null;
        paramArrayOfString.dhl();
        paramArrayOfString.sa(false);
      }
      AppMethodBeat.o(39583);
      return;
      this.pbK.setText(getString(2131755195));
      continue;
      this.pbK.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39577);
    this.LlW = ((ListView)findViewById(2131306532));
    this.pbK = ((TextView)findViewById(2131299481));
    this.Lmk = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.LlY = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.rmW = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.dmr = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.dmr == 1)
    {
      i = 2;
      this.dGC = i;
      this.Lmm = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      ae.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.dmr), Boolean.valueOf(this.Lmm) });
      this.Lmj = new b(getApplicationContext(), this.dmr);
      this.Lmj.yW(false);
      localLinkedList = new LinkedList();
      switch (this.dmr)
      {
      case 1: 
      default: 
        label216:
        if (this.Lmj != null) {
          this.Lmj.iy(localLinkedList);
        }
        this.LlW.setAdapter(this.Lmj);
        this.pbK.setVisibility(8);
        ae.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.rmW);
        if (this.dmr == 2)
        {
          setMMTitle("");
          this.Lmk = Z(this.Lmk);
        }
        break;
      }
    }
    for (;;)
    {
      setMMTitle(getString(2131764763));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39574);
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = g.yxI;
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
      this.LlW.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39575);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = g.yxI;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) == null)
            {
              i = 0;
              paramAnonymousAdapterView.kvStat(10452, i + "," + paramAnonymousInt);
            }
          }
          else
          {
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).Ga(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((aw)localObject).field_username;
            localObject = ((an)localObject).adG();
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
            ae.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(paramAnonymousView)));
            if (paramAnonymousAdapterView.dmr == 3)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
              paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
              paramAnonymousAdapterView.finish();
            }
            else if ((paramAnonymousAdapterView.dmr == 1) || (x.Ba(paramAnonymousView)) || (x.Ao(paramAnonymousView)) || (x.wb(paramAnonymousView)) || (x.Al(paramAnonymousView)) || (VoiceSearchResultUI.aZe((String)localObject)))
            {
              if (paramAnonymousAdapterView.dmr == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
                if (x.Al(paramAnonymousView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousView);
                  if (paramAnonymousAdapterView.Lmm)
                  {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                    paramAnonymousAdapterView.finish();
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  }
                }
              }
              else if (paramAnonymousAdapterView.dmr == 2)
              {
                if (bu.isNullOrNil(paramAnonymousView))
                {
                  ae.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramAnonymousView)));
                }
                else if (x.At(paramAnonymousView))
                {
                  if (v.aAZ())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    d.b(paramAnonymousAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.Av(paramAnonymousView))
                {
                  if (v.aAW())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    d.b(paramAnonymousAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.Au(paramAnonymousView))
                {
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (x.Az(paramAnonymousView))
                {
                  MMAppMgr.cancelNotification(paramAnonymousView);
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (x.Ar(paramAnonymousView))
                {
                  if (v.aBk()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.AE(paramAnonymousView))
                {
                  if (v.aBd())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 20);
                    d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.AM(paramAnonymousView))
                {
                  if (v.aBe())
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("type", 11);
                    d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.Aw(paramAnonymousView))
                {
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (x.Ax(paramAnonymousView))
                {
                  if (v.aBg()) {
                    d.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (x.AD(paramAnonymousView))
                {
                  if (v.aBa()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if ((x.AB(paramAnonymousView)) || (x.AC(paramAnonymousView)) || (x.Ay(paramAnonymousView)) || (x.AG(paramAnonymousView)) || (x.AH(paramAnonymousView)) || (x.As(paramAnonymousView)) || (x.AP(paramAnonymousView)))
                {
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
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
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
      });
      aa(this.Lmk);
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
      i = v.aAO();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!x.aBB()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!x.aBA())) {
        localLinkedList.add("blogapp");
      }
      if ((i & 0x10000) != 0) {
        localLinkedList.add("masssendapp");
      }
      localLinkedList.add("voiceinputapp");
      break label216;
      setMMTitle(getString(2131764763));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39576);
    super.onCreate(paramBundle);
    initView();
    this.Lml = false;
    AppMethodBeat.o(39576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39579);
    super.onDestroy();
    this.Lmj.dhl();
    AppMethodBeat.o(39579);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39581);
    if (4 == paramInt)
    {
      g localg;
      StringBuilder localStringBuilder;
      if (!this.Lml)
      {
        localg = g.yxI;
        localStringBuilder = new StringBuilder().append(this.dGC).append(",").append(this.rmW).append(",");
        if (this.Lmk != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.Lmk.length)
      {
        localg.kvStat(10452, i + ",0");
        if (!this.Lmm) {
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
    this.Lml = true;
    AppMethodBeat.o(39580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI
 * JD-Core Version:    0.7.0.1
 */