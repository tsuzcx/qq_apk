package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.h.a.lt;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.List;
import java.util.Set;

public class ba
  implements aw.a, b.b
{
  private static int pit = 0;
  private static int piu = 1;
  private static int piv = 2;
  protected String filePath;
  private String fsv;
  private String hcm;
  protected View hoY;
  int jsr = 0;
  protected View kcm;
  int lZB = 0;
  private int lastIndex;
  protected ListView lwE;
  private Activity mActivity;
  private String mSignature;
  protected MMPullDownView mbz;
  private boolean oPz;
  public int oki = 0;
  private boolean ong = false;
  protected SnsHeader oxg;
  private String peN;
  private boolean peO;
  private int peP;
  int piA = pit;
  int piB = pit;
  int piC = 0;
  boolean piD = false;
  com.tencent.mm.modelsns.b piE = null;
  protected LoadingMoreView pik;
  private int pil = 0;
  private boolean pim = false;
  protected boolean pio = false;
  public int pip = 0;
  a piq;
  View pir;
  private Toolbar.LayoutParams pis;
  private int piw;
  int pix = 0;
  float piy = 1.0F;
  float piz = 1.0F;
  int start = 0;
  protected p tipDialog = null;
  protected String title;
  
  public ba(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private void V(Intent paramIntent)
  {
    new ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        com.tencent.mm.plugin.sns.c.a.eUS.tm();
      }
    });
    y.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
    y.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
    if (this.filePath == null) {
      return;
    }
    Object localObject = "pre_temp_sns_pic" + com.tencent.mm.a.g.o(new StringBuilder().append(this.filePath).append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.plugin.sns.storage.s.ab(af.getAccSnsTmpPath(), this.filePath, (String)localObject);
    this.filePath = (af.getAccSnsTmpPath() + (String)localObject);
    y.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
    if (paramIntent != null) {}
    for (int i = paramIntent.getIntExtra("CropImage_filterId", 0);; i = 0)
    {
      localObject = new Intent(this.mActivity, SnsUploadUI.class);
      ((Intent)localObject).putExtra("KSnsPostManu", true);
      ((Intent)localObject).putExtra("KTouchCameraTime", bk.UX());
      if (this.piE != null)
      {
        this.piE.b((Intent)localObject, "intent_key_StatisticsOplog");
        this.piE = null;
      }
      ((Intent)localObject).putExtra("sns_kemdia_path", this.filePath);
      ((Intent)localObject).putExtra("KFilterId", i);
      if (this.ong) {
        ((Intent)localObject).putExtra("Kis_take_photo", true);
      }
      if (this.oPz) {
        ((Intent)localObject).putExtra("Ksnsupload_source", 11);
      }
      ((Intent)localObject).putExtra("KSessionID", paramIntent.getStringExtra("KSessionID"));
      this.mActivity.startActivityForResult((Intent)localObject, 6);
      this.ong = false;
      return;
    }
  }
  
  public static void onPause()
  {
    lt locallt = new lt();
    locallt.bUN.bUO = false;
    com.tencent.mm.sdk.b.a.udP.a(locallt, Looper.getMainLooper());
    y.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
  }
  
  public static void onResume()
  {
    af.bDA().T(2, false);
    com.tencent.mm.pluginsdk.wallet.i.Ez(7);
    lt locallt = new lt();
    locallt.bUN.bUO = true;
    com.tencent.mm.sdk.b.a.udP.a(locallt, Looper.getMainLooper());
    y.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
  }
  
  public final void Ni(String paramString) {}
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    this.piq.W(paramInt, paramBoolean);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.peN = paramString1;
    this.hcm = paramString2;
    this.fsv = paramString3;
    this.mSignature = paramString4;
    this.peO = paramBoolean1;
    this.oPz = paramBoolean2;
    this.peP = paramInt;
  }
  
  public final void bCt()
  {
    this.oxg.bIM();
  }
  
  public final void bEp()
  {
    if (this.oxg != null) {
      this.oxg.bIM();
    }
  }
  
  public final ListView bJB()
  {
    return this.piq.bJB();
  }
  
  public final void ba(String paramString, boolean paramBoolean)
  {
    if ((this.piq.getType() == 1) && (this.lwE != null) && (this.lwE.getAdapter() != null) && ((this.lwE.getAdapter() instanceof aw))) {
      ((aw)this.lwE.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void bb(String paramString, boolean paramBoolean) {}
  
  public final void jA(boolean paramBoolean)
  {
    this.piq.jA(paramBoolean);
  }
  
  protected final void jq(boolean paramBoolean)
  {
    y.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
    this.pik.jq(paramBoolean);
  }
  
  /* Error */
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 146
    //   2: new 156	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 476
    //   9: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 481	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +41 -> 65
    //   27: iload_1
    //   28: iconst_5
    //   29: if_icmpeq +13 -> 42
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +8 -> 42
    //   37: iload_1
    //   38: iconst_4
    //   39: if_icmpne +25 -> 64
    //   42: new 128	com/tencent/mm/sdk/platformtools/ah
    //   45: dup
    //   46: invokestatic 134	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   49: invokespecial 137	com/tencent/mm/sdk/platformtools/ah:<init>	(Landroid/os/Looper;)V
    //   52: new 483	com/tencent/mm/plugin/sns/ui/ba$14
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 484	com/tencent/mm/plugin/sns/ui/ba$14:<init>	(Lcom/tencent/mm/plugin/sns/ui/ba;)V
    //   60: invokevirtual 144	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   63: pop
    //   64: return
    //   65: iload_1
    //   66: tableswitch	default:+78 -> 144, 2:+479->545, 3:+78->144, 4:+1378->1444, 5:+371->437, 6:+1399->1465, 7:+1439->1505, 8:+1461->1527, 9:+1507->1573, 10:+1521->1587, 11:+78->144, 12:+1613->1679, 13:+1666->1732, 14:+597->663, 15:+-2->64, 16:+78->144, 17:+87->153
    //   145: i2c
    //   146: ldc_w 486
    //   149: invokestatic 488	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: return
    //   153: aload_3
    //   154: ldc_w 490
    //   157: invokevirtual 494	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   160: checkcast 496	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   163: astore 5
    //   165: aload 5
    //   167: ifnull -103 -> 64
    //   170: aload 5
    //   172: getfield 499	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfh	Z
    //   175: ifeq +33 -> 208
    //   178: aload_0
    //   179: aload 5
    //   181: getfield 502	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfp	Ljava/lang/String;
    //   184: putfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   187: aload_0
    //   188: getfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   191: invokestatic 506	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   194: ifne -130 -> 64
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 94	com/tencent/mm/plugin/sns/ui/ba:ong	Z
    //   202: aload_0
    //   203: aload_3
    //   204: invokespecial 508	com/tencent/mm/plugin/sns/ui/ba:V	(Landroid/content/Intent;)V
    //   207: return
    //   208: ldc 146
    //   210: ldc_w 510
    //   213: iconst_2
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload 5
    //   221: getfield 513	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload 5
    //   229: getfield 516	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfk	Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 519	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: new 212	android/content/Intent
    //   239: dup
    //   240: invokespecial 520	android/content/Intent:<init>	()V
    //   243: astore 4
    //   245: aload 4
    //   247: ldc_w 522
    //   250: aload 5
    //   252: getfield 513	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   255: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   258: pop
    //   259: aload 4
    //   261: ldc_w 524
    //   264: aload 5
    //   266: getfield 516	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfk	Ljava/lang/String;
    //   269: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   272: pop
    //   273: aload 5
    //   275: getfield 527	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   278: invokestatic 506	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   281: ifne +113 -> 394
    //   284: aload 4
    //   286: ldc_w 529
    //   289: aload 5
    //   291: getfield 527	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   294: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   297: pop
    //   298: aload 4
    //   300: ldc 223
    //   302: iconst_1
    //   303: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   306: pop
    //   307: aload 4
    //   309: ldc 229
    //   311: invokestatic 234	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   314: invokevirtual 237	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   317: pop
    //   318: aload 4
    //   320: ldc_w 531
    //   323: bipush 14
    //   325: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload 4
    //   331: ldc_w 257
    //   334: iconst_0
    //   335: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   338: pop
    //   339: aload 4
    //   341: ldc_w 263
    //   344: aload_3
    //   345: ldc_w 263
    //   348: invokevirtual 267	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   351: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   354: pop
    //   355: aload 5
    //   357: getfield 535	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfo	Lcom/tencent/mm/protocal/c/avn;
    //   360: invokevirtual 540	com/tencent/mm/protocal/c/avn:toByteArray	()[B
    //   363: astore_3
    //   364: aload_3
    //   365: ifnull +13 -> 378
    //   368: aload 4
    //   370: ldc_w 542
    //   373: aload_3
    //   374: invokevirtual 545	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   377: pop
    //   378: aload_0
    //   379: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   382: ldc_w 547
    //   385: ldc_w 549
    //   388: aload 4
    //   390: invokestatic 554	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   393: return
    //   394: aload 4
    //   396: ldc_w 529
    //   399: aload 5
    //   401: getfield 513	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   404: invokestatic 559	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   407: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   410: pop
    //   411: goto -113 -> 298
    //   414: astore_3
    //   415: ldc 146
    //   417: ldc_w 561
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload_3
    //   427: invokevirtual 564	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 519	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: goto -56 -> 378
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   442: invokevirtual 568	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   445: aload_3
    //   446: invokestatic 200	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   449: invokestatic 573	com/tencent/mm/pluginsdk/ui/tools/l:f	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   452: putfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   455: ldc 146
    //   457: new 156	java/lang/StringBuilder
    //   460: dup
    //   461: ldc_w 575
    //   464: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: aload_0
    //   468: getfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   471: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 154	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: getfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   484: ifnull -420 -> 64
    //   487: invokestatic 581	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   490: pop
    //   491: invokestatic 585	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   494: invokevirtual 591	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   497: ldc_w 592
    //   500: aconst_null
    //   501: invokevirtual 598	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 600	java/lang/Integer
    //   507: iconst_0
    //   508: invokestatic 603	com/tencent/mm/sdk/platformtools/bk:a	(Ljava/lang/Integer;I)I
    //   511: istore_1
    //   512: invokestatic 581	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   515: pop
    //   516: invokestatic 585	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   519: invokevirtual 591	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   522: ldc_w 592
    //   525: iload_1
    //   526: iconst_1
    //   527: iadd
    //   528: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: invokevirtual 610	com/tencent/mm/storage/z:o	(ILjava/lang/Object;)V
    //   534: aload_0
    //   535: iconst_1
    //   536: putfield 94	com/tencent/mm/plugin/sns/ui/ba:ong	Z
    //   539: aload_0
    //   540: aload_3
    //   541: invokespecial 508	com/tencent/mm/plugin/sns/ui/ba:V	(Landroid/content/Intent;)V
    //   544: return
    //   545: aload_3
    //   546: ifnull -482 -> 64
    //   549: invokestatic 581	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   552: pop
    //   553: invokestatic 585	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   556: invokevirtual 591	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   559: ldc_w 611
    //   562: aconst_null
    //   563: invokevirtual 598	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   566: checkcast 600	java/lang/Integer
    //   569: iconst_0
    //   570: invokestatic 603	com/tencent/mm/sdk/platformtools/bk:a	(Ljava/lang/Integer;I)I
    //   573: istore_1
    //   574: invokestatic 581	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   577: pop
    //   578: invokestatic 585	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   581: invokevirtual 591	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   584: ldc_w 611
    //   587: iload_1
    //   588: iconst_1
    //   589: iadd
    //   590: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   593: invokevirtual 610	com/tencent/mm/storage/z:o	(ILjava/lang/Object;)V
    //   596: new 212	android/content/Intent
    //   599: dup
    //   600: invokespecial 520	android/content/Intent:<init>	()V
    //   603: astore 4
    //   605: aload 4
    //   607: ldc_w 613
    //   610: iconst_4
    //   611: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   614: pop
    //   615: aload 4
    //   617: ldc_w 615
    //   620: iconst_1
    //   621: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   624: pop
    //   625: aload 4
    //   627: ldc_w 617
    //   630: iconst_1
    //   631: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   634: pop
    //   635: getstatic 623	com/tencent/mm/plugin/sns/c/a:eUR	Lcom/tencent/mm/pluginsdk/m;
    //   638: aload_0
    //   639: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   642: aload_3
    //   643: aload 4
    //   645: invokestatic 200	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   648: iconst_4
    //   649: new 625	com/tencent/mm/plugin/sns/ui/ba$2
    //   652: dup
    //   653: aload_0
    //   654: invokespecial 626	com/tencent/mm/plugin/sns/ui/ba$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/ba;)V
    //   657: invokeinterface 631 7 0
    //   662: return
    //   663: new 128	com/tencent/mm/sdk/platformtools/ah
    //   666: dup
    //   667: invokestatic 134	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   670: invokespecial 137	com/tencent/mm/sdk/platformtools/ah:<init>	(Landroid/os/Looper;)V
    //   673: new 633	com/tencent/mm/plugin/sns/ui/ba$3
    //   676: dup
    //   677: aload_0
    //   678: invokespecial 634	com/tencent/mm/plugin/sns/ui/ba$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/ba;)V
    //   681: invokevirtual 144	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   684: pop
    //   685: aload_3
    //   686: ldc_w 636
    //   689: invokevirtual 640	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   692: astore 4
    //   694: aload 4
    //   696: ifnull +11 -> 707
    //   699: aload 4
    //   701: invokevirtual 645	java/util/ArrayList:size	()I
    //   704: ifgt +16 -> 720
    //   707: aload_3
    //   708: ldc_w 647
    //   711: invokevirtual 267	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   714: invokestatic 506	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   717: ifne +414 -> 1131
    //   720: aload 4
    //   722: ifnull +120 -> 842
    //   725: aload 4
    //   727: invokevirtual 645	java/util/ArrayList:size	()I
    //   730: ifle +112 -> 842
    //   733: aload 4
    //   735: iconst_0
    //   736: invokevirtual 650	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   739: checkcast 185	java/lang/String
    //   742: astore 4
    //   744: aload_3
    //   745: ldc_w 652
    //   748: invokevirtual 267	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   751: astore 5
    //   753: aload 5
    //   755: invokestatic 506	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   758: ifne +14 -> 772
    //   761: aload 5
    //   763: astore_3
    //   764: aload 5
    //   766: invokestatic 655	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   769: ifne +176 -> 945
    //   772: new 156	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   779: invokestatic 200	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   782: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload 4
    //   787: invokestatic 559	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   790: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: astore_3
    //   797: new 657	android/media/MediaMetadataRetriever
    //   800: dup
    //   801: invokespecial 658	android/media/MediaMetadataRetriever:<init>	()V
    //   804: astore 5
    //   806: aload 5
    //   808: aload 4
    //   810: invokevirtual 661	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   813: aload 5
    //   815: lconst_0
    //   816: invokevirtual 665	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   819: astore 6
    //   821: aload 6
    //   823: ifnonnull +31 -> 854
    //   826: ldc 146
    //   828: ldc_w 667
    //   831: invokestatic 488	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload 5
    //   836: invokevirtual 670	android/media/MediaMetadataRetriever:release	()V
    //   839: return
    //   840: astore_3
    //   841: return
    //   842: aload_3
    //   843: ldc_w 647
    //   846: invokevirtual 267	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   849: astore 4
    //   851: goto -107 -> 744
    //   854: ldc 146
    //   856: ldc_w 672
    //   859: iconst_2
    //   860: anewarray 4	java/lang/Object
    //   863: dup
    //   864: iconst_0
    //   865: aload 6
    //   867: invokevirtual 677	android/graphics/Bitmap:getWidth	()I
    //   870: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   873: aastore
    //   874: dup
    //   875: iconst_1
    //   876: aload 6
    //   878: invokevirtual 680	android/graphics/Bitmap:getHeight	()I
    //   881: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   884: aastore
    //   885: invokestatic 519	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   888: aload 6
    //   890: bipush 80
    //   892: getstatic 686	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   895: aload_3
    //   896: iconst_1
    //   897: invokestatic 691	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   900: aload_3
    //   901: invokestatic 695	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   904: astore 6
    //   906: ldc 146
    //   908: ldc_w 697
    //   911: iconst_2
    //   912: anewarray 4	java/lang/Object
    //   915: dup
    //   916: iconst_0
    //   917: aload 6
    //   919: getfield 702	android/graphics/BitmapFactory$Options:outWidth	I
    //   922: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: aastore
    //   926: dup
    //   927: iconst_1
    //   928: aload 6
    //   930: getfield 705	android/graphics/BitmapFactory$Options:outHeight	I
    //   933: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   936: aastore
    //   937: invokestatic 519	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   940: aload 5
    //   942: invokevirtual 670	android/media/MediaMetadataRetriever:release	()V
    //   945: ldc 146
    //   947: ldc_w 707
    //   950: iconst_4
    //   951: anewarray 4	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload 4
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: aload_3
    //   962: aastore
    //   963: dup
    //   964: iconst_2
    //   965: aload 4
    //   967: invokestatic 711	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   970: invokestatic 716	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   973: aastore
    //   974: dup
    //   975: iconst_3
    //   976: aload_3
    //   977: invokestatic 711	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   980: invokestatic 716	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   983: aastore
    //   984: invokestatic 519	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   987: new 212	android/content/Intent
    //   990: dup
    //   991: invokespecial 520	android/content/Intent:<init>	()V
    //   994: astore 5
    //   996: aload 5
    //   998: ldc_w 522
    //   1001: aload 4
    //   1003: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1006: pop
    //   1007: aload 5
    //   1009: ldc_w 524
    //   1012: aload_3
    //   1013: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1016: pop
    //   1017: aload 5
    //   1019: ldc_w 529
    //   1022: aload 4
    //   1024: invokestatic 559	com/tencent/mm/vfs/e:aeY	(Ljava/lang/String;)Ljava/lang/String;
    //   1027: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1030: pop
    //   1031: aload 5
    //   1033: ldc 223
    //   1035: iconst_1
    //   1036: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1039: pop
    //   1040: aload 5
    //   1042: ldc 229
    //   1044: invokestatic 234	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   1047: invokevirtual 237	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1050: pop
    //   1051: aload 5
    //   1053: ldc_w 531
    //   1056: bipush 14
    //   1058: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1061: pop
    //   1062: aload 5
    //   1064: ldc_w 257
    //   1067: iconst_0
    //   1068: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1071: pop
    //   1072: aload_0
    //   1073: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   1076: ldc_w 547
    //   1079: ldc_w 549
    //   1082: aload 5
    //   1084: invokestatic 554	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1087: return
    //   1088: astore 6
    //   1090: ldc 146
    //   1092: ldc_w 718
    //   1095: iconst_1
    //   1096: anewarray 4	java/lang/Object
    //   1099: dup
    //   1100: iconst_0
    //   1101: aload 6
    //   1103: invokevirtual 564	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1106: aastore
    //   1107: invokestatic 720	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1110: aload 5
    //   1112: invokevirtual 670	android/media/MediaMetadataRetriever:release	()V
    //   1115: goto -170 -> 945
    //   1118: astore 5
    //   1120: goto -175 -> 945
    //   1123: astore_3
    //   1124: aload 5
    //   1126: invokevirtual 670	android/media/MediaMetadataRetriever:release	()V
    //   1129: aload_3
    //   1130: athrow
    //   1131: aload_3
    //   1132: ldc_w 722
    //   1135: invokevirtual 640	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1138: astore 4
    //   1140: aload 4
    //   1142: ifnull +11 -> 1153
    //   1145: aload 4
    //   1147: invokevirtual 645	java/util/ArrayList:size	()I
    //   1150: ifne +12 -> 1162
    //   1153: ldc 146
    //   1155: ldc_w 724
    //   1158: invokestatic 481	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1161: return
    //   1162: new 642	java/util/ArrayList
    //   1165: dup
    //   1166: invokespecial 725	java/util/ArrayList:<init>	()V
    //   1169: astore 5
    //   1171: aload 4
    //   1173: invokevirtual 729	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1176: astore 6
    //   1178: aload 6
    //   1180: invokeinterface 735 1 0
    //   1185: ifeq +76 -> 1261
    //   1188: aload 6
    //   1190: invokeinterface 739 1 0
    //   1195: checkcast 185	java/lang/String
    //   1198: astore 7
    //   1200: aload 7
    //   1202: invokestatic 745	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   1205: invokevirtual 749	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   1208: astore 8
    //   1210: aload 8
    //   1212: ifnull -34 -> 1178
    //   1215: aload 5
    //   1217: ldc_w 751
    //   1220: iconst_3
    //   1221: anewarray 4	java/lang/Object
    //   1224: dup
    //   1225: iconst_0
    //   1226: aload 7
    //   1228: aastore
    //   1229: dup
    //   1230: iconst_1
    //   1231: aload 8
    //   1233: getfield 757	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   1236: invokestatic 762	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1239: aastore
    //   1240: dup
    //   1241: iconst_2
    //   1242: aload 8
    //   1244: getfield 765	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   1247: invokestatic 762	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1250: aastore
    //   1251: invokestatic 769	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1254: invokevirtual 773	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1257: pop
    //   1258: goto -80 -> 1178
    //   1261: aload_0
    //   1262: aload_3
    //   1263: ldc_w 775
    //   1266: iconst_0
    //   1267: invokevirtual 779	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1270: putfield 94	com/tencent/mm/plugin/sns/ui/ba:ong	Z
    //   1273: new 212	android/content/Intent
    //   1276: dup
    //   1277: aload_0
    //   1278: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   1281: ldc 218
    //   1283: invokespecial 221	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1286: astore 6
    //   1288: aload 6
    //   1290: ldc 223
    //   1292: iconst_1
    //   1293: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1296: pop
    //   1297: aload 6
    //   1299: ldc 229
    //   1301: invokestatic 234	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   1304: invokevirtual 237	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1307: pop
    //   1308: aload_0
    //   1309: getfield 120	com/tencent/mm/plugin/sns/ui/ba:piE	Lcom/tencent/mm/modelsns/b;
    //   1312: ifnull +19 -> 1331
    //   1315: aload_0
    //   1316: getfield 120	com/tencent/mm/plugin/sns/ui/ba:piE	Lcom/tencent/mm/modelsns/b;
    //   1319: aload 6
    //   1321: ldc 239
    //   1323: invokevirtual 245	com/tencent/mm/modelsns/b:b	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1326: aload_0
    //   1327: aconst_null
    //   1328: putfield 120	com/tencent/mm/plugin/sns/ui/ba:piE	Lcom/tencent/mm/modelsns/b;
    //   1331: aload_0
    //   1332: getfield 259	com/tencent/mm/plugin/sns/ui/ba:oPz	Z
    //   1335: ifeq +14 -> 1349
    //   1338: aload 6
    //   1340: ldc_w 261
    //   1343: bipush 11
    //   1345: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1348: pop
    //   1349: aload_3
    //   1350: ldc 210
    //   1352: iconst_0
    //   1353: invokevirtual 216	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1356: istore_1
    //   1357: aload 6
    //   1359: ldc_w 781
    //   1362: aload 4
    //   1364: invokevirtual 784	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1367: pop
    //   1368: aload 6
    //   1370: ldc 252
    //   1372: iload_1
    //   1373: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1376: pop
    //   1377: aload_0
    //   1378: getfield 94	com/tencent/mm/plugin/sns/ui/ba:ong	Z
    //   1381: ifeq +13 -> 1394
    //   1384: aload 6
    //   1386: ldc_w 257
    //   1389: iconst_1
    //   1390: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1393: pop
    //   1394: aload 6
    //   1396: ldc_w 786
    //   1399: aload 5
    //   1401: invokevirtual 790	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1404: pop
    //   1405: ldc 146
    //   1407: ldc_w 792
    //   1410: iconst_1
    //   1411: anewarray 4	java/lang/Object
    //   1414: dup
    //   1415: iconst_0
    //   1416: aload 6
    //   1418: ldc_w 531
    //   1421: iconst_m1
    //   1422: invokevirtual 216	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1425: invokestatic 607	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1428: aastore
    //   1429: invokestatic 794	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1432: aload_0
    //   1433: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   1436: aload 6
    //   1438: bipush 6
    //   1440: invokevirtual 273	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1443: return
    //   1444: aload_3
    //   1445: ifnull -1381 -> 64
    //   1448: aload_0
    //   1449: aload_3
    //   1450: ldc_w 796
    //   1453: invokevirtual 267	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1456: putfield 163	com/tencent/mm/plugin/sns/ui/ba:filePath	Ljava/lang/String;
    //   1459: aload_0
    //   1460: aload_3
    //   1461: invokespecial 508	com/tencent/mm/plugin/sns/ui/ba:V	(Landroid/content/Intent;)V
    //   1464: return
    //   1465: ldc 146
    //   1467: ldc_w 798
    //   1470: invokestatic 154	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1473: aload_3
    //   1474: ifnull -1410 -> 64
    //   1477: aload_3
    //   1478: ldc_w 800
    //   1481: iconst_m1
    //   1482: invokevirtual 216	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1485: istore_1
    //   1486: aload_0
    //   1487: getfield 285	com/tencent/mm/plugin/sns/ui/ba:piq	Lcom/tencent/mm/plugin/sns/ui/ba$a;
    //   1490: iload_1
    //   1491: aconst_null
    //   1492: aconst_null
    //   1493: invokeinterface 803 4 0
    //   1498: invokestatic 807	com/tencent/mm/plugin/sns/model/af:bDB	()Lcom/tencent/mm/plugin/sns/model/aw;
    //   1501: invokevirtual 812	com/tencent/mm/plugin/sns/model/aw:bCp	()V
    //   1504: return
    //   1505: ldc 146
    //   1507: ldc_w 814
    //   1510: invokestatic 154	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1513: aload_0
    //   1514: getfield 428	com/tencent/mm/plugin/sns/ui/ba:oxg	Lcom/tencent/mm/plugin/sns/ui/SnsHeader;
    //   1517: invokevirtual 433	com/tencent/mm/plugin/sns/ui/SnsHeader:bIM	()V
    //   1520: invokestatic 807	com/tencent/mm/plugin/sns/model/af:bDB	()Lcom/tencent/mm/plugin/sns/model/aw;
    //   1523: invokevirtual 812	com/tencent/mm/plugin/sns/model/aw:bCp	()V
    //   1526: return
    //   1527: aload_3
    //   1528: ifnull -1464 -> 64
    //   1531: ldc 146
    //   1533: ldc_w 816
    //   1536: invokestatic 154	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1539: aload_3
    //   1540: ldc_w 818
    //   1543: invokevirtual 494	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1546: checkcast 820	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1549: astore_3
    //   1550: aload_3
    //   1551: ifnull -1487 -> 64
    //   1554: aload_0
    //   1555: getfield 285	com/tencent/mm/plugin/sns/ui/ba:piq	Lcom/tencent/mm/plugin/sns/ui/ba$a;
    //   1558: iconst_m1
    //   1559: aload_3
    //   1560: getfield 824	com/tencent/mm/plugin/sns/data/SnsCmdList:omR	Ljava/util/List;
    //   1563: aload_3
    //   1564: getfield 827	com/tencent/mm/plugin/sns/data/SnsCmdList:omS	Ljava/util/List;
    //   1567: invokeinterface 803 4 0
    //   1572: return
    //   1573: invokestatic 807	com/tencent/mm/plugin/sns/model/af:bDB	()Lcom/tencent/mm/plugin/sns/model/aw;
    //   1576: invokevirtual 812	com/tencent/mm/plugin/sns/model/aw:bCp	()V
    //   1579: aload_0
    //   1580: getfield 445	com/tencent/mm/plugin/sns/ui/ba:lwE	Landroid/widget/ListView;
    //   1583: invokestatic 832	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$c:a	(Landroid/widget/ListView;)V
    //   1586: return
    //   1587: aload_3
    //   1588: ifnull -1524 -> 64
    //   1591: iload_2
    //   1592: iconst_m1
    //   1593: if_icmpne -1529 -> 64
    //   1596: aload_3
    //   1597: invokevirtual 836	android/content/Intent:getData	()Landroid/net/Uri;
    //   1600: astore_3
    //   1601: aload_0
    //   1602: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   1605: aload_3
    //   1606: aconst_null
    //   1607: aconst_null
    //   1608: aconst_null
    //   1609: aconst_null
    //   1610: invokevirtual 840	android/app/Activity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1613: astore_3
    //   1614: aload_3
    //   1615: invokeinterface 845 1 0
    //   1620: ifeq -1556 -> 64
    //   1623: aload_3
    //   1624: aload_3
    //   1625: ldc_w 847
    //   1628: invokeinterface 851 2 0
    //   1633: invokeinterface 855 2 0
    //   1638: astore_3
    //   1639: new 212	android/content/Intent
    //   1642: dup
    //   1643: ldc_w 857
    //   1646: new 156	java/lang/StringBuilder
    //   1649: dup
    //   1650: ldc_w 859
    //   1653: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1656: aload_3
    //   1657: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1663: invokestatic 865	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1666: invokespecial 868	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1669: astore_3
    //   1670: aload_0
    //   1671: getfield 122	com/tencent/mm/plugin/sns/ui/ba:mActivity	Landroid/app/Activity;
    //   1674: aload_3
    //   1675: invokevirtual 871	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1678: return
    //   1679: aload_3
    //   1680: ldc_w 873
    //   1683: iconst_m1
    //   1684: invokevirtual 216	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1687: istore_1
    //   1688: iload_1
    //   1689: ifle -1625 -> 64
    //   1692: ldc 146
    //   1694: ldc_w 875
    //   1697: invokestatic 154	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1700: new 820	com/tencent/mm/plugin/sns/data/SnsCmdList
    //   1703: dup
    //   1704: invokespecial 876	com/tencent/mm/plugin/sns/data/SnsCmdList:<init>	()V
    //   1707: astore_3
    //   1708: aload_3
    //   1709: iload_1
    //   1710: invokevirtual 879	com/tencent/mm/plugin/sns/data/SnsCmdList:xz	(I)V
    //   1713: aload_0
    //   1714: getfield 285	com/tencent/mm/plugin/sns/ui/ba:piq	Lcom/tencent/mm/plugin/sns/ui/ba$a;
    //   1717: iconst_m1
    //   1718: aload_3
    //   1719: getfield 824	com/tencent/mm/plugin/sns/data/SnsCmdList:omR	Ljava/util/List;
    //   1722: aload_3
    //   1723: getfield 827	com/tencent/mm/plugin/sns/data/SnsCmdList:omS	Ljava/util/List;
    //   1726: invokeinterface 803 4 0
    //   1731: return
    //   1732: invokestatic 883	com/tencent/mm/plugin/sns/model/af:bDK	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   1735: invokevirtual 888	com/tencent/mm/plugin/sns/storage/k:aAp	()Z
    //   1738: pop
    //   1739: return
    //   1740: astore 5
    //   1742: goto -797 -> 945
    //   1745: astore 4
    //   1747: goto -618 -> 1129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1750	0	this	ba
    //   0	1750	1	paramInt1	int
    //   0	1750	2	paramInt2	int
    //   0	1750	3	paramIntent	Intent
    //   243	1120	4	localObject1	Object
    //   1745	1	4	localException1	java.lang.Exception
    //   163	948	5	localObject2	Object
    //   1118	7	5	localException2	java.lang.Exception
    //   1169	231	5	localArrayList	java.util.ArrayList
    //   1740	1	5	localException3	java.lang.Exception
    //   819	110	6	localObject3	Object
    //   1088	14	6	localException4	java.lang.Exception
    //   1176	261	6	localObject4	Object
    //   1198	29	7	str	String
    //   1208	35	8	locala	com.tencent.mm.compatible.util.Exif.a
    // Exception table:
    //   from	to	target	type
    //   355	364	414	java/lang/Exception
    //   368	378	414	java/lang/Exception
    //   834	839	840	java/lang/Exception
    //   806	821	1088	java/lang/Exception
    //   826	834	1088	java/lang/Exception
    //   854	940	1088	java/lang/Exception
    //   1110	1115	1118	java/lang/Exception
    //   806	821	1123	finally
    //   826	834	1123	finally
    //   854	940	1123	finally
    //   1090	1110	1123	finally
    //   940	945	1740	java/lang/Exception
    //   1124	1129	1745	java/lang/Exception
  }
  
  public final void onCreate()
  {
    this.oki = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
    af.bDC().start();
    if (this.pir != null) {
      this.pis = ((Toolbar.LayoutParams)this.pir.getLayoutParams());
    }
    this.lwE = this.piq.bJB();
    this.lwE.post(new ba.1(this));
    Object localObject = new StringBuilder("list is null ? ");
    boolean bool;
    label272:
    SnsHeader localSnsHeader;
    label424:
    String str2;
    String str3;
    String str1;
    if (this.lwE != null)
    {
      bool = true;
      y.i("MicroMsg.SnsActivity", bool);
      this.lwE.setScrollingCacheEnabled(false);
      this.oxg = new SnsHeader(this.mActivity);
      this.oxg.setBackClickListener(new ba.7(this));
      this.kcm = this.piq.bJC();
      this.hoY = this.piq.bJD();
      this.oxg.setHeadBgListener(new ba.8(this));
      this.pik = new LoadingMoreView(this.mActivity);
      this.lwE.addHeaderView(this.oxg);
      this.lwE.addFooterView(this.pik);
      this.lwE.setOnScrollListener(new ba.9(this));
      this.mbz = this.piq.bJE();
      localObject = new StringBuilder("pullDownView is null ? ");
      if (this.mbz == null) {
        break label533;
      }
      bool = true;
      y.i("MicroMsg.SnsActivity", bool);
      this.mbz.setOnTopLoadDataListener(new ba.10(this));
      this.mbz.setTopViewVisible(false);
      this.mbz.setIsTopShowAll(false);
      this.mbz.setAtBottomCallBack(new ba.11(this));
      this.mbz.setAtTopCallBack(new ba.12(this));
      this.mbz.setIsBottomShowAll(false);
      this.mbz.setOnBottomLoadDataListener(new ba.13(this));
      this.mbz.setShowBackground(true);
      this.mbz.setBgColor("#f4f4f4");
      this.title = this.mActivity.getIntent().getStringExtra("sns_title");
      localSnsHeader = this.oxg;
      if (!bk.bl(this.hcm)) {
        break label538;
      }
      localObject = this.peN;
      str2 = this.peN;
      str3 = this.fsv;
      str1 = this.mSignature;
      if ((localObject != null) && (str2 != null)) {
        break label546;
      }
      y.e("MicroMsg.SnsHeader", "userName or selfName is null ");
      this.oxg.setType(this.piq.getType());
      this.oxg.bIM();
      if (Build.VERSION.SDK_INT >= 11) {
        break label758;
      }
      y.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
    }
    for (;;)
    {
      af.bDB().dup.add(this);
      com.tencent.mm.plugin.sns.model.aw.ooB += 1;
      af.bDA().a(this);
      return;
      bool = false;
      break;
      label533:
      bool = false;
      break label272;
      label538:
      localObject = this.hcm;
      break label424;
      label546:
      localSnsHeader.userName = ((String)localObject).trim();
      localSnsHeader.diG = str2.trim();
      localSnsHeader.bMo = str2.equals(localObject);
      y.d("MicroMsg.SnsHeader", "userNamelen " + ((String)localObject).length() + "  " + (String)localObject);
      localSnsHeader.oYj.hPg.setText((CharSequence)localObject);
      if ((localSnsHeader.oYj == null) || (localSnsHeader.oYj.dpY == null)) {}
      for (;;)
      {
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = com.tencent.mm.plugin.sns.data.i.z(str3);
          localSnsHeader.oYj.hPg.setText(j.b(localSnsHeader.context, (CharSequence)localObject));
          localSnsHeader.oYj.oMX.setText(j.a(localSnsHeader.context, str1, localSnsHeader.oYj.oMX.getTextSize()));
        }
        localSnsHeader.oYj.dpY.setContentDescription(localSnsHeader.context.getString(i.j.sns_avatar_desc, new Object[] { localSnsHeader.oYj.hPg.getText() }));
        break;
        a.b.p(localSnsHeader.oYj.dpY, localSnsHeader.userName);
      }
      label758:
      new ba.6(this).run();
    }
  }
  
  public final void onDestroy()
  {
    if (this.oxg != null)
    {
      SnsHeader localSnsHeader = this.oxg;
      if ((localSnsHeader.oYp != null) && (!localSnsHeader.oYp.isRecycled())) {
        localSnsHeader.oYp.recycle();
      }
    }
    com.tencent.mm.kernel.g.DQ();
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      af.bDC().M(this.mActivity);
      af.bDA().b(this);
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.DQ();
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      af.bDB().dup.remove(this);
      com.tencent.mm.plugin.sns.model.aw.ooB -= 1;
    }
    this.pik.setVisibility(8);
    aa.bHF();
    com.tencent.mm.kernel.g.DQ();
    if (com.tencent.mm.kernel.g.DN().Dc()) {
      af.bDC().start();
    }
    this.lwE.setAdapter(null);
  }
  
  protected final void yA(int paramInt)
  {
    y.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
    this.pik.yA(paramInt);
  }
  
  protected final boolean yW(final int paramInt)
  {
    int i = 3;
    boolean bool = true;
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.mActivity);
      bool = false;
    }
    Object localObject;
    do
    {
      return bool;
      y.d("MicroMsg.SnsActivity", "selectPhoto " + paramInt);
      if (paramInt == 2)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("username", this.peN);
        ((Intent)localObject).setClass(this.mActivity, SettingSnsBackgroundUI.class);
        this.mActivity.startActivityForResult((Intent)localObject, 7);
        return true;
      }
    } while (paramInt != 1);
    com.tencent.mm.kernel.g.DQ();
    int j = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(68385, null), 0);
    com.tencent.mm.kernel.g.DQ();
    int k = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(68386, null), 0);
    if ((!this.pim) && (j < 3) && (k == 0))
    {
      this.pim = true;
      localObject = this.mActivity;
      DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          com.tencent.mm.kernel.g.DQ();
          paramAnonymousInt = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(68386, null), 0);
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(68386, Integer.valueOf(paramAnonymousInt + 1));
          ba.this.yW(paramInt);
        }
      };
      c.a locala = new c.a((Context)localObject);
      locala.Ip(i.j.sns_welcome_tip);
      locala.aeA(((Context)localObject).getString(i.j.sns_welcome_titlea) + "\n\n" + ((Context)localObject).getString(i.j.sns_welcome_titlec));
      locala.Is(i.j.welcome_i_know).a(local5);
      locala.a(new bb.1());
      locala.aoP().show();
      return true;
    }
    if (this.mActivity.getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).getString("gallery", "1").equalsIgnoreCase("0"))
    {
      com.tencent.mm.pluginsdk.ui.tools.l.a(this.mActivity, 2, null);
      return true;
    }
    paramInt = com.tencent.mm.m.g.AA().getInt("SnsCanPickVideoFromAlbum", 1);
    y.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[] { Integer.valueOf(paramInt) });
    if (com.tencent.mm.platformtools.ae.eTJ) {
      paramInt = 0;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_edit_video_max_time_length", d.Nl().No().duration);
      com.tencent.mm.pluginsdk.ui.tools.l.a(this.mActivity, 14, 9, 4, i, false, (Intent)localObject);
      return true;
      if (paramInt == 0) {
        i = 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void W(int paramInt, boolean paramBoolean);
    
    public abstract void a(int paramInt, List<Integer> paramList1, List<Integer> paramList2);
    
    public abstract void bJA();
    
    public abstract ListView bJB();
    
    public abstract View bJC();
    
    public abstract View bJD();
    
    public abstract MMPullDownView bJE();
    
    public abstract boolean bJF();
    
    public abstract void bJG();
    
    public abstract void bJH();
    
    public abstract void ea(int paramInt1, int paramInt2);
    
    public abstract int getType();
    
    public abstract void jA(boolean paramBoolean);
    
    public abstract void yP(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */