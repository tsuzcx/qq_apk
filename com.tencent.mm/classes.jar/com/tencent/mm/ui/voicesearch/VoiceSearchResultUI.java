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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
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
  private ListView HxW;
  private String HxY = null;
  private b Hyj;
  private String[] Hyk;
  private boolean Hyl = false;
  boolean Hym = false;
  int dcz = 1;
  private int dvJ = 2;
  private TextView nOJ;
  private int pMv = -1;
  
  private static String[] X(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39578);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(39578);
      return paramArrayOfString;
    }
    ad.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = v.sh(str1);
      ad.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!w.pF(str1)))
      {
        ad.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str1)));
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(39578);
    return paramArrayOfString;
  }
  
  private void Y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39583);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.Hyj != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.Hyj.aMb(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.nOJ.setVisibility(0);
      if (this.HxY != null) {
        this.nOJ.setText(this.HxY);
      }
    }
    for (;;)
    {
      if (this.Hyj != null)
      {
        paramArrayOfString = this.Hyj;
        paramArrayOfString.GgH = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.vpQ = null;
        paramArrayOfString.cHX();
        paramArrayOfString.qr(false);
      }
      AppMethodBeat.o(39583);
      return;
      this.nOJ.setText(getString(2131755195));
      continue;
      this.nOJ.setVisibility(8);
    }
  }
  
  static boolean aMc(String paramString)
  {
    AppMethodBeat.i(39582);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = az.arV().gLy.b(w.gMn, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!w.pF(str)) {
          localArrayList2.add(str);
        }
        ad.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(str)));
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = az.arV().gLz.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      ad.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
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
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39577);
    this.HxW = ((ListView)findViewById(2131306532));
    this.nOJ = ((TextView)findViewById(2131299481));
    this.Hyk = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.HxY = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.pMv = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.dcz = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.dcz == 1)
    {
      i = 2;
      this.dvJ = i;
      this.Hym = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      ad.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.dcz), Boolean.valueOf(this.Hym) });
      this.Hyj = new b(getApplicationContext(), this.dcz);
      this.Hyj.wN(false);
      localLinkedList = new LinkedList();
      switch (this.dcz)
      {
      case 1: 
      default: 
        label216:
        if (this.Hyj != null) {
          this.Hyj.hP(localLinkedList);
        }
        this.HxW.setAdapter(this.Hyj);
        this.nOJ.setVisibility(8);
        ad.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.pMv);
        if (this.dcz == 2)
        {
          setMMTitle("");
          this.Hyk = X(this.Hyk);
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
            paramAnonymousMenuItem = h.vKh;
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
      this.HxW.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39575);
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = h.vKh;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) != null) {
              break label143;
            }
          }
          Object localObject;
          label143:
          for (int i = 0;; i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length)
          {
            paramAnonymousAdapterView.kvStat(10452, i + "," + paramAnonymousInt);
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).aam(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((au)localObject).field_username;
            localObject = ((af)localObject).ZX();
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0)) {
              break;
            }
            AppMethodBeat.o(39575);
            return;
          }
          ad.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(paramAnonymousView)));
          if (paramAnonymousAdapterView.dcz == 3)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
            paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
            paramAnonymousAdapterView.finish();
            AppMethodBeat.o(39575);
            return;
          }
          if ((paramAnonymousAdapterView.dcz == 1) || (w.tp(paramAnonymousView)) || (w.sE(paramAnonymousView)) || (w.pF(paramAnonymousView)) || (w.sB(paramAnonymousView)) || (VoiceSearchResultUI.aMc((String)localObject)))
          {
            if (paramAnonymousAdapterView.dcz == 1)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              if (w.sB(paramAnonymousView)) {
                ((Intent)localObject).putExtra("Is_group_card", true);
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                e.a((Intent)localObject, paramAnonymousView);
                if (paramAnonymousAdapterView.Hym)
                {
                  paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  paramAnonymousAdapterView.finish();
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
              AppMethodBeat.o(39575);
              return;
            }
            if (paramAnonymousAdapterView.dcz == 2)
            {
              if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousView))
              {
                ad.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramAnonymousView)));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sJ(paramAnonymousView))
              {
                if (u.arb())
                {
                  paramAnonymousView = new Intent().putExtra("finish_direct", true);
                  d.b(paramAnonymousAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sL(paramAnonymousView))
              {
                if (u.aqY())
                {
                  paramAnonymousView = new Intent().putExtra("finish_direct", true);
                  d.b(paramAnonymousAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sK(paramAnonymousView))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sP(paramAnonymousView))
              {
                MMAppMgr.cancelNotification(paramAnonymousView);
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sH(paramAnonymousView))
              {
                if (u.ark())
                {
                  paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sU(paramAnonymousView))
              {
                if (u.are())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("type", 20);
                  d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.tc(paramAnonymousView))
              {
                if (u.arf())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("type", 11);
                  d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sM(paramAnonymousView))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sN(paramAnonymousView))
              {
                if (u.arh())
                {
                  d.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if (w.sT(paramAnonymousView))
              {
                if (u.arc())
                {
                  paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  AppMethodBeat.o(39575);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              if ((w.sR(paramAnonymousView)) || (w.sS(paramAnonymousView)) || (w.sO(paramAnonymousView)) || (w.sW(paramAnonymousView)) || (w.sX(paramAnonymousView)) || (w.sI(paramAnonymousView)) || (w.tf(paramAnonymousView)))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                AppMethodBeat.o(39575);
                return;
              }
              paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
              AppMethodBeat.o(39575);
            }
          }
          else
          {
            paramAnonymousView = new Intent(paramAnonymousAdapterView, SearchConversationResultUI.class);
            paramAnonymousView.putExtra("SearchConversationResult_User", (String)localObject);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(39575);
        }
      });
      Y(this.Hyk);
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
      i = u.aqS();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!w.arv()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!w.aru())) {
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
    this.Hyl = false;
    AppMethodBeat.o(39576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39579);
    super.onDestroy();
    this.Hyj.cHX();
    AppMethodBeat.o(39579);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39581);
    if (4 == paramInt)
    {
      h localh;
      StringBuilder localStringBuilder;
      if (!this.Hyl)
      {
        localh = h.vKh;
        localStringBuilder = new StringBuilder().append(this.dvJ).append(",").append(this.pMv).append(",");
        if (this.Hyk != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.Hyk.length)
      {
        localh.kvStat(10452, i + ",0");
        if (!this.Hym) {
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
    this.Hyl = true;
    AppMethodBeat.o(39580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI
 * JD-Core Version:    0.7.0.1
 */