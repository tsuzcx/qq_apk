package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends m
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected ac zTF;
  protected ImageView zTG;
  protected TextView zTH;
  protected TextView zTI;
  protected FrameLayout zTJ;
  protected RoundedCornerFrameLayout zTK;
  protected ViewGroup zTL;
  protected p zTM;
  protected boolean zTN;
  
  public d(Context paramContext, ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
    AppMethodBeat.i(96425);
    this.zTN = false;
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
    this.zTL = paramViewGroup;
    this.zTF = paramac;
    dUI();
    dUJ();
    ae.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramac.zRg + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  public final void At(long paramLong)
  {
    AppMethodBeat.i(96428);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96428);
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dUK();
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
      dUL();
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
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(96436);
    if (this.zTF == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.zTF == null) {}
      for (;;)
      {
        ae.e("AdLandingFloatBarCompWrapper", bool);
        AppMethodBeat.o(96436);
        return false;
        bool = false;
      }
    }
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96436);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      ae.i("AdLandingFloatBarCompWrapper", "kv=" + paramJSONObject.toString());
      AppMethodBeat.o(96436);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ae.printErrStackTrace("AdLandingFloatBarCompWrapper", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96436);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96426);
    View localView = LayoutInflater.from(this.mContext).inflate(2131495501, this.zTL, false);
    this.mContentView = localView;
    this.zTG = ((ImageView)localView.findViewById(2131300137));
    this.zTH = ((TextView)localView.findViewById(2131300138));
    this.zTI = ((TextView)localView.findViewById(2131300136));
    this.zTJ = ((FrameLayout)localView.findViewById(2131300135));
    ((RoundedCornerFrameLayout)localView.findViewById(2131300132)).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.zTK = ((RoundedCornerFrameLayout)localView.findViewById(2131300133));
    this.zTK.setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4));
    this.zTL.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  /* Error */
  protected final void dUJ()
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   10: getfield 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:iconUrl	Ljava/lang/String;
    //   13: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +289 -> 305
    //   19: aload_0
    //   20: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   23: getfield 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:iconUrl	Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   32: getfield 288	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRh	I
    //   35: new 290	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   38: dup
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 293	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;Ljava/lang/String;)V
    //   44: invokestatic 299	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   47: aload_0
    //   48: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   51: getfield 302	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:title	Ljava/lang/String;
    //   54: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +260 -> 317
    //   60: aload_0
    //   61: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTH	Landroid/widget/TextView;
    //   64: aload_0
    //   65: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   68: getfield 302	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:title	Ljava/lang/String;
    //   71: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_0
    //   75: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTH	Landroid/widget/TextView;
    //   78: iconst_0
    //   79: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   82: aload_0
    //   83: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   86: getfield 310	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:desc	Ljava/lang/String;
    //   89: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +237 -> 329
    //   95: aload_0
    //   96: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTI	Landroid/widget/TextView;
    //   99: aload_0
    //   100: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   103: getfield 310	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:desc	Ljava/lang/String;
    //   106: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTI	Landroid/widget/TextView;
    //   113: iconst_0
    //   114: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   117: aload_0
    //   118: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   121: getfield 313	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:jZm	Ljava/lang/String;
    //   124: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +259 -> 386
    //   130: aload_0
    //   131: getfield 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   134: aload_0
    //   135: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   138: getfield 313	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:jZm	Ljava/lang/String;
    //   141: invokestatic 319	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   144: invokevirtual 322	android/view/View:setBackgroundColor	(I)V
    //   147: aload_0
    //   148: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   151: getfield 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:titleColor	Ljava/lang/String;
    //   154: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +20 -> 177
    //   160: aload_0
    //   161: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTH	Landroid/widget/TextView;
    //   164: aload_0
    //   165: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   168: getfield 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:titleColor	Ljava/lang/String;
    //   171: invokestatic 319	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   174: invokevirtual 328	android/widget/TextView:setTextColor	(I)V
    //   177: aload_0
    //   178: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   181: getfield 331	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRw	Ljava/lang/String;
    //   184: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +20 -> 207
    //   190: aload_0
    //   191: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTI	Landroid/widget/TextView;
    //   194: aload_0
    //   195: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   198: getfield 331	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRw	Ljava/lang/String;
    //   201: invokestatic 319	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   204: invokevirtual 328	android/widget/TextView:setTextColor	(I)V
    //   207: aload_0
    //   208: getfield 254	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTJ	Landroid/widget/FrameLayout;
    //   211: invokevirtual 334	android/widget/FrameLayout:removeAllViews	()V
    //   214: aload_0
    //   215: getfield 62	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   218: aload_0
    //   219: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   222: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRB	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;
    //   225: aload_0
    //   226: getfield 254	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTJ	Landroid/widget/FrameLayout;
    //   229: iconst_0
    //   230: invokestatic 343	com/tencent/mm/plugin/sns/ui/av:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/y;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/m;
    //   233: astore_1
    //   234: aload_1
    //   235: instanceof 345
    //   238: ifeq +279 -> 517
    //   241: aload_0
    //   242: aload_1
    //   243: checkcast 345	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p
    //   246: putfield 347	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTM	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   249: aload_0
    //   250: getfield 347	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTM	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   253: ifnull +19 -> 272
    //   256: aload_0
    //   257: getfield 347	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTM	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   260: invokevirtual 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p:getView	()Landroid/view/View;
    //   263: astore_1
    //   264: aload_0
    //   265: getfield 254	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTJ	Landroid/widget/FrameLayout;
    //   268: aload_1
    //   269: invokevirtual 352	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   277: getfield 355	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRx	Z
    //   280: putfield 47	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTN	Z
    //   283: aload_0
    //   284: getfield 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   287: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 358	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   295: invokevirtual 362	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   298: ldc_w 276
    //   301: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: aload_0
    //   306: getfield 269	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTK	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   309: bipush 8
    //   311: invokevirtual 363	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   314: goto -267 -> 47
    //   317: aload_0
    //   318: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTH	Landroid/widget/TextView;
    //   321: bipush 8
    //   323: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   326: goto -244 -> 82
    //   329: aload_0
    //   330: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTI	Landroid/widget/TextView;
    //   333: bipush 8
    //   335: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   338: goto -221 -> 117
    //   341: astore_1
    //   342: ldc 75
    //   344: new 77	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 365
    //   351: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: invokevirtual 366	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 368
    //   364: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   371: getfield 313	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:jZm	Ljava/lang/String;
    //   374: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 202	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto -236 -> 147
    //   386: aload_0
    //   387: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   390: getfield 371	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRv	Ljava/lang/String;
    //   393: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifne -249 -> 147
    //   399: aload_0
    //   400: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   403: getfield 371	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRv	Ljava/lang/String;
    //   406: aload_0
    //   407: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   410: getfield 288	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRh	I
    //   413: new 373	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2
    //   416: dup
    //   417: aload_0
    //   418: invokespecial 374	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   421: invokestatic 299	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   424: goto -277 -> 147
    //   427: astore_1
    //   428: ldc 75
    //   430: new 77	java/lang/StringBuilder
    //   433: dup
    //   434: ldc_w 376
    //   437: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload_1
    //   441: invokevirtual 366	java/lang/Exception:toString	()Ljava/lang/String;
    //   444: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 368
    //   450: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   457: getfield 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:titleColor	Ljava/lang/String;
    //   460: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 202	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -292 -> 177
    //   472: astore_1
    //   473: ldc 75
    //   475: new 77	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 378
    //   482: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload_1
    //   486: invokevirtual 366	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 368
    //   495: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_0
    //   499: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zTF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac;
    //   502: getfield 331	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ac:zRw	Ljava/lang/String;
    //   505: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 202	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -307 -> 207
    //   517: ldc 75
    //   519: ldc_w 380
    //   522: aload_1
    //   523: invokestatic 386	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   526: invokevirtual 390	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokestatic 202	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final void dUK()
  {
    AppMethodBeat.i(96433);
    super.dUK();
    if (this.zTM != null) {
      this.zTM.dUK();
    }
    ae.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.zTM instanceof u)) && (!((u)this.zTM).zVi.isEnabled())) {
      this.zTN = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96434);
    super.dUL();
    if (this.zTM != null) {
      this.zTM.dUL();
    }
    ae.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.zUQ + ", stayTime=" + this.dCI);
    AppMethodBeat.o(96434);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96435);
    super.dUM();
    if (this.zTM != null) {
      this.zTM.dUM();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void eac()
  {
    AppMethodBeat.i(96437);
    if (this.zTM != null)
    {
      this.zTM.clickCount -= this.clickCount;
      ae.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.zTM.clickCount + ", stayTime=" + this.zTM.dCI);
    }
    AppMethodBeat.o(96437);
  }
  
  public final p ead()
  {
    return this.zTM;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */