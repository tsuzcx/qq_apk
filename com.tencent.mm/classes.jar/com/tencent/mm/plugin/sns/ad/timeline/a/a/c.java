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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.ad.timeline.helper.ActionBtnFollowFinderHelper;
import com.tencent.mm.plugin.sns.ad.timeline.helper.ActionBtnFollowFinderHelper.1;
import com.tencent.mm.plugin.sns.ad.timeline.helper.ActionBtnFollowFinderHelper.2;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.g.b.1;
import com.tencent.mm.plugin.sns.g.b.2;
import com.tencent.mm.plugin.sns.g.b.3;
import com.tencent.mm.plugin.sns.g.b.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.f;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class c
{
  SnsInfo PJQ;
  private int PYf;
  AdClickActionInfo PYg;
  private com.tencent.mm.plugin.sns.ad.g.l PYh;
  a PYi;
  b PYj;
  ActionBtnFollowFinderHelper PYk;
  Context mContext;
  private int mScene;
  private int xOq;
  
  public c(Context paramContext, int paramInt, com.tencent.mm.plugin.sns.ad.g.l paraml, a parama, b paramb)
  {
    this.mContext = paramContext;
    this.xOq = paramInt;
    this.PYh = paraml;
    this.PYi = parama;
    this.PYj = paramb;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick, int paramInt)
  {
    AppMethodBeat.i(311437);
    com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject1 = a.f.QIF;
    String str8;
    String str6;
    Object localObject2;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bR(MMApplicationContext.getContext(), paramString2))
    {
      String str5 = "";
      String str7 = "";
      String str4 = "";
      String str3 = "";
      String str2 = "";
      str8 = "";
      com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, isPkgInstalled==true, openApp");
      String str1 = str2;
      Object localObject3 = str3;
      str6 = str8;
      paramSnsAdClick = str7;
      localObject2 = str5;
      localObject1 = str4;
      if (this.PJQ != null)
      {
        localObject1 = this.PJQ.getAdInfo(this.xOq);
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
        str5 = Util.nullAsNil(this.PJQ.getAdXml().adExtInfo);
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str4 = String.valueOf(com.tencent.mm.plugin.sns.data.m.aXe(Util.nullAsNil(this.PJQ.getSnsId())));
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str3 = Util.nullAsNil(this.PJQ.getAid());
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str2 = Util.nullAsNil(this.PJQ.getTraceid());
        str1 = str2;
        localObject3 = str3;
        localObject2 = str5;
        localObject1 = str4;
        str6 = Util.nullAsNil(this.PJQ.getPid());
        localObject1 = str4;
        localObject2 = str5;
        localObject3 = str3;
        str1 = str2;
      }
      finally
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", localObject4.toString());
          str6 = str8;
        }
      }
      com.tencent.mm.plugin.sns.ad.d.c.a(true, this.PJQ);
      localObject3 = new j((String)localObject3, str1, str6);
      com.tencent.mm.plugin.sns.data.m.a(this.mContext, paramString1, paramString2, "", paramString3, paramSnsAdClick, (String)localObject2, (String)localObject1, 0, 0, (j)localObject3);
      AppMethodBeat.o(311437);
      return 34;
    }
    localObject1 = a.f.QIF;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, isApkExist==true, installApp");
      com.tencent.mm.plugin.sns.ad.d.c.a(false, this.PJQ);
      com.tencent.mm.plugin.sns.ad.d.b.lK(paramString2, paramString3);
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
      AppMethodBeat.o(311437);
      return 21;
    }
    if (this.PJQ == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "handleDownload, mSnsInfo==null");
      AppMethodBeat.o(311437);
      return 21;
    }
    try
    {
      paramString1 = this.PJQ.getAdInfo(this.xOq);
      if (com.tencent.mm.plugin.sns.data.m.b(this.mContext, this.PJQ, paramString1))
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, jumpAppMarket");
        com.tencent.mm.plugin.sns.ad.d.b.lK(paramString2, paramString3);
        AppMethodBeat.o(311437);
        return 36;
      }
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "handleDownload, jumpAppMarket exp=" + paramString1.toString());
      com.tencent.mm.plugin.sns.ad.d.c.a(false, this.PJQ);
      paramString3 = this.PJQ;
      paramString2 = (Activity)this.mContext;
      int i = this.xOq;
      localObject1 = this.PYj.hbu();
      localObject2 = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
      if (paramString3 == null)
      {
        paramString1 = "";
        com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", paramString1);
        paramString1 = a(paramString3, paramString2, i, (View)localObject1, paramInt);
        if (paramString1 == null) {
          break label750;
        }
        this.PYj.hbt();
        paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString1);
        com.tencent.mm.hellhoundlib.a.a.b(paramString2, paramString1.aYi(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString2.startActivity((Intent)paramString1.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString2, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString2.overridePendingTransition(0, 0);
      }
      label750:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label756;
        }
        com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, jumpNativeLandingPageUI");
        AppMethodBeat.o(311437);
        return 21;
        paramString1 = t.uA(paramString3.field_snsId);
        break;
      }
      label756:
      paramString1 = this.PJQ.getAdInfo(this.xOq);
      if ((paramString1 != null) && (paramString1.adActionType == 4) && (paramString1.actionExtWeApp != null) && (com.tencent.mm.plugin.sns.ui.listener.c.a(paramString1.actionExtWeApp.appUserName, paramString1.actionExtWeApp.hzy, paramString1.actionExtWeApp.appVersion, this.PJQ, this.xOq)))
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, jumpWeApp");
        AppMethodBeat.o(311437);
        return 31;
      }
      paramSnsAdClick.oTQ = 0;
      if (a(this.PJQ, paramSnsAdClick, this.xOq, this.mContext))
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, jumpH5");
        AppMethodBeat.o(311437);
        return 0;
      }
      com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "handleDownload, do nothing");
      AppMethodBeat.o(311437);
    }
    return 21;
  }
  
  private static Intent a(SnsInfo paramSnsInfo, Activity paramActivity, int paramInt1, View paramView, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(311448);
    Intent localIntent;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(paramSnsInfo.getAdSnsInfo().field_adxml))
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
        if ((paramSnsInfo.ContentObj.Zpq == 15) && (paramSnsInfo.sightFolded != 1)) {}
        for (;;)
        {
          localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
          localIntent.putExtra("sns_landing_pages_from_outer_index", paramInt2);
          AppMethodBeat.o(311448);
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
        com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "adxml is invalid, snsId=" + t.uA(paramSnsInfo.field_snsId));
        AppMethodBeat.o(311448);
        return null;
        label358:
        paramInt1 = 0;
        i = 0;
      }
      label366:
      paramInt1 = 1;
    }
  }
  
  private static void a(String paramString, SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    boolean bool2 = false;
    AppMethodBeat.i(311443);
    com.tencent.mm.sdk.platformtools.Log.i("AdClickActionHandler", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramSnsInfo);
    if ((TextUtils.isEmpty(paramString)) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(311443);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramSnsInfo.getAdXml().webrightBar == 0)
    {
      bool1 = true;
      if (!z.pCv) {
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
            str = com.tencent.mm.plugin.sns.ad.c.a.a.aWj(t.lY(paramString, localADInfo.uxInfo));
            t.i(localIntent, localADInfo.uxInfo);
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
      localIntent.putExtra("KPublisherId", "sns_" + t.uA(paramSnsInfo.field_snsId));
      localIntent.putExtra("pre_username", paramSnsInfo.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + t.uA(paramSnsInfo.field_snsId));
      localIntent.putExtra("preUsername", paramSnsInfo.field_userName);
      com.tencent.mm.plugin.sns.d.a.pFn.h(localIntent, paramContext);
      AppMethodBeat.o(311443);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static boolean a(SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(311424);
    try
    {
      String str2 = paramSnsInfo.getAdInfoLink();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramSnsInfo.getAdLink();
      }
      if (TextUtils.isEmpty(str1))
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "jumpUpdateWebUI both url is empty");
        AppMethodBeat.o(311424);
        return false;
      }
      a(str1, paramSnsInfo, paramSnsAdClick, paramInt, paramContext);
      AppMethodBeat.o(311424);
      return true;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdClickActionHandler", "jumpUpdateWebUI, exp=" + paramSnsInfo.toString());
      AppMethodBeat.o(311424);
    }
    return false;
  }
  
  public final void a(AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, int paramInt)
  {
    this.PYg = paramAdClickActionInfo;
    this.PJQ = paramSnsInfo;
    this.mScene = this.PYg.scene;
    this.PYf = paramInt;
  }
  
  /* Error */
  public final void jg(View paramView)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 5
    //   5: iconst_1
    //   6: istore 4
    //   8: ldc_w 573
    //   11: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: bipush 26
    //   16: istore_2
    //   17: aload_0
    //   18: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   21: iconst_1
    //   22: if_icmpne +384 -> 406
    //   25: bipush 26
    //   27: istore_2
    //   28: aload_0
    //   29: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   32: istore 6
    //   34: aload_0
    //   35: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   38: ifne +5 -> 43
    //   41: iconst_1
    //   42: istore_3
    //   43: new 315	com/tencent/mm/modelsns/SnsAdClick
    //   46: dup
    //   47: iload 6
    //   49: iload_3
    //   50: aload_0
    //   51: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   54: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   57: iload_2
    //   58: iconst_0
    //   59: invokespecial 576	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
    //   62: astore 13
    //   64: aload 13
    //   66: aload_0
    //   67: getfield 47	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYh	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   70: aload_0
    //   71: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   74: iload_2
    //   75: aload_0
    //   76: getfield 568	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYf	I
    //   79: invokestatic 579	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;II)V
    //   82: ldc 62
    //   84: new 64	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 581
    //   91: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   98: getfield 584	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLm	I
    //   101: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 586
    //   107: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   114: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   117: invokestatic 288	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   120: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 588
    //   126: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   133: getfield 564	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   136: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc_w 590
    //   142: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 568	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYf	I
    //   149: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   162: getfield 584	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLm	I
    //   165: tableswitch	default:+2078 -> 2243, 0:+573->738, 1:+804->969, 2:+686->851, 3:+354->519, 4:+608->773, 5:+768->933, 6:+1026->1191, 7:+1132->1297, 8:+83->248, 9:+83->248, 10:+83->248, 11:+83->248, 12:+1613->1778, 13:+1702->1867, 14:+1746->1911, 15:+1811->1976, 16:+1856->2021
    //   249: aload_0
    //   250: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   253: invokestatic 596	com/tencent/mm/plugin/sns/ad/timeline/a/a:f	(ILandroid/content/Context;)Lcom/tencent/mm/plugin/sns/ad/timeline/a/c;
    //   256: astore 12
    //   258: new 598	com/tencent/mm/plugin/sns/ad/timeline/a/d
    //   261: dup
    //   262: invokespecial 599	com/tencent/mm/plugin/sns/ad/timeline/a/d:<init>	()V
    //   265: astore 14
    //   267: aload 14
    //   269: ldc_w 601
    //   272: aload 13
    //   274: invokevirtual 605	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: aload 14
    //   280: ldc_w 606
    //   283: aload_0
    //   284: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   287: invokestatic 611	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: invokevirtual 605	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: aload 14
    //   296: ldc_w 613
    //   299: aload_0
    //   300: getfield 568	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYf	I
    //   303: invokestatic 611	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: invokevirtual 605	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: aload 12
    //   312: ifnull +22 -> 334
    //   315: aload 12
    //   317: aload_1
    //   318: aload_0
    //   319: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   322: aload_0
    //   323: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   326: aload 14
    //   328: invokeinterface 618 5 0
    //   333: pop
    //   334: iconst_0
    //   335: istore_2
    //   336: ldc 62
    //   338: new 64	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 620
    //   345: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload 13
    //   350: getfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   353: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: iload_2
    //   363: ifne +8 -> 371
    //   366: aload 13
    //   368: invokestatic 623	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
    //   371: aload_0
    //   372: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   375: ifnull +24 -> 399
    //   378: aload_0
    //   379: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   382: aload_0
    //   383: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   386: getfield 626	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:appGiftPackCode	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   393: getfield 629	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:appGiftPackCodeTips	Ljava/lang/String;
    //   396: invokestatic 633	com/tencent/mm/plugin/sns/ad/d/b:P	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   399: ldc_w 573
    //   402: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: return
    //   406: aload_0
    //   407: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   410: iconst_2
    //   411: if_icmpne +9 -> 420
    //   414: bipush 33
    //   416: istore_2
    //   417: goto -389 -> 28
    //   420: aload_0
    //   421: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   424: iconst_3
    //   425: if_icmpne +9 -> 434
    //   428: bipush 34
    //   430: istore_2
    //   431: goto -403 -> 28
    //   434: aload_0
    //   435: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   438: iconst_4
    //   439: if_icmpne +9 -> 448
    //   442: bipush 35
    //   444: istore_2
    //   445: goto -417 -> 28
    //   448: aload_0
    //   449: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   452: iconst_5
    //   453: if_icmpne +10 -> 463
    //   456: sipush 1001
    //   459: istore_2
    //   460: goto -432 -> 28
    //   463: aload_0
    //   464: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   467: bipush 6
    //   469: if_icmpne +10 -> 479
    //   472: sipush 1002
    //   475: istore_2
    //   476: goto -448 -> 28
    //   479: aload_0
    //   480: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   483: bipush 7
    //   485: if_icmpeq +1761 -> 2246
    //   488: aload_0
    //   489: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   492: bipush 8
    //   494: if_icmpne +6 -> 500
    //   497: goto +1749 -> 2246
    //   500: aload_0
    //   501: getfield 566	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mScene	I
    //   504: istore 6
    //   506: iload 6
    //   508: bipush 9
    //   510: if_icmpne -482 -> 28
    //   513: bipush 37
    //   515: istore_2
    //   516: goto -488 -> 28
    //   519: aload 13
    //   521: bipush 21
    //   523: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   526: aload_0
    //   527: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   530: astore 12
    //   532: aload_0
    //   533: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   536: checkcast 215	android/app/Activity
    //   539: astore_1
    //   540: aload_0
    //   541: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   544: istore_2
    //   545: aload_0
    //   546: getfield 51	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYj	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   549: invokeinterface 219 1 0
    //   554: astore 14
    //   556: aload_0
    //   557: getfield 568	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYf	I
    //   560: istore_3
    //   561: new 64	java/lang/StringBuilder
    //   564: dup
    //   565: ldc_w 635
    //   568: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   571: astore 15
    //   573: aload 12
    //   575: ifnonnull +130 -> 705
    //   578: lconst_0
    //   579: lstore 7
    //   581: ldc 62
    //   583: aload 15
    //   585: lload 7
    //   587: invokevirtual 638	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   590: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload 12
    //   598: aload_1
    //   599: iload_2
    //   600: aload 14
    //   602: iload_3
    //   603: invokestatic 224	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;I)Landroid/content/Intent;
    //   606: astore 12
    //   608: aload 12
    //   610: ifnull +105 -> 715
    //   613: aload_0
    //   614: getfield 51	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYj	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$b;
    //   617: invokeinterface 227 1 0
    //   622: new 237	com/tencent/mm/hellhoundlib/b/a
    //   625: dup
    //   626: invokespecial 238	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   629: aload 12
    //   631: invokevirtual 242	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   634: astore 12
    //   636: aload_1
    //   637: aload 12
    //   639: invokevirtual 246	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   642: ldc 248
    //   644: ldc_w 640
    //   647: ldc_w 642
    //   650: ldc 254
    //   652: ldc_w 256
    //   655: ldc_w 258
    //   658: invokestatic 263	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   661: aload_1
    //   662: aload 12
    //   664: iconst_0
    //   665: invokevirtual 267	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   668: checkcast 231	android/content/Intent
    //   671: invokevirtual 269	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   674: aload_1
    //   675: ldc 248
    //   677: ldc_w 640
    //   680: ldc_w 642
    //   683: ldc 254
    //   685: ldc_w 256
    //   688: ldc_w 258
    //   691: invokestatic 273	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload_1
    //   695: iconst_0
    //   696: iconst_0
    //   697: invokevirtual 277	android/app/Activity:overridePendingTransition	(II)V
    //   700: iconst_0
    //   701: istore_2
    //   702: goto -366 -> 336
    //   705: aload 12
    //   707: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   710: lstore 7
    //   712: goto -131 -> 581
    //   715: aload_0
    //   716: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   719: aload 13
    //   721: aload_0
    //   722: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   725: aload_0
    //   726: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   729: invokestatic 321	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)Z
    //   732: pop
    //   733: iconst_0
    //   734: istore_2
    //   735: goto -399 -> 336
    //   738: aload 13
    //   740: iconst_0
    //   741: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   744: aload_0
    //   745: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   748: getfield 645	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLn	Ljava/lang/String;
    //   751: aload_0
    //   752: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   755: aload 13
    //   757: aload_0
    //   758: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   761: aload_0
    //   762: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   765: invokestatic 554	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)V
    //   768: iconst_0
    //   769: istore_2
    //   770: goto -434 -> 336
    //   773: aload 13
    //   775: bipush 31
    //   777: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   780: aload_0
    //   781: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   784: getfield 648	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:xVm	Ljava/lang/String;
    //   787: aload_0
    //   788: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   791: getfield 651	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:nUS	Ljava/lang/String;
    //   794: new 64	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 652	java/lang/StringBuilder:<init>	()V
    //   801: aload_0
    //   802: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   805: getfield 655	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:nUT	I
    //   808: invokevirtual 445	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   811: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: aload_0
    //   815: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   818: aload_0
    //   819: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   822: invokestatic 311	com/tencent/mm/plugin/sns/ui/listener/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)Z
    //   825: pop
    //   826: invokestatic 661	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:hbB	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
    //   829: aload_0
    //   830: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   833: aload_0
    //   834: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   837: invokevirtual 664	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:c	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   840: iconst_0
    //   841: istore_2
    //   842: goto -506 -> 336
    //   845: astore_1
    //   846: iconst_0
    //   847: istore_2
    //   848: goto -512 -> 336
    //   851: aload_0
    //   852: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   855: getfield 667	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLB	Ljava/lang/String;
    //   858: astore_1
    //   859: aload_0
    //   860: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   863: getfield 670	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLC	Ljava/lang/String;
    //   866: astore 12
    //   868: aload_0
    //   869: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   872: getfield 673	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLD	Ljava/lang/String;
    //   875: astore 14
    //   877: aload 13
    //   879: aload_0
    //   880: aload_1
    //   881: aload 12
    //   883: aload 14
    //   885: aload 13
    //   887: aload_0
    //   888: getfield 568	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYf	I
    //   891: invokespecial 675	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelsns/SnsAdClick;I)I
    //   894: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   897: iconst_0
    //   898: istore_2
    //   899: goto -563 -> 336
    //   902: astore_1
    //   903: ldc 62
    //   905: new 64	java/lang/StringBuilder
    //   908: dup
    //   909: ldc_w 677
    //   912: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   915: aload_1
    //   916: invokevirtual 180	java/lang/Throwable:toString	()Ljava/lang/String;
    //   919: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: iconst_0
    //   929: istore_2
    //   930: goto -594 -> 336
    //   933: aload 13
    //   935: bipush 32
    //   937: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   940: aload_0
    //   941: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   944: getfield 645	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLn	Ljava/lang/String;
    //   947: aload_0
    //   948: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   951: aload 13
    //   953: aload_0
    //   954: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   957: aload_0
    //   958: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   961: invokestatic 554	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/modelsns/SnsAdClick;ILandroid/content/Context;)V
    //   964: iconst_0
    //   965: istore_2
    //   966: goto -630 -> 336
    //   969: aload 13
    //   971: bipush 11
    //   973: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   976: aload_0
    //   977: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   980: invokevirtual 680	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   983: astore 14
    //   985: ldc 106
    //   987: astore 12
    //   989: aload 12
    //   991: astore_1
    //   992: aload 14
    //   994: ifnull +33 -> 1027
    //   997: aload 12
    //   999: astore_1
    //   1000: aload 14
    //   1002: getfield 684	com/tencent/mm/plugin/sns/storage/ADInfo:mappedCanvasCardExt	Ljava/util/HashMap;
    //   1005: ifnull +22 -> 1027
    //   1008: aload 14
    //   1010: getfield 684	com/tencent/mm/plugin/sns/storage/ADInfo:mappedCanvasCardExt	Ljava/util/HashMap;
    //   1013: aload_0
    //   1014: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1017: getfield 687	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:wtm	Ljava/lang/String;
    //   1020: invokevirtual 693	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1023: checkcast 148	java/lang/String
    //   1026: astore_1
    //   1027: aload_1
    //   1028: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1031: ifeq +1209 -> 2240
    //   1034: ldc 62
    //   1036: new 64	java/lang/StringBuilder
    //   1039: dup
    //   1040: ldc_w 695
    //   1043: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1046: aload_0
    //   1047: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1050: getfield 687	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:wtm	Ljava/lang/String;
    //   1053: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1062: aload_0
    //   1063: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1066: getfield 698	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:wui	Ljava/lang/String;
    //   1069: astore_1
    //   1070: aload_0
    //   1071: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1074: checkcast 215	android/app/Activity
    //   1077: astore 12
    //   1079: aload_0
    //   1080: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1083: getfield 687	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:wtm	Ljava/lang/String;
    //   1086: astore 14
    //   1088: ldc 62
    //   1090: new 64	java/lang/StringBuilder
    //   1093: dup
    //   1094: ldc_w 700
    //   1097: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1100: aload 14
    //   1102: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: ldc_w 702
    //   1108: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload_1
    //   1112: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1121: new 231	android/content/Intent
    //   1124: dup
    //   1125: invokespecial 341	android/content/Intent:<init>	()V
    //   1128: astore 15
    //   1130: aload 15
    //   1132: ldc_w 704
    //   1135: aload 14
    //   1137: invokevirtual 346	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1140: pop
    //   1141: aload 15
    //   1143: ldc_w 706
    //   1146: aload_1
    //   1147: invokevirtual 346	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1150: pop
    //   1151: aload 15
    //   1153: ldc_w 708
    //   1156: bipush 21
    //   1158: invokevirtual 373	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1161: pop
    //   1162: aload 15
    //   1164: ldc_w 710
    //   1167: bipush 15
    //   1169: invokevirtual 373	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1172: pop
    //   1173: aload 12
    //   1175: ldc_w 712
    //   1178: ldc_w 714
    //   1181: aload 15
    //   1183: invokestatic 719	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1186: iconst_0
    //   1187: istore_2
    //   1188: goto -852 -> 336
    //   1191: aload 13
    //   1193: bipush 33
    //   1195: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   1198: aload_0
    //   1199: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1202: getfield 722	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLz	J
    //   1205: lstore 7
    //   1207: invokestatic 727	com/tencent/mm/model/cn:bDu	()J
    //   1210: ldc2_w 728
    //   1213: ldiv
    //   1214: lstore 9
    //   1216: lload 7
    //   1218: lconst_0
    //   1219: lcmp
    //   1220: ifle +11 -> 1231
    //   1223: lload 9
    //   1225: lload 7
    //   1227: lcmp
    //   1228: ifgt +35 -> 1263
    //   1231: new 6	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$1
    //   1234: dup
    //   1235: aload_0
    //   1236: aload_0
    //   1237: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1240: aload_0
    //   1241: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1244: aload_0
    //   1245: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1248: aload_0
    //   1249: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   1252: invokespecial 732	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c;Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   1255: invokestatic 738	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   1258: iconst_0
    //   1259: istore_2
    //   1260: goto -924 -> 336
    //   1263: aload_0
    //   1264: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1267: aload_0
    //   1268: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1271: getfield 741	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLA	Ljava/lang/String;
    //   1274: invokestatic 747	com/tencent/mm/ui/base/aa:dc	(Landroid/content/Context;Ljava/lang/String;)V
    //   1277: iconst_0
    //   1278: istore_2
    //   1279: goto -943 -> 336
    //   1282: astore_1
    //   1283: ldc 62
    //   1285: aload_1
    //   1286: invokevirtual 180	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1289: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1292: iconst_0
    //   1293: istore_2
    //   1294: goto -958 -> 336
    //   1297: ldc_w 749
    //   1300: invokestatic 755	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1303: checkcast 749	com/tencent/mm/plugin/messenger/foundation/a/n
    //   1306: invokeinterface 759 1 0
    //   1311: astore 12
    //   1313: aload 12
    //   1315: ifnull +920 -> 2235
    //   1318: aload_0
    //   1319: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1322: getfield 762	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:owR	Ljava/lang/String;
    //   1325: invokestatic 765	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1328: ifne +907 -> 2235
    //   1331: aload 12
    //   1333: aload_0
    //   1334: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1337: getfield 762	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:owR	Ljava/lang/String;
    //   1340: invokeinterface 771 2 0
    //   1345: astore_1
    //   1346: aload_1
    //   1347: ifnull +90 -> 1437
    //   1350: aload_1
    //   1351: getfield 776	com/tencent/mm/autogen/b/az:field_type	I
    //   1354: invokestatic 782	com/tencent/mm/contact/d:rs	(I)Z
    //   1357: ifeq +80 -> 1437
    //   1360: aload 13
    //   1362: bipush 39
    //   1364: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   1367: aload_1
    //   1368: ifnull +176 -> 1544
    //   1371: aload_1
    //   1372: getfield 776	com/tencent/mm/autogen/b/az:field_type	I
    //   1375: invokestatic 782	com/tencent/mm/contact/d:rs	(I)Z
    //   1378: ifeq +166 -> 1544
    //   1381: aload_0
    //   1382: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1385: astore_1
    //   1386: aload_0
    //   1387: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1390: astore 14
    //   1392: aload_0
    //   1393: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   1396: istore_3
    //   1397: aload_0
    //   1398: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1401: astore 12
    //   1403: aload_1
    //   1404: ifnull +28 -> 1432
    //   1407: aload 14
    //   1409: ifnull +23 -> 1432
    //   1412: aload 12
    //   1414: ifnull +18 -> 1432
    //   1417: aload 12
    //   1419: getfield 762	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:owR	Ljava/lang/String;
    //   1422: invokestatic 765	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1425: istore 11
    //   1427: iload 11
    //   1429: ifeq +33 -> 1462
    //   1432: iconst_0
    //   1433: istore_2
    //   1434: goto -1098 -> 336
    //   1437: aload 13
    //   1439: bipush 38
    //   1441: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   1444: goto -77 -> 1367
    //   1447: astore_1
    //   1448: ldc 62
    //   1450: aload_1
    //   1451: invokevirtual 180	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1454: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1457: iconst_0
    //   1458: istore_2
    //   1459: goto -1123 -> 336
    //   1462: new 231	android/content/Intent
    //   1465: dup
    //   1466: invokespecial 341	android/content/Intent:<init>	()V
    //   1469: astore 14
    //   1471: aload 14
    //   1473: ldc_w 784
    //   1476: aload 12
    //   1478: getfield 762	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:owR	Ljava/lang/String;
    //   1481: invokevirtual 346	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1484: pop
    //   1485: aload 14
    //   1487: ldc_w 493
    //   1490: aload 13
    //   1492: invokevirtual 787	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1495: pop
    //   1496: aload 14
    //   1498: ldc_w 789
    //   1501: sipush 181
    //   1504: invokevirtual 373	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1507: pop
    //   1508: iload 4
    //   1510: istore_2
    //   1511: iload_3
    //   1512: ifne +6 -> 1518
    //   1515: bipush 6
    //   1517: istore_2
    //   1518: aload 14
    //   1520: ldc_w 791
    //   1523: iload_2
    //   1524: invokevirtual 373	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1527: pop
    //   1528: getstatic 537	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
    //   1531: aload 14
    //   1533: aload_1
    //   1534: invokeinterface 793 3 0
    //   1539: iconst_0
    //   1540: istore_2
    //   1541: goto -1205 -> 336
    //   1544: new 795	com/tencent/mm/plugin/sns/g/a
    //   1547: dup
    //   1548: invokespecial 796	com/tencent/mm/plugin/sns/g/a:<init>	()V
    //   1551: astore 14
    //   1553: aload_0
    //   1554: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1557: astore 16
    //   1559: aload_0
    //   1560: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1563: astore 17
    //   1565: aload_0
    //   1566: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1569: astore 15
    //   1571: aload_0
    //   1572: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   1575: istore_2
    //   1576: aload_0
    //   1577: getfield 49	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYi	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   1580: astore 18
    //   1582: aload 14
    //   1584: aload 15
    //   1586: putfield 799	com/tencent/mm/plugin/sns/g/a:PZL	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1589: aload 14
    //   1591: aload 16
    //   1593: putfield 800	com/tencent/mm/plugin/sns/g/a:mContext	Landroid/content/Context;
    //   1596: aload 14
    //   1598: iload_2
    //   1599: putfield 801	com/tencent/mm/plugin/sns/g/a:xOq	I
    //   1602: aload 14
    //   1604: aload 12
    //   1606: putfield 805	com/tencent/mm/plugin/sns/g/a:onc	Lcom/tencent/mm/storage/bx;
    //   1609: aload 14
    //   1611: aload_1
    //   1612: putfield 809	com/tencent/mm/plugin/sns/g/a:xVS	Lcom/tencent/mm/storage/au;
    //   1615: aload 14
    //   1617: aload 18
    //   1619: putfield 812	com/tencent/mm/plugin/sns/g/a:Qku	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   1622: aload 14
    //   1624: aload 17
    //   1626: invokevirtual 140	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   1629: invokestatic 146	com/tencent/mm/plugin/sns/data/m:aXe	(Ljava/lang/String;)J
    //   1632: invokestatic 152	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1635: putfield 815	com/tencent/mm/plugin/sns/g/a:hQX	Ljava/lang/String;
    //   1638: aload 14
    //   1640: aload 17
    //   1642: invokevirtual 362	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
    //   1645: putfield 816	com/tencent/mm/plugin/sns/g/a:uxInfo	Ljava/lang/String;
    //   1648: aload 14
    //   1650: aload 17
    //   1652: invokevirtual 132	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1655: getfield 137	com/tencent/mm/plugin/sns/storage/ADXml:adExtInfo	Ljava/lang/String;
    //   1658: putfield 817	com/tencent/mm/plugin/sns/g/a:adExtInfo	Ljava/lang/String;
    //   1661: new 819	com/tencent/mm/plugin/sns/data/f
    //   1664: dup
    //   1665: invokespecial 820	com/tencent/mm/plugin/sns/data/f:<init>	()V
    //   1668: astore_1
    //   1669: aload 15
    //   1671: ifnonnull +19 -> 1690
    //   1674: aload 14
    //   1676: aload_1
    //   1677: putfield 824	com/tencent/mm/plugin/sns/g/a:Qkv	Lcom/tencent/mm/plugin/sns/data/f;
    //   1680: aload 14
    //   1682: invokevirtual 827	com/tencent/mm/plugin/sns/g/a:hel	()V
    //   1685: iconst_0
    //   1686: istore_2
    //   1687: goto -1351 -> 336
    //   1690: aload_1
    //   1691: aload 15
    //   1693: getfield 762	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:owR	Ljava/lang/String;
    //   1696: ldc 106
    //   1698: invokestatic 830	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1701: putfield 831	com/tencent/mm/plugin/sns/data/f:owR	Ljava/lang/String;
    //   1704: aload_1
    //   1705: aload 15
    //   1707: getfield 834	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLE	Ljava/lang/String;
    //   1710: ldc 106
    //   1712: invokestatic 830	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1715: putfield 835	com/tencent/mm/plugin/sns/data/f:PLE	Ljava/lang/String;
    //   1718: aload_1
    //   1719: aload 15
    //   1721: getfield 838	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:hEy	Ljava/lang/String;
    //   1724: ldc 106
    //   1726: invokestatic 830	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1729: putfield 839	com/tencent/mm/plugin/sns/data/f:hEy	Ljava/lang/String;
    //   1732: aload_1
    //   1733: aload 15
    //   1735: getfield 842	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLF	Ljava/lang/String;
    //   1738: ldc 106
    //   1740: invokestatic 830	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1743: putfield 843	com/tencent/mm/plugin/sns/data/f:PLF	Ljava/lang/String;
    //   1746: aload_1
    //   1747: aload 15
    //   1749: getfield 846	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PLG	Ljava/lang/String;
    //   1752: ldc 106
    //   1754: invokestatic 830	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1757: putfield 847	com/tencent/mm/plugin/sns/data/f:PLG	Ljava/lang/String;
    //   1760: goto -86 -> 1674
    //   1763: astore_1
    //   1764: ldc 62
    //   1766: aload_1
    //   1767: invokevirtual 180	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1770: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1773: iconst_0
    //   1774: istore_2
    //   1775: goto -1439 -> 336
    //   1778: aload_0
    //   1779: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1782: getfield 850	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1785: astore_1
    //   1786: aload_0
    //   1787: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1790: getfield 853	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PMd	Ljava/lang/String;
    //   1793: astore 12
    //   1795: aload_0
    //   1796: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1799: getfield 856	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PMe	Ljava/lang/String;
    //   1802: astore 14
    //   1804: aload_0
    //   1805: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1808: getfield 564	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   1811: invokestatic 862	com/tencent/mm/plugin/sns/ad/d/n:ajs	(I)I
    //   1814: istore_2
    //   1815: aload_0
    //   1816: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1819: invokevirtual 680	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1822: astore 15
    //   1824: aload_0
    //   1825: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1828: aload 15
    //   1830: getfield 122	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   1833: aload_1
    //   1834: aload 12
    //   1836: aload 14
    //   1838: aload_0
    //   1839: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1842: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1845: aload 15
    //   1847: getfield 865	com/tencent/mm/plugin/sns/storage/ADInfo:preloadFinderFeed	Z
    //   1850: iload_2
    //   1851: invokestatic 868	com/tencent/mm/plugin/sns/ad/d/n:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZI)Z
    //   1854: pop
    //   1855: aload 13
    //   1857: bipush 37
    //   1859: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   1862: iconst_0
    //   1863: istore_2
    //   1864: goto -1528 -> 336
    //   1867: ldc 62
    //   1869: ldc_w 870
    //   1872: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1875: ldc_w 872
    //   1878: invokestatic 755	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1881: checkcast 872	com/tencent/mm/plugin/findersdk/a/y
    //   1884: aload_0
    //   1885: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1888: getfield 850	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1891: new 8	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$2
    //   1894: dup
    //   1895: aload_0
    //   1896: aload 13
    //   1898: invokespecial 875	com/tencent/mm/plugin/sns/ad/timeline/a/a/c$2:<init>	(Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c;Lcom/tencent/mm/modelsns/SnsAdClick;)V
    //   1901: invokeinterface 878 3 0
    //   1906: iconst_1
    //   1907: istore_2
    //   1908: goto -1572 -> 336
    //   1911: aload_0
    //   1912: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1915: getfield 850	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:finderUsername	Ljava/lang/String;
    //   1918: astore_1
    //   1919: aload_0
    //   1920: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1923: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1926: invokestatic 288	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   1929: astore 12
    //   1931: aload_0
    //   1932: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   1935: getfield 564	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:scene	I
    //   1938: invokestatic 862	com/tencent/mm/plugin/sns/ad/d/n:ajs	(I)I
    //   1941: istore_2
    //   1942: aload_0
    //   1943: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1946: aload_1
    //   1947: aload_0
    //   1948: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1951: invokevirtual 680	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1954: getfield 122	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   1957: aload 12
    //   1959: iload_2
    //   1960: invokestatic 881	com/tencent/mm/plugin/sns/ad/d/n:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    //   1963: pop
    //   1964: aload 13
    //   1966: bipush 41
    //   1968: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   1971: iconst_0
    //   1972: istore_2
    //   1973: goto -1637 -> 336
    //   1976: new 231	android/content/Intent
    //   1979: dup
    //   1980: invokespecial 341	android/content/Intent:<init>	()V
    //   1983: astore_1
    //   1984: aload_1
    //   1985: ldc_w 883
    //   1988: aload_0
    //   1989: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   1992: getstatic 888	com/tencent/mm/plugin/sns/b$j:sns_ad_coupon_title_of_card_package	I
    //   1995: invokevirtual 894	android/content/Context:getString	(I)Ljava/lang/String;
    //   1998: invokevirtual 346	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2001: pop
    //   2002: aload_0
    //   2003: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   2006: ldc_w 712
    //   2009: ldc_w 896
    //   2012: aload_1
    //   2013: invokestatic 719	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2016: iconst_0
    //   2017: istore_2
    //   2018: goto -1682 -> 336
    //   2021: aload_0
    //   2022: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   2025: getfield 900	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PMg	Lcom/tencent/mm/plugin/sns/ad/adxml/a;
    //   2028: ifnull +120 -> 2148
    //   2031: aload_0
    //   2032: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2035: ifnull +113 -> 2148
    //   2038: aload_0
    //   2039: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2042: getfield 283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   2045: invokestatic 288	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   2048: astore_1
    //   2049: aload_1
    //   2050: aload_0
    //   2051: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   2054: getfield 900	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PMg	Lcom/tencent/mm/plugin/sns/ad/adxml/a;
    //   2057: invokestatic 905	com/tencent/mm/plugin/sns/ad/d/a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/adxml/a;)Ljava/lang/String;
    //   2060: astore 12
    //   2062: iload 5
    //   2064: istore_2
    //   2065: aload_0
    //   2066: getfield 45	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:xOq	I
    //   2069: ifne +5 -> 2074
    //   2072: iconst_0
    //   2073: istore_2
    //   2074: new 907	com/tencent/mm/plugin/sns/ad/widget/a
    //   2077: dup
    //   2078: aload_0
    //   2079: getfield 43	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:mContext	Landroid/content/Context;
    //   2082: iload_2
    //   2083: invokespecial 910	com/tencent/mm/plugin/sns/ad/widget/a:<init>	(Landroid/content/Context;I)V
    //   2086: astore 14
    //   2088: aload_0
    //   2089: getfield 49	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYi	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   2092: astore 15
    //   2094: aload_0
    //   2095: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   2098: astore 16
    //   2100: aload 14
    //   2102: aload 15
    //   2104: putfield 913	com/tencent/mm/plugin/sns/ad/widget/a:QdD	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c$a;
    //   2107: aload 14
    //   2109: aload 16
    //   2111: putfield 916	com/tencent/mm/plugin/sns/ad/widget/a:QdE	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   2114: aload 14
    //   2116: aload_1
    //   2117: aload_0
    //   2118: getfield 110	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2121: invokevirtual 362	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
    //   2124: aload_0
    //   2125: getfield 559	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:PYg	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   2128: getfield 900	com/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo:PMg	Lcom/tencent/mm/plugin/sns/ad/adxml/a;
    //   2131: aload 12
    //   2133: invokevirtual 919	com/tencent/mm/plugin/sns/ad/widget/a:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/adxml/a;Ljava/lang/String;)V
    //   2136: aload 13
    //   2138: bipush 50
    //   2140: putfield 318	com/tencent/mm/modelsns/SnsAdClick:oTQ	I
    //   2143: iconst_0
    //   2144: istore_2
    //   2145: goto -1809 -> 336
    //   2148: ldc 62
    //   2150: ldc_w 921
    //   2153: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2156: iconst_0
    //   2157: istore_2
    //   2158: goto -1822 -> 336
    //   2161: astore_1
    //   2162: iconst_0
    //   2163: istore_2
    //   2164: ldc 62
    //   2166: new 64	java/lang/StringBuilder
    //   2169: dup
    //   2170: ldc_w 923
    //   2173: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2176: aload_1
    //   2177: invokevirtual 924	java/lang/Exception:toString	()Ljava/lang/String;
    //   2180: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2186: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2189: goto -1827 -> 362
    //   2192: astore_1
    //   2193: ldc 62
    //   2195: new 64	java/lang/StringBuilder
    //   2198: dup
    //   2199: ldc_w 926
    //   2202: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2205: aload_1
    //   2206: invokestatic 932	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2209: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2212: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2215: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2218: ldc_w 573
    //   2221: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2224: return
    //   2225: astore_1
    //   2226: iconst_1
    //   2227: istore_2
    //   2228: goto -64 -> 2164
    //   2231: astore_1
    //   2232: goto -68 -> 2164
    //   2235: aconst_null
    //   2236: astore_1
    //   2237: goto -891 -> 1346
    //   2240: goto -1170 -> 1070
    //   2243: goto -1995 -> 248
    //   2246: bipush 21
    //   2248: istore_2
    //   2249: goto -2221 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2252	0	this	c
    //   0	2252	1	paramView	View
    //   16	2233	2	i	int
    //   1	1511	3	j	int
    //   6	1503	4	k	int
    //   3	2060	5	m	int
    //   32	479	6	n	int
    //   579	647	7	l1	long
    //   1214	10	9	l2	long
    //   1425	3	11	bool	boolean
    //   256	1876	12	localObject1	Object
    //   62	2075	13	localSnsAdClick	SnsAdClick
    //   265	1850	14	localObject2	Object
    //   571	1532	15	localObject3	Object
    //   1557	553	16	localObject4	Object
    //   1563	88	17	localSnsInfo	SnsInfo
    //   1580	38	18	locala	a
    // Exception table:
    //   from	to	target	type
    //   826	840	845	finally
    //   877	897	902	finally
    //   1198	1216	1282	finally
    //   1231	1258	1282	finally
    //   1263	1277	1282	finally
    //   1297	1313	1447	finally
    //   1318	1346	1447	finally
    //   1350	1367	1447	finally
    //   1437	1444	1447	finally
    //   1764	1773	1447	finally
    //   1371	1403	1763	finally
    //   1417	1427	1763	finally
    //   1462	1508	1763	finally
    //   1518	1539	1763	finally
    //   1544	1669	1763	finally
    //   1674	1685	1763	finally
    //   1690	1760	1763	finally
    //   82	248	2161	java/lang/Exception
    //   248	310	2161	java/lang/Exception
    //   315	334	2161	java/lang/Exception
    //   519	573	2161	java/lang/Exception
    //   581	608	2161	java/lang/Exception
    //   613	700	2161	java/lang/Exception
    //   705	712	2161	java/lang/Exception
    //   715	733	2161	java/lang/Exception
    //   738	768	2161	java/lang/Exception
    //   773	826	2161	java/lang/Exception
    //   851	877	2161	java/lang/Exception
    //   903	928	2161	java/lang/Exception
    //   933	964	2161	java/lang/Exception
    //   969	985	2161	java/lang/Exception
    //   1000	1027	2161	java/lang/Exception
    //   1027	1070	2161	java/lang/Exception
    //   1070	1186	2161	java/lang/Exception
    //   1191	1198	2161	java/lang/Exception
    //   1283	1292	2161	java/lang/Exception
    //   1448	1457	2161	java/lang/Exception
    //   1778	1862	2161	java/lang/Exception
    //   1911	1971	2161	java/lang/Exception
    //   1976	2016	2161	java/lang/Exception
    //   2021	2062	2161	java/lang/Exception
    //   2065	2072	2161	java/lang/Exception
    //   2074	2143	2161	java/lang/Exception
    //   2148	2156	2161	java/lang/Exception
    //   17	25	2192	java/lang/Exception
    //   28	34	2192	java/lang/Exception
    //   34	41	2192	java/lang/Exception
    //   43	82	2192	java/lang/Exception
    //   366	371	2192	java/lang/Exception
    //   371	399	2192	java/lang/Exception
    //   406	414	2192	java/lang/Exception
    //   420	428	2192	java/lang/Exception
    //   434	442	2192	java/lang/Exception
    //   448	456	2192	java/lang/Exception
    //   463	472	2192	java/lang/Exception
    //   479	497	2192	java/lang/Exception
    //   500	506	2192	java/lang/Exception
    //   2164	2189	2192	java/lang/Exception
    //   1867	1906	2225	java/lang/Exception
    //   336	362	2231	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(AdClickActionInfo paramAdClickActionInfo);
  }
  
  public static abstract interface b
  {
    public abstract void hbt();
    
    public abstract ViewGroup hbu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.c
 * JD-Core Version:    0.7.0.1
 */