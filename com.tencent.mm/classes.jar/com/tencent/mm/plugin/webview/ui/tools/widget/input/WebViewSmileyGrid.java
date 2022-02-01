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
import com.tencent.mm.cf.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.z;

public class WebViewSmileyGrid
  extends GridView
{
  private c EsP;
  a EsQ;
  AdapterView.OnItemClickListener awt;
  int nif;
  int nig;
  int nih;
  int nii;
  int nij;
  int nik;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.nig = 0;
    this.nii = 0;
    this.nij = 0;
    this.nik = 0;
    this.awt = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).EsW != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).EsW.aoO();
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
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).EsW != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).EsW;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(e.fmZ().wA(i * (j - 1) + paramAnonymousInt));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.nii;
  }
  
  public void setPanelManager(c paramc)
  {
    this.EsP = paramc;
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
        paramView = z.jO(WebViewSmileyGrid.this.getContext()).inflate(2131496089, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).nit - com.tencent.mm.cc.a.ax(WebViewSmileyGrid.this.getContext(), 2131165490) - com.tencent.mm.cc.a.ax(WebViewSmileyGrid.this.getContext(), 2131166250)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label159;
        }
        paramViewGroup.lZa.setImageResource(2131231885);
        paramViewGroup.lZa.setContentDescription(WebViewSmileyGrid.this.getContext().getString(2131758032));
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
          paramViewGroup.lZa.setImageDrawable(null);
        }
        else
        {
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          Drawable localDrawable = e.fmZ().wy(paramInt);
          paramViewGroup.lZa.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */