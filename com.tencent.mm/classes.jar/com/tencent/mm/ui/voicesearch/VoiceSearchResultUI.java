package com.tencent.mm.ui.voicesearch;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI
  extends MMActivity
{
  private String ABA = null;
  private b ABL;
  private String[] ABM;
  private boolean ABN = false;
  boolean ABO = false;
  private ListView ABy;
  private int cFd = 2;
  private TextView kIg;
  private int mfJ = -1;
  int showType = 1;
  
  private static String[] U(String[] paramArrayOfString)
  {
    AppMethodBeat.i(35373);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(35373);
      return paramArrayOfString;
    }
    ab.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = s.nE(str1);
      ab.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(str2)));
      if ((!localHashMap.containsValue(str2)) || (!t.lA(str1)))
      {
        ab.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str1)));
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(35373);
    return paramArrayOfString;
  }
  
  private void V(String[] paramArrayOfString)
  {
    AppMethodBeat.i(35378);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.ABL != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.ABL.avi(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.kIg.setVisibility(0);
      if (this.ABA != null) {
        this.kIg.setText(this.ABA);
      }
    }
    for (;;)
    {
      if (this.ABL != null)
      {
        paramArrayOfString = this.ABL;
        paramArrayOfString.zsR = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.sIj = null;
        paramArrayOfString.bKb();
        paramArrayOfString.lE(false);
      }
      AppMethodBeat.o(35378);
      return;
      this.kIg.setText(getString(2131296463));
      continue;
      this.kIg.setVisibility(8);
    }
  }
  
  static boolean avj(String paramString)
  {
    AppMethodBeat.i(35377);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = aw.aaz().fkq.b(t.flc, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!t.lA(str)) {
          localArrayList2.add(str);
        }
        ab.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(str)));
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = aw.aaz().fkr.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      ab.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
      if (i + j <= 1)
      {
        AppMethodBeat.o(35377);
        return true;
      }
      AppMethodBeat.o(35377);
    }
  }
  
  public int getLayoutId()
  {
    return 2130971101;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35372);
    this.ABy = ((ListView)findViewById(2131828799));
    this.kIg = ((TextView)findViewById(2131821075));
    this.ABM = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.ABA = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.mfJ = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.showType == 1)
    {
      i = 2;
      this.cFd = i;
      this.ABO = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      ab.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.showType), Boolean.valueOf(this.ABO) });
      this.ABL = new b(getApplicationContext(), this.showType);
      this.ABL.rz(false);
      localLinkedList = new LinkedList();
      switch (this.showType)
      {
      case 1: 
      default: 
        label216:
        if (this.ABL != null) {
          this.ABL.ft(localLinkedList);
        }
        this.ABy.setAdapter(this.ABL);
        this.kIg.setVisibility(8);
        ab.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.mfJ);
        if (this.showType == 2)
        {
          setMMTitle("");
          this.ABM = U(this.ABM);
        }
        break;
      }
    }
    for (;;)
    {
      setMMTitle(getString(2131304590));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(35369);
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = h.qsU;
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
            AppMethodBeat.o(35369);
            return true;
          }
        }
      });
      this.ABy.setOnItemClickListener(new VoiceSearchResultUI.2(this));
      V(this.ABM);
      AppMethodBeat.o(35372);
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
      i = r.Zy();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!t.aaa()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!t.ZZ())) {
        localLinkedList.add("blogapp");
      }
      if ((i & 0x10000) != 0) {
        localLinkedList.add("masssendapp");
      }
      localLinkedList.add("voiceinputapp");
      break label216;
      setMMTitle(getString(2131304590));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35371);
    super.onCreate(paramBundle);
    initView();
    this.ABN = false;
    AppMethodBeat.o(35371);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35374);
    super.onDestroy();
    this.ABL.bKb();
    AppMethodBeat.o(35374);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35376);
    if (4 == paramInt)
    {
      h localh;
      StringBuilder localStringBuilder;
      if (!this.ABN)
      {
        localh = h.qsU;
        localStringBuilder = new StringBuilder().append(this.cFd).append(",").append(this.mfJ).append(",");
        if (this.ABM != null) {
          break label115;
        }
      }
      label115:
      for (int i = 0;; i = this.ABM.length)
      {
        localh.kvStat(10452, i + ",0");
        if (!this.ABO) {
          break;
        }
        moveTaskToBack(true);
        finish();
        AppMethodBeat.o(35376);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(35376);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35375);
    super.onPause();
    this.ABN = true;
    AppMethodBeat.o(35375);
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