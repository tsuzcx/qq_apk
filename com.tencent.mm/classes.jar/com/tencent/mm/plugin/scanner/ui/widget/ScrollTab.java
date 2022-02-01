package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabId", "tabTitle", "Landroid/widget/TextView;", "getTabId", "getTabTitle", "", "init", "", "onTabSelected", "onTabUnselected", "setTabEnabled", "enable", "", "setTabId", "setTabTitle", "Companion", "plugin-scan_release"})
public final class ScrollTab
  extends LinearLayout
  implements a
{
  public static final a IYo;
  private TextView IYn;
  private int fXY;
  
  static
  {
    AppMethodBeat.i(52474);
    IYo = new a((byte)0);
    AppMethodBeat.o(52474);
  }
  
  public ScrollTab(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(52471);
    AppMethodBeat.o(52471);
  }
  
  public ScrollTab(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52472);
    AppMethodBeat.o(52472);
  }
  
  public ScrollTab(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52473);
    this.fXY = -1;
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.IEc, (ViewGroup)this).findViewById(l.f.IDC);
    p.j(paramContext, "view.findViewById(R.id.scroll_tab_title)");
    this.IYn = ((TextView)paramContext);
    paramContext = this.IYn;
    if (paramContext == null) {
      p.bGy("tabTitle");
    }
    paramContext.setAlpha(0.5F);
    AppMethodBeat.o(52473);
  }
  
  public final void fEv()
  {
    AppMethodBeat.i(52469);
    Object localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    Log.d("MicroMsg.ScrollTab", "alvinluo onTabSelected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(l.c.IBW));
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    ((TextView)localObject).setAlpha(1.0F);
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    localObject = ((TextView)localObject).getPaint();
    if (localObject != null) {
      ((TextPaint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
    }
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    localObject = ((TextView)localObject).getPaint();
    if (localObject != null)
    {
      ((TextPaint)localObject).setStrokeWidth(0.8F);
      AppMethodBeat.o(52469);
      return;
    }
    AppMethodBeat.o(52469);
  }
  
  public final void fEw()
  {
    AppMethodBeat.i(52470);
    Object localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    Log.d("MicroMsg.ScrollTab", "alvinluo onTabUnselected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(l.c.IBW));
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    ((TextView)localObject).setAlpha(0.5F);
    localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    localObject = ((TextView)localObject).getPaint();
    if (localObject != null)
    {
      ((TextPaint)localObject).setStyle(Paint.Style.FILL);
      AppMethodBeat.o(52470);
      return;
    }
    AppMethodBeat.o(52470);
  }
  
  public final int getTabId()
  {
    return this.fXY;
  }
  
  public final String getTabTitle()
  {
    AppMethodBeat.i(52467);
    Object localObject = this.IYn;
    if (localObject == null) {
      p.bGy("tabTitle");
    }
    localObject = ((TextView)localObject).getText().toString();
    AppMethodBeat.o(52467);
    return localObject;
  }
  
  public final void setTabEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170093);
    Log.v("MicroMsg.ScrollTab", "alvinluo setTabEnabled %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      setAlpha(1.0F);
      AppMethodBeat.o(170093);
      return;
    }
    setAlpha(0.3F);
    AppMethodBeat.o(170093);
  }
  
  public final void setTabId(int paramInt)
  {
    this.fXY = paramInt;
  }
  
  public final void setTabTitle(String paramString)
  {
    AppMethodBeat.i(52468);
    p.k(paramString, "tabTitle");
    TextView localTextView = this.IYn;
    if (localTextView == null) {
      p.bGy("tabTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52468);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScrollTab
 * JD-Core Version:    0.7.0.1
 */