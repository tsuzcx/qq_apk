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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
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
  private String KPA = null;
  private b KPL;
  private String[] KPM;
  private boolean KPN = false;
  boolean KPO = false;
  private ListView KPy;
  private int dFx = 2;
  int dlp = 1;
  private TextView oVh;
  private int reT = -1;
  
  private static String[] Z(String[] paramArrayOfString)
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
      String str2 = v.zf(str1);
      ad.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!w.vF(str1)))
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
  
  static boolean aXC(String paramString)
  {
    AppMethodBeat.i(39582);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = ba.aBQ().hEl.a(w.hFd, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!w.vF(str)) {
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
      arrayOfCursor[1] = ba.aBQ().hEm.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
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
  
  private void aa(String[] paramArrayOfString)
  {
    AppMethodBeat.i(39583);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.KPL != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.KPL.aXB(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.oVh.setVisibility(0);
      if (this.KPA != null) {
        this.oVh.setText(this.KPA);
      }
    }
    for (;;)
    {
      if (this.KPL != null)
      {
        paramArrayOfString = this.KPL;
        paramArrayOfString.Juo = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.xJc = null;
        paramArrayOfString.det();
        paramArrayOfString.rT(false);
      }
      AppMethodBeat.o(39583);
      return;
      this.oVh.setText(getString(2131755195));
      continue;
      this.oVh.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39577);
    this.KPy = ((ListView)findViewById(2131306532));
    this.oVh = ((TextView)findViewById(2131299481));
    this.KPM = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.KPA = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.reT = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.dlp = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.dlp == 1)
    {
      i = 2;
      this.dFx = i;
      this.KPO = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      ad.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.dlp), Boolean.valueOf(this.KPO) });
      this.KPL = new b(getApplicationContext(), this.dlp);
      this.KPL.yI(false);
      localLinkedList = new LinkedList();
      switch (this.dlp)
      {
      case 1: 
      default: 
        label216:
        if (this.KPL != null) {
          this.KPL.io(localLinkedList);
        }
        this.KPy.setAdapter(this.KPL);
        this.oVh.setVisibility(8);
        ad.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.reT);
        if (this.dlp == 2)
        {
          setMMTitle("");
          this.KPM = Z(this.KPM);
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
            paramAnonymousMenuItem = g.yhR;
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
      this.KPy.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(39575);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/voicesearch/VoiceSearchResultUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = g.yhR;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) == null)
            {
              i = 0;
              paramAnonymousAdapterView.kvStat(10452, i + "," + paramAnonymousInt);
            }
          }
          else
          {
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).FC(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((aw)localObject).field_username;
            localObject = ((am)localObject).adv();
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
            ad.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(paramAnonymousView)));
            if (paramAnonymousAdapterView.dlp == 3)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
              paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
              paramAnonymousAdapterView.finish();
            }
            else if ((paramAnonymousAdapterView.dlp == 1) || (w.Aq(paramAnonymousView)) || (w.zE(paramAnonymousView)) || (w.vF(paramAnonymousView)) || (w.zB(paramAnonymousView)) || (VoiceSearchResultUI.aXC((String)localObject)))
            {
              if (paramAnonymousAdapterView.dlp == 1)
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
                if (w.zB(paramAnonymousView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousView);
                  if (paramAnonymousAdapterView.KPO)
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
              else if (paramAnonymousAdapterView.dlp == 2)
              {
                if (bt.isNullOrNil(paramAnonymousView))
                {
                  ad.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramAnonymousView)));
                }
                else if (w.zJ(paramAnonymousView))
                {
                  if (u.aAJ())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    d.b(paramAnonymousAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (w.zL(paramAnonymousView))
                {
                  if (u.aAG())
                  {
                    paramAnonymousView = new Intent().putExtra("finish_direct", true);
                    d.b(paramAnonymousAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  }
                  else
                  {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (w.zK(paramAnonymousView))
                {
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (w.zP(paramAnonymousView))
                {
                  MMAppMgr.cancelNotification(paramAnonymousView);
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (w.zH(paramAnonymousView))
                {
                  if (u.aAU()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (w.zU(paramAnonymousView))
                {
                  if (u.aAN())
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
                else if (w.Ac(paramAnonymousView))
                {
                  if (u.aAO())
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
                else if (w.zM(paramAnonymousView))
                {
                  d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                }
                else if (w.zN(paramAnonymousView))
                {
                  if (u.aAQ()) {
                    d.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if (w.zT(paramAnonymousView))
                {
                  if (u.aAK()) {
                    paramAnonymousAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  } else {
                    d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                  }
                }
                else if ((w.zR(paramAnonymousView)) || (w.zS(paramAnonymousView)) || (w.zO(paramAnonymousView)) || (w.zW(paramAnonymousView)) || (w.zX(paramAnonymousView)) || (w.zI(paramAnonymousView)) || (w.Af(paramAnonymousView)))
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
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/voicesearch/VoiceSearchResultUI", "dealSelectContact", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
      });
      aa(this.KPM);
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
      i = u.aAy();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!w.aBl()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!w.aBk())) {
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
    this.KPN = false;
    AppMethodBeat.o(39576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39579);
    super.onDestroy();
    this.KPL.det();
    AppMethodBeat.o(39579);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39581);
    if (4 == paramInt)
    {
      g localg;
      StringBuilder localStringBuilder;
      if (!this.KPN)
      {
        localg = g.yhR;
        localStringBuilder = new StringBuilder().append(this.dFx).append(",").append(this.reT).append(",");
        if (this.KPM != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.KPM.length)
      {
        localg.kvStat(10452, i + ",0");
        if (!this.KPO) {
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
    this.KPN = true;
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