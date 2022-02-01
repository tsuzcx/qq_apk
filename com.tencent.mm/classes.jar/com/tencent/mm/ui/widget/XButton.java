package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/XButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setVisibility", "", "visibility", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class XButton
  extends AppCompatButton
{
  public XButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251584);
    AppMethodBeat.o(251584);
  }
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(251592);
    int i = getVisibility();
    if (paramInt != i)
    {
      if ((i == 4) && (paramInt == 0))
      {
        super.setVisibility(paramInt);
        com.tencent.mm.ui.anim.b.a.a((View)this, k.z(0.0D, 1.0D));
        AppMethodBeat.o(251592);
        return;
      }
      if ((i == 8) && (paramInt == 0))
      {
        super.setVisibility(paramInt);
        com.tencent.mm.ui.anim.b.a.a((View)this, k.z(0.0D, 1.0D));
        AppMethodBeat.o(251592);
        return;
      }
      if (i == 0) {
        com.tencent.mm.ui.anim.b.a.a((View)this, k.z(1.0D, 0.0D), (kotlin.g.a.a)new a(this, paramInt));
      }
    }
    AppMethodBeat.o(251592);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(XButton paramXButton, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.XButton
 * JD-Core Version:    0.7.0.1
 */