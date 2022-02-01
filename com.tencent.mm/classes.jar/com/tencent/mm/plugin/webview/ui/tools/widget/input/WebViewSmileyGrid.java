package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aa;

public class WebViewSmileyGrid
  extends GridView
{
  private c JBa;
  a JBb;
  AdapterView.OnItemClickListener awr;
  int gOF;
  int owU;
  int owV;
  int owW;
  int owX;
  int owY;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.owV = 0;
    this.owX = 0;
    this.owY = 0;
    this.gOF = 0;
    this.awr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).JBh != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).JBh.aHC();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(82338);
          return;
        }
        if (WebViewSmileyGrid.c(WebViewSmileyGrid.this) * (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) + paramAnonymousInt >= WebViewSmileyGrid.e(WebViewSmileyGrid.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(82338);
          return;
        }
        int i = WebViewSmileyGrid.c(WebViewSmileyGrid.this);
        int j = WebViewSmileyGrid.d(WebViewSmileyGrid.this);
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).JBh != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).JBh;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(e.gxR().An(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.owX;
  }
  
  public void setPanelManager(c paramc)
  {
    this.JBa = paramc;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(82339);
      int i = WebViewSmileyGrid.d(WebViewSmileyGrid.this);
      AppMethodBeat.o(82339);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(82340);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = aa.jQ(WebViewSmileyGrid.this.getContext()).inflate(2131497077, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).oxh - com.tencent.mm.cb.a.aG(WebViewSmileyGrid.this.getContext(), 2131165508) - com.tencent.mm.cb.a.aG(WebViewSmileyGrid.this.getContext(), 2131166293)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label159;
        }
        paramViewGroup.nnL.setImageResource(2131231968);
        paramViewGroup.nnL.setContentDescription(WebViewSmileyGrid.this.getContext().getString(2131758284));
      }
      for (;;)
      {
        AppMethodBeat.o(82340);
        return paramView;
        paramViewGroup = (WebViewSmileyGrid.b)paramView.getTag();
        break;
        label159:
        paramInt = (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) * WebViewSmileyGrid.c(WebViewSmileyGrid.this) + paramInt;
        if (paramInt > WebViewSmileyGrid.e(WebViewSmileyGrid.this) - 1)
        {
          paramViewGroup.nnL.setImageDrawable(null);
        }
        else
        {
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          Drawable localDrawable = e.gxR().Al(paramInt);
          paramViewGroup.nnL.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */