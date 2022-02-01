package com.tencent.mm.ui.chatting.gallery.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.y.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorViewPosition", "Landroid/graphics/Point;", "anchorViewSize", "bubbleMinWidth", "bubbleTextView", "Landroid/widget/TextView;", "bubbleTriangle", "Landroid/view/View;", "bubbleTriangleWidth", "bubbleViewContainer", "Landroid/view/ViewGroup;", "bubbleViewContainerRightMargin", "bubbleWidth", "mAnchor", "pendingShow", "", "viewWidth", "hide", "", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "anchorView", "setAnchorViewPosition", "x", "y", "setAnchorViewSize", "width", "height", "setBubbleClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBubbleText", "text", "", "setViewWidth", "show", "showByPosition", "showIfNeed", "Companion", "app_release"})
public final class SearchImageBubbleView
  extends LinearLayout
{
  public static final SearchImageBubbleView.a Krm;
  private ViewGroup Krc;
  private TextView Krd;
  private View Kre;
  private boolean Krf;
  private Point Krg;
  private Point Krh;
  private int Kri;
  private int Krj;
  private int Krk;
  private int Krl;
  private View azA;
  private int gil;
  
  static
  {
    AppMethodBeat.i(188368);
    Krm = new SearchImageBubbleView.a((byte)0);
    AppMethodBeat.o(188368);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(188366);
    AppMethodBeat.o(188366);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(188367);
    this.Krf = true;
    this.Krg = new Point(0, 0);
    this.Krh = new Point(0, 0);
    paramContext = LayoutInflater.from(paramContext).inflate(2131496524, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131308516);
    p.g(paramAttributeSet, "view.findViewById(R.id.s…h_image_bubble_container)");
    this.Krc = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131308517);
    p.g(paramAttributeSet, "view.findViewById(R.id.search_image_bubble_tips)");
    this.Krd = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131308478);
    p.g(paramContext, "view.findViewById(R.id.bubble_triangle)");
    this.Kre = paramContext;
    this.Krk = getResources().getDimensionPixelSize(2131167086);
    this.Krj = getResources().getDimensionPixelSize(2131167083);
    AppMethodBeat.o(188367);
  }
  
  private final void fLk()
  {
    AppMethodBeat.i(188365);
    setVisibility(0);
    y.d locald = new y.d();
    Object localObject = getLayoutParams();
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams))) {
      this.Krl = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
    }
    ae.v("MicroMsg.SearchImageBubbleView", "alvinluo showByPosition anchorViewPosition: %s, anchorViewSize: %s, bubbleWidth: %d, viewWidth: %d, bubbleRightMargin: %d", new Object[] { this.Krh, this.Krg, Integer.valueOf(this.Kri), Integer.valueOf(this.gil), Integer.valueOf(this.Krl) });
    localObject = this.Krd;
    if (localObject == null) {
      p.bdF("bubbleTextView");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    int i;
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
    {
      i = this.Krh.x + this.Krg.x / 2;
      if ((this.Kri <= this.Krj) || (this.Kri + i - this.Krj / 2 <= this.gil - this.Krl)) {
        break label341;
      }
      locald.NiW = (this.gil - this.Kri - this.Krl);
    }
    label341:
    for (locald.NiW = ((int)Math.max(this.gil / 3.0F, locald.NiW));; locald.NiW = (i - this.Kri / 2))
    {
      if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.NiW) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.NiW;
      }
      localObject = this.Kre;
      if (localObject == null) {
        p.bdF("bubbleTriangle");
      }
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null) {
        break;
      }
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        locald.NiW = Math.max(0, this.Krh.x + this.Krg.x / 2 - this.Krk / 2);
        if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.NiW) {
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.NiW;
        }
      }
      AppMethodBeat.o(188365);
      return;
    }
    AppMethodBeat.o(188365);
  }
  
  public final void jZ(int paramInt1, int paramInt2)
  {
    this.Krg.x = paramInt1;
    this.Krg.y = paramInt2;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188363);
    super.onMeasure(paramInt1, paramInt2);
    if (this.azA != null)
    {
      Object localObject1 = this.Krh;
      Object localObject2 = this.azA;
      if (localObject2 == null) {
        p.gkB();
      }
      ((Point)localObject1).x = ((int)((View)localObject2).getX());
      localObject1 = this.Krh;
      localObject2 = this.azA;
      if (localObject2 == null) {
        p.gkB();
      }
      ((Point)localObject1).y = ((int)((View)localObject2).getY());
      localObject1 = this.Krh;
      localObject2 = this.Krd;
      if (localObject2 == null) {
        p.bdF("bubbleTextView");
      }
      ae.v("MicroMsg.SearchImageBubbleView", "alvinluo onMeasure anchorViewPos: %s, %d, %d", new Object[] { localObject1, Integer.valueOf(((TextView)localObject2).getMeasuredWidth()), Integer.valueOf(getMeasuredWidth()) });
      if (this.Krh.x > 0)
      {
        localObject1 = this.Krd;
        if (localObject1 == null) {
          p.bdF("bubbleTextView");
        }
        if ((((TextView)localObject1).getMeasuredWidth() >= 0) && (getMeasuredWidth() > 0))
        {
          this.gil = getMeasuredWidth();
          ae.v("MicroMsg.SearchImageBubbleView", "alvinluo showIfNeed pendingShow: %b", new Object[] { Boolean.valueOf(this.Krf) });
          if (this.Krf)
          {
            this.Krf = false;
            fLk();
          }
        }
      }
    }
    AppMethodBeat.o(188363);
  }
  
  public final void setAnchorView(View paramView)
  {
    this.azA = paramView;
  }
  
  public final void setAnchorViewPosition$255f295(int paramInt)
  {
    this.Krh.x = paramInt;
    this.Krh.y = 0;
  }
  
  public final void setBubbleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(188362);
    TextView localTextView = this.Krd;
    if (localTextView == null) {
      p.bdF("bubbleTextView");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(188362);
  }
  
  public final void setBubbleText(String paramString)
  {
    AppMethodBeat.i(188361);
    p.h(paramString, "text");
    TextView localTextView = this.Krd;
    if (localTextView == null) {
      p.bdF("bubbleTextView");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(188361);
  }
  
  public final void setViewWidth(int paramInt)
  {
    this.gil = paramInt;
  }
  
  public final void show()
  {
    AppMethodBeat.i(188364);
    TextView localTextView = this.Krd;
    if (localTextView == null) {
      p.bdF("bubbleTextView");
    }
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localTextView = this.Krd;
    if (localTextView == null) {
      p.bdF("bubbleTextView");
    }
    this.Kri = localTextView.getMeasuredWidth();
    ae.v("MicroMsg.SearchImageBubbleView", "alvinluo showBubbleView bubbleWidth: %d", new Object[] { Integer.valueOf(this.Kri) });
    if (this.Krh.x > 0)
    {
      fLk();
      AppMethodBeat.o(188364);
      return;
    }
    setVisibility(4);
    this.Krf = true;
    AppMethodBeat.o(188364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView
 * JD-Core Version:    0.7.0.1
 */