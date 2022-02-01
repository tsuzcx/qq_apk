package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedColor", "drawableStateChanged", "", "switchNormalState", "switchPressState", "Companion", "plugin-webview_release"})
public final class BrowserIconImageView
  extends AppCompatImageView
{
  public static final a Jmj;
  private int Jmi;
  
  static
  {
    AppMethodBeat.i(210468);
    Jmj = new a((byte)0);
    AppMethodBeat.o(210468);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(210466);
    AppMethodBeat.o(210466);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210467);
    this.Jmi = getResources().getColor(2131099832);
    AppMethodBeat.o(210467);
  }
  
  private final void ggw()
  {
    AppMethodBeat.i(210465);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localDrawable = localDrawable.mutate();
      if (localDrawable != null)
      {
        localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(210465);
        return;
      }
    }
    AppMethodBeat.o(210465);
  }
  
  public final void drawableStateChanged()
  {
    AppMethodBeat.i(210464);
    super.drawableStateChanged();
    if ((!isEnabled()) || (!isFocusable()))
    {
      ggw();
      AppMethodBeat.o(210464);
      return;
    }
    if (isPressed())
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.mutate();
        if (localDrawable != null)
        {
          localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(this.Jmi, PorterDuff.Mode.SRC_ATOP));
          AppMethodBeat.o(210464);
          return;
        }
      }
      AppMethodBeat.o(210464);
      return;
    }
    ggw();
    AppMethodBeat.o(210464);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserIconImageView
 * JD-Core Version:    0.7.0.1
 */