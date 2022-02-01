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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorViewPosition", "Landroid/graphics/Point;", "anchorViewSize", "bubbleMinWidth", "bubbleTextView", "Landroid/widget/TextView;", "bubbleTriangle", "Landroid/view/View;", "bubbleTriangleWidth", "bubbleViewContainer", "Landroid/view/ViewGroup;", "bubbleViewContainerRightMargin", "bubbleWidth", "mAnchor", "pendingShow", "", "viewWidth", "hide", "", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "anchorView", "setAnchorViewPosition", "x", "y", "setAnchorViewSize", "width", "height", "setBubbleClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBubbleText", "text", "", "setViewWidth", "show", "showByPosition", "showIfNeed", "Companion", "app_release"})
public final class SearchImageBubbleView
  extends LinearLayout
{
  public static final SearchImageBubbleView.a WYh;
  private boolean Brn;
  private ViewGroup WXY;
  private TextView WXZ;
  private View WYa;
  private Point WYb;
  private Point WYc;
  private int WYd;
  private int WYe;
  private int WYf;
  private int WYg;
  private int jBZ;
  private View xB;
  
  static
  {
    AppMethodBeat.i(271023);
    WYh = new SearchImageBubbleView.a((byte)0);
    AppMethodBeat.o(271023);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(271021);
    AppMethodBeat.o(271021);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(271022);
    this.Brn = true;
    this.WYb = new Point(0, 0);
    this.WYc = new Point(0, 0);
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.ehD, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(R.h.dTn);
    p.j(paramAttributeSet, "view.findViewById(R.id.s…h_image_bubble_container)");
    this.WXY = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(R.h.dTo);
    p.j(paramAttributeSet, "view.findViewById(R.id.search_image_bubble_tips)");
    this.WXZ = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(R.h.duI);
    p.j(paramContext, "view.findViewById(R.id.bubble_triangle)");
    this.WYa = paramContext;
    this.WYf = getResources().getDimensionPixelSize(R.f.dlo);
    this.WYe = getResources().getDimensionPixelSize(R.f.dln);
    AppMethodBeat.o(271022);
  }
  
  private final void hTi()
  {
    AppMethodBeat.i(271020);
    setVisibility(0);
    aa.d locald = new aa.d();
    Object localObject = getLayoutParams();
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams))) {
      this.WYg = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
    }
    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showByPosition anchorViewPosition: %s, anchorViewSize: %s, bubbleWidth: %d, viewWidth: %d, bubbleRightMargin: %d", new Object[] { this.WYc, this.WYb, Integer.valueOf(this.WYd), Integer.valueOf(this.jBZ), Integer.valueOf(this.WYg) });
    localObject = this.WXZ;
    if (localObject == null) {
      p.bGy("bubbleTextView");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    int i;
    if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
    {
      i = this.WYc.x + this.WYb.x / 2;
      if ((this.WYd <= this.WYe) || (this.WYd + i - this.WYe / 2 <= this.jBZ - this.WYg)) {
        break label342;
      }
      locald.aaBA = (this.jBZ - this.WYd - this.WYg);
    }
    label342:
    for (locald.aaBA = ((int)Math.max(this.jBZ / 3.0F, locald.aaBA));; locald.aaBA = (i - this.WYd / 2))
    {
      if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.aaBA) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.aaBA;
      }
      localObject = this.WYa;
      if (localObject == null) {
        p.bGy("bubbleTriangle");
      }
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null) {
        break;
      }
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        locald.aaBA = Math.max(0, this.WYc.x + this.WYb.x / 2 - this.WYf / 2);
        if (((ViewGroup.MarginLayoutParams)localObject).leftMargin != locald.aaBA) {
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = locald.aaBA;
        }
      }
      AppMethodBeat.o(271020);
      return;
    }
    AppMethodBeat.o(271020);
  }
  
  public final void awA(int paramInt)
  {
    this.WYc.x = paramInt;
    this.WYc.y = 0;
  }
  
  public final void mB(int paramInt1, int paramInt2)
  {
    this.WYb.x = paramInt1;
    this.WYb.y = paramInt2;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271018);
    super.onMeasure(paramInt1, paramInt2);
    if (this.xB != null)
    {
      Object localObject1 = this.WYc;
      Object localObject2 = this.xB;
      if (localObject2 == null) {
        p.iCn();
      }
      ((Point)localObject1).x = ((int)((View)localObject2).getX());
      localObject1 = this.WYc;
      localObject2 = this.xB;
      if (localObject2 == null) {
        p.iCn();
      }
      ((Point)localObject1).y = ((int)((View)localObject2).getY());
      localObject1 = this.WYc;
      localObject2 = this.WXZ;
      if (localObject2 == null) {
        p.bGy("bubbleTextView");
      }
      Log.v("MicroMsg.SearchImageBubbleView", "alvinluo onMeasure anchorViewPos: %s, %d, %d", new Object[] { localObject1, Integer.valueOf(((TextView)localObject2).getMeasuredWidth()), Integer.valueOf(getMeasuredWidth()) });
      if (this.WYc.x > 0)
      {
        localObject1 = this.WXZ;
        if (localObject1 == null) {
          p.bGy("bubbleTextView");
        }
        if ((((TextView)localObject1).getMeasuredWidth() >= 0) && (getMeasuredWidth() > 0))
        {
          this.jBZ = getMeasuredWidth();
          Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showIfNeed pendingShow: %b", new Object[] { Boolean.valueOf(this.Brn) });
          if (this.Brn)
          {
            this.Brn = false;
            hTi();
          }
        }
      }
    }
    AppMethodBeat.o(271018);
  }
  
  public final void setAnchorView(View paramView)
  {
    this.xB = paramView;
  }
  
  public final void setBubbleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(271017);
    TextView localTextView = this.WXZ;
    if (localTextView == null) {
      p.bGy("bubbleTextView");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(271017);
  }
  
  public final void setBubbleText(String paramString)
  {
    AppMethodBeat.i(271016);
    p.k(paramString, "text");
    TextView localTextView = this.WXZ;
    if (localTextView == null) {
      p.bGy("bubbleTextView");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(271016);
  }
  
  public final void setViewWidth(int paramInt)
  {
    this.jBZ = paramInt;
  }
  
  public final void show()
  {
    AppMethodBeat.i(271019);
    TextView localTextView = this.WXZ;
    if (localTextView == null) {
      p.bGy("bubbleTextView");
    }
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localTextView = this.WXZ;
    if (localTextView == null) {
      p.bGy("bubbleTextView");
    }
    this.WYd = localTextView.getMeasuredWidth();
    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showBubbleView bubbleWidth: %d", new Object[] { Integer.valueOf(this.WYd) });
    if (this.WYc.x > 0)
    {
      hTi();
      AppMethodBeat.o(271019);
      return;
    }
    setVisibility(4);
    this.Brn = true;
    AppMethodBeat.o(271019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView
 * JD-Core Version:    0.7.0.1
 */