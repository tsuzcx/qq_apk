package com.tencent.mm.ui.chatting.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/TranslateControllerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "anim", "Landroid/animation/ValueAnimator;", "getAnim", "()Landroid/animation/ValueAnimator;", "anim$delegate", "Lkotlin/Lazy;", "curLanShowWidth", "img", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "root", "targetLanTv", "Landroid/widget/TextView;", "value", "targetLanTvOriginWidth", "setTargetLanTvOriginWidth", "(I)V", "animScorll", "", "from", "to", "hideLanguage", "setLanguageText", "lan", "showLanguage", "updateTextViewWidth", "w", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TranslateControllerView
  extends LinearLayout
{
  private final String TAG;
  private final TextView aeyf;
  private final WeImageView aeyg;
  private int aeyh;
  private int aeyi;
  private final j aeyj;
  private final LinearLayout ybr;
  
  public TranslateControllerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(255969);
    AppMethodBeat.o(255969);
  }
  
  public TranslateControllerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(255970);
    AppMethodBeat.o(255970);
  }
  
  private TranslateControllerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(255971);
    this.TAG = "TranslateControllerView";
    this.aeyj = k.cm((a)new a(this));
    af.mU(paramContext).inflate(R.i.gfc, (ViewGroup)this, true);
    this.ybr = ((LinearLayout)findViewById(R.h.fxS));
    this.aeyf = ((TextView)findViewById(R.h.fxU));
    this.aeyg = ((WeImageView)findViewById(R.h.fxR));
    AppMethodBeat.o(255971);
  }
  
  private static final void a(TranslateControllerView paramTranslateControllerView)
  {
    AppMethodBeat.i(255975);
    s.u(paramTranslateControllerView, "this$0");
    Log.i(paramTranslateControllerView.TAG, "showLanguage: postDelayed");
    paramTranslateControllerView.ot(paramTranslateControllerView.aeyh, paramTranslateControllerView.aeyi);
    AppMethodBeat.o(255975);
  }
  
  private static final void b(TranslateControllerView paramTranslateControllerView)
  {
    AppMethodBeat.i(255977);
    s.u(paramTranslateControllerView, "this$0");
    Log.i(paramTranslateControllerView.TAG, "hideLanguage: postDelayed");
    paramTranslateControllerView.ot(paramTranslateControllerView.aeyh, 0);
    AppMethodBeat.o(255977);
  }
  
  private final ValueAnimator getAnim()
  {
    AppMethodBeat.i(255967);
    ValueAnimator localValueAnimator = (ValueAnimator)this.aeyj.getValue();
    AppMethodBeat.o(255967);
    return localValueAnimator;
  }
  
  private void ot(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255973);
    getAnim().cancel();
    getAnim().setIntValues(new int[] { paramInt1, paramInt2 });
    getAnim().start();
    AppMethodBeat.o(255973);
  }
  
  private final void setTargetLanTvOriginWidth(int paramInt)
  {
    this.aeyi = paramInt;
  }
  
  public final void jtX()
  {
    AppMethodBeat.i(255994);
    Log.i(this.TAG, "showLanguage: ");
    post(new TranslateControllerView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(255994);
  }
  
  public final void jtY()
  {
    AppMethodBeat.i(255998);
    Log.i(this.TAG, "hideLanguage: ");
    post(new TranslateControllerView..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(255998);
  }
  
  public final void setLanguageText(String paramString)
  {
    AppMethodBeat.i(256002);
    s.u(paramString, "lan");
    Object localObject = this.aeyf;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    localObject = this.aeyf;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      setTargetLanTvOriginWidth(i);
      ot(this.aeyh, this.aeyi);
      Log.i(this.TAG, s.X("setLanguageText: setTarget", Integer.valueOf(this.aeyi)));
      AppMethodBeat.o(256002);
      return;
      localObject = ((TextView)localObject).getPaint();
      if (localObject == null) {
        i = 0;
      } else {
        i = (int)((TextPaint)localObject).measureText(paramString);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/animation/ValueAnimator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ValueAnimator>
  {
    a(TranslateControllerView paramTranslateControllerView)
    {
      super();
    }
    
    private static final void a(TranslateControllerView paramTranslateControllerView, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(256255);
      s.u(paramTranslateControllerView, "this$0");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramTranslateControllerView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(256255);
        throw paramTranslateControllerView;
      }
      TranslateControllerView.a(paramTranslateControllerView, ((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(256255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.TranslateControllerView
 * JD-Core Version:    0.7.0.1
 */