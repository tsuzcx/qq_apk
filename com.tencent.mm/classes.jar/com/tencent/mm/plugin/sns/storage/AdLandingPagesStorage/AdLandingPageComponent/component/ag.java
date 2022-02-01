package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
  extends n
{
  boolean QKi;
  boolean QOi = true;
  j QRl;
  volatile String Qnb = "";
  ImageView hIz;
  volatile String imageUrl = "";
  ProgressBar progressBar;
  
  public ag(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
  }
  
  private static boolean gAH()
  {
    AppMethodBeat.i(306935);
    try
    {
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIe, 0);
      Log.i("AdLandingPagePureImageComponet", "isNeedVerify=".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(306935);
    }
    return false;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96693);
    this.hIz = ((ImageView)this.contentView.findViewById(b.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(b.f.progressbar));
    if (((u)this.QOV).QKk)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((u)this.QOV).QKl);
      this.QRl = new j(this.context, hjn(), 1, localBundle);
      this.hIz.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307075);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          Log.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ag.this.Qnb);
          boolean bool = ag.this.QRl.a(ag.this.Qnb, ag.this.imageUrl, null);
          a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(307075);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
  }
  
  final void aZx(final String paramString)
  {
    AppMethodBeat.i(306961);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307066);
        try
        {
          final Bitmap localBitmap = BitmapUtil.decodeFile(paramString);
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307037);
              ag localag = ag.this;
              Bitmap localBitmap = localBitmap;
              if (localBitmap == null)
              {
                Log.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
                AppMethodBeat.o(307037);
                return;
              }
              if (localag.hIz == null)
              {
                Log.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
                AppMethodBeat.o(307037);
                return;
              }
              if (localBitmap.getWidth() == 0)
              {
                Log.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
                AppMethodBeat.o(307037);
                return;
              }
              localag.hIz.setImageBitmap(localBitmap);
              localag.progressBar.setVisibility(8);
              AppMethodBeat.o(307037);
            }
          });
          AppMethodBeat.o(307066);
          return;
        }
        finally
        {
          Log.e("AdLandingPagePureImageComponet", "setImageAsync, exp=" + localObject.toString());
          AppMethodBeat.o(307066);
        }
      }
    });
    AppMethodBeat.o(306961);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.QOi)
      {
        String str = MD5Util.getMD5String(this.imageUrl);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96698);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_pure_image;
  }
  
  /* Error */
  protected final void had()
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 99	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:contentView	Landroid/view/View;
    //   9: ifnull +17 -> 26
    //   12: aload_0
    //   13: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 122	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:progressBar	Landroid/widget/ProgressBar;
    //   23: ifnonnull +9 -> 32
    //   26: ldc 228
    //   28: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   36: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   39: ifnonnull +9 -> 48
    //   42: ldc 228
    //   44: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   52: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   55: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:nDl	I
    //   58: istore_3
    //   59: iload_3
    //   60: ifne +268 -> 328
    //   63: aload_0
    //   64: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   67: getstatic 237	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   70: invokevirtual 241	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   73: ldc 72
    //   75: new 243	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 245
    //   81: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   88: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   91: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKG	Ljava/lang/String;
    //   94: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 256
    //   100: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: iload_3
    //   104: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   118: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   121: getfield 266	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKj	Ljava/lang/String;
    //   124: putfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   131: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   134: getfield 269	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:bgColor	Ljava/lang/String;
    //   137: astore 7
    //   139: aload_0
    //   140: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   143: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   146: getfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:height	F
    //   149: fstore_2
    //   150: aload_0
    //   151: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   154: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   157: getfield 276	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:width	F
    //   160: fstore_1
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   166: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   169: getfield 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKi	Z
    //   172: putfield 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QKi	Z
    //   175: fload_2
    //   176: fconst_0
    //   177: fcmpl
    //   178: ifeq +174 -> 352
    //   181: fload_1
    //   182: fconst_0
    //   183: fcmpl
    //   184: ifeq +168 -> 352
    //   187: aload_0
    //   188: getfield 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QKi	Z
    //   191: ifne +161 -> 352
    //   194: aload_0
    //   195: getfield 282	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:sJv	I
    //   198: aload_0
    //   199: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   202: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   205: getfield 285	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:paddingLeft	F
    //   208: f2i
    //   209: isub
    //   210: aload_0
    //   211: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   214: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   217: getfield 288	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:paddingRight	F
    //   220: f2i
    //   221: isub
    //   222: istore_3
    //   223: fload_1
    //   224: iload_3
    //   225: i2f
    //   226: fcmpg
    //   227: ifge +119 -> 346
    //   230: fload_1
    //   231: aload_0
    //   232: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   235: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   238: getfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:height	F
    //   241: fmul
    //   242: aload_0
    //   243: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   246: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   249: getfield 276	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:width	F
    //   252: fdiv
    //   253: fstore_2
    //   254: aload_0
    //   255: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   258: new 290	android/widget/RelativeLayout$LayoutParams
    //   261: dup
    //   262: fload_1
    //   263: f2i
    //   264: fload_2
    //   265: f2i
    //   266: invokespecial 293	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   269: invokevirtual 297	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   272: aload 7
    //   274: ifnull +23 -> 297
    //   277: aload 7
    //   279: invokevirtual 300	java/lang/String:length	()I
    //   282: ifle +15 -> 297
    //   285: aload_0
    //   286: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   289: aload 7
    //   291: invokestatic 306	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   294: invokevirtual 309	android/widget/ImageView:setBackgroundColor	(I)V
    //   297: aload_0
    //   298: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   301: ifnull +13 -> 314
    //   304: aload_0
    //   305: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   308: invokevirtual 300	java/lang/String:length	()I
    //   311: ifgt +110 -> 421
    //   314: ldc 72
    //   316: ldc_w 311
    //   319: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: ldc 228
    //   324: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: return
    //   328: iload_3
    //   329: iconst_1
    //   330: if_icmpne -257 -> 73
    //   333: aload_0
    //   334: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   337: getstatic 314	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   340: invokevirtual 241	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   343: goto -270 -> 73
    //   346: iload_3
    //   347: i2f
    //   348: fstore_1
    //   349: goto -119 -> 230
    //   352: aload_0
    //   353: getfield 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QKi	Z
    //   356: ifeq +40 -> 396
    //   359: fload_2
    //   360: fconst_0
    //   361: fcmpl
    //   362: ifeq +34 -> 396
    //   365: fload_1
    //   366: fconst_0
    //   367: fcmpl
    //   368: ifeq +28 -> 396
    //   371: aload_0
    //   372: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   375: new 290	android/widget/RelativeLayout$LayoutParams
    //   378: dup
    //   379: aload_0
    //   380: getfield 282	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:sJv	I
    //   383: aload_0
    //   384: getfield 317	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:pvg	I
    //   387: invokespecial 293	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   390: invokevirtual 297	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   393: goto -121 -> 272
    //   396: aload_0
    //   397: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   400: new 290	android/widget/RelativeLayout$LayoutParams
    //   403: dup
    //   404: aload_0
    //   405: getfield 282	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:sJv	I
    //   408: aload_0
    //   409: getfield 317	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:pvg	I
    //   412: invokespecial 293	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   415: invokevirtual 297	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   418: goto -146 -> 272
    //   421: aload_0
    //   422: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   425: astore 7
    //   427: aload_0
    //   428: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   431: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   434: astore 8
    //   436: ldc_w 319
    //   439: aload 7
    //   441: invokestatic 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   444: astore 7
    //   446: aload 7
    //   448: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   451: ifne +11 -> 462
    //   454: aload 7
    //   456: invokestatic 337	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   459: ifne +273 -> 732
    //   462: ldc 72
    //   464: ldc_w 339
    //   467: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iconst_0
    //   471: aload 8
    //   473: getfield 342	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKU	I
    //   476: aload_0
    //   477: invokevirtual 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   480: getfield 347	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:source	I
    //   483: invokestatic 353	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$a:t	(ZII)V
    //   486: ldc_w 319
    //   489: aload_0
    //   490: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   493: invokestatic 356	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 7
    //   498: aload 7
    //   500: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +581 -> 1084
    //   506: aload_0
    //   507: aload 7
    //   509: invokevirtual 358	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:aZx	(Ljava/lang/String;)V
    //   512: aload_0
    //   513: aload 7
    //   515: putfield 43	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:Qnb	Ljava/lang/String;
    //   518: aload_0
    //   519: iconst_1
    //   520: putfield 37	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOi	Z
    //   523: ldc 72
    //   525: new 243	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 360
    //   532: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload_0
    //   536: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   539: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload_0
    //   549: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   552: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   555: getfield 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKk	Z
    //   558: ifeq +73 -> 631
    //   561: aload_0
    //   562: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   565: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   568: getfield 363	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKm	Z
    //   571: ifeq +60 -> 631
    //   574: ldc 72
    //   576: ldc_w 365
    //   579: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: invokestatic 371	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   585: ldc 39
    //   587: aload_0
    //   588: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   591: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   594: getfield 140	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKl	Ljava/lang/String;
    //   597: ldc 39
    //   599: aload_0
    //   600: invokevirtual 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   603: getfield 374	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:uxInfo	Ljava/lang/String;
    //   606: aload_0
    //   607: getfield 375	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   610: getfield 378	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   613: aload_0
    //   614: invokevirtual 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   617: invokevirtual 381	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:getSnsId	()Ljava/lang/String;
    //   620: new 17	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$b
    //   623: dup
    //   624: aload_0
    //   625: invokespecial 382	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$b:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag;)V
    //   628: invokevirtual 386	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:doAdUpdateQrUrlScene	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy$e;)V
    //   631: aload_0
    //   632: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   635: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   638: getfield 389	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:dwJ	F
    //   641: fstore_1
    //   642: fload_1
    //   643: fconst_0
    //   644: fcmpl
    //   645: ifle +81 -> 726
    //   648: ldc 72
    //   650: new 243	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 391
    //   657: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: fload_1
    //   661: invokevirtual 394	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   664: ldc_w 396
    //   667: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_0
    //   671: getfield 375	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   674: getfield 378	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:QKG	Ljava/lang/String;
    //   677: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: ldc_w 398
    //   683: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   690: invokevirtual 401	java/lang/Object:hashCode	()I
    //   693: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: aload_0
    //   703: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   706: iconst_1
    //   707: invokevirtual 405	android/widget/ImageView:setClipToOutline	(Z)V
    //   710: aload_0
    //   711: getfield 115	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hIz	Landroid/widget/ImageView;
    //   714: new 407	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$2
    //   717: dup
    //   718: aload_0
    //   719: fload_1
    //   720: invokespecial 410	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag;F)V
    //   723: invokevirtual 414	android/widget/ImageView:setOutlineProvider	(Landroid/view/ViewOutlineProvider;)V
    //   726: ldc 228
    //   728: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: return
    //   732: iconst_1
    //   733: aload 8
    //   735: getfield 342	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKU	I
    //   738: aload_0
    //   739: invokevirtual 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   742: getfield 347	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:source	I
    //   745: invokestatic 353	com/tencent/mm/plugin/sns/ad/landingpage/helper/a$a:t	(ZII)V
    //   748: aload 8
    //   750: getfield 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKk	Z
    //   753: ifeq +22 -> 775
    //   756: aload 8
    //   758: getfield 363	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKm	Z
    //   761: ifeq +14 -> 775
    //   764: ldc 72
    //   766: ldc_w 416
    //   769: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: goto -286 -> 486
    //   775: aload 8
    //   777: getfield 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKi	Z
    //   780: ifeq +14 -> 794
    //   783: ldc 72
    //   785: ldc_w 418
    //   788: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: goto -305 -> 486
    //   794: aload 8
    //   796: getfield 421	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:md5	Ljava/lang/String;
    //   799: astore 8
    //   801: aload_0
    //   802: invokevirtual 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   805: getfield 424	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:aid	Ljava/lang/String;
    //   808: invokestatic 429	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   811: astore 9
    //   813: aload_0
    //   814: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   817: checkcast 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u
    //   820: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/u:QKG	Ljava/lang/String;
    //   823: invokestatic 429	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   826: astore 10
    //   828: aload 8
    //   830: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   833: ifeq +62 -> 895
    //   836: getstatic 435	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   839: sipush 1594
    //   842: iconst_3
    //   843: invokevirtual 438	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   846: getstatic 443	com/tencent/mm/plugin/sns/data/l:Qnw	Ljava/lang/String;
    //   849: aload 9
    //   851: iconst_0
    //   852: iconst_0
    //   853: aload 10
    //   855: invokestatic 446	com/tencent/mm/plugin/sns/data/l:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   858: ldc 72
    //   860: new 243	java/lang/StringBuilder
    //   863: dup
    //   864: ldc_w 448
    //   867: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   870: aload 9
    //   872: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: ldc_w 450
    //   878: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload 10
    //   883: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: goto -406 -> 486
    //   895: invokestatic 452	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:gAH	()Z
    //   898: ifeq -412 -> 486
    //   901: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   904: lstore 4
    //   906: aload 7
    //   908: invokestatic 461	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore 11
    //   913: ldc 72
    //   915: new 243	java/lang/StringBuilder
    //   918: dup
    //   919: ldc_w 463
    //   922: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   925: aload 8
    //   927: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: ldc_w 465
    //   933: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 11
    //   938: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: ldc_w 467
    //   944: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   950: lload 4
    //   952: lsub
    //   953: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   956: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 473	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   962: aload 8
    //   964: aload 11
    //   966: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   969: ifne +102 -> 1071
    //   972: aload 7
    //   974: invokestatic 480	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   977: istore 6
    //   979: ldc 72
    //   981: new 243	java/lang/StringBuilder
    //   984: dup
    //   985: ldc_w 463
    //   988: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   991: aload 8
    //   993: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 465
    //   999: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 11
    //   1004: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: ldc_w 482
    //   1010: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: iload 6
    //   1015: invokevirtual 485	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1018: ldc_w 487
    //   1021: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 9
    //   1026: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc_w 450
    //   1032: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: aload 10
    //   1037: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1046: getstatic 435	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1049: sipush 1594
    //   1052: iconst_2
    //   1053: invokevirtual 438	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1056: getstatic 443	com/tencent/mm/plugin/sns/data/l:Qnw	Ljava/lang/String;
    //   1059: aload 9
    //   1061: iconst_0
    //   1062: iconst_1
    //   1063: aload 10
    //   1065: invokestatic 446	com/tencent/mm/plugin/sns/data/l:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   1068: goto -582 -> 486
    //   1071: getstatic 435	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1074: sipush 1594
    //   1077: iconst_1
    //   1078: invokevirtual 438	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1081: goto -595 -> 486
    //   1084: aload_0
    //   1085: iconst_0
    //   1086: putfield 37	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:QOi	Z
    //   1089: aload_0
    //   1090: invokevirtual 493	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:startLoading	()V
    //   1093: ldc_w 319
    //   1096: aload_0
    //   1097: getfield 41	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag:imageUrl	Ljava/lang/String;
    //   1100: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$1
    //   1103: dup
    //   1104: aload_0
    //   1105: invokespecial 494	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/ag;)V
    //   1108: invokestatic 497	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g$a;)V
    //   1111: goto -563 -> 548
    //   1114: astore 7
    //   1116: ldc 72
    //   1118: aload 7
    //   1120: invokevirtual 500	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1123: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: goto -495 -> 631
    //   1129: astore 9
    //   1131: goto -383 -> 748
    //   1134: astore 7
    //   1136: goto -839 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1139	0	this	ag
    //   160	560	1	f1	float
    //   149	211	2	f2	float
    //   58	289	3	i	int
    //   904	47	4	l	long
    //   977	37	6	bool	boolean
    //   137	836	7	str1	String
    //   1114	5	7	localObject1	Object
    //   1134	1	7	localException	Exception
    //   434	558	8	localObject2	Object
    //   811	249	9	str2	String
    //   1129	1	9	localObject3	Object
    //   826	238	10	str3	String
    //   911	92	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   574	631	1114	finally
    //   446	462	1129	finally
    //   462	486	1129	finally
    //   732	748	1129	finally
    //   285	297	1134	java/lang/Exception
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((u)this.QOV).paddingLeft, (int)((u)this.QOV).paddingTop, (int)((u)this.QOV).paddingRight, (int)((u)this.QOV).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96694);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96696);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96696);
  }
  
  public static final class a
    implements g.a
  {
    WeakReference<ag> QRp;
    
    a(ag paramag)
    {
      AppMethodBeat.i(306965);
      this.QRp = new WeakReference(paramag);
      AppMethodBeat.o(306965);
    }
    
    public final void aWn(String paramString)
    {
      AppMethodBeat.i(306977);
      ag localag = (ag)this.QRp.get();
      if (localag != null)
      {
        Log.i("AdLandingPagePureImageComponet", "download qr image completed, the path " + paramString + "; cId " + localag.QOV.QKG);
        localag.aZx(paramString);
        localag.Qnb = paramString;
        AppMethodBeat.o(306977);
        return;
      }
      Log.w("AdLandingPagePureImageComponet", "qrCodePureImageComp is null in weak ref");
      AppMethodBeat.o(306977);
    }
    
    public final void gZM() {}
    
    public final void gZN()
    {
      AppMethodBeat.i(306972);
      Log.e("AdLandingPagePureImageComponet", "there is something error happening when downloading qr image.");
      AppMethodBeat.o(306972);
    }
  }
  
  public static final class b
    implements AdLandingPagesProxy.e
  {
    private WeakReference<ag> QRp;
    
    b(ag paramag)
    {
      AppMethodBeat.i(306964);
      this.QRp = new WeakReference(paramag);
      AppMethodBeat.o(306964);
    }
    
    public final void h(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(306974);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      try
      {
        if ((paramObject instanceof byte[]))
        {
          cqm localcqm = new cqm();
          localcqm.parseFrom((byte[])paramObject);
          if (this.QRp != null)
          {
            paramObject = (ag)this.QRp.get();
            if ((paramObject != null) && (paramObject.QOV.QKG.equals(localcqm.aawY)))
            {
              Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl completed");
              paramObject.imageUrl = localcqm.url;
              k.b("adId", paramObject.imageUrl, new ag.a(paramObject));
            }
          }
          AppMethodBeat.o(306974);
          return;
        }
        Log.e("AdLandingPagePureImageComponet", "request new qr image imgUrl failed");
        AppMethodBeat.o(306974);
        return;
      }
      finally
      {
        Log.e("AdLandingPagePureImageComponet", paramObject.toString());
        AppMethodBeat.o(306974);
      }
    }
    
    public final void onCallback(Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag
 * JD-Core Version:    0.7.0.1
 */