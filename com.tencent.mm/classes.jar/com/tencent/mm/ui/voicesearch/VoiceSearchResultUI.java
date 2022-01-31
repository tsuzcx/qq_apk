package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI
  extends MMActivity
{
  private int ewz = 2;
  private TextView iCZ;
  private int jLF = -1;
  int showType = 1;
  private ListView wiG;
  private String wiI = null;
  private b wiT;
  private String[] wiU;
  private boolean wiV = false;
  boolean wiW = false;
  
  private static String[] L(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return paramArrayOfString;
    }
    y.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = r.gV(str1);
      y.d("MicroMsg.VoiceSearchResultUI", "displayname " + str2);
      if ((!localHashMap.containsValue(str2)) || (!s.fn(str1)))
      {
        y.d("MicroMsg.VoiceSearchResultUI", "username " + str1);
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private void M(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.wiT != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.wiT.aev(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.iCZ.setVisibility(0);
      if (this.wiI != null) {
        this.iCZ.setText(this.wiI);
      }
    }
    for (;;)
    {
      if (this.wiT != null)
      {
        paramArrayOfString = this.wiT;
        paramArrayOfString.ves = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        paramArrayOfString.wiK = null;
        paramArrayOfString.bcS();
        paramArrayOfString.jy(false);
      }
      return;
      this.iCZ.setText(getString(R.l.address_empty_voicesearch_tip));
      continue;
      this.iCZ.setVisibility(8);
    }
  }
  
  static boolean aew(String paramString)
  {
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = au.Hx().dUh.b(s.dUT, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!s.fn(str)) {
          localArrayList2.add(str);
        }
        y.d("MicroMsg.VoiceSearchResultUI", "block user " + str);
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = au.Hx().dUi.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      y.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
      if (i + j <= 1) {
        return true;
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.voice_search_result;
  }
  
  protected final void initView()
  {
    this.wiG = ((ListView)findViewById(R.h.voice_search_resultlist));
    this.iCZ = ((TextView)findViewById(R.h.empty_voicesearch_tip_tv));
    this.wiU = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.wiI = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.jLF = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.showType == 1)
    {
      i = 2;
      this.ewz = i;
      this.wiW = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      y.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.showType), Boolean.valueOf(this.wiW) });
      this.wiT = new b(getApplicationContext(), this.showType);
      this.wiT.nP(false);
      localLinkedList = new LinkedList();
      switch (this.showType)
      {
      case 1: 
      default: 
        label208:
        if (this.wiT != null) {
          this.wiT.ej(localLinkedList);
        }
        this.wiG.setAdapter(this.wiT);
        this.iCZ.setVisibility(8);
        y.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.jLF);
        if (this.showType == 2)
        {
          setMMTitle("");
          this.wiU = L(this.wiU);
        }
        break;
      }
    }
    for (;;)
    {
      setMMTitle(getString(R.l.voice_search_result));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = h.nFQ;
            localStringBuilder = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) != null) {
              break label112;
            }
          }
          label112:
          for (int i = 0;; i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length)
          {
            paramAnonymousMenuItem.aC(10452, i + ",0");
            if (VoiceSearchResultUI.e(VoiceSearchResultUI.this)) {
              VoiceSearchResultUI.this.moveTaskToBack(true);
            }
            VoiceSearchResultUI.this.finish();
            return true;
          }
        }
      });
      this.wiG.setOnItemClickListener(new VoiceSearchResultUI.2(this));
      M(this.wiU);
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
      i = q.Gu();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!s.GY()) || ((i & 0x2) != 0)) {
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
      if (((0x40000 & i) != 0) || (!s.GX())) {
        localLinkedList.add("blogapp");
      }
      if ((i & 0x10000) != 0) {
        localLinkedList.add("masssendapp");
      }
      localLinkedList.add("voiceinputapp");
      break label208;
      setMMTitle(getString(R.l.voice_search_result));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.wiV = false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wiT.bcS();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      h localh;
      StringBuilder localStringBuilder;
      if (!this.wiV)
      {
        localh = h.nFQ;
        localStringBuilder = new StringBuilder().append(this.ewz).append(",").append(this.jLF).append(",");
        if (this.wiU != null) {
          break label103;
        }
      }
      label103:
      for (int i = 0;; i = this.wiU.length)
      {
        localh.aC(10452, i + ",0");
        if (!this.wiW) {
          break;
        }
        moveTaskToBack(true);
        finish();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.wiV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI
 * JD-Core Version:    0.7.0.1
 */