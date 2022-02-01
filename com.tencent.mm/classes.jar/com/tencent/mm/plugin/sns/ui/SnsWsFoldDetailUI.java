package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.is;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsWsFoldDetailUI
  extends MMActivity
  implements com.tencent.mm.ak.i, x
{
  private long DIf;
  private long DIg;
  protected k EBv;
  private i EKZ;
  private d EQD;
  private long EQE;
  private List<Long> EQF;
  private Map<String, Boolean> EQG;
  private Map<String, String> EQH;
  private List<String> EQI;
  private String gna;
  private ListView krb;
  private ProgressBar mEz;
  private bv oQw;
  private String username;
  
  public SnsWsFoldDetailUI()
  {
    AppMethodBeat.i(203821);
    this.krb = null;
    this.mEz = null;
    this.EQD = null;
    this.oQw = null;
    this.EKZ = null;
    this.EQE = 0L;
    this.DIf = 0L;
    this.DIg = 0L;
    this.username = "";
    this.EQF = new ArrayList();
    this.gna = "";
    this.EBv = new k(0);
    AppMethodBeat.o(203821);
  }
  
  private void bqe()
  {
    AppMethodBeat.i(203826);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203819);
        Cursor localCursor;
        ArrayList localArrayList;
        if (SnsWsFoldDetailUI.b(SnsWsFoldDetailUI.this) != null)
        {
          localCursor = aj.faO().aQ(SnsWsFoldDetailUI.b(SnsWsFoldDetailUI.this), r.Jc(SnsWsFoldDetailUI.c(SnsWsFoldDetailUI.this)), r.Jc(SnsWsFoldDetailUI.d(SnsWsFoldDetailUI.this)));
          localArrayList = new ArrayList();
          if (localCursor == null)
          {
            Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor == null");
            AppMethodBeat.o(203819);
            return;
          }
          if (!localCursor.moveToFirst())
          {
            localCursor.close();
            Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor.moveToFirst == false");
            AppMethodBeat.o(203819);
            return;
          }
        }
        for (;;)
        {
          try
          {
            Object localObject2 = new SnsInfo();
            ((SnsInfo)localObject2).convertFrom(localCursor);
            localArrayList.add(localObject2);
            if (localCursor.moveToNext()) {
              continue;
            }
            int j = localArrayList.size();
            localObject2 = new ArrayList();
            Iterator localIterator = localArrayList.iterator();
            int i = 0;
            if (localIterator.hasNext())
            {
              SnsInfo localSnsInfo = (SnsInfo)localIterator.next();
              SnsObject localSnsObject = an.C(localSnsInfo);
              SnsWsFoldDetailUI localSnsWsFoldDetailUI = SnsWsFoldDetailUI.this;
              bk localbk = SnsWsFoldDetailUI.e(SnsWsFoldDetailUI.this).ESp;
              if (i >= j) {
                break label387;
              }
              bool = true;
              ((List)localObject2).add(r.a(localSnsInfo, localSnsObject, localSnsWsFoldDetailUI, localbk, bool, SnsWsFoldDetailUI.f(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.g(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.h(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.i(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.j(SnsWsFoldDetailUI.this)));
              i += 1;
              continue;
            }
            Log.i("MicroMsg.SnsWsFoldDetailUI", "loadData finish, snsInfoList.size:%s, structlist.size:%s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject2).size()) });
            aj.dRd().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203818);
                SnsWsFoldDetailUI.k(SnsWsFoldDetailUI.this);
                d locald = SnsWsFoldDetailUI.e(SnsWsFoldDetailUI.this);
                List localList = this.EQK;
                locald.dataList.clear();
                locald.dataList.addAll(localList);
                SnsWsFoldDetailUI.e(SnsWsFoldDetailUI.this).notifyDataSetChanged();
                AppMethodBeat.o(203818);
              }
            });
            return;
          }
          finally
          {
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(203819);
          }
          AppMethodBeat.o(203819);
          return;
          label387:
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(203826);
  }
  
  public final boolean ffL()
  {
    AppMethodBeat.i(203828);
    boolean bool = this.EKZ.EoQ.ffL();
    AppMethodBeat.o(203828);
    return bool;
  }
  
  public final boolean fv(View paramView)
  {
    AppMethodBeat.i(203827);
    boolean bool = this.EKZ.EoQ.d(paramView, true, true);
    AppMethodBeat.o(203827);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496524;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203822);
    h.q(this);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.b.e(this, true);
    this.EQE = getIntent().getLongExtra("key_ws_group_id", 0L);
    this.DIf = getIntent().getLongExtra("key_ws_detail_max_id", 0L);
    this.DIg = getIntent().getLongExtra("key_ws_detail_min_id", 0L);
    this.username = getIntent().getStringExtra("key_ws_detail_username");
    Log.i("MicroMsg.SnsWsFoldDetailUI", "groupId:%s", new Object[] { Long.valueOf(this.EQE) });
    paramBundle = getIntent().getStringArrayListExtra("key_ws_str_sns_id_list");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (String)paramBundle.next();
        long l = r.aOw((String)localObject);
        this.EQF.add(Long.valueOf(l));
        Log.i("MicroMsg.SnsWsFoldDetailUI", "snsId:%s-%s", new Object[] { localObject, Long.valueOf(l) });
      }
    }
    g.aAi();
    this.oQw = ((l)g.af(l.class)).aSN();
    this.gna = aj.fau();
    this.EQG = new HashMap();
    this.EQH = new HashMap();
    this.EQI = new ArrayList();
    setMMTitle(2131766310);
    setActionbarColor(getContext().getResources().getColor(2131100898));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(203816);
        SnsWsFoldDetailUI.this.hideVKB();
        SnsWsFoldDetailUI.this.finish();
        AppMethodBeat.o(203816);
        return false;
      }
    }, 2131689492);
    this.EKZ = new bw(this);
    this.EKZ.DQt = ((FrameLayout)findViewById(2131308270));
    this.EKZ.EoL = new bb(this);
    this.EKZ.b(this.EBv);
    this.krb = ((ListView)findViewById(2131308268));
    this.mEz = ((ProgressBar)findViewById(2131308269));
    paramBundle = this.krb;
    Object localObject = this.EKZ.EoV;
    i locali = this.EKZ;
    aj.fau();
    this.EQD = new d(this, paramBundle, (c)localObject, locali);
    this.krb.setAdapter(this.EQD);
    this.EKZ.EoS = new com.tencent.mm.plugin.sns.h.b(this, this.EQD.ESp.DQs, this.EKZ.DQt);
    this.EKZ.EoR = new b(this, this.EQD.ESp.DQs, this.EKZ.DQt, this.EKZ.EoS);
    this.EKZ.EoU = new bu(this, this.EQD.ESp.DQs, this.EKZ.DQt);
    this.EKZ.EoT = new ap(this, this.EQD.ESp.DQs, this.EKZ.DQt);
    this.EKZ.EoQ = new bs(this, this.EQD.ESp, this.EKZ.DQt);
    this.EKZ.DQX = this.EQD.ESp;
    this.EKZ.EoJ = ((SnsCommentFooter)findViewById(2131298947));
    this.EKZ.list = this.krb;
    this.EKZ.EoK = new bt(this.krb, this.EKZ.EoJ);
    this.krb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(203817);
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(203817);
          return false;
          SnsWsFoldDetailUI.this.ffL();
          continue;
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).ffp();
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).EoK.fjZ();
        }
      }
    });
    this.mEz.setVisibility(0);
    this.krb.setVisibility(8);
    bqe();
    g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.n(this.EQF), 0);
    g.aAg().hqi.a(5987, this);
    g.aAg().hqi.a(213, this);
    g.aAg().hqi.a(218, this);
    h.r(this);
    AppMethodBeat.o(203822);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(203825);
    super.onDestroy();
    if (this.EKZ != null) {
      this.EKZ.clean();
    }
    this.oQw = null;
    this.EQG.clear();
    this.EQH.clear();
    this.EQI.clear();
    g.aAg().hqi.b(5987, this);
    g.aAg().hqi.b(213, this);
    g.aAg().hqi.b(218, this);
    if (this.EQD != null) {
      this.EQD.ESp.fiP();
    }
    e locale = e.DUQ;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = locale.DVJ.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(r.Jc(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = locale.DVI;
    ((is)localObject).ePE = ((is)localObject).x("BrowseFeedList", localStringBuilder.toString(), true);
    locale.DVI.ePC = locale.DVJ.size();
    localObject = locale.DVI;
    ((is)localObject).eiB = ((is)localObject).x("SessionId", com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), true);
    locale.DVI.ePF = (System.currentTimeMillis() - locale.viC);
    Log.i("MicroMsg.SnsReportHelper", "setBrowseFeedList:%s FeedList:%s", new Object[] { localStringBuilder, locale.DVI.ePD });
    locale.DVI.bfK();
    locale.DVI = new is();
    locale.DVJ.clear();
    locale.viC = 0L;
    AppMethodBeat.o(203825);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(203830);
    super.onKeyboardStateChanged();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203820);
        SnsWsFoldDetailUI.this.ffL();
        AppMethodBeat.o(203820);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.EKZ != null) && (this.EKZ.EoJ != null) && (!this.EKZ.EoJ.fhW()))
      {
        Log.i("MicroMsg.SnsWsFoldDetailUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(203830);
      }
    }
    else if ((keyboardState() == 1) && (this.EKZ != null)) {
      this.EKZ.ffq();
    }
    AppMethodBeat.o(203830);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(203824);
    super.onPause();
    this.EQD.ESp.onPause();
    AppMethodBeat.o(203824);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(203823);
    super.onResume();
    this.EQD.ESp.onResume();
    AppMethodBeat.o(203823);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(203829);
    Log.i("MicroMsg.SnsWsFoldDetailUI", "onSceneEnd errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bqe();
    AppMethodBeat.o(203829);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI
 * JD-Core Version:    0.7.0.1
 */