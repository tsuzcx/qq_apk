package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
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
import com.tencent.mm.cl.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.ui.ad;

public class WebViewSmileyGrid
  extends GridView
{
  private c Qzm;
  a Qzp;
  int Qzq;
  int Qzr;
  int Qzs;
  int Qzt;
  int jyZ;
  int rFz;
  AdapterView.OnItemClickListener uX;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.Qzr = 0;
    this.Qzs = 0;
    this.Qzt = 0;
    this.jyZ = 0;
    this.uX = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).QzA != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).QzA.aDO();
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
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).QzA != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).QzA;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(c.hcq().asi(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.Qzs;
  }
  
  public void setPanelManager(c paramc)
  {
    this.Qzm = paramc;
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
      View localView;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localView = ad.kS(WebViewSmileyGrid.this.getContext()).inflate(c.g.webview_smiley_grid_item, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).QzB - com.tencent.mm.ci.a.aY(WebViewSmileyGrid.this.getContext(), c.d.LittlePadding) - com.tencent.mm.ci.a.aY(WebViewSmileyGrid.this.getContext(), c.d.emoji_panel_tab_height)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(localView);
        localView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label172;
        }
        paramViewGroup.qps.setImageResource(c.e.del_btn);
        paramViewGroup.qps.setContentDescription(WebViewSmileyGrid.this.getContext().getString(c.i.delete_btn));
      }
      for (;;)
      {
        AppMethodBeat.o(82340);
        return localView;
        paramViewGroup = (WebViewSmileyGrid.b)paramView.getTag();
        localView = paramView;
        break;
        label172:
        paramInt = (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) * WebViewSmileyGrid.c(WebViewSmileyGrid.this) + paramInt;
        if (paramInt <= WebViewSmileyGrid.e(WebViewSmileyGrid.this) - 1) {
          break label216;
        }
        paramViewGroup.qps.setImageDrawable(null);
      }
      label216:
      WebViewSmileyGrid.b(WebViewSmileyGrid.this);
      paramView = c.hcq();
      if (paramView.UYB == null)
      {
        Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.qps.setImageDrawable(paramView);
        break;
        paramView = (SmileyPanelConfigInfo)paramView.UYB.get(paramInt);
        if (paramView == null)
        {
          Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
          paramView = null;
        }
        else
        {
          paramView = f.buv(paramView.field_key);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */