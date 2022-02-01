package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rr;
import com.tencent.mm.autogen.mmdata.rpt.no;
import com.tencent.mm.autogen.mmdata.rpt.nq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e;
import com.tencent.mm.plugin.findersdk.a.bs;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.cover.preview.SnsCoverContainerLayout;
import com.tencent.mm.plugin.sns.model.ac;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bf.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.widget.h.c;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMOverScrollView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsUIAction
  implements bf.a, c.b
{
  private static int RCN = 0;
  private static int RCO = 1;
  private static int RCP = 2;
  protected View AhP;
  public int CCP;
  private ArrayList<SnsInfo> HIf;
  int KLB;
  protected SnsHeader QCY;
  String QEN;
  private boolean Qol;
  protected MMOverScrollView RCD;
  protected com.tencent.mm.plugin.sns.ui.widget.h RCE;
  protected h.c RCF;
  protected LoadingMoreView RCG;
  private int RCH;
  private int RCI;
  private boolean RCJ;
  public int RCK;
  a RCL;
  private Toolbar.LayoutParams RCM;
  private int RCQ;
  int RCR;
  float RCS;
  float RCT;
  float RCU;
  int RCV;
  int RCW;
  boolean RCX;
  public boolean RCY;
  private com.tencent.threadpool.i.b RCZ;
  ArrayList<n.a> RDa;
  com.tencent.mm.modelsns.l RDb;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.b.c RDc;
  private final com.tencent.mm.plugin.expt.hellhound.ext.a.b.d RDd;
  private boolean RdS;
  boolean Rjd;
  private int Rzb;
  private String Rzk;
  private boolean Rzl;
  private int Rzm;
  View actionbarView;
  protected String filePath;
  boolean isLoading;
  private int lastIndex;
  protected ListView list;
  private Activity mActivity;
  private String mSignature;
  protected View maskView;
  int mbN;
  private String qgV;
  private String sWX;
  private String sessionId;
  int start;
  protected w tipDialog;
  protected String title;
  int uiX;
  protected boolean wFp;
  
  public SnsUIAction(Activity paramActivity)
  {
    AppMethodBeat.i(176361);
    this.RCF = new h.c();
    this.tipDialog = null;
    this.RCH = 0;
    this.RCI = 0;
    this.RCJ = false;
    this.wFp = false;
    this.isLoading = false;
    this.Qol = false;
    this.CCP = 0;
    this.RCK = 0;
    this.RCR = 0;
    this.KLB = 0;
    this.RCS = 1.0F;
    this.RCT = 1.0F;
    this.RCU = 1.0F;
    this.RCV = RCN;
    this.RCW = RCN;
    this.uiX = 0;
    this.start = 0;
    this.mbN = 0;
    this.RCX = false;
    this.Rzb = 800;
    this.RCY = true;
    this.Rjd = false;
    this.HIf = new ArrayList();
    this.RCZ = new com.tencent.threadpool.i.b()
    {
      public final String getKey()
      {
        return "SnsUIAction#preloadRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(307862);
        Object localObject2 = al.hgz();
        synchronized (((ba)localObject2).QyG)
        {
          ((ba)localObject2).QyG.clear();
          ??? = new ArrayList(SnsUIAction.j(SnsUIAction.this)).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (SnsInfo)((Iterator)???).next();
            al.hgz().J((SnsInfo)localObject2);
          }
        }
      }
    };
    this.RDa = null;
    this.RDb = null;
    this.RDd = new com.tencent.mm.plugin.expt.hellhound.ext.a.b.d()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(307813);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(307813);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(307813);
          return;
        }
        BaseAdapter localBaseAdapter = SnsUIAction.k(SnsUIAction.this);
        if (localBaseAdapter == null)
        {
          AppMethodBeat.o(307813);
          return;
        }
        SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, localBaseAdapter, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(307813);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(307816);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(307816);
          return;
        }
        paramAnonymousAbsListView = SnsUIAction.k(SnsUIAction.this);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(307816);
          return;
        }
        SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.getSnsListView(), paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(307816);
      }
    };
    this.mActivity = paramActivity;
    AppMethodBeat.o(176361);
  }
  
  private BaseAdapter aNu()
  {
    if ((this.mActivity == null) || (this.QCY == null) || (this.actionbarView == null)) {}
    while (!(this.mActivity instanceof SnsTimeLineUI)) {
      return null;
    }
    return ((SnsTimeLineUI)this.mActivity).RyU;
  }
  
  private void bA(Intent paramIntent)
  {
    AppMethodBeat.i(99484);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99460);
        com.tencent.mm.plugin.sns.d.a.pFo.aDz();
        AppMethodBeat.o(99460);
      }
    });
    Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    Log.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null)
    {
      AppMethodBeat.o(99484);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.aTu(this.filePath);
    localObject = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.plugin.sns.storage.aa.bd(al.getAccSnsTmpPath(), this.filePath, (String)localObject);
    com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.aTs(this.filePath);
    this.filePath = (al.getAccSnsTmpPath() + (String)localObject);
    Log.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", Util.nowSecond());
      if (this.RDb != null)
      {
        this.RDb.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.RDb = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.Qol)
      {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
        ((Intent)localObject).putExtra("KSnsFrom", 17);
      }
      if (this.RdS) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, com.tencent.mm.hellhoundlib.b.c.a(6, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/sns/ui/SnsUIAction", "jumpToUploadUI", "(Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      this.Qol = false;
      AppMethodBeat.o(99484);
      return;
    }
  }
  
  private void bz(Intent paramIntent)
  {
    AppMethodBeat.i(308000);
    SightCaptureResult localSightCaptureResult = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (localSightCaptureResult == null)
    {
      AppMethodBeat.o(308000);
      return;
    }
    Object localObject;
    if (localSightCaptureResult.KTL)
    {
      this.filePath = localSightCaptureResult.KTT;
      if (!Util.isNullOrNil(this.filePath))
      {
        this.Qol = true;
        bA(paramIntent);
        AppMethodBeat.o(308000);
      }
    }
    else
    {
      if ((this.mActivity instanceof SnsTimeLineUI))
      {
        localObject = com.tencent.mm.plugin.sns.statistics.h.QFO;
        com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "firstEditPageShotMedia", Integer.valueOf(1));
        com.tencent.mm.plugin.comm.b.e.xfd.f("SnsPublishProcess", "endSessionShotMedia", Integer.valueOf(1));
      }
      Log.i("MicroMsg.SnsActivity", "video path %s thumb path ", new Object[] { localSightCaptureResult.KTN, localSightCaptureResult.KTO });
      localObject = new Intent();
      ((Intent)localObject).putExtra("KSightPath", localSightCaptureResult.KTN);
      ((Intent)localObject).putExtra("KSightThumbPath", localSightCaptureResult.KTO);
      if (Util.isNullOrNil(localSightCaptureResult.KTQ)) {
        break label303;
      }
      ((Intent)localObject).putExtra("sight_md5", localSightCaptureResult.KTQ);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KSnsFrom", 17);
      ((Intent)localObject).putExtra("KTouchCameraTime", Util.nowSecond());
      ((Intent)localObject).putExtra("Ksnsupload_type", 14);
      ((Intent)localObject).putExtra("Kis_take_photo", false);
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      try
      {
        paramIntent = localSightCaptureResult.KTS.toByteArray();
        if (paramIntent != null) {
          ((Intent)localObject).putExtra("KMMSightExtInfo", paramIntent);
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          Log.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", new Object[] { paramIntent.getMessage() });
        }
      }
      com.tencent.mm.br.c.b(this.mActivity, "sns", ".ui.SnsUploadUI", (Intent)localObject);
      AppMethodBeat.o(308000);
      return;
      label303:
      ((Intent)localObject).putExtra("sight_md5", com.tencent.mm.vfs.y.bub(localSightCaptureResult.KTN));
    }
  }
  
  public final void EE(String paramString) {}
  
  public final void Eo(boolean paramBoolean)
  {
    AppMethodBeat.i(99479);
    this.RCL.Eo(paramBoolean);
    AppMethodBeat.o(99479);
  }
  
  public final void Eq(boolean paramBoolean)
  {
    AppMethodBeat.i(179310);
    this.Rjd = paramBoolean;
    if (paramBoolean)
    {
      if (this.RCD != null) {
        this.RCD.setEnableGesture(false);
      }
      localSnsHeader = this.QCY;
      if ((localSnsHeader.Rrg != null) && (localSnsHeader.Rrg.RrC != null) && (localSnsHeader.Rrg.RrB != null))
      {
        localSnsHeader.Rrg.RrC.setVisibility(0);
        localSnsHeader.Rrg.RrB.setVisibility(8);
      }
      AppMethodBeat.o(179310);
      return;
    }
    if (this.RCD != null) {
      this.RCD.setEnableGesture(true);
    }
    SnsHeader localSnsHeader = this.QCY;
    if ((localSnsHeader.Rrg != null) && (localSnsHeader.Rrg.RrC != null) && (localSnsHeader.Rrg.RrB != null))
    {
      localSnsHeader.Rrg.RrC.setVisibility(4);
      localSnsHeader.Rrg.RrB.setVisibility(0);
    }
    AppMethodBeat.o(179310);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(308194);
    if (this.QCY != null) {
      this.QCY.a(paramq);
    }
    AppMethodBeat.o(308194);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.Rzk = paramString1;
    this.sWX = paramString2;
    this.qgV = paramString3;
    this.mSignature = paramString4;
    this.Rzl = paramBoolean1;
    this.RdS = paramBoolean2;
    this.Rzm = paramInt;
  }
  
  public final void aXr()
  {
    AppMethodBeat.i(99487);
    AppMethodBeat.o(99487);
  }
  
  public final void bF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99495);
    this.RCL.bF(paramInt, paramBoolean);
    AppMethodBeat.o(99495);
  }
  
  protected final void baP(String paramString)
  {
    AppMethodBeat.i(99488);
    Log.d("MicroMsg.SnsActivity", "snsactivty onIsDownAll ");
    this.RCG.baw(paramString);
    AppMethodBeat.o(99488);
  }
  
  protected final void baw(String paramString)
  {
    AppMethodBeat.i(99490);
    Log.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.RCG.baw(paramString);
    AppMethodBeat.o(99490);
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(99478);
    this.RCZ.cancel();
    this.HIf.clear();
    int i = this.list.getLastVisiblePosition();
    Log.i("MicroMsg.SnsVideoService", "currentPosition :%d count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.list.getCount()) });
    int j = this.list.getCount();
    if (j - i > 15) {
      j = i + 15;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.list.getItemAtPosition(i);
        if (((localObject instanceof SnsInfo)) && (((SnsInfo)localObject).getTypeFlag() == 15) && ((!((SnsInfo)localObject).isAd()) || (com.tencent.mm.plugin.sns.ad.timeline.helper.b.p((SnsInfo)localObject)))) {
          this.HIf.add((SnsInfo)localObject);
        }
        i += 1;
      }
      else
      {
        com.tencent.threadpool.h.ahAA.bm(this.RCZ);
        AppMethodBeat.o(99478);
        return;
      }
    }
  }
  
  public final boolean dsp()
  {
    AppMethodBeat.i(308144);
    View localView = this.list.getChildAt(this.list.getFirstVisiblePosition());
    if ((localView != null) && (localView.getTop() == 0))
    {
      AppMethodBeat.o(308144);
      return true;
    }
    AppMethodBeat.o(308144);
    return false;
  }
  
  public final boolean dsq()
  {
    AppMethodBeat.i(308147);
    View localView = this.list.getChildAt(this.list.getChildCount() - 1);
    if ((localView != null) && (localView.getBottom() <= this.list.getHeight()) && (this.list.getLastVisiblePosition() == this.list.getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(308147);
      return true;
    }
    AppMethodBeat.o(308147);
    return false;
  }
  
  public final int getHeaderHeight()
  {
    AppMethodBeat.i(179311);
    if (this.QCY != null)
    {
      int i = this.QCY.getMeasuredHeight();
      AppMethodBeat.o(179311);
      return i;
    }
    AppMethodBeat.o(179311);
    return 0;
  }
  
  public ListView getSnsListView()
  {
    AppMethodBeat.i(99498);
    ListView localListView = this.RCL.getSnsListView();
    AppMethodBeat.o(99498);
    return localListView;
  }
  
  public final boolean hqd()
  {
    AppMethodBeat.i(308149);
    Log.e("MicroMsg.SnsActivity", "bottomLoad  isAll: %s, isLoading:%s", new Object[] { Boolean.valueOf(this.wFp), Boolean.valueOf(this.isLoading) });
    if ((!this.wFp) && (!this.isLoading))
    {
      this.isLoading = true;
      this.RCL.hpO();
    }
    AppMethodBeat.o(308149);
    return true;
  }
  
  protected final void hqe()
  {
    AppMethodBeat.i(160742);
    this.RCG.atP();
    AppMethodBeat.o(160742);
  }
  
  public final void hqf()
  {
    AppMethodBeat.i(99491);
    if ((this.RCL != null) && (this.RCL.getType() == 2)) {
      al.gHI().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176355);
          Object localObject2 = al.hgF().aZY(SnsUIAction.d(SnsUIAction.this));
          final com.tencent.mm.plugin.sns.data.o localo = new com.tencent.mm.plugin.sns.data.o();
          ArrayList localArrayList;
          HashMap localHashMap;
          Object localObject1;
          String str;
          long l;
          if (!Util.isNullOrNil((List)localObject2))
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localObject1 = "";
            Iterator localIterator = ((List)localObject2).iterator();
            if (localIterator.hasNext())
            {
              fgh localfgh = (fgh)localIterator.next();
              localObject2 = String.valueOf(localfgh.abGi);
              str = String.valueOf(localfgh.abGj);
              l = localfgh.abGk;
              if (Util.isEqual((String)localObject1, (String)localObject2)) {
                break label281;
              }
              localArrayList = new ArrayList();
              localHashMap = new HashMap();
              localo.QnW.add(localObject2);
              localo.QnX.add(localArrayList);
              localo.map.put(localObject2, localHashMap);
              localObject1 = localObject2;
            }
          }
          label281:
          for (;;)
          {
            localArrayList.add(str);
            localHashMap.put(str, Long.valueOf(l));
            break;
            Collections.reverse(localo.QnW);
            Collections.reverse(localo.QnX);
            localObject1 = localo.QnX.iterator();
            while (((Iterator)localObject1).hasNext()) {
              Collections.reverse((List)((Iterator)localObject1).next());
            }
            al.fAG().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(307580);
                SnsUIAction.c(SnsUIAction.this).a(localo);
                AppMethodBeat.o(307580);
              }
            });
            AppMethodBeat.o(176355);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(99491);
  }
  
  public final void hqg()
  {
    AppMethodBeat.i(99493);
    if (getSnsListView() != null) {
      getSnsListView().setVisibility(8);
    }
    AppMethodBeat.o(99493);
  }
  
  public final void hqh()
  {
    AppMethodBeat.i(99494);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V", this);
    if (this.QCY != null)
    {
      SnsHeader localSnsHeader = this.QCY;
      if ((localSnsHeader.Rrg != null) && (localSnsHeader.Rrg.Rrz != null) && (localSnsHeader.Rrq)) {
        localSnsHeader.Rrg.Rrz.hqh();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V");
    AppMethodBeat.o(99494);
  }
  
  public final void hqi()
  {
    AppMethodBeat.i(308183);
    if (this.QCY != null)
    {
      SnsHeader localSnsHeader = this.QCY;
      if ((localSnsHeader.Rrg != null) && (localSnsHeader.Rrg.RrD != null) && (localSnsHeader.ReN != null))
      {
        localSnsHeader.ReN.cancel();
        localSnsHeader.ReN.reset();
        localSnsHeader.Rrg.RrD.startAnimation(localSnsHeader.ReN);
      }
    }
    AppMethodBeat.o(308183);
  }
  
  public final void hqj()
  {
    AppMethodBeat.i(308185);
    if (this.RCG != null)
    {
      LoadingMoreView localLoadingMoreView = this.RCG;
      localLoadingMoreView.ReN.cancel();
      localLoadingMoreView.ReN.reset();
      localLoadingMoreView.hNV.startAnimation(localLoadingMoreView.ReN);
    }
    AppMethodBeat.o(308185);
  }
  
  protected final boolean lN(int paramInt1, int paramInt2)
  {
    int j = 3;
    boolean bool1 = false;
    AppMethodBeat.i(308150);
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.mActivity, null);
      AppMethodBeat.o(308150);
      return false;
    }
    Log.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(paramInt1)));
    Intent localIntent;
    if (paramInt1 == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("username", this.Rzk);
      localIntent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
      com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, com.tencent.mm.hellhoundlib.b.c.a(7, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/sns/ui/SnsUIAction", "selectPhoto", "(II)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(308150);
      return true;
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.h.baF();
      i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(68385, null), 0);
      com.tencent.mm.kernel.h.baF();
      int k = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(68386, null), 0);
      if ((!this.RCJ) && (i < 3) && (k == 0))
      {
        this.RCJ = true;
        br.h(this.mActivity, new SnsUIAction.3(this, paramInt1, paramInt2));
        AppMethodBeat.o(308150);
        return true;
      }
      if (this.mActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
        com.tencent.mm.pluginsdk.ui.tools.t.d(this.mActivity, 2, null);
      }
    }
    else
    {
      AppMethodBeat.o(308150);
      return true;
    }
    int i = com.tencent.mm.k.i.aRC().getInt("SnsCanPickVideoFromAlbum", 1);
    Log.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(i) });
    if (z.pDl) {
      i = 0;
    }
    if (i == 1)
    {
      paramInt1 = j;
      label350:
      localIntent = new Intent();
      boolean bool3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWw, false);
      boolean bool2 = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getSnsMaasConfig().bxi();
      Log.i("MicroMsg.SnsActivity", "enableSnsTemplate:%b", new Object[] { Boolean.valueOf(bool2) });
      i = 9;
      if (bool2)
      {
        com.tencent.mm.plugin.sns.m.a locala = com.tencent.mm.plugin.sns.m.a.QZO;
        i = com.tencent.mm.plugin.sns.m.a.hlp();
      }
      if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWc, 0) != 1) && (!bool3) && (!bool2)) {
        break label629;
      }
      j = 1;
      label468:
      if (j == 0) {
        bool1 = true;
      }
      localIntent.putExtra("key_can_select_video_and_pic", bool1);
      localIntent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.bIg().bIk().duration);
      localIntent.putExtra("key_sns_publish_template", bool2);
      localIntent.putExtra("key_filter_hdr_video", bool2);
      if (!(this.mActivity instanceof SnsUserUI)) {
        break label635;
      }
      localIntent.putExtra("gallery_report_tag", 17);
    }
    for (;;)
    {
      localIntent.putExtra("key_check_third_party_video", true);
      localIntent.putExtra("KSnsFrom", paramInt2);
      localIntent.putExtra("record_video_is_sight_capture", true);
      com.tencent.mm.pluginsdk.ui.tools.t.a(this.mActivity, 14, i, 4, paramInt1, SnsTimeLineUI.hpL(), localIntent);
      if (!SnsTimeLineUI.hpL()) {
        break;
      }
      this.mActivity.overridePendingTransition(com.tencent.mm.plugin.sns.b.a.push_up_in, com.tencent.mm.plugin.sns.b.a.anim_not_change);
      break;
      paramInt1 = j;
      if (i != 0) {
        break label350;
      }
      paramInt1 = 1;
      break label350;
      label629:
      j = 0;
      break label468;
      label635:
      localIntent.putExtra("gallery_report_tag", 4);
    }
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 1115
    //   3: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 298
    //   9: ldc_w 1117
    //   12: iload_1
    //   13: invokestatic 930	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   16: invokevirtual 933	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 1119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload_1
    //   23: bipush 17
    //   25: if_icmpeq +9 -> 34
    //   28: iload_1
    //   29: bipush 14
    //   31: if_icmpne +138 -> 169
    //   34: getstatic 493	com/tencent/mm/plugin/sns/statistics/h:QFO	Lcom/tencent/mm/plugin/sns/statistics/h$a;
    //   37: astore 7
    //   39: iload_1
    //   40: tableswitch	default:+32 -> 72, 14:+188->228, 15:+32->72, 16:+32->72, 17:+181->221
    //   73: istore 4
    //   75: iload 4
    //   77: iconst_m1
    //   78: if_icmpeq +23 -> 101
    //   81: getstatic 499	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   84: ldc_w 501
    //   87: ldc_w 1121
    //   90: iload 4
    //   92: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: getstatic 1127	com/tencent/mm/plugin/comm/b/c:xeU	Lcom/tencent/mm/plugin/comm/b/c;
    //   98: invokevirtual 1130	com/tencent/mm/plugin/comm/b/e$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mm/plugin/comm/b/c;)V
    //   101: iload_2
    //   102: iconst_m1
    //   103: if_icmpeq +66 -> 169
    //   106: getstatic 499	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   109: ldc_w 501
    //   112: ldc_w 1132
    //   115: iconst_4
    //   116: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: getstatic 1135	com/tencent/mm/plugin/comm/b/c:xeS	Lcom/tencent/mm/plugin/comm/b/c;
    //   122: invokevirtual 1130	com/tencent/mm/plugin/comm/b/e$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mm/plugin/comm/b/c;)V
    //   125: getstatic 493	com/tencent/mm/plugin/sns/statistics/h:QFO	Lcom/tencent/mm/plugin/sns/statistics/h$a;
    //   128: astore 7
    //   130: iload_1
    //   131: bipush 17
    //   133: if_icmpne +102 -> 235
    //   136: iconst_1
    //   137: istore 5
    //   139: iload_1
    //   140: bipush 14
    //   142: if_icmpne +99 -> 241
    //   145: iconst_1
    //   146: istore 6
    //   148: iconst_0
    //   149: iload 5
    //   151: iload 6
    //   153: iconst_0
    //   154: iconst_0
    //   155: iconst_0
    //   156: iconst_0
    //   157: invokestatic 1140	com/tencent/mm/plugin/sns/statistics/h$a:a	(IZZZZZZ)V
    //   160: getstatic 493	com/tencent/mm/plugin/sns/statistics/h:QFO	Lcom/tencent/mm/plugin/sns/statistics/h$a;
    //   163: astore 7
    //   165: aconst_null
    //   166: invokestatic 1143	com/tencent/mm/plugin/sns/statistics/h$a:aZm	(Ljava/lang/String;)V
    //   169: iload_2
    //   170: iconst_m1
    //   171: if_icmpeq +76 -> 247
    //   174: iload_1
    //   175: iconst_5
    //   176: if_icmpeq +13 -> 189
    //   179: iload_1
    //   180: iconst_2
    //   181: if_icmpeq +8 -> 189
    //   184: iload_1
    //   185: iconst_4
    //   186: if_icmpne +28 -> 214
    //   189: new 282	com/tencent/mm/sdk/platformtools/MMHandler
    //   192: dup
    //   193: invokestatic 288	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   196: invokespecial 291	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Landroid/os/Looper;)V
    //   199: new 16	com/tencent/mm/plugin/sns/ui/SnsUIAction$12
    //   202: dup
    //   203: aload_0
    //   204: invokespecial 1144	com/tencent/mm/plugin/sns/ui/SnsUIAction$12:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   207: invokevirtual 296	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   210: pop
    //   211: invokestatic 1149	com/tencent/mm/plugin/sns/data/t:heS	()V
    //   214: ldc_w 1115
    //   217: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: bipush 8
    //   223: istore 4
    //   225: goto -150 -> 75
    //   228: bipush 7
    //   230: istore 4
    //   232: goto -157 -> 75
    //   235: iconst_0
    //   236: istore 5
    //   238: goto -99 -> 139
    //   241: iconst_0
    //   242: istore 6
    //   244: goto -96 -> 148
    //   247: iload_1
    //   248: tableswitch	default:+80 -> 328, 2:+230->478, 3:+80->328, 4:+1590->1838, 5:+108->356, 6:+1624->1872, 7:+1678->1926, 8:+1700->1948, 9:+1760->2008, 10:+1860->2108, 11:+80->328, 12:+2030->2278, 13:+2090->2338, 14:+360->608, 15:+2104->2352, 16:+80->328, 17:+96->344
    //   329: aconst_null
    //   330: aload_0
    //   331: ldc_w 1151
    //   334: invokestatic 1153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: ldc_w 1115
    //   340: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: return
    //   344: aload_0
    //   345: aload_3
    //   346: invokespecial 1155	com/tencent/mm/plugin/sns/ui/SnsUIAction:bz	(Landroid/content/Intent;)V
    //   349: ldc_w 1115
    //   352: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: return
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   361: invokevirtual 1159	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   364: aload_3
    //   365: invokestatic 361	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   368: invokestatic 1162	com/tencent/mm/pluginsdk/ui/tools/t:g	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   371: putfield 315	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   374: ldc_w 298
    //   377: new 308	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 1164
    //   384: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 315	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   391: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 315	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   404: ifnonnull +10 -> 414
    //   407: ldc_w 1115
    //   410: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: invokestatic 913	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   417: pop
    //   418: invokestatic 917	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   421: invokevirtual 948	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   424: ldc_w 1165
    //   427: aconst_null
    //   428: invokevirtual 954	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   431: checkcast 505	java/lang/Integer
    //   434: iconst_0
    //   435: invokestatic 958	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   438: istore_1
    //   439: invokestatic 913	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   442: pop
    //   443: invokestatic 917	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   446: invokevirtual 948	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   449: ldc_w 1165
    //   452: iload_1
    //   453: iconst_1
    //   454: iadd
    //   455: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: invokevirtual 1169	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   461: aload_0
    //   462: iconst_1
    //   463: putfield 155	com/tencent/mm/plugin/sns/ui/SnsUIAction:Qol	Z
    //   466: aload_0
    //   467: aload_3
    //   468: invokespecial 487	com/tencent/mm/plugin/sns/ui/SnsUIAction:bA	(Landroid/content/Intent;)V
    //   471: ldc_w 1115
    //   474: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: return
    //   478: aload_3
    //   479: ifnonnull +10 -> 489
    //   482: ldc_w 1115
    //   485: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   488: return
    //   489: invokestatic 913	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   492: pop
    //   493: invokestatic 917	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   496: invokevirtual 948	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   499: ldc_w 1170
    //   502: aconst_null
    //   503: invokevirtual 954	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   506: checkcast 505	java/lang/Integer
    //   509: iconst_0
    //   510: invokestatic 958	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   513: istore_1
    //   514: invokestatic 913	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   517: pop
    //   518: invokestatic 917	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   521: invokevirtual 948	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   524: ldc_w 1170
    //   527: iload_1
    //   528: iconst_1
    //   529: iadd
    //   530: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: invokevirtual 1169	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   536: new 376	android/content/Intent
    //   539: dup
    //   540: invokespecial 529	android/content/Intent:<init>	()V
    //   543: astore 7
    //   545: aload 7
    //   547: ldc_w 1172
    //   550: iconst_4
    //   551: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   554: pop
    //   555: aload 7
    //   557: ldc_w 1174
    //   560: iconst_1
    //   561: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   564: pop
    //   565: aload 7
    //   567: ldc_w 1176
    //   570: iconst_1
    //   571: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   574: pop
    //   575: getstatic 1182	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
    //   578: aload_0
    //   579: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   582: aload_3
    //   583: aload 7
    //   585: invokestatic 361	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   588: new 18	com/tencent/mm/plugin/sns/ui/SnsUIAction$13
    //   591: dup
    //   592: aload_0
    //   593: invokespecial 1183	com/tencent/mm/plugin/sns/ui/SnsUIAction$13:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   596: invokeinterface 1188 6 0
    //   601: ldc_w 1115
    //   604: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: return
    //   608: getstatic 493	com/tencent/mm/plugin/sns/statistics/h:QFO	Lcom/tencent/mm/plugin/sns/statistics/h$a;
    //   611: astore 7
    //   613: aload_0
    //   614: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   617: astore 7
    //   619: aload 7
    //   621: ldc_w 1190
    //   624: invokestatic 1196	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   627: aload 7
    //   629: instanceof 267
    //   632: ifeq +71 -> 703
    //   635: iconst_1
    //   636: istore_1
    //   637: getstatic 499	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   640: ldc_w 501
    //   643: ldc_w 1198
    //   646: iload_1
    //   647: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: invokevirtual 515	com/tencent/mm/plugin/comm/b/e$a:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   653: new 376	android/content/Intent
    //   656: dup
    //   657: aload_0
    //   658: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   661: ldc_w 382
    //   664: invokespecial 385	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   667: astore 10
    //   669: aload 10
    //   671: ldc_w 422
    //   674: bipush 14
    //   676: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   679: pop
    //   680: aload_3
    //   681: ldc_w 1200
    //   684: iconst_0
    //   685: invokevirtual 1204	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   688: ifeq +33 -> 721
    //   691: aload_0
    //   692: aload_3
    //   693: invokespecial 1155	com/tencent/mm/plugin/sns/ui/SnsUIAction:bz	(Landroid/content/Intent;)V
    //   696: ldc_w 1115
    //   699: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: return
    //   703: aload 7
    //   705: instanceof 1088
    //   708: ifeq +8 -> 716
    //   711: iconst_2
    //   712: istore_1
    //   713: goto -76 -> 637
    //   716: iconst_0
    //   717: istore_1
    //   718: goto -81 -> 637
    //   721: new 282	com/tencent/mm/sdk/platformtools/MMHandler
    //   724: dup
    //   725: invokestatic 288	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   728: invokespecial 291	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Landroid/os/Looper;)V
    //   731: new 20	com/tencent/mm/plugin/sns/ui/SnsUIAction$14
    //   734: dup
    //   735: aload_0
    //   736: invokespecial 1205	com/tencent/mm/plugin/sns/ui/SnsUIAction$14:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   739: invokevirtual 296	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   742: pop
    //   743: aload_3
    //   744: ldc_w 1207
    //   747: invokevirtual 1211	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   750: astore 7
    //   752: aload_3
    //   753: ldc_w 1213
    //   756: invokevirtual 430	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   759: invokestatic 1216	com/tencent/mm/plugin/sns/data/t:aXG	(Ljava/lang/String;)V
    //   762: aload 7
    //   764: ifnull +11 -> 775
    //   767: aload 7
    //   769: invokevirtual 1219	java/util/ArrayList:size	()I
    //   772: ifgt +16 -> 788
    //   775: aload_3
    //   776: ldc_w 1221
    //   779: invokevirtual 430	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   782: invokestatic 485	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   785: ifne +537 -> 1322
    //   788: aload 7
    //   790: ifnull +127 -> 917
    //   793: aload 7
    //   795: invokevirtual 1219	java/util/ArrayList:size	()I
    //   798: ifle +119 -> 917
    //   801: aload 7
    //   803: iconst_0
    //   804: invokevirtual 1224	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   807: checkcast 346	java/lang/String
    //   810: astore 7
    //   812: aload_3
    //   813: ldc_w 1226
    //   816: invokevirtual 430	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   819: astore 9
    //   821: aload 9
    //   823: invokestatic 485	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   826: ifne +15 -> 841
    //   829: aload 9
    //   831: astore 8
    //   833: aload 9
    //   835: invokestatic 1229	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   838: ifne +195 -> 1033
    //   841: new 308	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   848: invokestatic 361	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   851: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload 7
    //   856: invokestatic 568	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   859: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: astore 8
    //   867: new 1231	com/tencent/mm/compatible/i/d
    //   870: dup
    //   871: invokespecial 1232	com/tencent/mm/compatible/i/d:<init>	()V
    //   874: astore 9
    //   876: aload 9
    //   878: aload 7
    //   880: invokevirtual 1237	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   883: aload 9
    //   885: lconst_0
    //   886: invokevirtual 1241	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   889: astore 11
    //   891: aload 11
    //   893: ifnonnull +44 -> 937
    //   896: ldc_w 298
    //   899: ldc_w 1243
    //   902: invokestatic 1153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 9
    //   907: invokevirtual 1246	android/media/MediaMetadataRetriever:release	()V
    //   910: ldc_w 1115
    //   913: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: return
    //   917: aload_3
    //   918: ldc_w 1221
    //   921: invokevirtual 430	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   924: astore 7
    //   926: goto -114 -> 812
    //   929: astore_3
    //   930: ldc_w 1115
    //   933: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   936: return
    //   937: ldc_w 298
    //   940: ldc_w 1248
    //   943: iconst_2
    //   944: anewarray 4	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: aload 11
    //   951: invokevirtual 1253	android/graphics/Bitmap:getWidth	()I
    //   954: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   957: aastore
    //   958: dup
    //   959: iconst_1
    //   960: aload 11
    //   962: invokevirtual 1254	android/graphics/Bitmap:getHeight	()I
    //   965: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   968: aastore
    //   969: invokestatic 528	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   972: aload 11
    //   974: bipush 80
    //   976: getstatic 1260	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   979: aload 8
    //   981: iconst_1
    //   982: invokestatic 1266	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   985: pop
    //   986: aload 8
    //   988: invokestatic 1270	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   991: astore 11
    //   993: ldc_w 298
    //   996: ldc_w 1272
    //   999: iconst_2
    //   1000: anewarray 4	java/lang/Object
    //   1003: dup
    //   1004: iconst_0
    //   1005: aload 11
    //   1007: getfield 1277	android/graphics/BitmapFactory$Options:outWidth	I
    //   1010: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1013: aastore
    //   1014: dup
    //   1015: iconst_1
    //   1016: aload 11
    //   1018: getfield 1280	android/graphics/BitmapFactory$Options:outHeight	I
    //   1021: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1024: aastore
    //   1025: invokestatic 528	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1028: aload 9
    //   1030: invokevirtual 1246	android/media/MediaMetadataRetriever:release	()V
    //   1033: ldc_w 298
    //   1036: ldc_w 1282
    //   1039: iconst_4
    //   1040: anewarray 4	java/lang/Object
    //   1043: dup
    //   1044: iconst_0
    //   1045: aload 7
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_1
    //   1050: aload 8
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_2
    //   1055: aload 7
    //   1057: invokestatic 1286	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1060: invokestatic 1291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1063: aastore
    //   1064: dup
    //   1065: iconst_3
    //   1066: aload 8
    //   1068: invokestatic 1286	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1071: invokestatic 1291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1074: aastore
    //   1075: invokestatic 528	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1078: aload 10
    //   1080: ldc_w 531
    //   1083: aload 7
    //   1085: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1088: pop
    //   1089: aload 10
    //   1091: ldc_w 533
    //   1094: aload 8
    //   1096: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1099: pop
    //   1100: aload 10
    //   1102: ldc_w 538
    //   1105: aload 7
    //   1107: invokestatic 568	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1113: pop
    //   1114: aload 10
    //   1116: ldc_w 387
    //   1119: iconst_1
    //   1120: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1123: pop
    //   1124: aload 10
    //   1126: ldc_w 393
    //   1129: invokestatic 398	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1132: invokevirtual 401	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1135: pop
    //   1136: aload 10
    //   1138: ldc_w 540
    //   1141: bipush 14
    //   1143: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1146: pop
    //   1147: aload 10
    //   1149: ldc_w 1293
    //   1152: aload_3
    //   1153: ldc_w 1295
    //   1156: invokevirtual 1299	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   1159: invokevirtual 554	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1162: pop
    //   1163: aload 10
    //   1165: ldc_w 420
    //   1168: iconst_0
    //   1169: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1172: pop
    //   1173: getstatic 1305	com/tencent/mm/plugin/recordvideo/util/l:ObI	Lcom/tencent/mm/plugin/recordvideo/util/l;
    //   1176: astore 7
    //   1178: aload 10
    //   1180: aload_3
    //   1181: invokestatic 1308	com/tencent/mm/plugin/recordvideo/util/l:c	(Landroid/content/Intent;Landroid/content/Intent;)V
    //   1184: aload_0
    //   1185: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1188: astore_3
    //   1189: new 432	com/tencent/mm/hellhoundlib/b/a
    //   1192: dup
    //   1193: invokespecial 433	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1196: aload 10
    //   1198: invokevirtual 442	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1201: astore 7
    //   1203: aload_3
    //   1204: aload 7
    //   1206: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1209: ldc_w 447
    //   1212: ldc_w 1309
    //   1215: ldc_w 1310
    //   1218: ldc_w 1312
    //   1221: ldc_w 1314
    //   1224: ldc_w 450
    //   1227: invokestatic 1317	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1230: aload_3
    //   1231: aload 7
    //   1233: iconst_0
    //   1234: invokevirtual 1320	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1237: checkcast 376	android/content/Intent
    //   1240: invokevirtual 1322	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1243: aload_3
    //   1244: ldc_w 447
    //   1247: ldc_w 1309
    //   1250: ldc_w 1310
    //   1253: ldc_w 1312
    //   1256: ldc_w 1314
    //   1259: ldc_w 450
    //   1262: invokestatic 1325	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1265: ldc_w 1115
    //   1268: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1271: return
    //   1272: astore 11
    //   1274: ldc_w 298
    //   1277: ldc_w 1327
    //   1280: iconst_1
    //   1281: anewarray 4	java/lang/Object
    //   1284: dup
    //   1285: iconst_0
    //   1286: aload 11
    //   1288: invokevirtual 573	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1291: aastore
    //   1292: invokestatic 833	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1295: aload 9
    //   1297: invokevirtual 1246	android/media/MediaMetadataRetriever:release	()V
    //   1300: goto -267 -> 1033
    //   1303: astore 9
    //   1305: goto -272 -> 1033
    //   1308: astore_3
    //   1309: aload 9
    //   1311: invokevirtual 1246	android/media/MediaMetadataRetriever:release	()V
    //   1314: ldc_w 1115
    //   1317: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1320: aload_3
    //   1321: athrow
    //   1322: aload_3
    //   1323: ldc_w 1329
    //   1326: invokevirtual 1333	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1329: ifnull +147 -> 1476
    //   1332: ldc_w 298
    //   1335: ldc_w 1335
    //   1338: invokestatic 1119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1341: aload 10
    //   1343: ldc_w 420
    //   1346: iconst_0
    //   1347: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1350: pop
    //   1351: aload 10
    //   1353: ldc_w 387
    //   1356: iconst_1
    //   1357: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1360: pop
    //   1361: aload 10
    //   1363: ldc_w 540
    //   1366: bipush 14
    //   1368: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1371: pop
    //   1372: aload 10
    //   1374: ldc_w 1329
    //   1377: aload_3
    //   1378: ldc_w 1329
    //   1381: invokevirtual 1333	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1384: invokevirtual 1338	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   1387: pop
    //   1388: aload_0
    //   1389: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1392: astore_3
    //   1393: new 432	com/tencent/mm/hellhoundlib/b/a
    //   1396: dup
    //   1397: invokespecial 433	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1400: aload 10
    //   1402: invokevirtual 442	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1405: astore 7
    //   1407: aload_3
    //   1408: aload 7
    //   1410: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1413: ldc_w 447
    //   1416: ldc_w 1309
    //   1419: ldc_w 1310
    //   1422: ldc_w 1312
    //   1425: ldc_w 1314
    //   1428: ldc_w 450
    //   1431: invokestatic 1317	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1434: aload_3
    //   1435: aload 7
    //   1437: iconst_0
    //   1438: invokevirtual 1320	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1441: checkcast 376	android/content/Intent
    //   1444: invokevirtual 1322	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1447: aload_3
    //   1448: ldc_w 447
    //   1451: ldc_w 1309
    //   1454: ldc_w 1310
    //   1457: ldc_w 1312
    //   1460: ldc_w 1314
    //   1463: ldc_w 450
    //   1466: invokestatic 1325	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1469: ldc_w 1115
    //   1472: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1475: return
    //   1476: aload_3
    //   1477: ldc_w 1340
    //   1480: invokevirtual 1211	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1483: astore 7
    //   1485: aload 7
    //   1487: ifnull +11 -> 1498
    //   1490: aload 7
    //   1492: invokevirtual 1219	java/util/ArrayList:size	()I
    //   1495: ifne +19 -> 1514
    //   1498: ldc_w 298
    //   1501: ldc_w 1342
    //   1504: invokestatic 1119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1507: ldc_w 1115
    //   1510: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1513: return
    //   1514: getstatic 493	com/tencent/mm/plugin/sns/statistics/h:QFO	Lcom/tencent/mm/plugin/sns/statistics/h$a;
    //   1517: astore 8
    //   1519: aload 7
    //   1521: invokestatic 1346	com/tencent/mm/plugin/sns/statistics/h$a:bC	(Ljava/util/ArrayList;)V
    //   1524: new 189	java/util/ArrayList
    //   1527: dup
    //   1528: invokespecial 190	java/util/ArrayList:<init>	()V
    //   1531: astore 8
    //   1533: aload 7
    //   1535: invokevirtual 1350	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1538: astore 9
    //   1540: aload 9
    //   1542: invokeinterface 1355 1 0
    //   1547: ifeq +76 -> 1623
    //   1550: aload 9
    //   1552: invokeinterface 1359 1 0
    //   1557: checkcast 346	java/lang/String
    //   1560: astore 11
    //   1562: aload 11
    //   1564: invokestatic 1365	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1567: invokevirtual 1369	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1570: astore 12
    //   1572: aload 12
    //   1574: ifnull -34 -> 1540
    //   1577: aload 8
    //   1579: ldc_w 1371
    //   1582: iconst_3
    //   1583: anewarray 4	java/lang/Object
    //   1586: dup
    //   1587: iconst_0
    //   1588: aload 11
    //   1590: aastore
    //   1591: dup
    //   1592: iconst_1
    //   1593: aload 12
    //   1595: getfield 1377	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1598: invokestatic 1382	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1601: aastore
    //   1602: dup
    //   1603: iconst_2
    //   1604: aload 12
    //   1606: getfield 1385	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1609: invokestatic 1382	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1612: aastore
    //   1613: invokestatic 1389	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1616: invokevirtual 769	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1619: pop
    //   1620: goto -80 -> 1540
    //   1623: aload_0
    //   1624: aload_3
    //   1625: ldc_w 1391
    //   1628: iconst_0
    //   1629: invokevirtual 1204	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1632: putfield 155	com/tencent/mm/plugin/sns/ui/SnsUIAction:Qol	Z
    //   1635: aload 10
    //   1637: ldc_w 387
    //   1640: iconst_1
    //   1641: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1644: pop
    //   1645: aload 10
    //   1647: ldc_w 393
    //   1650: invokestatic 398	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1653: invokevirtual 401	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1656: pop
    //   1657: aload_0
    //   1658: getfield 201	com/tencent/mm/plugin/sns/ui/SnsUIAction:RDb	Lcom/tencent/mm/modelsns/l;
    //   1661: ifnull +20 -> 1681
    //   1664: aload_0
    //   1665: getfield 201	com/tencent/mm/plugin/sns/ui/SnsUIAction:RDb	Lcom/tencent/mm/modelsns/l;
    //   1668: aload 10
    //   1670: ldc_w 403
    //   1673: invokevirtual 408	com/tencent/mm/modelsns/l:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1676: aload_0
    //   1677: aconst_null
    //   1678: putfield 201	com/tencent/mm/plugin/sns/ui/SnsUIAction:RDb	Lcom/tencent/mm/modelsns/l;
    //   1681: aload_0
    //   1682: getfield 277	com/tencent/mm/plugin/sns/ui/SnsUIAction:RdS	Z
    //   1685: ifeq +14 -> 1699
    //   1688: aload 10
    //   1690: ldc_w 424
    //   1693: bipush 11
    //   1695: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1698: pop
    //   1699: aload_3
    //   1700: ldc_w 374
    //   1703: iconst_0
    //   1704: invokevirtual 380	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1707: istore_1
    //   1708: aload 10
    //   1710: ldc_w 1393
    //   1713: aload 7
    //   1715: invokevirtual 1396	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1718: pop
    //   1719: aload 10
    //   1721: ldc_w 415
    //   1724: iload_1
    //   1725: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1728: pop
    //   1729: aload_0
    //   1730: getfield 155	com/tencent/mm/plugin/sns/ui/SnsUIAction:Qol	Z
    //   1733: ifeq +13 -> 1746
    //   1736: aload 10
    //   1738: ldc_w 420
    //   1741: iconst_1
    //   1742: invokevirtual 391	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1745: pop
    //   1746: aload 10
    //   1748: ldc_w 1398
    //   1751: aload 8
    //   1753: invokevirtual 1402	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1756: pop
    //   1757: ldc_w 298
    //   1760: ldc_w 1404
    //   1763: iconst_1
    //   1764: anewarray 4	java/lang/Object
    //   1767: dup
    //   1768: iconst_0
    //   1769: aload 10
    //   1771: ldc_w 540
    //   1774: iconst_m1
    //   1775: invokevirtual 380	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1778: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1781: aastore
    //   1782: invokestatic 1406	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1785: aload_0
    //   1786: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1789: bipush 6
    //   1791: new 432	com/tencent/mm/hellhoundlib/b/a
    //   1794: dup
    //   1795: invokespecial 433	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1798: invokestatic 438	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1801: aload 10
    //   1803: invokevirtual 442	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1806: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1809: ldc_w 447
    //   1812: ldc_w 1309
    //   1815: ldc_w 1310
    //   1818: ldc_w 452
    //   1821: ldc_w 454
    //   1824: ldc_w 456
    //   1827: invokestatic 461	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   1830: pop
    //   1831: ldc_w 1115
    //   1834: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1837: return
    //   1838: aload_3
    //   1839: ifnonnull +10 -> 1849
    //   1842: ldc_w 1115
    //   1845: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1848: return
    //   1849: aload_0
    //   1850: aload_3
    //   1851: ldc_w 1408
    //   1854: invokevirtual 430	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1857: putfield 315	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   1860: aload_0
    //   1861: aload_3
    //   1862: invokespecial 487	com/tencent/mm/plugin/sns/ui/SnsUIAction:bA	(Landroid/content/Intent;)V
    //   1865: ldc_w 1115
    //   1868: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1871: return
    //   1872: ldc_w 298
    //   1875: ldc_w 1410
    //   1878: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1881: aload_3
    //   1882: ifnonnull +10 -> 1892
    //   1885: ldc_w 1115
    //   1888: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1891: return
    //   1892: aload_3
    //   1893: ldc_w 1412
    //   1896: iconst_m1
    //   1897: invokevirtual 380	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1900: istore_1
    //   1901: aload_0
    //   1902: getfield 579	com/tencent/mm/plugin/sns/ui/SnsUIAction:RCL	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1905: iload_1
    //   1906: aconst_null
    //   1907: aconst_null
    //   1908: invokeinterface 1415 4 0
    //   1913: invokestatic 1419	com/tencent/mm/plugin/sns/model/al:hgx	()Lcom/tencent/mm/plugin/sns/model/bf;
    //   1916: invokevirtual 1424	com/tencent/mm/plugin/sns/model/bf:hej	()V
    //   1919: ldc_w 1115
    //   1922: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1925: return
    //   1926: ldc_w 298
    //   1929: ldc_w 1426
    //   1932: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1935: invokestatic 1419	com/tencent/mm/plugin/sns/model/al:hgx	()Lcom/tencent/mm/plugin/sns/model/bf;
    //   1938: invokevirtual 1424	com/tencent/mm/plugin/sns/model/bf:hej	()V
    //   1941: ldc_w 1115
    //   1944: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1947: return
    //   1948: aload_3
    //   1949: ifnonnull +10 -> 1959
    //   1952: ldc_w 1115
    //   1955: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1958: return
    //   1959: ldc_w 298
    //   1962: ldc_w 1428
    //   1965: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1968: aload_3
    //   1969: ldc_w 1430
    //   1972: invokevirtual 473	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1975: checkcast 1432	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1978: astore_3
    //   1979: aload_3
    //   1980: ifnull +379 -> 2359
    //   1983: aload_0
    //   1984: getfield 579	com/tencent/mm/plugin/sns/ui/SnsUIAction:RCL	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1987: iconst_m1
    //   1988: aload_3
    //   1989: getfield 1436	com/tencent/mm/plugin/sns/data/SnsCmdList:QnS	Ljava/util/List;
    //   1992: aload_3
    //   1993: getfield 1439	com/tencent/mm/plugin/sns/data/SnsCmdList:alK	Ljava/util/List;
    //   1996: invokeinterface 1415 4 0
    //   2001: ldc_w 1115
    //   2004: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2007: return
    //   2008: invokestatic 1419	com/tencent/mm/plugin/sns/model/al:hgx	()Lcom/tencent/mm/plugin/sns/model/bf;
    //   2011: invokevirtual 1424	com/tencent/mm/plugin/sns/model/bf:hej	()V
    //   2014: aload_0
    //   2015: getfield 735	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   2018: astore_3
    //   2019: new 432	com/tencent/mm/hellhoundlib/b/a
    //   2022: dup
    //   2023: invokespecial 433	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2026: aload_3
    //   2027: invokevirtual 442	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2030: astore_3
    //   2031: new 4	java/lang/Object
    //   2034: dup
    //   2035: invokespecial 129	java/lang/Object:<init>	()V
    //   2038: astore 7
    //   2040: aload 7
    //   2042: aload_3
    //   2043: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   2046: ldc_w 447
    //   2049: ldc_w 1309
    //   2052: ldc_w 1310
    //   2055: ldc_w 1441
    //   2058: ldc_w 1443
    //   2061: ldc_w 1445
    //   2064: invokestatic 1317	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2067: aload_3
    //   2068: iconst_0
    //   2069: invokevirtual 1320	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   2072: checkcast 737	android/widget/ListView
    //   2075: invokestatic 1449	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory:scrollToTop	(Landroid/widget/ListView;)V
    //   2078: aload 7
    //   2080: ldc_w 447
    //   2083: ldc_w 1309
    //   2086: ldc_w 1310
    //   2089: ldc_w 1441
    //   2092: ldc_w 1443
    //   2095: ldc_w 1445
    //   2098: invokestatic 1325	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2101: ldc_w 1115
    //   2104: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2107: return
    //   2108: aload_3
    //   2109: ifnonnull +10 -> 2119
    //   2112: ldc_w 1115
    //   2115: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2118: return
    //   2119: iload_2
    //   2120: iconst_m1
    //   2121: if_icmpne +238 -> 2359
    //   2124: aload_3
    //   2125: invokevirtual 1453	android/content/Intent:getData	()Landroid/net/Uri;
    //   2128: astore_3
    //   2129: aload_0
    //   2130: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   2133: aload_3
    //   2134: aconst_null
    //   2135: aconst_null
    //   2136: aconst_null
    //   2137: aconst_null
    //   2138: invokevirtual 1457	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2141: astore_3
    //   2142: aload_3
    //   2143: invokeinterface 1462 1 0
    //   2148: ifeq +123 -> 2271
    //   2151: new 376	android/content/Intent
    //   2154: dup
    //   2155: ldc_w 1464
    //   2158: ldc_w 1466
    //   2161: aload_3
    //   2162: aload_3
    //   2163: ldc_w 1468
    //   2166: invokeinterface 1472 2 0
    //   2171: invokeinterface 1474 2 0
    //   2176: invokestatic 1477	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2179: invokevirtual 933	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2182: invokestatic 1483	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2185: invokespecial 1486	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   2188: astore 7
    //   2190: aload_0
    //   2191: getfield 206	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   2194: astore_3
    //   2195: new 432	com/tencent/mm/hellhoundlib/b/a
    //   2198: dup
    //   2199: invokespecial 433	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2202: aload 7
    //   2204: invokevirtual 442	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2207: astore 7
    //   2209: aload_3
    //   2210: aload 7
    //   2212: invokevirtual 446	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   2215: ldc_w 447
    //   2218: ldc_w 1309
    //   2221: ldc_w 1310
    //   2224: ldc_w 1312
    //   2227: ldc_w 1314
    //   2230: ldc_w 450
    //   2233: invokestatic 1317	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2236: aload_3
    //   2237: aload 7
    //   2239: iconst_0
    //   2240: invokevirtual 1320	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   2243: checkcast 376	android/content/Intent
    //   2246: invokevirtual 1322	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2249: aload_3
    //   2250: ldc_w 447
    //   2253: ldc_w 1309
    //   2256: ldc_w 1310
    //   2259: ldc_w 1312
    //   2262: ldc_w 1314
    //   2265: ldc_w 450
    //   2268: invokestatic 1325	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2271: ldc_w 1115
    //   2274: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2277: return
    //   2278: aload_3
    //   2279: ldc_w 1488
    //   2282: iconst_m1
    //   2283: invokevirtual 380	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2286: istore_1
    //   2287: iload_1
    //   2288: ifle +71 -> 2359
    //   2291: ldc_w 298
    //   2294: ldc_w 1490
    //   2297: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2300: new 1432	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   2303: dup
    //   2304: invokespecial 1491	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   2307: astore_3
    //   2308: aload_3
    //   2309: iload_1
    //   2310: invokevirtual 1494	com/tencent/mm/plugin/sns/data/SnsCmdList:akp	(I)V
    //   2313: aload_0
    //   2314: getfield 579	com/tencent/mm/plugin/sns/ui/SnsUIAction:RCL	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   2317: iconst_m1
    //   2318: aload_3
    //   2319: getfield 1436	com/tencent/mm/plugin/sns/data/SnsCmdList:QnS	Ljava/util/List;
    //   2322: aload_3
    //   2323: getfield 1439	com/tencent/mm/plugin/sns/data/SnsCmdList:alK	Ljava/util/List;
    //   2326: invokeinterface 1415 4 0
    //   2331: ldc_w 1115
    //   2334: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2337: return
    //   2338: invokestatic 1498	com/tencent/mm/plugin/sns/model/al:hgH	()Lcom/tencent/mm/plugin/sns/storage/p;
    //   2341: invokevirtual 1503	com/tencent/mm/plugin/sns/storage/p:dkG	()Z
    //   2344: pop
    //   2345: ldc_w 1115
    //   2348: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2351: return
    //   2352: ldc_w 1115
    //   2355: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2358: return
    //   2359: ldc_w 1115
    //   2362: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2365: return
    //   2366: astore 9
    //   2368: goto -1335 -> 1033
    //   2371: astore 7
    //   2373: goto -1059 -> 1314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2376	0	this	SnsUIAction
    //   0	2376	1	paramInt1	int
    //   0	2376	2	paramInt2	int
    //   0	2376	3	paramIntent	Intent
    //   73	158	4	i	int
    //   137	100	5	bool1	boolean
    //   146	97	6	bool2	boolean
    //   37	2201	7	localObject1	Object
    //   2371	1	7	localException1	Exception
    //   831	921	8	localObject2	Object
    //   819	477	9	localObject3	Object
    //   1303	7	9	localException2	Exception
    //   1538	13	9	localIterator	Iterator
    //   2366	1	9	localException3	Exception
    //   667	1135	10	localIntent	Intent
    //   889	128	11	localObject4	Object
    //   1272	15	11	localException4	Exception
    //   1560	29	11	str	String
    //   1570	35	12	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   905	910	929	java/lang/Exception
    //   876	891	1272	java/lang/Exception
    //   896	905	1272	java/lang/Exception
    //   937	1028	1272	java/lang/Exception
    //   1295	1300	1303	java/lang/Exception
    //   876	891	1308	finally
    //   896	905	1308	finally
    //   937	1028	1308	finally
    //   1274	1295	1308	finally
    //   1028	1033	2366	java/lang/Exception
    //   1309	1314	2371	java/lang/Exception
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(308209);
    if (this.QCY != null)
    {
      SnsHeader localSnsHeader = this.QCY;
      if ((localSnsHeader.Rrg.RrG != null) && (!localSnsHeader.Rrg.RrG.getStatus().evb))
      {
        com.tencent.mm.plugin.sns.ui.widget.h.a(localSnsHeader.Rrr);
        AppMethodBeat.o(308209);
        return true;
      }
      AppMethodBeat.o(308209);
      return false;
    }
    AppMethodBeat.o(308209);
    return false;
  }
  
  public final void onCreate(boolean paramBoolean)
  {
    AppMethodBeat.i(308109);
    this.CCP = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    this.Rzb = ((int)(this.CCP * 0.4D));
    al.hgy().start();
    if (this.actionbarView != null) {
      this.RCM = ((Toolbar.LayoutParams)this.actionbarView.getLayoutParams());
    }
    this.RDc = new com.tencent.mm.plugin.expt.hellhound.ext.a.b.c(this.RDd, "SnsTimelineUI", com.tencent.mm.plugin.expt.hellhound.ext.a.b.c.a.zEw);
    this.list = this.RCL.getSnsListView();
    this.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99459);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        SnsUIAction.a(SnsUIAction.this).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        al.hgq();
        com.tencent.mm.plugin.sns.storage.aa.lD(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        AppMethodBeat.o(99459);
      }
    });
    Object localObject1 = new StringBuilder("list is null ? ");
    boolean bool;
    label209:
    Object localObject2;
    label365:
    SnsHeader localSnsHeader;
    label414:
    label498:
    Object localObject3;
    String str;
    if (this.list != null)
    {
      bool = true;
      Log.i("MicroMsg.SnsActivity", bool);
      this.list.setScrollingCacheEnabled(false);
      this.QCY = new SnsHeader(this.mActivity);
      this.QCY.setSessionId(this.sessionId);
      this.QCY.setEnterObjectId(this.QEN);
      localObject1 = this.QCY;
      if (paramBoolean) {
        break label647;
      }
      paramBoolean = true;
      ((SnsHeader)localObject1).setIsCoverPreview(paramBoolean);
      this.QCY.setBackClickListener(new SnsHeader.a()
      {
        public final boolean W(long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(307824);
          Log.i("MicroMsg.SnsActivity", "friend like %s, %s, %s", new Object[] { SnsUIAction.d(SnsUIAction.this), Long.valueOf(paramAnonymousLong), Boolean.valueOf(paramAnonymousBoolean) });
          Object localObject1;
          if (au.bwO(SnsUIAction.d(SnsUIAction.this)))
          {
            if (paramAnonymousBoolean)
            {
              localObject1 = al.hgF().aZW(SnsUIAction.d(SnsUIAction.this));
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new ac(SnsUIAction.d(SnsUIAction.this), (u)localObject1), 0);
              ((u)localObject1).field_local_flag |= 0x2;
              al.hgF().c((u)localObject1);
              SnsUIAction.e(SnsUIAction.this);
            }
            Log.i("MicroMsg.SnsActivity", "openIM friend like %s", new Object[] { SnsUIAction.d(SnsUIAction.this) });
            j.QFS.QGh.jiE = 1L;
            AppMethodBeat.o(307824);
            return false;
          }
          Object localObject2;
          if (paramAnonymousBoolean)
          {
            localObject1 = new SnsInfo();
            ((SnsInfo)localObject1).field_snsId = paramAnonymousLong;
            ((SnsInfo)localObject1).field_userName = SnsUIAction.d(SnsUIAction.this);
            localObject2 = com.tencent.mm.modelsns.o.bMJ();
            ((TimeLineObject)localObject2).UserName = SnsUIAction.d(SnsUIAction.this);
            ((SnsInfo)localObject1).setTimeLine((TimeLineObject)localObject2);
            localObject2 = ap.aYv(SnsUIAction.d(SnsUIAction.this));
            if (localObject2 != null) {
              break label307;
            }
            ar.a.a((SnsInfo)localObject1, 1, "", 0);
          }
          for (;;)
          {
            SnsUIAction.e(SnsUIAction.this);
            localObject1 = al.hgG().aZM(SnsUIAction.d(SnsUIAction.this));
            if ((localObject1 == null) || (((q)localObject1).field_snsBgId != paramAnonymousLong)) {
              break;
            }
            ((q)localObject1).field_isLike = paramAnonymousBoolean;
            al.hgG().a((q)localObject1, false);
            break;
            label307:
            if (((SnsInfo)localObject2).isExtFlag()) {
              ar.a.a((SnsInfo)localObject1, 1, "", 0);
            } else {
              ar.a.a((SnsInfo)localObject1, 5, "", 0);
            }
          }
        }
        
        public final void hoI()
        {
          AppMethodBeat.i(307820);
          if ((SnsUIAction.b(SnsUIAction.this)) || (SnsUIAction.c(SnsUIAction.this).getType() == 1)) {
            SnsUIAction.this.lN(2, 4);
          }
          AppMethodBeat.o(307820);
        }
      });
      this.AhP = this.RCL.hpP();
      this.maskView = this.RCL.getMaskView();
      this.RCG = new LoadingMoreView(this.mActivity);
      this.list.addHeaderView(this.QCY);
      this.list.addFooterView(this.RCG);
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(99470);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt3);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          System.currentTimeMillis();
          localObject = SnsUIAction.this.QCY;
          if ((((SnsHeader)localObject).Rrg != null) && (((SnsHeader)localObject).Rrg.Rrz != null) && (((SnsHeader)localObject).Rrq)) {
            ((SnsHeader)localObject).Rrg.Rrz.huG();
          }
          SnsUIAction.c(SnsUIAction.this).hpT();
          SnsUIAction.this.RCK = (paramAnonymousInt1 + paramAnonymousInt2 - 1);
          if ((SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 3) && (SnsUIAction.this.list.getCount() != SnsUIAction.f(SnsUIAction.this)))
          {
            Log.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(SnsUIAction.this.list.getCount()) });
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.list.getCount());
            SnsUIAction.this.hqd();
          }
          if (paramAnonymousAbsListView.getChildCount() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
          }
          int m = com.tencent.mm.cd.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 20);
          paramAnonymousInt3 = 0;
          float f2 = 1.0F;
          float f1 = 1.0F;
          int k = 1;
          int i = 0;
          int n;
          int i1;
          int j;
          label360:
          SnsUIAction localSnsUIAction;
          label408:
          int i2;
          float f3;
          if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
          {
            i = com.tencent.mm.cd.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 245);
            n = i - com.tencent.mm.cd.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 30);
            i1 = i - com.tencent.mm.cd.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 10);
            localObject = paramAnonymousAbsListView.getChildAt(0);
            if (localObject != null) {
              break label962;
            }
            j = 0;
            if (paramAnonymousInt1 <= SnsUIAction.g(SnsUIAction.this)) {
              break label972;
            }
            SnsUIAction.this.RCV = SnsUIAction.bPa();
            if (localObject != null)
            {
              localSnsUIAction = SnsUIAction.this;
              localSnsUIAction.mbN += ((View)localObject).getHeight();
            }
            SnsUIAction.this.uiX = (-j + SnsUIAction.this.mbN);
            SnsUIAction.b(SnsUIAction.this, paramAnonymousInt1);
            SnsUIAction.c(SnsUIAction.this, j);
            if (SnsUIAction.this.RCW != SnsUIAction.this.RCV)
            {
              SnsUIAction.this.start = SnsUIAction.this.uiX;
              SnsUIAction.this.RCX = false;
            }
            if (paramAnonymousInt1 != 0) {
              break label1242;
            }
            i2 = -((View)localObject).getTop();
            SnsUIAction.this.uiX = i2;
            if ((i2 < 0) || (i2 > n)) {
              break label1100;
            }
            f3 = 1.0F;
            f2 = 1.0F;
            label523:
            if ((i2 < 0) || (i2 > i)) {
              break label1182;
            }
            f1 = 0.0F;
            k = 0;
            paramAnonymousInt3 = 0;
          }
          for (;;)
          {
            if (SnsUIAction.this.maskView != null)
            {
              Log.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(SnsUIAction.this.uiX), Integer.valueOf(j), Integer.valueOf(SnsUIAction.this.mbN) });
              if ((SnsUIAction.this.uiX <= i) && (!SnsUIAction.i(SnsUIAction.this))) {
                break label1255;
              }
              SnsUIAction.this.maskView.setVisibility(8);
            }
            label633:
            SnsUIAction.this.RCR = SnsUIAction.this.uiX;
            SnsUIAction.this.RCW = SnsUIAction.this.RCV;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) {
              break label1269;
            }
            localObject = (SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this);
            label686:
            float f4 = f1;
            float f5 = f3;
            i = paramAnonymousInt3;
            if (localObject != null)
            {
              if (SnsUIAction.i(SnsUIAction.this))
              {
                paramAnonymousInt3 = 100;
                f3 = 1.0F;
                f1 = 1.0F;
              }
              if (SnsUIAction.this.KLB != paramAnonymousInt3)
              {
                if (paramAnonymousInt3 > 0) {
                  break label1297;
                }
                ((MMActivity)localObject).setActionbarColor(SnsUIAction.a(SnsUIAction.this).getResources().getColor(b.c.transparent));
                label761:
                if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
                {
                  if (k == 0) {
                    break label1330;
                  }
                  ((MMActivity)localObject).updateOptionMenuIcon(0, b.i.icons_outlined_camera);
                }
              }
              label788:
              SnsUIAction.c(SnsUIAction.this).lM(paramAnonymousInt1, paramAnonymousInt3);
              if (SnsUIAction.this.RCT != f1) {
                ((MMActivity)localObject).setTitleAlpha(f1);
              }
              f4 = f1;
              f5 = f3;
              i = paramAnonymousInt3;
              if (SnsUIAction.this.RCS != f3)
              {
                ((MMActivity)localObject).setIconAlpha(f3);
                i = paramAnonymousInt3;
                f5 = f3;
                f4 = f1;
              }
            }
            SnsUIAction.this.KLB = i;
            SnsUIAction.this.RCS = f5;
            SnsUIAction.this.RCT = f4;
            SnsUIAction.this.RCU = f2;
            SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
              break;
            }
            i = com.tencent.mm.cd.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 199);
            break;
            label962:
            j = ((View)localObject).getTop();
            break label360;
            label972:
            if (paramAnonymousInt1 < SnsUIAction.g(SnsUIAction.this))
            {
              SnsUIAction.this.RCV = SnsUIAction.ddn();
              if (SnsUIAction.this.mbN < ((View)localObject).getHeight()) {
                break label408;
              }
              localSnsUIAction = SnsUIAction.this;
              localSnsUIAction.mbN -= ((View)localObject).getHeight();
              break label408;
            }
            if (Math.abs(j - SnsUIAction.h(SnsUIAction.this)) <= 1) {
              break label408;
            }
            if (j < SnsUIAction.h(SnsUIAction.this))
            {
              SnsUIAction.this.RCV = SnsUIAction.bPa();
              break label408;
            }
            if (j <= SnsUIAction.h(SnsUIAction.this)) {
              break label408;
            }
            SnsUIAction.this.RCV = SnsUIAction.ddn();
            break label408;
            label1100:
            if (i2 <= i1)
            {
              f3 = 1.0F - (i2 - n) / (i1 - n);
              f2 = 1.0F - (i2 - n) / (i1 - n);
              break label523;
            }
            f1 = f2;
            if (i2 <= i + m) {
              f1 = (i2 - i) * 1.0F / m;
            }
            f2 = 0.0F;
            f3 = f1;
            break label523;
            label1182:
            if (i2 > i + m) {
              break label1222;
            }
            paramAnonymousInt3 = (i2 - i) * 100 / m;
            f1 = (i2 - i) * 1.0F / m;
          }
          label1222:
          if (i2 > i + m) {
            paramAnonymousInt3 = 100;
          }
          for (;;)
          {
            f1 = 1.0F;
            break;
            label1242:
            paramAnonymousInt3 = 100;
            f2 = 0.0F;
            f3 = 1.0F;
            break;
            label1255:
            SnsUIAction.this.maskView.setVisibility(0);
            break label633;
            label1269:
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI))
            {
              localObject = (SnsUserUI)SnsUIAction.a(SnsUIAction.this);
              break label686;
              i = b.c.normal_actionbar_color;
              ((MMActivity)localObject).setActionbarColor(bb.gy(SnsUIAction.a(SnsUIAction.this).getResources().getColor(i), paramAnonymousInt3));
              break label761;
              ((MMActivity)localObject).updateOptionMenuIcon(0, b.i.icons_filled_camera);
              break label788;
            }
            label1297:
            label1330:
            localObject = null;
            break label686;
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(99469);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          SnsUIAction.c(SnsUIAction.this).amk(paramAnonymousInt);
          Object localObject3;
          if (paramAnonymousInt == 0)
          {
            if (((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).RoZ != null)) {
              ((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).RoZ.Ds(true);
            }
            if (SnsUIAction.this.QCY != null)
            {
              localObject1 = SnsUIAction.this.QCY;
              if ((((SnsHeader)localObject1).Rrg != null) && (((SnsHeader)localObject1).Rrg.RrA != null) && (!((SnsHeader)localObject1).Rrq)) {
                ((SnsHeader)localObject1).Rrg.RrA.hsE();
              }
            }
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
            {
              localObject1 = SnsUIAction.this;
              localObject3 = SnsUIAction.this.list;
            }
          }
          for (;;)
          {
            long l1;
            int j;
            int i;
            int m;
            try
            {
              l1 = System.currentTimeMillis();
              if (((SnsUIAction)localObject1).RDa != null) {
                ((SnsUIAction)localObject1).RDa.clear();
              }
              j = -1;
              i = -1;
              int i1 = ((ListView)localObject3).getHeight();
              Object localObject4 = new Rect();
              if (((SnsUIAction)localObject1).actionbarView == null) {
                break label773;
              }
              ((SnsUIAction)localObject1).actionbarView.getGlobalVisibleRect((Rect)localObject4);
              k = ((Rect)localObject4).bottom;
              int i2 = ((ListView)localObject3).getChildCount();
              m = 0;
              if (m < i2)
              {
                Object localObject5 = ((ListView)localObject3).getChildAt(m).getTag();
                if (!(localObject5 instanceof n.a)) {
                  break label770;
                }
                localObject5 = (n.a)localObject5;
                if (!(((n.a)localObject5).RLz instanceof com.tencent.mm.plugin.sns.ui.item.n)) {
                  break label770;
                }
                if (((SnsUIAction)localObject1).RDa == null) {
                  ((SnsUIAction)localObject1).RDa = new ArrayList();
                }
                ((SnsUIAction)localObject1).RDa.add(localObject5);
                ((n.a)localObject5).RNm.getGlobalVisibleRect((Rect)localObject4);
                if (((Rect)localObject4).top < k) {
                  ((Rect)localObject4).top = k;
                }
                if (((Rect)localObject4).top > i1) {
                  ((Rect)localObject4).top = i1;
                }
                if (((Rect)localObject4).bottom < k) {
                  ((Rect)localObject4).bottom = k;
                }
                if (((Rect)localObject4).bottom > i1) {
                  ((Rect)localObject4).bottom = i1;
                }
                int n = Math.abs(((Rect)localObject4).bottom - ((Rect)localObject4).top);
                if (n < j) {
                  break label770;
                }
                i = ((SnsUIAction)localObject1).RDa.size() - 1;
                j = n;
                break label779;
              }
              if ((((SnsUIAction)localObject1).RDa != null) && (((SnsUIAction)localObject1).RDa.size() > 0) && (i >= 0))
              {
                j = 0;
                if (j >= ((SnsUIAction)localObject1).RDa.size()) {
                  break label678;
                }
                localObject3 = (n.a)((SnsUIAction)localObject1).RDa.get(j);
                localObject4 = (com.tencent.mm.plugin.sns.ui.item.n)((n.a)localObject3).RLz;
                if (j == i) {
                  ((com.tencent.mm.plugin.sns.ui.item.n)localObject4).a(((n.a)localObject3).RNm, false);
                } else {
                  ((com.tencent.mm.plugin.sns.ui.item.n)localObject4).a(((n.a)localObject3).RNm, true);
                }
              }
            }
            finally
            {
              Log.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + localObject2.toString());
            }
            SnsUIAction.this.cuV();
            if (SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 1) {
              SnsUIAction.this.hqd();
            }
            if (paramAnonymousInt == 2) {
              SnsUIAction.this.Eo(true);
            }
            for (;;)
            {
              SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, paramAnonymousInt);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V");
              AppMethodBeat.o(99469);
              return;
              label678:
              long l2 = System.currentTimeMillis();
              localObject3 = new StringBuilder("checkSphereImageCompItem cost=").append(l2 - l1).append(", maxVisiableItemIdx=").append(i).append(", size=");
              if (localObject2.RDa != null) {}
              for (i = localObject2.RDa.size();; i = 0)
              {
                Log.d("MicroMsg.SnsActivitySphereImageView", i);
                break;
              }
              SnsUIAction.this.Eo(false);
            }
            label770:
            break label779;
            label773:
            int k = 0;
            continue;
            label779:
            m += 1;
            continue;
            j += 1;
          }
        }
      });
      this.RCD = this.RCL.hpQ();
      this.RCE = new com.tencent.mm.plugin.sns.ui.widget.h(this.RCD.getViewProvider());
      localObject1 = this.RCE;
      if (!this.RCY) {
        break label652;
      }
      localObject2 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      if (!com.tencent.mm.plugin.sns.cover.b.a.hes()) {
        break label652;
      }
      paramBoolean = true;
      ((com.tencent.mm.plugin.sns.ui.widget.h)localObject1).RXw = paramBoolean;
      this.RCE.RXx = this.RCF;
      this.RCD.setScrollConsumer(this.RCE);
      localObject1 = new StringBuilder("pullDownView is null ? ");
      if (this.RCD == null) {
        break label657;
      }
      paramBoolean = true;
      Log.i("MicroMsg.SnsActivity", paramBoolean);
      this.RCD.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean dsq()
        {
          AppMethodBeat.i(307899);
          boolean bool = SnsUIAction.this.dsq();
          AppMethodBeat.o(307899);
          return bool;
        }
      });
      this.RCD.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean dsp()
        {
          AppMethodBeat.i(307855);
          boolean bool = SnsUIAction.this.dsp();
          AppMethodBeat.o(307855);
          return bool;
        }
      });
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localSnsHeader = this.QCY;
      if (!Util.isNullOrNil(this.sWX)) {
        break label662;
      }
      localObject1 = this.Rzk;
      localObject3 = this.Rzk;
      localObject2 = this.qgV;
      str = this.mSignature;
      if ((localObject1 != null) && (localObject3 != null)) {
        break label671;
      }
      Log.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      this.QCY.a(this.RCL.getType(), this);
      this.QCY.setActionBarView(this.RCL.getActionBar());
      localObject2 = al.hgG();
      if (!Util.isNullOrNil(this.sWX)) {
        break label1221;
      }
      localObject1 = this.Rzk;
      label589:
      a(((r)localObject2).aZM((String)localObject1));
      hqf();
      if (Build.VERSION.SDK_INT >= 11) {
        break label1230;
      }
      Log.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      al.hgx().a(this);
      al.hgw().a(this);
      AppMethodBeat.o(308109);
      return;
      bool = false;
      break;
      label647:
      paramBoolean = false;
      break label209;
      label652:
      paramBoolean = false;
      break label365;
      label657:
      paramBoolean = false;
      break label414;
      label662:
      localObject1 = this.sWX;
      break label498;
      label671:
      localSnsHeader.userName = ((String)localObject1).trim();
      localSnsHeader.ltf = ((String)localObject3).trim();
      localSnsHeader.hHq = ((String)localObject3).equals(localObject1);
      localSnsHeader.Rrg.RrG.setPreview(localSnsHeader.Rrt.booleanValue());
      localObject3 = localSnsHeader.Rrg.RrG;
      paramBoolean = localSnsHeader.hHq;
      kotlin.g.b.s.u(localObject1, "userName");
      j localj = j.QFS;
      int i;
      label777:
      label929:
      if (!((SnsCoverContainerLayout)localObject3).QlH.isPreview)
      {
        i = 1;
        label764:
        if (i == 0) {
          break label1148;
        }
        localj.QGN.imW = 1;
        localObject3 = localj.QGN;
        ((no)localObject3).jfs = ((no)localObject3).F("OwnerUsername", (String)localObject1, true);
        Log.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject1).length() + "  " + (String)localObject1);
        localSnsHeader.Rrg.vgb.setText((CharSequence)localObject1);
        if ((localSnsHeader.Rrg != null) && (localSnsHeader.Rrg.lKK != null)) {
          break label1176;
        }
        label870:
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1);
          if ((localObject3 == null) || (Util.isNullOrNil(((au)localObject3).aSV()))) {
            break label1195;
          }
          localObject2 = ((au)localObject3).aSV();
          localSnsHeader.Rrg.vgb.setText(p.b(localSnsHeader.context, (CharSequence)localObject2));
          localSnsHeader.Rrg.RaR.setText(p.b(localSnsHeader.context, str, localSnsHeader.Rrg.RaR.getTextSize()));
          localSnsHeader.maT = au.bwO((String)localObject1);
          if (!localSnsHeader.maT) {
            break label1205;
          }
          localSnsHeader.Rrg.pJK.setVisibility(0);
          localSnsHeader.Rrg.pJK.setText(com.tencent.mm.openim.room.a.a.X((au)localObject3));
        }
      }
      for (;;)
      {
        localSnsHeader.Rrl = false;
        localObject1 = al.hgF().aZW((String)localObject1);
        if ((localSnsHeader.maT) && ((Util.isNullOrNil(((u)localObject1).field_bgUrl)) || (Util.isNullOrNil(((u)localObject1).field_imBGmd5sum)) || (Util.isNullOrNil(((u)localObject1).field_imBGfileid))))
        {
          Log.e("MicroMsg.SnsHeader", "openim bg error, do not show like btn");
          localSnsHeader.Rrl = true;
        }
        localSnsHeader.Rrg.lKK.setContentDescription(localSnsHeader.context.getString(b.j.sns_avatar_desc, new Object[] { localSnsHeader.Rrg.vgb.getText() }));
        break;
        i = 0;
        break label764;
        label1148:
        if (paramBoolean)
        {
          localj.QGN.imW = 2;
          break label777;
        }
        localj.QGN.imW = 3;
        break label777;
        label1176:
        a.b.C(localSnsHeader.Rrg.lKK, localSnsHeader.userName);
        break label870;
        label1195:
        localObject2 = com.tencent.mm.plugin.sns.data.t.aq((CharSequence)localObject2);
        break label929;
        label1205:
        localSnsHeader.Rrg.pJK.setVisibility(8);
      }
      label1221:
      localObject1 = this.sWX;
      break label589;
      label1230:
      new SnsUIAction.5(this).run();
    }
  }
  
  public final void onDestroy()
  {
    boolean bool1 = true;
    AppMethodBeat.i(99486);
    Object localObject1;
    label326:
    int i;
    if ((this.mActivity == null) || (!(this.mActivity instanceof SnsTimeLineUI))) {
      if (this.QCY != null)
      {
        localObject1 = this.QCY;
        if ((((SnsHeader)localObject1).Rrp != null) && (!((SnsHeader)localObject1).Rrp.isRecycled())) {
          ((SnsHeader)localObject1).Rrp.recycle();
        }
        if ((((SnsHeader)localObject1).Rrg != null) && (((SnsHeader)localObject1).Rrg.Rrz != null) && (((SnsHeader)localObject1).Rrq)) {
          ((SnsHeader)localObject1).Rrg.Rrz.onDestroyView();
        }
        Object localObject2;
        if ((((SnsHeader)localObject1).Rrg != null) && (((SnsHeader)localObject1).Rrg.RrA != null) && (!((SnsHeader)localObject1).Rrq))
        {
          localObject2 = ((SnsHeader)localObject1).Rrg.RrA;
          Log.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
          ((SnsStoryHeaderView)localObject2).aUP = true;
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b((l.b)localObject2);
        }
        if ((((SnsHeader)localObject1).Rrg != null) && (((SnsHeader)localObject1).Rrg.RrE != null)) {
          ((SnsHeader)localObject1).Rrg.RrE.release();
        }
        if ((((SnsHeader)localObject1).Rrg != null) && (((SnsHeader)localObject1).Rrg.RrG != null))
        {
          localObject2 = ((SnsHeader)localObject1).Rrg.RrG;
          Log.i("MicroMsg.SnsCoverContainerLayout", "[" + ((SnsCoverContainerLayout)localObject2).hashCode() + "] onDestroy");
          localObject1 = ((SnsCoverContainerLayout)localObject2).QlE;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.sns.cover.a.a)localObject1).onDestroy();
          }
          al.hgG().QYK.QZH.b((androidx.lifecycle.y)localObject2);
          com.tencent.mm.plugin.sns.cover.c.a locala = ((SnsCoverContainerLayout)localObject2).QlQ;
          localObject1 = ((SnsCoverContainerLayout)localObject2).QlO;
          if (localObject1 != null) {
            break label574;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool2 = ((Boolean)localObject1).booleanValue();
            nq localnq = locala.Qml;
            if (localnq != null)
            {
              if (!((Boolean)localObject1).booleanValue()) {
                break label587;
              }
              i = 1;
              label359:
              localnq.jfH = i;
            }
            localObject1 = locala.Qml;
            if (localObject1 != null)
            {
              if (locala.Qmm == bool2) {
                break label592;
              }
              i = 1;
              label388:
              ((nq)localObject1).jfI = i;
            }
          }
          localObject1 = ((SnsCoverContainerLayout)localObject2).QlQ;
          if (((SnsCoverContainerLayout)localObject2).QlH.isPreview) {
            break label597;
          }
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.cover.c.a)localObject1).DB(bool1);
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        al.hgy().bq(this.mActivity);
        al.hgw().b(this);
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        al.hgx().b(this);
      }
      this.RCG.setVisibility(8);
      ai.hmn();
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        al.hgy().start();
      }
      this.list.setAdapter(null);
      com.tencent.mm.plugin.sns.data.t.aXG("");
      AppMethodBeat.o(99486);
      return;
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(null, null, c.e.zHr.state, -1, -1, 1L, "61", 8, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGt);
      break;
      label574:
      localObject1 = Boolean.valueOf(((q)localObject1).field_isLike);
      break label326;
      label587:
      i = 0;
      break label359;
      label592:
      i = 0;
      break label388;
      label597:
      bool1 = false;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(99481);
    Object localObject = new rr();
    ((rr)localObject).hUK.pause = false;
    ((rr)localObject).asyncPublish(Looper.getMainLooper());
    Log.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    if (this.QCY != null)
    {
      localObject = this.QCY;
      if ((((SnsHeader)localObject).Rrg != null) && (((SnsHeader)localObject).Rrg.RrA != null) && (!((SnsHeader)localObject).Rrq))
      {
        SnsStoryHeaderView localSnsStoryHeaderView = ((SnsHeader)localObject).Rrg.RrA;
        localSnsStoryHeaderView.RVl = false;
        localSnsStoryHeaderView.hJi = true;
      }
      if ((((SnsHeader)localObject).Rrg != null) && (((SnsHeader)localObject).Rrg.RrG != null))
      {
        localObject = ((SnsHeader)localObject).Rrg.RrG;
        Log.i("MicroMsg.SnsCoverContainerLayout", "[" + ((SnsCoverContainerLayout)localObject).hashCode() + "] onPause");
        localObject = ((SnsCoverContainerLayout)localObject).QlE;
        if (localObject != null) {
          ((com.tencent.mm.plugin.sns.cover.a.a)localObject).onPause();
        }
      }
      localObject = aNu();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGt = this.QCY.jI(this.actionbarView);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(this.list, (BaseAdapter)localObject, c.e.zHq.state, -1, -1, 1L, "61", 3, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGt);
      }
    }
    AppMethodBeat.o(99481);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(99480);
    al.hgw().bE(2, false);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(7);
    Object localObject = new rr();
    ((rr)localObject).hUK.pause = true;
    ((rr)localObject).asyncPublish(Looper.getMainLooper());
    Log.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    if (this.QCY != null)
    {
      this.QCY.onResume();
      localObject = aNu();
      if (localObject != null)
      {
        boolean bool2 = this.QCY.jI(this.actionbarView);
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGt;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(this.list, (BaseAdapter)localObject, c.e.zHp.state, -1, -1, 1L, "61", 2, bool1);
      }
    }
    AppMethodBeat.o(99480);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(99482);
    this.sessionId = paramString;
    if (this.QCY != null) {
      this.QCY.setSessionId(paramString);
    }
    AppMethodBeat.o(99482);
  }
  
  public final void w(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99497);
    if ((this.RCL.getType() == 1) && (this.list != null) && (this.list.getAdapter() != null) && ((this.list.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.a.c))) {
      ((com.tencent.mm.plugin.sns.ui.a.c)this.list.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(99497);
  }
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void Eo(boolean paramBoolean);
    
    public abstract void a(com.tencent.mm.plugin.sns.data.o paramo);
    
    public abstract void amk(int paramInt);
    
    public abstract void bF(int paramInt, boolean paramBoolean);
    
    public abstract void d(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract View getActionBar();
    
    public abstract View getMaskView();
    
    public abstract ListView getSnsListView();
    
    public abstract int getType();
    
    public abstract void hpO();
    
    public abstract View hpP();
    
    public abstract MMOverScrollView hpQ();
    
    public abstract boolean hpR();
    
    public abstract void hpS();
    
    public abstract void hpT();
    
    public abstract void lM(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction
 * JD-Core Version:    0.7.0.1
 */