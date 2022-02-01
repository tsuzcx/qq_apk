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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedColor", "drawableStateChanged", "", "switchNormalState", "switchPressState", "Companion", "plugin-webview_release"})
public final class BrowserIconImageView
  extends AppCompatImageView
{
  public static final a QjA;
  private int Qjz;
  
  static
  {
    AppMethodBeat.i(268115);
    QjA = new a((byte)0);
    AppMethodBeat.o(268115);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(268113);
    AppMethodBeat.o(268113);
  }
  
  public BrowserIconImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(268114);
    this.Qjz = getResources().getColor(c.c.UN_BW_0_Alpha_0_1);
    AppMethodBeat.o(268114);
  }
  
  private final void gZL()
  {
    AppMethodBeat.i(268112);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localDrawable = localDrawable.mutate();
      if (localDrawable != null)
      {
        localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(268112);
        return;
      }
    }
    AppMethodBeat.o(268112);
  }
  
  public final void drawableStateChanged()
  {
    AppMethodBeat.i(268111);
    super.drawableStateChanged();
    if ((!isEnabled()) || (!isFocusable()))
    {
      gZL();
      AppMethodBeat.o(268111);
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
          localDrawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(this.Qjz, PorterDuff.Mode.SRC_ATOP));
          AppMethodBeat.o(268111);
          return;
        }
      }
      AppMethodBeat.o(268111);
      return;
    }
    gZL();
    AppMethodBeat.o(268111);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserIconImageView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserIconImageView
 * JD-Core Version:    0.7.0.1
 */