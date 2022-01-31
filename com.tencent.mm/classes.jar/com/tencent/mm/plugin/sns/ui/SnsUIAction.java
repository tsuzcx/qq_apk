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
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ax.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.story.api.k.b;
import com.tencent.mm.plugin.story.api.k.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SnsUIAction
  implements ax.a, b.b
{
  private static int saU = 0;
  private static int saV = 1;
  private static int saW = 2;
  View actionbarView;
  private String cpW;
  protected String filePath;
  private String gJX;
  private String ikj;
  protected View jbK;
  int jgE = 0;
  protected boolean kyS = false;
  private int lastIndex;
  protected ListView list;
  private Activity mActivity;
  private String mSignature;
  protected View mwU;
  protected MMPullDownView oCa;
  int ozS = 0;
  public int qYs = 0;
  private boolean rHl;
  private String rXD;
  private boolean rXE;
  private int rXF;
  private int rXu = 800;
  private boolean rbv = false;
  protected SnsHeader rmc;
  String rnO;
  protected LoadingMoreView saO;
  private int saP = 0;
  private boolean saQ = false;
  public int saR = 0;
  a saS;
  private Toolbar.LayoutParams saT;
  private int saX;
  int saY = 0;
  float saZ = 1.0F;
  float sba = 1.0F;
  int sbb = saU;
  int sbc = saU;
  int sbd = 0;
  boolean sbe = false;
  ArrayList<h.a> sbf = null;
  com.tencent.mm.modelsns.b sbg = null;
  int start = 0;
  protected p tipDialog = null;
  protected String title;
  
  public SnsUIAction(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private void ao(Intent paramIntent)
  {
    AppMethodBeat.i(39660);
    new ak(Looper.getMainLooper()).post(new SnsUIAction.3(this));
    ab.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    ab.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null)
    {
      AppMethodBeat.o(39660);
      return;
    }
    Object localObject = "pre_temp_sns_pic" + com.tencent.mm.a.g.w(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    s.an(ag.getAccSnsTmpPath(), this.filePath, (String)localObject);
    this.filePath = (ag.getAccSnsTmpPath() + (String)localObject);
    ab.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", bo.aox());
      if (this.sbg != null)
      {
        this.sbg.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.sbg = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.rbv) {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
      }
      if (this.rHl) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      this.mActivity.startActivityForResult((Intent)localObject, 6);
      this.rbv = false;
      AppMethodBeat.o(39660);
      return;
    }
  }
  
  protected final boolean Fd(int paramInt)
  {
    int i = 3;
    int j = 0;
    AppMethodBeat.i(39661);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      t.ii(this.mActivity);
      AppMethodBeat.o(39661);
      return false;
    }
    ab.d("MicroMsg.SnsActivity", "selectPhoto ".concat(String.valueOf(paramInt)));
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("username", this.rXD);
      localIntent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
      this.mActivity.startActivityForResult(localIntent, 7);
      AppMethodBeat.o(39661);
      return true;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.kernel.g.RM();
      int k = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(68385, null), 0);
      com.tencent.mm.kernel.g.RM();
      int m = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(68386, null), 0);
      if ((!this.saQ) && (k < 3) && (m == 0))
      {
        this.saQ = true;
        az.b(this.mActivity, new SnsUIAction.4(this, paramInt));
        AppMethodBeat.o(39661);
        return true;
      }
      if (this.mActivity.getSharedPreferences(ah.dsP(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
        n.a(this.mActivity, 2, null);
      }
    }
    else
    {
      AppMethodBeat.o(39661);
      return true;
    }
    paramInt = com.tencent.mm.m.g.Nq().getInt("SnsCanPickVideoFromAlbum", 1);
    ab.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(paramInt) });
    if (ae.glE) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt == 1) {}
      for (;;)
      {
        localIntent = new Intent();
        localIntent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.afW().afZ().duration);
        n.a(this.mActivity, 14, 9, 4, i, localIntent);
        break;
        if (paramInt == 0) {
          i = 1;
        }
      }
    }
  }
  
  public final void ZU(String paramString) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.rXD = paramString1;
    this.ikj = paramString2;
    this.gJX = paramString3;
    this.mSignature = paramString4;
    this.rXE = paramBoolean1;
    this.rHl = paramBoolean2;
    this.rXF = paramInt;
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(39666);
    this.saS.af(paramInt, paramBoolean);
    AppMethodBeat.o(39666);
  }
  
  protected final void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(138387);
    ab.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.saO.bf(paramInt, paramString);
    AppMethodBeat.o(138387);
  }
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39668);
    if ((this.saS.getType() == 1) && (this.list != null) && (this.list.getAdapter() != null) && ((this.list.getAdapter() instanceof c))) {
      ((c)this.list.getAdapter()).notifyDataSetChanged();
    }
    AppMethodBeat.o(39668);
  }
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV()
  {
    AppMethodBeat.i(39663);
    this.rmc.cvh();
    AppMethodBeat.o(39663);
  }
  
  public final void cpO()
  {
    AppMethodBeat.i(39667);
    if (this.rmc != null) {
      this.rmc.cvh();
    }
    AppMethodBeat.o(39667);
  }
  
  public ListView getSnsListView()
  {
    AppMethodBeat.i(39669);
    ListView localListView = this.saS.getSnsListView();
    AppMethodBeat.o(39669);
    return localListView;
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(39655);
    this.saS.lG(paramBoolean);
    AppMethodBeat.o(39655);
  }
  
  protected final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(39664);
    ab.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
    this.saO.lu(paramBoolean);
    AppMethodBeat.o(39664);
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 606
    //   3: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 168
    //   8: ldc_w 608
    //   11: iload_1
    //   12: invokestatic 412	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: invokevirtual 415	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 610	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iload_2
    //   22: iconst_m1
    //   23: if_icmpeq +47 -> 70
    //   26: iload_1
    //   27: iconst_5
    //   28: if_icmpeq +13 -> 41
    //   31: iload_1
    //   32: iconst_2
    //   33: if_icmpeq +8 -> 41
    //   36: iload_1
    //   37: iconst_4
    //   38: if_icmpne +25 -> 63
    //   41: new 148	com/tencent/mm/sdk/platformtools/ak
    //   44: dup
    //   45: invokestatic 154	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   48: invokespecial 157	com/tencent/mm/sdk/platformtools/ak:<init>	(Landroid/os/Looper;)V
    //   51: new 612	com/tencent/mm/plugin/sns/ui/SnsUIAction$12
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 613	com/tencent/mm/plugin/sns/ui/SnsUIAction$12:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   59: invokevirtual 166	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   62: pop
    //   63: ldc_w 606
    //   66: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: iload_1
    //   71: tableswitch	default:+77 -> 148, 2:+509->580, 3:+77->148, 4:+1469->1540, 5:+388->459, 6:+1503->1574, 7:+1556->1627, 8:+1584->1655, 9:+1643->1714, 10:+1663->1734, 11:+77->148, 12:+1759->1830, 13:+1818->1889, 14:+640->711, 15:+1832->1903, 16:+77->148, 17:+92->163
    //   149: jsr +4866 -> 5015
    //   152: dsub
    //   153: invokestatic 617	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc_w 606
    //   159: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: aload_3
    //   164: ldc_w 619
    //   167: invokevirtual 623	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   170: checkcast 625	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   173: astore 5
    //   175: aload 5
    //   177: ifnull +1733 -> 1910
    //   180: aload 5
    //   182: getfield 628	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFG	Z
    //   185: ifeq +39 -> 224
    //   188: aload_0
    //   189: aload 5
    //   191: getfield 631	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFO	Ljava/lang/String;
    //   194: putfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   201: invokestatic 634	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   204: ifne +1706 -> 1910
    //   207: aload_0
    //   208: iconst_1
    //   209: putfield 100	com/tencent/mm/plugin/sns/ui/SnsUIAction:rbv	Z
    //   212: aload_0
    //   213: aload_3
    //   214: invokespecial 636	com/tencent/mm/plugin/sns/ui/SnsUIAction:ao	(Landroid/content/Intent;)V
    //   217: ldc_w 606
    //   220: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: ldc 168
    //   226: ldc_w 638
    //   229: iconst_2
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload 5
    //   237: getfield 641	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: aload 5
    //   245: getfield 644	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFJ	Ljava/lang/String;
    //   248: aastore
    //   249: invokestatic 504	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: new 237	android/content/Intent
    //   255: dup
    //   256: invokespecial 416	android/content/Intent:<init>	()V
    //   259: astore 4
    //   261: aload 4
    //   263: ldc_w 646
    //   266: aload 5
    //   268: getfield 641	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   271: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   274: pop
    //   275: aload 4
    //   277: ldc_w 648
    //   280: aload 5
    //   282: getfield 644	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFJ	Ljava/lang/String;
    //   285: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   288: pop
    //   289: aload 5
    //   291: getfield 651	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   294: invokestatic 634	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   297: ifne +119 -> 416
    //   300: aload 4
    //   302: ldc_w 653
    //   305: aload 5
    //   307: getfield 651	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFL	Ljava/lang/String;
    //   310: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   313: pop
    //   314: aload 4
    //   316: ldc 248
    //   318: iconst_1
    //   319: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   322: pop
    //   323: aload 4
    //   325: ldc 254
    //   327: invokestatic 259	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   330: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   333: pop
    //   334: aload 4
    //   336: ldc_w 655
    //   339: bipush 14
    //   341: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   344: pop
    //   345: aload 4
    //   347: ldc_w 282
    //   350: iconst_0
    //   351: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   354: pop
    //   355: aload 4
    //   357: ldc_w 288
    //   360: aload_3
    //   361: ldc_w 288
    //   364: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   370: pop
    //   371: aload 5
    //   373: getfield 659	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFN	Lcom/tencent/mm/protocal/protobuf/bby;
    //   376: invokevirtual 664	com/tencent/mm/protocal/protobuf/bby:toByteArray	()[B
    //   379: astore_3
    //   380: aload_3
    //   381: ifnull +13 -> 394
    //   384: aload 4
    //   386: ldc_w 666
    //   389: aload_3
    //   390: invokevirtual 669	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   393: pop
    //   394: aload_0
    //   395: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   398: ldc_w 671
    //   401: ldc_w 673
    //   404: aload 4
    //   406: invokestatic 678	com/tencent/mm/bq/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   409: ldc_w 606
    //   412: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: return
    //   416: aload 4
    //   418: ldc_w 653
    //   421: aload 5
    //   423: getfield 641	com/tencent/mm/plugin/mmsight/SightCaptureResult:oFI	Ljava/lang/String;
    //   426: invokestatic 683	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   429: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   432: pop
    //   433: goto -119 -> 314
    //   436: astore_3
    //   437: ldc 168
    //   439: ldc_w 685
    //   442: iconst_1
    //   443: anewarray 4	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload_3
    //   449: invokevirtual 688	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   452: aastore
    //   453: invokestatic 504	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: goto -62 -> 394
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   464: invokevirtual 692	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   467: aload_3
    //   468: invokestatic 225	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   471: invokestatic 695	com/tencent/mm/pluginsdk/ui/tools/n:h	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   474: putfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   477: ldc 168
    //   479: new 178	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 697
    //   486: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   493: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_0
    //   503: getfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   506: ifnonnull +10 -> 516
    //   509: ldc_w 606
    //   512: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: return
    //   516: invokestatic 393	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   519: pop
    //   520: invokestatic 397	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   523: invokevirtual 430	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   526: ldc_w 698
    //   529: aconst_null
    //   530: invokevirtual 437	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   533: checkcast 439	java/lang/Integer
    //   536: iconst_0
    //   537: invokestatic 442	com/tencent/mm/sdk/platformtools/bo:a	(Ljava/lang/Integer;I)I
    //   540: istore_1
    //   541: invokestatic 393	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   544: pop
    //   545: invokestatic 397	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   548: invokevirtual 430	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   551: ldc_w 698
    //   554: iload_1
    //   555: iconst_1
    //   556: iadd
    //   557: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: invokevirtual 702	com/tencent/mm/storage/z:set	(ILjava/lang/Object;)V
    //   563: aload_0
    //   564: iconst_1
    //   565: putfield 100	com/tencent/mm/plugin/sns/ui/SnsUIAction:rbv	Z
    //   568: aload_0
    //   569: aload_3
    //   570: invokespecial 636	com/tencent/mm/plugin/sns/ui/SnsUIAction:ao	(Landroid/content/Intent;)V
    //   573: ldc_w 606
    //   576: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: return
    //   580: aload_3
    //   581: ifnonnull +10 -> 591
    //   584: ldc_w 606
    //   587: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: invokestatic 393	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   594: pop
    //   595: invokestatic 397	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   598: invokevirtual 430	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   601: ldc_w 703
    //   604: aconst_null
    //   605: invokevirtual 437	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   608: checkcast 439	java/lang/Integer
    //   611: iconst_0
    //   612: invokestatic 442	com/tencent/mm/sdk/platformtools/bo:a	(Ljava/lang/Integer;I)I
    //   615: istore_1
    //   616: invokestatic 393	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   619: pop
    //   620: invokestatic 397	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   623: invokevirtual 430	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   626: ldc_w 703
    //   629: iload_1
    //   630: iconst_1
    //   631: iadd
    //   632: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: invokevirtual 702	com/tencent/mm/storage/z:set	(ILjava/lang/Object;)V
    //   638: new 237	android/content/Intent
    //   641: dup
    //   642: invokespecial 416	android/content/Intent:<init>	()V
    //   645: astore 4
    //   647: aload 4
    //   649: ldc_w 705
    //   652: iconst_4
    //   653: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   656: pop
    //   657: aload 4
    //   659: ldc_w 707
    //   662: iconst_1
    //   663: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   666: pop
    //   667: aload 4
    //   669: ldc_w 709
    //   672: iconst_1
    //   673: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   676: pop
    //   677: getstatic 715	com/tencent/mm/plugin/sns/c/a:gmO	Lcom/tencent/mm/pluginsdk/n;
    //   680: aload_0
    //   681: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   684: aload_3
    //   685: aload 4
    //   687: invokestatic 225	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   690: iconst_4
    //   691: new 717	com/tencent/mm/plugin/sns/ui/SnsUIAction$13
    //   694: dup
    //   695: aload_0
    //   696: invokespecial 718	com/tencent/mm/plugin/sns/ui/SnsUIAction$13:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   699: invokeinterface 723 7 0
    //   704: ldc_w 606
    //   707: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: return
    //   711: new 148	com/tencent/mm/sdk/platformtools/ak
    //   714: dup
    //   715: invokestatic 154	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   718: invokespecial 157	com/tencent/mm/sdk/platformtools/ak:<init>	(Landroid/os/Looper;)V
    //   721: new 725	com/tencent/mm/plugin/sns/ui/SnsUIAction$2
    //   724: dup
    //   725: aload_0
    //   726: invokespecial 726	com/tencent/mm/plugin/sns/ui/SnsUIAction$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;)V
    //   729: invokevirtual 166	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   732: pop
    //   733: aload_3
    //   734: ldc_w 728
    //   737: invokevirtual 732	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   740: astore 4
    //   742: aload_3
    //   743: ldc_w 734
    //   746: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   749: invokestatic 739	com/tencent/mm/plugin/sns/data/i:ZQ	(Ljava/lang/String;)V
    //   752: aload 4
    //   754: ifnull +11 -> 765
    //   757: aload 4
    //   759: invokevirtual 744	java/util/ArrayList:size	()I
    //   762: ifgt +16 -> 778
    //   765: aload_3
    //   766: ldc_w 746
    //   769: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   772: invokestatic 634	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   775: ifne +438 -> 1213
    //   778: aload 4
    //   780: ifnull +124 -> 904
    //   783: aload 4
    //   785: invokevirtual 744	java/util/ArrayList:size	()I
    //   788: ifle +116 -> 904
    //   791: aload 4
    //   793: iconst_0
    //   794: invokevirtual 749	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   797: checkcast 210	java/lang/String
    //   800: astore 4
    //   802: aload_3
    //   803: ldc_w 751
    //   806: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 5
    //   811: aload 5
    //   813: invokestatic 634	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   816: ifne +14 -> 830
    //   819: aload 5
    //   821: astore_3
    //   822: aload 5
    //   824: invokestatic 754	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   827: ifne +188 -> 1015
    //   830: new 178	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   837: invokestatic 225	com/tencent/mm/plugin/sns/model/ag:getAccSnsTmpPath	()Ljava/lang/String;
    //   840: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 4
    //   845: invokestatic 683	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   848: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: astore_3
    //   855: new 756	android/media/MediaMetadataRetriever
    //   858: dup
    //   859: invokespecial 757	android/media/MediaMetadataRetriever:<init>	()V
    //   862: astore 5
    //   864: aload 5
    //   866: aload 4
    //   868: invokevirtual 760	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   871: aload 5
    //   873: lconst_0
    //   874: invokevirtual 764	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   877: astore 6
    //   879: aload 6
    //   881: ifnonnull +43 -> 924
    //   884: ldc 168
    //   886: ldc_w 766
    //   889: invokestatic 617	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload 5
    //   894: invokevirtual 769	android/media/MediaMetadataRetriever:release	()V
    //   897: ldc_w 606
    //   900: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   903: return
    //   904: aload_3
    //   905: ldc_w 746
    //   908: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore 4
    //   913: goto -111 -> 802
    //   916: astore_3
    //   917: ldc_w 606
    //   920: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   923: return
    //   924: ldc 168
    //   926: ldc_w 771
    //   929: iconst_2
    //   930: anewarray 4	java/lang/Object
    //   933: dup
    //   934: iconst_0
    //   935: aload 6
    //   937: invokevirtual 776	android/graphics/Bitmap:getWidth	()I
    //   940: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   943: aastore
    //   944: dup
    //   945: iconst_1
    //   946: aload 6
    //   948: invokevirtual 779	android/graphics/Bitmap:getHeight	()I
    //   951: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   954: aastore
    //   955: invokestatic 504	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   958: aload 6
    //   960: bipush 80
    //   962: getstatic 785	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   965: aload_3
    //   966: iconst_1
    //   967: invokestatic 790	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   970: aload_3
    //   971: invokestatic 794	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   974: astore 6
    //   976: ldc 168
    //   978: ldc_w 796
    //   981: iconst_2
    //   982: anewarray 4	java/lang/Object
    //   985: dup
    //   986: iconst_0
    //   987: aload 6
    //   989: getfield 801	android/graphics/BitmapFactory$Options:outWidth	I
    //   992: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   995: aastore
    //   996: dup
    //   997: iconst_1
    //   998: aload 6
    //   1000: getfield 804	android/graphics/BitmapFactory$Options:outHeight	I
    //   1003: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1006: aastore
    //   1007: invokestatic 504	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1010: aload 5
    //   1012: invokevirtual 769	android/media/MediaMetadataRetriever:release	()V
    //   1015: ldc 168
    //   1017: ldc_w 806
    //   1020: iconst_4
    //   1021: anewarray 4	java/lang/Object
    //   1024: dup
    //   1025: iconst_0
    //   1026: aload 4
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_1
    //   1031: aload_3
    //   1032: aastore
    //   1033: dup
    //   1034: iconst_2
    //   1035: aload 4
    //   1037: invokestatic 810	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1040: invokestatic 815	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1043: aastore
    //   1044: dup
    //   1045: iconst_3
    //   1046: aload_3
    //   1047: invokestatic 810	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1050: invokestatic 815	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1053: aastore
    //   1054: invokestatic 504	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1057: new 237	android/content/Intent
    //   1060: dup
    //   1061: invokespecial 416	android/content/Intent:<init>	()V
    //   1064: astore 5
    //   1066: aload 5
    //   1068: ldc_w 646
    //   1071: aload 4
    //   1073: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1076: pop
    //   1077: aload 5
    //   1079: ldc_w 648
    //   1082: aload_3
    //   1083: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1086: pop
    //   1087: aload 5
    //   1089: ldc_w 653
    //   1092: aload 4
    //   1094: invokestatic 683	com/tencent/mm/vfs/e:avP	(Ljava/lang/String;)Ljava/lang/String;
    //   1097: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1100: pop
    //   1101: aload 5
    //   1103: ldc 248
    //   1105: iconst_1
    //   1106: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1109: pop
    //   1110: aload 5
    //   1112: ldc 254
    //   1114: invokestatic 259	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   1117: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1120: pop
    //   1121: aload 5
    //   1123: ldc_w 655
    //   1126: bipush 14
    //   1128: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1131: pop
    //   1132: aload 5
    //   1134: ldc_w 282
    //   1137: iconst_0
    //   1138: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1141: pop
    //   1142: aload_0
    //   1143: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1146: ldc_w 671
    //   1149: ldc_w 673
    //   1152: aload 5
    //   1154: invokestatic 678	com/tencent/mm/bq/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1157: ldc_w 606
    //   1160: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: return
    //   1164: astore 6
    //   1166: ldc 168
    //   1168: ldc_w 817
    //   1171: iconst_1
    //   1172: anewarray 4	java/lang/Object
    //   1175: dup
    //   1176: iconst_0
    //   1177: aload 6
    //   1179: invokevirtual 688	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1182: aastore
    //   1183: invokestatic 819	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1186: aload 5
    //   1188: invokevirtual 769	android/media/MediaMetadataRetriever:release	()V
    //   1191: goto -176 -> 1015
    //   1194: astore 5
    //   1196: goto -181 -> 1015
    //   1199: astore_3
    //   1200: aload 5
    //   1202: invokevirtual 769	android/media/MediaMetadataRetriever:release	()V
    //   1205: ldc_w 606
    //   1208: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1211: aload_3
    //   1212: athrow
    //   1213: aload_3
    //   1214: ldc_w 821
    //   1217: invokevirtual 732	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1220: astore 4
    //   1222: aload 4
    //   1224: ifnull +11 -> 1235
    //   1227: aload 4
    //   1229: invokevirtual 744	java/util/ArrayList:size	()I
    //   1232: ifne +18 -> 1250
    //   1235: ldc 168
    //   1237: ldc_w 823
    //   1240: invokestatic 610	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1243: ldc_w 606
    //   1246: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1249: return
    //   1250: new 741	java/util/ArrayList
    //   1253: dup
    //   1254: invokespecial 824	java/util/ArrayList:<init>	()V
    //   1257: astore 5
    //   1259: aload 4
    //   1261: invokevirtual 828	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1264: astore 6
    //   1266: aload 6
    //   1268: invokeinterface 833 1 0
    //   1273: ifeq +76 -> 1349
    //   1276: aload 6
    //   1278: invokeinterface 837 1 0
    //   1283: checkcast 210	java/lang/String
    //   1286: astore 7
    //   1288: aload 7
    //   1290: invokestatic 843	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1293: invokevirtual 847	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1296: astore 8
    //   1298: aload 8
    //   1300: ifnull -34 -> 1266
    //   1303: aload 5
    //   1305: ldc_w 849
    //   1308: iconst_3
    //   1309: anewarray 4	java/lang/Object
    //   1312: dup
    //   1313: iconst_0
    //   1314: aload 7
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_1
    //   1319: aload 8
    //   1321: getfield 855	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1324: invokestatic 860	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1327: aastore
    //   1328: dup
    //   1329: iconst_2
    //   1330: aload 8
    //   1332: getfield 863	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1335: invokestatic 860	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1338: aastore
    //   1339: invokestatic 867	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1342: invokevirtual 871	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1345: pop
    //   1346: goto -80 -> 1266
    //   1349: aload_0
    //   1350: aload_3
    //   1351: ldc_w 873
    //   1354: iconst_0
    //   1355: invokevirtual 877	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1358: putfield 100	com/tencent/mm/plugin/sns/ui/SnsUIAction:rbv	Z
    //   1361: new 237	android/content/Intent
    //   1364: dup
    //   1365: aload_0
    //   1366: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1369: ldc 243
    //   1371: invokespecial 246	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1374: astore 6
    //   1376: aload 6
    //   1378: ldc 248
    //   1380: iconst_1
    //   1381: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1384: pop
    //   1385: aload 6
    //   1387: ldc 254
    //   1389: invokestatic 259	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   1392: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1395: pop
    //   1396: aload_0
    //   1397: getfield 130	com/tencent/mm/plugin/sns/ui/SnsUIAction:sbg	Lcom/tencent/mm/modelsns/b;
    //   1400: ifnull +20 -> 1420
    //   1403: aload_0
    //   1404: getfield 130	com/tencent/mm/plugin/sns/ui/SnsUIAction:sbg	Lcom/tencent/mm/modelsns/b;
    //   1407: aload 6
    //   1409: ldc_w 264
    //   1412: invokevirtual 270	com/tencent/mm/modelsns/b:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1415: aload_0
    //   1416: aconst_null
    //   1417: putfield 130	com/tencent/mm/plugin/sns/ui/SnsUIAction:sbg	Lcom/tencent/mm/modelsns/b;
    //   1420: aload_0
    //   1421: getfield 284	com/tencent/mm/plugin/sns/ui/SnsUIAction:rHl	Z
    //   1424: ifeq +14 -> 1438
    //   1427: aload 6
    //   1429: ldc_w 286
    //   1432: bipush 11
    //   1434: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1437: pop
    //   1438: aload_3
    //   1439: ldc 235
    //   1441: iconst_0
    //   1442: invokevirtual 241	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1445: istore_1
    //   1446: aload 6
    //   1448: ldc_w 879
    //   1451: aload 4
    //   1453: invokevirtual 882	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1456: pop
    //   1457: aload 6
    //   1459: ldc_w 277
    //   1462: iload_1
    //   1463: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1466: pop
    //   1467: aload_0
    //   1468: getfield 100	com/tencent/mm/plugin/sns/ui/SnsUIAction:rbv	Z
    //   1471: ifeq +13 -> 1484
    //   1474: aload 6
    //   1476: ldc_w 282
    //   1479: iconst_1
    //   1480: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1483: pop
    //   1484: aload 6
    //   1486: ldc_w 884
    //   1489: aload 5
    //   1491: invokevirtual 888	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1494: pop
    //   1495: ldc 168
    //   1497: ldc_w 890
    //   1500: iconst_1
    //   1501: anewarray 4	java/lang/Object
    //   1504: dup
    //   1505: iconst_0
    //   1506: aload 6
    //   1508: ldc_w 655
    //   1511: iconst_m1
    //   1512: invokevirtual 241	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1515: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1518: aastore
    //   1519: invokestatic 892	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1522: aload_0
    //   1523: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1526: aload 6
    //   1528: bipush 6
    //   1530: invokevirtual 298	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1533: ldc_w 606
    //   1536: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1539: return
    //   1540: aload_3
    //   1541: ifnonnull +10 -> 1551
    //   1544: ldc_w 606
    //   1547: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1550: return
    //   1551: aload_0
    //   1552: aload_3
    //   1553: ldc_w 894
    //   1556: invokevirtual 292	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: putfield 185	com/tencent/mm/plugin/sns/ui/SnsUIAction:filePath	Ljava/lang/String;
    //   1562: aload_0
    //   1563: aload_3
    //   1564: invokespecial 636	com/tencent/mm/plugin/sns/ui/SnsUIAction:ao	(Landroid/content/Intent;)V
    //   1567: ldc_w 606
    //   1570: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1573: return
    //   1574: ldc 168
    //   1576: ldc_w 896
    //   1579: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: aload_3
    //   1583: ifnonnull +10 -> 1593
    //   1586: ldc_w 606
    //   1589: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1592: return
    //   1593: aload_3
    //   1594: ldc_w 898
    //   1597: iconst_m1
    //   1598: invokevirtual 241	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1601: istore_1
    //   1602: aload_0
    //   1603: getfield 307	com/tencent/mm/plugin/sns/ui/SnsUIAction:saS	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1606: iload_1
    //   1607: aconst_null
    //   1608: aconst_null
    //   1609: invokeinterface 901 4 0
    //   1614: invokestatic 905	com/tencent/mm/plugin/sns/model/ag:cpb	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   1617: invokevirtual 910	com/tencent/mm/plugin/sns/model/ax:cnP	()V
    //   1620: ldc_w 606
    //   1623: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1626: return
    //   1627: ldc 168
    //   1629: ldc_w 912
    //   1632: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1635: aload_0
    //   1636: getfield 578	com/tencent/mm/plugin/sns/ui/SnsUIAction:rmc	Lcom/tencent/mm/plugin/sns/ui/SnsHeader;
    //   1639: invokevirtual 583	com/tencent/mm/plugin/sns/ui/SnsHeader:cvh	()V
    //   1642: invokestatic 905	com/tencent/mm/plugin/sns/model/ag:cpb	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   1645: invokevirtual 910	com/tencent/mm/plugin/sns/model/ax:cnP	()V
    //   1648: ldc_w 606
    //   1651: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1654: return
    //   1655: aload_3
    //   1656: ifnonnull +10 -> 1666
    //   1659: ldc_w 606
    //   1662: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1665: return
    //   1666: ldc 168
    //   1668: ldc_w 914
    //   1671: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1674: aload_3
    //   1675: ldc_w 916
    //   1678: invokevirtual 623	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1681: checkcast 918	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1684: astore_3
    //   1685: aload_3
    //   1686: ifnull +224 -> 1910
    //   1689: aload_0
    //   1690: getfield 307	com/tencent/mm/plugin/sns/ui/SnsUIAction:saS	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1693: iconst_m1
    //   1694: aload_3
    //   1695: getfield 922	com/tencent/mm/plugin/sns/data/SnsCmdList:rbg	Ljava/util/List;
    //   1698: aload_3
    //   1699: getfield 925	com/tencent/mm/plugin/sns/data/SnsCmdList:rbh	Ljava/util/List;
    //   1702: invokeinterface 901 4 0
    //   1707: ldc_w 606
    //   1710: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1713: return
    //   1714: invokestatic 905	com/tencent/mm/plugin/sns/model/ag:cpb	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   1717: invokevirtual 910	com/tencent/mm/plugin/sns/model/ax:cnP	()V
    //   1720: aload_0
    //   1721: getfield 562	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1724: invokestatic 930	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$c:a	(Landroid/widget/ListView;)V
    //   1727: ldc_w 606
    //   1730: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1733: return
    //   1734: aload_3
    //   1735: ifnonnull +10 -> 1745
    //   1738: ldc_w 606
    //   1741: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1744: return
    //   1745: iload_2
    //   1746: iconst_m1
    //   1747: if_icmpne +163 -> 1910
    //   1750: aload_3
    //   1751: invokevirtual 934	android/content/Intent:getData	()Landroid/net/Uri;
    //   1754: astore_3
    //   1755: aload_0
    //   1756: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1759: aload_3
    //   1760: aconst_null
    //   1761: aconst_null
    //   1762: aconst_null
    //   1763: aconst_null
    //   1764: invokevirtual 938	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1767: astore_3
    //   1768: aload_3
    //   1769: invokeinterface 943 1 0
    //   1774: ifeq +49 -> 1823
    //   1777: new 237	android/content/Intent
    //   1780: dup
    //   1781: ldc_w 945
    //   1784: ldc_w 947
    //   1787: aload_3
    //   1788: aload_3
    //   1789: ldc_w 949
    //   1792: invokeinterface 953 2 0
    //   1797: invokeinterface 955 2 0
    //   1802: invokestatic 958	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1805: invokevirtual 415	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1808: invokestatic 964	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1811: invokespecial 967	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1814: astore_3
    //   1815: aload_0
    //   1816: getfield 132	com/tencent/mm/plugin/sns/ui/SnsUIAction:mActivity	Landroid/app/Activity;
    //   1819: aload_3
    //   1820: invokevirtual 970	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1823: ldc_w 606
    //   1826: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1829: return
    //   1830: aload_3
    //   1831: ldc_w 972
    //   1834: iconst_m1
    //   1835: invokevirtual 241	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1838: istore_1
    //   1839: iload_1
    //   1840: ifle +70 -> 1910
    //   1843: ldc 168
    //   1845: ldc_w 974
    //   1848: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1851: new 918	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1854: dup
    //   1855: invokespecial 975	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   1858: astore_3
    //   1859: aload_3
    //   1860: iload_1
    //   1861: invokevirtual 978	com/tencent/mm/plugin/sns/data/SnsCmdList:Dz	(I)V
    //   1864: aload_0
    //   1865: getfield 307	com/tencent/mm/plugin/sns/ui/SnsUIAction:saS	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction$a;
    //   1868: iconst_m1
    //   1869: aload_3
    //   1870: getfield 922	com/tencent/mm/plugin/sns/data/SnsCmdList:rbg	Ljava/util/List;
    //   1873: aload_3
    //   1874: getfield 925	com/tencent/mm/plugin/sns/data/SnsCmdList:rbh	Ljava/util/List;
    //   1877: invokeinterface 901 4 0
    //   1882: ldc_w 606
    //   1885: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1888: return
    //   1889: invokestatic 982	com/tencent/mm/plugin/sns/model/ag:cpk	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   1892: invokevirtual 987	com/tencent/mm/plugin/sns/storage/k:bca	()Z
    //   1895: pop
    //   1896: ldc_w 606
    //   1899: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1902: return
    //   1903: ldc_w 606
    //   1906: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1909: return
    //   1910: ldc_w 606
    //   1913: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1916: return
    //   1917: astore 5
    //   1919: goto -904 -> 1015
    //   1922: astore 4
    //   1924: goto -719 -> 1205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1927	0	this	SnsUIAction
    //   0	1927	1	paramInt1	int
    //   0	1927	2	paramInt2	int
    //   0	1927	3	paramIntent	Intent
    //   259	1193	4	localObject1	Object
    //   1922	1	4	localException1	java.lang.Exception
    //   173	1014	5	localObject2	Object
    //   1194	7	5	localException2	java.lang.Exception
    //   1257	233	5	localArrayList	ArrayList
    //   1917	1	5	localException3	java.lang.Exception
    //   877	122	6	localObject3	Object
    //   1164	14	6	localException4	java.lang.Exception
    //   1264	263	6	localObject4	Object
    //   1286	29	7	str	String
    //   1296	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   371	380	436	java/lang/Exception
    //   384	394	436	java/lang/Exception
    //   892	897	916	java/lang/Exception
    //   864	879	1164	java/lang/Exception
    //   884	892	1164	java/lang/Exception
    //   924	1010	1164	java/lang/Exception
    //   1186	1191	1194	java/lang/Exception
    //   864	879	1199	finally
    //   884	892	1199	finally
    //   924	1010	1199	finally
    //   1166	1186	1199	finally
    //   1010	1015	1917	java/lang/Exception
    //   1200	1205	1922	java/lang/Exception
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(39654);
    this.qYs = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    this.rXu = ((int)(this.qYs * 0.4D));
    ag.cpc().start();
    if (this.actionbarView != null) {
      this.saT = ((Toolbar.LayoutParams)this.actionbarView.getLayoutParams());
    }
    this.list = this.saS.getSnsListView();
    this.list.post(new SnsUIAction.1(this));
    Object localObject = new StringBuilder("list is null ? ");
    boolean bool;
    label299:
    SnsHeader localSnsHeader;
    label451:
    String str2;
    String str3;
    String str1;
    if (this.list != null)
    {
      bool = true;
      ab.i("MicroMsg.SnsActivity", bool);
      this.list.setScrollingCacheEnabled(false);
      this.rmc = new SnsHeader(this.mActivity);
      this.rmc.setSessionId(this.cpW);
      this.rmc.setEnterObjectId(this.rnO);
      this.rmc.setBackClickListener(new SnsUIAction.6(this));
      this.mwU = this.saS.cwh();
      this.jbK = this.saS.getMaskView();
      this.saO = new LoadingMoreView(this.mActivity);
      this.list.addHeaderView(this.rmc);
      this.list.addFooterView(this.saO);
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(145644);
          System.currentTimeMillis();
          SnsUIAction.this.saR = (paramAnonymousInt1 + paramAnonymousInt2 - 1);
          if ((SnsUIAction.this.list.getLastVisiblePosition() == SnsUIAction.this.list.getCount() - 1) && (SnsUIAction.this.list.getCount() != SnsUIAction.f(SnsUIAction.this)))
          {
            ab.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(SnsUIAction.this.list.getCount()) });
            SnsUIAction.a(SnsUIAction.this, SnsUIAction.this.list.getCount());
            SnsUIAction.g(SnsUIAction.this);
          }
          if (paramAnonymousAbsListView.getChildCount() == 0)
          {
            AppMethodBeat.o(145644);
            return;
          }
          int k = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 20);
          paramAnonymousInt2 = 0;
          float f1 = 1.0F;
          int j = 1;
          paramAnonymousInt3 = 0;
          int m;
          int n;
          int i;
          label231:
          SnsUIAction localSnsUIAction;
          label277:
          int i1;
          label388:
          float f2;
          if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
          {
            paramAnonymousInt3 = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 245);
            m = paramAnonymousInt3 - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 30);
            n = paramAnonymousInt3 - com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 10);
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
            if (paramAnonymousAbsListView != null) {
              break label717;
            }
            i = 0;
            if (paramAnonymousInt1 <= SnsUIAction.h(SnsUIAction.this)) {
              break label726;
            }
            SnsUIAction.this.sbb = SnsUIAction.aUG();
            if (paramAnonymousAbsListView != null)
            {
              localSnsUIAction = SnsUIAction.this;
              localSnsUIAction.jgE += paramAnonymousAbsListView.getHeight();
            }
            SnsUIAction.this.sbd = (-i + SnsUIAction.this.jgE);
            SnsUIAction.b(SnsUIAction.this, paramAnonymousInt1);
            SnsUIAction.c(SnsUIAction.this, i);
            if (SnsUIAction.this.sbc != SnsUIAction.this.sbb)
            {
              SnsUIAction.this.start = SnsUIAction.this.sbd;
              SnsUIAction.this.sbe = false;
            }
            if (paramAnonymousInt1 != 0) {
              break label964;
            }
            i1 = -paramAnonymousAbsListView.getTop();
            SnsUIAction.this.sbd = i1;
            if ((i1 < 0) || (i1 > m)) {
              break label852;
            }
            f1 = 1.0F;
            if ((i1 < 0) || (i1 > paramAnonymousInt3)) {
              break label906;
            }
            paramAnonymousInt2 = 0;
            j = 0;
            f2 = 0.0F;
            label408:
            if (SnsUIAction.this.jbK != null)
            {
              ab.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(SnsUIAction.this.sbd), Integer.valueOf(i), Integer.valueOf(SnsUIAction.this.jgE) });
              if (SnsUIAction.this.sbd <= paramAnonymousInt3) {
                break label973;
              }
              SnsUIAction.this.jbK.setVisibility(8);
            }
            label487:
            SnsUIAction.this.saY = SnsUIAction.this.sbd;
            SnsUIAction.this.sbc = SnsUIAction.this.sbb;
            if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) {
              break label987;
            }
            paramAnonymousAbsListView = (SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this);
          }
          for (;;)
          {
            label539:
            if (paramAnonymousAbsListView != null) {
              if (SnsUIAction.this.ozS != paramAnonymousInt2)
              {
                if (paramAnonymousInt2 > 0) {
                  break label1014;
                }
                paramAnonymousAbsListView.setActionbarColor(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131690605));
                label577:
                if ((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI))
                {
                  if (j == 0) {
                    break label1040;
                  }
                  paramAnonymousAbsListView.updateOptionMenuIcon(0, 2131231490);
                }
              }
            }
            for (;;)
            {
              SnsUIAction.c(SnsUIAction.this).fN(paramAnonymousInt1, paramAnonymousInt2);
              if (SnsUIAction.this.sba != f2) {
                paramAnonymousAbsListView.setTitleAlpha(f2);
              }
              if (SnsUIAction.this.saZ != f1) {
                paramAnonymousAbsListView.setIconAlpha(f1);
              }
              SnsUIAction.this.ozS = paramAnonymousInt2;
              SnsUIAction.this.saZ = f1;
              SnsUIAction.this.sba = f2;
              AppMethodBeat.o(145644);
              return;
              if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
                break;
              }
              paramAnonymousInt3 = com.tencent.mm.cb.a.fromDPToPix(SnsUIAction.a(SnsUIAction.this), 199);
              break;
              label717:
              i = paramAnonymousAbsListView.getTop();
              break label231;
              label726:
              if (paramAnonymousInt1 < SnsUIAction.h(SnsUIAction.this))
              {
                SnsUIAction.this.sbb = SnsUIAction.amn();
                if (SnsUIAction.this.jgE < paramAnonymousAbsListView.getHeight()) {
                  break label277;
                }
                localSnsUIAction = SnsUIAction.this;
                localSnsUIAction.jgE -= paramAnonymousAbsListView.getHeight();
                break label277;
              }
              if (Math.abs(i - SnsUIAction.i(SnsUIAction.this)) <= 1) {
                break label277;
              }
              if (i < SnsUIAction.i(SnsUIAction.this))
              {
                SnsUIAction.this.sbb = SnsUIAction.aUG();
                break label277;
              }
              if (i <= SnsUIAction.i(SnsUIAction.this)) {
                break label277;
              }
              SnsUIAction.this.sbb = SnsUIAction.amn();
              break label277;
              label852:
              if (i1 <= n)
              {
                f1 = 1.0F - (i1 - m) / (n - m);
                break label388;
              }
              if (i1 > paramAnonymousInt3 + k) {
                break label388;
              }
              f1 = (i1 - paramAnonymousInt3) * 1.0F / k;
              break label388;
              label906:
              if (i1 <= paramAnonymousInt3 + k)
              {
                paramAnonymousInt2 = (i1 - paramAnonymousInt3) * 100 / k;
                f2 = (i1 - paramAnonymousInt3) * 1.0F / k;
                break label408;
              }
              if (i1 > k + paramAnonymousInt3) {
                paramAnonymousInt2 = 100;
              }
              f2 = 1.0F;
              break label408;
              label964:
              f2 = 1.0F;
              paramAnonymousInt2 = 100;
              break label408;
              label973:
              SnsUIAction.this.jbK.setVisibility(0);
              break label487;
              label987:
              if (!(SnsUIAction.a(SnsUIAction.this) instanceof SnsUserUI)) {
                break label1050;
              }
              paramAnonymousAbsListView = (SnsUserUI)SnsUIAction.a(SnsUIAction.this);
              break label539;
              label1014:
              paramAnonymousAbsListView.setActionbarColor(aj.dS(SnsUIAction.a(SnsUIAction.this).getResources().getColor(2131690316), paramAnonymousInt2));
              break label577;
              label1040:
              paramAnonymousAbsListView.updateOptionMenuIcon(0, 2131231442);
            }
            label1050:
            paramAnonymousAbsListView = null;
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(145643);
          SnsUIAction.c(SnsUIAction.this).EY(paramAnonymousInt);
          Object localObject1;
          if (paramAnonymousInt == 0)
          {
            paramAnonymousAbsListView = new ua();
            paramAnonymousAbsListView.cKz.type = 5;
            paramAnonymousAbsListView.cKz.cKA = SnsUIAction.this.list.getFirstVisiblePosition();
            paramAnonymousAbsListView.cKz.cKB = SnsUIAction.this.list.getLastVisiblePosition();
            paramAnonymousAbsListView.cKz.cKC = SnsUIAction.this.list.getHeaderViewsCount();
            com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousAbsListView);
            if (((SnsUIAction.a(SnsUIAction.this) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).rOU != null)) {
              ((SnsTimeLineUI)SnsUIAction.a(SnsUIAction.this)).rOU.kZ(true);
            }
            if (SnsUIAction.this.rmc != null)
            {
              paramAnonymousAbsListView = SnsUIAction.this.rmc;
              if ((paramAnonymousAbsListView.rQC != null) && (paramAnonymousAbsListView.rQC.rQR != null)) {
                paramAnonymousAbsListView.rQC.rQR.cxA();
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
              if (paramAnonymousAbsListView.sbf != null) {
                paramAnonymousAbsListView.sbf.clear();
              }
              j = -1;
              i = -1;
              int i1 = ((ListView)localObject1).getHeight();
              Object localObject2 = new Rect();
              if (paramAnonymousAbsListView.actionbarView == null) {
                break label763;
              }
              paramAnonymousAbsListView.actionbarView.getGlobalVisibleRect((Rect)localObject2);
              k = ((Rect)localObject2).bottom;
              int i2 = ((ListView)localObject1).getChildCount();
              m = 0;
              if (m < i2)
              {
                Object localObject3 = ((ListView)localObject1).getChildAt(m).getTag();
                if (!(localObject3 instanceof h.a)) {
                  break label760;
                }
                localObject3 = (h.a)localObject3;
                if (!(((h.a)localObject3).shL instanceof h)) {
                  break label760;
                }
                if (paramAnonymousAbsListView.sbf == null) {
                  paramAnonymousAbsListView.sbf = new ArrayList();
                }
                paramAnonymousAbsListView.sbf.add(localObject3);
                ((h.a)localObject3).siz.getGlobalVisibleRect((Rect)localObject2);
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
                  break label760;
                }
                i = paramAnonymousAbsListView.sbf.size() - 1;
                j = n;
                break label769;
              }
              if ((paramAnonymousAbsListView.sbf != null) && (paramAnonymousAbsListView.sbf.size() > 0) && (i >= 0))
              {
                j = 0;
                if (j >= paramAnonymousAbsListView.sbf.size()) {
                  break label667;
                }
                localObject1 = (h.a)paramAnonymousAbsListView.sbf.get(j);
                localObject2 = (h)((h.a)localObject1).shL;
                if (j == i) {
                  ((h)localObject2).a(((h.a)localObject1).siz, false);
                } else {
                  ((h)localObject2).a(((h.a)localObject1).siz, true);
                }
              }
            }
            catch (Throwable paramAnonymousAbsListView)
            {
              ab.e("MicroMsg.SnsActivitySphereImageView", "checkSphereImageCompItem exp=" + paramAnonymousAbsListView.toString());
            }
            if (paramAnonymousInt == 2)
            {
              com.tencent.mm.ci.d.dAt().eJ(SnsUIAction.class.getName() + SnsUIAction.c(SnsUIAction.this).getType() + ".Listview", 4);
              SnsUIAction.this.lG(true);
              AppMethodBeat.o(145643);
              return;
              label667:
              long l2 = System.currentTimeMillis();
              localObject1 = new StringBuilder("checkSphereImageCompItem cost=").append(l2 - l1).append(", maxVisiableItemIdx=").append(i).append(", size=");
              if (paramAnonymousAbsListView.sbf != null) {}
              for (i = paramAnonymousAbsListView.sbf.size();; i = 0)
              {
                ab.d("MicroMsg.SnsActivitySphereImageView", i);
                break;
              }
            }
            SnsUIAction.this.lG(false);
            AppMethodBeat.o(145643);
            return;
            label760:
            break label769;
            label763:
            int k = 0;
            continue;
            label769:
            m += 1;
            continue;
            j += 1;
          }
        }
      });
      this.oCa = this.saS.cwi();
      localObject = new StringBuilder("pullDownView is null ? ");
      if (this.oCa == null) {
        break label566;
      }
      bool = true;
      ab.i("MicroMsg.SnsActivity", bool);
      this.oCa.setOnTopLoadDataListener(new SnsUIAction.8(this));
      this.oCa.setTopViewVisible(false);
      this.oCa.setIsTopShowAll(false);
      this.oCa.setAtBottomCallBack(new SnsUIAction.9(this));
      this.oCa.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean bil()
        {
          AppMethodBeat.i(145647);
          View localView = SnsUIAction.this.list.getChildAt(SnsUIAction.this.list.getFirstVisiblePosition());
          if ((localView != null) && (localView.getTop() == 0))
          {
            AppMethodBeat.o(145647);
            return true;
          }
          AppMethodBeat.o(145647);
          return false;
        }
      });
      this.oCa.setIsBottomShowAll(false);
      this.oCa.setOnBottomLoadDataListener(new SnsUIAction.11(this));
      this.oCa.setShowBackground(true);
      this.oCa.setBgColor("#f4f4f4");
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localSnsHeader = this.rmc;
      if (!bo.isNullOrNil(this.ikj)) {
        break label571;
      }
      localObject = this.rXD;
      str2 = this.rXD;
      str3 = this.gJX;
      str1 = this.mSignature;
      if ((localObject != null) && (str2 != null)) {
        break label579;
      }
      ab.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      this.rmc.setType(this.saS.getType());
      this.rmc.cvh();
      if (Build.VERSION.SDK_INT >= 11) {
        break label791;
      }
      ab.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      ag.cpb().bLQ.add(this);
      ax.rcV += 1;
      ag.cpa().a(this);
      AppMethodBeat.o(39654);
      return;
      bool = false;
      break;
      label566:
      bool = false;
      break label299;
      label571:
      localObject = this.ikj;
      break label451;
      label579:
      localSnsHeader.userName = ((String)localObject).trim();
      localSnsHeader.dZZ = str2.trim();
      localSnsHeader.ctJ = str2.equals(localObject);
      ab.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject).length() + "  " + (String)localObject);
      localSnsHeader.rQC.jII.setText((CharSequence)localObject);
      if ((localSnsHeader.rQC == null) || (localSnsHeader.rQC.ehv == null)) {}
      for (;;)
      {
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = i.I(str3);
          localSnsHeader.rQC.jII.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localSnsHeader.context, (CharSequence)localObject));
          localSnsHeader.rQC.rEI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localSnsHeader.context, str1, localSnsHeader.rQC.rEI.getTextSize()));
        }
        localSnsHeader.rQC.ehv.setContentDescription(localSnsHeader.context.getString(2131303779, new Object[] { localSnsHeader.rQC.jII.getText() }));
        break;
        a.b.u(localSnsHeader.rQC.ehv, localSnsHeader.userName);
      }
      label791:
      new SnsUIAction.5(this).run();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(39662);
    if (this.rmc != null)
    {
      Object localObject = this.rmc;
      if ((((SnsHeader)localObject).rQI != null) && (!((SnsHeader)localObject).rQI.isRecycled())) {
        ((SnsHeader)localObject).rQI.recycle();
      }
      if ((((SnsHeader)localObject).rQC != null) && (((SnsHeader)localObject).rQC.rQR != null))
      {
        localObject = ((SnsHeader)localObject).rQC.rQR;
        ab.i("MicroMsg.SnsStoryHeaderView", "destroy: ");
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().b((k.b)localObject);
      }
    }
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      ag.cpc().ah(this.mActivity);
      ag.cpa().b(this);
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      ag.cpb().bLQ.remove(this);
      ax.rcV -= 1;
    }
    this.saO.setVisibility(8);
    aa.ctL();
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RJ().QU()) {
      ag.cpc().start();
    }
    this.list.setAdapter(null);
    i.ZQ("");
    AppMethodBeat.o(39662);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(39657);
    Object localObject = new mj();
    ((mj)localObject).cCu.cCv = false;
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    ab.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    if (this.rmc != null)
    {
      localObject = this.rmc;
      if ((((SnsHeader)localObject).rQC != null) && (((SnsHeader)localObject).rQC.rQR != null))
      {
        localObject = ((SnsHeader)localObject).rQC.rQR;
        ((SnsStoryHeaderView)localObject).smn = false;
        ((SnsStoryHeaderView)localObject).cvo = true;
      }
    }
    AppMethodBeat.o(39657);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39656);
    ag.cpa().ac(2, false);
    com.tencent.mm.pluginsdk.wallet.j.Mx(7);
    Object localObject = new mj();
    ((mj)localObject).cCu.cCv = true;
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    ab.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    if (this.rmc != null)
    {
      localObject = this.rmc;
      if ((((SnsHeader)localObject).rQC != null) && (((SnsHeader)localObject).rQC.rQR != null))
      {
        localObject = ((SnsHeader)localObject).rQC.rQR;
        ab.i("MicroMsg.SnsStoryHeaderView", "resume: ");
        ((SnsStoryHeaderView)localObject).cvo = false;
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getContactFetcher().czz();
        ((SnsStoryHeaderView)localObject).post(new SnsStoryHeaderView.2((SnsStoryHeaderView)localObject));
      }
    }
    AppMethodBeat.o(39656);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(39658);
    this.cpW = paramString;
    if (this.rmc != null) {
      this.rmc.setSessionId(paramString);
    }
    AppMethodBeat.o(39658);
  }
  
  public static abstract interface a
  {
    public abstract void EY(int paramInt);
    
    public abstract void af(int paramInt, boolean paramBoolean);
    
    public abstract void b(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract void cwg();
    
    public abstract View cwh();
    
    public abstract MMPullDownView cwi();
    
    public abstract boolean cwj();
    
    public abstract void cwk();
    
    public abstract void cwl();
    
    public abstract void fN(int paramInt1, int paramInt2);
    
    public abstract View getMaskView();
    
    public abstract ListView getSnsListView();
    
    public abstract int getType();
    
    public abstract void lG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction
 * JD-Core Version:    0.7.0.1
 */