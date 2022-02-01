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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class d
  extends a
{
  private Context mContext;
  public View xPJ;
  public View xPK;
  private TextView xPL;
  private TextView xPM;
  private TextView xPN;
  private TextView xPO;
  private View xPP;
  MMPinProgressBtn xPQ;
  b.h xPR;
  String xPS;
  protected a.d xPT;
  public SphereImageView xdi;
  ImageView xdk;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a xdl;
  int xdm;
  protected SphereImageView.b xgT;
  public View xtU;
  
  public d(TimeLineObject paramTimeLineObject, p paramp, b paramb)
  {
    AppMethodBeat.i(100031);
    this.xPS = null;
    this.xdm = 0;
    this.xPT = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100026);
        ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        d.this.xdi.g(paramAnonymousBitmap, paramAnonymousString2);
        AppMethodBeat.o(100026);
      }
      
      public final void onStart(String paramAnonymousString)
      {
        AppMethodBeat.i(100025);
        ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
        AppMethodBeat.o(100025);
      }
    };
    this.xgT = new SphereImageView.b()
    {
      public final void apy(final String paramAnonymousString)
      {
        AppMethodBeat.i(100029);
        if (d.this.xdk.getVisibility() == 0)
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(350L);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(100027);
              d.this.xdk.setVisibility(8);
              d.this.xdk.setImageDrawable(new ColorDrawable(d.this.xdk.getResources().getColor(2131099651)));
              AppMethodBeat.o(100027);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
          d.this.xdk.startAnimation(localAlphaAnimation);
        }
        if ((d.this.xPR != null) && (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.iS(d.this.xPR.wUA, "scene_timeline")))
        {
          ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
          d.this.xdi.setTouchEnabled(false);
          d.this.xdi.dxk();
          d.this.xdi.xfJ.requestRender();
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100028);
              String str;
              if (d.this.xPR != null)
              {
                str = d.this.xPR.wUA;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label120;
                }
                ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(d.this.xdi, str, "scene_timeline");
              }
              for (;;)
              {
                ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
                d.this.xdi.setSensorEnabled(true);
                d.this.xdi.setTouchEnabled(true);
                AppMethodBeat.o(100028);
                return;
                str = "";
                break;
                label120:
                ad.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramAnonymousString + ", info.url=" + str);
              }
            }
          }, 800L);
        }
        for (;;)
        {
          if (d.this.xPQ.getVisibility() == 0)
          {
            d.this.xPQ.setVisibility(8);
            ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
          }
          AppMethodBeat.o(100029);
          return;
          d.this.xdi.setSensorEnabled(true);
          d.this.xdi.setTouchEnabled(true);
        }
      }
      
      public final void dwB() {}
      
      public final void dwC() {}
      
      public final void dwD()
      {
        d locald = d.this;
        locald.xdm += 1;
      }
      
      public final void onDetachedFromWindow()
      {
        AppMethodBeat.i(100030);
        ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + d.this.xdi.hashCode());
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", d.this.xdm);
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          String str1 = d.this.wwP.dyc();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(17539, new Object[] { d.this.wwP.dxy().Id, localObject, d.this.wwP.dxu().dvK, Integer.valueOf(2), str2 });
          ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(str2)));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + localException.toString());
          }
        }
        d.this.xdm = 0;
        d.this.xPS = null;
        AppMethodBeat.o(100030);
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.wwP = paramp;
    this.xta = paramb;
    AppMethodBeat.o(100031);
  }
  
  public final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100032);
    this.contentView = paramView1;
    this.xwu = paramView2;
    this.mContext = paramView1.getContext();
    this.xtU = paramView1.findViewById(2131305147);
    this.xPJ = paramView1.findViewById(2131306008);
    this.xPK = paramView1.findViewById(2131297449);
    this.xPL = ((TextView)paramView1.findViewById(2131306010));
    this.xPM = ((TextView)paramView1.findViewById(2131306009));
    this.xPN = ((TextView)paramView1.findViewById(2131297451));
    this.xPO = ((TextView)paramView1.findViewById(2131297450));
    this.xPP = paramView1.findViewById(2131297455);
    this.xdk = ((ImageView)paramView1.findViewById(2131302164));
    this.xdi = ((SphereImageView)paramView1.findViewById(2131305148));
    this.xPQ = ((MMPinProgressBtn)paramView1.findViewById(2131303515));
    this.xPQ.setMax(50);
    this.xdi.X(1.8F, -2.0F);
    this.xdi.setTouchSensitivity(0.45F);
    this.xdi.setEventListener(this.xgT);
    this.xdi.setTouchEnabled(true);
    this.xdi.setSensorEnabled(false);
    this.xdi.dxk();
    this.xdl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
    this.xdl.a(this.xPT);
    ad.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "initView, hash=" + this.xdi.hashCode());
    AppMethodBeat.o(100032);
  }
  
  /* Error */
  public final void refreshView()
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 187
    //   7: new 189	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 219
    //   13: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   20: invokevirtual 200	java/lang/Object:hashCode	()I
    //   23: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   37: invokevirtual 224	com/tencent/mm/plugin/sns/storage/p:getSnsId	()Ljava/lang/String;
    //   40: invokestatic 230	com/tencent/mm/plugin/sns/storage/h:apJ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/p;
    //   43: putfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   51: aload_0
    //   52: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   55: ifnull +27 -> 82
    //   58: aload_0
    //   59: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   62: invokevirtual 236	com/tencent/mm/plugin/sns/storage/p:dxs	()Lcom/tencent/mm/plugin/sns/storage/b;
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   73: invokevirtual 236	com/tencent/mm/plugin/sns/storage/p:dxs	()Lcom/tencent/mm/plugin/sns/storage/b;
    //   76: getfield 241	com/tencent/mm/plugin/sns/storage/b:wTE	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   79: putfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   82: aload_0
    //   83: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   86: ldc 243
    //   88: invokevirtual 249	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 251	android/view/WindowManager
    //   94: astore_3
    //   95: aload_3
    //   96: invokeinterface 255 1 0
    //   101: invokevirtual 260	android/view/Display:getWidth	()I
    //   104: aload_3
    //   105: invokeinterface 255 1 0
    //   110: invokevirtual 263	android/view/Display:getHeight	()I
    //   113: invokestatic 269	java/lang/Math:min	(II)I
    //   116: istore_1
    //   117: aload_0
    //   118: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:xPJ	Landroid/view/View;
    //   121: bipush 8
    //   123: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   126: aload_0
    //   127: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:xPL	Landroid/widget/TextView;
    //   130: bipush 8
    //   132: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   135: aload_0
    //   136: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:xPM	Landroid/widget/TextView;
    //   139: bipush 8
    //   141: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   144: aload_0
    //   145: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   148: bipush 8
    //   150: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   153: aload_0
    //   154: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:xPN	Landroid/widget/TextView;
    //   157: bipush 8
    //   159: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   162: aload_0
    //   163: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:xPO	Landroid/widget/TextView;
    //   166: bipush 8
    //   168: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   171: aload_0
    //   172: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:xPP	Landroid/view/View;
    //   175: bipush 8
    //   177: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   180: aload_0
    //   181: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   184: ifnull +1127 -> 1311
    //   187: iload_1
    //   188: aload_0
    //   189: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   192: ldc_w 274
    //   195: invokestatic 280	com/tencent/mm/cd/a:ao	(Landroid/content/Context;I)I
    //   198: isub
    //   199: aload_0
    //   200: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   203: ldc_w 281
    //   206: invokestatic 280	com/tencent/mm/cd/a:ao	(Landroid/content/Context;I)I
    //   209: isub
    //   210: aload_0
    //   211: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   214: invokevirtual 285	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc_w 286
    //   220: invokevirtual 292	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   223: isub
    //   224: aload_0
    //   225: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   228: invokevirtual 285	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: ldc_w 286
    //   234: invokevirtual 292	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   237: isub
    //   238: istore_1
    //   239: aload_0
    //   240: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   243: getfield 297	com/tencent/mm/plugin/sns/storage/b$h:wUk	I
    //   246: ifne +676 -> 922
    //   249: new 299	android/view/ViewGroup$LayoutParams
    //   252: dup
    //   253: bipush 254
    //   255: bipush 254
    //   257: invokespecial 302	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   260: astore_3
    //   261: aload_3
    //   262: iload_1
    //   263: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   266: aload_3
    //   267: aload_3
    //   268: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   271: i2f
    //   272: ldc_w 306
    //   275: fmul
    //   276: f2i
    //   277: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   280: aload_3
    //   281: ifnull +129 -> 410
    //   284: aload_0
    //   285: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/d:contentView	Landroid/view/View;
    //   288: invokevirtual 313	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   291: astore 4
    //   293: aload 4
    //   295: aload_3
    //   296: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   299: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   302: aload 4
    //   304: aload_3
    //   305: getfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   308: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   311: aload_0
    //   312: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/d:contentView	Landroid/view/View;
    //   315: aload 4
    //   317: invokevirtual 317	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   320: aload_0
    //   321: getfield 92	com/tencent/mm/plugin/sns/ui/c/a/d:contentView	Landroid/view/View;
    //   324: checkcast 319	com/tencent/mm/ui/widget/RoundedCornerFrameLayout
    //   327: aload_0
    //   328: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   331: bipush 8
    //   333: invokestatic 322	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   336: i2f
    //   337: invokevirtual 325	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   340: aload_0
    //   341: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   344: invokevirtual 326	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   347: astore 4
    //   349: aload 4
    //   351: aload_3
    //   352: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   355: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   358: aload 4
    //   360: aload_3
    //   361: getfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   364: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   367: aload_0
    //   368: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   371: aload 4
    //   373: invokevirtual 327	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   376: aload_0
    //   377: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:xdk	Landroid/widget/ImageView;
    //   380: invokevirtual 328	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   383: astore_3
    //   384: aload_3
    //   385: aload 4
    //   387: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   390: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   393: aload_3
    //   394: aload 4
    //   396: getfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   399: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   402: aload_0
    //   403: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:xdk	Landroid/widget/ImageView;
    //   406: aload_3
    //   407: invokevirtual 329	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   410: aload_0
    //   411: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   414: getfield 332	com/tencent/mm/plugin/sns/storage/b$h:wUm	I
    //   417: ifne +544 -> 961
    //   420: aload_0
    //   421: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   424: getfield 335	com/tencent/mm/plugin/sns/storage/b$h:wUl	I
    //   427: i2f
    //   428: ldc_w 336
    //   431: fmul
    //   432: f2i
    //   433: iconst_0
    //   434: iconst_0
    //   435: iconst_0
    //   436: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   439: istore_1
    //   440: iconst_0
    //   441: iconst_0
    //   442: iconst_0
    //   443: iconst_0
    //   444: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   447: istore_2
    //   448: new 344	android/graphics/drawable/GradientDrawable
    //   451: dup
    //   452: getstatic 350	android/graphics/drawable/GradientDrawable$Orientation:TOP_BOTTOM	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   455: iconst_2
    //   456: newarray int
    //   458: dup
    //   459: iconst_0
    //   460: iload_1
    //   461: iastore
    //   462: dup
    //   463: iconst_1
    //   464: iload_2
    //   465: iastore
    //   466: invokespecial 353	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   469: astore_3
    //   470: aload_3
    //   471: iconst_0
    //   472: invokevirtual 356	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   475: aload_0
    //   476: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:xPJ	Landroid/view/View;
    //   479: aload_3
    //   480: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   483: aload_0
    //   484: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   487: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   490: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   493: ifeq +16 -> 509
    //   496: aload_0
    //   497: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   500: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   503: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   506: ifne +11 -> 517
    //   509: aload_0
    //   510: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:xPJ	Landroid/view/View;
    //   513: iconst_0
    //   514: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   517: aload_0
    //   518: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   521: bipush 8
    //   523: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   526: aload_0
    //   527: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   530: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   533: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   536: ifne +52 -> 588
    //   539: aload_0
    //   540: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:xPL	Landroid/widget/TextView;
    //   543: iconst_0
    //   544: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   547: aload_0
    //   548: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:xPL	Landroid/widget/TextView;
    //   551: astore_3
    //   552: invokestatic 378	com/tencent/mm/cg/g:eIa	()Lcom/tencent/mm/cg/g;
    //   555: astore 4
    //   557: aload_0
    //   558: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:xPL	Landroid/widget/TextView;
    //   561: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   564: pop
    //   565: aload_3
    //   566: aload 4
    //   568: aload_0
    //   569: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   572: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   575: aload_0
    //   576: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:xPL	Landroid/widget/TextView;
    //   579: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   582: invokevirtual 387	com/tencent/mm/cg/g:b	(Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   585: invokevirtual 391	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   588: aload_0
    //   589: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   592: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   595: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   598: ifne +52 -> 650
    //   601: aload_0
    //   602: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:xPM	Landroid/widget/TextView;
    //   605: iconst_0
    //   606: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   609: aload_0
    //   610: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:xPM	Landroid/widget/TextView;
    //   613: astore_3
    //   614: invokestatic 378	com/tencent/mm/cg/g:eIa	()Lcom/tencent/mm/cg/g;
    //   617: astore 4
    //   619: aload_0
    //   620: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:xPM	Landroid/widget/TextView;
    //   623: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   626: pop
    //   627: aload_3
    //   628: aload 4
    //   630: aload_0
    //   631: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   634: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   637: aload_0
    //   638: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:xPM	Landroid/widget/TextView;
    //   641: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   644: invokevirtual 387	com/tencent/mm/cg/g:b	(Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   647: invokevirtual 391	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   650: aload_0
    //   651: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   654: ifnull +95 -> 749
    //   657: aload_0
    //   658: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:wwP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   661: invokevirtual 395	com/tencent/mm/plugin/sns/storage/p:dxu	()Lcom/tencent/mm/plugin/sns/storage/a;
    //   664: invokevirtual 401	com/tencent/mm/plugin/sns/storage/a:dvd	()Z
    //   667: ifeq +82 -> 749
    //   670: aload_0
    //   671: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   674: getfield 335	com/tencent/mm/plugin/sns/storage/b$h:wUl	I
    //   677: i2f
    //   678: ldc_w 336
    //   681: fmul
    //   682: f2i
    //   683: iconst_0
    //   684: iconst_0
    //   685: iconst_0
    //   686: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   689: istore_1
    //   690: iconst_0
    //   691: iconst_0
    //   692: iconst_0
    //   693: iconst_0
    //   694: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   697: istore_2
    //   698: new 344	android/graphics/drawable/GradientDrawable
    //   701: dup
    //   702: getstatic 404	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   705: iconst_2
    //   706: newarray int
    //   708: dup
    //   709: iconst_0
    //   710: iload_1
    //   711: iastore
    //   712: dup
    //   713: iconst_1
    //   714: iload_2
    //   715: iastore
    //   716: invokespecial 353	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   719: astore_3
    //   720: aload_3
    //   721: iconst_0
    //   722: invokevirtual 356	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   725: aload_0
    //   726: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   729: iconst_0
    //   730: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   733: aload_0
    //   734: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   737: aload_3
    //   738: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   741: aload_0
    //   742: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:xPP	Landroid/view/View;
    //   745: iconst_0
    //   746: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   749: aload_0
    //   750: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   753: iconst_0
    //   754: invokevirtual 405	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setVisibility	(I)V
    //   757: aload_0
    //   758: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   761: aload_0
    //   762: invokevirtual 409	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setTag	(Ljava/lang/Object;)V
    //   765: aload_0
    //   766: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   769: aload_0
    //   770: getfield 82	com/tencent/mm/plugin/sns/ui/c/a/d:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   773: getfield 415	com/tencent/mm/plugin/sns/ui/d/b:xUd	Landroid/view/View$OnClickListener;
    //   776: invokevirtual 419	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   779: aload_0
    //   780: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:xPS	Ljava/lang/String;
    //   783: ifnull +20 -> 803
    //   786: aload_0
    //   787: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:xPS	Ljava/lang/String;
    //   790: aload_0
    //   791: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   794: getfield 422	com/tencent/mm/plugin/sns/storage/b$h:wUA	Ljava/lang/String;
    //   797: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   800: ifne +497 -> 1297
    //   803: ldc 187
    //   805: ldc_w 430
    //   808: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: aload_0
    //   812: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:xdk	Landroid/widget/ImageView;
    //   815: iconst_0
    //   816: invokevirtual 431	android/widget/ImageView:setVisibility	(I)V
    //   819: aload_0
    //   820: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   823: getfield 422	com/tencent/mm/plugin/sns/storage/b$h:wUA	Ljava/lang/String;
    //   826: astore_3
    //   827: aload_0
    //   828: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   831: getfield 434	com/tencent/mm/plugin/sns/storage/b$h:wUB	Ljava/lang/String;
    //   834: astore 4
    //   836: new 436	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c
    //   839: dup
    //   840: aload_3
    //   841: aload 4
    //   843: ldc_w 438
    //   846: new 6	com/tencent/mm/plugin/sns/ui/c/a/d$1
    //   849: dup
    //   850: aload_0
    //   851: aload_3
    //   852: aload 4
    //   854: invokespecial 441	com/tencent/mm/plugin/sns/ui/c/a/d$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/d;Ljava/lang/String;Ljava/lang/String;)V
    //   857: invokespecial 444	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$d;)V
    //   860: iconst_0
    //   861: anewarray 446	java/lang/Void
    //   864: invokevirtual 450	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   867: pop
    //   868: aload_0
    //   869: getfield 181	com/tencent/mm/plugin/sns/ui/c/a/d:xdl	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   872: aload_0
    //   873: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   876: getfield 422	com/tencent/mm/plugin/sns/storage/b$h:wUA	Ljava/lang/String;
    //   879: aload_0
    //   880: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   883: invokevirtual 326	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   886: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   889: aload_0
    //   890: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:xdi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   893: invokevirtual 326	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   896: getfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   899: ldc_w 438
    //   902: invokevirtual 454	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:j	(Ljava/lang/String;IILjava/lang/String;)V
    //   905: aload_0
    //   906: aload_0
    //   907: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   910: getfield 422	com/tencent/mm/plugin/sns/storage/b$h:wUA	Ljava/lang/String;
    //   913: putfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:xPS	Ljava/lang/String;
    //   916: ldc 217
    //   918: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   921: return
    //   922: aload_0
    //   923: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   926: getfield 297	com/tencent/mm/plugin/sns/storage/b$h:wUk	I
    //   929: iconst_1
    //   930: if_icmpne +395 -> 1325
    //   933: new 299	android/view/ViewGroup$LayoutParams
    //   936: dup
    //   937: bipush 254
    //   939: bipush 254
    //   941: invokespecial 302	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   944: astore_3
    //   945: aload_3
    //   946: iload_1
    //   947: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   950: aload_3
    //   951: aload_3
    //   952: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   955: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   958: goto -678 -> 280
    //   961: aload_0
    //   962: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   965: getfield 332	com/tencent/mm/plugin/sns/storage/b$h:wUm	I
    //   968: iconst_1
    //   969: if_icmpne -319 -> 650
    //   972: aload_0
    //   973: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   976: getfield 335	com/tencent/mm/plugin/sns/storage/b$h:wUl	I
    //   979: i2f
    //   980: ldc_w 336
    //   983: fmul
    //   984: f2i
    //   985: iconst_0
    //   986: iconst_0
    //   987: iconst_0
    //   988: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   991: istore_1
    //   992: iconst_0
    //   993: iconst_0
    //   994: iconst_0
    //   995: iconst_0
    //   996: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   999: istore_2
    //   1000: new 344	android/graphics/drawable/GradientDrawable
    //   1003: dup
    //   1004: getstatic 404	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   1007: iconst_2
    //   1008: newarray int
    //   1010: dup
    //   1011: iconst_0
    //   1012: iload_1
    //   1013: iastore
    //   1014: dup
    //   1015: iconst_1
    //   1016: iload_2
    //   1017: iastore
    //   1018: invokespecial 353	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   1021: astore_3
    //   1022: aload_3
    //   1023: iconst_0
    //   1024: invokevirtual 356	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   1027: aload_0
    //   1028: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:xPJ	Landroid/view/View;
    //   1031: bipush 8
    //   1033: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   1036: aload_0
    //   1037: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   1040: aload_3
    //   1041: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1044: aload_0
    //   1045: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1048: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   1051: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1054: ifeq +16 -> 1070
    //   1057: aload_0
    //   1058: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1061: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   1064: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1067: ifne +42 -> 1109
    //   1070: aload_0
    //   1071: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:xPK	Landroid/view/View;
    //   1074: iconst_0
    //   1075: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   1078: aload_0
    //   1079: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:xPP	Landroid/view/View;
    //   1082: invokevirtual 313	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1085: checkcast 456	android/widget/RelativeLayout$LayoutParams
    //   1088: astore_3
    //   1089: aload_3
    //   1090: aload_0
    //   1091: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   1094: iconst_4
    //   1095: invokestatic 322	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1098: putfield 459	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1101: aload_0
    //   1102: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:xPP	Landroid/view/View;
    //   1105: aload_3
    //   1106: invokevirtual 317	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1109: aload_0
    //   1110: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1113: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   1116: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1119: ifne +52 -> 1171
    //   1122: aload_0
    //   1123: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:xPN	Landroid/widget/TextView;
    //   1126: iconst_0
    //   1127: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   1130: aload_0
    //   1131: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:xPN	Landroid/widget/TextView;
    //   1134: astore_3
    //   1135: invokestatic 378	com/tencent/mm/cg/g:eIa	()Lcom/tencent/mm/cg/g;
    //   1138: astore 4
    //   1140: aload_0
    //   1141: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:xPN	Landroid/widget/TextView;
    //   1144: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1147: pop
    //   1148: aload_3
    //   1149: aload 4
    //   1151: aload_0
    //   1152: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1155: getfield 363	com/tencent/mm/plugin/sns/storage/b$h:title	Ljava/lang/String;
    //   1158: aload_0
    //   1159: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:xPN	Landroid/widget/TextView;
    //   1162: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   1165: invokevirtual 387	com/tencent/mm/cg/g:b	(Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1168: invokevirtual 391	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1171: aload_0
    //   1172: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1175: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   1178: invokestatic 369	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1181: ifne -531 -> 650
    //   1184: aload_0
    //   1185: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:xPO	Landroid/widget/TextView;
    //   1188: iconst_0
    //   1189: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   1192: aload_0
    //   1193: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:xPO	Landroid/widget/TextView;
    //   1196: astore_3
    //   1197: invokestatic 378	com/tencent/mm/cg/g:eIa	()Lcom/tencent/mm/cg/g;
    //   1200: astore 4
    //   1202: aload_0
    //   1203: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:xPO	Landroid/widget/TextView;
    //   1206: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1209: pop
    //   1210: aload_3
    //   1211: aload 4
    //   1213: aload_0
    //   1214: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:xPR	Lcom/tencent/mm/plugin/sns/storage/b$h;
    //   1217: getfield 372	com/tencent/mm/plugin/sns/storage/b$h:description	Ljava/lang/String;
    //   1220: aload_0
    //   1221: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:xPO	Landroid/widget/TextView;
    //   1224: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   1227: invokevirtual 387	com/tencent/mm/cg/g:b	(Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1230: invokevirtual 391	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1233: goto -583 -> 650
    //   1236: astore_3
    //   1237: ldc 187
    //   1239: new 189	java/lang/StringBuilder
    //   1242: dup
    //   1243: ldc_w 461
    //   1246: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1249: aload_3
    //   1250: invokevirtual 462	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1253: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1262: ldc 217
    //   1264: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1267: return
    //   1268: astore_3
    //   1269: ldc 187
    //   1271: new 189	java/lang/StringBuilder
    //   1274: dup
    //   1275: ldc_w 470
    //   1278: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1281: aload_3
    //   1282: invokevirtual 462	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1285: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1294: goto -426 -> 868
    //   1297: ldc 187
    //   1299: ldc_w 472
    //   1302: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1305: ldc 217
    //   1307: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1310: return
    //   1311: ldc 187
    //   1313: ldc_w 474
    //   1316: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1319: ldc 217
    //   1321: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1324: return
    //   1325: aconst_null
    //   1326: astore_3
    //   1327: goto -1047 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1330	0	this	d
    //   116	897	1	i	int
    //   447	570	2	j	int
    //   94	1117	3	localObject1	Object
    //   1236	14	3	localThrowable1	Throwable
    //   1268	14	3	localThrowable2	Throwable
    //   1326	1	3	localObject2	Object
    //   291	921	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	82	1236	java/lang/Throwable
    //   82	280	1236	java/lang/Throwable
    //   284	410	1236	java/lang/Throwable
    //   410	509	1236	java/lang/Throwable
    //   509	517	1236	java/lang/Throwable
    //   517	588	1236	java/lang/Throwable
    //   588	650	1236	java/lang/Throwable
    //   650	749	1236	java/lang/Throwable
    //   749	803	1236	java/lang/Throwable
    //   803	811	1236	java/lang/Throwable
    //   868	921	1236	java/lang/Throwable
    //   922	958	1236	java/lang/Throwable
    //   961	1070	1236	java/lang/Throwable
    //   1070	1109	1236	java/lang/Throwable
    //   1109	1171	1236	java/lang/Throwable
    //   1171	1233	1236	java/lang/Throwable
    //   1269	1294	1236	java/lang/Throwable
    //   1297	1310	1236	java/lang/Throwable
    //   1311	1319	1236	java/lang/Throwable
    //   811	868	1268	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */