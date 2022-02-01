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
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabId", "tabTitle", "Landroid/widget/TextView;", "getTabId", "getTabTitle", "", "init", "", "onTabSelected", "onTabUnselected", "setTabEnabled", "enable", "", "setTabId", "setTabTitle", "Companion", "plugin-scan_release"})
public final class ScrollTab
  extends LinearLayout
  implements a
{
  public static final a CSW;
  private TextView CSV;
  private int ehn;
  
  static
  {
    AppMethodBeat.i(52474);
    CSW = new a((byte)0);
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
    this.ehn = -1;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495195, (ViewGroup)this).findViewById(2131307337);
    p.g(paramContext, "view.findViewById(R.id.scroll_tab_title)");
    this.CSV = ((TextView)paramContext);
    paramContext = this.CSV;
    if (paramContext == null) {
      p.btv("tabTitle");
    }
    paramContext.setAlpha(0.5F);
    AppMethodBeat.o(52473);
  }
  
  public final void eRu()
  {
    AppMethodBeat.i(52469);
    Object localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    Log.d("MicroMsg.ScrollTab", "alvinluo onTabSelected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131101031));
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    ((TextView)localObject).setAlpha(1.0F);
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    localObject = ((TextView)localObject).getPaint();
    if (localObject != null) {
      ((TextPaint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
    }
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
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
  
  public final void eRv()
  {
    AppMethodBeat.i(52470);
    Object localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    Log.d("MicroMsg.ScrollTab", "alvinluo onTabUnselected %s", new Object[] { ((TextView)localObject).getText() });
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131101031));
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
    }
    ((TextView)localObject).setAlpha(0.5F);
    localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
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
    return this.ehn;
  }
  
  public final String getTabTitle()
  {
    AppMethodBeat.i(52467);
    Object localObject = this.CSV;
    if (localObject == null) {
      p.btv("tabTitle");
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
    this.ehn = paramInt;
  }
  
  public final void setTabTitle(String paramString)
  {
    AppMethodBeat.i(52468);
    p.h(paramString, "tabTitle");
    TextView localTextView = this.CSV;
    if (localTextView == null) {
      p.btv("tabTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52468);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScrollTab
 * JD-Core Version:    0.7.0.1
 */