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
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorViewPosition", "Landroid/graphics/Point;", "anchorViewSize", "bubbleMinWidth", "bubbleTextView", "Landroid/widget/TextView;", "bubbleTriangle", "Landroid/view/View;", "bubbleTriangleWidth", "bubbleViewContainer", "Landroid/view/ViewGroup;", "bubbleViewContainerRightMargin", "bubbleWidth", "mAnchor", "pendingShow", "", "viewWidth", "hide", "", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "anchorView", "setAnchorViewPosition", "x", "y", "setAnchorViewSize", "width", "height", "setBubbleClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBubbleText", "text", "", "setViewWidth", "show", "showByPosition", "showIfNeed", "Companion", "app_release"})
public final class SearchImageBubbleView
  extends LinearLayout
{
  public static final SearchImageBubbleView.a PDu;
  private boolean CCL;
  private ViewGroup PDl;
  private TextView PDm;
  private View PDn;
  private Point PDo;
  private Point PDp;
  private int PDq;
  private int PDr;
  private int PDs;
  private int PDt;
  private View azy;
  private int gRD;
  
  static
  {
    AppMethodBeat.i(231321);
    PDu = new SearchImageBubbleView.a((byte)0);
    AppMethodBeat.o(231321);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(231319);
    AppMethodBeat.o(231319);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(231320);
    this.CCL = true;
    this.PDo = new Point(0, 0);
    this.PDp = new Point(0, 0);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495064, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307392);
    p.g(paramAttributeSet, "view.findViewById(R.id.s…h_image_bubble_container)");
    this.PDl = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307393);
    p.g(paramAttributeSet, "view.findViewById(R.id.search_image_bubble_tips)");
    this.PDm = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131297856);
    p.g(paramContext, "view.findViewById(R.id.bubble_triangle)");
    this.PDn = paramContext;
    this.PDs = getResources().getDimensionPixelSize(2131166062);
    this.PDr = getResources().getDimensionPixelSize(2131166059);
    AppMethodBeat.o(231320);
  }
  
  private final void gTC()
  {
    AppMethodBeat.i(231318);
    setVisibility(0);
    z.d locald = new z.d();
    Object localObject = getLayoutParams();
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams))) {
      this.PDt = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
    }
    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showByPosition anchorViewPosition: %s, anchorViewSize: %s, bubbleWidth: %d, viewWidth: %d, bubbleRightMargin: %d", new Object[] { this.PDp, this.PDo, Integer.valueOf(this.PDq), Integer.valueOf(this.gRD), Integer.valueOf(this.PDt) });
    localObject = this.PDm;
    if (localObject == null) {
      p.btv("bubbleTextView");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    int i;
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
    {
      i = this.PDp.x + this.PDo.x / 2;
      if ((this.PDq <= this.PDr) || (this.PDq + i - this.PDr / 2 <= this.gRD - this.PDt)) {
        break label341;
      }
      locald.SYE = (this.gRD - this.PDq - this.PDt);
    }
    label341:
    for (locald.SYE = ((int)Math.max(this.gRD / 3.0F, locald.SYE));; locald.SYE = (i - this.PDq / 2))
    {
      if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.SYE) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.SYE;
      }
      localObject = this.PDn;
      if (localObject == null) {
        p.btv("bubbleTriangle");
      }
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null) {
        break;
      }
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        locald.SYE = Math.max(0, this.PDp.x + this.PDo.x / 2 - this.PDs / 2);
        if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.SYE) {
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.SYE;
        }
      }
      AppMethodBeat.o(231318);
      return;
    }
    AppMethodBeat.o(231318);
  }
  
  public final void lj(int paramInt1, int paramInt2)
  {
    this.PDo.x = paramInt1;
    this.PDo.y = paramInt2;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231316);
    super.onMeasure(paramInt1, paramInt2);
    if (this.azy != null)
    {
      Object localObject1 = this.PDp;
      Object localObject2 = this.azy;
      if (localObject2 == null) {
        p.hyc();
      }
      ((Point)localObject1).x = ((int)((View)localObject2).getX());
      localObject1 = this.PDp;
      localObject2 = this.azy;
      if (localObject2 == null) {
        p.hyc();
      }
      ((Point)localObject1).y = ((int)((View)localObject2).getY());
      localObject1 = this.PDp;
      localObject2 = this.PDm;
      if (localObject2 == null) {
        p.btv("bubbleTextView");
      }
      Log.v("MicroMsg.SearchImageBubbleView", "alvinluo onMeasure anchorViewPos: %s, %d, %d", new Object[] { localObject1, Integer.valueOf(((TextView)localObject2).getMeasuredWidth()), Integer.valueOf(getMeasuredWidth()) });
      if (this.PDp.x > 0)
      {
        localObject1 = this.PDm;
        if (localObject1 == null) {
          p.btv("bubbleTextView");
        }
        if ((((TextView)localObject1).getMeasuredWidth() >= 0) && (getMeasuredWidth() > 0))
        {
          this.gRD = getMeasuredWidth();
          Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showIfNeed pendingShow: %b", new Object[] { Boolean.valueOf(this.CCL) });
          if (this.CCL)
          {
            this.CCL = false;
            gTC();
          }
        }
      }
    }
    AppMethodBeat.o(231316);
  }
  
  public final void setAnchorView(View paramView)
  {
    this.azy = paramView;
  }
  
  public final void setAnchorViewPosition$255f295(int paramInt)
  {
    this.PDp.x = paramInt;
    this.PDp.y = 0;
  }
  
  public final void setBubbleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231315);
    TextView localTextView = this.PDm;
    if (localTextView == null) {
      p.btv("bubbleTextView");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(231315);
  }
  
  public final void setBubbleText(String paramString)
  {
    AppMethodBeat.i(231314);
    p.h(paramString, "text");
    TextView localTextView = this.PDm;
    if (localTextView == null) {
      p.btv("bubbleTextView");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(231314);
  }
  
  public final void setViewWidth(int paramInt)
  {
    this.gRD = paramInt;
  }
  
  public final void show()
  {
    AppMethodBeat.i(231317);
    TextView localTextView = this.PDm;
    if (localTextView == null) {
      p.btv("bubbleTextView");
    }
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localTextView = this.PDm;
    if (localTextView == null) {
      p.btv("bubbleTextView");
    }
    this.PDq = localTextView.getMeasuredWidth();
    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showBubbleView bubbleWidth: %d", new Object[] { Integer.valueOf(this.PDq) });
    if (this.PDp.x > 0)
    {
      gTC();
      AppMethodBeat.o(231317);
      return;
    }
    setVisibility(4);
    this.CCL = true;
    AppMethodBeat.o(231317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView
 * JD-Core Version:    0.7.0.1
 */