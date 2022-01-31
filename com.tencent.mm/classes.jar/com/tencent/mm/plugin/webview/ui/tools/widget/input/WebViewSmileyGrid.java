package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cd.e;
import com.tencent.mm.ui.w;

public class WebViewSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener amh;
  int jpP;
  int jpQ;
  int jpR;
  int jpS;
  int jpT;
  int jpU;
  private c vtC;
  a vtD;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10108);
    this.jpQ = 0;
    this.jpS = 0;
    this.jpT = 0;
    this.jpU = 0;
    this.amh = new WebViewSmileyGrid.1(this);
    AppMethodBeat.o(10108);
  }
  
  int getRowSpacing()
  {
    return this.jpS;
  }
  
  public void setPanelManager(c paramc)
  {
    this.vtC = paramc;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(10105);
      int i = WebViewSmileyGrid.d(WebViewSmileyGrid.this);
      AppMethodBeat.o(10105);
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
      AppMethodBeat.i(10106);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = w.hM(WebViewSmileyGrid.this.getContext()).inflate(2130971307, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).jqe - a.ao(WebViewSmileyGrid.this.getContext(), 2131427782) - a.ao(WebViewSmileyGrid.this.getContext(), 2131428385)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label161;
        }
        paramViewGroup.ivs.setImageResource(2130838499);
        paramViewGroup.ivs.setContentDescription(WebViewSmileyGrid.this.getContext().getString(2131298947));
      }
      for (;;)
      {
        AppMethodBeat.o(10106);
        return paramView;
        paramViewGroup = (WebViewSmileyGrid.b)paramView.getTag();
        break;
        label161:
        paramInt = (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) * WebViewSmileyGrid.c(WebViewSmileyGrid.this) + paramInt;
        if (paramInt > WebViewSmileyGrid.e(WebViewSmileyGrid.this) - 1)
        {
          paramViewGroup.ivs.setImageDrawable(null);
        }
        else
        {
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          Drawable localDrawable = e.dve().qA(paramInt);
          paramViewGroup.ivs.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */