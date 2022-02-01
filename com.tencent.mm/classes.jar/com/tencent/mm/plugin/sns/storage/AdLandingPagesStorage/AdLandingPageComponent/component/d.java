package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends k
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected aa wZa;
  protected ImageView wZb;
  protected TextView wZc;
  protected TextView wZd;
  protected FrameLayout wZe;
  protected RoundedCornerFrameLayout wZf;
  protected ViewGroup wZg;
  protected n wZh;
  protected boolean wZi;
  
  public d(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    AppMethodBeat.i(96425);
    this.wZi = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96424);
        if (paramAnonymousMessage.what == 1)
        {
          d.this.W(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(96424);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          d.this.X(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(96424);
      }
    };
    this.mContext = paramContext;
    this.wZg = paramViewGroup;
    this.wZa = paramaa;
    dvx();
    dvN();
    ad.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramaa.wWE + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dvz();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(96429);
  }
  
  protected final void X(boolean paramBoolean)
  {
    AppMethodBeat.i(96431);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      dvA();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(96431);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(96436);
    if (this.wZa == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.wZa == null) {}
      for (;;)
      {
        ad.e("AdLandingFloatBarCompWrapper", bool);
        AppMethodBeat.o(96436);
        return false;
        bool = false;
      }
    }
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96436);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      ad.i("AdLandingFloatBarCompWrapper", "kv=" + paramJSONObject.toString());
      AppMethodBeat.o(96436);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("AdLandingFloatBarCompWrapper", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96436);
    }
    return false;
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96434);
    super.dvA();
    if (this.wZh != null) {
      this.wZh.dvA();
    }
    ad.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.xac + ", stayTime=" + this.dsf);
    AppMethodBeat.o(96434);
  }
  
  /* Error */
  protected final void dvN()
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   9: getfield 227	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:iconUrl	Ljava/lang/String;
    //   12: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +285 -> 300
    //   18: aload_0
    //   19: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   22: getfield 227	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:iconUrl	Ljava/lang/String;
    //   25: aload_0
    //   26: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   29: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWF	I
    //   32: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 239	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   40: invokestatic 245	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   43: aload_0
    //   44: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   47: getfield 248	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:title	Ljava/lang/String;
    //   50: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +259 -> 312
    //   56: aload_0
    //   57: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZc	Landroid/widget/TextView;
    //   60: aload_0
    //   61: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   64: getfield 248	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:title	Ljava/lang/String;
    //   67: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   70: aload_0
    //   71: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZc	Landroid/widget/TextView;
    //   74: iconst_0
    //   75: invokevirtual 257	android/widget/TextView:setVisibility	(I)V
    //   78: aload_0
    //   79: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   82: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:desc	Ljava/lang/String;
    //   85: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +236 -> 324
    //   91: aload_0
    //   92: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZd	Landroid/widget/TextView;
    //   95: aload_0
    //   96: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   99: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:desc	Ljava/lang/String;
    //   102: invokevirtual 256	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   105: aload_0
    //   106: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZd	Landroid/widget/TextView;
    //   109: iconst_0
    //   110: invokevirtual 257	android/widget/TextView:setVisibility	(I)V
    //   113: aload_0
    //   114: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   117: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:jbK	Ljava/lang/String;
    //   120: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +258 -> 381
    //   126: aload_0
    //   127: getfield 125	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   130: aload_0
    //   131: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   134: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:jbK	Ljava/lang/String;
    //   137: invokestatic 271	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   140: invokevirtual 274	android/view/View:setBackgroundColor	(I)V
    //   143: aload_0
    //   144: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   147: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:gIA	Ljava/lang/String;
    //   150: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +20 -> 173
    //   156: aload_0
    //   157: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZc	Landroid/widget/TextView;
    //   160: aload_0
    //   161: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   164: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:gIA	Ljava/lang/String;
    //   167: invokestatic 271	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   170: invokevirtual 280	android/widget/TextView:setTextColor	(I)V
    //   173: aload_0
    //   174: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   177: getfield 283	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWS	Ljava/lang/String;
    //   180: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +20 -> 203
    //   186: aload_0
    //   187: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZd	Landroid/widget/TextView;
    //   190: aload_0
    //   191: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   194: getfield 283	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWS	Ljava/lang/String;
    //   197: invokestatic 271	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   200: invokevirtual 280	android/widget/TextView:setTextColor	(I)V
    //   203: aload_0
    //   204: getfield 285	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZe	Landroid/widget/FrameLayout;
    //   207: invokevirtual 290	android/widget/FrameLayout:removeAllViews	()V
    //   210: aload_0
    //   211: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   214: aload_0
    //   215: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   218: getfield 294	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   221: aload_0
    //   222: getfield 285	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZe	Landroid/widget/FrameLayout;
    //   225: iconst_0
    //   226: invokestatic 299	com/tencent/mm/plugin/sns/ui/as:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k;
    //   229: astore_1
    //   230: aload_1
    //   231: instanceof 208
    //   234: ifeq +278 -> 512
    //   237: aload_0
    //   238: aload_1
    //   239: checkcast 208	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n
    //   242: putfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   245: aload_0
    //   246: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   249: ifnull +19 -> 268
    //   252: aload_0
    //   253: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   256: invokevirtual 303	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:getView	()Landroid/view/View;
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 285	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZe	Landroid/widget/FrameLayout;
    //   264: aload_1
    //   265: invokevirtual 307	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   273: getfield 310	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWT	Z
    //   276: putfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZi	Z
    //   279: aload_0
    //   280: getfield 125	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   283: new 10	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   286: dup
    //   287: aload_0
    //   288: invokespecial 311	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   291: invokevirtual 315	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   294: ldc 224
    //   296: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: return
    //   300: aload_0
    //   301: getfield 317	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZf	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   304: bipush 8
    //   306: invokevirtual 320	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   309: goto -266 -> 43
    //   312: aload_0
    //   313: getfield 250	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZc	Landroid/widget/TextView;
    //   316: bipush 8
    //   318: invokevirtual 257	android/widget/TextView:setVisibility	(I)V
    //   321: goto -243 -> 78
    //   324: aload_0
    //   325: getfield 262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZd	Landroid/widget/TextView;
    //   328: bipush 8
    //   330: invokevirtual 257	android/widget/TextView:setVisibility	(I)V
    //   333: goto -220 -> 113
    //   336: astore_1
    //   337: ldc 79
    //   339: new 81	java/lang/StringBuilder
    //   342: dup
    //   343: ldc_w 322
    //   346: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload_1
    //   350: invokevirtual 323	java/lang/Exception:toString	()Ljava/lang/String;
    //   353: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc_w 325
    //   359: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   366: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:jbK	Ljava/lang/String;
    //   369: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: goto -235 -> 143
    //   381: aload_0
    //   382: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   385: getfield 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWR	Ljava/lang/String;
    //   388: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne -248 -> 143
    //   394: aload_0
    //   395: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   398: getfield 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWR	Ljava/lang/String;
    //   401: aload_0
    //   402: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   405: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWF	I
    //   408: new 8	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2
    //   411: dup
    //   412: aload_0
    //   413: invokespecial 329	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   416: invokestatic 245	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   419: goto -276 -> 143
    //   422: astore_1
    //   423: ldc 79
    //   425: new 81	java/lang/StringBuilder
    //   428: dup
    //   429: ldc_w 331
    //   432: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: aload_1
    //   436: invokevirtual 323	java/lang/Exception:toString	()Ljava/lang/String;
    //   439: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 325
    //   445: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   452: getfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:gIA	Ljava/lang/String;
    //   455: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: goto -291 -> 173
    //   467: astore_1
    //   468: ldc 79
    //   470: new 81	java/lang/StringBuilder
    //   473: dup
    //   474: ldc_w 333
    //   477: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   480: aload_1
    //   481: invokevirtual 323	java/lang/Exception:toString	()Ljava/lang/String;
    //   484: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: ldc_w 325
    //   490: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_0
    //   494: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:wZa	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   497: getfield 283	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa:wWS	Ljava/lang/String;
    //   500: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -306 -> 203
    //   512: ldc 79
    //   514: ldc_w 335
    //   517: aload_1
    //   518: invokestatic 341	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   521: invokevirtual 345	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   524: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: goto -282 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	d
    //   229	36	1	localObject	Object
    //   336	14	1	localException1	Exception
    //   422	14	1	localException2	Exception
    //   467	51	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   126	143	336	java/lang/Exception
    //   156	173	422	java/lang/Exception
    //   186	203	467	java/lang/Exception
  }
  
  public final void dvO()
  {
    AppMethodBeat.i(96437);
    if (this.wZh != null)
    {
      this.wZh.clickCount -= this.clickCount;
      ad.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.wZh.clickCount + ", stayTime=" + this.wZh.dsf);
    }
    AppMethodBeat.o(96437);
  }
  
  public final n dvP()
  {
    return this.wZh;
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96426);
    View localView = LayoutInflater.from(this.mContext).inflate(2131495501, this.wZg, false);
    this.mContentView = localView;
    this.wZb = ((ImageView)localView.findViewById(2131300137));
    this.wZc = ((TextView)localView.findViewById(2131300138));
    this.wZd = ((TextView)localView.findViewById(2131300136));
    this.wZe = ((FrameLayout)localView.findViewById(2131300135));
    ((RoundedCornerFrameLayout)localView.findViewById(2131300132)).setRadius(a.fromDPToPix(this.mContext, 8));
    this.wZf = ((RoundedCornerFrameLayout)localView.findViewById(2131300133));
    this.wZf.setRadius(a.fromDPToPix(this.mContext, 4));
    this.wZg.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96435);
    super.dvy();
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96433);
    super.dvz();
    if (this.wZh != null) {
      this.wZh.dvz();
    }
    ad.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.wZh instanceof s)) && (!((s)this.wZh).xau.isEnabled())) {
      this.wZi = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void i(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(96430);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96430);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(96432);
    if (this.mContentView.getVisibility() == 0)
    {
      AppMethodBeat.o(96432);
      return true;
    }
    AppMethodBeat.o(96432);
    return false;
  }
  
  public final void sU(long paramLong)
  {
    AppMethodBeat.i(96428);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */