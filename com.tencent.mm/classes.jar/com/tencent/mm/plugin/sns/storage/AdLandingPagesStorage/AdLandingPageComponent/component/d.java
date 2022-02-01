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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends l
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected ab zCD;
  protected ImageView zCE;
  protected TextView zCF;
  protected TextView zCG;
  protected FrameLayout zCH;
  protected RoundedCornerFrameLayout zCI;
  protected ViewGroup zCJ;
  protected o zCK;
  protected boolean zCL;
  
  public d(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
    AppMethodBeat.i(96425);
    this.zCL = false;
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
    this.zCJ = paramViewGroup;
    this.zCD = paramab;
    dRk();
    dRl();
    ad.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramab.zAg + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dRm();
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
      dRn();
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
    if (this.zCD == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.zCD == null) {}
      for (;;)
      {
        ad.e("AdLandingFloatBarCompWrapper", bool);
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
  
  public final void dRk()
  {
    AppMethodBeat.i(96426);
    View localView = LayoutInflater.from(this.mContext).inflate(2131495501, this.zCJ, false);
    this.mContentView = localView;
    this.zCE = ((ImageView)localView.findViewById(2131300137));
    this.zCF = ((TextView)localView.findViewById(2131300138));
    this.zCG = ((TextView)localView.findViewById(2131300136));
    this.zCH = ((FrameLayout)localView.findViewById(2131300135));
    ((RoundedCornerFrameLayout)localView.findViewById(2131300132)).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8));
    this.zCI = ((RoundedCornerFrameLayout)localView.findViewById(2131300133));
    this.zCI.setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 4));
    this.zCJ.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  /* Error */
  protected final void dRl()
  {
    // Byte code:
    //   0: ldc_w 258
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   10: getfield 261	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:iconUrl	Ljava/lang/String;
    //   13: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +289 -> 305
    //   19: aload_0
    //   20: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   23: getfield 261	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:iconUrl	Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   32: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAh	I
    //   35: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   38: dup
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;Ljava/lang/String;)V
    //   44: invokestatic 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   47: aload_0
    //   48: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   51: getfield 282	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:title	Ljava/lang/String;
    //   54: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +260 -> 317
    //   60: aload_0
    //   61: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCF	Landroid/widget/TextView;
    //   64: aload_0
    //   65: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   68: getfield 282	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:title	Ljava/lang/String;
    //   71: invokevirtual 286	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   74: aload_0
    //   75: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCF	Landroid/widget/TextView;
    //   78: iconst_0
    //   79: invokevirtual 287	android/widget/TextView:setVisibility	(I)V
    //   82: aload_0
    //   83: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   86: getfield 290	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:desc	Ljava/lang/String;
    //   89: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +237 -> 329
    //   95: aload_0
    //   96: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCG	Landroid/widget/TextView;
    //   99: aload_0
    //   100: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   103: getfield 290	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:desc	Ljava/lang/String;
    //   106: invokevirtual 286	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCG	Landroid/widget/TextView;
    //   113: iconst_0
    //   114: invokevirtual 287	android/widget/TextView:setVisibility	(I)V
    //   117: aload_0
    //   118: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   121: getfield 293	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jVX	Ljava/lang/String;
    //   124: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +259 -> 386
    //   130: aload_0
    //   131: getfield 125	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   134: aload_0
    //   135: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   138: getfield 293	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jVX	Ljava/lang/String;
    //   141: invokestatic 299	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   144: invokevirtual 302	android/view/View:setBackgroundColor	(I)V
    //   147: aload_0
    //   148: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   151: getfield 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   154: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +20 -> 177
    //   160: aload_0
    //   161: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCF	Landroid/widget/TextView;
    //   164: aload_0
    //   165: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   168: getfield 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   171: invokestatic 299	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   174: invokevirtual 308	android/widget/TextView:setTextColor	(I)V
    //   177: aload_0
    //   178: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   181: getfield 311	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAw	Ljava/lang/String;
    //   184: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +20 -> 207
    //   190: aload_0
    //   191: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCG	Landroid/widget/TextView;
    //   194: aload_0
    //   195: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   198: getfield 311	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAw	Ljava/lang/String;
    //   201: invokestatic 299	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   204: invokevirtual 308	android/widget/TextView:setTextColor	(I)V
    //   207: aload_0
    //   208: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCH	Landroid/widget/FrameLayout;
    //   211: invokevirtual 314	android/widget/FrameLayout:removeAllViews	()V
    //   214: aload_0
    //   215: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   218: aload_0
    //   219: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   222: getfield 318	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAB	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;
    //   225: aload_0
    //   226: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCH	Landroid/widget/FrameLayout;
    //   229: iconst_0
    //   230: invokestatic 323	com/tencent/mm/plugin/sns/ui/av:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/x;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l;
    //   233: astore_1
    //   234: aload_1
    //   235: instanceof 325
    //   238: ifeq +279 -> 517
    //   241: aload_0
    //   242: aload_1
    //   243: checkcast 325	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o
    //   246: putfield 327	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o;
    //   249: aload_0
    //   250: getfield 327	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o;
    //   253: ifnull +19 -> 272
    //   256: aload_0
    //   257: getfield 327	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o;
    //   260: invokevirtual 331	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/o:getView	()Landroid/view/View;
    //   263: astore_1
    //   264: aload_0
    //   265: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCH	Landroid/widget/FrameLayout;
    //   268: aload_1
    //   269: invokevirtual 332	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   277: getfield 335	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAx	Z
    //   280: putfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCL	Z
    //   283: aload_0
    //   284: getfield 125	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   287: new 10	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   295: invokevirtual 342	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   298: ldc_w 258
    //   301: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: aload_0
    //   306: getfield 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCI	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   309: bipush 8
    //   311: invokevirtual 343	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   314: goto -267 -> 47
    //   317: aload_0
    //   318: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCF	Landroid/widget/TextView;
    //   321: bipush 8
    //   323: invokevirtual 287	android/widget/TextView:setVisibility	(I)V
    //   326: goto -244 -> 82
    //   329: aload_0
    //   330: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCG	Landroid/widget/TextView;
    //   333: bipush 8
    //   335: invokevirtual 287	android/widget/TextView:setVisibility	(I)V
    //   338: goto -221 -> 117
    //   341: astore_1
    //   342: ldc 79
    //   344: new 81	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 345
    //   351: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 348
    //   364: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   371: getfield 293	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:jVX	Ljava/lang/String;
    //   374: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto -236 -> 147
    //   386: aload_0
    //   387: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   390: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAv	Ljava/lang/String;
    //   393: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifne -249 -> 147
    //   399: aload_0
    //   400: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   403: getfield 351	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAv	Ljava/lang/String;
    //   406: aload_0
    //   407: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   410: getfield 270	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAh	I
    //   413: new 8	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2
    //   416: dup
    //   417: aload_0
    //   418: invokespecial 352	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   421: invokestatic 279	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   424: goto -277 -> 147
    //   427: astore_1
    //   428: ldc 79
    //   430: new 81	java/lang/StringBuilder
    //   433: dup
    //   434: ldc_w 354
    //   437: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload_1
    //   441: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   444: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 348
    //   450: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   457: getfield 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:titleColor	Ljava/lang/String;
    //   460: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -292 -> 177
    //   472: astore_1
    //   473: ldc 79
    //   475: new 81	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 356
    //   482: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload_1
    //   486: invokevirtual 346	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 348
    //   495: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_0
    //   499: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:zCD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab;
    //   502: getfield 311	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ab:zAw	Ljava/lang/String;
    //   505: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -307 -> 207
    //   517: ldc 79
    //   519: ldc_w 358
    //   522: aload_1
    //   523: invokestatic 364	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   526: invokevirtual 368	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final void dRm()
  {
    AppMethodBeat.i(96433);
    super.dRm();
    if (this.zCK != null) {
      this.zCK.dRm();
    }
    ad.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.zCK instanceof t)) && (!((t)this.zCK).zEd.isEnabled())) {
      this.zCL = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96434);
    super.dRn();
    if (this.zCK != null) {
      this.zCK.dRn();
    }
    ad.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.zDL + ", stayTime=" + this.dBD);
    AppMethodBeat.o(96434);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96435);
    super.dRo();
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void dWA()
  {
    AppMethodBeat.i(96437);
    if (this.zCK != null)
    {
      this.zCK.clickCount -= this.clickCount;
      ad.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.zCK.clickCount + ", stayTime=" + this.zCK.dBD);
    }
    AppMethodBeat.o(96437);
  }
  
  public final o dWB()
  {
    return this.zCK;
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
  
  public final void zV(long paramLong)
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