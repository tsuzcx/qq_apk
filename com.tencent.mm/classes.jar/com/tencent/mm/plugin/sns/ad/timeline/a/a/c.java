package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.f.j;
import com.tencent.mm.plugin.sns.ad.timeline.b.a.1;
import com.tencent.mm.plugin.sns.ad.timeline.b.a.2;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.e.b.1;
import com.tencent.mm.plugin.sns.e.b.2;
import com.tencent.mm.plugin.sns.e.b.3;
import com.tencent.mm.plugin.sns.e.b.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class c
{
  private int JCO;
  private int JHe;
  AdClickActionInfo JHf;
  private com.tencent.mm.plugin.sns.ad.f.l JHg;
  a JHh;
  b JHi;
  com.tencent.mm.plugin.sns.ad.timeline.b.a JHj;
  SnsInfo Jws;
  Context mContext;
  private int mScene;
  
  public c(Context paramContext, int paramInt, com.tencent.mm.plugin.sns.ad.f.l paraml, a parama, b paramb)
  {
    this.mContext = paramContext;
    this.JCO = paramInt;
    this.JHg = paraml;
    this.JHh = parama;
    this.JHi = paramb;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick, int paramInt)
  {
    AppMethodBeat.i(214862);
    com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject1 = a.f.Kky;
    String str8;
    String str6;
    Object localObject2;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bN(MMApplicationContext.getContext(), paramString2))
    {
      String str5 = "";
      String str7 = "";
      String str4 = "";
      String str3 = "";
      String str2 = "";
      str8 = "";
      com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "isPkgInstalled==true");
      str6 = str8;
      String str1 = str2;
      Object localObject3 = str3;
      paramSnsAdClick = str7;
      localObject2 = str5;
      localObject1 = str4;
      if (this.Jws != null)
      {
        localObject1 = this.Jws.getAdInfo(this.JCO);
        paramSnsAdClick = str7;
        if (localObject1 != null) {
          paramSnsAdClick = Util.nullAsNil(((ADInfo)localObject1).uxInfo);
        }
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
      }
      try
      {
        str5 = Util.nullAsNil(this.Jws.getAdXml().adExtInfo);
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str4 = String.valueOf(com.tencent.mm.plugin.sns.data.m.aYS(Util.nullAsNil(this.Jws.getSnsId())));
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str3 = Util.nullAsNil(this.Jws.getAid());
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str2 = Util.nullAsNil(this.Jws.getTraceid());
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str6 = Util.nullAsNil(this.Jws.getPid());
        localObject1 = str4;
        localObject2 = str5;
        localObject3 = str3;
        str1 = str2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", localThrowable.toString());
          str6 = str8;
        }
      }
      com.tencent.mm.plugin.sns.ad.d.b.a(true, this.Jws);
      localObject3 = new j((String)localObject3, str1, str6);
      com.tencent.mm.plugin.sns.data.m.a(this.mContext, paramString1, paramString2, "", paramString3, paramSnsAdClick, (String)localObject2, (String)localObject1, 0, 0, (j)localObject3);
      if (TextUtils.isEmpty(paramString3)) {
        break label447;
      }
      AppMethodBeat.o(214862);
      return 34;
    }
    localObject1 = a.f.Kky;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "isApkExist==true");
      com.tencent.mm.plugin.sns.ad.d.b.a(false, this.Jws);
      com.tencent.mm.plugin.sns.ad.d.a.kl(paramString2, paramString3);
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
    }
    for (;;)
    {
      label447:
      AppMethodBeat.o(214862);
      return 21;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.Jws != null) {}
      try
      {
        paramString1 = this.Jws.getAdInfo(this.JCO);
        bool1 = com.tencent.mm.plugin.sns.data.m.b(this.mContext, this.Jws, paramString1);
        if (!bool1)
        {
          com.tencent.mm.plugin.sns.ad.d.b.a(false, this.Jws);
          paramString3 = this.Jws;
          paramString2 = (Activity)this.mContext;
          int i = this.JCO;
          localObject1 = this.JHi.fLd();
          localObject2 = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
          if (paramString3 == null) {}
          for (paramString1 = "";; paramString1 = t.Qu(paramString3.field_snsId))
          {
            com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", paramString1);
            paramString1 = a(paramString3, paramString2, i, (View)localObject1, paramInt);
            if (paramString1 == null) {
              break label687;
            }
            this.JHi.fLc();
            paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
            paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString1);
            com.tencent.mm.hellhoundlib.a.a.b(paramString2, paramString1.aFh(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.startActivity((Intent)paramString1.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString2, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.overridePendingTransition(0, 0);
            break;
          }
          label687:
          a(paramString3, paramSnsAdClick, i, paramString2);
          continue;
        }
        com.tencent.mm.plugin.sns.ad.d.a.kl(paramString2, paramString3);
        AppMethodBeat.o(214862);
        return 36;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  private static Intent a(SnsInfo paramSnsInfo, Activity paramActivity, int paramInt1, View paramView, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(214873);
    Intent localIntent;
    if (i.bbf(paramSnsInfo.getAdSnsInfo().field_adxml))
    {
      localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramSnsInfo.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramSnsInfo.getTimeLine().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramSnsInfo.getUxinfo());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt1 == 2) {
        paramInt1 = 16;
      }
    }
    for (;;)
    {
      localIntent.putExtra("sns_landig_pages_from_source", paramInt1);
      localIntent.putExtra("sns_landing_pages_xml", paramSnsInfo.getAdSnsInfo().field_adxml);
      localIntent.putExtra("sns_landing_pages_rec_src", paramSnsInfo.getAdRecSrc());
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      localIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
      int i;
      if (paramView != null)
      {
        paramActivity = new int[2];
        if (paramView == null) {
          break label358;
        }
        paramView.getLocationInWindow(paramActivity);
        i = paramView.getWidth();
        paramInt1 = paramView.getHeight();
      }
      for (;;)
      {
        localIntent.putExtra("img_gallery_left", paramActivity[0]);
        localIntent.putExtra("img_gallery_top", paramActivity[1]);
        localIntent.putExtra("img_gallery_width", i);
        localIntent.putExtra("img_gallery_height", paramInt1);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        label237:
        paramSnsInfo = paramSnsInfo.getTimeLine();
        if ((paramSnsInfo.ContentObj.Sqq == 15) && (paramSnsInfo.sightFolded != 1)) {}
        for (;;)
        {
          localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
          localIntent.putExtra("sns_landing_pages_from_outer_index", paramInt2);
          AppMethodBeat.o(214873);
          return localIntent;
          if (paramInt1 != 1) {
            break label366;
          }
          paramInt1 = 2;
          break;
          localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
          break label237;
          bool = false;
        }
        com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "adxml is invalid, snsId=" + t.Qu(paramSnsInfo.field_snsId));
        AppMethodBeat.o(214873);
        return null;
        label358:
        paramInt1 = 0;
        i = 0;
      }
      label366:
      paramInt1 = 1;
    }
  }
  
  private static void a(SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(214855);
    String str2 = paramSnsInfo.getAdInfoLink();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramSnsInfo.getAdLink();
    }
    if (TextUtils.isEmpty(str1))
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "jumpUpdateWebUI both url is empty");
      AppMethodBeat.o(214855);
      return;
    }
    a(str1, paramSnsInfo, paramSnsAdClick, paramInt, paramContext);
    AppMethodBeat.o(214855);
  }
  
  private static void a(String paramString, SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    boolean bool2 = false;
    AppMethodBeat.i(214869);
    com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramSnsInfo);
    if ((TextUtils.isEmpty(paramString)) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(214869);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramSnsInfo.getAdXml().webrightBar == 0)
    {
      bool1 = true;
      if (!ac.mFV) {
        break label386;
      }
      bool1 = bool2;
    }
    label386:
    for (;;)
    {
      String str = paramString;
      if (paramSnsInfo != null)
      {
        str = paramString;
        if (paramSnsInfo.isAd())
        {
          ADInfo localADInfo = paramSnsInfo.getAdInfo(paramInt);
          str = paramString;
          if (localADInfo != null)
          {
            localIntent.putExtra("KsnsViewId", localADInfo.viewId);
            str = com.tencent.mm.plugin.sns.ad.c.a.a.aYo(t.kw(paramString, localADInfo.uxInfo));
            t.g(localIntent, localADInfo.uxInfo);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramSnsInfo.getTimeLine().statExtStr);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramSnsInfo.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + t.Qu(paramSnsInfo.field_snsId));
      localIntent.putExtra("pre_username", paramSnsInfo.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + t.Qu(paramSnsInfo.field_snsId));
      localIntent.putExtra("preUsername", paramSnsInfo.field_userName);
      com.tencent.mm.plugin.sns.c.a.mIG.h(localIntent, paramContext);
      AppMethodBeat.o(214869);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, int paramInt)
  {
    this.JHf = paramAdClickActionInfo;
    this.Jws = paramSnsInfo;
    this.mScene = this.JHf.scene;
    this.JHe = paramInt;
  }
  
  /* Error */
  public final void gd(View paramView)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: ldc_w 530
    //   8: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: bipush 26
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 523	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   18: iconst_1
    //   19: if_icmpne +375 -> 394
    //   22: bipush 26
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   29: istore 5
    //   31: aload_0
    //   32: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: istore_3
    //   40: new 532	com/tencent/mm/modelsns/SnsAdClick
    //   43: dup
    //   44: iload 5
    //   46: iload_3
    //   47: aload_0
    //   48: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   51: getfield 281	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   54: iload_2
    //   55: iconst_0
    //   56: invokespecial 535	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
    //   59: astore 12
    //   61: aload 12
    //   63: aload_0
    //   64: getfield 47	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHg	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   67: aload_0
    //   68: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   71: iload_2
    //   72: aload_0
    //   73: getfield 525	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHe	I
    //   76: invokestatic 538	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/f/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;II)V
    //   79: ldc 64
    //   81: new 66	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 540
    //   88: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   95: getfield 543	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jxx	I
    //   98: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc_w 545
    //   104: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   111: getfield 281	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   114: invokestatic 286	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   117: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 547
    //   123: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   130: getfield 521	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   133: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc_w 549
    //   139: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: getfield 525	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHe	I
    //   146: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   159: getfield 543	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jxx	I
    //   162: tableswitch	default:+1764 -> 1926, 0:+494->656, 1:+684->846, 2:+607->769, 3:+278->440, 4:+529->691, 5:+648->810, 6:+906->1068, 7:+1012->1174, 8:+74->236, 9:+74->236, 10:+74->236, 11:+74->236, 12:+1493->1655, 13:+1573->1735, 14:+1617->1779
    //   237: aload_0
    //   238: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   241: invokestatic 554	com/tencent/mm/plugin/sns/ad/timeline/a/a:e	(ILandroid/content/Context;)Lcom/tencent/mm/plugin/sns/ad/timeline/a/c;
    //   244: astore 11
    //   246: new 556	com/tencent/mm/plugin/sns/ad/timeline/a/d
    //   249: dup
    //   250: invokespecial 557	com/tencent/mm/plugin/sns/ad/timeline/a/d:<init>	()V
    //   253: astore 13
    //   255: aload 13
    //   257: ldc_w 559
    //   260: aload 12
    //   262: invokevirtual 563	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: aload 13
    //   268: ldc_w 564
    //   271: aload_0
    //   272: getfield 523	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   275: invokestatic 569	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokevirtual 563	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload 13
    //   284: ldc_w 571
    //   287: aload_0
    //   288: getfield 525	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHe	I
    //   291: invokestatic 569	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: invokevirtual 563	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: aload 11
    //   300: ifnull +22 -> 322
    //   303: aload 11
    //   305: aload_1
    //   306: aload_0
    //   307: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   310: aload_0
    //   311: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   314: aload 13
    //   316: invokeinterface 576 5 0
    //   321: pop
    //   322: iconst_0
    //   323: istore_2
    //   324: ldc 64
    //   326: new 66	java/lang/StringBuilder
    //   329: dup
    //   330: ldc_w 578
    //   333: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: aload 12
    //   338: getfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   341: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: iload_2
    //   351: ifne +8 -> 359
    //   354: aload 12
    //   356: invokestatic 584	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
    //   359: aload_0
    //   360: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   363: ifnull +24 -> 387
    //   366: aload_0
    //   367: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   370: aload_0
    //   371: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   374: getfield 587	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:appGiftPackCode	Ljava/lang/String;
    //   377: aload_0
    //   378: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   381: getfield 590	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:appGiftPackCodeTips	Ljava/lang/String;
    //   384: invokestatic 594	com/tencent/mm/plugin/sns/ad/d/a:O	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   387: ldc_w 530
    //   390: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: return
    //   394: aload_0
    //   395: getfield 523	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   398: iconst_2
    //   399: if_icmpne +9 -> 408
    //   402: bipush 33
    //   404: istore_2
    //   405: goto -380 -> 25
    //   408: aload_0
    //   409: getfield 523	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   412: iconst_3
    //   413: if_icmpne +9 -> 422
    //   416: bipush 34
    //   418: istore_2
    //   419: goto -394 -> 25
    //   422: aload_0
    //   423: getfield 523	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   426: istore 5
    //   428: iload 5
    //   430: iconst_4
    //   431: if_icmpne -406 -> 25
    //   434: bipush 35
    //   436: istore_2
    //   437: goto -412 -> 25
    //   440: aload 12
    //   442: bipush 21
    //   444: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   447: aload_0
    //   448: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   451: astore 11
    //   453: aload_0
    //   454: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   457: checkcast 215	android/app/Activity
    //   460: astore_1
    //   461: aload_0
    //   462: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   465: istore_2
    //   466: aload_0
    //   467: getfield 51	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHi	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   470: invokeinterface 219 1 0
    //   475: astore 13
    //   477: aload_0
    //   478: getfield 525	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHe	I
    //   481: istore_3
    //   482: new 66	java/lang/StringBuilder
    //   485: dup
    //   486: ldc_w 596
    //   489: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   492: astore 14
    //   494: aload 11
    //   496: ifnonnull +128 -> 624
    //   499: lconst_0
    //   500: lstore 6
    //   502: ldc 64
    //   504: aload 14
    //   506: lload 6
    //   508: invokevirtual 599	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload 11
    //   519: aload_1
    //   520: iload_2
    //   521: aload 13
    //   523: iload_3
    //   524: invokestatic 224	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;I)Landroid/content/Intent;
    //   527: astore 11
    //   529: aload 11
    //   531: ifnull +103 -> 634
    //   534: aload_0
    //   535: getfield 51	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHi	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   538: invokeinterface 227 1 0
    //   543: new 237	com/tencent/mm/hellhoundlib/b/a
    //   546: dup
    //   547: invokespecial 238	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   550: aload 11
    //   552: invokevirtual 242	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   555: astore 11
    //   557: aload_1
    //   558: aload 11
    //   560: invokevirtual 246	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   563: ldc 248
    //   565: ldc_w 601
    //   568: ldc 252
    //   570: ldc 254
    //   572: ldc_w 256
    //   575: ldc_w 258
    //   578: invokestatic 263	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload_1
    //   582: aload 11
    //   584: iconst_0
    //   585: invokevirtual 267	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   588: checkcast 231	android/content/Intent
    //   591: invokevirtual 269	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   594: aload_1
    //   595: ldc 248
    //   597: ldc_w 601
    //   600: ldc 252
    //   602: ldc 254
    //   604: ldc_w 256
    //   607: ldc_w 258
    //   610: invokestatic 273	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload_1
    //   614: iconst_0
    //   615: iconst_0
    //   616: invokevirtual 277	android/app/Activity:overridePendingTransition	(II)V
    //   619: iconst_0
    //   620: istore_2
    //   621: goto -297 -> 324
    //   624: aload 11
    //   626: getfield 281	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   629: lstore 6
    //   631: goto -129 -> 502
    //   634: aload_0
    //   635: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   638: aload 12
    //   640: aload_0
    //   641: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   644: aload_0
    //   645: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   648: invokestatic 289	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)V
    //   651: iconst_0
    //   652: istore_2
    //   653: goto -329 -> 324
    //   656: aload 12
    //   658: iconst_0
    //   659: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   662: aload_0
    //   663: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   666: getfield 604	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jxy	Ljava/lang/String;
    //   669: aload_0
    //   670: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   673: aload 12
    //   675: aload_0
    //   676: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   679: aload_0
    //   680: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   683: invokestatic 412	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)V
    //   686: iconst_0
    //   687: istore_2
    //   688: goto -364 -> 324
    //   691: aload 12
    //   693: bipush 31
    //   695: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   698: aload_0
    //   699: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   702: getfield 607	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:uMJ	Ljava/lang/String;
    //   705: aload_0
    //   706: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   709: getfield 610	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lpQ	Ljava/lang/String;
    //   712: new 66	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 611	java/lang/StringBuilder:<init>	()V
    //   719: aload_0
    //   720: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   723: getfield 614	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lpR	I
    //   726: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: aload_0
    //   733: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   736: aload_0
    //   737: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   740: invokestatic 619	com/tencent/mm/plugin/sns/ui/d/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)Z
    //   743: pop
    //   744: invokestatic 625	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:fLk	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
    //   747: aload_0
    //   748: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   751: aload_0
    //   752: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   755: invokevirtual 628	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:a	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   758: iconst_0
    //   759: istore_2
    //   760: goto -436 -> 324
    //   763: astore_1
    //   764: iconst_0
    //   765: istore_2
    //   766: goto -442 -> 324
    //   769: aload 12
    //   771: aload_0
    //   772: aload_0
    //   773: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   776: getfield 631	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxM	Ljava/lang/String;
    //   779: aload_0
    //   780: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   783: getfield 634	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxN	Ljava/lang/String;
    //   786: aload_0
    //   787: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   790: getfield 637	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxO	Ljava/lang/String;
    //   793: aload 12
    //   795: aload_0
    //   796: getfield 525	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHe	I
    //   799: invokespecial 639	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelsns/SnsAdClick;I)I
    //   802: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   805: iconst_0
    //   806: istore_2
    //   807: goto -483 -> 324
    //   810: aload 12
    //   812: bipush 32
    //   814: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   817: aload_0
    //   818: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   821: getfield 604	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jxy	Ljava/lang/String;
    //   824: aload_0
    //   825: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   828: aload 12
    //   830: aload_0
    //   831: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   834: aload_0
    //   835: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   838: invokestatic 412	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)V
    //   841: iconst_0
    //   842: istore_2
    //   843: goto -519 -> 324
    //   846: aload 12
    //   848: bipush 11
    //   850: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   853: aload_0
    //   854: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   857: invokevirtual 642	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   860: astore 13
    //   862: ldc 108
    //   864: astore 11
    //   866: aload 11
    //   868: astore_1
    //   869: aload 13
    //   871: ifnull +33 -> 904
    //   874: aload 11
    //   876: astore_1
    //   877: aload 13
    //   879: getfield 646	com/tencent/mm/plugin/sns/storage/ADInfo:mappedCanvasCardExt	Ljava/util/HashMap;
    //   882: ifnull +22 -> 904
    //   885: aload 13
    //   887: getfield 646	com/tencent/mm/plugin/sns/storage/ADInfo:mappedCanvasCardExt	Ljava/util/HashMap;
    //   890: aload_0
    //   891: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   894: getfield 649	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:toN	Ljava/lang/String;
    //   897: invokevirtual 655	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   900: checkcast 150	java/lang/String
    //   903: astore_1
    //   904: aload_1
    //   905: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   908: ifeq +1015 -> 1923
    //   911: ldc 64
    //   913: new 66	java/lang/StringBuilder
    //   916: dup
    //   917: ldc_w 657
    //   920: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   923: aload_0
    //   924: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   927: getfield 649	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:toN	Ljava/lang/String;
    //   930: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   939: aload_0
    //   940: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   943: getfield 660	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:tpJ	Ljava/lang/String;
    //   946: astore_1
    //   947: aload_0
    //   948: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   951: checkcast 215	android/app/Activity
    //   954: astore 11
    //   956: aload_0
    //   957: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   960: getfield 649	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:toN	Ljava/lang/String;
    //   963: astore 13
    //   965: ldc 64
    //   967: new 66	java/lang/StringBuilder
    //   970: dup
    //   971: ldc_w 662
    //   974: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   977: aload 13
    //   979: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: ldc_w 664
    //   985: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload_1
    //   989: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: new 231	android/content/Intent
    //   1001: dup
    //   1002: invokespecial 305	android/content/Intent:<init>	()V
    //   1005: astore 14
    //   1007: aload 14
    //   1009: ldc_w 666
    //   1012: aload 13
    //   1014: invokevirtual 310	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1017: pop
    //   1018: aload 14
    //   1020: ldc_w 668
    //   1023: aload_1
    //   1024: invokevirtual 310	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1027: pop
    //   1028: aload 14
    //   1030: ldc_w 670
    //   1033: bipush 21
    //   1035: invokevirtual 337	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1038: pop
    //   1039: aload 14
    //   1041: ldc_w 672
    //   1044: bipush 15
    //   1046: invokevirtual 337	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1049: pop
    //   1050: aload 11
    //   1052: ldc_w 674
    //   1055: ldc_w 676
    //   1058: aload 14
    //   1060: invokestatic 681	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1063: iconst_0
    //   1064: istore_2
    //   1065: goto -741 -> 324
    //   1068: aload 12
    //   1070: bipush 33
    //   1072: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   1075: aload_0
    //   1076: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1079: getfield 684	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxK	J
    //   1082: lstore 6
    //   1084: invokestatic 689	com/tencent/mm/model/cm:bfC	()J
    //   1087: ldc2_w 690
    //   1090: ldiv
    //   1091: lstore 8
    //   1093: lload 6
    //   1095: lconst_0
    //   1096: lcmp
    //   1097: ifle +11 -> 1108
    //   1100: lload 8
    //   1102: lload 6
    //   1104: lcmp
    //   1105: ifgt +35 -> 1140
    //   1108: new 6	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$1
    //   1111: dup
    //   1112: aload_0
    //   1113: aload_0
    //   1114: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1117: aload_0
    //   1118: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1121: aload_0
    //   1122: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1125: aload_0
    //   1126: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   1129: invokespecial 694	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c;Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   1132: invokestatic 700	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1135: iconst_0
    //   1136: istore_2
    //   1137: goto -813 -> 324
    //   1140: aload_0
    //   1141: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1144: aload_0
    //   1145: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1148: getfield 703	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxL	Ljava/lang/String;
    //   1151: invokestatic 709	com/tencent/mm/ui/base/w:cS	(Landroid/content/Context;Ljava/lang/String;)V
    //   1154: iconst_0
    //   1155: istore_2
    //   1156: goto -832 -> 324
    //   1159: astore_1
    //   1160: ldc 64
    //   1162: aload_1
    //   1163: invokevirtual 186	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1166: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1169: iconst_0
    //   1170: istore_2
    //   1171: goto -847 -> 324
    //   1174: ldc_w 711
    //   1177: invokestatic 717	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1180: checkcast 711	com/tencent/mm/plugin/messenger/foundation/a/n
    //   1183: invokeinterface 721 1 0
    //   1188: astore 11
    //   1190: aload 11
    //   1192: ifnull +726 -> 1918
    //   1195: aload_0
    //   1196: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1199: getfield 724	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lFl	Ljava/lang/String;
    //   1202: invokestatic 727	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1205: ifne +713 -> 1918
    //   1208: aload 11
    //   1210: aload_0
    //   1211: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1214: getfield 724	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lFl	Ljava/lang/String;
    //   1217: invokeinterface 733 2 0
    //   1222: astore_1
    //   1223: aload_1
    //   1224: ifnull +90 -> 1314
    //   1227: aload_1
    //   1228: getfield 738	com/tencent/mm/f/c/ax:field_type	I
    //   1231: invokestatic 744	com/tencent/mm/contact/d:rk	(I)Z
    //   1234: ifeq +80 -> 1314
    //   1237: aload 12
    //   1239: bipush 39
    //   1241: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   1244: aload_1
    //   1245: ifnull +176 -> 1421
    //   1248: aload_1
    //   1249: getfield 738	com/tencent/mm/f/c/ax:field_type	I
    //   1252: invokestatic 744	com/tencent/mm/contact/d:rk	(I)Z
    //   1255: ifeq +166 -> 1421
    //   1258: aload_0
    //   1259: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1262: astore_1
    //   1263: aload_0
    //   1264: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1267: astore 13
    //   1269: aload_0
    //   1270: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   1273: istore_3
    //   1274: aload_0
    //   1275: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1278: astore 11
    //   1280: aload_1
    //   1281: ifnull +28 -> 1309
    //   1284: aload 13
    //   1286: ifnull +23 -> 1309
    //   1289: aload 11
    //   1291: ifnull +18 -> 1309
    //   1294: aload 11
    //   1296: getfield 724	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lFl	Ljava/lang/String;
    //   1299: invokestatic 727	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1302: istore 10
    //   1304: iload 10
    //   1306: ifeq +33 -> 1339
    //   1309: iconst_0
    //   1310: istore_2
    //   1311: goto -987 -> 324
    //   1314: aload 12
    //   1316: bipush 38
    //   1318: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   1321: goto -77 -> 1244
    //   1324: astore_1
    //   1325: ldc 64
    //   1327: aload_1
    //   1328: invokevirtual 186	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1331: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1334: iconst_0
    //   1335: istore_2
    //   1336: goto -1012 -> 324
    //   1339: new 231	android/content/Intent
    //   1342: dup
    //   1343: invokespecial 305	android/content/Intent:<init>	()V
    //   1346: astore 13
    //   1348: aload 13
    //   1350: ldc_w 746
    //   1353: aload 11
    //   1355: getfield 724	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lFl	Ljava/lang/String;
    //   1358: invokevirtual 310	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1361: pop
    //   1362: aload 13
    //   1364: ldc_w 463
    //   1367: aload 12
    //   1369: invokevirtual 749	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1372: pop
    //   1373: aload 13
    //   1375: ldc_w 751
    //   1378: sipush 181
    //   1381: invokevirtual 337	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1384: pop
    //   1385: iload 4
    //   1387: istore_2
    //   1388: iload_3
    //   1389: ifne +6 -> 1395
    //   1392: bipush 6
    //   1394: istore_2
    //   1395: aload 13
    //   1397: ldc_w 753
    //   1400: iload_2
    //   1401: invokevirtual 337	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1404: pop
    //   1405: getstatic 507	com/tencent/mm/plugin/sns/c/a:mIG	Lcom/tencent/mm/pluginsdk/m;
    //   1408: aload 13
    //   1410: aload_1
    //   1411: invokeinterface 755 3 0
    //   1416: iconst_0
    //   1417: istore_2
    //   1418: goto -1094 -> 324
    //   1421: new 757	com/tencent/mm/plugin/sns/e/a
    //   1424: dup
    //   1425: invokespecial 758	com/tencent/mm/plugin/sns/e/a:<init>	()V
    //   1428: astore 13
    //   1430: aload_0
    //   1431: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1434: astore 15
    //   1436: aload_0
    //   1437: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1440: astore 16
    //   1442: aload_0
    //   1443: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1446: astore 14
    //   1448: aload_0
    //   1449: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JCO	I
    //   1452: istore_2
    //   1453: aload_0
    //   1454: getfield 49	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHh	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   1457: astore 17
    //   1459: aload 13
    //   1461: aload 14
    //   1463: putfield 761	com/tencent/mm/plugin/sns/e/a:JIJ	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1466: aload 13
    //   1468: aload 15
    //   1470: putfield 762	com/tencent/mm/plugin/sns/e/a:mContext	Landroid/content/Context;
    //   1473: aload 13
    //   1475: iload_2
    //   1476: putfield 763	com/tencent/mm/plugin/sns/e/a:JCO	I
    //   1479: aload 13
    //   1481: aload 11
    //   1483: putfield 767	com/tencent/mm/plugin/sns/e/a:lvF	Lcom/tencent/mm/storage/bv;
    //   1486: aload 13
    //   1488: aload_1
    //   1489: putfield 771	com/tencent/mm/plugin/sns/e/a:uNk	Lcom/tencent/mm/storage/as;
    //   1492: aload 13
    //   1494: aload 17
    //   1496: putfield 774	com/tencent/mm/plugin/sns/e/a:JPl	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   1499: aload 13
    //   1501: aload 16
    //   1503: invokevirtual 142	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   1506: invokestatic 148	com/tencent/mm/plugin/sns/data/m:aYS	(Ljava/lang/String;)J
    //   1509: invokestatic 154	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1512: putfield 777	com/tencent/mm/plugin/sns/e/a:fLp	Ljava/lang/String;
    //   1515: aload 13
    //   1517: aload 16
    //   1519: invokevirtual 326	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
    //   1522: putfield 778	com/tencent/mm/plugin/sns/e/a:uxInfo	Ljava/lang/String;
    //   1525: aload 13
    //   1527: aload 16
    //   1529: invokevirtual 134	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1532: getfield 139	com/tencent/mm/plugin/sns/storage/ADXml:adExtInfo	Ljava/lang/String;
    //   1535: putfield 779	com/tencent/mm/plugin/sns/e/a:adExtInfo	Ljava/lang/String;
    //   1538: new 781	com/tencent/mm/plugin/sns/data/f
    //   1541: dup
    //   1542: invokespecial 782	com/tencent/mm/plugin/sns/data/f:<init>	()V
    //   1545: astore_1
    //   1546: aload 14
    //   1548: ifnonnull +19 -> 1567
    //   1551: aload 13
    //   1553: aload_1
    //   1554: putfield 786	com/tencent/mm/plugin/sns/e/a:JPm	Lcom/tencent/mm/plugin/sns/data/f;
    //   1557: aload 13
    //   1559: invokevirtual 789	com/tencent/mm/plugin/sns/e/a:fNf	()V
    //   1562: iconst_0
    //   1563: istore_2
    //   1564: goto -1240 -> 324
    //   1567: aload_1
    //   1568: aload 14
    //   1570: getfield 724	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:lFl	Ljava/lang/String;
    //   1573: ldc 108
    //   1575: invokestatic 792	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1578: putfield 793	com/tencent/mm/plugin/sns/data/f:lFl	Ljava/lang/String;
    //   1581: aload_1
    //   1582: aload 14
    //   1584: getfield 796	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxP	Ljava/lang/String;
    //   1587: ldc 108
    //   1589: invokestatic 792	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1592: putfield 797	com/tencent/mm/plugin/sns/data/f:JxP	Ljava/lang/String;
    //   1595: aload_1
    //   1596: aload 14
    //   1598: getfield 800	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:fzM	Ljava/lang/String;
    //   1601: ldc 108
    //   1603: invokestatic 792	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1606: putfield 801	com/tencent/mm/plugin/sns/data/f:fzM	Ljava/lang/String;
    //   1609: aload_1
    //   1610: aload 14
    //   1612: getfield 804	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxQ	Ljava/lang/String;
    //   1615: ldc 108
    //   1617: invokestatic 792	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1620: putfield 805	com/tencent/mm/plugin/sns/data/f:JxQ	Ljava/lang/String;
    //   1623: aload_1
    //   1624: aload 14
    //   1626: getfield 808	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:JxR	Ljava/lang/String;
    //   1629: ldc 108
    //   1631: invokestatic 792	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1634: putfield 809	com/tencent/mm/plugin/sns/data/f:JxR	Ljava/lang/String;
    //   1637: goto -86 -> 1551
    //   1640: astore_1
    //   1641: ldc 64
    //   1643: aload_1
    //   1644: invokevirtual 186	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1647: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1650: iconst_0
    //   1651: istore_2
    //   1652: goto -1328 -> 324
    //   1655: aload_0
    //   1656: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1659: getfield 812	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1662: astore_1
    //   1663: aload_0
    //   1664: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1667: getfield 815	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jyf	Ljava/lang/String;
    //   1670: astore 11
    //   1672: aload_0
    //   1673: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1676: getfield 818	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:Jyg	Ljava/lang/String;
    //   1679: astore 13
    //   1681: aload_0
    //   1682: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1685: getfield 521	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   1688: invokestatic 824	com/tencent/mm/plugin/sns/ad/d/l:aeJ	(I)I
    //   1691: istore_2
    //   1692: aload_0
    //   1693: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1696: aload_0
    //   1697: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1700: invokevirtual 642	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1703: getfield 124	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   1706: aload_1
    //   1707: aload 11
    //   1709: aload 13
    //   1711: aload_0
    //   1712: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1715: getfield 281	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1718: iload_2
    //   1719: invokestatic 827	com/tencent/mm/plugin/sns/ad/d/l:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)Z
    //   1722: pop
    //   1723: aload 12
    //   1725: bipush 37
    //   1727: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   1730: iconst_0
    //   1731: istore_2
    //   1732: goto -1408 -> 324
    //   1735: ldc 64
    //   1737: ldc_w 829
    //   1740: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1743: ldc_w 831
    //   1746: invokestatic 717	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1749: checkcast 831	com/tencent/mm/plugin/findersdk/a/m
    //   1752: aload_0
    //   1753: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1756: getfield 812	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1759: new 8	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$2
    //   1762: dup
    //   1763: aload_0
    //   1764: aload 12
    //   1766: invokespecial 834	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$2:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c;Lcom/tencent/mm/modelsns/SnsAdClick;)V
    //   1769: invokeinterface 837 3 0
    //   1774: iconst_1
    //   1775: istore_2
    //   1776: goto -1452 -> 324
    //   1779: aload_0
    //   1780: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1783: getfield 812	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1786: astore_1
    //   1787: aload_0
    //   1788: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1791: getfield 281	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1794: invokestatic 286	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   1797: astore 11
    //   1799: aload_0
    //   1800: getfield 516	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:JHf	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1803: getfield 521	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   1806: invokestatic 824	com/tencent/mm/plugin/sns/ad/d/l:aeJ	(I)I
    //   1809: istore_2
    //   1810: aload_0
    //   1811: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1814: aload_1
    //   1815: aload_0
    //   1816: getfield 112	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:Jws	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1819: invokevirtual 642	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1822: getfield 124	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   1825: aload 11
    //   1827: iload_2
    //   1828: invokestatic 840	com/tencent/mm/plugin/sns/ad/d/l:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    //   1831: pop
    //   1832: aload 12
    //   1834: bipush 41
    //   1836: putfield 581	com/tencent/mm/modelsns/SnsAdClick:maW	I
    //   1839: iconst_0
    //   1840: istore_2
    //   1841: goto -1517 -> 324
    //   1844: astore_1
    //   1845: iconst_0
    //   1846: istore_2
    //   1847: ldc 64
    //   1849: new 66	java/lang/StringBuilder
    //   1852: dup
    //   1853: ldc_w 842
    //   1856: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1859: aload_1
    //   1860: invokevirtual 843	java/lang/Exception:toString	()Ljava/lang/String;
    //   1863: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1869: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1872: goto -1522 -> 350
    //   1875: astore_1
    //   1876: ldc 64
    //   1878: new 66	java/lang/StringBuilder
    //   1881: dup
    //   1882: ldc_w 845
    //   1885: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1888: aload_1
    //   1889: invokestatic 851	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1892: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1901: ldc_w 530
    //   1904: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1907: return
    //   1908: astore_1
    //   1909: iconst_1
    //   1910: istore_2
    //   1911: goto -64 -> 1847
    //   1914: astore_1
    //   1915: goto -68 -> 1847
    //   1918: aconst_null
    //   1919: astore_1
    //   1920: goto -697 -> 1223
    //   1923: goto -976 -> 947
    //   1926: goto -1690 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1929	0	this	c
    //   0	1929	1	paramView	View
    //   13	1898	2	i	int
    //   1	1388	3	j	int
    //   3	1383	4	k	int
    //   29	403	5	m	int
    //   500	603	6	l1	long
    //   1091	10	8	l2	long
    //   1302	3	10	bool	boolean
    //   244	1582	11	localObject1	Object
    //   59	1774	12	localSnsAdClick	SnsAdClick
    //   253	1457	13	localObject2	Object
    //   492	1133	14	localObject3	Object
    //   1434	35	15	localContext	Context
    //   1440	88	16	localSnsInfo	SnsInfo
    //   1457	38	17	locala	a
    // Exception table:
    //   from	to	target	type
    //   744	758	763	java/lang/Throwable
    //   1075	1093	1159	java/lang/Throwable
    //   1108	1135	1159	java/lang/Throwable
    //   1140	1154	1159	java/lang/Throwable
    //   1174	1190	1324	java/lang/Throwable
    //   1195	1223	1324	java/lang/Throwable
    //   1227	1244	1324	java/lang/Throwable
    //   1314	1321	1324	java/lang/Throwable
    //   1641	1650	1324	java/lang/Throwable
    //   1248	1280	1640	java/lang/Throwable
    //   1294	1304	1640	java/lang/Throwable
    //   1339	1385	1640	java/lang/Throwable
    //   1395	1416	1640	java/lang/Throwable
    //   1421	1546	1640	java/lang/Throwable
    //   1551	1562	1640	java/lang/Throwable
    //   1567	1637	1640	java/lang/Throwable
    //   79	236	1844	java/lang/Exception
    //   236	298	1844	java/lang/Exception
    //   303	322	1844	java/lang/Exception
    //   440	494	1844	java/lang/Exception
    //   502	529	1844	java/lang/Exception
    //   534	619	1844	java/lang/Exception
    //   624	631	1844	java/lang/Exception
    //   634	651	1844	java/lang/Exception
    //   656	686	1844	java/lang/Exception
    //   691	744	1844	java/lang/Exception
    //   744	758	1844	java/lang/Exception
    //   769	805	1844	java/lang/Exception
    //   810	841	1844	java/lang/Exception
    //   846	862	1844	java/lang/Exception
    //   877	904	1844	java/lang/Exception
    //   904	947	1844	java/lang/Exception
    //   947	1063	1844	java/lang/Exception
    //   1068	1075	1844	java/lang/Exception
    //   1075	1093	1844	java/lang/Exception
    //   1108	1135	1844	java/lang/Exception
    //   1140	1154	1844	java/lang/Exception
    //   1160	1169	1844	java/lang/Exception
    //   1174	1190	1844	java/lang/Exception
    //   1195	1223	1844	java/lang/Exception
    //   1227	1244	1844	java/lang/Exception
    //   1248	1280	1844	java/lang/Exception
    //   1294	1304	1844	java/lang/Exception
    //   1314	1321	1844	java/lang/Exception
    //   1325	1334	1844	java/lang/Exception
    //   1339	1385	1844	java/lang/Exception
    //   1395	1416	1844	java/lang/Exception
    //   1421	1546	1844	java/lang/Exception
    //   1551	1562	1844	java/lang/Exception
    //   1567	1637	1844	java/lang/Exception
    //   1641	1650	1844	java/lang/Exception
    //   1655	1730	1844	java/lang/Exception
    //   1779	1839	1844	java/lang/Exception
    //   14	22	1875	java/lang/Exception
    //   25	31	1875	java/lang/Exception
    //   31	38	1875	java/lang/Exception
    //   40	79	1875	java/lang/Exception
    //   354	359	1875	java/lang/Exception
    //   359	387	1875	java/lang/Exception
    //   394	402	1875	java/lang/Exception
    //   408	416	1875	java/lang/Exception
    //   422	428	1875	java/lang/Exception
    //   1847	1872	1875	java/lang/Exception
    //   1735	1774	1908	java/lang/Exception
    //   324	350	1914	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(AdClickActionInfo paramAdClickActionInfo);
  }
  
  public static abstract interface b
  {
    public abstract void fLc();
    
    public abstract ViewGroup fLd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.c
 * JD-Core Version:    0.7.0.1
 */