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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabId", "tabTitle", "Landroid/widget/TextView;", "getTabId", "getTabTitle", "", "init", "", "onTabSelected", "onTabUnselected", "setTabEnabled", "enable", "", "setTabId", "setTabTitle", "Companion", "plugin-scan_release"})
public final class ScrollTab
  extends LinearLayout
  implements a
{
  public static final a vZP;
  private int qfh;
  private TextView vZO;
  
  static
  {
    AppMethodBeat.i(52474);
    vZP = new a((byte)0);
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
    this.qfh = -1;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494572, (ViewGroup)this).findViewById(2131304374);
    k.g(paramContext, "view.findViewById(R.id.scroll_tab_title)");
    this.vZO = ((TextView)paramContext);
    paramContext = this.vZO;
    if (paramContext == null) {
      k.aPZ("tabTitle");
    }
    paramContext.setAlpha(0.5F);
    AppMethodBeat.o(52473);
  }
  
  public final void dmM()
  {
    AppMethodBeat.i(52469);
    Object localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ad.d("MicroMsg.ScrollTab", "alvinluo onTabSelected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131100833));
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ((TextView)localObject).setAlpha(1.0F);
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    localObject = ((TextView)localObject).getPaint();
    if (localObject != null) {
      ((TextPaint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
    }
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
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
  
  public final void dmN()
  {
    AppMethodBeat.i(52470);
    Object localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ad.d("MicroMsg.ScrollTab", "alvinluo onTabUnselected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131100833));
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    ((TextView)localObject).setAlpha(0.5F);
    localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
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
    return this.qfh;
  }
  
  public final String getTabTitle()
  {
    AppMethodBeat.i(52467);
    Object localObject = this.vZO;
    if (localObject == null) {
      k.aPZ("tabTitle");
    }
    localObject = ((TextView)localObject).getText().toString();
    AppMethodBeat.o(52467);
    return localObject;
  }
  
  public final void setTabEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170093);
    ad.v("MicroMsg.ScrollTab", "alvinluo setTabEnabled %b", new Object[] { Boolean.valueOf(paramBoolean) });
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
    this.qfh = paramInt;
  }
  
  public final void setTabTitle(String paramString)
  {
    AppMethodBeat.i(52468);
    k.h(paramString, "tabTitle");
    TextView localTextView = this.vZO;
    if (localTextView == null) {
      k.aPZ("tabTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52468);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScrollTab
 * JD-Core Version:    0.7.0.1
 */