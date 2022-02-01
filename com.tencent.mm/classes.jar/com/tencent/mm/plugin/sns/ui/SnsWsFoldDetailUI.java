package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.lb;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsWsFoldDetailUI
  extends MMActivity
  implements com.tencent.mm.an.i, z
{
  private long JVf;
  private long JVg;
  protected l KPn;
  private i KZa;
  private d LeC;
  private long LeD;
  private List<Long> LeE;
  private Map<String, Boolean> LeF;
  private Map<String, String> LeG;
  private List<String> LeH;
  private String iRj;
  private boolean kUn;
  private ListView niO;
  private ProgressBar pDL;
  private com.tencent.mm.storage.bv rSt;
  private String username;
  
  public SnsWsFoldDetailUI()
  {
    AppMethodBeat.i(206554);
    this.niO = null;
    this.pDL = null;
    this.LeC = null;
    this.rSt = null;
    this.KZa = null;
    this.LeD = 0L;
    this.JVf = 0L;
    this.JVg = 0L;
    this.username = "";
    this.LeE = new ArrayList();
    this.iRj = "";
    this.kUn = false;
    this.KPn = new l(0);
    AppMethodBeat.o(206554);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(206569);
    if (!this.kUn) {
      aj.fwa().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202591);
          if (SnsWsFoldDetailUI.b(SnsWsFoldDetailUI.this))
          {
            AppMethodBeat.o(202591);
            return;
          }
          Cursor localCursor;
          ArrayList localArrayList;
          if (SnsWsFoldDetailUI.c(SnsWsFoldDetailUI.this) != null)
          {
            localCursor = aj.fOI().aK(SnsWsFoldDetailUI.c(SnsWsFoldDetailUI.this), com.tencent.mm.plugin.sns.data.t.Qv(SnsWsFoldDetailUI.d(SnsWsFoldDetailUI.this)), com.tencent.mm.plugin.sns.data.t.Qv(SnsWsFoldDetailUI.e(SnsWsFoldDetailUI.this)));
            localArrayList = new ArrayList();
            if (localCursor == null)
            {
              Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor == null");
              AppMethodBeat.o(202591);
              return;
            }
            if (!localCursor.moveToFirst())
            {
              localCursor.close();
              Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor.moveToFirst == false");
              AppMethodBeat.o(202591);
              return;
            }
            if (SnsWsFoldDetailUI.b(SnsWsFoldDetailUI.this))
            {
              AppMethodBeat.o(202591);
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
                SnsObject localSnsObject = an.D(localSnsInfo);
                SnsWsFoldDetailUI localSnsWsFoldDetailUI = SnsWsFoldDetailUI.this;
                bm localbm = SnsWsFoldDetailUI.f(SnsWsFoldDetailUI.this).Lgs;
                if (i >= j) {
                  break label419;
                }
                bool = true;
                ((List)localObject2).add(com.tencent.mm.plugin.sns.data.t.a(localSnsInfo, localSnsObject, localSnsWsFoldDetailUI, localbm, bool, SnsWsFoldDetailUI.g(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.h(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.i(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.j(SnsWsFoldDetailUI.this), SnsWsFoldDetailUI.k(SnsWsFoldDetailUI.this)));
                i += 1;
                continue;
              }
              Log.i("MicroMsg.SnsWsFoldDetailUI", "loadData finish, snsInfoList.size:%s, structlist.size:%s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(((List)localObject2).size()) });
              aj.etE().post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(197915);
                  SnsWsFoldDetailUI.l(SnsWsFoldDetailUI.this);
                  d locald = SnsWsFoldDetailUI.f(SnsWsFoldDetailUI.this);
                  List localList = this.LeJ;
                  locald.dataList.clear();
                  locald.dataList.addAll(localList);
                  SnsWsFoldDetailUI.f(SnsWsFoldDetailUI.this).notifyDataSetChanged();
                  AppMethodBeat.o(197915);
                }
              });
              return;
            }
            finally
            {
              if (localCursor != null) {
                localCursor.close();
              }
              AppMethodBeat.o(202591);
            }
            AppMethodBeat.o(202591);
            return;
            label419:
            boolean bool = false;
          }
        }
      });
    }
    AppMethodBeat.o(206569);
  }
  
  public final boolean fTI()
  {
    AppMethodBeat.i(206572);
    boolean bool = this.KZa.KBZ.fTI();
    AppMethodBeat.o(206572);
    return bool;
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(206570);
    boolean bool = this.KZa.KBZ.d(paramView, true, true);
    AppMethodBeat.o(206570);
    return bool;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_ws_fold_detail_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206560);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.c.f(this, true);
    this.kUn = false;
    this.LeD = getIntent().getLongExtra("key_ws_group_id", 0L);
    this.JVf = getIntent().getLongExtra("key_ws_detail_max_id", 0L);
    this.JVg = getIntent().getLongExtra("key_ws_detail_min_id", 0L);
    this.username = getIntent().getStringExtra("key_ws_detail_username");
    Log.i("MicroMsg.SnsWsFoldDetailUI", "groupId:%s", new Object[] { Long.valueOf(this.LeD) });
    paramBundle = getIntent().getStringArrayListExtra("key_ws_str_sns_id_list");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (String)paramBundle.next();
        long l = com.tencent.mm.plugin.sns.data.t.aZs((String)localObject);
        this.LeE.add(Long.valueOf(l));
        Log.i("MicroMsg.SnsWsFoldDetailUI", "snsId:%s-%s", new Object[] { localObject, Long.valueOf(l) });
      }
    }
    com.tencent.mm.kernel.h.aHH();
    this.rSt = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
    this.iRj = aj.fOo();
    this.LeF = new HashMap();
    this.LeG = new HashMap();
    this.LeH = new ArrayList();
    setMMTitle(i.j.sns_ws_fold_detail_ui_title);
    setActionbarColor(getContext().getResources().getColor(i.c.normal_actionbar_color));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(242508);
        SnsWsFoldDetailUI.this.hideVKB();
        SnsWsFoldDetailUI.this.finish();
        AppMethodBeat.o(242508);
        return false;
      }
    }, i.i.actionbar_icon_dark_back);
    this.KZa = new bz(this);
    this.KZa.KdA = ((FrameLayout)findViewById(i.f.sns_ws_fold_detail_root));
    this.KZa.KBU = new bd(this);
    this.KZa.b(this.KPn);
    this.niO = ((ListView)findViewById(i.f.sns_ws_fold_detail_list_view));
    this.pDL = ((ProgressBar)findViewById(i.f.sns_ws_fold_detail_loading));
    paramBundle = this.niO;
    Object localObject = this.KZa.KCe;
    i locali = this.KZa;
    aj.fOo();
    this.LeC = new d(this, paramBundle, (com.tencent.mm.plugin.sns.ui.d.c)localObject, locali);
    this.niO.setAdapter(this.LeC);
    this.KZa.KCb = new com.tencent.mm.plugin.sns.h.b(this, this.LeC.Lgs.Kdz, this.KZa.KdA);
    this.KZa.KCa = new b(this, this.LeC.Lgs.Kdz, this.KZa.KdA, this.KZa.KCb);
    this.KZa.KCd = new bx(this, this.LeC.Lgs.Kdz, this.KZa.KdA);
    this.KZa.KCc = new ar(this, this.LeC.Lgs.Kdz, this.KZa.KdA);
    this.KZa.KBZ = new bv(this, this.LeC.Lgs, this.KZa.KdA);
    this.KZa.Kee = this.LeC.Lgs;
    this.KZa.KBS = ((SnsCommentFooter)findViewById(i.f.comment_footer));
    this.KZa.list = this.niO;
    this.KZa.KBT = new bw(this.niO, this.KZa.KBS);
    this.niO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208795);
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(208795);
          return false;
          SnsWsFoldDetailUI.this.fTI();
          continue;
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).fTl();
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).KBT.fYi();
        }
      }
    });
    this.pDL.setVisibility(0);
    this.niO.setVisibility(8);
    dlN();
    com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.model.n(this.LeE), 0);
    com.tencent.mm.kernel.h.aHF().kcd.a(5987, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(213, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(218, this);
    com.tencent.mm.pluginsdk.h.s(this);
    AppMethodBeat.o(206560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(206567);
    super.onDestroy();
    this.kUn = true;
    if (this.KZa != null) {
      this.KZa.clean();
    }
    this.rSt = null;
    this.LeF.clear();
    this.LeG.clear();
    this.LeH.clear();
    com.tencent.mm.kernel.h.aHF().kcd.b(5987, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(213, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(218, this);
    g localg = g.Kia;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localg.KiT.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(com.tencent.mm.plugin.sns.data.t.Qv(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = localg.KiS;
    ((lb)localObject).gQa = ((lb)localObject).z("BrowseFeedList", localStringBuilder.toString(), true);
    localg.KiS.gPY = localg.KiT.size();
    localObject = localg.KiS;
    ((lb)localObject).gcU = ((lb)localObject).z("SessionId", com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().deL(), true);
    localg.KiS.gQb = (System.currentTimeMillis() - localg.zUF);
    Log.i("MicroMsg.SnsReportHelper", "setBrowseFeedList:%s FeedList:%s", new Object[] { localStringBuilder, localg.KiS.gPZ });
    localg.KiS.bpa();
    localg.KiS = new lb();
    localg.KiT.clear();
    localg.zUF = 0L;
    AppMethodBeat.o(206567);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(206575);
    super.onKeyboardStateChanged();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198539);
        SnsWsFoldDetailUI.this.fTI();
        AppMethodBeat.o(198539);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.KZa != null) && (this.KZa.KBS != null) && (!this.KZa.KBS.fWj()))
      {
        Log.i("MicroMsg.SnsWsFoldDetailUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(206575);
      }
    }
    else if ((keyboardState() == 1) && (this.KZa != null)) {
      this.KZa.fTm();
    }
    AppMethodBeat.o(206575);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(206563);
    super.onPause();
    this.LeC.Lgs.onPause();
    AppMethodBeat.o(206563);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(206561);
    super.onResume();
    this.LeC.Lgs.onResume();
    AppMethodBeat.o(206561);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(206573);
    if (paramq.getType() == 5987)
    {
      paramString = ((com.tencent.mm.plugin.sns.model.n)paramq).JVd;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.RPI))) {
        an.a("@__batch", 128, paramString.RPI, com.tencent.mm.plugin.sns.data.t.aZn(com.tencent.mm.plugin.sns.data.t.Qu(((SnsObject)paramString.RPI.getFirst()).Id)));
      }
      dlN();
    }
    AppMethodBeat.o(206573);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI
 * JD-Core Version:    0.7.0.1
 */