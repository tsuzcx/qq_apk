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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends m
{
  protected ad EbN;
  protected ImageView EbO;
  protected TextView EbP;
  protected TextView EbQ;
  protected FrameLayout EbR;
  protected RoundedCornerFrameLayout EbS;
  protected ViewGroup EbT;
  protected p EbU;
  protected boolean EbV;
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  
  public d(Context paramContext, ad paramad, ViewGroup paramViewGroup)
  {
    super(paramContext, paramad, paramViewGroup);
    AppMethodBeat.i(96425);
    this.EbV = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96424);
        if (paramAnonymousMessage.what == 1)
        {
          d.this.V(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(96424);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          d.this.W(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(96424);
      }
    };
    this.mContext = paramContext;
    this.EbT = paramViewGroup;
    this.EbN = paramad;
    eXe();
    eWT();
    Log.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramad.DZi + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  public final void JA(long paramLong)
  {
    AppMethodBeat.i(96428);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96428);
  }
  
  protected final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      eWZ();
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
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(96431);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      eXa();
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
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(96436);
    if (this.EbN == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.EbN == null) {}
      for (;;)
      {
        Log.e("AdLandingFloatBarCompWrapper", bool);
        AppMethodBeat.o(96436);
        return false;
        bool = false;
      }
    }
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96436);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      Log.i("AdLandingFloatBarCompWrapper", "kv=" + paramJSONObject.toString());
      AppMethodBeat.o(96436);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingFloatBarCompWrapper", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96436);
    }
    return false;
  }
  
  /* Error */
  protected final void eWT()
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   9: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:iconUrl	Ljava/lang/String;
    //   12: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +288 -> 303
    //   18: aload_0
    //   19: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   22: getfield 228	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:iconUrl	Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   31: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZj	I
    //   34: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   37: dup
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 240	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;Ljava/lang/String;)V
    //   43: invokestatic 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   46: aload_0
    //   47: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   50: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:title	Ljava/lang/String;
    //   53: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +259 -> 315
    //   59: aload_0
    //   60: getfield 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbP	Landroid/widget/TextView;
    //   63: aload_0
    //   64: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   67: getfield 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:title	Ljava/lang/String;
    //   70: invokevirtual 257	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   73: aload_0
    //   74: getfield 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbP	Landroid/widget/TextView;
    //   77: iconst_0
    //   78: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
    //   81: aload_0
    //   82: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   85: getfield 261	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:desc	Ljava/lang/String;
    //   88: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +236 -> 327
    //   94: aload_0
    //   95: getfield 263	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbQ	Landroid/widget/TextView;
    //   98: aload_0
    //   99: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   102: getfield 261	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:desc	Ljava/lang/String;
    //   105: invokevirtual 257	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   108: aload_0
    //   109: getfield 263	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbQ	Landroid/widget/TextView;
    //   112: iconst_0
    //   113: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
    //   116: aload_0
    //   117: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   120: getfield 266	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:lco	Ljava/lang/String;
    //   123: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +258 -> 384
    //   129: aload_0
    //   130: getfield 148	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   133: aload_0
    //   134: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   137: getfield 266	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:lco	Ljava/lang/String;
    //   140: invokestatic 272	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   143: invokevirtual 275	android/view/View:setBackgroundColor	(I)V
    //   146: aload_0
    //   147: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   150: getfield 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:iyd	Ljava/lang/String;
    //   153: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +20 -> 176
    //   159: aload_0
    //   160: getfield 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbP	Landroid/widget/TextView;
    //   163: aload_0
    //   164: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   167: getfield 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:iyd	Ljava/lang/String;
    //   170: invokestatic 272	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   173: invokevirtual 281	android/widget/TextView:setTextColor	(I)V
    //   176: aload_0
    //   177: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   180: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZC	Ljava/lang/String;
    //   183: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +20 -> 206
    //   189: aload_0
    //   190: getfield 263	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbQ	Landroid/widget/TextView;
    //   193: aload_0
    //   194: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   197: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZC	Ljava/lang/String;
    //   200: invokestatic 272	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   203: invokevirtual 281	android/widget/TextView:setTextColor	(I)V
    //   206: aload_0
    //   207: getfield 286	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbR	Landroid/widget/FrameLayout;
    //   210: invokevirtual 291	android/widget/FrameLayout:removeAllViews	()V
    //   213: aload_0
    //   214: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   217: aload_0
    //   218: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   221: getfield 295	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZH	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;
    //   224: aload_0
    //   225: getfield 286	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbR	Landroid/widget/FrameLayout;
    //   228: iconst_0
    //   229: invokestatic 300	com/tencent/mm/plugin/sns/ui/ay:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/z;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/m;
    //   232: astore_1
    //   233: aload_1
    //   234: instanceof 302
    //   237: ifeq +278 -> 515
    //   240: aload_0
    //   241: aload_1
    //   242: checkcast 302	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p
    //   245: putfield 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbU	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   248: aload_0
    //   249: getfield 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbU	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   252: ifnull +19 -> 271
    //   255: aload_0
    //   256: getfield 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbU	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   259: invokevirtual 308	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p:getView	()Landroid/view/View;
    //   262: astore_1
    //   263: aload_0
    //   264: getfield 286	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbR	Landroid/widget/FrameLayout;
    //   267: aload_1
    //   268: invokevirtual 312	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   276: getfield 315	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZD	Z
    //   279: putfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbV	Z
    //   282: aload_0
    //   283: getfield 148	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   286: new 10	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   289: dup
    //   290: aload_0
    //   291: invokespecial 318	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   294: invokevirtual 322	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   297: ldc 225
    //   299: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: aload_0
    //   304: getfield 324	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbS	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   307: bipush 8
    //   309: invokevirtual 327	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   312: goto -266 -> 46
    //   315: aload_0
    //   316: getfield 251	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbP	Landroid/widget/TextView;
    //   319: bipush 8
    //   321: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
    //   324: goto -243 -> 81
    //   327: aload_0
    //   328: getfield 263	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbQ	Landroid/widget/TextView;
    //   331: bipush 8
    //   333: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
    //   336: goto -220 -> 116
    //   339: astore_1
    //   340: ldc 79
    //   342: new 81	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 329
    //   349: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload_1
    //   353: invokevirtual 330	java/lang/Exception:toString	()Ljava/lang/String;
    //   356: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 332
    //   362: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   369: getfield 266	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:lco	Ljava/lang/String;
    //   372: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: goto -235 -> 146
    //   384: aload_0
    //   385: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   388: getfield 335	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZB	Ljava/lang/String;
    //   391: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne -248 -> 146
    //   397: aload_0
    //   398: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   401: getfield 335	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZB	Ljava/lang/String;
    //   404: aload_0
    //   405: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   408: getfield 237	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZj	I
    //   411: new 8	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2
    //   414: dup
    //   415: aload_0
    //   416: invokespecial 336	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$2:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   419: invokestatic 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;ILcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   422: goto -276 -> 146
    //   425: astore_1
    //   426: ldc 79
    //   428: new 81	java/lang/StringBuilder
    //   431: dup
    //   432: ldc_w 338
    //   435: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: aload_1
    //   439: invokevirtual 330	java/lang/Exception:toString	()Ljava/lang/String;
    //   442: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 332
    //   448: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   455: getfield 278	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:iyd	Ljava/lang/String;
    //   458: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: goto -291 -> 176
    //   470: astore_1
    //   471: ldc 79
    //   473: new 81	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 340
    //   480: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload_1
    //   484: invokevirtual 330	java/lang/Exception:toString	()Ljava/lang/String;
    //   487: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc_w 332
    //   493: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:EbN	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
    //   500: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad:DZC	Ljava/lang/String;
    //   503: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -306 -> 206
    //   515: ldc 79
    //   517: ldc_w 342
    //   520: aload_1
    //   521: invokestatic 348	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokevirtual 352	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   527: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: goto -282 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	d
    //   25	243	1	localObject	Object
    //   339	14	1	localException1	Exception
    //   425	14	1	localException2	Exception
    //   470	51	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   129	146	339	java/lang/Exception
    //   159	176	425	java/lang/Exception
    //   189	206	470	java/lang/Exception
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96433);
    super.eWZ();
    if (this.EbU != null) {
      this.EbU.eWZ();
    }
    Log.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.EbU instanceof u)) && (!((u)this.EbU).Edp.isEnabled())) {
      this.EbV = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96434);
    super.eXa();
    if (this.EbU != null) {
      this.EbU.eXa();
    }
    Log.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.Dzo + ", stayTime=" + fdo());
    AppMethodBeat.o(96434);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96435);
    super.eXd();
    if (this.EbU != null) {
      this.EbU.eXd();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96426);
    View localView = LayoutInflater.from(this.mContext).inflate(2131496384, this.EbT, false);
    this.mContentView = localView;
    this.EbO = ((ImageView)localView.findViewById(2131301588));
    this.EbP = ((TextView)localView.findViewById(2131301589));
    this.EbQ = ((TextView)localView.findViewById(2131301587));
    this.EbR = ((FrameLayout)localView.findViewById(2131301586));
    ((RoundedCornerFrameLayout)localView.findViewById(2131301583)).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
    this.EbS = ((RoundedCornerFrameLayout)localView.findViewById(2131301584));
    this.EbS.setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4));
    this.EbT.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  public final void fcW()
  {
    AppMethodBeat.i(96437);
    if (this.EbU != null)
    {
      this.EbU.clickCount -= this.clickCount;
      Log.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.EbU.clickCount + ", stayTime=" + this.EbU.fdo());
    }
    AppMethodBeat.o(96437);
  }
  
  public final p fcX()
  {
    return this.EbU;
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
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(96430);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */