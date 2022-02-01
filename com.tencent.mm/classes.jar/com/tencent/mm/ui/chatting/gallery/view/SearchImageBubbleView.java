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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/view/SearchImageBubbleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorViewPosition", "Landroid/graphics/Point;", "anchorViewSize", "bubbleMinWidth", "bubbleTextView", "Landroid/widget/TextView;", "bubbleTriangle", "Landroid/view/View;", "bubbleTriangleWidth", "bubbleViewContainer", "Landroid/view/ViewGroup;", "bubbleViewContainerRightMargin", "bubbleWidth", "mAnchor", "pendingShow", "", "viewWidth", "hide", "", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "anchorView", "setAnchorViewPosition", "x", "y", "setAnchorViewSize", "width", "height", "setBubbleClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBubbleText", "text", "", "setViewWidth", "show", "showByPosition", "showIfNeed", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SearchImageBubbleView
  extends LinearLayout
{
  public static final SearchImageBubbleView.a aeHy;
  private boolean GXN;
  private TextView aeHA;
  private View aeHB;
  private Point aeHC;
  private Point aeHD;
  private int aeHE;
  private int aeHF;
  private int aeHG;
  private int aeHH;
  private ViewGroup aeHz;
  private int mbM;
  private View yw;
  
  static
  {
    AppMethodBeat.i(254717);
    aeHy = new SearchImageBubbleView.a((byte)0);
    AppMethodBeat.o(254717);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(254700);
    AppMethodBeat.o(254700);
  }
  
  public SearchImageBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254706);
    this.GXN = true;
    this.aeHC = new Point(0, 0);
    this.aeHD = new Point(0, 0);
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.gky, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(R.h.fVv);
    s.s(paramAttributeSet, "view.findViewById(R.id.s…h_image_bubble_container)");
    this.aeHz = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(R.h.fVw);
    s.s(paramAttributeSet, "view.findViewById(R.id.search_image_bubble_tips)");
    this.aeHA = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(R.h.fva);
    s.s(paramContext, "view.findViewById(R.id.bubble_triangle)");
    this.aeHB = paramContext;
    this.aeHG = getResources().getDimensionPixelSize(R.f.flE);
    this.aeHF = getResources().getDimensionPixelSize(R.f.flD);
    AppMethodBeat.o(254706);
  }
  
  private final void jwJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(254712);
    setVisibility(0);
    Object localObject1 = getLayoutParams();
    if ((localObject1 != null) && ((localObject1 instanceof ViewGroup.MarginLayoutParams))) {
      this.aeHH = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
    }
    Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showByPosition anchorViewPosition: %s, anchorViewSize: %s, bubbleWidth: %d, viewWidth: %d, bubbleRightMargin: %d", new Object[] { this.aeHD, this.aeHC, Integer.valueOf(this.aeHE), Integer.valueOf(this.mbM), Integer.valueOf(this.aeHH) });
    TextView localTextView = this.aeHA;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("bubbleTextView");
      localObject1 = null;
    }
    localObject1 = ((TextView)localObject1).getLayoutParams();
    int i;
    if ((localObject1 != null) && ((localObject1 instanceof ViewGroup.MarginLayoutParams)))
    {
      i = this.aeHD.x + this.aeHC.x / 2;
      if ((this.aeHE <= this.aeHF) || (this.aeHE + i - this.aeHF / 2 <= this.mbM - this.aeHH)) {
        break label347;
      }
      i = this.mbM;
      int j = this.aeHE;
      int k = this.aeHH;
      i = (int)Math.max(this.mbM / 3.0F, i - j - k);
      if (((ViewGroup.MarginLayoutParams)localObject1).leftMargin != i) {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
      }
    }
    localObject1 = this.aeHB;
    if (localObject1 == null)
    {
      s.bIx("bubbleTriangle");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((View)localObject1).getLayoutParams();
      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup.MarginLayoutParams)))
      {
        i = Math.max(0, this.aeHD.x + this.aeHC.x / 2 - this.aeHG / 2);
        if (((ViewGroup.MarginLayoutParams)localObject1).leftMargin != i) {
          ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
        }
      }
      AppMethodBeat.o(254712);
      return;
      label347:
      i -= this.aeHE / 2;
      break;
    }
  }
  
  public final void aDj(int paramInt)
  {
    this.aeHD.x = paramInt;
    this.aeHD.y = 0;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(254746);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject1;
    if (this.yw != null)
    {
      localObject1 = this.aeHD;
      Object localObject3 = this.yw;
      s.checkNotNull(localObject3);
      ((Point)localObject1).x = ((int)((View)localObject3).getX());
      localObject1 = this.aeHD;
      localObject3 = this.yw;
      s.checkNotNull(localObject3);
      ((Point)localObject1).y = ((int)((View)localObject3).getY());
      Point localPoint = this.aeHD;
      localObject3 = this.aeHA;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bubbleTextView");
        localObject1 = null;
      }
      Log.v("MicroMsg.SearchImageBubbleView", "alvinluo onMeasure anchorViewPos: %s, %d, %d", new Object[] { localPoint, Integer.valueOf(((TextView)localObject1).getMeasuredWidth()), Integer.valueOf(getMeasuredWidth()) });
      if (this.aeHD.x > 0)
      {
        localObject1 = this.aeHA;
        if (localObject1 != null) {
          break label232;
        }
        s.bIx("bubbleTextView");
        localObject1 = localObject2;
      }
    }
    label232:
    for (;;)
    {
      if ((((TextView)localObject1).getMeasuredWidth() >= 0) && (getMeasuredWidth() > 0))
      {
        this.mbM = getMeasuredWidth();
        Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showIfNeed pendingShow: %b", new Object[] { Boolean.valueOf(this.GXN) });
        if (this.GXN)
        {
          this.GXN = false;
          jwJ();
        }
      }
      AppMethodBeat.o(254746);
      return;
    }
  }
  
  public final void ov(int paramInt1, int paramInt2)
  {
    this.aeHC.x = paramInt1;
    this.aeHC.y = paramInt2;
  }
  
  public final void setAnchorView(View paramView)
  {
    this.yw = paramView;
  }
  
  public final void setBubbleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(254741);
    TextView localTextView2 = this.aeHA;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("bubbleTextView");
      localTextView1 = null;
    }
    localTextView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(254741);
  }
  
  public final void setBubbleText(String paramString)
  {
    AppMethodBeat.i(254733);
    s.u(paramString, "text");
    TextView localTextView2 = this.aeHA;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("bubbleTextView");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(254733);
  }
  
  public final void setViewWidth(int paramInt)
  {
    this.mbM = paramInt;
  }
  
  public final void show()
  {
    Object localObject2 = null;
    AppMethodBeat.i(254748);
    TextView localTextView = this.aeHA;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("bubbleTextView");
      localObject1 = null;
    }
    ((TextView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localObject1 = this.aeHA;
    if (localObject1 == null)
    {
      s.bIx("bubbleTextView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.aeHE = ((TextView)localObject1).getMeasuredWidth();
      Log.v("MicroMsg.SearchImageBubbleView", "alvinluo showBubbleView bubbleWidth: %d", new Object[] { Integer.valueOf(this.aeHE) });
      if (this.aeHD.x <= 0) {
        break;
      }
      jwJ();
      AppMethodBeat.o(254748);
      return;
    }
    setVisibility(4);
    this.GXN = true;
    AppMethodBeat.o(254748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView
 * JD-Core Version:    0.7.0.1
 */