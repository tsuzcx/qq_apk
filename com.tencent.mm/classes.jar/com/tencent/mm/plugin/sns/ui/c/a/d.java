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
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
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

public final class d
  extends a
{
  public View EVJ;
  public View EVK;
  private TextView EVL;
  private TextView EVM;
  private TextView EVN;
  private TextView EVO;
  private View EVP;
  MMPinProgressBtn EVQ;
  ADXml.i EVR;
  String EVS;
  protected a.d EVT;
  public SphereImageView EgD;
  ImageView EgF;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a EgG;
  int EgH;
  protected SphereImageView.b Ekr;
  public View ExX;
  private Context mContext;
  
  public d(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc)
  {
    AppMethodBeat.i(100031);
    this.EVS = null;
    this.EgH = 0;
    this.EVT = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100026);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        d.this.EgD.g(paramAnonymousBitmap, paramAnonymousString2);
        AppMethodBeat.o(100026);
      }
      
      public final void onStart(String paramAnonymousString)
      {
        AppMethodBeat.i(100025);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
        AppMethodBeat.o(100025);
      }
    };
    this.Ekr = new SphereImageView.b()
    {
      public final void aQa(final String paramAnonymousString)
      {
        AppMethodBeat.i(100029);
        if (d.this.EgF.getVisibility() == 0)
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(350L);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(100027);
              d.this.EgF.setVisibility(8);
              d.this.EgF.setImageDrawable(new ColorDrawable(d.this.EgF.getResources().getColor(2131099651)));
              AppMethodBeat.o(100027);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
          d.this.EgF.startAnimation(localAlphaAnimation);
        }
        if ((d.this.EVR != null) && (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kx(d.this.EVR.DWL, "scene_timeline")))
        {
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
          d.this.EgD.setTouchEnabled(false);
          d.this.EgD.feu();
          d.this.EgD.Ejd.requestRender();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100028);
              String str;
              if (d.this.EVR != null)
              {
                str = d.this.EVR.DWL;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label120;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(d.this.EgD, str, "scene_timeline");
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
                d.this.EgD.setSensorEnabled(true);
                d.this.EgD.setTouchEnabled(true);
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
          if (d.this.EVQ.getVisibility() == 0)
          {
            d.this.EVQ.setVisibility(8);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
          }
          AppMethodBeat.o(100029);
          return;
          d.this.EgD.setSensorEnabled(true);
          d.this.EgD.setTouchEnabled(true);
        }
      }
      
      public final void fdK() {}
      
      public final void fdL() {}
      
      public final void fdM()
      {
        d locald = d.this;
        locald.EgH += 1;
      }
      
      public final void onDetachedFromWindow()
      {
        AppMethodBeat.i(100030);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + d.this.EgD.hashCode());
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", d.this.EgH);
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          String str1 = d.this.DsC.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(17539, new Object[] { d.this.DsC.getTimeLine().Id, localObject, d.this.DsC.getAdInfo().uxInfo, Integer.valueOf(2), str2 });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(str2)));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + localException.toString());
          }
        }
        d.this.EgH = 0;
        d.this.EVS = null;
        AppMethodBeat.o(100030);
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.DsC = paramSnsInfo;
    this.Dyw = paramc;
    AppMethodBeat.o(100031);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100032);
    this.contentView = paramView1;
    this.EAV = paramView2;
    this.mContext = paramView1.getContext();
    this.ExX = paramView1.findViewById(2131308329);
    this.EVJ = paramView1.findViewById(2131309318);
    this.EVK = paramView1.findViewById(2131297679);
    this.EVL = ((TextView)paramView1.findViewById(2131309320));
    this.EVM = ((TextView)paramView1.findViewById(2131309319));
    this.EVN = ((TextView)paramView1.findViewById(2131297681));
    this.EVO = ((TextView)paramView1.findViewById(2131297680));
    this.EVP = paramView1.findViewById(2131297688);
    this.EgF = ((ImageView)paramView1.findViewById(2131304506));
    this.EgD = ((SphereImageView)paramView1.findViewById(2131308330));
    this.EVQ = ((MMPinProgressBtn)paramView1.findViewById(2131306281));
    this.EVQ.setMax(50);
    this.EgD.an(1.8F, -2.0F);
    this.EgD.setTouchSensitivity(0.45F);
    this.EgD.setEventListener(this.Ekr);
    this.EgD.setTouchEnabled(true);
    this.EgD.setSensorEnabled(false);
    this.EgD.feu();
    this.EgG = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
    this.EgG.a(this.EVT);
    Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "initView, hash=" + this.EgD.hashCode());
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
    //   17: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   20: invokevirtual 200	java/lang/Object:hashCode	()I
    //   23: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   37: invokevirtual 224	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   40: invokestatic 230	com/tencent/mm/plugin/sns/storage/f:aQl	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   43: putfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   51: aload_0
    //   52: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   55: ifnull +27 -> 82
    //   58: aload_0
    //   59: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   62: invokevirtual 236	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   73: invokevirtual 236	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   76: getfield 241	com/tencent/mm/plugin/sns/storage/ADXml:adSphereCardInfo	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   79: putfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
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
    //   118: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:EVJ	Landroid/view/View;
    //   121: bipush 8
    //   123: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   126: aload_0
    //   127: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:EVL	Landroid/widget/TextView;
    //   130: bipush 8
    //   132: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   135: aload_0
    //   136: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:EVM	Landroid/widget/TextView;
    //   139: bipush 8
    //   141: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   144: aload_0
    //   145: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   148: bipush 8
    //   150: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   153: aload_0
    //   154: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:EVN	Landroid/widget/TextView;
    //   157: bipush 8
    //   159: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   162: aload_0
    //   163: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:EVO	Landroid/widget/TextView;
    //   166: bipush 8
    //   168: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   171: aload_0
    //   172: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:EVP	Landroid/view/View;
    //   175: bipush 8
    //   177: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   180: aload_0
    //   181: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   184: ifnull +1099 -> 1283
    //   187: iload_1
    //   188: aload_0
    //   189: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   192: ldc_w 274
    //   195: invokestatic 280	com/tencent/mm/cb/a:aG	(Landroid/content/Context;I)I
    //   198: isub
    //   199: aload_0
    //   200: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   203: ldc_w 281
    //   206: invokestatic 280	com/tencent/mm/cb/a:aG	(Landroid/content/Context;I)I
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
    //   240: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   243: getfield 297	com/tencent/mm/plugin/sns/storage/ADXml$i:DWw	I
    //   246: ifne +662 -> 908
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
    //   333: invokestatic 322	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   336: i2f
    //   337: invokevirtual 325	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   340: aload_0
    //   341: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
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
    //   368: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   371: aload 4
    //   373: invokevirtual 327	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   376: aload_0
    //   377: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:EgF	Landroid/widget/ImageView;
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
    //   403: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:EgF	Landroid/widget/ImageView;
    //   406: aload_3
    //   407: invokevirtual 329	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   410: aload_0
    //   411: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   414: getfield 332	com/tencent/mm/plugin/sns/storage/ADXml$i:DWy	I
    //   417: ifne +530 -> 947
    //   420: aload_0
    //   421: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   424: getfield 335	com/tencent/mm/plugin/sns/storage/ADXml$i:DWx	I
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
    //   476: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:EVJ	Landroid/view/View;
    //   479: aload_3
    //   480: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   483: aload_0
    //   484: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   487: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   490: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   493: ifeq +16 -> 509
    //   496: aload_0
    //   497: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   500: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   503: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   506: ifne +11 -> 517
    //   509: aload_0
    //   510: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:EVJ	Landroid/view/View;
    //   513: iconst_0
    //   514: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   517: aload_0
    //   518: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   521: bipush 8
    //   523: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   526: aload_0
    //   527: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   530: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   533: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   536: ifne +45 -> 581
    //   539: aload_0
    //   540: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:EVL	Landroid/widget/TextView;
    //   543: iconst_0
    //   544: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   547: aload_0
    //   548: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:EVL	Landroid/widget/TextView;
    //   551: invokestatic 378	com/tencent/mm/ce/g:gxZ	()Lcom/tencent/mm/ce/g;
    //   554: aload_0
    //   555: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:EVL	Landroid/widget/TextView;
    //   558: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   561: aload_0
    //   562: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   565: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   568: aload_0
    //   569: getfield 121	com/tencent/mm/plugin/sns/ui/c/a/d:EVL	Landroid/widget/TextView;
    //   572: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   575: invokevirtual 386	com/tencent/mm/ce/g:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   578: invokevirtual 390	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   581: aload_0
    //   582: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   585: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   588: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   591: ifne +45 -> 636
    //   594: aload_0
    //   595: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:EVM	Landroid/widget/TextView;
    //   598: iconst_0
    //   599: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   602: aload_0
    //   603: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:EVM	Landroid/widget/TextView;
    //   606: invokestatic 378	com/tencent/mm/ce/g:gxZ	()Lcom/tencent/mm/ce/g;
    //   609: aload_0
    //   610: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:EVM	Landroid/widget/TextView;
    //   613: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   616: aload_0
    //   617: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   620: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   623: aload_0
    //   624: getfield 124	com/tencent/mm/plugin/sns/ui/c/a/d:EVM	Landroid/widget/TextView;
    //   627: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   630: invokevirtual 386	com/tencent/mm/ce/g:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   633: invokevirtual 390	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   636: aload_0
    //   637: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   640: ifnull +95 -> 735
    //   643: aload_0
    //   644: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/d:DsC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   647: invokevirtual 394	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   650: invokevirtual 400	com/tencent/mm/plugin/sns/storage/ADInfo:isWeapp	()Z
    //   653: ifeq +82 -> 735
    //   656: aload_0
    //   657: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   660: getfield 335	com/tencent/mm/plugin/sns/storage/ADXml$i:DWx	I
    //   663: i2f
    //   664: ldc_w 336
    //   667: fmul
    //   668: f2i
    //   669: iconst_0
    //   670: iconst_0
    //   671: iconst_0
    //   672: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   675: istore_1
    //   676: iconst_0
    //   677: iconst_0
    //   678: iconst_0
    //   679: iconst_0
    //   680: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   683: istore_2
    //   684: new 344	android/graphics/drawable/GradientDrawable
    //   687: dup
    //   688: getstatic 403	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   691: iconst_2
    //   692: newarray int
    //   694: dup
    //   695: iconst_0
    //   696: iload_1
    //   697: iastore
    //   698: dup
    //   699: iconst_1
    //   700: iload_2
    //   701: iastore
    //   702: invokespecial 353	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   705: astore_3
    //   706: aload_3
    //   707: iconst_0
    //   708: invokevirtual 356	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   711: aload_0
    //   712: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   715: iconst_0
    //   716: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   719: aload_0
    //   720: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   723: aload_3
    //   724: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   727: aload_0
    //   728: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:EVP	Landroid/view/View;
    //   731: iconst_0
    //   732: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   735: aload_0
    //   736: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   739: iconst_0
    //   740: invokevirtual 404	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setVisibility	(I)V
    //   743: aload_0
    //   744: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   747: aload_0
    //   748: invokevirtual 408	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setTag	(Ljava/lang/Object;)V
    //   751: aload_0
    //   752: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   755: aload_0
    //   756: getfield 82	com/tencent/mm/plugin/sns/ui/c/a/d:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   759: getfield 414	com/tencent/mm/plugin/sns/ui/d/c:Fbd	Landroid/view/View$OnClickListener;
    //   762: invokevirtual 418	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   765: aload_0
    //   766: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:EVS	Ljava/lang/String;
    //   769: ifnull +20 -> 789
    //   772: aload_0
    //   773: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:EVS	Ljava/lang/String;
    //   776: aload_0
    //   777: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   780: getfield 421	com/tencent/mm/plugin/sns/storage/ADXml$i:DWL	Ljava/lang/String;
    //   783: invokevirtual 427	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   786: ifne +483 -> 1269
    //   789: ldc 187
    //   791: ldc_w 429
    //   794: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   797: aload_0
    //   798: getfield 138	com/tencent/mm/plugin/sns/ui/c/a/d:EgF	Landroid/widget/ImageView;
    //   801: iconst_0
    //   802: invokevirtual 430	android/widget/ImageView:setVisibility	(I)V
    //   805: aload_0
    //   806: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   809: getfield 421	com/tencent/mm/plugin/sns/storage/ADXml$i:DWL	Ljava/lang/String;
    //   812: astore_3
    //   813: aload_0
    //   814: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   817: getfield 433	com/tencent/mm/plugin/sns/storage/ADXml$i:DWM	Ljava/lang/String;
    //   820: astore 4
    //   822: new 435	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c
    //   825: dup
    //   826: aload_3
    //   827: aload 4
    //   829: ldc_w 437
    //   832: new 6	com/tencent/mm/plugin/sns/ui/c/a/d$1
    //   835: dup
    //   836: aload_0
    //   837: aload_3
    //   838: aload 4
    //   840: invokespecial 440	com/tencent/mm/plugin/sns/ui/c/a/d$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/d;Ljava/lang/String;Ljava/lang/String;)V
    //   843: invokespecial 443	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$d;)V
    //   846: iconst_0
    //   847: anewarray 445	java/lang/Void
    //   850: invokevirtual 449	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   853: pop
    //   854: aload_0
    //   855: getfield 181	com/tencent/mm/plugin/sns/ui/c/a/d:EgG	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   858: aload_0
    //   859: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   862: getfield 421	com/tencent/mm/plugin/sns/storage/ADXml$i:DWL	Ljava/lang/String;
    //   865: aload_0
    //   866: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   869: invokevirtual 326	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   872: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   875: aload_0
    //   876: getfield 143	com/tencent/mm/plugin/sns/ui/c/a/d:EgD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   879: invokevirtual 326	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   882: getfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   885: ldc_w 437
    //   888: invokevirtual 453	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:l	(Ljava/lang/String;IILjava/lang/String;)V
    //   891: aload_0
    //   892: aload_0
    //   893: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   896: getfield 421	com/tencent/mm/plugin/sns/storage/ADXml$i:DWL	Ljava/lang/String;
    //   899: putfield 60	com/tencent/mm/plugin/sns/ui/c/a/d:EVS	Ljava/lang/String;
    //   902: ldc 217
    //   904: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   907: return
    //   908: aload_0
    //   909: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   912: getfield 297	com/tencent/mm/plugin/sns/storage/ADXml$i:DWw	I
    //   915: iconst_1
    //   916: if_icmpne +381 -> 1297
    //   919: new 299	android/view/ViewGroup$LayoutParams
    //   922: dup
    //   923: bipush 254
    //   925: bipush 254
    //   927: invokespecial 302	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   930: astore_3
    //   931: aload_3
    //   932: iload_1
    //   933: putfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   936: aload_3
    //   937: aload_3
    //   938: getfield 305	android/view/ViewGroup$LayoutParams:width	I
    //   941: putfield 309	android/view/ViewGroup$LayoutParams:height	I
    //   944: goto -664 -> 280
    //   947: aload_0
    //   948: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   951: getfield 332	com/tencent/mm/plugin/sns/storage/ADXml$i:DWy	I
    //   954: iconst_1
    //   955: if_icmpne -319 -> 636
    //   958: aload_0
    //   959: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   962: getfield 335	com/tencent/mm/plugin/sns/storage/ADXml$i:DWx	I
    //   965: i2f
    //   966: ldc_w 336
    //   969: fmul
    //   970: f2i
    //   971: iconst_0
    //   972: iconst_0
    //   973: iconst_0
    //   974: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   977: istore_1
    //   978: iconst_0
    //   979: iconst_0
    //   980: iconst_0
    //   981: iconst_0
    //   982: invokestatic 342	android/graphics/Color:argb	(IIII)I
    //   985: istore_2
    //   986: new 344	android/graphics/drawable/GradientDrawable
    //   989: dup
    //   990: getstatic 403	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   993: iconst_2
    //   994: newarray int
    //   996: dup
    //   997: iconst_0
    //   998: iload_1
    //   999: iastore
    //   1000: dup
    //   1001: iconst_1
    //   1002: iload_2
    //   1003: iastore
    //   1004: invokespecial 353	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   1007: astore_3
    //   1008: aload_3
    //   1009: iconst_0
    //   1010: invokevirtual 356	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   1013: aload_0
    //   1014: getfield 113	com/tencent/mm/plugin/sns/ui/c/a/d:EVJ	Landroid/view/View;
    //   1017: bipush 8
    //   1019: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   1022: aload_0
    //   1023: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   1026: aload_3
    //   1027: invokevirtual 360	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1030: aload_0
    //   1031: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1034: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1037: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1040: ifeq +16 -> 1056
    //   1043: aload_0
    //   1044: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1047: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1050: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1053: ifne +42 -> 1095
    //   1056: aload_0
    //   1057: getfield 116	com/tencent/mm/plugin/sns/ui/c/a/d:EVK	Landroid/view/View;
    //   1060: iconst_0
    //   1061: invokevirtual 272	android/view/View:setVisibility	(I)V
    //   1064: aload_0
    //   1065: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:EVP	Landroid/view/View;
    //   1068: invokevirtual 313	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1071: checkcast 455	android/widget/RelativeLayout$LayoutParams
    //   1074: astore_3
    //   1075: aload_3
    //   1076: aload_0
    //   1077: getfield 103	com/tencent/mm/plugin/sns/ui/c/a/d:mContext	Landroid/content/Context;
    //   1080: iconst_4
    //   1081: invokestatic 322	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1084: putfield 458	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1087: aload_0
    //   1088: getfield 133	com/tencent/mm/plugin/sns/ui/c/a/d:EVP	Landroid/view/View;
    //   1091: aload_3
    //   1092: invokevirtual 317	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1095: aload_0
    //   1096: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1099: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1102: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1105: ifne +45 -> 1150
    //   1108: aload_0
    //   1109: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:EVN	Landroid/widget/TextView;
    //   1112: iconst_0
    //   1113: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   1116: aload_0
    //   1117: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:EVN	Landroid/widget/TextView;
    //   1120: invokestatic 378	com/tencent/mm/ce/g:gxZ	()Lcom/tencent/mm/ce/g;
    //   1123: aload_0
    //   1124: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:EVN	Landroid/widget/TextView;
    //   1127: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1130: aload_0
    //   1131: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1134: getfield 363	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1137: aload_0
    //   1138: getfield 127	com/tencent/mm/plugin/sns/ui/c/a/d:EVN	Landroid/widget/TextView;
    //   1141: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   1144: invokevirtual 386	com/tencent/mm/ce/g:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1147: invokevirtual 390	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1150: aload_0
    //   1151: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1154: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1157: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1160: ifne -524 -> 636
    //   1163: aload_0
    //   1164: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:EVO	Landroid/widget/TextView;
    //   1167: iconst_0
    //   1168: invokevirtual 273	android/widget/TextView:setVisibility	(I)V
    //   1171: aload_0
    //   1172: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:EVO	Landroid/widget/TextView;
    //   1175: invokestatic 378	com/tencent/mm/ce/g:gxZ	()Lcom/tencent/mm/ce/g;
    //   1178: aload_0
    //   1179: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:EVO	Landroid/widget/TextView;
    //   1182: invokevirtual 379	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1185: aload_0
    //   1186: getfield 232	com/tencent/mm/plugin/sns/ui/c/a/d:EVR	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1189: getfield 372	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1192: aload_0
    //   1193: getfield 130	com/tencent/mm/plugin/sns/ui/c/a/d:EVO	Landroid/widget/TextView;
    //   1196: invokevirtual 383	android/widget/TextView:getTextSize	()F
    //   1199: invokevirtual 386	com/tencent/mm/ce/g:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1202: invokevirtual 390	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1205: goto -569 -> 636
    //   1208: astore_3
    //   1209: ldc 187
    //   1211: new 189	java/lang/StringBuilder
    //   1214: dup
    //   1215: ldc_w 460
    //   1218: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1221: aload_3
    //   1222: invokevirtual 461	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1225: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: ldc 217
    //   1236: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1239: return
    //   1240: astore_3
    //   1241: ldc 187
    //   1243: new 189	java/lang/StringBuilder
    //   1246: dup
    //   1247: ldc_w 469
    //   1250: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1253: aload_3
    //   1254: invokevirtual 461	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1257: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: goto -412 -> 854
    //   1269: ldc 187
    //   1271: ldc_w 471
    //   1274: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1277: ldc 217
    //   1279: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1282: return
    //   1283: ldc 187
    //   1285: ldc_w 473
    //   1288: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1291: ldc 217
    //   1293: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1296: return
    //   1297: aconst_null
    //   1298: astore_3
    //   1299: goto -1019 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1302	0	this	d
    //   116	883	1	i	int
    //   447	556	2	j	int
    //   94	998	3	localObject1	Object
    //   1208	14	3	localThrowable1	Throwable
    //   1240	14	3	localThrowable2	Throwable
    //   1298	1	3	localObject2	Object
    //   291	548	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	82	1208	java/lang/Throwable
    //   82	280	1208	java/lang/Throwable
    //   284	410	1208	java/lang/Throwable
    //   410	509	1208	java/lang/Throwable
    //   509	517	1208	java/lang/Throwable
    //   517	581	1208	java/lang/Throwable
    //   581	636	1208	java/lang/Throwable
    //   636	735	1208	java/lang/Throwable
    //   735	789	1208	java/lang/Throwable
    //   789	797	1208	java/lang/Throwable
    //   854	907	1208	java/lang/Throwable
    //   908	944	1208	java/lang/Throwable
    //   947	1056	1208	java/lang/Throwable
    //   1056	1095	1208	java/lang/Throwable
    //   1095	1150	1208	java/lang/Throwable
    //   1150	1205	1208	java/lang/Throwable
    //   1241	1266	1208	java/lang/Throwable
    //   1269	1282	1208	java/lang/Throwable
    //   1283	1291	1208	java/lang/Throwable
    //   797	854	1240	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */