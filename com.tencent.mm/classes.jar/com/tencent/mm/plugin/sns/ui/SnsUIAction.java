package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.be.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsUIAction
  implements be.a, c.b
{
  private static int EOK = 0;
  private static int EOL = 1;
  private static int EOM = 2;
  private boolean DEF;
  protected SnsHeader DSh;
  String DTT;
  public int DuA;
  private int ELa;
  private String ELj;
  private boolean ELk;
  private int ELl;
  protected LoadingMoreView EOC;
  private int EOD;
  private int EOE;
  private boolean EOG;
  public int EOH;
  a EOI;
  private Toolbar.LayoutParams EOJ;
  private int EON;
  int EOO;
  float EOP;
  float EOQ;
  float EOR;
  int EOS;
  int EOT;
  int EOU;
  boolean EOV;
  private com.tencent.f.i.b EOW;
  ArrayList<n.a> EOX;
  com.tencent.mm.modelsns.k EOY;
  private com.tencent.mm.plugin.expt.hellhound.a.a.b.c EOZ;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.b.e EPa;
  private boolean EqY;
  boolean EvK;
  View actionbarView;
  protected View cBH;
  protected String filePath;
  int gRE;
  private String krY;
  private int lastIndex;
  protected ListView list;
  private Activity mActivity;
  private String mRa;
  private String mSignature;
  protected View maskView;
  protected boolean qeT;
  private String sessionId;
  int start;
  protected q tipDialog;
  protected String title;
  private ArrayList<SnsInfo> xjs;
  int zlN;
  protected MMPullDownView zog;
  
  public SnsUIAction(Activity paramActivity)
  {
    AppMethodBeat.i(176361);
    this.tipDialog = null;
    this.EOD = 0;
    this.EOE = 0;
    this.EOG = false;
    this.qeT = false;
    this.DEF = false;
    this.DuA = 0;
    this.EOH = 0;
    this.EOO = 0;
    this.zlN = 0;
    this.EOP = 1.0F;
    this.EOQ = 1.0F;
    this.EOR = 1.0F;
    this.EOS = EOK;
    this.EOT = EOK;
    this.EOU = 0;
    this.start = 0;
    this.gRE = 0;
    this.EOV = false;
    this.ELa = 800;
    this.EvK = false;
    this.xjs = new ArrayList();
    this.EOW = new com.tencent.f.i.b()
    {
      public final String getKey()
      {
        return "SnsUIAction#preloadRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(99475);
        Object localObject2 = com.tencent.mm.plugin.sns.model.aj.faM();
        synchronized (((az)localObject2).DOk)
        {
          ((az)localObject2).DOk.clear();
          ??? = new ArrayList(SnsUIAction.k(SnsUIAction.this)).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (SnsInfo)((Iterator)???).next();
            com.tencent.mm.plugin.sns.model.aj.faM().H((SnsInfo)localObject2);
          }
        }
        AppMethodBeat.o(99475);
      }
    };
    this.EOX = null;
    this.EOY = null;
    this.EPa = new com.tencent.mm.plugin.expt.hellhound.a.a.b.e()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(203750);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(203750);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(203750);
          return;
        }
        BaseAdapter localBaseAdapter = SnsUIAction.l(SnsUIAction.this);
        if (localBaseAdapter == null)
        {
          AppMethodBeat.o(203750);
          return;
        }
        SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, localBaseAdapter, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(203750);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(203751);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(203751);
          return;
        }
        paramAnonymousAbsListView = SnsUIAction.l(SnsUIAction.this);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(203751);
          return;
        }
        SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.getSnsListView(), paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(203751);
      }
    };
    this.mActivity = paramActivity;
    AppMethodBeat.o(176361);
  }
  
  private BaseAdapter anl()
  {
    if ((this.mActivity == null) || (this.DSh == null) || (this.actionbarView == null)) {}
    while (!(this.mActivity instanceof SnsTimeLineUI)) {
      return null;
    }
    return ((SnsTimeLineUI)this.mActivity).EKT;
  }
  
  private void ba(Intent paramIntent)
  {
    AppMethodBeat.i(99484);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176355);
        com.tencent.mm.plugin.sns.c.a.jRu.Xb();
        AppMethodBeat.o(176355);
      }
    });
    Log.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    Log.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null)
    {
      AppMethodBeat.o(99484);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.aLH(this.filePath);
    localObject = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.plugin.sns.storage.r.aR(com.tencent.mm.plugin.sns.model.aj.getAccSnsTmpPath(), this.filePath, (String)localObject);
    com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.aLF(this.filePath);
    this.filePath = (com.tencent.mm.plugin.sns.model.aj.getAccSnsTmpPath() + (String)localObject);
    Log.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", Util.nowSecond());
      if (this.EOY != null)
      {
        this.EOY.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.EOY = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.DEF) {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
      }
      if (this.EqY) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      this.mActivity.startActivityForResult((Intent)localObject, 6);
      this.DEF = false;
      AppMethodBeat.o(99484);
      return;
    }
  }
  
  protected final boolean ZX(int paramInt)
  {
    int j = 3;
    boolean bool1 = false;
    AppMethodBeat.i(99485);
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      u.g(this.mActivity, null);
      AppMethodBeat.o(99485);
      return false;
    }
    Log.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(paramInt)));
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("username", this.ELj);
      localIntent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
      this.mActivity.startActivityForResult(localIntent, 7);
      AppMethodBeat.o(99485);
      return true;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.kernel.g.aAi();
      i = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(68385, null), 0);
      com.tencent.mm.kernel.g.aAi();
      int k = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(68386, null), 0);
      if ((!this.EOG) && (i < 3) && (k == 0))
      {
        this.EOG = true;
        bn.g(this.mActivity, new SnsUIAction.5(this, paramInt));
        AppMethodBeat.o(99485);
        return true;
      }
      if (this.mActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
        s.c(this.mActivity, 2, null);
      }
    }
    else
    {
      AppMethodBeat.o(99485);
      return true;
    }
    int i = com.tencent.mm.n.h.aqJ().getInt("SnsCanPickVideoFromAlbum", 1);
    Log.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(i) });
    if (ac.jPB) {
      i = 0;
    }
    if (i == 1)
    {
      paramInt = j;
      label312:
      localIntent = new Intent();
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZB, false);
      if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0) != 1) && (!bool2)) {
        break label451;
      }
      i = 1;
      label365:
      if (i == 0) {
        bool1 = true;
      }
      localIntent.putExtra("key_can_select_video_and_pic", bool1);
      localIntent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
      if (!(this.mActivity instanceof SnsUserUI)) {
        break label456;
      }
      localIntent.putExtra("gallery_report_tag", 17);
    }
    for (;;)
    {
      s.a(this.mActivity, 14, 9, 4, paramInt, localIntent);
      break;
      paramInt = j;
      if (i != 0) {
        break label312;
      }
      paramInt = 1;
      break label312;
      label451:
      i = 0;
      break label365;
      label456:
      localIntent.putExtra("gallery_report_tag", 4);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.ELj = paramString1;
    this.mRa = paramString2;
    this.krY = paramString3;
    this.mSignature = paramString4;
    this.ELk = paramBoolean1;
    this.EqY = paramBoolean2;
    this.ELl = paramInt;
  }
  
  public final void aOG(String paramString) {}
  
  public final void aP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99495);
    this.EOI.aP(paramInt, paramBoolean);
    AppMethodBeat.o(99495);
  }
  
  protected final void aQU(String paramString)
  {
    AppMethodBeat.i(99490);
    Log.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.EOC.aQU(paramString);
    AppMethodBeat.o(99490);
  }
  
  protected final void aRh(String paramString)
  {
    AppMethodBeat.i(99488);
    Log.d("MicroMsg.SnsActivity", "snsactivty onIsDownAll ");
    this.EOC.aQU(paramString);
    AppMethodBeat.o(99488);
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(99478);
    this.EOW.cancel();
    this.xjs.clear();
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
        if (((localObject instanceof SnsInfo)) && (((SnsInfo)localObject).getTypeFlag() == 15) && ((!((SnsInfo)localObject).isAd()) || (com.tencent.mm.plugin.sns.ad.timeline.b.a.n((SnsInfo)localObject)))) {
          this.xjs.add((SnsInfo)localObject);
        }
        i += 1;
      }
      else
      {
        com.tencent.f.h.RTc.aX(this.EOW);
        AppMethodBeat.o(99478);
        return;
      }
    }
  }
  
  public final void ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99497);
    if ((this.EOI.getType() == 1) && (this.list != null) && (this.list.getAdapter() != null) && ((this.list.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.a.c))) {
      ((com.tencent.mm.plugin.sns.ui.a.c)this.list.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(99497);
  }
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public final void eZJ()
  {
    AppMethodBeat.i(99487);
    this.DSh.fid();
    AppMethodBeat.o(99487);
  }
  
  public final void fbl()
  {
    AppMethodBeat.i(99496);
    if (this.DSh != null) {
      this.DSh.fid();
    }
    AppMethodBeat.o(99496);
  }
  
  public final void fjA()
  {
    AppMethodBeat.i(203752);
    if (this.DSh != null)
    {
      SnsHeader localSnsHeader = this.DSh;
      if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDT != null) && (localSnsHeader.ErS != null))
      {
        localSnsHeader.ErS.cancel();
        localSnsHeader.ErS.reset();
        localSnsHeader.EDy.EDT.startAnimation(localSnsHeader.ErS);
      }
    }
    AppMethodBeat.o(203752);
  }
  
  public final void fjB()
  {
    AppMethodBeat.i(203753);
    if (this.EOC != null)
    {
      LoadingMoreView localLoadingMoreView = this.EOC;
      localLoadingMoreView.ErS.cancel();
      localLoadingMoreView.ErS.reset();
      localLoadingMoreView.dPk.startAnimation(localLoadingMoreView.ErS);
    }
    AppMethodBeat.o(203753);
  }
  
  protected final void fjw()
  {
    AppMethodBeat.i(160742);
    this.EOC.PL();
    AppMethodBeat.o(160742);
  }
  
  public final void fjx()
  {
    AppMethodBeat.i(99491);
    if ((this.EOI != null) && (this.EOI.getType() == 2)) {
      com.tencent.mm.plugin.sns.model.aj.eJP().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99466);
          Object localObject2 = com.tencent.mm.plugin.sns.model.aj.faS().aQs(SnsUIAction.d(SnsUIAction.this));
          final com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m();
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
              ebo localebo = (ebo)localIterator.next();
              localObject2 = String.valueOf(localebo.Nbm);
              str = String.valueOf(localebo.Nbn);
              l = localebo.Nbo;
              if (Util.isEqual((String)localObject1, (String)localObject2)) {
                break label281;
              }
              localArrayList = new ArrayList();
              localHashMap = new HashMap();
              localm.DEq.add(localObject2);
              localm.DEr.add(localArrayList);
              localm.map.put(localObject2, localHashMap);
              localObject1 = localObject2;
            }
          }
          label281:
          for (;;)
          {
            localArrayList.add(str);
            localHashMap.put(str, Long.valueOf(l));
            break;
            Collections.reverse(localm.DEq);
            Collections.reverse(localm.DEr);
            localObject1 = localm.DEr.iterator();
            while (((Iterator)localObject1).hasNext()) {
              Collections.reverse((List)((Iterator)localObject1).next());
            }
            com.tencent.mm.plugin.sns.model.aj.dRd().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176357);
                SnsUIAction.c(SnsUIAction.this).a(localm);
                AppMethodBeat.o(176357);
              }
            });
            AppMethodBeat.o(99466);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(99491);
  }
  
  public final void fjy()
  {
    AppMethodBeat.i(99493);
    if (getSnsListView() != null) {
      getSnsListView().setVisibility(8);
    }
    AppMethodBeat.o(99493);
  }
  
  public final void fjz()
  {
    AppMethodBeat.i(99494);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V", this);
    if (this.DSh != null)
    {
      SnsHeader localSnsHeader = this.DSh;
      if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDP != null) && (localSnsHeader.EDF)) {
        localSnsHeader.EDy.EDP.fjz();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V");
    AppMethodBeat.o(99494);
  }
  
  public final int getHeaderHeight()
  {
    AppMethodBeat.i(179311);
    if (this.DSh != null)
    {
      int i = this.DSh.getMeasuredHeight();
      AppMethodBeat.o(179311);
      return i;
    }
    AppMethodBeat.o(179311);
    return 0;
  }
  
  public ListView getSnsListView()
  {
    AppMethodBeat.i(99498);
    ListView localListView = this.EOI.getSnsListView();
    AppMethodBeat.o(99498);
    return localListView;
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 880
    //   3: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 291
    //   9: ldc_w 882
    //   12: iload_1
    //   13: invokestatic 530	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   16: invokevirtual 533	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 884	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +50 -> 74
    //   27: iload_1
    //   28: iconst_5
    //   29: if_icmpeq +13 -> 42
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +8 -> 42
    //   37: iload_1
    //   38: iconst_4
    //   39: if_icmpne +25 -> 64
    //   42: new 275	com/tencent/mm/sdk/platformtools/MMHandler
    //   45: dup
    //   46: invokestatic 281	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   49: invokespecial 284	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Landroid/os/Looper;)V
    //   52: new 24	com/tencent/mm/plugin/sns/ui/SnsUIAction$16
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 885	com/tencent/mm/plugin/sns/ui/SnsUIAction$16:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   60: invokevirtual 289	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   63: pop
    //   64: invokestatic 890	com/tencent/mm/plugin/sns/data/r:eZy	()V
    //   67: ldc_w 880
    //   70: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    //   74: iload_1
    //   75: tableswitch	default:+77 -> 152, 2:+515->590, 3:+77->152, 4:+1586->1661, 5:+393->468, 6:+1620->1695, 7:+1674->1749, 8:+1703->1778, 9:+1763->1838, 10:+1863->1938, 11:+77->152, 12:+2033->2108, 13:+2093->2168, 14:+646->721, 15:+2107->2182, 16:+77->152, 17:+93->168
    //   153: aconst_null
    //   154: fload_1
    //   155: ldc_w 892
    //   158: invokestatic 894	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: ldc_w 880
    //   164: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: aload_3
    //   169: ldc_w 896
    //   172: invokevirtual 900	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   175: checkcast 902	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +2007 -> 2189
    //   185: aload 5
    //   187: getfield 905	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsy	Z
    //   190: ifeq +39 -> 229
    //   193: aload_0
    //   194: aload 5
    //   196: getfield 908	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsG	Ljava/lang/String;
    //   199: putfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   206: invokestatic 911	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   209: ifne +1980 -> 2189
    //   212: aload_0
    //   213: iconst_1
    //   214: putfield 150	com/tencent/mm/plugin/sns/ui/SnsUIAction:DEF	Z
    //   217: aload_0
    //   218: aload_3
    //   219: invokespecial 913	com/tencent/mm/plugin/sns/ui/SnsUIAction:ba	(Landroid/content/Intent;)V
    //   222: ldc_w 880
    //   225: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: ldc_w 291
    //   232: ldc_w 915
    //   235: iconst_2
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 5
    //   243: getfield 918	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload 5
    //   251: getfield 921	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsB	Ljava/lang/String;
    //   254: aastore
    //   255: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: new 369	android/content/Intent
    //   261: dup
    //   262: invokespecial 534	android/content/Intent:<init>	()V
    //   265: astore 4
    //   267: aload 4
    //   269: ldc_w 923
    //   272: aload 5
    //   274: getfield 918	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   277: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   280: pop
    //   281: aload 4
    //   283: ldc_w 925
    //   286: aload 5
    //   288: getfield 921	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsB	Ljava/lang/String;
    //   291: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   294: pop
    //   295: aload 5
    //   297: getfield 928	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   300: invokestatic 911	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   303: ifne +121 -> 424
    //   306: aload 4
    //   308: ldc_w 930
    //   311: aload 5
    //   313: getfield 928	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsD	Ljava/lang/String;
    //   316: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   319: pop
    //   320: aload 4
    //   322: ldc_w 380
    //   325: iconst_1
    //   326: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   329: pop
    //   330: aload 4
    //   332: ldc_w 386
    //   335: invokestatic 391	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   338: invokevirtual 394	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   341: pop
    //   342: aload 4
    //   344: ldc_w 932
    //   347: bipush 14
    //   349: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   352: pop
    //   353: aload 4
    //   355: ldc_w 413
    //   358: iconst_0
    //   359: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   362: pop
    //   363: aload 4
    //   365: ldc_w 417
    //   368: aload_3
    //   369: ldc_w 417
    //   372: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   375: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   378: pop
    //   379: aload 5
    //   381: getfield 936	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsF	Lcom/tencent/mm/protocal/protobuf/cly;
    //   384: invokevirtual 941	com/tencent/mm/protocal/protobuf/cly:toByteArray	()[B
    //   387: astore_3
    //   388: aload_3
    //   389: ifnull +13 -> 402
    //   392: aload 4
    //   394: ldc_w 943
    //   397: aload_3
    //   398: invokevirtual 946	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   401: pop
    //   402: aload_0
    //   403: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   406: ldc_w 948
    //   409: ldc_w 950
    //   412: aload 4
    //   414: invokestatic 955	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   417: ldc_w 880
    //   420: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    //   424: aload 4
    //   426: ldc_w 930
    //   429: aload 5
    //   431: getfield 918	com/tencent/mm/plugin/mmsight/SightCaptureResult:zsA	Ljava/lang/String;
    //   434: invokestatic 960	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   437: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   440: pop
    //   441: goto -121 -> 320
    //   444: astore_3
    //   445: ldc_w 291
    //   448: ldc_w 962
    //   451: iconst_1
    //   452: anewarray 4	java/lang/Object
    //   455: dup
    //   456: iconst_0
    //   457: aload_3
    //   458: invokevirtual 965	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   461: aastore
    //   462: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: goto -63 -> 402
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   473: invokevirtual 969	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   476: aload_3
    //   477: invokestatic 354	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   480: invokestatic 972	com/tencent/mm/pluginsdk/ui/tools/s:h	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   483: putfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   486: ldc_w 291
    //   489: new 301	java/lang/StringBuilder
    //   492: dup
    //   493: ldc_w 974
    //   496: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: aload_0
    //   500: getfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   503: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   516: ifnonnull +10 -> 526
    //   519: ldc_w 880
    //   522: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: return
    //   526: invokestatic 511	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   529: pop
    //   530: invokestatic 515	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   533: invokevirtual 548	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   536: ldc_w 975
    //   539: aconst_null
    //   540: invokevirtual 555	com/tencent/mm/storage/ao:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 557	java/lang/Integer
    //   546: iconst_0
    //   547: invokestatic 561	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   550: istore_1
    //   551: invokestatic 511	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   554: pop
    //   555: invokestatic 515	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   558: invokevirtual 548	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   561: ldc_w 975
    //   564: iload_1
    //   565: iconst_1
    //   566: iadd
    //   567: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: invokevirtual 979	com/tencent/mm/storage/ao:set	(ILjava/lang/Object;)V
    //   573: aload_0
    //   574: iconst_1
    //   575: putfield 150	com/tencent/mm/plugin/sns/ui/SnsUIAction:DEF	Z
    //   578: aload_0
    //   579: aload_3
    //   580: invokespecial 913	com/tencent/mm/plugin/sns/ui/SnsUIAction:ba	(Landroid/content/Intent;)V
    //   583: ldc_w 880
    //   586: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   589: return
    //   590: aload_3
    //   591: ifnonnull +10 -> 601
    //   594: ldc_w 880
    //   597: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: return
    //   601: invokestatic 511	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   604: pop
    //   605: invokestatic 515	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   608: invokevirtual 548	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   611: ldc_w 980
    //   614: aconst_null
    //   615: invokevirtual 555	com/tencent/mm/storage/ao:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   618: checkcast 557	java/lang/Integer
    //   621: iconst_0
    //   622: invokestatic 561	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   625: istore_1
    //   626: invokestatic 511	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   629: pop
    //   630: invokestatic 515	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   633: invokevirtual 548	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   636: ldc_w 980
    //   639: iload_1
    //   640: iconst_1
    //   641: iadd
    //   642: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokevirtual 979	com/tencent/mm/storage/ao:set	(ILjava/lang/Object;)V
    //   648: new 369	android/content/Intent
    //   651: dup
    //   652: invokespecial 534	android/content/Intent:<init>	()V
    //   655: astore 4
    //   657: aload 4
    //   659: ldc_w 982
    //   662: iconst_4
    //   663: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   666: pop
    //   667: aload 4
    //   669: ldc_w 984
    //   672: iconst_1
    //   673: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   676: pop
    //   677: aload 4
    //   679: ldc_w 986
    //   682: iconst_1
    //   683: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   686: pop
    //   687: getstatic 992	com/tencent/mm/plugin/sns/c/a:jRt	Lcom/tencent/mm/pluginsdk/m;
    //   690: aload_0
    //   691: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   694: aload_3
    //   695: aload 4
    //   697: invokestatic 354	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   700: iconst_4
    //   701: new 26	com/tencent/mm/plugin/sns/ui/SnsUIAction$2
    //   704: dup
    //   705: aload_0
    //   706: invokespecial 993	com/tencent/mm/plugin/sns/ui/SnsUIAction$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   709: invokeinterface 998 7 0
    //   714: ldc_w 880
    //   717: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   720: return
    //   721: new 275	com/tencent/mm/sdk/platformtools/MMHandler
    //   724: dup
    //   725: invokestatic 281	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   728: invokespecial 284	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Landroid/os/Looper;)V
    //   731: new 28	com/tencent/mm/plugin/sns/ui/SnsUIAction$3
    //   734: dup
    //   735: aload_0
    //   736: invokespecial 999	com/tencent/mm/plugin/sns/ui/SnsUIAction$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   739: invokevirtual 289	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   742: pop
    //   743: aload_3
    //   744: ldc_w 1001
    //   747: invokevirtual 1005	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   750: astore 4
    //   752: aload_3
    //   753: ldc_w 1007
    //   756: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   759: invokestatic 1010	com/tencent/mm/plugin/sns/data/r:aOz	(Ljava/lang/String;)V
    //   762: aload 4
    //   764: ifnull +11 -> 775
    //   767: aload 4
    //   769: invokevirtual 1013	java/util/ArrayList:size	()I
    //   772: ifgt +16 -> 788
    //   775: aload_3
    //   776: ldc_w 1015
    //   779: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   782: invokestatic 911	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   785: ifne +446 -> 1231
    //   788: aload 4
    //   790: ifnull +125 -> 915
    //   793: aload 4
    //   795: invokevirtual 1013	java/util/ArrayList:size	()I
    //   798: ifle +117 -> 915
    //   801: aload 4
    //   803: iconst_0
    //   804: invokevirtual 1017	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   807: checkcast 339	java/lang/String
    //   810: astore 4
    //   812: aload_3
    //   813: ldc_w 1019
    //   816: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   819: astore 5
    //   821: aload 5
    //   823: invokestatic 911	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   826: ifne +14 -> 840
    //   829: aload 5
    //   831: astore_3
    //   832: aload 5
    //   834: invokestatic 1022	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   837: ifne +192 -> 1029
    //   840: new 301	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   847: invokestatic 354	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   850: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload 4
    //   855: invokestatic 960	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   858: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: astore_3
    //   865: new 1024	com/tencent/mm/compatible/i/d
    //   868: dup
    //   869: invokespecial 1025	com/tencent/mm/compatible/i/d:<init>	()V
    //   872: astore 5
    //   874: aload 5
    //   876: aload 4
    //   878: invokevirtual 1030	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   881: aload 5
    //   883: lconst_0
    //   884: invokevirtual 1034	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   887: astore 6
    //   889: aload 6
    //   891: ifnonnull +44 -> 935
    //   894: ldc_w 291
    //   897: ldc_w 1036
    //   900: invokestatic 894	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload 5
    //   905: invokevirtual 1039	android/media/MediaMetadataRetriever:release	()V
    //   908: ldc_w 880
    //   911: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   914: return
    //   915: aload_3
    //   916: ldc_w 1015
    //   919: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   922: astore 4
    //   924: goto -112 -> 812
    //   927: astore_3
    //   928: ldc_w 880
    //   931: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   934: return
    //   935: ldc_w 291
    //   938: ldc_w 1041
    //   941: iconst_2
    //   942: anewarray 4	java/lang/Object
    //   945: dup
    //   946: iconst_0
    //   947: aload 6
    //   949: invokevirtual 1046	android/graphics/Bitmap:getWidth	()I
    //   952: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   955: aastore
    //   956: dup
    //   957: iconst_1
    //   958: aload 6
    //   960: invokevirtual 1049	android/graphics/Bitmap:getHeight	()I
    //   963: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   966: aastore
    //   967: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: aload 6
    //   972: bipush 80
    //   974: getstatic 1055	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   977: aload_3
    //   978: iconst_1
    //   979: invokestatic 1061	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   982: pop
    //   983: aload_3
    //   984: invokestatic 1065	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   987: astore 6
    //   989: ldc_w 291
    //   992: ldc_w 1067
    //   995: iconst_2
    //   996: anewarray 4	java/lang/Object
    //   999: dup
    //   1000: iconst_0
    //   1001: aload 6
    //   1003: getfield 1072	android/graphics/BitmapFactory$Options:outWidth	I
    //   1006: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1009: aastore
    //   1010: dup
    //   1011: iconst_1
    //   1012: aload 6
    //   1014: getfield 1075	android/graphics/BitmapFactory$Options:outHeight	I
    //   1017: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1020: aastore
    //   1021: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1024: aload 5
    //   1026: invokevirtual 1039	android/media/MediaMetadataRetriever:release	()V
    //   1029: ldc_w 291
    //   1032: ldc_w 1077
    //   1035: iconst_4
    //   1036: anewarray 4	java/lang/Object
    //   1039: dup
    //   1040: iconst_0
    //   1041: aload 4
    //   1043: aastore
    //   1044: dup
    //   1045: iconst_1
    //   1046: aload_3
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_2
    //   1050: aload 4
    //   1052: invokestatic 1081	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   1055: invokestatic 1086	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_3
    //   1061: aload_3
    //   1062: invokestatic 1081	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   1065: invokestatic 1086	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1068: aastore
    //   1069: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1072: new 369	android/content/Intent
    //   1075: dup
    //   1076: invokespecial 534	android/content/Intent:<init>	()V
    //   1079: astore 5
    //   1081: aload 5
    //   1083: ldc_w 923
    //   1086: aload 4
    //   1088: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1091: pop
    //   1092: aload 5
    //   1094: ldc_w 925
    //   1097: aload_3
    //   1098: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1101: pop
    //   1102: aload 5
    //   1104: ldc_w 930
    //   1107: aload 4
    //   1109: invokestatic 960	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   1112: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1115: pop
    //   1116: aload 5
    //   1118: ldc_w 380
    //   1121: iconst_1
    //   1122: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1125: pop
    //   1126: aload 5
    //   1128: ldc_w 386
    //   1131: invokestatic 391	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1134: invokevirtual 394	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1137: pop
    //   1138: aload 5
    //   1140: ldc_w 932
    //   1143: bipush 14
    //   1145: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1148: pop
    //   1149: aload 5
    //   1151: ldc_w 413
    //   1154: iconst_0
    //   1155: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1158: pop
    //   1159: aload_0
    //   1160: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1163: ldc_w 948
    //   1166: ldc_w 950
    //   1169: aload 5
    //   1171: invokestatic 955	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1174: ldc_w 880
    //   1177: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1180: return
    //   1181: astore 6
    //   1183: ldc_w 291
    //   1186: ldc_w 1088
    //   1189: iconst_1
    //   1190: anewarray 4	java/lang/Object
    //   1193: dup
    //   1194: iconst_0
    //   1195: aload 6
    //   1197: invokevirtual 965	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1200: aastore
    //   1201: invokestatic 1090	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1204: aload 5
    //   1206: invokevirtual 1039	android/media/MediaMetadataRetriever:release	()V
    //   1209: goto -180 -> 1029
    //   1212: astore 5
    //   1214: goto -185 -> 1029
    //   1217: astore_3
    //   1218: aload 5
    //   1220: invokevirtual 1039	android/media/MediaMetadataRetriever:release	()V
    //   1223: ldc_w 880
    //   1226: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1229: aload_3
    //   1230: athrow
    //   1231: aload_3
    //   1232: ldc_w 1092
    //   1235: invokevirtual 1096	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1238: ifnull +90 -> 1328
    //   1241: ldc_w 291
    //   1244: ldc_w 1098
    //   1247: invokestatic 884	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1250: new 369	android/content/Intent
    //   1253: dup
    //   1254: invokespecial 534	android/content/Intent:<init>	()V
    //   1257: astore 4
    //   1259: aload 4
    //   1261: ldc_w 413
    //   1264: iconst_0
    //   1265: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload 4
    //   1271: ldc_w 380
    //   1274: iconst_1
    //   1275: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1278: pop
    //   1279: aload 4
    //   1281: ldc_w 932
    //   1284: bipush 14
    //   1286: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1289: pop
    //   1290: aload 4
    //   1292: ldc_w 1092
    //   1295: aload_3
    //   1296: ldc_w 1092
    //   1299: invokevirtual 1096	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1302: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   1305: pop
    //   1306: aload_0
    //   1307: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1310: ldc_w 948
    //   1313: ldc_w 950
    //   1316: aload 4
    //   1318: invokestatic 955	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1321: ldc_w 880
    //   1324: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1327: return
    //   1328: aload_3
    //   1329: ldc_w 1103
    //   1332: invokevirtual 1005	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1335: astore 4
    //   1337: aload 4
    //   1339: ifnull +11 -> 1350
    //   1342: aload 4
    //   1344: invokevirtual 1013	java/util/ArrayList:size	()I
    //   1347: ifne +19 -> 1366
    //   1350: ldc_w 291
    //   1353: ldc_w 1105
    //   1356: invokestatic 884	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1359: ldc_w 880
    //   1362: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1365: return
    //   1366: new 182	java/util/ArrayList
    //   1369: dup
    //   1370: invokespecial 183	java/util/ArrayList:<init>	()V
    //   1373: astore 5
    //   1375: aload 4
    //   1377: invokevirtual 1109	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1380: astore 6
    //   1382: aload 6
    //   1384: invokeinterface 1114 1 0
    //   1389: ifeq +76 -> 1465
    //   1392: aload 6
    //   1394: invokeinterface 1118 1 0
    //   1399: checkcast 339	java/lang/String
    //   1402: astore 7
    //   1404: aload 7
    //   1406: invokestatic 1124	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1409: invokevirtual 1128	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1412: astore 8
    //   1414: aload 8
    //   1416: ifnull -34 -> 1382
    //   1419: aload 5
    //   1421: ldc_w 1130
    //   1424: iconst_3
    //   1425: anewarray 4	java/lang/Object
    //   1428: dup
    //   1429: iconst_0
    //   1430: aload 7
    //   1432: aastore
    //   1433: dup
    //   1434: iconst_1
    //   1435: aload 8
    //   1437: getfield 1136	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1440: invokestatic 1141	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1443: aastore
    //   1444: dup
    //   1445: iconst_2
    //   1446: aload 8
    //   1448: getfield 1144	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1451: invokestatic 1141	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1454: aastore
    //   1455: invokestatic 1148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1458: invokevirtual 752	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1461: pop
    //   1462: goto -80 -> 1382
    //   1465: aload_0
    //   1466: aload_3
    //   1467: ldc_w 1150
    //   1470: iconst_0
    //   1471: invokevirtual 1154	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1474: putfield 150	com/tencent/mm/plugin/sns/ui/SnsUIAction:DEF	Z
    //   1477: new 369	android/content/Intent
    //   1480: dup
    //   1481: aload_0
    //   1482: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1485: ldc_w 375
    //   1488: invokespecial 378	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1491: astore 6
    //   1493: aload 6
    //   1495: ldc_w 380
    //   1498: iconst_1
    //   1499: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1502: pop
    //   1503: aload 6
    //   1505: ldc_w 386
    //   1508: invokestatic 391	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1511: invokevirtual 394	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1514: pop
    //   1515: aload_0
    //   1516: getfield 194	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOY	Lcom/tencent/mm/modelsns/k;
    //   1519: ifnull +20 -> 1539
    //   1522: aload_0
    //   1523: getfield 194	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOY	Lcom/tencent/mm/modelsns/k;
    //   1526: aload 6
    //   1528: ldc_w 396
    //   1531: invokevirtual 401	com/tencent/mm/modelsns/k:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1534: aload_0
    //   1535: aconst_null
    //   1536: putfield 194	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOY	Lcom/tencent/mm/modelsns/k;
    //   1539: aload_0
    //   1540: getfield 270	com/tencent/mm/plugin/sns/ui/SnsUIAction:EqY	Z
    //   1543: ifeq +14 -> 1557
    //   1546: aload 6
    //   1548: ldc_w 415
    //   1551: bipush 11
    //   1553: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1556: pop
    //   1557: aload_3
    //   1558: ldc_w 367
    //   1561: iconst_0
    //   1562: invokevirtual 373	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1565: istore_1
    //   1566: aload 6
    //   1568: ldc_w 1156
    //   1571: aload 4
    //   1573: invokevirtual 1159	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1576: pop
    //   1577: aload 6
    //   1579: ldc_w 408
    //   1582: iload_1
    //   1583: invokevirtual 411	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1586: pop
    //   1587: aload_0
    //   1588: getfield 150	com/tencent/mm/plugin/sns/ui/SnsUIAction:DEF	Z
    //   1591: ifeq +13 -> 1604
    //   1594: aload 6
    //   1596: ldc_w 413
    //   1599: iconst_1
    //   1600: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1603: pop
    //   1604: aload 6
    //   1606: ldc_w 1161
    //   1609: aload 5
    //   1611: invokevirtual 1165	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1614: pop
    //   1615: ldc_w 291
    //   1618: ldc_w 1167
    //   1621: iconst_1
    //   1622: anewarray 4	java/lang/Object
    //   1625: dup
    //   1626: iconst_0
    //   1627: aload 6
    //   1629: ldc_w 932
    //   1632: iconst_m1
    //   1633: invokevirtual 373	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1636: invokestatic 620	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1639: aastore
    //   1640: invokestatic 1169	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1643: aload_0
    //   1644: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1647: aload 6
    //   1649: bipush 6
    //   1651: invokevirtual 427	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1654: ldc_w 880
    //   1657: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1660: return
    //   1661: aload_3
    //   1662: ifnonnull +10 -> 1672
    //   1665: ldc_w 880
    //   1668: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1671: return
    //   1672: aload_0
    //   1673: aload_3
    //   1674: ldc_w 1171
    //   1677: invokevirtual 421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1680: putfield 308	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   1683: aload_0
    //   1684: aload_3
    //   1685: invokespecial 913	com/tencent/mm/plugin/sns/ui/SnsUIAction:ba	(Landroid/content/Intent;)V
    //   1688: ldc_w 880
    //   1691: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1694: return
    //   1695: ldc_w 291
    //   1698: ldc_w 1173
    //   1701: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1704: aload_3
    //   1705: ifnonnull +10 -> 1715
    //   1708: ldc_w 880
    //   1711: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1714: return
    //   1715: aload_3
    //   1716: ldc_w 1175
    //   1719: iconst_m1
    //   1720: invokevirtual 373	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1723: istore_1
    //   1724: aload_0
    //   1725: getfield 436	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOI	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1728: iload_1
    //   1729: aconst_null
    //   1730: aconst_null
    //   1731: invokeinterface 1178 4 0
    //   1736: invokestatic 1182	com/tencent/mm/plugin/sns/model/aj:faK	()Lcom/tencent/mm/plugin/sns/model/be;
    //   1739: invokevirtual 1187	com/tencent/mm/plugin/sns/model/be:eZn	()V
    //   1742: ldc_w 880
    //   1745: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1748: return
    //   1749: ldc_w 291
    //   1752: ldc_w 1189
    //   1755: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1758: aload_0
    //   1759: getfield 222	com/tencent/mm/plugin/sns/ui/SnsUIAction:DSh	Lcom/tencent/mm/plugin/sns/ui/SnsHeader;
    //   1762: invokevirtual 785	com/tencent/mm/plugin/sns/ui/SnsHeader:fid	()V
    //   1765: invokestatic 1182	com/tencent/mm/plugin/sns/model/aj:faK	()Lcom/tencent/mm/plugin/sns/model/be;
    //   1768: invokevirtual 1187	com/tencent/mm/plugin/sns/model/be:eZn	()V
    //   1771: ldc_w 880
    //   1774: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1777: return
    //   1778: aload_3
    //   1779: ifnonnull +10 -> 1789
    //   1782: ldc_w 880
    //   1785: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1788: return
    //   1789: ldc_w 291
    //   1792: ldc_w 1191
    //   1795: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1798: aload_3
    //   1799: ldc_w 1193
    //   1802: invokevirtual 900	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1805: checkcast 1195	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1808: astore_3
    //   1809: aload_3
    //   1810: ifnull +379 -> 2189
    //   1813: aload_0
    //   1814: getfield 436	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOI	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1817: iconst_m1
    //   1818: aload_3
    //   1819: getfield 1199	com/tencent/mm/plugin/sns/data/SnsCmdList:DEl	Ljava/util/List;
    //   1822: aload_3
    //   1823: getfield 1202	com/tencent/mm/plugin/sns/data/SnsCmdList:DEm	Ljava/util/List;
    //   1826: invokeinterface 1178 4 0
    //   1831: ldc_w 880
    //   1834: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1837: return
    //   1838: invokestatic 1182	com/tencent/mm/plugin/sns/model/aj:faK	()Lcom/tencent/mm/plugin/sns/model/be;
    //   1841: invokevirtual 1187	com/tencent/mm/plugin/sns/model/be:eZn	()V
    //   1844: aload_0
    //   1845: getfield 718	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1848: astore_3
    //   1849: new 1204	com/tencent/mm/hellhoundlib/b/a
    //   1852: dup
    //   1853: invokespecial 1205	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1856: aload_3
    //   1857: invokevirtual 1209	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1860: astore_3
    //   1861: new 4	java/lang/Object
    //   1864: dup
    //   1865: invokespecial 131	java/lang/Object:<init>	()V
    //   1868: astore 4
    //   1870: aload 4
    //   1872: aload_3
    //   1873: invokevirtual 1213	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   1876: ldc_w 846
    //   1879: ldc_w 1214
    //   1882: ldc_w 1215
    //   1885: ldc_w 1217
    //   1888: ldc_w 1219
    //   1891: ldc_w 1221
    //   1894: invokestatic 1224	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1897: aload_3
    //   1898: iconst_0
    //   1899: invokevirtual 1227	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   1902: checkcast 720	android/widget/ListView
    //   1905: invokestatic 1231	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory:scrollToTop	(Landroid/widget/ListView;)V
    //   1908: aload 4
    //   1910: ldc_w 846
    //   1913: ldc_w 1214
    //   1916: ldc_w 1215
    //   1919: ldc_w 1217
    //   1922: ldc_w 1219
    //   1925: ldc_w 1221
    //   1928: invokestatic 1234	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1931: ldc_w 880
    //   1934: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: return
    //   1938: aload_3
    //   1939: ifnonnull +10 -> 1949
    //   1942: ldc_w 880
    //   1945: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1948: return
    //   1949: iload_2
    //   1950: iconst_m1
    //   1951: if_icmpne +238 -> 2189
    //   1954: aload_3
    //   1955: invokevirtual 1238	android/content/Intent:getData	()Landroid/net/Uri;
    //   1958: astore_3
    //   1959: aload_0
    //   1960: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1963: aload_3
    //   1964: aconst_null
    //   1965: aconst_null
    //   1966: aconst_null
    //   1967: aconst_null
    //   1968: invokevirtual 1242	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1971: astore_3
    //   1972: aload_3
    //   1973: invokeinterface 1247 1 0
    //   1978: ifeq +123 -> 2101
    //   1981: new 369	android/content/Intent
    //   1984: dup
    //   1985: ldc_w 1249
    //   1988: ldc_w 1251
    //   1991: aload_3
    //   1992: aload_3
    //   1993: ldc_w 1253
    //   1996: invokeinterface 1257 2 0
    //   2001: invokeinterface 1259 2 0
    //   2006: invokestatic 1262	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2009: invokevirtual 533	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2012: invokestatic 1268	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2015: invokespecial 1271	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   2018: astore 4
    //   2020: aload_0
    //   2021: getfield 199	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   2024: astore_3
    //   2025: new 1204	com/tencent/mm/hellhoundlib/b/a
    //   2028: dup
    //   2029: invokespecial 1205	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2032: aload 4
    //   2034: invokevirtual 1209	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2037: astore 4
    //   2039: aload_3
    //   2040: aload 4
    //   2042: invokevirtual 1213	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   2045: ldc_w 846
    //   2048: ldc_w 1214
    //   2051: ldc_w 1215
    //   2054: ldc_w 1273
    //   2057: ldc_w 1275
    //   2060: ldc_w 1276
    //   2063: invokestatic 1224	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2066: aload_3
    //   2067: aload 4
    //   2069: iconst_0
    //   2070: invokevirtual 1227	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   2073: checkcast 369	android/content/Intent
    //   2076: invokevirtual 1278	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2079: aload_3
    //   2080: ldc_w 846
    //   2083: ldc_w 1214
    //   2086: ldc_w 1215
    //   2089: ldc_w 1273
    //   2092: ldc_w 1275
    //   2095: ldc_w 1276
    //   2098: invokestatic 1234	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2101: ldc_w 880
    //   2104: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2107: return
    //   2108: aload_3
    //   2109: ldc_w 1280
    //   2112: iconst_m1
    //   2113: invokevirtual 373	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2116: istore_1
    //   2117: iload_1
    //   2118: ifle +71 -> 2189
    //   2121: ldc_w 291
    //   2124: ldc_w 1282
    //   2127: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2130: new 1195	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   2133: dup
    //   2134: invokespecial 1283	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   2137: astore_3
    //   2138: aload_3
    //   2139: iload_1
    //   2140: invokevirtual 1286	com/tencent/mm/plugin/sns/data/SnsCmdList:Yj	(I)V
    //   2143: aload_0
    //   2144: getfield 436	com/tencent/mm/plugin/sns/ui/SnsUIAction:EOI	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   2147: iconst_m1
    //   2148: aload_3
    //   2149: getfield 1199	com/tencent/mm/plugin/sns/data/SnsCmdList:DEl	Ljava/util/List;
    //   2152: aload_3
    //   2153: getfield 1202	com/tencent/mm/plugin/sns/data/SnsCmdList:DEm	Ljava/util/List;
    //   2156: invokeinterface 1178 4 0
    //   2161: ldc_w 880
    //   2164: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2167: return
    //   2168: invokestatic 1290	com/tencent/mm/plugin/sns/model/aj:faT	()Lcom/tencent/mm/plugin/sns/storage/i;
    //   2171: invokevirtual 1295	com/tencent/mm/plugin/sns/storage/i:ctN	()Z
    //   2174: pop
    //   2175: ldc_w 880
    //   2178: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2181: return
    //   2182: ldc_w 880
    //   2185: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2188: return
    //   2189: ldc_w 880
    //   2192: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2195: return
    //   2196: astore 5
    //   2198: goto -1169 -> 1029
    //   2201: astore 4
    //   2203: goto -980 -> 1223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2206	0	this	SnsUIAction
    //   0	2206	1	paramInt1	int
    //   0	2206	2	paramInt2	int
    //   0	2206	3	paramIntent	Intent
    //   265	1803	4	localObject1	Object
    //   2201	1	4	localException1	java.lang.Exception
    //   178	1027	5	localObject2	Object
    //   1212	7	5	localException2	java.lang.Exception
    //   1373	237	5	localArrayList	ArrayList
    //   2196	1	5	localException3	java.lang.Exception
    //   887	126	6	localObject3	Object
    //   1181	15	6	localException4	java.lang.Exception
    //   1380	268	6	localObject4	Object
    //   1402	29	7	str	String
    //   1412	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   379	388	444	java/lang/Exception
    //   392	402	444	java/lang/Exception
    //   903	908	927	java/lang/Exception
    //   874	889	1181	java/lang/Exception
    //   894	903	1181	java/lang/Exception
    //   935	1024	1181	java/lang/Exception
    //   1204	1209	1212	java/lang/Exception
    //   874	889	1217	finally
    //   894	903	1217	finally
    //   935	1024	1217	finally
    //   1183	1204	1217	finally
    //   1024	1029	2196	java/lang/Exception
    //   1218	1223	2201	java/lang/Exception
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(99477);
    this.DuA = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    this.ELa = ((int)(this.DuA * 0.4D));
    com.tencent.mm.plugin.sns.model.aj.faL().start();
    if (this.actionbarView != null) {
      this.EOJ = ((Toolbar.LayoutParams)this.actionbarView.getLayoutParams());
    }
    this.EOZ = new com.tencent.mm.plugin.expt.hellhound.a.a.b.c(this.EPa, "SnsTimelineUI", c.a.sCy);
    this.list = this.EOI.getSnsListView();
    this.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99459);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        SnsUIAction.a(SnsUIAction.this).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        com.tencent.mm.plugin.sns.model.aj.faD();
        com.tencent.mm.plugin.sns.storage.r.iI(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        AppMethodBeat.o(99459);
      }
    });
    Object localObject1 = new StringBuilder("list is null ? ");
    boolean bool;
    label321:
    Object localObject2;
    label484:
    String str3;
    String str2;
    String str1;
    int i;
    if (this.list != null)
    {
      bool = true;
      Log.i("MicroMsg.SnsActivity", bool);
      this.list.setScrollingCacheEnabled(false);
      this.DSh = new SnsHeader(this.mActivity);
      this.DSh.setSessionId(this.sessionId);
      this.DSh.setEnterObjectId(this.DTT);
      this.DSh.setBackClickListener(new SnsHeader.a()
      {
        public final boolean JQ(long paramAnonymousLong)
        {
          AppMethodBeat.i(99467);
          if ((SnsUIAction.b(SnsUIAction.this)) || (SnsUIAction.c(SnsUIAction.this).getType() == 1))
          {
            SnsUIAction.this.ZX(2);
            AppMethodBeat.o(99467);
            return false;
          }
          Object localObject1 = new SnsInfo();
          ((SnsInfo)localObject1).field_snsId = paramAnonymousLong;
          ((SnsInfo)localObject1).field_userName = SnsUIAction.d(SnsUIAction.this);
          Object localObject2 = com.tencent.mm.modelsns.n.bfM();
          ((TimeLineObject)localObject2).UserName = SnsUIAction.d(SnsUIAction.this);
          ((SnsInfo)localObject1).setTimeLine((TimeLineObject)localObject2);
          localObject2 = an.aPk(SnsUIAction.d(SnsUIAction.this));
          Log.d("MicroMsg.SnsActivity", "friend like %s", new Object[] { SnsUIAction.d(SnsUIAction.this) });
          if (localObject2 == null) {
            aq.a.a((SnsInfo)localObject1, 1, "", 0);
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.sns.model.aj.faS().aQr(SnsUIAction.d(SnsUIAction.this));
            ((com.tencent.mm.plugin.sns.storage.l)localObject1).field_local_flag |= 0x2;
            com.tencent.mm.plugin.sns.model.aj.faS().c((com.tencent.mm.plugin.sns.storage.l)localObject1);
            SnsUIAction.e(SnsUIAction.this);
            com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePV = 1L;
            break;
            if (((SnsInfo)localObject2).isExtFlag()) {
              aq.a.a((SnsInfo)localObject1, 1, "", 0);
            } else {
              aq.a.a((SnsInfo)localObject1, 5, "", 0);
            }
          }
        }
        
        public final boolean fif()
        {
          AppMethodBeat.i(99468);
          SnsUIAction.c(SnsUIAction.this).fjl();
          AppMethodBeat.o(99468);
          return false;
        }
      });
      this.cBH = this.EOI.fjh();
      this.maskView = this.EOI.getMaskView();
      this.EOC = new LoadingMoreView(this.mActivity);
      this.list.addHeaderView(this.DSh);
      this.list.addFooterView(this.EOC);
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(99470);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt3);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          System.currentTimeMillis();
          localObject = SnsUIAction.this.DSh;
          if ((((SnsHeader)localObject).EDy != null) && (((SnsHeader)localObject).EDy.EDP != null) && (((SnsHeader)localObject).EDF)) {
            ((SnsHeader)localObject).EDy.EDP.fmU();
          }
          SnsUIAction.c(SnsUIAction.this).fjm();
          SnsUIAction.this.EOH = (paramAnonymousInt1 + paramAnonymousInt2 - 1);
          if ((SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 3) && (SnsUIAction.this.list.getCount() != SnsUIAction.f(SnsUIAction.this)))
          {
            Log.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(SnsUIAction.this.list.getCount()) });
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.list.getCount());
            SnsUIAction.g(SnsUIAction.this);
          }
          if (paramAnonymousAbsListView.getChildCount() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
          }
          int m = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 20);
          paramAnonymousInt3 = 0;
          float f2 = 1.0F;
          float f1 = 1.0F;
          int k = 1;
          int i = 0;
          int n;
          int i1;
          int j;
          label359:
          SnsUIAction localSnsUIAction;
          label407:
          int i2;
          float f3;
          if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
          {
            i = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 245);
            n = i - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 30);
            i1 = i - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 10);
            localObject = paramAnonymousAbsListView.getChildAt(0);
            if (localObject != null) {
              break label959;
            }
            j = 0;
            if (paramAnonymousInt1 <= SnsUIAction.h(SnsUIAction.this)) {
              break label969;
            }
            SnsUIAction.this.EOS = SnsUIAction.bhW();
            if (localObject != null)
            {
              localSnsUIAction = SnsUIAction.this;
              localSnsUIAction.gRE += ((View)localObject).getHeight();
            }
            SnsUIAction.this.EOU = (-j + SnsUIAction.this.gRE);
            SnsUIAction.b(SnsUIAction.this, paramAnonymousInt1);
            SnsUIAction.c(SnsUIAction.this, j);
            if (SnsUIAction.this.EOT != SnsUIAction.this.EOS)
            {
              SnsUIAction.this.start = SnsUIAction.this.EOU;
              SnsUIAction.this.EOV = false;
            }
            if (paramAnonymousInt1 != 0) {
              break label1239;
            }
            i2 = -((View)localObject).getTop();
            SnsUIAction.this.EOU = i2;
            if ((i2 < 0) || (i2 > n)) {
              break label1097;
            }
            f3 = 1.0F;
            f2 = 1.0F;
            label522:
            if ((i2 < 0) || (i2 > i)) {
              break label1179;
            }
            f1 = 0.0F;
            k = 0;
            paramAnonymousInt3 = 0;
          }
          for (;;)
          {
            if (SnsUIAction.this.maskView != null)
            {
              Log.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(SnsUIAction.this.EOU), Integer.valueOf(j), Integer.valueOf(SnsUIAction.this.gRE) });
              if ((SnsUIAction.this.EOU <= i) && (!SnsUIAction.j(SnsUIAction.this))) {
                break label1252;
              }
              SnsUIAction.this.maskView.setVisibility(8);
            }
            label632:
            SnsUIAction.this.EOO = SnsUIAction.this.EOU;
            SnsUIAction.this.EOT = SnsUIAction.this.EOS;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) {
              break label1266;
            }
            localObject = (SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this);
            label685:
            float f4 = f1;
            float f5 = f3;
            i = paramAnonymousInt3;
            if (localObject != null)
            {
              if (SnsUIAction.j(SnsUIAction.this))
              {
                paramAnonymousInt3 = 100;
                f3 = 1.0F;
                f1 = 1.0F;
              }
              if (SnsUIAction.this.zlN != paramAnonymousInt3)
              {
                if (paramAnonymousInt3 > 0) {
                  break label1294;
                }
                ((MMActivity)localObject).setActionbarColor(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131101287));
                label759:
                if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
                {
                  if (k == 0) {
                    break label1323;
                  }
                  ((MMActivity)localObject).updateOptionMenuIcon(0, 2131690751);
                }
              }
              label785:
              SnsUIAction.c(SnsUIAction.this).iR(paramAnonymousInt1, paramAnonymousInt3);
              if (SnsUIAction.this.EOQ != f1) {
                ((MMActivity)localObject).setTitleAlpha(f1);
              }
              f4 = f1;
              f5 = f3;
              i = paramAnonymousInt3;
              if (SnsUIAction.this.EOP != f3)
              {
                ((MMActivity)localObject).setIconAlpha(f3);
                i = paramAnonymousInt3;
                f5 = f3;
                f4 = f1;
              }
            }
            SnsUIAction.this.zlN = i;
            SnsUIAction.this.EOP = f5;
            SnsUIAction.this.EOQ = f4;
            SnsUIAction.this.EOR = f2;
            SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
              break;
            }
            i = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 199);
            break;
            label959:
            j = ((View)localObject).getTop();
            break label359;
            label969:
            if (paramAnonymousInt1 < SnsUIAction.h(SnsUIAction.this))
            {
              SnsUIAction.this.EOS = SnsUIAction.byT();
              if (SnsUIAction.this.gRE < ((View)localObject).getHeight()) {
                break label407;
              }
              localSnsUIAction = SnsUIAction.this;
              localSnsUIAction.gRE -= ((View)localObject).getHeight();
              break label407;
            }
            if (Math.abs(j - SnsUIAction.i(SnsUIAction.this)) <= 1) {
              break label407;
            }
            if (j < SnsUIAction.i(SnsUIAction.this))
            {
              SnsUIAction.this.EOS = SnsUIAction.bhW();
              break label407;
            }
            if (j <= SnsUIAction.i(SnsUIAction.this)) {
              break label407;
            }
            SnsUIAction.this.EOS = SnsUIAction.byT();
            break label407;
            label1097:
            if (i2 <= i1)
            {
              f3 = 1.0F - (i2 - n) / (i1 - n);
              f2 = 1.0F - (i2 - n) / (i1 - n);
              break label522;
            }
            f1 = f2;
            if (i2 <= i + m) {
              f1 = (i2 - i) * 1.0F / m;
            }
            f2 = 0.0F;
            f3 = f1;
            break label522;
            label1179:
            if (i2 > i + m) {
              break label1219;
            }
            paramAnonymousInt3 = (i2 - i) * 100 / m;
            f1 = (i2 - i) * 1.0F / m;
          }
          label1219:
          if (i2 > i + m) {
            paramAnonymousInt3 = 100;
          }
          for (;;)
          {
            f1 = 1.0F;
            break;
            label1239:
            paramAnonymousInt3 = 100;
            f2 = 0.0F;
            f3 = 1.0F;
            break;
            label1252:
            SnsUIAction.this.maskView.setVisibility(0);
            break label632;
            label1266:
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI))
            {
              localObject = (SnsUserUI)SnsUIAction.a(SnsUIAction.this);
              break label685;
              ((MMActivity)localObject).setActionbarColor(ar.fj(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131100898), paramAnonymousInt3));
              break label759;
              ((MMActivity)localObject).updateOptionMenuIcon(0, 2131690501);
              break label785;
            }
            label1294:
            label1323:
            localObject = null;
            break label685;
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(99469);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          SnsUIAction.c(SnsUIAction.this).ZS(paramAnonymousInt);
          Object localObject2;
          if (paramAnonymousInt == 0)
          {
            if (((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).EBv != null)) {
              ((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).EBv.uM(true);
            }
            if (SnsUIAction.this.DSh != null)
            {
              localObject1 = SnsUIAction.this.DSh;
              if ((((SnsHeader)localObject1).EDy != null) && (((SnsHeader)localObject1).EDy.EDQ != null) && (!((SnsHeader)localObject1).EDF)) {
                ((SnsHeader)localObject1).EDy.EDQ.fkW();
              }
            }
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
            {
              localObject1 = SnsUIAction.this;
              localObject2 = SnsUIAction.this.list;
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
              if (((SnsUIAction)localObject1).EOX != null) {
                ((SnsUIAction)localObject1).EOX.clear();
              }
              j = -1;
              i = -1;
              int i1 = ((ListView)localObject2).getHeight();
              Object localObject3 = new Rect();
              if (((SnsUIAction)localObject1).actionbarView == null) {
                break label786;
              }
              ((SnsUIAction)localObject1).actionbarView.getGlobalVisibleRect((Rect)localObject3);
              k = ((Rect)localObject3).bottom;
              int i2 = ((ListView)localObject2).getChildCount();
              m = 0;
              if (m < i2)
              {
                Object localObject4 = ((ListView)localObject2).getChildAt(m).getTag();
                if (!(localObject4 instanceof n.a)) {
                  break label783;
                }
                localObject4 = (n.a)localObject4;
                if (!(((n.a)localObject4).EXx instanceof com.tencent.mm.plugin.sns.ui.item.n)) {
                  break label783;
                }
                if (((SnsUIAction)localObject1).EOX == null) {
                  ((SnsUIAction)localObject1).EOX = new ArrayList();
                }
                ((SnsUIAction)localObject1).EOX.add(localObject4);
                ((n.a)localObject4).EZp.getGlobalVisibleRect((Rect)localObject3);
                if (((Rect)localObject3).top < k) {
                  ((Rect)localObject3).top = k;
                }
                if (((Rect)localObject3).top > i1) {
                  ((Rect)localObject3).top = i1;
                }
                if (((Rect)localObject3).bottom < k) {
                  ((Rect)localObject3).bottom = k;
                }
                if (((Rect)localObject3).bottom > i1) {
                  ((Rect)localObject3).bottom = i1;
                }
                int n = Math.abs(((Rect)localObject3).bottom - ((Rect)localObject3).top);
                if (n < j) {
                  break label783;
                }
                i = ((SnsUIAction)localObject1).EOX.size() - 1;
                j = n;
                break label792;
              }
              if ((((SnsUIAction)localObject1).EOX != null) && (((SnsUIAction)localObject1).EOX.size() > 0) && (i >= 0))
              {
                j = 0;
                if (j >= ((SnsUIAction)localObject1).EOX.size()) {
                  break label691;
                }
                localObject2 = (n.a)((SnsUIAction)localObject1).EOX.get(j);
                localObject3 = (com.tencent.mm.plugin.sns.ui.item.n)((n.a)localObject2).EXx;
                if (j == i) {
                  ((com.tencent.mm.plugin.sns.ui.item.n)localObject3).a(((n.a)localObject2).EZp, false);
                } else {
                  ((com.tencent.mm.plugin.sns.ui.item.n)localObject3).a(((n.a)localObject2).EZp, true);
                }
              }
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + localThrowable.toString());
            }
            SnsUIAction.this.bIW();
            if (paramAnonymousInt == 2)
            {
              d.gGm().gV(SnsUIAction.class.getName() + SnsUIAction.c(SnsUIAction.this).getType() + ".Listview", 4);
              SnsUIAction.this.vy(true);
            }
            for (;;)
            {
              SnsUIAction.a(SnsUIAction.this, paramAnonymousAbsListView, paramAnonymousInt);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V");
              AppMethodBeat.o(99469);
              return;
              label691:
              long l2 = System.currentTimeMillis();
              localObject2 = new StringBuilder("checkSphereImageCompItem cost=").append(l2 - l1).append(", maxVisiableItemIdx=").append(i).append(", size=");
              if (localThrowable.EOX != null) {}
              for (i = localThrowable.EOX.size();; i = 0)
              {
                Log.d("MicroMsg.SnsActivitySphereImageView", i);
                break;
              }
              SnsUIAction.this.vy(false);
            }
            label783:
            break label792;
            label786:
            int k = 0;
            continue;
            label792:
            m += 1;
            continue;
            j += 1;
          }
        }
      });
      this.zog = this.EOI.fji();
      localObject1 = new StringBuilder("pullDownView is null ? ");
      if (this.zog == null) {
        break label1003;
      }
      bool = true;
      Log.i("MicroMsg.SnsActivity", bool);
      this.zog.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean cAm()
        {
          AppMethodBeat.i(99471);
          SnsUIAction.c(SnsUIAction.this).fjk();
          AppMethodBeat.o(99471);
          return true;
        }
      });
      this.zog.setTopViewVisible(false);
      this.zog.setIsTopShowAll(false);
      this.zog.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cAl()
        {
          AppMethodBeat.i(99472);
          View localView = SnsUIAction.this.list.getChildAt(SnsUIAction.this.list.getChildCount() - 1);
          if ((localView != null) && (localView.getBottom() <= SnsUIAction.this.list.getHeight()) && (SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getAdapter().getCount() - 1))
          {
            AppMethodBeat.o(99472);
            return true;
          }
          AppMethodBeat.o(99472);
          return false;
        }
      });
      this.zog.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cAk()
        {
          AppMethodBeat.i(99473);
          View localView = SnsUIAction.this.list.getChildAt(SnsUIAction.this.list.getFirstVisiblePosition());
          if ((localView != null) && (localView.getTop() == 0))
          {
            AppMethodBeat.o(99473);
            return true;
          }
          AppMethodBeat.o(99473);
          return false;
        }
      });
      this.zog.setIsBottomShowAll(false);
      this.zog.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean cAj()
        {
          AppMethodBeat.i(99474);
          Log.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.qeT);
          if (!SnsUIAction.this.qeT) {
            SnsUIAction.g(SnsUIAction.this);
          }
          AppMethodBeat.o(99474);
          return true;
        }
      });
      this.zog.setShowBackground(true);
      this.zog.setBgColor(MMApplicationContext.getContext().getResources().getColor(2131099650));
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localObject2 = this.DSh;
      if (!Util.isNullOrNil(this.mRa)) {
        break label1008;
      }
      localObject1 = this.ELj;
      str3 = this.ELj;
      str2 = this.krY;
      str1 = this.mSignature;
      if ((localObject1 != null) && (str3 != null)) {
        break label1016;
      }
      Log.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      localObject1 = this.DSh;
      i = this.EOI.getType();
      ((SnsHeader)localObject1).type = i;
      if ((i == 1) && (((SnsHeader)localObject1).EDy.Eob != null)) {
        ((SnsHeader)localObject1).EDy.Eob.setVisibility(8);
      }
      if (((SnsHeader)localObject1).EDy != null)
      {
        if ((((SnsHeader)localObject1).EDy.EDP != null) && (((SnsHeader)localObject1).EDF)) {
          ((SnsHeader)localObject1).EDy.EDP.setSnsType(i);
        }
        if ((((SnsHeader)localObject1).EDy.EDQ != null) && (!((SnsHeader)localObject1).EDF)) {
          ((SnsHeader)localObject1).EDy.EDQ.setSnsType(i);
        }
      }
      if (i != 1)
      {
        if ((((SnsHeader)localObject1).EDy.EDP != null) && (((SnsHeader)localObject1).EDy.EDP.getParent() != null) && ((((SnsHeader)localObject1).EDy.EDP.getParent() instanceof ViewGroup))) {
          ((ViewGroup)((SnsHeader)localObject1).EDy.EDP.getParent()).removeView(((SnsHeader)localObject1).EDy.EDP);
        }
        if ((((SnsHeader)localObject1).EDy.EDQ != null) && (((SnsHeader)localObject1).EDy.EDQ.getParent() != null) && ((((SnsHeader)localObject1).EDy.EDQ.getParent() instanceof ViewGroup))) {
          ((ViewGroup)((SnsHeader)localObject1).EDy.EDQ.getParent()).removeView(((SnsHeader)localObject1).EDy.EDQ);
        }
      }
      if (i != 1) {
        break label1287;
      }
      ((SnsHeader)localObject1).EDy.EDS.setPadding(0, au.eu(((SnsHeader)localObject1).context) + au.aD(((SnsHeader)localObject1).context) - ((SnsHeader)localObject1).getResources().getDimensionPixelSize(2131166968), 0, at.fromDPToPix(((SnsHeader)localObject1).context, 10));
      label811:
      if ((i == 1) && (((SnsHeader)localObject1).EDy != null) && (((SnsHeader)localObject1).EDy.EDV != null))
      {
        if (!SnsHeader.fic()) {
          break label1343;
        }
        ((SnsHeader)localObject1).EDy.EDU = ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).getFinderUtilApi().ao((Activity)((SnsHeader)localObject1).context);
        localObject2 = ((SnsHeader)localObject1).EDy.EDU.dHb();
        ((SnsHeader)localObject1).EDy.EDV.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -2));
        ((SnsHeader)localObject1).EDy.EDU.a(new SnsHeader.1((SnsHeader)localObject1, this));
        if (((SnsHeader)localObject1).EDy.EDQ != null) {
          ((SnsHeader)localObject1).EDy.EDQ.setTopLineVisibility(0);
        }
      }
      label949:
      this.DSh.fid();
      fjx();
      if (Build.VERSION.SDK_INT >= 11) {
        break label1403;
      }
      Log.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.model.aj.faK().a(this);
      com.tencent.mm.plugin.sns.model.aj.faJ().a(this);
      AppMethodBeat.o(99477);
      return;
      bool = false;
      break;
      label1003:
      bool = false;
      break label321;
      label1008:
      localObject1 = this.mRa;
      break label484;
      label1016:
      ((SnsHeader)localObject2).userName = ((String)localObject1).trim();
      ((SnsHeader)localObject2).gna = str3.trim();
      ((SnsHeader)localObject2).dJM = str3.equals(localObject1);
      Log.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject1).length() + "  " + (String)localObject1);
      ((SnsHeader)localObject2).EDy.oSN.setText((CharSequence)localObject1);
      if ((((SnsHeader)localObject2).EDy == null) || (((SnsHeader)localObject2).EDy.gyr == null)) {
        label1113:
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject1);
          if ((localObject1 == null) || (Util.isNullOrNil(((as)localObject1).arJ()))) {
            break label1278;
          }
        }
      }
      label1278:
      for (localObject1 = ((as)localObject1).arJ();; localObject1 = com.tencent.mm.plugin.sns.data.r.R(str2))
      {
        ((SnsHeader)localObject2).EDy.oSN.setText(com.tencent.mm.pluginsdk.ui.span.l.c(((SnsHeader)localObject2).context, (CharSequence)localObject1));
        ((SnsHeader)localObject2).EDy.Eob.setText(com.tencent.mm.pluginsdk.ui.span.l.b(((SnsHeader)localObject2).context, str1, ((SnsHeader)localObject2).EDy.Eob.getTextSize()));
        ((SnsHeader)localObject2).EDy.gyr.setContentDescription(((SnsHeader)localObject2).context.getString(2131766004, new Object[] { ((SnsHeader)localObject2).EDy.oSN.getText() }));
        break;
        a.b.A(((SnsHeader)localObject2).EDy.gyr, ((SnsHeader)localObject2).userName);
        break label1113;
      }
      label1287:
      if (i != 2) {
        break label811;
      }
      ((SnsHeader)localObject1).EDy.EDS.setPadding(0, au.eu(((SnsHeader)localObject1).context) + au.aD(((SnsHeader)localObject1).context) + at.fromDPToPix(((SnsHeader)localObject1).getContext(), 90) + at.fromDPToPix(((SnsHeader)localObject1).getContext(), 48), 0, 0);
      break label811;
      label1343:
      ((SnsHeader)localObject1).EDy.EDV.setPadding(0, (int)((SnsHeader)localObject1).context.getResources().getDimension(2131165303), 0, 0);
      if (((SnsHeader)localObject1).EDy.EDQ != null) {
        ((SnsHeader)localObject1).EDy.EDQ.setTopLineVisibility(0);
      }
      Log.i("MicroMsg.SnsHeader", "disable finderSnsHeader");
      break label949;
      label1403:
      new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176359);
          View.OnDragListener local1 = new View.OnDragListener()
          {
            public final boolean onDrag(View paramAnonymous2View, DragEvent paramAnonymous2DragEvent)
            {
              AppMethodBeat.i(176358);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymous2View);
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymous2DragEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
              boolean bool = false;
              int i = paramAnonymous2DragEvent.getAction();
              switch (i)
              {
              default: 
                Log.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                AppMethodBeat.o(176358);
                return bool;
                bool = true;
                Log.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
                continue;
                Log.i("MicroMsg.SnsActivity", "ACTION_DROP");
                paramAnonymous2DragEvent = paramAnonymous2DragEvent.getClipData();
                if (paramAnonymous2DragEvent != null)
                {
                  int j = paramAnonymous2DragEvent.getItemCount();
                  paramAnonymous2View = new ArrayList();
                  i = 0;
                  if (i < j)
                  {
                    Object localObject2 = paramAnonymous2DragEvent.getItemAt(i);
                    if (localObject2 == null) {
                      Log.e("MicroMsg.SnsActivity", "item == null");
                    }
                    for (;;)
                    {
                      i += 1;
                      break;
                      if (((ClipData.Item)localObject2).getIntent() != null)
                      {
                        localObject1 = SnsUIAction.a(SnsUIAction.this);
                        localObject2 = ((ClipData.Item)localObject2).getIntent();
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      }
                      else if (((ClipData.Item)localObject2).getUri() != null)
                      {
                        localObject1 = new t(SnsUIAction.a(SnsUIAction.this), ((ClipData.Item)localObject2).getUri());
                        if ((((t)localObject1).fileType != 0) && (((t)localObject1).filePath != null)) {}
                        switch (((t)localObject1).fileType)
                        {
                        default: 
                          break;
                        case 3: 
                          paramAnonymous2View.add(((t)localObject1).filePath);
                          continue;
                          Log.e("MicroMsg.SnsActivity", "get file path failed");
                        }
                      }
                    }
                  }
                  if (paramAnonymous2View.size() < 0)
                  {
                    Log.e("MicroMsg.SnsActivity", "no image file available");
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                    AppMethodBeat.o(176358);
                    return true;
                  }
                  paramAnonymous2DragEvent = new Intent(SnsUIAction.a(SnsUIAction.this), SnsUploadUI.class);
                  paramAnonymous2DragEvent.putExtra("KSnsPostManu", true);
                  paramAnonymous2DragEvent.putExtra("KTouchCameraTime", Util.nowSecond());
                  paramAnonymous2DragEvent.putStringArrayListExtra("sns_kemdia_path_list", paramAnonymous2View);
                  paramAnonymous2DragEvent.setAction("android.intent.action.SEND");
                  paramAnonymous2DragEvent.addCategory("android.intent.category.DEFAULT");
                  paramAnonymous2DragEvent.addFlags(268435456);
                  paramAnonymous2DragEvent.putExtra("android.intent.extra.TEXT", "");
                  paramAnonymous2DragEvent.putExtra("Ksnsupload_empty_img", true);
                  if (SnsUIAction.b(SnsUIAction.this)) {
                    paramAnonymous2DragEvent.putExtra("Ksnsupload_source", 11);
                  }
                  paramAnonymous2DragEvent.setType("image/*");
                  paramAnonymous2View = SnsUIAction.a(SnsUIAction.this);
                  paramAnonymous2DragEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2DragEvent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2DragEvent.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2View.startActivity((Intent)paramAnonymous2DragEvent.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  bool = true;
                }
                else
                {
                  bool = true;
                }
              }
            }
          };
          if (SnsUIAction.this.DSh != null) {
            SnsUIAction.this.DSh.setOnDragListener(local1);
          }
          AppMethodBeat.o(176359);
        }
      }.run();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(99486);
    if ((this.mActivity == null) || (!(this.mActivity instanceof SnsTimeLineUI))) {}
    for (;;)
    {
      if (this.DSh != null)
      {
        SnsHeader localSnsHeader = this.DSh;
        if ((localSnsHeader.EDE != null) && (!localSnsHeader.EDE.isRecycled())) {
          localSnsHeader.EDE.recycle();
        }
        if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDP != null) && (localSnsHeader.EDF)) {
          localSnsHeader.EDy.EDP.onDestroyView();
        }
        if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDQ != null) && (!localSnsHeader.EDF))
        {
          SnsStoryHeaderView localSnsStoryHeaderView = localSnsHeader.EDy.EDQ;
          Log.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
          localSnsStoryHeaderView.aMn = true;
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b(localSnsStoryHeaderView);
        }
        if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDU != null)) {
          localSnsHeader.EDy.EDU.release();
        }
      }
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAf().azp())
      {
        com.tencent.mm.plugin.sns.model.aj.faL().aI(this.mActivity);
        com.tencent.mm.plugin.sns.model.aj.faJ().b(this);
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        com.tencent.mm.plugin.sns.model.aj.faK().b(this);
      }
      this.EOC.setVisibility(8);
      af.ffX();
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        com.tencent.mm.plugin.sns.model.aj.faL().start();
      }
      this.list.setAdapter(null);
      com.tencent.mm.plugin.sns.data.r.aOz("");
      AppMethodBeat.o(99486);
      return;
      ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(null, null, c.e.sFr.state, -1, -1, 1L, "61", 8, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(99481);
    Object localObject = new pg();
    ((pg)localObject).dVo.pause = false;
    EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
    Log.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    if (this.DSh != null)
    {
      localObject = this.DSh;
      if ((((SnsHeader)localObject).EDy != null) && (((SnsHeader)localObject).EDy.EDQ != null) && (!((SnsHeader)localObject).EDF))
      {
        localObject = ((SnsHeader)localObject).EDy.EDQ;
        ((SnsStoryHeaderView)localObject).FdC = false;
        ((SnsStoryHeaderView)localObject).dLD = true;
      }
      localObject = anl();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt = this.DSh.fx(this.actionbarView);
        ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(this.list, (BaseAdapter)localObject, c.e.sFq.state, -1, -1, 1L, "61", 3, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt);
      }
    }
    AppMethodBeat.o(99481);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(99480);
    com.tencent.mm.plugin.sns.model.aj.faJ().aO(2, false);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(7);
    Object localObject = new pg();
    ((pg)localObject).dVo.pause = true;
    EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
    Log.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    if (this.DSh != null)
    {
      this.DSh.onResume();
      localObject = anl();
      if (localObject != null)
      {
        boolean bool2 = this.DSh.fx(this.actionbarView);
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEt;
        }
        ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053(this.list, (BaseAdapter)localObject, c.e.sFp.state, -1, -1, 1L, "61", 2, bool1);
      }
    }
    AppMethodBeat.o(99480);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(99482);
    this.sessionId = paramString;
    if (this.DSh != null) {
      this.DSh.setSessionId(paramString);
    }
    AppMethodBeat.o(99482);
  }
  
  public final void vy(boolean paramBoolean)
  {
    AppMethodBeat.i(99479);
    this.EOI.vy(paramBoolean);
    AppMethodBeat.o(99479);
  }
  
  public final void vz(boolean paramBoolean)
  {
    AppMethodBeat.i(179310);
    this.EvK = paramBoolean;
    if (paramBoolean)
    {
      if (this.zog != null) {
        this.zog.setEnableGesture(false);
      }
      localSnsHeader = this.DSh;
      if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDS != null) && (localSnsHeader.EDy.EDR != null))
      {
        localSnsHeader.EDy.EDS.setVisibility(0);
        localSnsHeader.EDy.EDR.setVisibility(8);
      }
      AppMethodBeat.o(179310);
      return;
    }
    if (this.zog != null) {
      this.zog.setEnableGesture(true);
    }
    SnsHeader localSnsHeader = this.DSh;
    if ((localSnsHeader.EDy != null) && (localSnsHeader.EDy.EDS != null) && (localSnsHeader.EDy.EDR != null))
    {
      localSnsHeader.EDy.EDS.setVisibility(4);
      localSnsHeader.EDy.EDR.setVisibility(0);
    }
    AppMethodBeat.o(179310);
  }
  
  public static abstract interface a
  {
    public abstract void ZS(int paramInt);
    
    public abstract void a(com.tencent.mm.plugin.sns.data.m paramm);
    
    public abstract void aP(int paramInt, boolean paramBoolean);
    
    public abstract void d(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract void fjg();
    
    public abstract View fjh();
    
    public abstract MMPullDownView fji();
    
    public abstract boolean fjj();
    
    public abstract void fjk();
    
    public abstract void fjl();
    
    public abstract void fjm();
    
    public abstract View getMaskView();
    
    public abstract ListView getSnsListView();
    
    public abstract int getType();
    
    public abstract void iR(int paramInt1, int paramInt2);
    
    public abstract void vy(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction
 * JD-Core Version:    0.7.0.1
 */