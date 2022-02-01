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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.smiley.o;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.ui.af;

public class WebViewSmileyGrid
  extends GridView
{
  private c Xsf;
  a Xsi;
  int Xsj;
  int Xsk;
  int Xsl;
  int Xsm;
  int Xsn;
  int uQL;
  AdapterView.OnItemClickListener vT;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.Xsk = 0;
    this.Xsl = 0;
    this.Xsm = 0;
    this.Xsn = 0;
    this.vT = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).Xsu != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).Xsu.aWM();
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
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).Xsu != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).Xsu;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(c.iCQ().ays(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.Xsl;
  }
  
  public void setPanelManager(c paramc)
  {
    this.Xsf = paramc;
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
        localView = af.mU(WebViewSmileyGrid.this.getContext()).inflate(c.g.webview_smiley_grid_item, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).Xsv - com.tencent.mm.cd.a.br(WebViewSmileyGrid.this.getContext(), c.d.LittlePadding) - com.tencent.mm.cd.a.br(WebViewSmileyGrid.this.getContext(), c.d.emoji_panel_tab_height)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(localView);
        localView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label172;
        }
        paramViewGroup.ttT.setImageResource(c.e.del_btn);
        paramViewGroup.ttT.setContentDescription(WebViewSmileyGrid.this.getContext().getString(c.i.delete_btn));
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
        paramViewGroup.ttT.setImageDrawable(null);
      }
      label216:
      WebViewSmileyGrid.b(WebViewSmileyGrid.this);
      paramView = c.iCQ();
      if (paramView.acys == null)
      {
        Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.ttT.setImageDrawable(paramView);
        break;
        paramView = (SmileyPanelConfigInfo)paramView.acys.get(paramInt);
        if (paramView == null)
        {
          Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
          paramView = null;
        }
        else
        {
          paramView = o.buC(paramView.field_key);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */