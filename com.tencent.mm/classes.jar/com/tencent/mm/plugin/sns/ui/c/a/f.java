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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class f
  extends b
{
  public View Cxb;
  public SphereImageView QSc;
  ImageView QSe;
  private a QSf;
  int QSg;
  protected SphereImageView.b QWi;
  public View RJK;
  public View RJL;
  private TextView RJM;
  private TextView RJN;
  private TextView RJO;
  private TextView RJP;
  private View RJQ;
  MMPinProgressBtn RJR;
  ADXml.i RJS;
  String RJT;
  protected a.d RJU;
  private Context mContext;
  
  public f(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc)
  {
    AppMethodBeat.i(100031);
    this.RJT = null;
    this.QSg = 0;
    this.RJU = new a.d()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(100026);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + paramAnonymousBoolean + ", errInfo=" + paramAnonymousString1);
        f.this.QSc.k(paramAnonymousBitmap, paramAnonymousString2);
        AppMethodBeat.o(100026);
      }
      
      public final void aNZ(String paramAnonymousString)
      {
        AppMethodBeat.i(100025);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
        AppMethodBeat.o(100025);
      }
    };
    this.QWi = new SphereImageView.b()
    {
      public final void aZA(final String paramAnonymousString)
      {
        AppMethodBeat.i(100029);
        if (f.this.QSe.getVisibility() == 0)
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(350L);
          localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(100027);
              f.this.QSe.setVisibility(8);
              f.this.QSe.setImageDrawable(new ColorDrawable(f.this.QSe.getResources().getColor(b.c.BG_3)));
              AppMethodBeat.o(100027);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
          f.this.QSe.startAnimation(localAlphaAnimation);
        }
        if ((f.this.RJS != null) && (!a.mz(f.this.RJS.QHV, "scene_timeline")))
        {
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
          f.this.QSc.setTouchEnabled(false);
          f.this.QSc.hkt();
          f.this.QSc.QUV.requestRender();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100028);
              String str;
              if (f.this.RJS != null)
              {
                str = f.this.RJS.QHV;
                if ((paramAnonymousString == null) || (!paramAnonymousString.equals(str))) {
                  break label120;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
                a.a(f.this.QSc, str, "scene_timeline");
              }
              for (;;)
              {
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
                f.this.QSc.setSensorEnabled(true);
                f.this.QSc.setTouchEnabled(true);
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
          if (f.this.RJR.getVisibility() == 0)
          {
            f.this.RJR.setVisibility(8);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
          }
          AppMethodBeat.o(100029);
          return;
          f.this.QSc.setSensorEnabled(true);
          f.this.QSc.setTouchEnabled(true);
        }
      }
      
      public final void hjD() {}
      
      public final void hjE() {}
      
      public final void hjF()
      {
        f localf = f.this;
        localf.QSg += 1;
      }
      
      public final void onDetachedFromWindow()
      {
        AppMethodBeat.i(100030);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + f.this.QSc.hashCode());
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("panCount", f.this.QSg);
          ((JSONObject)localObject).put("type", 1);
          String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          String str1 = f.this.PNI.getAid();
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          h.OAn.b(17539, new Object[] { f.this.PNI.getTimeLine().Id, localObject, f.this.PNI.getAdInfo().uxInfo, Integer.valueOf(2), str2 });
          Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(str2)));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + localException.toString());
          }
        }
        f.this.QSg = 0;
        f.this.RJT = null;
        AppMethodBeat.o(100030);
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    AppMethodBeat.o(100031);
  }
  
  /* Error */
  public final void refreshView()
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 90
    //   7: new 92	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 94
    //   13: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   20: invokevirtual 105	java/lang/Object:hashCode	()I
    //   23: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   37: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
    //   40: invokestatic 129	com/tencent/mm/plugin/sns/storage/l:aZK	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   43: putfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   51: aload_0
    //   52: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   55: ifnull +27 -> 82
    //   58: aload_0
    //   59: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   62: invokevirtual 135	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   73: invokevirtual 135	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   76: getfield 140	com/tencent/mm/plugin/sns/storage/ADXml:adSphereCardInfo	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   79: putfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   82: aload_0
    //   83: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   86: ldc 144
    //   88: invokevirtual 150	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 152	android/view/WindowManager
    //   94: astore_3
    //   95: aload_3
    //   96: invokeinterface 156 1 0
    //   101: invokevirtual 161	android/view/Display:getWidth	()I
    //   104: aload_3
    //   105: invokeinterface 156 1 0
    //   110: invokevirtual 164	android/view/Display:getHeight	()I
    //   113: invokestatic 170	java/lang/Math:min	(II)I
    //   116: istore_1
    //   117: aload_0
    //   118: getfield 172	com/tencent/mm/plugin/sns/ui/c/a/f:RJK	Landroid/view/View;
    //   121: bipush 8
    //   123: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   126: aload_0
    //   127: getfield 179	com/tencent/mm/plugin/sns/ui/c/a/f:RJM	Landroid/widget/TextView;
    //   130: bipush 8
    //   132: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   135: aload_0
    //   136: getfield 184	com/tencent/mm/plugin/sns/ui/c/a/f:RJN	Landroid/widget/TextView;
    //   139: bipush 8
    //   141: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   144: aload_0
    //   145: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   148: bipush 8
    //   150: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   153: aload_0
    //   154: getfield 188	com/tencent/mm/plugin/sns/ui/c/a/f:RJO	Landroid/widget/TextView;
    //   157: bipush 8
    //   159: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   162: aload_0
    //   163: getfield 190	com/tencent/mm/plugin/sns/ui/c/a/f:RJP	Landroid/widget/TextView;
    //   166: bipush 8
    //   168: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   171: aload_0
    //   172: getfield 192	com/tencent/mm/plugin/sns/ui/c/a/f:RJQ	Landroid/view/View;
    //   175: bipush 8
    //   177: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   180: aload_0
    //   181: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   184: ifnull +1098 -> 1282
    //   187: iload_1
    //   188: aload_0
    //   189: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   192: getstatic 197	com/tencent/mm/plugin/sns/b$d:sns_avatar_size	I
    //   195: invokestatic 203	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   198: isub
    //   199: aload_0
    //   200: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   203: getstatic 206	com/tencent/mm/plugin/sns/b$d:Edge_0_5_A	I
    //   206: invokestatic 203	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   209: isub
    //   210: aload_0
    //   211: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   214: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: getstatic 213	com/tencent/mm/plugin/sns/b$d:NormalPadding	I
    //   220: invokevirtual 219	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   223: isub
    //   224: aload_0
    //   225: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   228: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: getstatic 213	com/tencent/mm/plugin/sns/b$d:NormalPadding	I
    //   234: invokevirtual 219	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   237: isub
    //   238: istore_1
    //   239: aload_0
    //   240: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   243: getfield 224	com/tencent/mm/plugin/sns/storage/ADXml$i:QHE	I
    //   246: ifne +661 -> 907
    //   249: new 226	android/view/ViewGroup$LayoutParams
    //   252: dup
    //   253: bipush 254
    //   255: bipush 254
    //   257: invokespecial 229	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   260: astore_3
    //   261: aload_3
    //   262: iload_1
    //   263: putfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   266: aload_3
    //   267: aload_3
    //   268: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   271: i2f
    //   272: ldc 233
    //   274: fmul
    //   275: f2i
    //   276: putfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   279: aload_3
    //   280: ifnull +129 -> 409
    //   283: aload_0
    //   284: getfield 239	com/tencent/mm/plugin/sns/ui/c/a/f:contentView	Landroid/view/View;
    //   287: invokevirtual 243	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   290: astore 4
    //   292: aload 4
    //   294: aload_3
    //   295: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   298: putfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   301: aload 4
    //   303: aload_3
    //   304: getfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   307: putfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   310: aload_0
    //   311: getfield 239	com/tencent/mm/plugin/sns/ui/c/a/f:contentView	Landroid/view/View;
    //   314: aload 4
    //   316: invokevirtual 247	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   319: aload_0
    //   320: getfield 239	com/tencent/mm/plugin/sns/ui/c/a/f:contentView	Landroid/view/View;
    //   323: checkcast 249	com/tencent/mm/ui/widget/RoundedCornerFrameLayout
    //   326: aload_0
    //   327: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   330: bipush 8
    //   332: invokestatic 252	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   335: i2f
    //   336: invokevirtual 256	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   339: aload_0
    //   340: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   343: invokevirtual 259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   346: astore 4
    //   348: aload 4
    //   350: aload_3
    //   351: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   354: putfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   357: aload 4
    //   359: aload_3
    //   360: getfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   363: putfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   366: aload_0
    //   367: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   370: aload 4
    //   372: invokevirtual 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   375: aload_0
    //   376: getfield 262	com/tencent/mm/plugin/sns/ui/c/a/f:QSe	Landroid/widget/ImageView;
    //   379: invokevirtual 265	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   382: astore_3
    //   383: aload_3
    //   384: aload 4
    //   386: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   389: putfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   392: aload_3
    //   393: aload 4
    //   395: getfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   398: putfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   401: aload_0
    //   402: getfield 262	com/tencent/mm/plugin/sns/ui/c/a/f:QSe	Landroid/widget/ImageView;
    //   405: aload_3
    //   406: invokevirtual 266	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   409: aload_0
    //   410: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   413: getfield 269	com/tencent/mm/plugin/sns/storage/ADXml$i:QHG	I
    //   416: ifne +530 -> 946
    //   419: aload_0
    //   420: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   423: getfield 272	com/tencent/mm/plugin/sns/storage/ADXml$i:QHF	I
    //   426: i2f
    //   427: ldc_w 273
    //   430: fmul
    //   431: f2i
    //   432: iconst_0
    //   433: iconst_0
    //   434: iconst_0
    //   435: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   438: istore_1
    //   439: iconst_0
    //   440: iconst_0
    //   441: iconst_0
    //   442: iconst_0
    //   443: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   446: istore_2
    //   447: new 281	android/graphics/drawable/GradientDrawable
    //   450: dup
    //   451: getstatic 287	android/graphics/drawable/GradientDrawable$Orientation:TOP_BOTTOM	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   454: iconst_2
    //   455: newarray int
    //   457: dup
    //   458: iconst_0
    //   459: iload_1
    //   460: iastore
    //   461: dup
    //   462: iconst_1
    //   463: iload_2
    //   464: iastore
    //   465: invokespecial 290	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   468: astore_3
    //   469: aload_3
    //   470: iconst_0
    //   471: invokevirtual 293	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   474: aload_0
    //   475: getfield 172	com/tencent/mm/plugin/sns/ui/c/a/f:RJK	Landroid/view/View;
    //   478: aload_3
    //   479: invokevirtual 297	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   482: aload_0
    //   483: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   486: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   489: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   492: ifeq +16 -> 508
    //   495: aload_0
    //   496: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   499: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   502: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   505: ifne +11 -> 516
    //   508: aload_0
    //   509: getfield 172	com/tencent/mm/plugin/sns/ui/c/a/f:RJK	Landroid/view/View;
    //   512: iconst_0
    //   513: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   516: aload_0
    //   517: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   520: bipush 8
    //   522: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   525: aload_0
    //   526: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   529: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   532: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   535: ifne +45 -> 580
    //   538: aload_0
    //   539: getfield 179	com/tencent/mm/plugin/sns/ui/c/a/f:RJM	Landroid/widget/TextView;
    //   542: iconst_0
    //   543: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   546: aload_0
    //   547: getfield 179	com/tencent/mm/plugin/sns/ui/c/a/f:RJM	Landroid/widget/TextView;
    //   550: invokestatic 315	com/tencent/mm/smiley/u:iVt	()Lcom/tencent/mm/smiley/u;
    //   553: aload_0
    //   554: getfield 179	com/tencent/mm/plugin/sns/ui/c/a/f:RJM	Landroid/widget/TextView;
    //   557: invokevirtual 319	android/widget/TextView:getContext	()Landroid/content/Context;
    //   560: aload_0
    //   561: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   564: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   567: aload_0
    //   568: getfield 179	com/tencent/mm/plugin/sns/ui/c/a/f:RJM	Landroid/widget/TextView;
    //   571: invokevirtual 323	android/widget/TextView:getTextSize	()F
    //   574: invokevirtual 327	com/tencent/mm/smiley/u:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   577: invokevirtual 331	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   580: aload_0
    //   581: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   584: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   587: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   590: ifne +45 -> 635
    //   593: aload_0
    //   594: getfield 184	com/tencent/mm/plugin/sns/ui/c/a/f:RJN	Landroid/widget/TextView;
    //   597: iconst_0
    //   598: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   601: aload_0
    //   602: getfield 184	com/tencent/mm/plugin/sns/ui/c/a/f:RJN	Landroid/widget/TextView;
    //   605: invokestatic 315	com/tencent/mm/smiley/u:iVt	()Lcom/tencent/mm/smiley/u;
    //   608: aload_0
    //   609: getfield 184	com/tencent/mm/plugin/sns/ui/c/a/f:RJN	Landroid/widget/TextView;
    //   612: invokevirtual 319	android/widget/TextView:getContext	()Landroid/content/Context;
    //   615: aload_0
    //   616: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   619: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   622: aload_0
    //   623: getfield 184	com/tencent/mm/plugin/sns/ui/c/a/f:RJN	Landroid/widget/TextView;
    //   626: invokevirtual 323	android/widget/TextView:getTextSize	()F
    //   629: invokevirtual 327	com/tencent/mm/smiley/u:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   632: invokevirtual 331	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   635: aload_0
    //   636: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   639: ifnull +95 -> 734
    //   642: aload_0
    //   643: getfield 78	com/tencent/mm/plugin/sns/ui/c/a/f:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   646: invokevirtual 335	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   649: invokevirtual 341	com/tencent/mm/plugin/sns/storage/ADInfo:isWeapp	()Z
    //   652: ifeq +82 -> 734
    //   655: aload_0
    //   656: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   659: getfield 272	com/tencent/mm/plugin/sns/storage/ADXml$i:QHF	I
    //   662: i2f
    //   663: ldc_w 273
    //   666: fmul
    //   667: f2i
    //   668: iconst_0
    //   669: iconst_0
    //   670: iconst_0
    //   671: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   674: istore_1
    //   675: iconst_0
    //   676: iconst_0
    //   677: iconst_0
    //   678: iconst_0
    //   679: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   682: istore_2
    //   683: new 281	android/graphics/drawable/GradientDrawable
    //   686: dup
    //   687: getstatic 344	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   690: iconst_2
    //   691: newarray int
    //   693: dup
    //   694: iconst_0
    //   695: iload_1
    //   696: iastore
    //   697: dup
    //   698: iconst_1
    //   699: iload_2
    //   700: iastore
    //   701: invokespecial 290	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   704: astore_3
    //   705: aload_3
    //   706: iconst_0
    //   707: invokevirtual 293	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   710: aload_0
    //   711: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   714: iconst_0
    //   715: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   718: aload_0
    //   719: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   722: aload_3
    //   723: invokevirtual 297	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   726: aload_0
    //   727: getfield 192	com/tencent/mm/plugin/sns/ui/c/a/f:RJQ	Landroid/view/View;
    //   730: iconst_0
    //   731: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   734: aload_0
    //   735: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   738: iconst_0
    //   739: invokevirtual 345	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setVisibility	(I)V
    //   742: aload_0
    //   743: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   746: aload_0
    //   747: invokevirtual 349	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setTag	(Ljava/lang/Object;)V
    //   750: aload_0
    //   751: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   754: aload_0
    //   755: getfield 82	com/tencent/mm/plugin/sns/ui/c/a/f:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   758: getfield 355	com/tencent/mm/plugin/sns/ui/listener/c:RQG	Landroid/view/View$OnClickListener;
    //   761: invokevirtual 359	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   764: aload_0
    //   765: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/f:RJT	Ljava/lang/String;
    //   768: ifnull +20 -> 788
    //   771: aload_0
    //   772: getfield 60	com/tencent/mm/plugin/sns/ui/c/a/f:RJT	Ljava/lang/String;
    //   775: aload_0
    //   776: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   779: getfield 362	com/tencent/mm/plugin/sns/storage/ADXml$i:QHV	Ljava/lang/String;
    //   782: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   785: ifne +483 -> 1268
    //   788: ldc 90
    //   790: ldc_w 370
    //   793: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload_0
    //   797: getfield 262	com/tencent/mm/plugin/sns/ui/c/a/f:QSe	Landroid/widget/ImageView;
    //   800: iconst_0
    //   801: invokevirtual 371	android/widget/ImageView:setVisibility	(I)V
    //   804: aload_0
    //   805: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   808: getfield 362	com/tencent/mm/plugin/sns/storage/ADXml$i:QHV	Ljava/lang/String;
    //   811: astore_3
    //   812: aload_0
    //   813: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   816: getfield 374	com/tencent/mm/plugin/sns/storage/ADXml$i:QHW	Ljava/lang/String;
    //   819: astore 4
    //   821: new 376	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c
    //   824: dup
    //   825: aload_3
    //   826: aload 4
    //   828: ldc_w 378
    //   831: new 6	com/tencent/mm/plugin/sns/ui/c/a/f$1
    //   834: dup
    //   835: aload_0
    //   836: aload_3
    //   837: aload 4
    //   839: invokespecial 381	com/tencent/mm/plugin/sns/ui/c/a/f$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/c/a/f;Ljava/lang/String;Ljava/lang/String;)V
    //   842: invokespecial 384	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$d;)V
    //   845: iconst_0
    //   846: anewarray 386	java/lang/Void
    //   849: invokevirtual 390	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$c:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   852: pop
    //   853: aload_0
    //   854: getfield 392	com/tencent/mm/plugin/sns/ui/c/a/f:QSf	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
    //   857: aload_0
    //   858: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   861: getfield 362	com/tencent/mm/plugin/sns/storage/ADXml$i:QHV	Ljava/lang/String;
    //   864: aload_0
    //   865: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   868: invokevirtual 259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   871: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   874: aload_0
    //   875: getfield 99	com/tencent/mm/plugin/sns/ui/c/a/f:QSc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
    //   878: invokevirtual 259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   881: getfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   884: ldc_w 378
    //   887: invokevirtual 398	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:n	(Ljava/lang/String;IILjava/lang/String;)V
    //   890: aload_0
    //   891: aload_0
    //   892: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   895: getfield 362	com/tencent/mm/plugin/sns/storage/ADXml$i:QHV	Ljava/lang/String;
    //   898: putfield 60	com/tencent/mm/plugin/sns/ui/c/a/f:RJT	Ljava/lang/String;
    //   901: ldc 88
    //   903: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   906: return
    //   907: aload_0
    //   908: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   911: getfield 224	com/tencent/mm/plugin/sns/storage/ADXml$i:QHE	I
    //   914: iconst_1
    //   915: if_icmpne +381 -> 1296
    //   918: new 226	android/view/ViewGroup$LayoutParams
    //   921: dup
    //   922: bipush 254
    //   924: bipush 254
    //   926: invokespecial 229	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   929: astore_3
    //   930: aload_3
    //   931: iload_1
    //   932: putfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   935: aload_3
    //   936: aload_3
    //   937: getfield 232	android/view/ViewGroup$LayoutParams:width	I
    //   940: putfield 236	android/view/ViewGroup$LayoutParams:height	I
    //   943: goto -664 -> 279
    //   946: aload_0
    //   947: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   950: getfield 269	com/tencent/mm/plugin/sns/storage/ADXml$i:QHG	I
    //   953: iconst_1
    //   954: if_icmpne -319 -> 635
    //   957: aload_0
    //   958: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   961: getfield 272	com/tencent/mm/plugin/sns/storage/ADXml$i:QHF	I
    //   964: i2f
    //   965: ldc_w 273
    //   968: fmul
    //   969: f2i
    //   970: iconst_0
    //   971: iconst_0
    //   972: iconst_0
    //   973: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   976: istore_1
    //   977: iconst_0
    //   978: iconst_0
    //   979: iconst_0
    //   980: iconst_0
    //   981: invokestatic 279	android/graphics/Color:argb	(IIII)I
    //   984: istore_2
    //   985: new 281	android/graphics/drawable/GradientDrawable
    //   988: dup
    //   989: getstatic 344	android/graphics/drawable/GradientDrawable$Orientation:BOTTOM_TOP	Landroid/graphics/drawable/GradientDrawable$Orientation;
    //   992: iconst_2
    //   993: newarray int
    //   995: dup
    //   996: iconst_0
    //   997: iload_1
    //   998: iastore
    //   999: dup
    //   1000: iconst_1
    //   1001: iload_2
    //   1002: iastore
    //   1003: invokespecial 290	android/graphics/drawable/GradientDrawable:<init>	(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
    //   1006: astore_3
    //   1007: aload_3
    //   1008: iconst_0
    //   1009: invokevirtual 293	android/graphics/drawable/GradientDrawable:setGradientType	(I)V
    //   1012: aload_0
    //   1013: getfield 172	com/tencent/mm/plugin/sns/ui/c/a/f:RJK	Landroid/view/View;
    //   1016: bipush 8
    //   1018: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   1021: aload_0
    //   1022: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   1025: aload_3
    //   1026: invokevirtual 297	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1029: aload_0
    //   1030: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1033: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1036: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1039: ifeq +16 -> 1055
    //   1042: aload_0
    //   1043: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1046: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1049: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1052: ifne +42 -> 1094
    //   1055: aload_0
    //   1056: getfield 186	com/tencent/mm/plugin/sns/ui/c/a/f:RJL	Landroid/view/View;
    //   1059: iconst_0
    //   1060: invokevirtual 177	android/view/View:setVisibility	(I)V
    //   1063: aload_0
    //   1064: getfield 192	com/tencent/mm/plugin/sns/ui/c/a/f:RJQ	Landroid/view/View;
    //   1067: invokevirtual 243	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1070: checkcast 400	android/widget/RelativeLayout$LayoutParams
    //   1073: astore_3
    //   1074: aload_3
    //   1075: aload_0
    //   1076: getfield 142	com/tencent/mm/plugin/sns/ui/c/a/f:mContext	Landroid/content/Context;
    //   1079: iconst_4
    //   1080: invokestatic 252	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1083: putfield 403	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1086: aload_0
    //   1087: getfield 192	com/tencent/mm/plugin/sns/ui/c/a/f:RJQ	Landroid/view/View;
    //   1090: aload_3
    //   1091: invokevirtual 247	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1094: aload_0
    //   1095: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1098: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1101: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1104: ifne +45 -> 1149
    //   1107: aload_0
    //   1108: getfield 188	com/tencent/mm/plugin/sns/ui/c/a/f:RJO	Landroid/widget/TextView;
    //   1111: iconst_0
    //   1112: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   1115: aload_0
    //   1116: getfield 188	com/tencent/mm/plugin/sns/ui/c/a/f:RJO	Landroid/widget/TextView;
    //   1119: invokestatic 315	com/tencent/mm/smiley/u:iVt	()Lcom/tencent/mm/smiley/u;
    //   1122: aload_0
    //   1123: getfield 188	com/tencent/mm/plugin/sns/ui/c/a/f:RJO	Landroid/widget/TextView;
    //   1126: invokevirtual 319	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1129: aload_0
    //   1130: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1133: getfield 300	com/tencent/mm/plugin/sns/storage/ADXml$i:title	Ljava/lang/String;
    //   1136: aload_0
    //   1137: getfield 188	com/tencent/mm/plugin/sns/ui/c/a/f:RJO	Landroid/widget/TextView;
    //   1140: invokevirtual 323	android/widget/TextView:getTextSize	()F
    //   1143: invokevirtual 327	com/tencent/mm/smiley/u:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1146: invokevirtual 331	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1149: aload_0
    //   1150: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1153: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1156: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1159: ifne -524 -> 635
    //   1162: aload_0
    //   1163: getfield 190	com/tencent/mm/plugin/sns/ui/c/a/f:RJP	Landroid/widget/TextView;
    //   1166: iconst_0
    //   1167: invokevirtual 182	android/widget/TextView:setVisibility	(I)V
    //   1170: aload_0
    //   1171: getfield 190	com/tencent/mm/plugin/sns/ui/c/a/f:RJP	Landroid/widget/TextView;
    //   1174: invokestatic 315	com/tencent/mm/smiley/u:iVt	()Lcom/tencent/mm/smiley/u;
    //   1177: aload_0
    //   1178: getfield 190	com/tencent/mm/plugin/sns/ui/c/a/f:RJP	Landroid/widget/TextView;
    //   1181: invokevirtual 319	android/widget/TextView:getContext	()Landroid/content/Context;
    //   1184: aload_0
    //   1185: getfield 131	com/tencent/mm/plugin/sns/ui/c/a/f:RJS	Lcom/tencent/mm/plugin/sns/storage/ADXml$i;
    //   1188: getfield 309	com/tencent/mm/plugin/sns/storage/ADXml$i:description	Ljava/lang/String;
    //   1191: aload_0
    //   1192: getfield 190	com/tencent/mm/plugin/sns/ui/c/a/f:RJP	Landroid/widget/TextView;
    //   1195: invokevirtual 323	android/widget/TextView:getTextSize	()F
    //   1198: invokevirtual 327	com/tencent/mm/smiley/u:a	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   1201: invokevirtual 331	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1204: goto -569 -> 635
    //   1207: astore_3
    //   1208: ldc 90
    //   1210: new 92	java/lang/StringBuilder
    //   1213: dup
    //   1214: ldc_w 405
    //   1217: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1220: aload_3
    //   1221: invokevirtual 408	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1224: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1230: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: ldc 88
    //   1235: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1238: return
    //   1239: astore_3
    //   1240: ldc 90
    //   1242: new 92	java/lang/StringBuilder
    //   1245: dup
    //   1246: ldc_w 416
    //   1249: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1252: aload_3
    //   1253: invokevirtual 408	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1256: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: goto -412 -> 853
    //   1268: ldc 90
    //   1270: ldc_w 418
    //   1273: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1276: ldc 88
    //   1278: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1281: return
    //   1282: ldc 90
    //   1284: ldc_w 420
    //   1287: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1290: ldc 88
    //   1292: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1295: return
    //   1296: aconst_null
    //   1297: astore_3
    //   1298: goto -1019 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1301	0	this	f
    //   116	882	1	i	int
    //   446	556	2	j	int
    //   94	997	3	localObject1	Object
    //   1207	14	3	localObject2	Object
    //   1239	14	3	localObject3	Object
    //   1297	1	3	localObject4	Object
    //   290	548	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   5	82	1207	finally
    //   82	279	1207	finally
    //   283	409	1207	finally
    //   409	508	1207	finally
    //   508	516	1207	finally
    //   516	580	1207	finally
    //   580	635	1207	finally
    //   635	734	1207	finally
    //   734	788	1207	finally
    //   788	796	1207	finally
    //   853	906	1207	finally
    //   907	943	1207	finally
    //   946	1055	1207	finally
    //   1055	1094	1207	finally
    //   1094	1149	1207	finally
    //   1149	1204	1207	finally
    //   1240	1265	1207	finally
    //   1268	1281	1207	finally
    //   1282	1290	1207	finally
    //   796	853	1239	finally
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100032);
    this.contentView = paramView1;
    this.RoA = paramView2;
    this.mContext = paramView1.getContext();
    this.Cxb = paramView1.findViewById(b.f.sphere_card_container);
    this.RJK = paramView1.findViewById(b.f.top_layer);
    this.RJL = paramView1.findViewById(b.f.bottom_layer);
    this.RJM = ((TextView)paramView1.findViewById(b.f.top_layer_title));
    this.RJN = ((TextView)paramView1.findViewById(b.f.top_layer_desc));
    this.RJO = ((TextView)paramView1.findViewById(b.f.bottom_layer_title));
    this.RJP = ((TextView)paramView1.findViewById(b.f.bottom_layer_desc));
    this.RJQ = paramView1.findViewById(b.f.bottom_mini_program);
    this.QSe = ((ImageView)paramView1.findViewById(b.f.mask_img));
    this.QSc = ((SphereImageView)paramView1.findViewById(b.f.sphere_card_img));
    this.RJR = ((MMPinProgressBtn)paramView1.findViewById(b.f.progress));
    this.RJR.setMax(50);
    float f1 = m.akn(b.d.sns_ad_fullcard_title_font_size);
    float f2 = m.akn(b.d.sns_ad_fullcard_desc_font_size);
    this.RJM.setTextSize(0, f1);
    this.RJN.setTextSize(0, f2);
    this.RJO.setTextSize(0, f1);
    this.RJP.setTextSize(0, f2);
    this.QSc.aV(1.8F, -2.0F);
    this.QSc.setTouchSensitivity(0.45F);
    this.QSc.setEventListener(this.QWi);
    this.QSc.setTouchEnabled(true);
    this.QSc.setSensorEnabled(false);
    this.QSc.hkt();
    this.QSf = new a();
    this.QSf.a(this.RJU);
    Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "initView, hash=" + this.QSc.hashCode());
    AppMethodBeat.o(100032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.f
 * JD-Core Version:    0.7.0.1
 */