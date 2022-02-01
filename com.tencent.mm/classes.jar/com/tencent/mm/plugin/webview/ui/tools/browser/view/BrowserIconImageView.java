package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedColor", "drawableStateChanged", "", "switchNormalState", "switchPressState", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BrowserIconImageView
  extends AppCompatImageView
{
  public static final BrowserIconImageView.a Xbu;
  private int Xbv;
  
  static
  {
    AppMethodBeat.i(296625);
    Xbu = new BrowserIconImageView.a((byte)0);
    AppMethodBeat.o(296625);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(296594);
    AppMethodBeat.o(296594);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(296603);
    this.Xbv = getResources().getColor(c.c.UN_BW_0_Alpha_0_1);
    AppMethodBeat.o(296603);
  }
  
  private final void izO()
  {
    AppMethodBeat.i(296614);
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {}
    for (localDrawable = null;; localDrawable = localDrawable.mutate())
    {
      if (localDrawable != null) {
        localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
      }
      AppMethodBeat.o(296614);
      return;
    }
  }
  
  public final void drawableStateChanged()
  {
    AppMethodBeat.i(296631);
    super.drawableStateChanged();
    if ((!isEnabled()) || (!isFocusable()))
    {
      izO();
      AppMethodBeat.o(296631);
      return;
    }
    if (isPressed())
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable == null) {}
      for (localDrawable = null;; localDrawable = localDrawable.mutate())
      {
        if (localDrawable != null) {
          localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(this.Xbv, PorterDuff.Mode.SRC_ATOP));
        }
        AppMethodBeat.o(296631);
        return;
      }
    }
    izO();
    AppMethodBeat.o(296631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserIconImageView
 * JD-Core Version:    0.7.0.1
 */