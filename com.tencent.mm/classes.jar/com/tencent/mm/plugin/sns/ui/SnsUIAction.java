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
import android.support.v7.widget.Toolbar.LayoutParams;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bc.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SnsUIAction
  implements bc.a, c.b
{
  private static int AFg = 0;
  private static int AFh = 1;
  private static int AFi = 2;
  private int ABC;
  private String ABL;
  private boolean ABM;
  private int ABN;
  protected LoadingMoreView AEZ;
  private int AFa;
  private int AFb;
  private boolean AFc;
  public int AFd;
  a AFe;
  private Toolbar.LayoutParams AFf;
  private int AFj;
  int AFk;
  float AFl;
  float AFm;
  float AFn;
  int AFo;
  int AFp;
  int AFq;
  boolean AFr;
  private com.tencent.e.i.b AFs;
  ArrayList<k.a> AFt;
  com.tencent.mm.modelsns.e AFu;
  private boolean Aiv;
  boolean AmY;
  View actionbarView;
  private String cff;
  protected View cpn;
  protected String filePath;
  int gim;
  protected View hcH;
  private String jtJ;
  private String lJm;
  private int lastIndex;
  protected ListView list;
  private Activity mActivity;
  protected boolean oRf;
  private String sessionId;
  int start;
  private ArrayList<com.tencent.mm.plugin.sns.storage.p> tSf;
  protected com.tencent.mm.ui.base.p tipDialog;
  protected String title;
  int vRH;
  protected MMPullDownView vUa;
  protected SnsHeader zIf;
  String zJR;
  public int zop;
  private boolean zuv;
  
  public SnsUIAction(Activity paramActivity)
  {
    AppMethodBeat.i(176361);
    this.tipDialog = null;
    this.AFa = 0;
    this.AFb = 0;
    this.AFc = false;
    this.oRf = false;
    this.zuv = false;
    this.zop = 0;
    this.AFd = 0;
    this.AFk = 0;
    this.vRH = 0;
    this.AFl = 1.0F;
    this.AFm = 1.0F;
    this.AFn = 1.0F;
    this.AFo = AFg;
    this.AFp = AFg;
    this.AFq = 0;
    this.start = 0;
    this.gim = 0;
    this.AFr = false;
    this.ABC = 800;
    this.AmY = false;
    this.tSf = new ArrayList();
    this.AFs = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "SnsUIAction#preloadRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(99475);
        Object localObject2 = ah.dXC();
        synchronized (((ax)localObject2).zEh)
        {
          ((ax)localObject2).zEh.clear();
          ??? = new ArrayList(SnsUIAction.k(SnsUIAction.this)).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.sns.storage.p)((Iterator)???).next();
            ah.dXC().A((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
        }
        AppMethodBeat.o(99475);
      }
    };
    this.AFt = null;
    this.AFu = null;
    this.mActivity = paramActivity;
    AppMethodBeat.o(176361);
  }
  
  private void aQ(Intent paramIntent)
  {
    AppMethodBeat.i(99484);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176355);
        com.tencent.mm.plugin.sns.c.a.iUA.MO();
        AppMethodBeat.o(176355);
      }
    });
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null)
    {
      AppMethodBeat.o(99484);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.axj(this.filePath);
    localObject = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    u.aG(ah.getAccSnsTmpPath(), this.filePath, (String)localObject);
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.axh(this.filePath);
    this.filePath = (ah.getAccSnsTmpPath() + (String)localObject);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", bu.aRi());
      if (this.AFu != null)
      {
        this.AFu.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.AFu = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.zuv) {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
      }
      if (this.Aiv) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      this.mActivity.startActivityForResult((Intent)localObject, 6);
      this.zuv = false;
      AppMethodBeat.o(99484);
      return;
    }
  }
  
  protected final boolean Sb(int paramInt)
  {
    int j = 3;
    boolean bool1 = false;
    AppMethodBeat.i(99485);
    com.tencent.mm.kernel.g.ajS();
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      t.g(this.mActivity, null);
      AppMethodBeat.o(99485);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(paramInt)));
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("username", this.ABL);
      localIntent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
      this.mActivity.startActivityForResult(localIntent, 7);
      AppMethodBeat.o(99485);
      return true;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.kernel.g.ajS();
      i = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(68385, null), 0);
      com.tencent.mm.kernel.g.ajS();
      int k = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(68386, null), 0);
      if ((!this.AFc) && (i < 3) && (k == 0))
      {
        this.AFc = true;
        bk.b(this.mActivity, new SnsUIAction.5(this, paramInt));
        AppMethodBeat.o(99485);
        return true;
      }
      if (this.mActivity.getSharedPreferences(ak.fow(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
        q.c(this.mActivity, 2, null);
      }
    }
    else
    {
      AppMethodBeat.o(99485);
      return true;
    }
    int i = com.tencent.mm.n.g.acL().getInt("SnsCanPickVideoFromAlbum", 1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(i) });
    if (ac.iSG) {
      i = 0;
    }
    if (i == 1)
    {
      paramInt = j;
      label310:
      localIntent = new Intent();
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGn, false);
      if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXH, 0) != 1) && (!bool2)) {
        break label449;
      }
      i = 1;
      label363:
      if (i == 0) {
        bool1 = true;
      }
      localIntent.putExtra("key_can_select_video_and_pic", bool1);
      localIntent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.aHh().aHk().duration);
      if (!(this.mActivity instanceof SnsUserUI)) {
        break label454;
      }
      localIntent.putExtra("gallery_report_tag", 17);
    }
    for (;;)
    {
      q.a(this.mActivity, 14, 9, 4, paramInt, localIntent);
      break;
      paramInt = j;
      if (i != 0) {
        break label310;
      }
      paramInt = 1;
      break label310;
      label449:
      i = 0;
      break label363;
      label454:
      localIntent.putExtra("gallery_report_tag", 4);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.ABL = paramString1;
    this.lJm = paramString2;
    this.jtJ = paramString3;
    this.cff = paramString4;
    this.ABM = paramBoolean1;
    this.Aiv = paramBoolean2;
    this.ABN = paramInt;
  }
  
  protected final void aBZ(String paramString)
  {
    AppMethodBeat.i(99490);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.AEZ.aBZ(paramString);
    AppMethodBeat.o(99490);
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99495);
    this.AFe.aC(paramInt, paramBoolean);
    AppMethodBeat.o(99495);
  }
  
  protected final void aCl(String paramString)
  {
    AppMethodBeat.i(99488);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "snsactivty onIsDownAll ");
    this.AEZ.aBZ(paramString);
    AppMethodBeat.o(99488);
  }
  
  public final void azJ(String paramString) {}
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99497);
    if ((this.AFe.getType() == 1) && (this.list != null) && (this.list.getAdapter() != null) && ((this.list.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.a.c))) {
      ((com.tencent.mm.plugin.sns.ui.a.c)this.list.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(99497);
  }
  
  public final void bR(String paramString, boolean paramBoolean) {}
  
  public final void bns()
  {
    AppMethodBeat.i(99478);
    this.AFs.cancel();
    this.tSf.clear();
    int i = this.list.getLastVisiblePosition();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsVideoService", "currentPosition :%d count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.list.getCount()) });
    int j = this.list.getCount();
    if (j - i > 15) {
      j = i + 15;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.list.getItemAtPosition(i);
        if (((localObject instanceof com.tencent.mm.plugin.sns.storage.p)) && (((com.tencent.mm.plugin.sns.storage.p)localObject).field_type == 15) && ((!((com.tencent.mm.plugin.sns.storage.p)localObject).Rt(32)) || (com.tencent.mm.plugin.sns.ad.timeline.a.a.j((com.tencent.mm.plugin.sns.storage.p)localObject)))) {
          this.tSf.add((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        i += 1;
      }
      else
      {
        com.tencent.e.h.MqF.aO(this.AFs);
        AppMethodBeat.o(99478);
        return;
      }
    }
  }
  
  public final void dWB()
  {
    AppMethodBeat.i(99487);
    this.zIf.efD();
    AppMethodBeat.o(99487);
  }
  
  public final void dYG()
  {
    AppMethodBeat.i(99496);
    if (this.zIf != null) {
      this.zIf.efD();
    }
    AppMethodBeat.o(99496);
  }
  
  protected final void egU()
  {
    AppMethodBeat.i(160742);
    this.AEZ.Gc();
    AppMethodBeat.o(160742);
  }
  
  public final void egV()
  {
    AppMethodBeat.i(99491);
    if ((this.AFe != null) && (this.AFe.getType() == 2)) {
      ah.dJc().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99466);
          Object localObject2 = ah.dXI().aBx(SnsUIAction.d(SnsUIAction.this));
          final m localm = new m();
          ArrayList localArrayList;
          HashMap localHashMap;
          Object localObject1;
          String str;
          long l;
          if (!bu.ht((List)localObject2))
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localObject1 = "";
            Iterator localIterator = ((List)localObject2).iterator();
            if (localIterator.hasNext())
            {
              die localdie = (die)localIterator.next();
              localObject2 = String.valueOf(localdie.HPu);
              str = String.valueOf(localdie.HPv);
              l = localdie.HPw;
              if (bu.lX((String)localObject1, (String)localObject2)) {
                break label281;
              }
              localArrayList = new ArrayList();
              localHashMap = new HashMap();
              localm.zug.add(localObject2);
              localm.zuh.add(localArrayList);
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
            Collections.reverse(localm.zug);
            Collections.reverse(localm.zuh);
            localObject1 = localm.zuh.iterator();
            while (((Iterator)localObject1).hasNext()) {
              Collections.reverse((List)((Iterator)localObject1).next());
            }
            ah.cXK().post(new Runnable()
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
  
  public final void egW()
  {
    AppMethodBeat.i(99493);
    if (getSnsListView() != null) {
      getSnsListView().setVisibility(8);
    }
    AppMethodBeat.o(99493);
  }
  
  public final void egX()
  {
    AppMethodBeat.i(99494);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V", this);
    if (this.zIf != null)
    {
      SnsHeader localSnsHeader = this.zIf;
      if ((localSnsHeader.Auq != null) && (localSnsHeader.Auq.AuF != null) && (localSnsHeader.Aux)) {
        localSnsHeader.Auq.AuF.egX();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V");
    AppMethodBeat.o(99494);
  }
  
  public final void egY()
  {
    AppMethodBeat.i(220014);
    if (this.zIf != null)
    {
      SnsHeader localSnsHeader = this.zIf;
      if ((localSnsHeader.Auq != null) && (localSnsHeader.Auq.AuJ != null) && (localSnsHeader.Ajj != null))
      {
        localSnsHeader.Ajj.cancel();
        localSnsHeader.Ajj.reset();
        localSnsHeader.Auq.AuJ.startAnimation(localSnsHeader.Ajj);
      }
    }
    AppMethodBeat.o(220014);
  }
  
  public final void egZ()
  {
    AppMethodBeat.i(220015);
    if (this.AEZ != null)
    {
      LoadingMoreView localLoadingMoreView = this.AEZ;
      localLoadingMoreView.Ajj.cancel();
      localLoadingMoreView.Ajj.reset();
      localLoadingMoreView.dxD.startAnimation(localLoadingMoreView.Ajj);
    }
    AppMethodBeat.o(220015);
  }
  
  public final int getHeaderHeight()
  {
    AppMethodBeat.i(179311);
    if (this.zIf != null)
    {
      int i = this.zIf.getMeasuredHeight();
      AppMethodBeat.o(179311);
      return i;
    }
    AppMethodBeat.o(179311);
    return 0;
  }
  
  public ListView getSnsListView()
  {
    AppMethodBeat.i(99498);
    ListView localListView = this.AFe.getSnsListView();
    AppMethodBeat.o(99498);
    return localListView;
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 821
    //   3: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 214
    //   8: ldc_w 823
    //   11: iload_1
    //   12: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 825	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iload_2
    //   22: iconst_m1
    //   23: if_icmpeq +50 -> 73
    //   26: iload_1
    //   27: iconst_5
    //   28: if_icmpeq +13 -> 41
    //   31: iload_1
    //   32: iconst_2
    //   33: if_icmpeq +8 -> 41
    //   36: iload_1
    //   37: iconst_4
    //   38: if_icmpne +25 -> 63
    //   41: new 198	com/tencent/mm/sdk/platformtools/aq
    //   44: dup
    //   45: invokestatic 204	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   48: invokespecial 207	com/tencent/mm/sdk/platformtools/aq:<init>	(Landroid/os/Looper;)V
    //   51: new 22	com/tencent/mm/plugin/sns/ui/SnsUIAction$15
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 826	com/tencent/mm/plugin/sns/ui/SnsUIAction$15:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   59: invokevirtual 212	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
    //   62: pop
    //   63: invokestatic 831	com/tencent/mm/plugin/sns/data/r:dWq	()V
    //   66: ldc_w 821
    //   69: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: iload_1
    //   74: tableswitch	default:+78 -> 152, 2:+512->586, 3:+78->152, 4:+1575->1649, 5:+391->465, 6:+1609->1683, 7:+1662->1736, 8:+1690->1764, 9:+1749->1823, 10:+1849->1923, 11:+78->152, 12:+2019->2093, 13:+2078->2152, 14:+643->717, 15:+2092->2166, 16:+78->152, 17:+93->167
    //   153: <illegal opcode>
    //   154: ldc_w 833
    //   157: invokestatic 835	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 821
    //   163: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: aload_3
    //   168: ldc_w 837
    //   171: invokevirtual 841	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   174: checkcast 843	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   177: astore 5
    //   179: aload 5
    //   181: ifnull +1992 -> 2173
    //   184: aload 5
    //   186: getfield 846	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYw	Z
    //   189: ifeq +39 -> 228
    //   192: aload_0
    //   193: aload 5
    //   195: getfield 849	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYE	Ljava/lang/String;
    //   198: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   205: invokestatic 852	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   208: ifne +1965 -> 2173
    //   211: aload_0
    //   212: iconst_1
    //   213: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zuv	Z
    //   216: aload_0
    //   217: aload_3
    //   218: invokespecial 854	com/tencent/mm/plugin/sns/ui/SnsUIAction:aQ	(Landroid/content/Intent;)V
    //   221: ldc_w 821
    //   224: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: ldc 214
    //   230: ldc_w 856
    //   233: iconst_2
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload 5
    //   241: getfield 859	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYy	Ljava/lang/String;
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload 5
    //   249: getfield 862	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYz	Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 563	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: new 292	android/content/Intent
    //   259: dup
    //   260: invokespecial 475	android/content/Intent:<init>	()V
    //   263: astore 4
    //   265: aload 4
    //   267: ldc_w 864
    //   270: aload 5
    //   272: getfield 859	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYy	Ljava/lang/String;
    //   275: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   278: pop
    //   279: aload 4
    //   281: ldc_w 866
    //   284: aload 5
    //   286: getfield 862	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYz	Ljava/lang/String;
    //   289: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   292: pop
    //   293: aload 5
    //   295: getfield 869	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYB	Ljava/lang/String;
    //   298: invokestatic 852	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   301: ifne +121 -> 422
    //   304: aload 4
    //   306: ldc_w 871
    //   309: aload 5
    //   311: getfield 869	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYB	Ljava/lang/String;
    //   314: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: aload 4
    //   320: ldc_w 303
    //   323: iconst_1
    //   324: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   327: pop
    //   328: aload 4
    //   330: ldc_w 309
    //   333: invokestatic 314	com/tencent/mm/sdk/platformtools/bu:aRi	()J
    //   336: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   339: pop
    //   340: aload 4
    //   342: ldc_w 873
    //   345: bipush 14
    //   347: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   350: pop
    //   351: aload 4
    //   353: ldc_w 337
    //   356: iconst_0
    //   357: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   360: pop
    //   361: aload 4
    //   363: ldc_w 343
    //   366: aload_3
    //   367: ldc_w 343
    //   370: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   373: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   376: pop
    //   377: aload 5
    //   379: getfield 877	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYD	Lcom/tencent/mm/protocal/protobuf/byg;
    //   382: invokevirtual 882	com/tencent/mm/protocal/protobuf/byg:toByteArray	()[B
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +13 -> 400
    //   390: aload 4
    //   392: ldc_w 884
    //   395: aload_3
    //   396: invokevirtual 887	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   399: pop
    //   400: aload_0
    //   401: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   404: ldc_w 889
    //   407: ldc_w 891
    //   410: aload 4
    //   412: invokestatic 896	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   415: ldc_w 821
    //   418: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    //   422: aload 4
    //   424: ldc_w 871
    //   427: aload 5
    //   429: getfield 859	com/tencent/mm/plugin/mmsight/SightCaptureResult:vYy	Ljava/lang/String;
    //   432: invokestatic 901	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   435: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   438: pop
    //   439: goto -121 -> 318
    //   442: astore_3
    //   443: ldc 214
    //   445: ldc_w 903
    //   448: iconst_1
    //   449: anewarray 4	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: aload_3
    //   455: invokevirtual 906	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   458: aastore
    //   459: invokestatic 563	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: goto -62 -> 400
    //   465: aload_0
    //   466: aload_0
    //   467: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   470: invokevirtual 910	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   473: aload_3
    //   474: invokestatic 277	com/tencent/mm/plugin/sns/model/ah:getAccSnsTmpPath	()Ljava/lang/String;
    //   477: invokestatic 913	com/tencent/mm/pluginsdk/ui/tools/q:i	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   480: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   483: ldc 214
    //   485: new 224	java/lang/StringBuilder
    //   488: dup
    //   489: ldc_w 915
    //   492: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   495: aload_0
    //   496: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   499: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload_0
    //   509: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   512: ifnonnull +10 -> 522
    //   515: ldc_w 821
    //   518: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: return
    //   522: invokestatic 452	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   525: pop
    //   526: invokestatic 456	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   529: invokevirtual 489	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   532: ldc_w 916
    //   535: aconst_null
    //   536: invokevirtual 496	com/tencent/mm/storage/aj:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   539: checkcast 498	java/lang/Integer
    //   542: iconst_0
    //   543: invokestatic 501	com/tencent/mm/sdk/platformtools/bu:a	(Ljava/lang/Integer;I)I
    //   546: istore_1
    //   547: invokestatic 452	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   550: pop
    //   551: invokestatic 456	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   554: invokevirtual 489	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   557: ldc_w 916
    //   560: iload_1
    //   561: iconst_1
    //   562: iadd
    //   563: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: invokevirtual 920	com/tencent/mm/storage/aj:set	(ILjava/lang/Object;)V
    //   569: aload_0
    //   570: iconst_1
    //   571: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zuv	Z
    //   574: aload_0
    //   575: aload_3
    //   576: invokespecial 854	com/tencent/mm/plugin/sns/ui/SnsUIAction:aQ	(Landroid/content/Intent;)V
    //   579: ldc_w 821
    //   582: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: return
    //   586: aload_3
    //   587: ifnonnull +10 -> 597
    //   590: ldc_w 821
    //   593: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: return
    //   597: invokestatic 452	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   600: pop
    //   601: invokestatic 456	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   604: invokevirtual 489	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   607: ldc_w 921
    //   610: aconst_null
    //   611: invokevirtual 496	com/tencent/mm/storage/aj:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   614: checkcast 498	java/lang/Integer
    //   617: iconst_0
    //   618: invokestatic 501	com/tencent/mm/sdk/platformtools/bu:a	(Ljava/lang/Integer;I)I
    //   621: istore_1
    //   622: invokestatic 452	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   625: pop
    //   626: invokestatic 456	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   629: invokevirtual 489	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   632: ldc_w 921
    //   635: iload_1
    //   636: iconst_1
    //   637: iadd
    //   638: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: invokevirtual 920	com/tencent/mm/storage/aj:set	(ILjava/lang/Object;)V
    //   644: new 292	android/content/Intent
    //   647: dup
    //   648: invokespecial 475	android/content/Intent:<init>	()V
    //   651: astore 4
    //   653: aload 4
    //   655: ldc_w 923
    //   658: iconst_4
    //   659: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   662: pop
    //   663: aload 4
    //   665: ldc_w 925
    //   668: iconst_1
    //   669: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   672: pop
    //   673: aload 4
    //   675: ldc_w 927
    //   678: iconst_1
    //   679: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   682: pop
    //   683: getstatic 933	com/tencent/mm/plugin/sns/c/a:iUz	Lcom/tencent/mm/pluginsdk/m;
    //   686: aload_0
    //   687: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   690: aload_3
    //   691: aload 4
    //   693: invokestatic 277	com/tencent/mm/plugin/sns/model/ah:getAccSnsTmpPath	()Ljava/lang/String;
    //   696: iconst_4
    //   697: new 24	com/tencent/mm/plugin/sns/ui/SnsUIAction$2
    //   700: dup
    //   701: aload_0
    //   702: invokespecial 934	com/tencent/mm/plugin/sns/ui/SnsUIAction$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   705: invokeinterface 939 7 0
    //   710: ldc_w 821
    //   713: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: return
    //   717: new 198	com/tencent/mm/sdk/platformtools/aq
    //   720: dup
    //   721: invokestatic 204	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   724: invokespecial 207	com/tencent/mm/sdk/platformtools/aq:<init>	(Landroid/os/Looper;)V
    //   727: new 26	com/tencent/mm/plugin/sns/ui/SnsUIAction$3
    //   730: dup
    //   731: aload_0
    //   732: invokespecial 940	com/tencent/mm/plugin/sns/ui/SnsUIAction$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   735: invokevirtual 212	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
    //   738: pop
    //   739: aload_3
    //   740: ldc_w 942
    //   743: invokevirtual 946	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   746: astore 4
    //   748: aload_3
    //   749: ldc_w 948
    //   752: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   755: invokestatic 951	com/tencent/mm/plugin/sns/data/r:azC	(Ljava/lang/String;)V
    //   758: aload 4
    //   760: ifnull +11 -> 771
    //   763: aload 4
    //   765: invokevirtual 954	java/util/ArrayList:size	()I
    //   768: ifgt +16 -> 784
    //   771: aload_3
    //   772: ldc_w 956
    //   775: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   778: invokestatic 852	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   781: ifne +441 -> 1222
    //   784: aload 4
    //   786: ifnull +124 -> 910
    //   789: aload 4
    //   791: invokevirtual 954	java/util/ArrayList:size	()I
    //   794: ifle +116 -> 910
    //   797: aload 4
    //   799: iconst_0
    //   800: invokevirtual 958	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   803: checkcast 262	java/lang/String
    //   806: astore 4
    //   808: aload_3
    //   809: ldc_w 960
    //   812: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   815: astore 5
    //   817: aload 5
    //   819: invokestatic 852	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   822: ifne +14 -> 836
    //   825: aload 5
    //   827: astore_3
    //   828: aload 5
    //   830: invokestatic 963	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   833: ifne +189 -> 1022
    //   836: new 224	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   843: invokestatic 277	com/tencent/mm/plugin/sns/model/ah:getAccSnsTmpPath	()Ljava/lang/String;
    //   846: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload 4
    //   851: invokestatic 901	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   854: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: astore_3
    //   861: new 965	com/tencent/mm/compatible/h/d
    //   864: dup
    //   865: invokespecial 966	com/tencent/mm/compatible/h/d:<init>	()V
    //   868: astore 5
    //   870: aload 5
    //   872: aload 4
    //   874: invokevirtual 971	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   877: aload 5
    //   879: lconst_0
    //   880: invokevirtual 975	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   883: astore 6
    //   885: aload 6
    //   887: ifnonnull +43 -> 930
    //   890: ldc 214
    //   892: ldc_w 977
    //   895: invokestatic 835	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload 5
    //   900: invokevirtual 980	android/media/MediaMetadataRetriever:release	()V
    //   903: ldc_w 821
    //   906: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   909: return
    //   910: aload_3
    //   911: ldc_w 956
    //   914: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 4
    //   919: goto -111 -> 808
    //   922: astore_3
    //   923: ldc_w 821
    //   926: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: return
    //   930: ldc 214
    //   932: ldc_w 982
    //   935: iconst_2
    //   936: anewarray 4	java/lang/Object
    //   939: dup
    //   940: iconst_0
    //   941: aload 6
    //   943: invokevirtual 987	android/graphics/Bitmap:getWidth	()I
    //   946: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   949: aastore
    //   950: dup
    //   951: iconst_1
    //   952: aload 6
    //   954: invokevirtual 990	android/graphics/Bitmap:getHeight	()I
    //   957: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   960: aastore
    //   961: invokestatic 563	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   964: aload 6
    //   966: bipush 80
    //   968: getstatic 996	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   971: aload_3
    //   972: iconst_1
    //   973: invokestatic 1001	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   976: pop
    //   977: aload_3
    //   978: invokestatic 1005	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   981: astore 6
    //   983: ldc 214
    //   985: ldc_w 1007
    //   988: iconst_2
    //   989: anewarray 4	java/lang/Object
    //   992: dup
    //   993: iconst_0
    //   994: aload 6
    //   996: getfield 1012	android/graphics/BitmapFactory$Options:outWidth	I
    //   999: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1002: aastore
    //   1003: dup
    //   1004: iconst_1
    //   1005: aload 6
    //   1007: getfield 1015	android/graphics/BitmapFactory$Options:outHeight	I
    //   1010: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1013: aastore
    //   1014: invokestatic 563	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1017: aload 5
    //   1019: invokevirtual 980	android/media/MediaMetadataRetriever:release	()V
    //   1022: ldc 214
    //   1024: ldc_w 1017
    //   1027: iconst_4
    //   1028: anewarray 4	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload 4
    //   1035: aastore
    //   1036: dup
    //   1037: iconst_1
    //   1038: aload_3
    //   1039: aastore
    //   1040: dup
    //   1041: iconst_2
    //   1042: aload 4
    //   1044: invokestatic 1021	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1047: invokestatic 1026	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1050: aastore
    //   1051: dup
    //   1052: iconst_3
    //   1053: aload_3
    //   1054: invokestatic 1021	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1057: invokestatic 1026	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1060: aastore
    //   1061: invokestatic 563	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1064: new 292	android/content/Intent
    //   1067: dup
    //   1068: invokespecial 475	android/content/Intent:<init>	()V
    //   1071: astore 5
    //   1073: aload 5
    //   1075: ldc_w 864
    //   1078: aload 4
    //   1080: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1083: pop
    //   1084: aload 5
    //   1086: ldc_w 866
    //   1089: aload_3
    //   1090: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1093: pop
    //   1094: aload 5
    //   1096: ldc_w 871
    //   1099: aload 4
    //   1101: invokestatic 901	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   1104: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1107: pop
    //   1108: aload 5
    //   1110: ldc_w 303
    //   1113: iconst_1
    //   1114: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1117: pop
    //   1118: aload 5
    //   1120: ldc_w 309
    //   1123: invokestatic 314	com/tencent/mm/sdk/platformtools/bu:aRi	()J
    //   1126: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1129: pop
    //   1130: aload 5
    //   1132: ldc_w 873
    //   1135: bipush 14
    //   1137: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1140: pop
    //   1141: aload 5
    //   1143: ldc_w 337
    //   1146: iconst_0
    //   1147: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1150: pop
    //   1151: aload_0
    //   1152: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1155: ldc_w 889
    //   1158: ldc_w 891
    //   1161: aload 5
    //   1163: invokestatic 896	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1166: ldc_w 821
    //   1169: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1172: return
    //   1173: astore 6
    //   1175: ldc 214
    //   1177: ldc_w 1028
    //   1180: iconst_1
    //   1181: anewarray 4	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: aload 6
    //   1188: invokevirtual 906	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1191: aastore
    //   1192: invokestatic 1030	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1195: aload 5
    //   1197: invokevirtual 980	android/media/MediaMetadataRetriever:release	()V
    //   1200: goto -178 -> 1022
    //   1203: astore 5
    //   1205: goto -183 -> 1022
    //   1208: astore_3
    //   1209: aload 5
    //   1211: invokevirtual 980	android/media/MediaMetadataRetriever:release	()V
    //   1214: ldc_w 821
    //   1217: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1220: aload_3
    //   1221: athrow
    //   1222: aload_3
    //   1223: ldc_w 1032
    //   1226: invokevirtual 1036	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1229: ifnull +89 -> 1318
    //   1232: ldc 214
    //   1234: ldc_w 1038
    //   1237: invokestatic 825	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1240: new 292	android/content/Intent
    //   1243: dup
    //   1244: invokespecial 475	android/content/Intent:<init>	()V
    //   1247: astore 4
    //   1249: aload 4
    //   1251: ldc_w 337
    //   1254: iconst_0
    //   1255: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1258: pop
    //   1259: aload 4
    //   1261: ldc_w 303
    //   1264: iconst_1
    //   1265: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload 4
    //   1271: ldc_w 873
    //   1274: bipush 14
    //   1276: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload 4
    //   1282: ldc_w 1032
    //   1285: aload_3
    //   1286: ldc_w 1032
    //   1289: invokevirtual 1036	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1292: invokevirtual 1041	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   1295: pop
    //   1296: aload_0
    //   1297: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1300: ldc_w 889
    //   1303: ldc_w 891
    //   1306: aload 4
    //   1308: invokestatic 896	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1311: ldc_w 821
    //   1314: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1317: return
    //   1318: aload_3
    //   1319: ldc_w 1043
    //   1322: invokevirtual 946	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1325: astore 4
    //   1327: aload 4
    //   1329: ifnull +11 -> 1340
    //   1332: aload 4
    //   1334: invokevirtual 954	java/util/ArrayList:size	()I
    //   1337: ifne +18 -> 1355
    //   1340: ldc 214
    //   1342: ldc_w 1045
    //   1345: invokestatic 825	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1348: ldc_w 821
    //   1351: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1354: return
    //   1355: new 172	java/util/ArrayList
    //   1358: dup
    //   1359: invokespecial 173	java/util/ArrayList:<init>	()V
    //   1362: astore 5
    //   1364: aload 4
    //   1366: invokevirtual 1049	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1369: astore 6
    //   1371: aload 6
    //   1373: invokeinterface 1054 1 0
    //   1378: ifeq +76 -> 1454
    //   1381: aload 6
    //   1383: invokeinterface 1058 1 0
    //   1388: checkcast 262	java/lang/String
    //   1391: astore 7
    //   1393: aload 7
    //   1395: invokestatic 1064	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1398: invokevirtual 1068	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1401: astore 8
    //   1403: aload 8
    //   1405: ifnull -34 -> 1371
    //   1408: aload 5
    //   1410: ldc_w 1070
    //   1413: iconst_3
    //   1414: anewarray 4	java/lang/Object
    //   1417: dup
    //   1418: iconst_0
    //   1419: aload 7
    //   1421: aastore
    //   1422: dup
    //   1423: iconst_1
    //   1424: aload 8
    //   1426: getfield 1076	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1429: invokestatic 1081	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1432: aastore
    //   1433: dup
    //   1434: iconst_2
    //   1435: aload 8
    //   1437: getfield 1084	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1440: invokestatic 1081	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1443: aastore
    //   1444: invokestatic 1088	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1447: invokevirtual 706	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1450: pop
    //   1451: goto -80 -> 1371
    //   1454: aload_0
    //   1455: aload_3
    //   1456: ldc_w 1090
    //   1459: iconst_0
    //   1460: invokevirtual 1094	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1463: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zuv	Z
    //   1466: new 292	android/content/Intent
    //   1469: dup
    //   1470: aload_0
    //   1471: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1474: ldc_w 298
    //   1477: invokespecial 301	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1480: astore 6
    //   1482: aload 6
    //   1484: ldc_w 303
    //   1487: iconst_1
    //   1488: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1491: pop
    //   1492: aload 6
    //   1494: ldc_w 309
    //   1497: invokestatic 314	com/tencent/mm/sdk/platformtools/bu:aRi	()J
    //   1500: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1503: pop
    //   1504: aload_0
    //   1505: getfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFu	Lcom/tencent/mm/modelsns/e;
    //   1508: ifnull +20 -> 1528
    //   1511: aload_0
    //   1512: getfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFu	Lcom/tencent/mm/modelsns/e;
    //   1515: aload 6
    //   1517: ldc_w 319
    //   1520: invokevirtual 325	com/tencent/mm/modelsns/e:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1523: aload_0
    //   1524: aconst_null
    //   1525: putfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFu	Lcom/tencent/mm/modelsns/e;
    //   1528: aload_0
    //   1529: getfield 339	com/tencent/mm/plugin/sns/ui/SnsUIAction:Aiv	Z
    //   1532: ifeq +14 -> 1546
    //   1535: aload 6
    //   1537: ldc_w 341
    //   1540: bipush 11
    //   1542: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1545: pop
    //   1546: aload_3
    //   1547: ldc_w 290
    //   1550: iconst_0
    //   1551: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1554: istore_1
    //   1555: aload 6
    //   1557: ldc_w 1096
    //   1560: aload 4
    //   1562: invokevirtual 1099	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1565: pop
    //   1566: aload 6
    //   1568: ldc_w 332
    //   1571: iload_1
    //   1572: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1575: pop
    //   1576: aload_0
    //   1577: getfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zuv	Z
    //   1580: ifeq +13 -> 1593
    //   1583: aload 6
    //   1585: ldc_w 337
    //   1588: iconst_1
    //   1589: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1592: pop
    //   1593: aload 6
    //   1595: ldc_w 1101
    //   1598: aload 5
    //   1600: invokevirtual 1105	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1603: pop
    //   1604: ldc 214
    //   1606: ldc_w 1107
    //   1609: iconst_1
    //   1610: anewarray 4	java/lang/Object
    //   1613: dup
    //   1614: iconst_0
    //   1615: aload 6
    //   1617: ldc_w 873
    //   1620: iconst_m1
    //   1621: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1624: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1627: aastore
    //   1628: invokestatic 1109	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1631: aload_0
    //   1632: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1635: aload 6
    //   1637: bipush 6
    //   1639: invokevirtual 353	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1642: ldc_w 821
    //   1645: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1648: return
    //   1649: aload_3
    //   1650: ifnonnull +10 -> 1660
    //   1653: ldc_w 821
    //   1656: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1659: return
    //   1660: aload_0
    //   1661: aload_3
    //   1662: ldc_w 1111
    //   1665: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   1671: aload_0
    //   1672: aload_3
    //   1673: invokespecial 854	com/tencent/mm/plugin/sns/ui/SnsUIAction:aQ	(Landroid/content/Intent;)V
    //   1676: ldc_w 821
    //   1679: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1682: return
    //   1683: ldc 214
    //   1685: ldc_w 1113
    //   1688: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1691: aload_3
    //   1692: ifnonnull +10 -> 1702
    //   1695: ldc_w 821
    //   1698: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1701: return
    //   1702: aload_3
    //   1703: ldc_w 1115
    //   1706: iconst_m1
    //   1707: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1710: istore_1
    //   1711: aload_0
    //   1712: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFe	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1715: iload_1
    //   1716: aconst_null
    //   1717: aconst_null
    //   1718: invokeinterface 1118 4 0
    //   1723: invokestatic 1122	com/tencent/mm/plugin/sns/model/ah:dXA	()Lcom/tencent/mm/plugin/sns/model/bc;
    //   1726: invokevirtual 1127	com/tencent/mm/plugin/sns/model/bc:dWc	()V
    //   1729: ldc_w 821
    //   1732: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1735: return
    //   1736: ldc 214
    //   1738: ldc_w 1129
    //   1741: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1744: aload_0
    //   1745: getfield 722	com/tencent/mm/plugin/sns/ui/SnsUIAction:zIf	Lcom/tencent/mm/plugin/sns/ui/SnsHeader;
    //   1748: invokevirtual 727	com/tencent/mm/plugin/sns/ui/SnsHeader:efD	()V
    //   1751: invokestatic 1122	com/tencent/mm/plugin/sns/model/ah:dXA	()Lcom/tencent/mm/plugin/sns/model/bc;
    //   1754: invokevirtual 1127	com/tencent/mm/plugin/sns/model/bc:dWc	()V
    //   1757: ldc_w 821
    //   1760: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1763: return
    //   1764: aload_3
    //   1765: ifnonnull +10 -> 1775
    //   1768: ldc_w 821
    //   1771: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1774: return
    //   1775: ldc 214
    //   1777: ldc_w 1131
    //   1780: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1783: aload_3
    //   1784: ldc_w 1133
    //   1787: invokevirtual 841	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1790: checkcast 1135	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1793: astore_3
    //   1794: aload_3
    //   1795: ifnull +378 -> 2173
    //   1798: aload_0
    //   1799: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFe	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1802: iconst_m1
    //   1803: aload_3
    //   1804: getfield 1139	com/tencent/mm/plugin/sns/data/SnsCmdList:zub	Ljava/util/List;
    //   1807: aload_3
    //   1808: getfield 1142	com/tencent/mm/plugin/sns/data/SnsCmdList:zuc	Ljava/util/List;
    //   1811: invokeinterface 1118 4 0
    //   1816: ldc_w 821
    //   1819: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1822: return
    //   1823: invokestatic 1122	com/tencent/mm/plugin/sns/model/ah:dXA	()Lcom/tencent/mm/plugin/sns/model/bc;
    //   1826: invokevirtual 1127	com/tencent/mm/plugin/sns/model/bc:dWc	()V
    //   1829: aload_0
    //   1830: getfield 654	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1833: astore_3
    //   1834: new 1144	com/tencent/mm/hellhoundlib/b/a
    //   1837: dup
    //   1838: invokespecial 1145	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1841: aload_3
    //   1842: invokevirtual 1149	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1845: astore_3
    //   1846: new 4	java/lang/Object
    //   1849: dup
    //   1850: invokespecial 121	java/lang/Object:<init>	()V
    //   1853: astore 4
    //   1855: aload 4
    //   1857: aload_3
    //   1858: invokevirtual 1153	com/tencent/mm/hellhoundlib/b/a:ahE	()[Ljava/lang/Object;
    //   1861: ldc_w 753
    //   1864: ldc_w 1154
    //   1867: ldc_w 1155
    //   1870: ldc_w 1157
    //   1873: ldc_w 1159
    //   1876: ldc_w 1161
    //   1879: invokestatic 1164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1882: aload_3
    //   1883: iconst_0
    //   1884: invokevirtual 1167	com/tencent/mm/hellhoundlib/b/a:mt	(I)Ljava/lang/Object;
    //   1887: checkcast 656	android/widget/ListView
    //   1890: invokestatic 1171	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$c:b	(Landroid/widget/ListView;)V
    //   1893: aload 4
    //   1895: ldc_w 753
    //   1898: ldc_w 1154
    //   1901: ldc_w 1155
    //   1904: ldc_w 1157
    //   1907: ldc_w 1159
    //   1910: ldc_w 1161
    //   1913: invokestatic 1174	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1916: ldc_w 821
    //   1919: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1922: return
    //   1923: aload_3
    //   1924: ifnonnull +10 -> 1934
    //   1927: ldc_w 821
    //   1930: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1933: return
    //   1934: iload_2
    //   1935: iconst_m1
    //   1936: if_icmpne +237 -> 2173
    //   1939: aload_3
    //   1940: invokevirtual 1178	android/content/Intent:getData	()Landroid/net/Uri;
    //   1943: astore_3
    //   1944: aload_0
    //   1945: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1948: aload_3
    //   1949: aconst_null
    //   1950: aconst_null
    //   1951: aconst_null
    //   1952: aconst_null
    //   1953: invokevirtual 1182	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1956: astore_3
    //   1957: aload_3
    //   1958: invokeinterface 1187 1 0
    //   1963: ifeq +123 -> 2086
    //   1966: new 292	android/content/Intent
    //   1969: dup
    //   1970: ldc_w 1189
    //   1973: ldc_w 1191
    //   1976: aload_3
    //   1977: aload_3
    //   1978: ldc_w 1193
    //   1981: invokeinterface 1197 2 0
    //   1986: invokeinterface 1199 2 0
    //   1991: invokestatic 1202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1994: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1997: invokestatic 1208	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2000: invokespecial 1211	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   2003: astore 4
    //   2005: aload_0
    //   2006: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   2009: astore_3
    //   2010: new 1144	com/tencent/mm/hellhoundlib/b/a
    //   2013: dup
    //   2014: invokespecial 1145	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2017: aload 4
    //   2019: invokevirtual 1149	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2022: astore 4
    //   2024: aload_3
    //   2025: aload 4
    //   2027: invokevirtual 1153	com/tencent/mm/hellhoundlib/b/a:ahE	()[Ljava/lang/Object;
    //   2030: ldc_w 753
    //   2033: ldc_w 1154
    //   2036: ldc_w 1155
    //   2039: ldc_w 1213
    //   2042: ldc_w 1215
    //   2045: ldc_w 1216
    //   2048: invokestatic 1164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2051: aload_3
    //   2052: aload 4
    //   2054: iconst_0
    //   2055: invokevirtual 1167	com/tencent/mm/hellhoundlib/b/a:mt	(I)Ljava/lang/Object;
    //   2058: checkcast 292	android/content/Intent
    //   2061: invokevirtual 1218	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2064: aload_3
    //   2065: ldc_w 753
    //   2068: ldc_w 1154
    //   2071: ldc_w 1155
    //   2074: ldc_w 1213
    //   2077: ldc_w 1215
    //   2080: ldc_w 1216
    //   2083: invokestatic 1174	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2086: ldc_w 821
    //   2089: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2092: return
    //   2093: aload_3
    //   2094: ldc_w 1220
    //   2097: iconst_m1
    //   2098: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2101: istore_1
    //   2102: iload_1
    //   2103: ifle +70 -> 2173
    //   2106: ldc 214
    //   2108: ldc_w 1222
    //   2111: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2114: new 1135	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   2117: dup
    //   2118: invokespecial 1223	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   2121: astore_3
    //   2122: aload_3
    //   2123: iload_1
    //   2124: invokevirtual 1226	com/tencent/mm/plugin/sns/data/SnsCmdList:Qo	(I)V
    //   2127: aload_0
    //   2128: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AFe	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   2131: iconst_m1
    //   2132: aload_3
    //   2133: getfield 1139	com/tencent/mm/plugin/sns/data/SnsCmdList:zub	Ljava/util/List;
    //   2136: aload_3
    //   2137: getfield 1142	com/tencent/mm/plugin/sns/data/SnsCmdList:zuc	Ljava/util/List;
    //   2140: invokeinterface 1118 4 0
    //   2145: ldc_w 821
    //   2148: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2151: return
    //   2152: invokestatic 1230	com/tencent/mm/plugin/sns/model/ah:dXJ	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   2155: invokevirtual 1235	com/tencent/mm/plugin/sns/storage/k:bVZ	()Z
    //   2158: pop
    //   2159: ldc_w 821
    //   2162: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2165: return
    //   2166: ldc_w 821
    //   2169: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2172: return
    //   2173: ldc_w 821
    //   2176: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2179: return
    //   2180: astore 5
    //   2182: goto -1160 -> 1022
    //   2185: astore 4
    //   2187: goto -973 -> 1214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2190	0	this	SnsUIAction
    //   0	2190	1	paramInt1	int
    //   0	2190	2	paramInt2	int
    //   0	2190	3	paramIntent	Intent
    //   263	1790	4	localObject1	Object
    //   2185	1	4	localException1	java.lang.Exception
    //   177	1019	5	localObject2	Object
    //   1203	7	5	localException2	java.lang.Exception
    //   1362	237	5	localArrayList	ArrayList
    //   2180	1	5	localException3	java.lang.Exception
    //   883	123	6	localObject3	Object
    //   1173	14	6	localException4	java.lang.Exception
    //   1369	267	6	localObject4	Object
    //   1391	29	7	str	String
    //   1401	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   377	386	442	java/lang/Exception
    //   390	400	442	java/lang/Exception
    //   898	903	922	java/lang/Exception
    //   870	885	1173	java/lang/Exception
    //   890	898	1173	java/lang/Exception
    //   930	1017	1173	java/lang/Exception
    //   1195	1200	1203	java/lang/Exception
    //   870	885	1208	finally
    //   890	898	1208	finally
    //   930	1017	1208	finally
    //   1175	1195	1208	finally
    //   1017	1022	2180	java/lang/Exception
    //   1209	1214	2185	java/lang/Exception
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(99477);
    this.zop = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    this.ABC = ((int)(this.zop * 0.4D));
    ah.dXB().start();
    if (this.actionbarView != null) {
      this.AFf = ((Toolbar.LayoutParams)this.actionbarView.getLayoutParams());
    }
    this.list = this.AFe.getSnsListView();
    this.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99459);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        SnsUIAction.a(SnsUIAction.this).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        ah.dXt();
        u.hO(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        AppMethodBeat.o(99459);
      }
    });
    Object localObject = new StringBuilder("list is null ? ");
    boolean bool;
    label299:
    SnsHeader localSnsHeader;
    label460:
    String str3;
    String str2;
    String str1;
    if (this.list != null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsActivity", bool);
      this.list.setScrollingCacheEnabled(false);
      this.zIf = new SnsHeader(this.mActivity);
      this.zIf.setSessionId(this.sessionId);
      this.zIf.setEnterObjectId(this.zJR);
      this.zIf.setBackClickListener(new SnsHeader.a()
      {
        public final boolean AL(long paramAnonymousLong)
        {
          AppMethodBeat.i(99467);
          if ((SnsUIAction.b(SnsUIAction.this)) || (SnsUIAction.c(SnsUIAction.this).getType() == 1))
          {
            SnsUIAction.this.Sb(2);
            AppMethodBeat.o(99467);
            return false;
          }
          Object localObject1 = new com.tencent.mm.plugin.sns.storage.p();
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).field_snsId = paramAnonymousLong;
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName = SnsUIAction.d(SnsUIAction.this);
          Object localObject2 = com.tencent.mm.modelsns.h.aLJ();
          ((TimeLineObject)localObject2).nIJ = SnsUIAction.d(SnsUIAction.this);
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).f((TimeLineObject)localObject2);
          localObject2 = al.aAo(SnsUIAction.d(SnsUIAction.this));
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "friend like %s", new Object[] { SnsUIAction.d(SnsUIAction.this) });
          if (localObject2 == null) {
            ao.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 1, "", 0);
          }
          for (;;)
          {
            localObject1 = ah.dXI().aBw(SnsUIAction.d(SnsUIAction.this));
            ((n)localObject1).field_local_flag |= 0x2;
            ah.dXI().c((n)localObject1);
            SnsUIAction.e(SnsUIAction.this);
            com.tencent.mm.plugin.sns.j.e.zKO.zLc.emn = 1L;
            break;
            if (((com.tencent.mm.plugin.sns.storage.p)localObject2).ecn()) {
              ao.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 1, "", 0);
            } else {
              ao.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 5, "", 0);
            }
          }
        }
        
        public final boolean efF()
        {
          AppMethodBeat.i(99468);
          SnsUIAction.c(SnsUIAction.this).egJ();
          AppMethodBeat.o(99468);
          return false;
        }
      });
      this.cpn = this.AFe.egF();
      this.hcH = this.AFe.getMaskView();
      this.AEZ = new LoadingMoreView(this.mActivity);
      this.list.addHeaderView(this.zIf);
      this.list.addFooterView(this.AEZ);
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(99470);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt2);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt3);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          System.currentTimeMillis();
          localObject = SnsUIAction.this.zIf;
          if ((((SnsHeader)localObject).Auq != null) && (((SnsHeader)localObject).Auq.AuF != null) && (((SnsHeader)localObject).Aux)) {
            ((SnsHeader)localObject).Auq.AuF.ekt();
          }
          SnsUIAction.c(SnsUIAction.this).egK();
          SnsUIAction.this.AFd = (paramAnonymousInt1 + paramAnonymousInt2 - 1);
          if ((SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 3) && (SnsUIAction.this.list.getCount() != SnsUIAction.f(SnsUIAction.this)))
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(SnsUIAction.this.list.getCount()) });
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.list.getCount());
            SnsUIAction.g(SnsUIAction.this);
          }
          if (paramAnonymousAbsListView.getChildCount() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
          }
          int k = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 20);
          paramAnonymousInt2 = 0;
          float f2 = 1.0F;
          float f1 = 1.0F;
          int j = 1;
          paramAnonymousInt3 = 0;
          int m;
          int n;
          int i;
          label356:
          int i1;
          label402:
          float f3;
          if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
          {
            paramAnonymousInt3 = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 245);
            m = paramAnonymousInt3 - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 30);
            n = paramAnonymousInt3 - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 10);
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
            if (paramAnonymousAbsListView != null) {
              break label929;
            }
            i = 0;
            if (paramAnonymousInt1 <= SnsUIAction.h(SnsUIAction.this)) {
              break label938;
            }
            SnsUIAction.this.AFo = SnsUIAction.bJS();
            if (paramAnonymousAbsListView != null)
            {
              localObject = SnsUIAction.this;
              ((SnsUIAction)localObject).gim += paramAnonymousAbsListView.getHeight();
            }
            SnsUIAction.this.AFq = (-i + SnsUIAction.this.gim);
            SnsUIAction.b(SnsUIAction.this, paramAnonymousInt1);
            SnsUIAction.c(SnsUIAction.this, i);
            if (SnsUIAction.this.AFp != SnsUIAction.this.AFo)
            {
              SnsUIAction.this.start = SnsUIAction.this.AFq;
              SnsUIAction.this.AFr = false;
            }
            if (paramAnonymousInt1 != 0) {
              break label1204;
            }
            i1 = -paramAnonymousAbsListView.getTop();
            SnsUIAction.this.AFq = i1;
            if ((i1 < 0) || (i1 > m)) {
              break label1064;
            }
            f2 = 1.0F;
            f3 = 1.0F;
            label516:
            if ((i1 < 0) || (i1 > paramAnonymousInt3)) {
              break label1146;
            }
            paramAnonymousInt2 = 0;
            f1 = 0.0F;
            j = 0;
          }
          for (;;)
          {
            if (SnsUIAction.this.hcH != null)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(SnsUIAction.this.AFq), Integer.valueOf(i), Integer.valueOf(SnsUIAction.this.gim) });
              if ((SnsUIAction.this.AFq <= paramAnonymousInt3) && (!SnsUIAction.j(SnsUIAction.this))) {
                break label1216;
              }
              SnsUIAction.this.hcH.setVisibility(8);
            }
            label625:
            SnsUIAction.this.AFk = SnsUIAction.this.AFq;
            SnsUIAction.this.AFp = SnsUIAction.this.AFo;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) {
              break label1230;
            }
            paramAnonymousAbsListView = (SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this);
            label677:
            float f4 = f1;
            paramAnonymousInt3 = paramAnonymousInt2;
            float f5 = f2;
            if (paramAnonymousAbsListView != null)
            {
              if (SnsUIAction.j(SnsUIAction.this))
              {
                paramAnonymousInt2 = 100;
                f2 = 1.0F;
                f1 = 1.0F;
              }
              if (SnsUIAction.this.vRH != paramAnonymousInt2)
              {
                if (paramAnonymousInt2 > 0) {
                  break label1257;
                }
                paramAnonymousAbsListView.setActionbarColor(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131101053));
                label745:
                if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
                {
                  if (j == 0) {
                    break label1284;
                  }
                  paramAnonymousAbsListView.updateOptionMenuIcon(0, 2131690526);
                }
              }
              label770:
              SnsUIAction.c(SnsUIAction.this).hW(paramAnonymousInt1, paramAnonymousInt2);
              if (SnsUIAction.this.AFm != f1) {
                paramAnonymousAbsListView.setTitleAlpha(f1);
              }
              f4 = f1;
              paramAnonymousInt3 = paramAnonymousInt2;
              f5 = f2;
              if (SnsUIAction.this.AFl != f2)
              {
                paramAnonymousAbsListView.setIconAlpha(f2);
                f5 = f2;
                paramAnonymousInt3 = paramAnonymousInt2;
                f4 = f1;
              }
            }
            SnsUIAction.this.vRH = paramAnonymousInt3;
            SnsUIAction.this.AFl = f5;
            SnsUIAction.this.AFm = f4;
            SnsUIAction.this.AFn = f3;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
              break;
            }
            paramAnonymousInt3 = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 199);
            break;
            label929:
            i = paramAnonymousAbsListView.getTop();
            break label356;
            label938:
            if (paramAnonymousInt1 < SnsUIAction.h(SnsUIAction.this))
            {
              SnsUIAction.this.AFo = SnsUIAction.aNR();
              if (SnsUIAction.this.gim < paramAnonymousAbsListView.getHeight()) {
                break label402;
              }
              localObject = SnsUIAction.this;
              ((SnsUIAction)localObject).gim -= paramAnonymousAbsListView.getHeight();
              break label402;
            }
            if (Math.abs(i - SnsUIAction.i(SnsUIAction.this)) <= 1) {
              break label402;
            }
            if (i < SnsUIAction.i(SnsUIAction.this))
            {
              SnsUIAction.this.AFo = SnsUIAction.bJS();
              break label402;
            }
            if (i <= SnsUIAction.i(SnsUIAction.this)) {
              break label402;
            }
            SnsUIAction.this.AFo = SnsUIAction.aNR();
            break label402;
            label1064:
            if (i1 <= n)
            {
              f2 = 1.0F - (i1 - m) / (n - m);
              f3 = 1.0F - (i1 - m) / (n - m);
              break label516;
            }
            f1 = f2;
            if (i1 <= paramAnonymousInt3 + k) {
              f1 = (i1 - paramAnonymousInt3) * 1.0F / k;
            }
            f3 = 0.0F;
            f2 = f1;
            break label516;
            label1146:
            if (i1 > paramAnonymousInt3 + k) {
              break label1185;
            }
            paramAnonymousInt2 = (i1 - paramAnonymousInt3) * 100 / k;
            f1 = (i1 - paramAnonymousInt3) * 1.0F / k;
          }
          label1185:
          if (i1 > paramAnonymousInt3 + k) {
            paramAnonymousInt2 = 100;
          }
          for (;;)
          {
            f1 = 1.0F;
            break;
            label1204:
            paramAnonymousInt2 = 100;
            f3 = 0.0F;
            f2 = 1.0F;
            break;
            label1216:
            SnsUIAction.this.hcH.setVisibility(0);
            break label625;
            label1230:
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI))
            {
              paramAnonymousAbsListView = (SnsUserUI)SnsUIAction.a(SnsUIAction.this);
              break label677;
              label1257:
              paramAnonymousAbsListView.setActionbarColor(ao.eW(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131100705), paramAnonymousInt2));
              break label745;
              paramAnonymousAbsListView.updateOptionMenuIcon(0, 2131690361);
              break label770;
            }
            label1284:
            paramAnonymousAbsListView = null;
            break label677;
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(99469);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          SnsUIAction.c(SnsUIAction.this).RW(paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            if (((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).Asq != null)) {
              ((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).Asq.rq(true);
            }
            if (SnsUIAction.this.zIf != null)
            {
              paramAnonymousAbsListView = SnsUIAction.this.zIf;
              if ((paramAnonymousAbsListView.Auq != null) && (paramAnonymousAbsListView.Auq.AuG != null) && (!paramAnonymousAbsListView.Aux)) {
                paramAnonymousAbsListView.Auq.AuG.eiv();
              }
            }
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
            {
              paramAnonymousAbsListView = SnsUIAction.this;
              localObject1 = SnsUIAction.this.list;
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
              if (paramAnonymousAbsListView.AFt != null) {
                paramAnonymousAbsListView.AFt.clear();
              }
              j = -1;
              i = -1;
              int i1 = ((ListView)localObject1).getHeight();
              Object localObject2 = new Rect();
              if (paramAnonymousAbsListView.actionbarView == null) {
                break label755;
              }
              paramAnonymousAbsListView.actionbarView.getGlobalVisibleRect((Rect)localObject2);
              k = ((Rect)localObject2).bottom;
              int i2 = ((ListView)localObject1).getChildCount();
              m = 0;
              if (m < i2)
              {
                Object localObject3 = ((ListView)localObject1).getChildAt(m).getTag();
                if (!(localObject3 instanceof k.a)) {
                  break label752;
                }
                localObject3 = (k.a)localObject3;
                if (!(((k.a)localObject3).ANn instanceof com.tencent.mm.plugin.sns.ui.item.k)) {
                  break label752;
                }
                if (paramAnonymousAbsListView.AFt == null) {
                  paramAnonymousAbsListView.AFt = new ArrayList();
                }
                paramAnonymousAbsListView.AFt.add(localObject3);
                ((k.a)localObject3).AOK.getGlobalVisibleRect((Rect)localObject2);
                if (((Rect)localObject2).top < k) {
                  ((Rect)localObject2).top = k;
                }
                if (((Rect)localObject2).top > i1) {
                  ((Rect)localObject2).top = i1;
                }
                if (((Rect)localObject2).bottom < k) {
                  ((Rect)localObject2).bottom = k;
                }
                if (((Rect)localObject2).bottom > i1) {
                  ((Rect)localObject2).bottom = i1;
                }
                int n = Math.abs(((Rect)localObject2).bottom - ((Rect)localObject2).top);
                if (n < j) {
                  break label752;
                }
                i = paramAnonymousAbsListView.AFt.size() - 1;
                j = n;
                break label761;
              }
              if ((paramAnonymousAbsListView.AFt != null) && (paramAnonymousAbsListView.AFt.size() > 0) && (i >= 0))
              {
                j = 0;
                if (j >= paramAnonymousAbsListView.AFt.size()) {
                  break label662;
                }
                localObject1 = (k.a)paramAnonymousAbsListView.AFt.get(j);
                localObject2 = (com.tencent.mm.plugin.sns.ui.item.k)((k.a)localObject1).ANn;
                if (j == i) {
                  ((com.tencent.mm.plugin.sns.ui.item.k)localObject2).a(((k.a)localObject1).AOK, false);
                } else {
                  ((com.tencent.mm.plugin.sns.ui.item.k)localObject2).a(((k.a)localObject1).AOK, true);
                }
              }
            }
            catch (Throwable paramAnonymousAbsListView)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + paramAnonymousAbsListView.toString());
            }
            SnsUIAction.this.bns();
            if (paramAnonymousInt == 2)
            {
              com.tencent.mm.ci.d.fyy().gC(SnsUIAction.class.getName() + SnsUIAction.c(SnsUIAction.this).getType() + ".Listview", 4);
              SnsUIAction.this.sc(true);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V");
              AppMethodBeat.o(99469);
              return;
              label662:
              long l2 = System.currentTimeMillis();
              localObject1 = new StringBuilder("checkSphereImageCompItem cost=").append(l2 - l1).append(", maxVisiableItemIdx=").append(i).append(", size=");
              if (paramAnonymousAbsListView.AFt != null) {}
              for (i = paramAnonymousAbsListView.AFt.size();; i = 0)
              {
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivitySphereImageView", i);
                break;
              }
              SnsUIAction.this.sc(false);
            }
            label752:
            break label761;
            label755:
            int k = 0;
            continue;
            label761:
            m += 1;
            continue;
            j += 1;
          }
        }
      });
      this.vUa = this.AFe.egG();
      localObject = new StringBuilder("pullDownView is null ? ");
      if (this.vUa == null) {
        break label579;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsActivity", bool);
      this.vUa.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean ccs()
        {
          AppMethodBeat.i(99471);
          SnsUIAction.c(SnsUIAction.this).egI();
          AppMethodBeat.o(99471);
          return true;
        }
      });
      this.vUa.setTopViewVisible(false);
      this.vUa.setIsTopShowAll(false);
      this.vUa.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean ccr()
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
      this.vUa.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean ccq()
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
      this.vUa.setIsBottomShowAll(false);
      this.vUa.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean ccp()
        {
          AppMethodBeat.i(99474);
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.oRf);
          if (!SnsUIAction.this.oRf) {
            SnsUIAction.g(SnsUIAction.this);
          }
          AppMethodBeat.o(99474);
          return true;
        }
      });
      this.vUa.setShowBackground(true);
      this.vUa.setBgColor(ak.getContext().getResources().getColor(2131099650));
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localSnsHeader = this.zIf;
      if (!bu.isNullOrNil(this.lJm)) {
        break label584;
      }
      localObject = this.ABL;
      str3 = this.ABL;
      str2 = this.jtJ;
      str1 = this.cff;
      if ((localObject != null) && (str3 != null)) {
        break label592;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      this.zIf.setType(this.AFe.getType());
      this.zIf.efD();
      egV();
      if (Build.VERSION.SDK_INT >= 11) {
        break label847;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      ah.dXA().cBA.add(this);
      bc.zws += 1;
      ah.dXz().a(this);
      AppMethodBeat.o(99477);
      return;
      bool = false;
      break;
      label579:
      bool = false;
      break label299;
      label584:
      localObject = this.lJm;
      break label460;
      label592:
      localSnsHeader.userName = ((String)localObject).trim();
      localSnsHeader.fHO = str3.trim();
      localSnsHeader.dsB = str3.equals(localObject);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject).length() + "  " + (String)localObject);
      localSnsHeader.Auq.nHR.setText((CharSequence)localObject);
      if ((localSnsHeader.Auq == null) || (localSnsHeader.Auq.fTj == null)) {
        label683:
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)localObject);
          if ((localObject == null) || (bu.isNullOrNil(((an)localObject).adG()))) {
            break label838;
          }
        }
      }
      label838:
      for (localObject = ((an)localObject).adG();; localObject = r.N(str2))
      {
        localSnsHeader.Auq.nHR.setText(com.tencent.mm.pluginsdk.ui.span.k.c(localSnsHeader.context, (CharSequence)localObject));
        localSnsHeader.Auq.AfE.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localSnsHeader.context, str1, localSnsHeader.Auq.AfE.getTextSize()));
        localSnsHeader.Auq.fTj.setContentDescription(localSnsHeader.context.getString(2131763782, new Object[] { localSnsHeader.Auq.nHR.getText() }));
        break;
        a.b.w(localSnsHeader.Auq.fTj, localSnsHeader.userName);
        break label683;
      }
      label847:
      new SnsUIAction.7(this).run();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(99486);
    if (this.zIf != null)
    {
      Object localObject = this.zIf;
      if ((((SnsHeader)localObject).Auw != null) && (!((SnsHeader)localObject).Auw.isRecycled())) {
        ((SnsHeader)localObject).Auw.recycle();
      }
      if ((((SnsHeader)localObject).Auq != null) && (((SnsHeader)localObject).Auq.AuF != null) && (((SnsHeader)localObject).Aux)) {
        ((SnsHeader)localObject).Auq.AuF.onDestroyView();
      }
      if ((((SnsHeader)localObject).Auq != null) && (((SnsHeader)localObject).Auq.AuG != null) && (!((SnsHeader)localObject).Aux))
      {
        localObject = ((SnsHeader)localObject).Auq.AuG;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
        ((SnsStoryHeaderView)localObject).aMv = true;
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b((l.b)localObject);
      }
    }
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ah.dXB().aE(this.mActivity);
      ah.dXz().b(this);
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ah.dXA().cBA.remove(this);
      bc.zws -= 1;
    }
    this.AEZ.setVisibility(8);
    ae.edF();
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {
      ah.dXB().start();
    }
    this.list.setAdapter(null);
    r.azC("");
    AppMethodBeat.o(99486);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(99481);
    Object localObject = new oo();
    ((oo)localObject).dDz.dDA = false;
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    if (this.zIf != null)
    {
      localObject = this.zIf;
      if ((((SnsHeader)localObject).Auq != null) && (((SnsHeader)localObject).Auq.AuG != null) && (!((SnsHeader)localObject).Aux))
      {
        localObject = ((SnsHeader)localObject).Auq.AuG;
        ((SnsStoryHeaderView)localObject).ASW = false;
        ((SnsStoryHeaderView)localObject).dus = true;
      }
    }
    AppMethodBeat.o(99481);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(99480);
    ah.dXz().az(2, false);
    com.tencent.mm.pluginsdk.wallet.h.aad(7);
    oo localoo = new oo();
    localoo.dDz.dDA = true;
    com.tencent.mm.sdk.b.a.IvT.a(localoo, Looper.getMainLooper());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    if (this.zIf != null) {
      this.zIf.onResume();
    }
    AppMethodBeat.o(99480);
  }
  
  public final void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(99479);
    this.AFe.sc(paramBoolean);
    AppMethodBeat.o(99479);
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(179310);
    this.AmY = paramBoolean;
    if (paramBoolean)
    {
      if (this.vUa != null) {
        this.vUa.setEnableGesture(false);
      }
      localSnsHeader = this.zIf;
      if ((localSnsHeader.Auq != null) && (localSnsHeader.Auq.AuI != null) && (localSnsHeader.Auq.AuH != null))
      {
        localSnsHeader.Auq.AuI.setVisibility(0);
        localSnsHeader.Auq.AuH.setVisibility(8);
      }
      AppMethodBeat.o(179310);
      return;
    }
    if (this.vUa != null) {
      this.vUa.setEnableGesture(true);
    }
    SnsHeader localSnsHeader = this.zIf;
    if ((localSnsHeader.Auq != null) && (localSnsHeader.Auq.AuI != null) && (localSnsHeader.Auq.AuH != null))
    {
      localSnsHeader.Auq.AuI.setVisibility(4);
      localSnsHeader.Auq.AuH.setVisibility(0);
    }
    AppMethodBeat.o(179310);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(99482);
    this.sessionId = paramString;
    if (this.zIf != null) {
      this.zIf.setSessionId(paramString);
    }
    AppMethodBeat.o(99482);
  }
  
  public static abstract interface a
  {
    public abstract void RW(int paramInt);
    
    public abstract void a(m paramm);
    
    public abstract void aC(int paramInt, boolean paramBoolean);
    
    public abstract void e(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract void egE();
    
    public abstract View egF();
    
    public abstract MMPullDownView egG();
    
    public abstract boolean egH();
    
    public abstract void egI();
    
    public abstract void egJ();
    
    public abstract void egK();
    
    public abstract View getMaskView();
    
    public abstract ListView getSnsListView();
    
    public abstract int getType();
    
    public abstract void hW(int paramInt1, int paramInt2);
    
    public abstract void sc(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction
 * JD-Core Version:    0.7.0.1
 */