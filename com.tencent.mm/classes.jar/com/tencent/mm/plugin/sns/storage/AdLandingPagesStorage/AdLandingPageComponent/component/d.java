package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends k
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected ab ylO;
  protected ImageView ylP;
  protected TextView ylQ;
  protected TextView ylR;
  protected FrameLayout ylS;
  protected RoundedCornerFrameLayout ylT;
  protected ViewGroup ylU;
  protected n ylV;
  protected boolean ylW;
  
  public d(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
    AppMethodBeat.i(96425);
    this.ylW = false;
    this.clickCount = 0;
    this.mHandler = new d.4(this, Looper.getMainLooper());
    this.mContext = paramContext;
    this.ylU = paramViewGroup;
    this.ylO = paramab;
    dJW();
    dKm();
    ac.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramab.yjs + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dJY();
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
      dJZ();
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
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(96436);
    if (this.ylO == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.ylO == null) {}
      for (;;)
      {
        ac.e("AdLandingFloatBarCompWrapper", bool);
        AppMethodBeat.o(96436);
        return false;
        bool = false;
      }
    }
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96436);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      ac.i("AdLandingFloatBarCompWrapper", "kv=" + paramJSONObject.toString());
      AppMethodBeat.o(96436);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ac.printErrStackTrace("AdLandingFloatBarCompWrapper", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96436);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96426);
    View localView = LayoutInflater.from(this.mContext).inflate(2131495501, this.ylU, false);
    this.mContentView = localView;
    this.ylP = ((ImageView)localView.findViewById(2131300137));
    this.ylQ = ((TextView)localView.findViewById(2131300138));
    this.ylR = ((TextView)localView.findViewById(2131300136));
    this.ylS = ((FrameLayout)localView.findViewById(2131300135));
    ((RoundedCornerFrameLayout)localView.findViewById(2131300132)).setRadius(a.fromDPToPix(this.mContext, 8));
    this.ylT = ((RoundedCornerFrameLayout)localView.findViewById(2131300133));
    this.ylT.setRadius(a.fromDPToPix(this.mContext, 4));
    this.ylU.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96435);
    super.dJX();
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96433);
    super.dJY();
    if (this.ylV != null) {
      this.ylV.dJY();
    }
    ac.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.ylV instanceof s)) && (!((s)this.ylV).ynj.isEnabled())) {
      this.ylW = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96434);
    super.dJZ();
    if (this.ylV != null) {
      this.ylV.dJZ();
    }
    ac.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.ymR + ", stayTime=" + this.dpQ);
    AppMethodBeat.o(96434);
  }
  
  /* Error */
  protected final void dKm()
  {
    // Byte code:
    //   0: ldc_w 302
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   10: getfield 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:iconUrl	Ljava/lang/String;
    //   13: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +289 -> 305
    //   19: aload_0
    //   20: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   23: getfield 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:iconUrl	Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   32: getfield 314	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjt	I
    //   35: new 316	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   38: dup
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 319	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;Ljava/lang/String;)V
    //   44: invokestatic 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   47: aload_0
    //   48: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   51: getfield 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:title	Ljava/lang/String;
    //   54: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +260 -> 317
    //   60: aload_0
    //   61: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylQ	Landroid/widget/TextView;
    //   64: aload_0
    //   65: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   68: getfield 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:title	Ljava/lang/String;
    //   71: invokevirtual 332	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_0
    //   75: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylQ	Landroid/widget/TextView;
    //   78: iconst_0
    //   79: invokevirtual 333	android/widget/TextView:setVisibility	(I)V
    //   82: aload_0
    //   83: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   86: getfield 336	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:desc	Ljava/lang/String;
    //   89: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +237 -> 329
    //   95: aload_0
    //   96: getfield 225	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylR	Landroid/widget/TextView;
    //   99: aload_0
    //   100: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   103: getfield 336	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:desc	Ljava/lang/String;
    //   106: invokevirtual 332	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: getfield 225	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylR	Landroid/widget/TextView;
    //   113: iconst_0
    //   114: invokevirtual 333	android/widget/TextView:setVisibility	(I)V
    //   117: aload_0
    //   118: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   121: getfield 339	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jBX	Ljava/lang/String;
    //   124: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +259 -> 386
    //   130: aload_0
    //   131: getfield 119	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   134: aload_0
    //   135: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   138: getfield 339	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jBX	Ljava/lang/String;
    //   141: invokestatic 345	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   144: invokevirtual 348	android/view/View:setBackgroundColor	(I)V
    //   147: aload_0
    //   148: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   151: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   154: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +20 -> 177
    //   160: aload_0
    //   161: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylQ	Landroid/widget/TextView;
    //   164: aload_0
    //   165: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   168: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   171: invokestatic 345	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   174: invokevirtual 354	android/widget/TextView:setTextColor	(I)V
    //   177: aload_0
    //   178: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   181: getfield 357	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjH	Ljava/lang/String;
    //   184: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +20 -> 207
    //   190: aload_0
    //   191: getfield 225	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylR	Landroid/widget/TextView;
    //   194: aload_0
    //   195: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   198: getfield 357	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjH	Ljava/lang/String;
    //   201: invokestatic 345	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   204: invokevirtual 354	android/widget/TextView:setTextColor	(I)V
    //   207: aload_0
    //   208: getfield 230	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylS	Landroid/widget/FrameLayout;
    //   211: invokevirtual 360	android/widget/FrameLayout:removeAllViews	()V
    //   214: aload_0
    //   215: getfield 60	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   218: aload_0
    //   219: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   222: getfield 364	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjM	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   225: aload_0
    //   226: getfield 230	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylS	Landroid/widget/FrameLayout;
    //   229: iconst_0
    //   230: invokestatic 369	com/tencent/mm/plugin/sns/ui/as:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k;
    //   233: astore_1
    //   234: aload_1
    //   235: instanceof 267
    //   238: ifeq +279 -> 517
    //   241: aload_0
    //   242: aload_1
    //   243: checkcast 267	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n
    //   246: putfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   249: aload_0
    //   250: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   253: ifnull +19 -> 272
    //   256: aload_0
    //   257: getfield 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n;
    //   260: invokevirtual 373	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/n:getView	()Landroid/view/View;
    //   263: astore_1
    //   264: aload_0
    //   265: getfield 230	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylS	Landroid/widget/FrameLayout;
    //   268: aload_1
    //   269: invokevirtual 374	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   277: getfield 377	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjI	Z
    //   280: putfield 43	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylW	Z
    //   283: aload_0
    //   284: getfield 119	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   287: new 379	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 382	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   295: invokevirtual 386	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   298: ldc_w 302
    //   301: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: aload_0
    //   306: getfield 245	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylT	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   309: bipush 8
    //   311: invokevirtual 387	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   314: goto -267 -> 47
    //   317: aload_0
    //   318: getfield 222	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylQ	Landroid/widget/TextView;
    //   321: bipush 8
    //   323: invokevirtual 333	android/widget/TextView:setVisibility	(I)V
    //   326: goto -244 -> 82
    //   329: aload_0
    //   330: getfield 225	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylR	Landroid/widget/TextView;
    //   333: bipush 8
    //   335: invokevirtual 333	android/widget/TextView:setVisibility	(I)V
    //   338: goto -221 -> 117
    //   341: astore_1
    //   342: ldc 73
    //   344: new 75	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 389
    //   351: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: invokevirtual 390	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 392
    //   364: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   371: getfield 339	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jBX	Ljava/lang/String;
    //   374: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 178	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto -236 -> 147
    //   386: aload_0
    //   387: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   390: getfield 395	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjG	Ljava/lang/String;
    //   393: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifne -249 -> 147
    //   399: aload_0
    //   400: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   403: getfield 395	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjG	Ljava/lang/String;
    //   406: aload_0
    //   407: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   410: getfield 314	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjt	I
    //   413: new 397	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2
    //   416: dup
    //   417: aload_0
    //   418: invokespecial 398	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   421: invokestatic 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   424: goto -277 -> 147
    //   427: astore_1
    //   428: ldc 73
    //   430: new 75	java/lang/StringBuilder
    //   433: dup
    //   434: ldc_w 400
    //   437: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload_1
    //   441: invokevirtual 390	java/lang/Exception:toString	()Ljava/lang/String;
    //   444: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 392
    //   450: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   457: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   460: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 178	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -292 -> 177
    //   472: astore_1
    //   473: ldc 73
    //   475: new 75	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 402
    //   482: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload_1
    //   486: invokevirtual 390	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 392
    //   495: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_0
    //   499: getfield 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:ylO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   502: getfield 357	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:yjH	Ljava/lang/String;
    //   505: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 178	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -307 -> 207
    //   517: ldc 73
    //   519: ldc_w 404
    //   522: aload_1
    //   523: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   526: invokevirtual 414	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokestatic 178	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: goto -283 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	d
    //   26	243	1	localObject	Object
    //   341	14	1	localException1	Exception
    //   427	14	1	localException2	Exception
    //   472	51	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   130	147	341	java/lang/Exception
    //   160	177	427	java/lang/Exception
    //   190	207	472	java/lang/Exception
  }
  
  public final void dKn()
  {
    AppMethodBeat.i(96437);
    if (this.ylV != null)
    {
      this.ylV.clickCount -= this.clickCount;
      ac.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.ylV.clickCount + ", stayTime=" + this.ylV.dpQ);
    }
    AppMethodBeat.o(96437);
  }
  
  public final n dKo()
  {
    return this.ylV;
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
  
  public final void xx(long paramLong)
  {
    AppMethodBeat.i(96428);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */