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
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTab;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabId", "tabTitle", "Landroid/widget/TextView;", "getTabId", "getTabTitle", "", "init", "", "onTabSelected", "onTabUnselected", "setTabEnabled", "enable", "", "setTabId", "setTabTitle", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScrollTab
  extends LinearLayout
  implements a
{
  public static final ScrollTab.a PhL;
  private TextView PhM;
  private int idY;
  
  static
  {
    AppMethodBeat.i(52474);
    PhL = new ScrollTab.a((byte)0);
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
    this.idY = -1;
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.OKf, (ViewGroup)this).findViewById(l.f.OJE);
    s.s(paramContext, "view.findViewById(R.id.scroll_tab_title)");
    this.PhM = ((TextView)paramContext);
    paramAttributeSet = this.PhM;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("tabTitle");
      paramContext = null;
    }
    paramContext.setAlpha(0.5F);
    AppMethodBeat.o(52473);
  }
  
  public final void gTi()
  {
    Object localObject2 = null;
    AppMethodBeat.i(52469);
    Object localObject3 = new StringBuilder();
    TextView localTextView = this.PhM;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    localObject3 = ((TextView)localObject1).getText() + getContext().getString(l.i.OLy);
    StringBuilder localStringBuilder = new StringBuilder("alvinluo onTabSelected ");
    localTextView = this.PhM;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    Log.d("MicroMsg.ScrollTab", ((TextView)localObject1).getText() + "  desc:" + (String)localObject3);
    localTextView = this.PhM;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(l.c.OHY));
    localTextView = this.PhM;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setContentDescription((CharSequence)localObject3);
    localTextView = this.PhM;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setAlpha(1.0F);
    localTextView = this.PhM;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    localObject1 = ((TextView)localObject1).getPaint();
    if (localObject1 != null) {
      ((TextPaint)localObject1).setStyle(Paint.Style.FILL_AND_STROKE);
    }
    localObject1 = this.PhM;
    if (localObject1 == null)
    {
      s.bIx("tabTitle");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((TextView)localObject1).getPaint();
      if (localObject1 != null) {
        ((TextPaint)localObject1).setStrokeWidth(0.8F);
      }
      AppMethodBeat.o(52469);
      return;
    }
  }
  
  public final void gTj()
  {
    Object localObject3 = null;
    AppMethodBeat.i(52470);
    Object localObject4 = new StringBuilder("alvinluo onTabUnselected ");
    Object localObject2 = this.PhM;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    localObject4 = ((StringBuilder)localObject4).append(((TextView)localObject1).getText()).append("  desc:");
    localObject2 = this.PhM;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    Log.d("MicroMsg.ScrollTab", ((TextView)localObject1).getText());
    localObject2 = this.PhM;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(l.c.OHY));
    localObject2 = this.PhM;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    localObject4 = this.PhM;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("tabTitle");
      localObject2 = null;
    }
    ((TextView)localObject1).setContentDescription(((TextView)localObject2).getText());
    localObject2 = this.PhM;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("tabTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setAlpha(0.5F);
    localObject1 = this.PhM;
    if (localObject1 == null)
    {
      s.bIx("tabTitle");
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject1 = ((TextView)localObject1).getPaint();
      if (localObject1 != null) {
        ((TextPaint)localObject1).setStyle(Paint.Style.FILL);
      }
      AppMethodBeat.o(52470);
      return;
    }
  }
  
  public final int getTabId()
  {
    return this.idY;
  }
  
  public final String getTabTitle()
  {
    AppMethodBeat.i(52467);
    TextView localTextView = this.PhM;
    Object localObject = localTextView;
    if (localTextView == null)
    {
      s.bIx("tabTitle");
      localObject = null;
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
    this.idY = paramInt;
  }
  
  public final void setTabTitle(String paramString)
  {
    AppMethodBeat.i(52468);
    s.u(paramString, "tabTitle");
    TextView localTextView2 = this.PhM;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("tabTitle");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(52468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScrollTab
 * JD-Core Version:    0.7.0.1
 */