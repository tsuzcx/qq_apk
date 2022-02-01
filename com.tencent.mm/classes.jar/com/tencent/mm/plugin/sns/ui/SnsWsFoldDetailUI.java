package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.ob;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsWsFoldDetailUI
  extends MMActivity
  implements com.tencent.mm.am.h, aa
{
  public long Qsh;
  private d REN;
  private long REO;
  private List<Long> REP;
  public Map<String, Boolean> REQ;
  public Map<String, String> RER;
  public List<String> RES;
  protected l RoZ;
  private i Rza;
  public String ltf;
  public long maxId;
  public boolean nzW;
  public com.tencent.mm.storage.bx psc;
  public ListView qgc;
  public ProgressBar sIX;
  public String username;
  
  public SnsWsFoldDetailUI()
  {
    AppMethodBeat.i(308181);
    this.qgc = null;
    this.sIX = null;
    this.REN = null;
    this.psc = null;
    this.Rza = null;
    this.REO = 0L;
    this.maxId = 0L;
    this.Qsh = 0L;
    this.username = "";
    this.REP = new ArrayList();
    this.ltf = "";
    this.nzW = false;
    this.RoZ = new l(0);
    AppMethodBeat.o(308181);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_ws_fold_detail_layout;
  }
  
  public final boolean hmb()
  {
    AppMethodBeat.i(308211);
    boolean bool = this.Rza.RbH.hmb();
    AppMethodBeat.o(308211);
    return bool;
  }
  
  public final boolean jG(View paramView)
  {
    AppMethodBeat.i(308206);
    boolean bool = this.Rza.RbH.jG(paramView);
    AppMethodBeat.o(308206);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(308196);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.c.h(this, true);
    this.nzW = false;
    this.REO = getIntent().getLongExtra("key_ws_group_id", 0L);
    this.maxId = getIntent().getLongExtra("key_ws_detail_max_id", 0L);
    this.Qsh = getIntent().getLongExtra("key_ws_detail_min_id", 0L);
    this.username = getIntent().getStringExtra("key_ws_detail_username");
    Log.i("MicroMsg.SnsWsFoldDetailUI", "groupId:%s", new Object[] { Long.valueOf(this.REO) });
    paramBundle = getIntent().getStringArrayListExtra("key_ws_str_sns_id_list");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (String)paramBundle.next();
        long l = t.aXD((String)localObject);
        this.REP.add(Long.valueOf(l));
        Log.i("MicroMsg.SnsWsFoldDetailUI", "snsId:%s-%s", new Object[] { localObject, Long.valueOf(l) });
      }
    }
    com.tencent.mm.kernel.h.baF();
    this.psc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    this.ltf = al.hgg();
    this.REQ = new HashMap();
    this.RER = new HashMap();
    this.RES = new ArrayList();
    setMMTitle(b.j.sns_ws_fold_detail_ui_title);
    setActionbarColor(getContext().getResources().getColor(b.c.normal_actionbar_color));
    setBackBtn(new SnsWsFoldDetailUI.1(this), b.i.actionbar_icon_dark_back);
    this.Rza = new ca(this);
    this.Rza.QBg = ((FrameLayout)findViewById(b.f.sns_ws_fold_detail_root));
    this.Rza.RbC = new be(this);
    this.Rza.b(this.RoZ);
    this.qgc = ((ListView)findViewById(b.f.sns_ws_fold_detail_list_view));
    this.sIX = ((ProgressBar)findViewById(b.f.sns_ws_fold_detail_loading));
    paramBundle = this.qgc;
    Object localObject = this.Rza.RbM;
    i locali = this.Rza;
    al.hgg();
    this.REN = new d(this, paramBundle, (com.tencent.mm.plugin.sns.ui.listener.c)localObject, locali);
    this.qgc.setAdapter(this.REN);
    this.Rza.RbJ = new com.tencent.mm.plugin.sns.i.b(this, this.REN.RGC.QBf, this.Rza.QBg);
    this.Rza.RbI = new b(this, this.REN.RGC.QBf, this.Rza.QBg, this.Rza.RbJ);
    this.Rza.RbL = new by(this, this.REN.RGC.QBf, this.Rza.QBg);
    this.Rza.RbK = new as(this, this.REN.RGC.QBf, this.Rza.QBg);
    this.Rza.RbH = new bw(this, this.REN.RGC, this.Rza.QBg);
    this.Rza.QBJ = this.REN.RGC;
    this.Rza.RbA = ((SnsCommentFooter)findViewById(b.f.comment_footer));
    this.Rza.list = this.qgc;
    this.Rza.RbB = new bx(this.qgc, this.Rza.RbA);
    this.qgc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(308268);
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(308268);
          return false;
          SnsWsFoldDetailUI.this.hmb();
          continue;
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).hlC();
          SnsWsFoldDetailUI.a(SnsWsFoldDetailUI.this).RbB.hqG();
        }
      }
    });
    this.sIX.setVisibility(0);
    this.qgc.setVisibility(8);
    this.REN.b(this);
    com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.n(this.REP), 0);
    com.tencent.mm.kernel.h.baD().mCm.a(5987, this);
    com.tencent.mm.kernel.h.baD().mCm.a(213, this);
    com.tencent.mm.kernel.h.baD().mCm.a(218, this);
    com.tencent.mm.kernel.h.baD().mCm.a(214, this);
    com.tencent.mm.pluginsdk.h.x(this);
    AppMethodBeat.o(308196);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(308203);
    super.onDestroy();
    this.nzW = true;
    if (this.Rza != null) {
      this.Rza.clean();
    }
    this.psc = null;
    this.REQ.clear();
    this.RER.clear();
    this.RES.clear();
    com.tencent.mm.kernel.h.baD().mCm.b(5987, this);
    com.tencent.mm.kernel.h.baD().mCm.b(213, this);
    com.tencent.mm.kernel.h.baD().mCm.b(218, this);
    com.tencent.mm.kernel.h.baD().mCm.b(214, this);
    j localj = j.QFS;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localj.QGQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(t.uB(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = localj.QGP;
    ((ob)localObject).jio = ((ob)localObject).F("BrowseFeedList", localStringBuilder.toString(), true);
    localj.QGP.jim = localj.QGQ.size();
    localObject = localj.QGP;
    ((ob)localObject).ijk = ((ob)localObject).F("SessionId", com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA(), true);
    localj.QGP.jip = (System.currentTimeMillis() - localj.AxK);
    Log.i("MicroMsg.SnsReportHelper", "setBrowseFeedList:%s FeedList:%s", new Object[] { localStringBuilder, localj.QGP.jin });
    localj.QGP.bMH();
    localj.QGP = new ob();
    localj.QGQ.clear();
    localj.AxK = 0L;
    AppMethodBeat.o(308203);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(308216);
    super.onKeyboardStateChanged();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308241);
        SnsWsFoldDetailUI.this.hmb();
        AppMethodBeat.o(308241);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.Rza != null) && (this.Rza.RbA != null) && (!this.Rza.RbA.hox()))
      {
        Log.i("MicroMsg.SnsWsFoldDetailUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(308216);
      }
    }
    else if ((keyboardState() == 1) && (this.Rza != null)) {
      this.Rza.hlD();
    }
    AppMethodBeat.o(308216);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(308201);
    super.onPause();
    this.REN.RGC.onPause();
    AppMethodBeat.o(308201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(308197);
    super.onResume();
    this.REN.RGC.onResume();
    AppMethodBeat.o(308197);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(308214);
    Log.i("MicroMsg.SnsWsFoldDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType());
    if (paramp.getType() == 5987)
    {
      paramString = ((com.tencent.mm.plugin.sns.model.n)paramp).Qsf;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.YMW))) {
        ap.a("@__batch", 128, paramString.YMW, t.aXy(t.uA(((SnsObject)paramString.YMW.getFirst()).Id)));
      }
    }
    if (paramp.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.s)paramp;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.Rza.RbN != null)) {
        this.Rza.RbN.dismiss();
      }
    }
    if (this.REN != null) {
      this.REN.b(this);
    }
    AppMethodBeat.o(308214);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI
 * JD-Core Version:    0.7.0.1
 */