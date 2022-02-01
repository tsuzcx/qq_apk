package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleImg", "Landroid/widget/ImageView;", "onBubblingViewClickListener", "Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "getOnBubblingViewClickListener", "()Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "setOnBubblingViewClickListener", "(Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;)V", "smallConfetti", "Lcom/tencent/mm/particles/ConfettiManager;", "smallGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "emitSmallBubble", "", "stopSmallBubble", "Companion", "OnBubblingViewClickListener", "app_release"})
public final class BubblingView
  extends RelativeLayout
{
  public static final BubblingView.a JOG;
  private static final String TAG = "MicroMsg.BubblingView";
  private final com.tencent.mm.particles.b FCt;
  private final ImageView JOE;
  private b JOF;
  
  static
  {
    AppMethodBeat.i(230949);
    JOG = new BubblingView.a((byte)0);
    TAG = "MicroMsg.BubblingView";
    AppMethodBeat.o(230949);
  }
  
  public BubblingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(230948);
    AppMethodBeat.o(230948);
  }
  
  public BubblingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230947);
    View.inflate(paramContext, 2131493326, (ViewGroup)this);
    paramAttributeSet = findViewById(2131297854);
    p.g(paramAttributeSet, "findViewById(R.id.bubble_img)");
    this.JOE = ((ImageView)paramAttributeSet);
    this.JOE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230945);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/BubblingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.JOH.getOnBubblingViewClickListener();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/whatsnew/ui/BubblingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230945);
      }
    });
    paramAttributeSet = BitmapFactory.decodeResource(getResources(), 2131235769);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 40);
    this.FCt = ((com.tencent.mm.particles.b)new com.tencent.mm.particles.b() {});
    AppMethodBeat.o(230947);
  }
  
  public final b getOnBubblingViewClickListener()
  {
    return this.JOF;
  }
  
  public final void setOnBubblingViewClickListener(b paramb)
  {
    this.JOF = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "", "onBubblingViewClick", "", "app_release"})
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.BubblingView
 * JD-Core Version:    0.7.0.1
 */