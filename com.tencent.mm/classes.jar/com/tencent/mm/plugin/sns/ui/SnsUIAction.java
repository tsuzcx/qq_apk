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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bb.a;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements b.b, bb.a
{
  private static int AnT = 0;
  private static int AnU = 1;
  private static int AnV = 2;
  private boolean AkA;
  private int AkB;
  private int Akq;
  private String Akz;
  protected LoadingMoreView AnM;
  private int AnN;
  private int AnO;
  private boolean AnP;
  public int AnQ;
  a AnR;
  private Toolbar.LayoutParams AnS;
  private int AnW;
  int AnX;
  float AnY;
  float AnZ;
  float Aoa;
  int Aob;
  int Aoc;
  int Aod;
  boolean Aoe;
  private com.tencent.e.i.b Aof;
  ArrayList<k.a> Aog;
  com.tencent.mm.modelsns.e Aoh;
  View actionbarView;
  private String cff;
  protected String filePath;
  protected View gZU;
  int gfU;
  private String jqQ;
  private String lEN;
  private int lastIndex;
  protected ListView list;
  private Activity mActivity;
  protected boolean oKD;
  protected View rxm;
  private String sessionId;
  int start;
  private ArrayList<com.tencent.mm.plugin.sns.storage.p> tHo;
  protected com.tencent.mm.ui.base.p tipDialog;
  protected String title;
  int vFD;
  protected MMPullDownView vHW;
  public int yXO;
  private boolean zRo;
  boolean zVQ;
  private boolean zdF;
  protected SnsHeader zqQ;
  String zsC;
  
  public SnsUIAction(Activity paramActivity)
  {
    AppMethodBeat.i(176361);
    this.tipDialog = null;
    this.AnN = 0;
    this.AnO = 0;
    this.AnP = false;
    this.oKD = false;
    this.zdF = false;
    this.yXO = 0;
    this.AnQ = 0;
    this.AnX = 0;
    this.vFD = 0;
    this.AnY = 1.0F;
    this.AnZ = 1.0F;
    this.Aoa = 1.0F;
    this.Aob = AnT;
    this.Aoc = AnT;
    this.Aod = 0;
    this.start = 0;
    this.gfU = 0;
    this.Aoe = false;
    this.Akq = 800;
    this.zVQ = false;
    this.tHo = new ArrayList();
    this.Aof = new com.tencent.e.i.b()
    {
      public final String getKey()
      {
        return "SnsUIAction#preloadRunnable";
      }
      
      public final void run()
      {
        AppMethodBeat.i(99475);
        Object localObject2 = ag.dUc();
        synchronized (((aw)localObject2).zmS)
        {
          ((aw)localObject2).zmS.clear();
          ??? = new ArrayList(SnsUIAction.k(SnsUIAction.this)).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.sns.storage.p)((Iterator)???).next();
            ag.dUc().A((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
        }
        AppMethodBeat.o(99475);
      }
    };
    this.Aog = null;
    this.Aoh = null;
    this.mActivity = paramActivity;
    AppMethodBeat.o(176361);
  }
  
  private void aP(Intent paramIntent)
  {
    AppMethodBeat.i(99484);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176355);
        com.tencent.mm.plugin.sns.c.a.iRH.MT();
        AppMethodBeat.o(176355);
      }
    });
    ad.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    ad.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null)
    {
      AppMethodBeat.o(99484);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.avU(this.filePath);
    localObject = "pre_temp_sns_pic" + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    u.aG(ag.getAccSnsTmpPath(), this.filePath, (String)localObject);
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.avS(this.filePath);
    this.filePath = (ag.getAccSnsTmpPath() + (String)localObject);
    ad.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", bt.aQJ());
      if (this.Aoh != null)
      {
        this.Aoh.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.Aoh = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.zdF) {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
      }
      if (this.zRo) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      this.mActivity.startActivityForResult((Intent)localObject, 6);
      this.zdF = false;
      AppMethodBeat.o(99484);
      return;
    }
  }
  
  protected final boolean Ru(int paramInt)
  {
    int j = 3;
    boolean bool1 = false;
    AppMethodBeat.i(99485);
    com.tencent.mm.kernel.g.ajD();
    if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
    {
      t.g(this.mActivity, null);
      AppMethodBeat.o(99485);
      return false;
    }
    ad.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(paramInt)));
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("username", this.Akz);
      localIntent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
      this.mActivity.startActivityForResult(localIntent, 7);
      AppMethodBeat.o(99485);
      return true;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.kernel.g.ajD();
      i = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68385, null), 0);
      com.tencent.mm.kernel.g.ajD();
      int k = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68386, null), 0);
      if ((!this.AnP) && (i < 3) && (k == 0))
      {
        this.AnP = true;
        bk.b(this.mActivity, new SnsUIAction.5(this, paramInt));
        AppMethodBeat.o(99485);
        return true;
      }
      if (this.mActivity.getSharedPreferences(aj.fkC(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
        com.tencent.mm.pluginsdk.ui.tools.q.c(this.mActivity, 2, null);
      }
    }
    else
    {
      AppMethodBeat.o(99485);
      return true;
    }
    int i = com.tencent.mm.n.g.acA().getInt("SnsCanPickVideoFromAlbum", 1);
    ad.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(i) });
    if (ac.iPN) {
      i = 0;
    }
    if (i == 1)
    {
      paramInt = j;
      label310:
      localIntent = new Intent();
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzh, false);
      if ((com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IDh, 0) != 1) && (!bool2)) {
        break label449;
      }
      i = 1;
      label363:
      if (i == 0) {
        bool1 = true;
      }
      localIntent.putExtra("key_can_select_video_and_pic", bool1);
      localIntent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.aGQ().aGT().duration);
      if (!(this.mActivity instanceof SnsUserUI)) {
        break label454;
      }
      localIntent.putExtra("gallery_report_tag", 17);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.mActivity, 14, 9, 4, paramInt, localIntent);
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
    this.Akz = paramString1;
    this.lEN = paramString2;
    this.jqQ = paramString3;
    this.cff = paramString4;
    this.AkA = paramBoolean1;
    this.zRo = paramBoolean2;
    this.AkB = paramInt;
  }
  
  protected final void aAI(String paramString)
  {
    AppMethodBeat.i(99490);
    ad.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.AnM.aAI(paramString);
    AppMethodBeat.o(99490);
  }
  
  protected final void aAU(String paramString)
  {
    AppMethodBeat.i(99488);
    ad.d("MicroMsg.SnsActivity", "snsactivty onIsDownAll ");
    this.AnM.aAI(paramString);
    AppMethodBeat.o(99488);
  }
  
  public final void ays(String paramString) {}
  
  public final void az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99495);
    this.AnR.az(paramInt, paramBoolean);
    AppMethodBeat.o(99495);
  }
  
  public final void bM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99497);
    if ((this.AnR.getType() == 1) && (this.list != null) && (this.list.getAdapter() != null) && ((this.list.getAdapter() instanceof c))) {
      ((c)this.list.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(99497);
  }
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void bmJ()
  {
    AppMethodBeat.i(99478);
    this.Aof.cancel();
    this.tHo.clear();
    int i = this.list.getLastVisiblePosition();
    ad.i("MicroMsg.SnsVideoService", "currentPosition :%d count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.list.getCount()) });
    int j = this.list.getCount();
    if (j - i > 15) {
      j = i + 15;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.list.getItemAtPosition(i);
        if (((localObject instanceof com.tencent.mm.plugin.sns.storage.p)) && (((com.tencent.mm.plugin.sns.storage.p)localObject).field_type == 15) && ((!((com.tencent.mm.plugin.sns.storage.p)localObject).QM(32)) || (com.tencent.mm.plugin.sns.ad.timeline.a.a.i((com.tencent.mm.plugin.sns.storage.p)localObject)))) {
          this.tHo.add((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        i += 1;
      }
      else
      {
        com.tencent.e.h.LTJ.aR(this.Aof);
        AppMethodBeat.o(99478);
        return;
      }
    }
  }
  
  public final void dTb()
  {
    AppMethodBeat.i(99487);
    this.zqQ.ebW();
    AppMethodBeat.o(99487);
  }
  
  public final void dVf()
  {
    AppMethodBeat.i(99496);
    if (this.zqQ != null) {
      this.zqQ.ebW();
    }
    AppMethodBeat.o(99496);
  }
  
  protected final void edn()
  {
    AppMethodBeat.i(160742);
    this.AnM.FW();
    AppMethodBeat.o(160742);
  }
  
  public final void edo()
  {
    AppMethodBeat.i(99491);
    if ((this.AnR != null) && (this.AnR.getType() == 2)) {
      ag.dFL().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99466);
          Object localObject2 = ag.dUi().aAg(SnsUIAction.d(SnsUIAction.this));
          final com.tencent.mm.plugin.sns.data.l locall = new com.tencent.mm.plugin.sns.data.l();
          ArrayList localArrayList;
          HashMap localHashMap;
          Object localObject1;
          String str;
          long l;
          if (!bt.hj((List)localObject2))
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localObject1 = "";
            Iterator localIterator = ((List)localObject2).iterator();
            if (localIterator.hasNext())
            {
              dhk localdhk = (dhk)localIterator.next();
              localObject2 = String.valueOf(localdhk.HvR);
              str = String.valueOf(localdhk.HvS);
              l = localdhk.HvT;
              if (bt.lQ((String)localObject1, (String)localObject2)) {
                break label281;
              }
              localArrayList = new ArrayList();
              localHashMap = new HashMap();
              locall.zdq.add(localObject2);
              locall.zdr.add(localArrayList);
              locall.map.put(localObject2, localHashMap);
              localObject1 = localObject2;
            }
          }
          label281:
          for (;;)
          {
            localArrayList.add(str);
            localHashMap.put(str, Long.valueOf(l));
            break;
            Collections.reverse(locall.zdq);
            Collections.reverse(locall.zdr);
            localObject1 = locall.zdr.iterator();
            while (((Iterator)localObject1).hasNext()) {
              Collections.reverse((List)((Iterator)localObject1).next());
            }
            ag.cVf().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176357);
                SnsUIAction.c(SnsUIAction.this).a(locall);
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
  
  public final void edp()
  {
    AppMethodBeat.i(99493);
    if (getSnsListView() != null) {
      getSnsListView().setVisibility(8);
    }
    AppMethodBeat.o(99493);
  }
  
  public final void edq()
  {
    AppMethodBeat.i(99494);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V", this);
    if (this.zqQ != null)
    {
      SnsHeader localSnsHeader = this.zqQ;
      if ((localSnsHeader.Ade != null) && (localSnsHeader.Ade.Adt != null) && (localSnsHeader.Adl)) {
        localSnsHeader.Ade.Adt.edq();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction", "com/tencent/mm/plugin/sns/ui/SnsUIAction", "resetStoryHeader", "()V");
    AppMethodBeat.o(99494);
  }
  
  public final void edr()
  {
    AppMethodBeat.i(198472);
    if (this.zqQ != null)
    {
      SnsHeader localSnsHeader = this.zqQ;
      if ((localSnsHeader.Ade != null) && (localSnsHeader.Ade.Adx != null) && (localSnsHeader.zSc != null))
      {
        localSnsHeader.zSc.cancel();
        localSnsHeader.zSc.reset();
        localSnsHeader.Ade.Adx.startAnimation(localSnsHeader.zSc);
      }
    }
    AppMethodBeat.o(198472);
  }
  
  public final void eds()
  {
    AppMethodBeat.i(198473);
    if (this.AnM != null)
    {
      LoadingMoreView localLoadingMoreView = this.AnM;
      localLoadingMoreView.zSc.cancel();
      localLoadingMoreView.zSc.reset();
      localLoadingMoreView.dwy.startAnimation(localLoadingMoreView.zSc);
    }
    AppMethodBeat.o(198473);
  }
  
  public final int getHeaderHeight()
  {
    AppMethodBeat.i(179311);
    if (this.zqQ != null)
    {
      int i = this.zqQ.getMeasuredHeight();
      AppMethodBeat.o(179311);
      return i;
    }
    AppMethodBeat.o(179311);
    return 0;
  }
  
  public ListView getSnsListView()
  {
    AppMethodBeat.i(99498);
    ListView localListView = this.AnR.getSnsListView();
    AppMethodBeat.o(99498);
    return localListView;
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 820
    //   3: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 214
    //   8: ldc_w 822
    //   11: iload_1
    //   12: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 824	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   41: new 198	com/tencent/mm/sdk/platformtools/ap
    //   44: dup
    //   45: invokestatic 204	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   48: invokespecial 207	com/tencent/mm/sdk/platformtools/ap:<init>	(Landroid/os/Looper;)V
    //   51: new 22	com/tencent/mm/plugin/sns/ui/SnsUIAction$15
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 825	com/tencent/mm/plugin/sns/ui/SnsUIAction$15:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   59: invokevirtual 212	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   62: pop
    //   63: invokestatic 830	com/tencent/mm/plugin/sns/data/q:dSQ	()V
    //   66: ldc_w 820
    //   69: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: iload_1
    //   74: tableswitch	default:+78 -> 152, 2:+512->586, 3:+78->152, 4:+1575->1649, 5:+391->465, 6:+1609->1683, 7:+1662->1736, 8:+1690->1764, 9:+1749->1823, 10:+1849->1923, 11:+78->152, 12:+2019->2093, 13:+2078->2152, 14:+643->717, 15:+2092->2166, 16:+78->152, 17:+93->167
    //   153: <illegal opcode>
    //   154: ldc_w 832
    //   157: invokestatic 834	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 820
    //   163: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: aload_3
    //   168: ldc_w 836
    //   171: invokevirtual 840	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   174: checkcast 842	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   177: astore 5
    //   179: aload 5
    //   181: ifnull +1992 -> 2173
    //   184: aload 5
    //   186: getfield 845	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMs	Z
    //   189: ifeq +39 -> 228
    //   192: aload_0
    //   193: aload 5
    //   195: getfield 848	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMA	Ljava/lang/String;
    //   198: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   205: invokestatic 851	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   208: ifne +1965 -> 2173
    //   211: aload_0
    //   212: iconst_1
    //   213: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zdF	Z
    //   216: aload_0
    //   217: aload_3
    //   218: invokespecial 853	com/tencent/mm/plugin/sns/ui/SnsUIAction:aP	(Landroid/content/Intent;)V
    //   221: ldc_w 820
    //   224: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: ldc 214
    //   230: ldc_w 855
    //   233: iconst_2
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload 5
    //   241: getfield 858	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMu	Ljava/lang/String;
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload 5
    //   249: getfield 861	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMv	Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 563	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: new 292	android/content/Intent
    //   259: dup
    //   260: invokespecial 475	android/content/Intent:<init>	()V
    //   263: astore 4
    //   265: aload 4
    //   267: ldc_w 863
    //   270: aload 5
    //   272: getfield 858	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMu	Ljava/lang/String;
    //   275: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   278: pop
    //   279: aload 4
    //   281: ldc_w 865
    //   284: aload 5
    //   286: getfield 861	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMv	Ljava/lang/String;
    //   289: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   292: pop
    //   293: aload 5
    //   295: getfield 868	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMx	Ljava/lang/String;
    //   298: invokestatic 851	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   301: ifne +121 -> 422
    //   304: aload 4
    //   306: ldc_w 870
    //   309: aload 5
    //   311: getfield 868	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMx	Ljava/lang/String;
    //   314: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: aload 4
    //   320: ldc_w 303
    //   323: iconst_1
    //   324: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   327: pop
    //   328: aload 4
    //   330: ldc_w 309
    //   333: invokestatic 314	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   336: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   339: pop
    //   340: aload 4
    //   342: ldc_w 872
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
    //   379: getfield 876	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMz	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   382: invokevirtual 881	com/tencent/mm/protocal/protobuf/bxm:toByteArray	()[B
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +13 -> 400
    //   390: aload 4
    //   392: ldc_w 883
    //   395: aload_3
    //   396: invokevirtual 886	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   399: pop
    //   400: aload_0
    //   401: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   404: ldc_w 888
    //   407: ldc_w 890
    //   410: aload 4
    //   412: invokestatic 895	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   415: ldc_w 820
    //   418: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    //   422: aload 4
    //   424: ldc_w 870
    //   427: aload 5
    //   429: getfield 858	com/tencent/mm/plugin/mmsight/SightCaptureResult:vMu	Ljava/lang/String;
    //   432: invokestatic 900	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   435: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   438: pop
    //   439: goto -121 -> 318
    //   442: astore_3
    //   443: ldc 214
    //   445: ldc_w 902
    //   448: iconst_1
    //   449: anewarray 4	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: aload_3
    //   455: invokevirtual 905	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   458: aastore
    //   459: invokestatic 563	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: goto -62 -> 400
    //   465: aload_0
    //   466: aload_0
    //   467: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   470: invokevirtual 909	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   473: aload_3
    //   474: invokestatic 277	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   477: invokestatic 912	com/tencent/mm/pluginsdk/ui/tools/q:i	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   480: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   483: ldc 214
    //   485: new 224	java/lang/StringBuilder
    //   488: dup
    //   489: ldc_w 914
    //   492: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   495: aload_0
    //   496: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   499: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 222	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload_0
    //   509: getfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   512: ifnonnull +10 -> 522
    //   515: ldc_w 820
    //   518: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: return
    //   522: invokestatic 452	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   525: pop
    //   526: invokestatic 456	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   529: invokevirtual 489	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   532: ldc_w 915
    //   535: aconst_null
    //   536: invokevirtual 496	com/tencent/mm/storage/ai:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   539: checkcast 498	java/lang/Integer
    //   542: iconst_0
    //   543: invokestatic 501	com/tencent/mm/sdk/platformtools/bt:a	(Ljava/lang/Integer;I)I
    //   546: istore_1
    //   547: invokestatic 452	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   550: pop
    //   551: invokestatic 456	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   554: invokevirtual 489	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   557: ldc_w 915
    //   560: iload_1
    //   561: iconst_1
    //   562: iadd
    //   563: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: invokevirtual 919	com/tencent/mm/storage/ai:set	(ILjava/lang/Object;)V
    //   569: aload_0
    //   570: iconst_1
    //   571: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zdF	Z
    //   574: aload_0
    //   575: aload_3
    //   576: invokespecial 853	com/tencent/mm/plugin/sns/ui/SnsUIAction:aP	(Landroid/content/Intent;)V
    //   579: ldc_w 820
    //   582: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: return
    //   586: aload_3
    //   587: ifnonnull +10 -> 597
    //   590: ldc_w 820
    //   593: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: return
    //   597: invokestatic 452	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   600: pop
    //   601: invokestatic 456	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   604: invokevirtual 489	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   607: ldc_w 920
    //   610: aconst_null
    //   611: invokevirtual 496	com/tencent/mm/storage/ai:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   614: checkcast 498	java/lang/Integer
    //   617: iconst_0
    //   618: invokestatic 501	com/tencent/mm/sdk/platformtools/bt:a	(Ljava/lang/Integer;I)I
    //   621: istore_1
    //   622: invokestatic 452	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   625: pop
    //   626: invokestatic 456	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   629: invokevirtual 489	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   632: ldc_w 920
    //   635: iload_1
    //   636: iconst_1
    //   637: iadd
    //   638: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: invokevirtual 919	com/tencent/mm/storage/ai:set	(ILjava/lang/Object;)V
    //   644: new 292	android/content/Intent
    //   647: dup
    //   648: invokespecial 475	android/content/Intent:<init>	()V
    //   651: astore 4
    //   653: aload 4
    //   655: ldc_w 922
    //   658: iconst_4
    //   659: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   662: pop
    //   663: aload 4
    //   665: ldc_w 924
    //   668: iconst_1
    //   669: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   672: pop
    //   673: aload 4
    //   675: ldc_w 926
    //   678: iconst_1
    //   679: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   682: pop
    //   683: getstatic 932	com/tencent/mm/plugin/sns/c/a:iRG	Lcom/tencent/mm/pluginsdk/m;
    //   686: aload_0
    //   687: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   690: aload_3
    //   691: aload 4
    //   693: invokestatic 277	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   696: iconst_4
    //   697: new 24	com/tencent/mm/plugin/sns/ui/SnsUIAction$2
    //   700: dup
    //   701: aload_0
    //   702: invokespecial 933	com/tencent/mm/plugin/sns/ui/SnsUIAction$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   705: invokeinterface 938 7 0
    //   710: ldc_w 820
    //   713: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: return
    //   717: new 198	com/tencent/mm/sdk/platformtools/ap
    //   720: dup
    //   721: invokestatic 204	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   724: invokespecial 207	com/tencent/mm/sdk/platformtools/ap:<init>	(Landroid/os/Looper;)V
    //   727: new 26	com/tencent/mm/plugin/sns/ui/SnsUIAction$3
    //   730: dup
    //   731: aload_0
    //   732: invokespecial 939	com/tencent/mm/plugin/sns/ui/SnsUIAction$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   735: invokevirtual 212	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   738: pop
    //   739: aload_3
    //   740: ldc_w 941
    //   743: invokevirtual 945	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   746: astore 4
    //   748: aload_3
    //   749: ldc_w 947
    //   752: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   755: invokestatic 950	com/tencent/mm/plugin/sns/data/q:ayl	(Ljava/lang/String;)V
    //   758: aload 4
    //   760: ifnull +11 -> 771
    //   763: aload 4
    //   765: invokevirtual 953	java/util/ArrayList:size	()I
    //   768: ifgt +16 -> 784
    //   771: aload_3
    //   772: ldc_w 955
    //   775: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   778: invokestatic 851	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   781: ifne +441 -> 1222
    //   784: aload 4
    //   786: ifnull +124 -> 910
    //   789: aload 4
    //   791: invokevirtual 953	java/util/ArrayList:size	()I
    //   794: ifle +116 -> 910
    //   797: aload 4
    //   799: iconst_0
    //   800: invokevirtual 957	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   803: checkcast 262	java/lang/String
    //   806: astore 4
    //   808: aload_3
    //   809: ldc_w 959
    //   812: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   815: astore 5
    //   817: aload 5
    //   819: invokestatic 851	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   822: ifne +14 -> 836
    //   825: aload 5
    //   827: astore_3
    //   828: aload 5
    //   830: invokestatic 962	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   833: ifne +189 -> 1022
    //   836: new 224	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   843: invokestatic 277	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   846: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload 4
    //   851: invokestatic 900	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   854: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: astore_3
    //   861: new 964	com/tencent/mm/compatible/h/d
    //   864: dup
    //   865: invokespecial 965	com/tencent/mm/compatible/h/d:<init>	()V
    //   868: astore 5
    //   870: aload 5
    //   872: aload 4
    //   874: invokevirtual 970	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   877: aload 5
    //   879: lconst_0
    //   880: invokevirtual 974	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   883: astore 6
    //   885: aload 6
    //   887: ifnonnull +43 -> 930
    //   890: ldc 214
    //   892: ldc_w 976
    //   895: invokestatic 834	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload 5
    //   900: invokevirtual 979	android/media/MediaMetadataRetriever:release	()V
    //   903: ldc_w 820
    //   906: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   909: return
    //   910: aload_3
    //   911: ldc_w 955
    //   914: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   917: astore 4
    //   919: goto -111 -> 808
    //   922: astore_3
    //   923: ldc_w 820
    //   926: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: return
    //   930: ldc 214
    //   932: ldc_w 981
    //   935: iconst_2
    //   936: anewarray 4	java/lang/Object
    //   939: dup
    //   940: iconst_0
    //   941: aload 6
    //   943: invokevirtual 986	android/graphics/Bitmap:getWidth	()I
    //   946: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   949: aastore
    //   950: dup
    //   951: iconst_1
    //   952: aload 6
    //   954: invokevirtual 989	android/graphics/Bitmap:getHeight	()I
    //   957: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   960: aastore
    //   961: invokestatic 563	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   964: aload 6
    //   966: bipush 80
    //   968: getstatic 995	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   971: aload_3
    //   972: iconst_1
    //   973: invokestatic 1000	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   976: pop
    //   977: aload_3
    //   978: invokestatic 1004	com/tencent/mm/sdk/platformtools/g:aQc	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   981: astore 6
    //   983: ldc 214
    //   985: ldc_w 1006
    //   988: iconst_2
    //   989: anewarray 4	java/lang/Object
    //   992: dup
    //   993: iconst_0
    //   994: aload 6
    //   996: getfield 1011	android/graphics/BitmapFactory$Options:outWidth	I
    //   999: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1002: aastore
    //   1003: dup
    //   1004: iconst_1
    //   1005: aload 6
    //   1007: getfield 1014	android/graphics/BitmapFactory$Options:outHeight	I
    //   1010: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1013: aastore
    //   1014: invokestatic 563	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1017: aload 5
    //   1019: invokevirtual 979	android/media/MediaMetadataRetriever:release	()V
    //   1022: ldc 214
    //   1024: ldc_w 1016
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
    //   1044: invokestatic 1020	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   1047: invokestatic 1025	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1050: aastore
    //   1051: dup
    //   1052: iconst_3
    //   1053: aload_3
    //   1054: invokestatic 1020	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   1057: invokestatic 1025	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1060: aastore
    //   1061: invokestatic 563	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1064: new 292	android/content/Intent
    //   1067: dup
    //   1068: invokespecial 475	android/content/Intent:<init>	()V
    //   1071: astore 5
    //   1073: aload 5
    //   1075: ldc_w 863
    //   1078: aload 4
    //   1080: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1083: pop
    //   1084: aload 5
    //   1086: ldc_w 865
    //   1089: aload_3
    //   1090: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1093: pop
    //   1094: aload 5
    //   1096: ldc_w 870
    //   1099: aload 4
    //   1101: invokestatic 900	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
    //   1104: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1107: pop
    //   1108: aload 5
    //   1110: ldc_w 303
    //   1113: iconst_1
    //   1114: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1117: pop
    //   1118: aload 5
    //   1120: ldc_w 309
    //   1123: invokestatic 314	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   1126: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1129: pop
    //   1130: aload 5
    //   1132: ldc_w 872
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
    //   1155: ldc_w 888
    //   1158: ldc_w 890
    //   1161: aload 5
    //   1163: invokestatic 895	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1166: ldc_w 820
    //   1169: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1172: return
    //   1173: astore 6
    //   1175: ldc 214
    //   1177: ldc_w 1027
    //   1180: iconst_1
    //   1181: anewarray 4	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: aload 6
    //   1188: invokevirtual 905	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1191: aastore
    //   1192: invokestatic 1029	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1195: aload 5
    //   1197: invokevirtual 979	android/media/MediaMetadataRetriever:release	()V
    //   1200: goto -178 -> 1022
    //   1203: astore 5
    //   1205: goto -183 -> 1022
    //   1208: astore_3
    //   1209: aload 5
    //   1211: invokevirtual 979	android/media/MediaMetadataRetriever:release	()V
    //   1214: ldc_w 820
    //   1217: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1220: aload_3
    //   1221: athrow
    //   1222: aload_3
    //   1223: ldc_w 1031
    //   1226: invokevirtual 1035	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1229: ifnull +89 -> 1318
    //   1232: ldc 214
    //   1234: ldc_w 1037
    //   1237: invokestatic 824	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1271: ldc_w 872
    //   1274: bipush 14
    //   1276: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload 4
    //   1282: ldc_w 1031
    //   1285: aload_3
    //   1286: ldc_w 1031
    //   1289: invokevirtual 1035	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1292: invokevirtual 1040	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   1295: pop
    //   1296: aload_0
    //   1297: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1300: ldc_w 888
    //   1303: ldc_w 890
    //   1306: aload 4
    //   1308: invokestatic 895	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1311: ldc_w 820
    //   1314: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1317: return
    //   1318: aload_3
    //   1319: ldc_w 1042
    //   1322: invokevirtual 945	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1325: astore 4
    //   1327: aload 4
    //   1329: ifnull +11 -> 1340
    //   1332: aload 4
    //   1334: invokevirtual 953	java/util/ArrayList:size	()I
    //   1337: ifne +18 -> 1355
    //   1340: ldc 214
    //   1342: ldc_w 1044
    //   1345: invokestatic 824	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1348: ldc_w 820
    //   1351: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1354: return
    //   1355: new 172	java/util/ArrayList
    //   1358: dup
    //   1359: invokespecial 173	java/util/ArrayList:<init>	()V
    //   1362: astore 5
    //   1364: aload 4
    //   1366: invokevirtual 1048	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1369: astore 6
    //   1371: aload 6
    //   1373: invokeinterface 1053 1 0
    //   1378: ifeq +76 -> 1454
    //   1381: aload 6
    //   1383: invokeinterface 1057 1 0
    //   1388: checkcast 262	java/lang/String
    //   1391: astore 7
    //   1393: aload 7
    //   1395: invokestatic 1063	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1398: invokevirtual 1067	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1401: astore 8
    //   1403: aload 8
    //   1405: ifnull -34 -> 1371
    //   1408: aload 5
    //   1410: ldc_w 1069
    //   1413: iconst_3
    //   1414: anewarray 4	java/lang/Object
    //   1417: dup
    //   1418: iconst_0
    //   1419: aload 7
    //   1421: aastore
    //   1422: dup
    //   1423: iconst_1
    //   1424: aload 8
    //   1426: getfield 1075	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1429: invokestatic 1080	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1432: aastore
    //   1433: dup
    //   1434: iconst_2
    //   1435: aload 8
    //   1437: getfield 1083	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1440: invokestatic 1080	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1443: aastore
    //   1444: invokestatic 1087	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1447: invokevirtual 705	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1450: pop
    //   1451: goto -80 -> 1371
    //   1454: aload_0
    //   1455: aload_3
    //   1456: ldc_w 1089
    //   1459: iconst_0
    //   1460: invokevirtual 1093	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1463: putfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zdF	Z
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
    //   1497: invokestatic 314	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
    //   1500: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1503: pop
    //   1504: aload_0
    //   1505: getfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:Aoh	Lcom/tencent/mm/modelsns/e;
    //   1508: ifnull +20 -> 1528
    //   1511: aload_0
    //   1512: getfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:Aoh	Lcom/tencent/mm/modelsns/e;
    //   1515: aload 6
    //   1517: ldc_w 319
    //   1520: invokevirtual 325	com/tencent/mm/modelsns/e:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1523: aload_0
    //   1524: aconst_null
    //   1525: putfield 184	com/tencent/mm/plugin/sns/ui/SnsUIAction:Aoh	Lcom/tencent/mm/modelsns/e;
    //   1528: aload_0
    //   1529: getfield 339	com/tencent/mm/plugin/sns/ui/SnsUIAction:zRo	Z
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
    //   1557: ldc_w 1095
    //   1560: aload 4
    //   1562: invokevirtual 1098	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1565: pop
    //   1566: aload 6
    //   1568: ldc_w 332
    //   1571: iload_1
    //   1572: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1575: pop
    //   1576: aload_0
    //   1577: getfield 140	com/tencent/mm/plugin/sns/ui/SnsUIAction:zdF	Z
    //   1580: ifeq +13 -> 1593
    //   1583: aload 6
    //   1585: ldc_w 337
    //   1588: iconst_1
    //   1589: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1592: pop
    //   1593: aload 6
    //   1595: ldc_w 1100
    //   1598: aload 5
    //   1600: invokevirtual 1104	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1603: pop
    //   1604: ldc 214
    //   1606: ldc_w 1106
    //   1609: iconst_1
    //   1610: anewarray 4	java/lang/Object
    //   1613: dup
    //   1614: iconst_0
    //   1615: aload 6
    //   1617: ldc_w 872
    //   1620: iconst_m1
    //   1621: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1624: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1627: aastore
    //   1628: invokestatic 1108	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1631: aload_0
    //   1632: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1635: aload 6
    //   1637: bipush 6
    //   1639: invokevirtual 353	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1642: ldc_w 820
    //   1645: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1648: return
    //   1649: aload_3
    //   1650: ifnonnull +10 -> 1660
    //   1653: ldc_w 820
    //   1656: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1659: return
    //   1660: aload_0
    //   1661: aload_3
    //   1662: ldc_w 1110
    //   1665: invokevirtual 347	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1668: putfield 231	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   1671: aload_0
    //   1672: aload_3
    //   1673: invokespecial 853	com/tencent/mm/plugin/sns/ui/SnsUIAction:aP	(Landroid/content/Intent;)V
    //   1676: ldc_w 820
    //   1679: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1682: return
    //   1683: ldc 214
    //   1685: ldc_w 1112
    //   1688: invokestatic 222	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1691: aload_3
    //   1692: ifnonnull +10 -> 1702
    //   1695: ldc_w 820
    //   1698: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1701: return
    //   1702: aload_3
    //   1703: ldc_w 1114
    //   1706: iconst_m1
    //   1707: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1710: istore_1
    //   1711: aload_0
    //   1712: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AnR	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1715: iload_1
    //   1716: aconst_null
    //   1717: aconst_null
    //   1718: invokeinterface 1117 4 0
    //   1723: invokestatic 1121	com/tencent/mm/plugin/sns/model/ag:dUa	()Lcom/tencent/mm/plugin/sns/model/bb;
    //   1726: invokevirtual 1126	com/tencent/mm/plugin/sns/model/bb:dSE	()V
    //   1729: ldc_w 820
    //   1732: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1735: return
    //   1736: ldc 214
    //   1738: ldc_w 1128
    //   1741: invokestatic 222	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1744: aload_0
    //   1745: getfield 721	com/tencent/mm/plugin/sns/ui/SnsUIAction:zqQ	Lcom/tencent/mm/plugin/sns/ui/SnsHeader;
    //   1748: invokevirtual 726	com/tencent/mm/plugin/sns/ui/SnsHeader:ebW	()V
    //   1751: invokestatic 1121	com/tencent/mm/plugin/sns/model/ag:dUa	()Lcom/tencent/mm/plugin/sns/model/bb;
    //   1754: invokevirtual 1126	com/tencent/mm/plugin/sns/model/bb:dSE	()V
    //   1757: ldc_w 820
    //   1760: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1763: return
    //   1764: aload_3
    //   1765: ifnonnull +10 -> 1775
    //   1768: ldc_w 820
    //   1771: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1774: return
    //   1775: ldc 214
    //   1777: ldc_w 1130
    //   1780: invokestatic 222	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1783: aload_3
    //   1784: ldc_w 1132
    //   1787: invokevirtual 840	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1790: checkcast 1134	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1793: astore_3
    //   1794: aload_3
    //   1795: ifnull +378 -> 2173
    //   1798: aload_0
    //   1799: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AnR	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1802: iconst_m1
    //   1803: aload_3
    //   1804: getfield 1138	com/tencent/mm/plugin/sns/data/SnsCmdList:zdl	Ljava/util/List;
    //   1807: aload_3
    //   1808: getfield 1141	com/tencent/mm/plugin/sns/data/SnsCmdList:zdm	Ljava/util/List;
    //   1811: invokeinterface 1117 4 0
    //   1816: ldc_w 820
    //   1819: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1822: return
    //   1823: invokestatic 1121	com/tencent/mm/plugin/sns/model/ag:dUa	()Lcom/tencent/mm/plugin/sns/model/bb;
    //   1826: invokevirtual 1126	com/tencent/mm/plugin/sns/model/bb:dSE	()V
    //   1829: aload_0
    //   1830: getfield 653	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1833: astore_3
    //   1834: new 1143	com/tencent/mm/hellhoundlib/b/a
    //   1837: dup
    //   1838: invokespecial 1144	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1841: aload_3
    //   1842: invokevirtual 1148	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1845: astore_3
    //   1846: new 4	java/lang/Object
    //   1849: dup
    //   1850: invokespecial 121	java/lang/Object:<init>	()V
    //   1853: astore 4
    //   1855: aload 4
    //   1857: aload_3
    //   1858: invokevirtual 1152	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
    //   1861: ldc_w 752
    //   1864: ldc_w 1153
    //   1867: ldc_w 1154
    //   1870: ldc_w 1156
    //   1873: ldc_w 1158
    //   1876: ldc_w 1160
    //   1879: invokestatic 1163	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1882: aload_3
    //   1883: iconst_0
    //   1884: invokevirtual 1166	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
    //   1887: checkcast 655	android/widget/ListView
    //   1890: invokestatic 1170	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$c:b	(Landroid/widget/ListView;)V
    //   1893: aload 4
    //   1895: ldc_w 752
    //   1898: ldc_w 1153
    //   1901: ldc_w 1154
    //   1904: ldc_w 1156
    //   1907: ldc_w 1158
    //   1910: ldc_w 1160
    //   1913: invokestatic 1173	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1916: ldc_w 820
    //   1919: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1922: return
    //   1923: aload_3
    //   1924: ifnonnull +10 -> 1934
    //   1927: ldc_w 820
    //   1930: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1933: return
    //   1934: iload_2
    //   1935: iconst_m1
    //   1936: if_icmpne +237 -> 2173
    //   1939: aload_3
    //   1940: invokevirtual 1177	android/content/Intent:getData	()Landroid/net/Uri;
    //   1943: astore_3
    //   1944: aload_0
    //   1945: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1948: aload_3
    //   1949: aconst_null
    //   1950: aconst_null
    //   1951: aconst_null
    //   1952: aconst_null
    //   1953: invokevirtual 1181	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1956: astore_3
    //   1957: aload_3
    //   1958: invokeinterface 1186 1 0
    //   1963: ifeq +123 -> 2086
    //   1966: new 292	android/content/Intent
    //   1969: dup
    //   1970: ldc_w 1188
    //   1973: ldc_w 1190
    //   1976: aload_3
    //   1977: aload_3
    //   1978: ldc_w 1192
    //   1981: invokeinterface 1196 2 0
    //   1986: invokeinterface 1198 2 0
    //   1991: invokestatic 1201	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1994: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1997: invokestatic 1207	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   2000: invokespecial 1210	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   2003: astore 4
    //   2005: aload_0
    //   2006: getfield 186	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   2009: astore_3
    //   2010: new 1143	com/tencent/mm/hellhoundlib/b/a
    //   2013: dup
    //   2014: invokespecial 1144	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2017: aload 4
    //   2019: invokevirtual 1148	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2022: astore 4
    //   2024: aload_3
    //   2025: aload 4
    //   2027: invokevirtual 1152	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
    //   2030: ldc_w 752
    //   2033: ldc_w 1153
    //   2036: ldc_w 1154
    //   2039: ldc_w 1212
    //   2042: ldc_w 1214
    //   2045: ldc_w 1215
    //   2048: invokestatic 1163	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2051: aload_3
    //   2052: aload 4
    //   2054: iconst_0
    //   2055: invokevirtual 1166	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
    //   2058: checkcast 292	android/content/Intent
    //   2061: invokevirtual 1217	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2064: aload_3
    //   2065: ldc_w 752
    //   2068: ldc_w 1153
    //   2071: ldc_w 1154
    //   2074: ldc_w 1212
    //   2077: ldc_w 1214
    //   2080: ldc_w 1215
    //   2083: invokestatic 1173	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2086: ldc_w 820
    //   2089: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2092: return
    //   2093: aload_3
    //   2094: ldc_w 1219
    //   2097: iconst_m1
    //   2098: invokevirtual 296	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2101: istore_1
    //   2102: iload_1
    //   2103: ifle +70 -> 2173
    //   2106: ldc 214
    //   2108: ldc_w 1221
    //   2111: invokestatic 222	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2114: new 1134	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   2117: dup
    //   2118: invokespecial 1222	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   2121: astore_3
    //   2122: aload_3
    //   2123: iload_1
    //   2124: invokevirtual 1225	com/tencent/mm/plugin/sns/data/SnsCmdList:PH	(I)V
    //   2127: aload_0
    //   2128: getfield 363	com/tencent/mm/plugin/sns/ui/SnsUIAction:AnR	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   2131: iconst_m1
    //   2132: aload_3
    //   2133: getfield 1138	com/tencent/mm/plugin/sns/data/SnsCmdList:zdl	Ljava/util/List;
    //   2136: aload_3
    //   2137: getfield 1141	com/tencent/mm/plugin/sns/data/SnsCmdList:zdm	Ljava/util/List;
    //   2140: invokeinterface 1117 4 0
    //   2145: ldc_w 820
    //   2148: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2151: return
    //   2152: invokestatic 1229	com/tencent/mm/plugin/sns/model/ag:dUj	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   2155: invokevirtual 1234	com/tencent/mm/plugin/sns/storage/k:bUK	()Z
    //   2158: pop
    //   2159: ldc_w 820
    //   2162: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2165: return
    //   2166: ldc_w 820
    //   2169: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2172: return
    //   2173: ldc_w 820
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
    this.yXO = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    this.Akq = ((int)(this.yXO * 0.4D));
    ag.dUb().start();
    if (this.actionbarView != null) {
      this.AnS = ((Toolbar.LayoutParams)this.actionbarView.getLayoutParams());
    }
    this.list = this.AnR.getSnsListView();
    this.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99459);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        SnsUIAction.a(SnsUIAction.this).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        ag.dTT();
        u.hL(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
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
      ad.i("MicroMsg.SnsActivity", bool);
      this.list.setScrollingCacheEnabled(false);
      this.zqQ = new SnsHeader(this.mActivity);
      this.zqQ.setSessionId(this.sessionId);
      this.zqQ.setEnterObjectId(this.zsC);
      this.zqQ.setBackClickListener(new SnsHeader.a()
      {
        public final boolean An(long paramAnonymousLong)
        {
          AppMethodBeat.i(99467);
          if ((SnsUIAction.b(SnsUIAction.this)) || (SnsUIAction.c(SnsUIAction.this).getType() == 1))
          {
            SnsUIAction.this.Ru(2);
            AppMethodBeat.o(99467);
            return false;
          }
          Object localObject1 = new com.tencent.mm.plugin.sns.storage.p();
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).field_snsId = paramAnonymousLong;
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName = SnsUIAction.d(SnsUIAction.this);
          Object localObject2 = com.tencent.mm.modelsns.h.aLm();
          ((TimeLineObject)localObject2).nDo = SnsUIAction.d(SnsUIAction.this);
          ((com.tencent.mm.plugin.sns.storage.p)localObject1).f((TimeLineObject)localObject2);
          localObject2 = ak.ayX(SnsUIAction.d(SnsUIAction.this));
          ad.d("MicroMsg.SnsActivity", "friend like %s", new Object[] { SnsUIAction.d(SnsUIAction.this) });
          if (localObject2 == null) {
            an.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 1, "", 0);
          }
          for (;;)
          {
            localObject1 = ag.dUi().aAf(SnsUIAction.d(SnsUIAction.this));
            ((n)localObject1).field_local_flag |= 0x2;
            ag.dUi().c((n)localObject1);
            SnsUIAction.e(SnsUIAction.this);
            com.tencent.mm.plugin.sns.j.e.ztz.ztL.ekG = 1L;
            break;
            if (((com.tencent.mm.plugin.sns.storage.p)localObject2).dYJ()) {
              an.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 1, "", 0);
            } else {
              an.a.a((com.tencent.mm.plugin.sns.storage.p)localObject1, 5, "", 0);
            }
          }
        }
        
        public final boolean ebY()
        {
          AppMethodBeat.i(99468);
          SnsUIAction.c(SnsUIAction.this).edc();
          AppMethodBeat.o(99468);
          return false;
        }
      });
      this.rxm = this.AnR.ecY();
      this.gZU = this.AnR.getMaskView();
      this.AnM = new LoadingMoreView(this.mActivity);
      this.list.addHeaderView(this.zqQ);
      this.list.addFooterView(this.AnM);
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(99470);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAbsListView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt2);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt3);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          System.currentTimeMillis();
          localObject = SnsUIAction.this.zqQ;
          if ((((SnsHeader)localObject).Ade != null) && (((SnsHeader)localObject).Ade.Adt != null) && (((SnsHeader)localObject).Adl)) {
            ((SnsHeader)localObject).Ade.Adt.egL();
          }
          SnsUIAction.c(SnsUIAction.this).edd();
          SnsUIAction.this.AnQ = (paramAnonymousInt1 + paramAnonymousInt2 - 1);
          if ((SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 3) && (SnsUIAction.this.list.getCount() != SnsUIAction.f(SnsUIAction.this)))
          {
            ad.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(SnsUIAction.this.list.getCount()) });
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.list.getCount());
            SnsUIAction.g(SnsUIAction.this);
          }
          if (paramAnonymousAbsListView.getChildCount() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
          }
          int k = com.tencent.mm.cc.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 20);
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
            paramAnonymousInt3 = com.tencent.mm.cc.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 245);
            m = paramAnonymousInt3 - com.tencent.mm.cc.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 30);
            n = paramAnonymousInt3 - com.tencent.mm.cc.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 10);
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
            if (paramAnonymousAbsListView != null) {
              break label929;
            }
            i = 0;
            if (paramAnonymousInt1 <= SnsUIAction.h(SnsUIAction.this)) {
              break label938;
            }
            SnsUIAction.this.Aob = SnsUIAction.bIU();
            if (paramAnonymousAbsListView != null)
            {
              localObject = SnsUIAction.this;
              ((SnsUIAction)localObject).gfU += paramAnonymousAbsListView.getHeight();
            }
            SnsUIAction.this.Aod = (-i + SnsUIAction.this.gfU);
            SnsUIAction.b(SnsUIAction.this, paramAnonymousInt1);
            SnsUIAction.c(SnsUIAction.this, i);
            if (SnsUIAction.this.Aoc != SnsUIAction.this.Aob)
            {
              SnsUIAction.this.start = SnsUIAction.this.Aod;
              SnsUIAction.this.Aoe = false;
            }
            if (paramAnonymousInt1 != 0) {
              break label1204;
            }
            i1 = -paramAnonymousAbsListView.getTop();
            SnsUIAction.this.Aod = i1;
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
            if (SnsUIAction.this.gZU != null)
            {
              ad.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(SnsUIAction.this.Aod), Integer.valueOf(i), Integer.valueOf(SnsUIAction.this.gfU) });
              if ((SnsUIAction.this.Aod <= paramAnonymousInt3) && (!SnsUIAction.j(SnsUIAction.this))) {
                break label1216;
              }
              SnsUIAction.this.gZU.setVisibility(8);
            }
            label625:
            SnsUIAction.this.AnX = SnsUIAction.this.Aod;
            SnsUIAction.this.Aoc = SnsUIAction.this.Aob;
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
              if (SnsUIAction.this.vFD != paramAnonymousInt2)
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
              SnsUIAction.c(SnsUIAction.this).hT(paramAnonymousInt1, paramAnonymousInt2);
              if (SnsUIAction.this.AnZ != f1) {
                paramAnonymousAbsListView.setTitleAlpha(f1);
              }
              f4 = f1;
              paramAnonymousInt3 = paramAnonymousInt2;
              f5 = f2;
              if (SnsUIAction.this.AnY != f2)
              {
                paramAnonymousAbsListView.setIconAlpha(f2);
                f5 = f2;
                paramAnonymousInt3 = paramAnonymousInt2;
                f4 = f1;
              }
            }
            SnsUIAction.this.vFD = paramAnonymousInt3;
            SnsUIAction.this.AnY = f5;
            SnsUIAction.this.AnZ = f4;
            SnsUIAction.this.Aoa = f3;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScroll", "(Landroid/widget/AbsListView;III)V");
            AppMethodBeat.o(99470);
            return;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
              break;
            }
            paramAnonymousInt3 = com.tencent.mm.cc.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 199);
            break;
            label929:
            i = paramAnonymousAbsListView.getTop();
            break label356;
            label938:
            if (paramAnonymousInt1 < SnsUIAction.h(SnsUIAction.this))
            {
              SnsUIAction.this.Aob = SnsUIAction.aNt();
              if (SnsUIAction.this.gfU < paramAnonymousAbsListView.getHeight()) {
                break label402;
              }
              localObject = SnsUIAction.this;
              ((SnsUIAction)localObject).gfU -= paramAnonymousAbsListView.getHeight();
              break label402;
            }
            if (Math.abs(i - SnsUIAction.i(SnsUIAction.this)) <= 1) {
              break label402;
            }
            if (i < SnsUIAction.i(SnsUIAction.this))
            {
              SnsUIAction.this.Aob = SnsUIAction.bIU();
              break label402;
            }
            if (i <= SnsUIAction.i(SnsUIAction.this)) {
              break label402;
            }
            SnsUIAction.this.Aob = SnsUIAction.aNt();
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
            SnsUIAction.this.gZU.setVisibility(0);
            break label625;
            label1230:
            if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI))
            {
              paramAnonymousAbsListView = (SnsUserUI)SnsUIAction.a(SnsUIAction.this);
              break label677;
              label1257:
              paramAnonymousAbsListView.setActionbarColor(ao.eV(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131100705), paramAnonymousInt2));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          SnsUIAction.c(SnsUIAction.this).Rp(paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            if (((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).Abd != null)) {
              ((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).Abd.rj(true);
            }
            if (SnsUIAction.this.zqQ != null)
            {
              paramAnonymousAbsListView = SnsUIAction.this.zqQ;
              if ((paramAnonymousAbsListView.Ade != null) && (paramAnonymousAbsListView.Ade.Adu != null) && (!paramAnonymousAbsListView.Adl)) {
                paramAnonymousAbsListView.Ade.Adu.eeO();
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
              if (paramAnonymousAbsListView.Aog != null) {
                paramAnonymousAbsListView.Aog.clear();
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
                if (!(((k.a)localObject3).AvW instanceof com.tencent.mm.plugin.sns.ui.item.k)) {
                  break label752;
                }
                if (paramAnonymousAbsListView.Aog == null) {
                  paramAnonymousAbsListView.Aog = new ArrayList();
                }
                paramAnonymousAbsListView.Aog.add(localObject3);
                ((k.a)localObject3).Axr.getGlobalVisibleRect((Rect)localObject2);
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
                i = paramAnonymousAbsListView.Aog.size() - 1;
                j = n;
                break label761;
              }
              if ((paramAnonymousAbsListView.Aog != null) && (paramAnonymousAbsListView.Aog.size() > 0) && (i >= 0))
              {
                j = 0;
                if (j >= paramAnonymousAbsListView.Aog.size()) {
                  break label662;
                }
                localObject1 = (k.a)paramAnonymousAbsListView.Aog.get(j);
                localObject2 = (com.tencent.mm.plugin.sns.ui.item.k)((k.a)localObject1).AvW;
                if (j == i) {
                  ((com.tencent.mm.plugin.sns.ui.item.k)localObject2).a(((k.a)localObject1).Axr, false);
                } else {
                  ((com.tencent.mm.plugin.sns.ui.item.k)localObject2).a(((k.a)localObject1).Axr, true);
                }
              }
            }
            catch (Throwable paramAnonymousAbsListView)
            {
              ad.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + paramAnonymousAbsListView.toString());
            }
            SnsUIAction.this.bmJ();
            if (paramAnonymousInt == 2)
            {
              com.tencent.mm.cj.d.fux().gt(SnsUIAction.class.getName() + SnsUIAction.c(SnsUIAction.this).getType() + ".Listview", 4);
              SnsUIAction.this.rV(true);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$3", "com/tencent/mm/plugin/sns/ui/SnsUIAction$android/widget/AbsListView$OnScrollListener", "onScrollStateChanged", "(Landroid/widget/AbsListView;I)V");
              AppMethodBeat.o(99469);
              return;
              label662:
              long l2 = System.currentTimeMillis();
              localObject1 = new StringBuilder("checkSphereImageCompItem cost=").append(l2 - l1).append(", maxVisiableItemIdx=").append(i).append(", size=");
              if (paramAnonymousAbsListView.Aog != null) {}
              for (i = paramAnonymousAbsListView.Aog.size();; i = 0)
              {
                ad.d("MicroMsg.SnsActivitySphereImageView", i);
                break;
              }
              SnsUIAction.this.rV(false);
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
      this.vHW = this.AnR.ecZ();
      localObject = new StringBuilder("pullDownView is null ? ");
      if (this.vHW == null) {
        break label579;
      }
      bool = true;
      ad.i("MicroMsg.SnsActivity", bool);
      this.vHW.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean cbd()
        {
          AppMethodBeat.i(99471);
          SnsUIAction.c(SnsUIAction.this).edb();
          AppMethodBeat.o(99471);
          return true;
        }
      });
      this.vHW.setTopViewVisible(false);
      this.vHW.setIsTopShowAll(false);
      this.vHW.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cbc()
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
      this.vHW.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cbb()
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
      this.vHW.setIsBottomShowAll(false);
      this.vHW.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean cba()
        {
          AppMethodBeat.i(99474);
          ad.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + SnsUIAction.this.oKD);
          if (!SnsUIAction.this.oKD) {
            SnsUIAction.g(SnsUIAction.this);
          }
          AppMethodBeat.o(99474);
          return true;
        }
      });
      this.vHW.setShowBackground(true);
      this.vHW.setBgColor(aj.getContext().getResources().getColor(2131099650));
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localSnsHeader = this.zqQ;
      if (!bt.isNullOrNil(this.lEN)) {
        break label584;
      }
      localObject = this.Akz;
      str3 = this.Akz;
      str2 = this.jqQ;
      str1 = this.cff;
      if ((localObject != null) && (str3 != null)) {
        break label592;
      }
      ad.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      this.zqQ.setType(this.AnR.getType());
      this.zqQ.ebW();
      edo();
      if (Build.VERSION.SDK_INT >= 11) {
        break label847;
      }
      ad.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      ag.dUa().cAT.add(this);
      bb.zfC += 1;
      ag.dTZ().a(this);
      AppMethodBeat.o(99477);
      return;
      bool = false;
      break;
      label579:
      bool = false;
      break label299;
      label584:
      localObject = this.lEN;
      break label460;
      label592:
      localSnsHeader.userName = ((String)localObject).trim();
      localSnsHeader.fFK = str3.trim();
      localSnsHeader.drv = str3.equals(localObject);
      ad.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject).length() + "  " + (String)localObject);
      localSnsHeader.Ade.nCw.setText((CharSequence)localObject);
      if ((localSnsHeader.Ade == null) || (localSnsHeader.Ade.fRd == null)) {
        label683:
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject);
          if ((localObject == null) || (bt.isNullOrNil(((am)localObject).adv()))) {
            break label838;
          }
        }
      }
      label838:
      for (localObject = ((am)localObject).adv();; localObject = com.tencent.mm.plugin.sns.data.q.O(str2))
      {
        localSnsHeader.Ade.nCw.setText(com.tencent.mm.pluginsdk.ui.span.k.c(localSnsHeader.context, (CharSequence)localObject));
        localSnsHeader.Ade.zOx.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localSnsHeader.context, str1, localSnsHeader.Ade.zOx.getTextSize()));
        localSnsHeader.Ade.fRd.setContentDescription(localSnsHeader.context.getString(2131763782, new Object[] { localSnsHeader.Ade.nCw.getText() }));
        break;
        a.b.w(localSnsHeader.Ade.fRd, localSnsHeader.userName);
        break label683;
      }
      label847:
      new SnsUIAction.7(this).run();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(99486);
    if (this.zqQ != null)
    {
      Object localObject = this.zqQ;
      if ((((SnsHeader)localObject).Adk != null) && (!((SnsHeader)localObject).Adk.isRecycled())) {
        ((SnsHeader)localObject).Adk.recycle();
      }
      if ((((SnsHeader)localObject).Ade != null) && (((SnsHeader)localObject).Ade.Adt != null) && (((SnsHeader)localObject).Adl)) {
        ((SnsHeader)localObject).Ade.Adt.onDestroyView();
      }
      if ((((SnsHeader)localObject).Ade != null) && (((SnsHeader)localObject).Ade.Adu != null) && (!((SnsHeader)localObject).Adl))
      {
        localObject = ((SnsHeader)localObject).Ade.Adu;
        ad.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
        ((SnsStoryHeaderView)localObject).aMv = true;
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b((l.b)localObject);
      }
    }
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      ag.dUb().aD(this.mActivity);
      ag.dTZ().b(this);
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      ag.dUa().cAT.remove(this);
      bb.zfC -= 1;
    }
    this.AnM.setVisibility(8);
    ae.dZZ();
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.kernel.g.ajA().aiK()) {
      ag.dUb().start();
    }
    this.list.setAdapter(null);
    com.tencent.mm.plugin.sns.data.q.ayl("");
    AppMethodBeat.o(99486);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(99481);
    Object localObject = new on();
    ((on)localObject).dCu.dCv = false;
    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    ad.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    if (this.zqQ != null)
    {
      localObject = this.zqQ;
      if ((((SnsHeader)localObject).Ade != null) && (((SnsHeader)localObject).Ade.Adu != null) && (!((SnsHeader)localObject).Adl))
      {
        localObject = ((SnsHeader)localObject).Ade.Adu;
        ((SnsStoryHeaderView)localObject).ABv = false;
        ((SnsStoryHeaderView)localObject).dtm = true;
      }
    }
    AppMethodBeat.o(99481);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(99480);
    ag.dTZ().aw(2, false);
    com.tencent.mm.pluginsdk.wallet.h.Zx(7);
    on localon = new on();
    localon.dCu.dCv = true;
    com.tencent.mm.sdk.b.a.IbL.a(localon, Looper.getMainLooper());
    ad.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    if (this.zqQ != null) {
      this.zqQ.onResume();
    }
    AppMethodBeat.o(99480);
  }
  
  public final void rV(boolean paramBoolean)
  {
    AppMethodBeat.i(99479);
    this.AnR.rV(paramBoolean);
    AppMethodBeat.o(99479);
  }
  
  public final void rW(boolean paramBoolean)
  {
    AppMethodBeat.i(179310);
    this.zVQ = paramBoolean;
    if (paramBoolean)
    {
      if (this.vHW != null) {
        this.vHW.setEnableGesture(false);
      }
      localSnsHeader = this.zqQ;
      if ((localSnsHeader.Ade != null) && (localSnsHeader.Ade.Adw != null) && (localSnsHeader.Ade.Adv != null))
      {
        localSnsHeader.Ade.Adw.setVisibility(0);
        localSnsHeader.Ade.Adv.setVisibility(8);
      }
      AppMethodBeat.o(179310);
      return;
    }
    if (this.vHW != null) {
      this.vHW.setEnableGesture(true);
    }
    SnsHeader localSnsHeader = this.zqQ;
    if ((localSnsHeader.Ade != null) && (localSnsHeader.Ade.Adw != null) && (localSnsHeader.Ade.Adv != null))
    {
      localSnsHeader.Ade.Adw.setVisibility(4);
      localSnsHeader.Ade.Adv.setVisibility(0);
    }
    AppMethodBeat.o(179310);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(99482);
    this.sessionId = paramString;
    if (this.zqQ != null) {
      this.zqQ.setSessionId(paramString);
    }
    AppMethodBeat.o(99482);
  }
  
  public static abstract interface a
  {
    public abstract void Rp(int paramInt);
    
    public abstract void a(com.tencent.mm.plugin.sns.data.l paraml);
    
    public abstract void az(int paramInt, boolean paramBoolean);
    
    public abstract void e(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract void ecX();
    
    public abstract View ecY();
    
    public abstract MMPullDownView ecZ();
    
    public abstract boolean eda();
    
    public abstract void edb();
    
    public abstract void edc();
    
    public abstract void edd();
    
    public abstract View getMaskView();
    
    public abstract ListView getSnsListView();
    
    public abstract int getType();
    
    public abstract void hT(int paramInt1, int paramInt2);
    
    public abstract void rV(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction
 * JD-Core Version:    0.7.0.1
 */