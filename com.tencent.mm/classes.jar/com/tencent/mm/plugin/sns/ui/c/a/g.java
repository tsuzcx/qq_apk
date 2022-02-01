package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class g
  extends b
{
  public SphereImageView KtC;
  ImageView KtE;
  private a KtF;
  int KtG;
  protected SphereImageView.b KxA;
  public View LjW;
  public View LjX;
  private TextView LjY;
  private TextView LjZ;
  private TextView Lka;
  private TextView Lkb;
  private View Lkc;
  MMPinProgressBtn Lkd;
  ADXml.i Lke;
  String Lkf;
  protected a.d Lkg;
  private Context mContext;
  public View xYJ;
  
  public g(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc)
  {
    AppMethodBeat.i(100031);
    this.Lkf = null;
    this.KtG = 0;
    this.Lkg = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100026);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        g.this.KtC.g(paramAnonymousBitmap, paramAnonymousString2);
        AppMethodBeat.o(100026);
      }
      
      public final void aRh(String paramAnonymousString)
      {
        AppMethodBeat.i(100025);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
        AppMethodBeat.o(100025);
      }
    };
    this.KxA = new SphereImageView.b()
    {
      public final void baZ(final String paramAnonymousString)
      {
        AppMethodBeat.i(100029);
        if (g.this.KtE.getVisibility() == 0)
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(350L);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(100027);
              g.this.KtE.setVisibility(8);
              g.this.KtE.setImageDrawable(new ColorDrawable(g.this.KtE.getResources().getColor(i.c.BG_3)));
              AppMethodBeat.o(100027);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
          g.this.KtE.startAnimation(localAlphaAnimation);
        }
        if ((g.this.Lke != null) && (!a.kS(g.this.Lke.KjX, "scene_timeline")))
        {
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
          g.this.KtC.setTouchEnabled(false);
          g.this.KtC.fSo();
          g.this.KtC.Kwm.requestRender();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100028);
              String str;
              if (g.this.Lke != null)
              {
                str = g.this.Lke.KjX;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label120;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
                a.a(g.this.KtC, str, "scene_timeline");
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
                g.this.KtC.setSensorEnabled(true);
                g.this.KtC.setTouchEnabled(true);
                AppMethodBeat.o(100028);
                return;
                str = "";
                break;
                label120:
                Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (g.this.Lkd.getVisibility() == 0)
          {
            g.this.Lkd.setVisibility(8);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
          }
          AppMethodBeat.o(100029);
          return;
          g.this.KtC.setSensorEnabled(true);
          g.this.KtC.setTouchEnabled(true);
        }
      }
      
      public final void fRD() {}
      
      public final void fRE() {}
      
      public final void fRF()
      {
        g localg = g.this;
        localg.KtG += 1;
      }
      
      public final void onDetachedFromWindow()
      {
        AppMethodBeat.i(100030);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + g.this.KtC.hashCode());
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", g.this.KtG);
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          String str1 = g.this.Jzk.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(17539, new Object[] { g.this.Jzk.getTimeLine().Id, localObject, g.this.Jzk.getAdInfo().uxInfo, Integer.valueOf(2), str2 });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(str2)));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + localException.toString());
          }
        }
        g.this.KtG = 0;
        g.this.Lkf = null;
        AppMethodBeat.o(100030);
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    AppMethodBeat.o(100031);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100032);
    this.contentView = paramView1;
    this.KON = paramView2;
    this.mContext = paramView1.getContext();
    this.xYJ = paramView1.findViewById(i.f.sphere_card_container);
    this.LjW = paramView1.findViewById(i.f.top_layer);
    this.LjX = paramView1.findViewById(i.f.bottom_layer);
    this.LjY = ((TextView)paramView1.findViewById(i.f.top_layer_title));
    this.LjZ = ((TextView)paramView1.findViewById(i.f.top_layer_desc));
    this.Lka = ((TextView)paramView1.findViewById(i.f.bottom_layer_title));
    this.Lkb = ((TextView)paramView1.findViewById(i.f.bottom_layer_desc));
    this.Lkc = paramView1.findViewById(i.f.bottom_mini_program);
    this.KtE = ((ImageView)paramView1.findViewById(i.f.mask_img));
    this.KtC = ((SphereImageView)paramView1.findViewById(i.f.sphere_card_img));
    this.Lkd = ((MMPinProgressBtn)paramView1.findViewById(i.f.progress));
    this.Lkd.setMax(50);
    this.KtC.ap(1.8F, -2.0F);
    this.KtC.setTouchSensitivity(0.45F);
    this.KtC.setEventListener(this.KxA);
    this.KtC.setTouchEnabled(true);
    this.KtC.setSensorEnabled(false);
    this.KtC.fSo();
    this.KtF = new a();
    this.KtF.a(this.Lkg);
    Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "initView, hash=" + this.KtC.hashCode());
    AppMethodBeat.o(100032);
  }
  
  /* Error */
  public final void refreshView()
  {
    // Byte code:
    //   0: ldc 241
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 211
    //   7: new 213	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 243
    //   13: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   20: invokevirtual 224	java/lang/Object:hashCode	()I
    //   23: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   37: invokevirtual 248	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   40: invokestatic 254	com/tencent/mm/plugin/sns/storage/f:bbk	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   43: putfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   51: aload_0
    //   52: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   55: ifnull +27 -> 82
    //   58: aload_0
    //   59: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   62: invokevirtual 260	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   73: invokevirtual 260	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   76: getfield 265	com/tencent/mm/plugin/sns/storage/ADXml:adSphereCardInfo	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   79: putfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   82: aload_0
    //   83: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   86: ldc_w 267
    //   89: invokevirtual 273	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: checkcast 275	android/view/WindowManager
    //   95: astore_3
    //   96: aload_3
    //   97: invokeinterface 279 1 0
    //   102: invokevirtual 284	android/view/Display:getWidth	()I
    //   105: aload_3
    //   106: invokeinterface 279 1 0
    //   111: invokevirtual 287	android/view/Display:getHeight	()I
    //   114: invokestatic 293	java/lang/Math:min	(II)I
    //   117: istore_1
    //   118: aload_0
    //   119: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/g:LjW	Landroid/view/View;
    //   122: bipush 8
    //   124: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   127: aload_0
    //   128: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/g:LjY	Landroid/widget/TextView;
    //   131: bipush 8
    //   133: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   136: aload_0
    //   137: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/g:LjZ	Landroid/widget/TextView;
    //   140: bipush 8
    //   142: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   145: aload_0
    //   146: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   149: bipush 8
    //   151: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   154: aload_0
    //   155: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/g:Lka	Landroid/widget/TextView;
    //   158: bipush 8
    //   160: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   163: aload_0
    //   164: getfield 146	com/tencent/mm/plugin/sns/ui/c/a/g:Lkb	Landroid/widget/TextView;
    //   167: bipush 8
    //   169: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   172: aload_0
    //   173: getfield 151	com/tencent/mm/plugin/sns/ui/c/a/g:Lkc	Landroid/view/View;
    //   176: bipush 8
    //   178: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   181: aload_0
    //   182: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   185: ifnull +1099 -> 1284
    //   188: iload_1
    //   189: aload_0
    //   190: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   193: getstatic 302	com/tencent/mm/plugin/sns/i$d:sns_avatar_size	I
    //   196: invokestatic 308	com/tencent/mm/ci/a:aY	(Landroid/content/Context;I)I
    //   199: isub
    //   200: aload_0
    //   201: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   204: getstatic 311	com/tencent/mm/plugin/sns/i$d:Edge_0_5_A	I
    //   207: invokestatic 308	com/tencent/mm/ci/a:aY	(Landroid/content/Context;I)I
    //   210: isub
    //   211: aload_0
    //   212: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   215: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   218: getstatic 318	com/tencent/mm/plugin/sns/i$d:NormalPadding	I
    //   221: invokevirtual 324	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   224: isub
    //   225: aload_0
    //   226: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   229: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   232: getstatic 318	com/tencent/mm/plugin/sns/i$d:NormalPadding	I
    //   235: invokevirtual 324	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   238: isub
    //   239: istore_1
    //   240: aload_0
    //   241: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   244: getfield 329	com/tencent/mm/plugin/sns/storage/ADXml$i:KjH	I
    //   247: ifne +662 -> 909
    //   250: new 331	android/view/ViewGroup$LayoutParams
    //   253: dup
    //   254: bipush 254
    //   256: bipush 254
    //   258: invokespecial 334	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   261: astore_3
    //   262: aload_3
    //   263: iload_1
    //   264: putfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   267: aload_3
    //   268: aload_3
    //   269: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   272: i2f
    //   273: ldc_w 338
    //   276: fmul
    //   277: f2i
    //   278: putfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   281: aload_3
    //   282: ifnull +129 -> 411
    //   285: aload_0
    //   286: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/g:contentView	Landroid/view/View;
    //   289: invokevirtual 345	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   292: astore 4
    //   294: aload 4
    //   296: aload_3
    //   297: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   300: putfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   303: aload 4
    //   305: aload_3
    //   306: getfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   309: putfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   312: aload_0
    //   313: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/g:contentView	Landroid/view/View;
    //   316: aload 4
    //   318: invokevirtual 349	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   321: aload_0
    //   322: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/g:contentView	Landroid/view/View;
    //   325: checkcast 351	com/tencent/mm/ui/widget/RoundedCornerFrameLayout
    //   328: aload_0
    //   329: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   332: bipush 8
    //   334: invokestatic 354	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   337: i2f
    //   338: invokevirtual 357	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   341: aload_0
    //   342: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   345: invokevirtual 358	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   348: astore 4
    //   350: aload 4
    //   352: aload_3
    //   353: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   356: putfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   359: aload 4
    //   361: aload_3
    //   362: getfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   365: putfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   368: aload_0
    //   369: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   372: aload 4
    //   374: invokevirtual 359	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   377: aload_0
    //   378: getfield 158	com/tencent/mm/plugin/sns/ui/c/a/g:KtE	Landroid/widget/ImageView;
    //   381: invokevirtual 360	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   384: astore_3
    //   385: aload_3
    //   386: aload 4
    //   388: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   391: putfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   394: aload_3
    //   395: aload 4
    //   397: getfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   400: putfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   403: aload_0
    //   404: getfield 158	com/tencent/mm/plugin/sns/ui/c/a/g:KtE	Landroid/widget/ImageView;
    //   407: aload_3
    //   408: invokevirtual 361	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   411: aload_0
    //   412: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   415: getfield 364	com/tencent/mm/plugin/sns/storage/ADXml$i:KjJ	I
    //   418: ifne +530 -> 948
    //   421: aload_0
    //   422: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   425: getfield 367	com/tencent/mm/plugin/sns/storage/ADXml$i:KjI	I
    //   428: i2f
    //   429: ldc_w 368
    //   432: fmul
    //   433: f2i
    //   434: iconst_0
    //   435: iconst_0
    //   436: iconst_0
    //   437: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   440: istore_1
    //   441: iconst_0
    //   442: iconst_0
    //   443: iconst_0
    //   444: iconst_0
    //   445: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   448: istore_2
    //   449: new 376	android/graphics/drawable/GradientDrawable
    //   452: dup
    //   453: getstatic 382	android/graphics/drawable/GradientDrawable$Orientation:TOP_BOTTOM	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   456: iconst_2
    //   457: newarray int
    //   459: dup
    //   460: iconst_0
    //   461: iload_1
    //   462: iastore
    //   463: dup
    //   464: iconst_1
    //   465: iload_2
    //   466: iastore
    //   467: invokespecial 385	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   470: astore_3
    //   471: aload_3
    //   472: iconst_0
    //   473: invokevirtual 388	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   476: aload_0
    //   477: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/g:LjW	Landroid/view/View;
    //   480: aload_3
    //   481: invokevirtual 392	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   484: aload_0
    //   485: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   488: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   491: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   494: ifeq +16 -> 510
    //   497: aload_0
    //   498: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   501: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   504: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   507: ifne +11 -> 518
    //   510: aload_0
    //   511: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/g:LjW	Landroid/view/View;
    //   514: iconst_0
    //   515: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   518: aload_0
    //   519: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   522: bipush 8
    //   524: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   527: aload_0
    //   528: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   531: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   534: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   537: ifne +45 -> 582
    //   540: aload_0
    //   541: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/g:LjY	Landroid/widget/TextView;
    //   544: iconst_0
    //   545: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   548: aload_0
    //   549: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/g:LjY	Landroid/widget/TextView;
    //   552: invokestatic 410	com/tencent/mm/cl/h:htZ	()Lcom/tencent/mm/cl/h;
    //   555: aload_0
    //   556: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/g:LjY	Landroid/widget/TextView;
    //   559: invokevirtual 411	android/widget/TextView:getContext	()Landroid/content/Context;
    //   562: aload_0
    //   563: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   566: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   569: aload_0
    //   570: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/g:LjY	Landroid/widget/TextView;
    //   573: invokevirtual 415	android/widget/TextView:getTextSize	()F
    //   576: invokevirtual 418	com/tencent/mm/cl/h:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   579: invokevirtual 422	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   582: aload_0
    //   583: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   586: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   589: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   592: ifne +45 -> 637
    //   595: aload_0
    //   596: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/g:LjZ	Landroid/widget/TextView;
    //   599: iconst_0
    //   600: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   603: aload_0
    //   604: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/g:LjZ	Landroid/widget/TextView;
    //   607: invokestatic 410	com/tencent/mm/cl/h:htZ	()Lcom/tencent/mm/cl/h;
    //   610: aload_0
    //   611: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/g:LjZ	Landroid/widget/TextView;
    //   614: invokevirtual 411	android/widget/TextView:getContext	()Landroid/content/Context;
    //   617: aload_0
    //   618: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   621: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   624: aload_0
    //   625: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/g:LjZ	Landroid/widget/TextView;
    //   628: invokevirtual 415	android/widget/TextView:getTextSize	()F
    //   631: invokevirtual 418	com/tencent/mm/cl/h:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   634: invokevirtual 422	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   637: aload_0
    //   638: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   641: ifnull +95 -> 736
    //   644: aload_0
    //   645: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/g:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   648: invokevirtual 426	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   651: invokevirtual 432	com/tencent/mm/plugin/sns/storage/ADInfo:isWeapp	()Z
    //   654: ifeq +82 -> 736
    //   657: aload_0
    //   658: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   661: getfield 367	com/tencent/mm/plugin/sns/storage/ADXml$i:KjI	I
    //   664: i2f
    //   665: ldc_w 368
    //   668: fmul
    //   669: f2i
    //   670: iconst_0
    //   671: iconst_0
    //   672: iconst_0
    //   673: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   676: istore_1
    //   677: iconst_0
    //   678: iconst_0
    //   679: iconst_0
    //   680: iconst_0
    //   681: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   684: istore_2
    //   685: new 376	android/graphics/drawable/GradientDrawable
    //   688: dup
    //   689: getstatic 435	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   692: iconst_2
    //   693: newarray int
    //   695: dup
    //   696: iconst_0
    //   697: iload_1
    //   698: iastore
    //   699: dup
    //   700: iconst_1
    //   701: iload_2
    //   702: iastore
    //   703: invokespecial 385	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   706: astore_3
    //   707: aload_3
    //   708: iconst_0
    //   709: invokevirtual 388	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   712: aload_0
    //   713: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   716: iconst_0
    //   717: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   720: aload_0
    //   721: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   724: aload_3
    //   725: invokevirtual 392	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   728: aload_0
    //   729: getfield 151	com/tencent/mm/plugin/sns/ui/c/a/g:Lkc	Landroid/view/View;
    //   732: iconst_0
    //   733: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   736: aload_0
    //   737: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   740: iconst_0
    //   741: invokevirtual 436	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setVisibility	(I)V
    //   744: aload_0
    //   745: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   748: aload_0
    //   749: invokevirtual 440	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setTag	(Ljava/lang/Object;)V
    //   752: aload_0
    //   753: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   756: aload_0
    //   757: getfield 82	com/tencent/mm/plugin/sns/ui/c/a/g:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   760: getfield 446	com/tencent/mm/plugin/sns/ui/d/c:LpB	Landroid/view/View$OnClickListener;
    //   763: invokevirtual 450	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   766: aload_0
    //   767: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/g:Lkf	Ljava/lang/String;
    //   770: ifnull +20 -> 790
    //   773: aload_0
    //   774: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/g:Lkf	Ljava/lang/String;
    //   777: aload_0
    //   778: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   781: getfield 453	com/tencent/mm/plugin/sns/storage/ADXml$i:KjX	Ljava/lang/String;
    //   784: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   787: ifne +483 -> 1270
    //   790: ldc 211
    //   792: ldc_w 461
    //   795: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: aload_0
    //   799: getfield 158	com/tencent/mm/plugin/sns/ui/c/a/g:KtE	Landroid/widget/ImageView;
    //   802: iconst_0
    //   803: invokevirtual 462	android/widget/ImageView:setVisibility	(I)V
    //   806: aload_0
    //   807: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   810: getfield 453	com/tencent/mm/plugin/sns/storage/ADXml$i:KjX	Ljava/lang/String;
    //   813: astore_3
    //   814: aload_0
    //   815: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   818: getfield 465	com/tencent/mm/plugin/sns/storage/ADXml$i:KjY	Ljava/lang/String;
    //   821: astore 4
    //   823: new 467	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c
    //   826: dup
    //   827: aload_3
    //   828: aload 4
    //   830: ldc_w 469
    //   833: new 6	com/tencent/mm/plugin/sns/ui/c/a/g$1
    //   836: dup
    //   837: aload_0
    //   838: aload_3
    //   839: aload 4
    //   841: invokespecial 472	com/tencent/mm/plugin/sns/ui/c/a/g$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/g;Ljava/lang/String;Ljava/lang/String;)V
    //   844: invokespecial 475	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$d;)V
    //   847: iconst_0
    //   848: anewarray 477	java/lang/Void
    //   851: invokevirtual 481	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   854: pop
    //   855: aload_0
    //   856: getfield 205	com/tencent/mm/plugin/sns/ui/c/a/g:KtF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   859: aload_0
    //   860: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   863: getfield 453	com/tencent/mm/plugin/sns/storage/ADXml$i:KjX	Ljava/lang/String;
    //   866: aload_0
    //   867: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   870: invokevirtual 358	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   873: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   876: aload_0
    //   877: getfield 165	com/tencent/mm/plugin/sns/ui/c/a/g:KtC	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   880: invokevirtual 358	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   883: getfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   886: ldc_w 469
    //   889: invokevirtual 484	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:n	(Ljava/lang/String;IILjava/lang/String;)V
    //   892: aload_0
    //   893: aload_0
    //   894: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   897: getfield 453	com/tencent/mm/plugin/sns/storage/ADXml$i:KjX	Ljava/lang/String;
    //   900: putfield 60	com/tencent/mm/plugin/sns/ui/c/a/g:Lkf	Ljava/lang/String;
    //   903: ldc 241
    //   905: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   908: return
    //   909: aload_0
    //   910: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   913: getfield 329	com/tencent/mm/plugin/sns/storage/ADXml$i:KjH	I
    //   916: iconst_1
    //   917: if_icmpne +381 -> 1298
    //   920: new 331	android/view/ViewGroup$LayoutParams
    //   923: dup
    //   924: bipush 254
    //   926: bipush 254
    //   928: invokespecial 334	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   931: astore_3
    //   932: aload_3
    //   933: iload_1
    //   934: putfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   937: aload_3
    //   938: aload_3
    //   939: getfield 337	android/view/ViewGroup$LayoutParams:width	I
    //   942: putfield 341	android/view/ViewGroup$LayoutParams:height	I
    //   945: goto -664 -> 281
    //   948: aload_0
    //   949: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   952: getfield 364	com/tencent/mm/plugin/sns/storage/ADXml$i:KjJ	I
    //   955: iconst_1
    //   956: if_icmpne -319 -> 637
    //   959: aload_0
    //   960: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   963: getfield 367	com/tencent/mm/plugin/sns/storage/ADXml$i:KjI	I
    //   966: i2f
    //   967: ldc_w 368
    //   970: fmul
    //   971: f2i
    //   972: iconst_0
    //   973: iconst_0
    //   974: iconst_0
    //   975: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   978: istore_1
    //   979: iconst_0
    //   980: iconst_0
    //   981: iconst_0
    //   982: iconst_0
    //   983: invokestatic 374	android/graphics/Color:argb	(IIII)I
    //   986: istore_2
    //   987: new 376	android/graphics/drawable/GradientDrawable
    //   990: dup
    //   991: getstatic 435	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   994: iconst_2
    //   995: newarray int
    //   997: dup
    //   998: iconst_0
    //   999: iload_1
    //   1000: iastore
    //   1001: dup
    //   1002: iconst_1
    //   1003: iload_2
    //   1004: iastore
    //   1005: invokespecial 385	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   1008: astore_3
    //   1009: aload_3
    //   1010: iconst_0
    //   1011: invokevirtual 388	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   1014: aload_0
    //   1015: getfield 119	com/tencent/mm/plugin/sns/ui/c/a/g:LjW	Landroid/view/View;
    //   1018: bipush 8
    //   1020: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   1023: aload_0
    //   1024: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   1027: aload_3
    //   1028: invokevirtual 392	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1031: aload_0
    //   1032: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1035: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1038: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1041: ifeq +16 -> 1057
    //   1044: aload_0
    //   1045: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1048: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1051: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1054: ifne +42 -> 1096
    //   1057: aload_0
    //   1058: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/g:LjX	Landroid/view/View;
    //   1061: iconst_0
    //   1062: invokevirtual 296	android/view/View:setVisibility	(I)V
    //   1065: aload_0
    //   1066: getfield 151	com/tencent/mm/plugin/sns/ui/c/a/g:Lkc	Landroid/view/View;
    //   1069: invokevirtual 345	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1072: checkcast 486	android/widget/RelativeLayout$LayoutParams
    //   1075: astore_3
    //   1076: aload_3
    //   1077: aload_0
    //   1078: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/g:mContext	Landroid/content/Context;
    //   1081: iconst_4
    //   1082: invokestatic 354	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1085: putfield 489	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1088: aload_0
    //   1089: getfield 151	com/tencent/mm/plugin/sns/ui/c/a/g:Lkc	Landroid/view/View;
    //   1092: aload_3
    //   1093: invokevirtual 349	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1096: aload_0
    //   1097: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1100: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1103: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1106: ifne +45 -> 1151
    //   1109: aload_0
    //   1110: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/g:Lka	Landroid/widget/TextView;
    //   1113: iconst_0
    //   1114: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   1117: aload_0
    //   1118: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/g:Lka	Landroid/widget/TextView;
    //   1121: invokestatic 410	com/tencent/mm/cl/h:htZ	()Lcom/tencent/mm/cl/h;
    //   1124: aload_0
    //   1125: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/g:Lka	Landroid/widget/TextView;
    //   1128: invokevirtual 411	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1131: aload_0
    //   1132: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1135: getfield 395	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1138: aload_0
    //   1139: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/g:Lka	Landroid/widget/TextView;
    //   1142: invokevirtual 415	android/widget/TextView:getTextSize	()F
    //   1145: invokevirtual 418	com/tencent/mm/cl/h:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1148: invokevirtual 422	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1151: aload_0
    //   1152: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1155: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1158: invokestatic 401	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1161: ifne -524 -> 637
    //   1164: aload_0
    //   1165: getfield 146	com/tencent/mm/plugin/sns/ui/c/a/g:Lkb	Landroid/widget/TextView;
    //   1168: iconst_0
    //   1169: invokevirtual 297	android/widget/TextView:setVisibility	(I)V
    //   1172: aload_0
    //   1173: getfield 146	com/tencent/mm/plugin/sns/ui/c/a/g:Lkb	Landroid/widget/TextView;
    //   1176: invokestatic 410	com/tencent/mm/cl/h:htZ	()Lcom/tencent/mm/cl/h;
    //   1179: aload_0
    //   1180: getfield 146	com/tencent/mm/plugin/sns/ui/c/a/g:Lkb	Landroid/widget/TextView;
    //   1183: invokevirtual 411	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1186: aload_0
    //   1187: getfield 256	com/tencent/mm/plugin/sns/ui/c/a/g:Lke	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1190: getfield 404	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1193: aload_0
    //   1194: getfield 146	com/tencent/mm/plugin/sns/ui/c/a/g:Lkb	Landroid/widget/TextView;
    //   1197: invokevirtual 415	android/widget/TextView:getTextSize	()F
    //   1200: invokevirtual 418	com/tencent/mm/cl/h:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1203: invokevirtual 422	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1206: goto -569 -> 637
    //   1209: astore_3
    //   1210: ldc 211
    //   1212: new 213	java/lang/StringBuilder
    //   1215: dup
    //   1216: ldc_w 491
    //   1219: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1222: aload_3
    //   1223: invokevirtual 492	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1226: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1235: ldc 241
    //   1237: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: astore_3
    //   1242: ldc 211
    //   1244: new 213	java/lang/StringBuilder
    //   1247: dup
    //   1248: ldc_w 500
    //   1251: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1254: aload_3
    //   1255: invokevirtual 492	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1258: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1267: goto -412 -> 855
    //   1270: ldc 211
    //   1272: ldc_w 502
    //   1275: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1278: ldc 241
    //   1280: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1283: return
    //   1284: ldc 211
    //   1286: ldc_w 504
    //   1289: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1292: ldc 241
    //   1294: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1297: return
    //   1298: aconst_null
    //   1299: astore_3
    //   1300: goto -1019 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1303	0	this	g
    //   117	883	1	i	int
    //   448	556	2	j	int
    //   95	998	3	localObject1	Object
    //   1209	14	3	localThrowable1	Throwable
    //   1241	14	3	localThrowable2	Throwable
    //   1299	1	3	localObject2	Object
    //   292	548	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	82	1209	java/lang/Throwable
    //   82	281	1209	java/lang/Throwable
    //   285	411	1209	java/lang/Throwable
    //   411	510	1209	java/lang/Throwable
    //   510	518	1209	java/lang/Throwable
    //   518	582	1209	java/lang/Throwable
    //   582	637	1209	java/lang/Throwable
    //   637	736	1209	java/lang/Throwable
    //   736	790	1209	java/lang/Throwable
    //   790	798	1209	java/lang/Throwable
    //   855	908	1209	java/lang/Throwable
    //   909	945	1209	java/lang/Throwable
    //   948	1057	1209	java/lang/Throwable
    //   1057	1096	1209	java/lang/Throwable
    //   1096	1151	1209	java/lang/Throwable
    //   1151	1206	1209	java/lang/Throwable
    //   1242	1267	1209	java/lang/Throwable
    //   1270	1283	1209	java/lang/Throwable
    //   1284	1292	1209	java/lang/Throwable
    //   798	855	1241	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.g
 * JD-Core Version:    0.7.0.1
 */