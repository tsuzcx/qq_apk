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
import com.tencent.mm.cc.a;
import com.tencent.mm.cf.e;
import com.tencent.mm.ui.z;

public class WebViewSmileyGrid
  extends GridView
{
  private c COP;
  a COQ;
  AdapterView.OnItemClickListener auB;
  int mHH;
  int mHI;
  int mHJ;
  int mHK;
  int mHL;
  int mHM;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.mHI = 0;
    this.mHK = 0;
    this.mHL = 0;
    this.mHM = 0;
    this.auB = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).COW != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).COW.amb();
          }
          AppMethodBeat.o(82338);
          return;
        }
        if (WebViewSmileyGrid.c(WebViewSmileyGrid.this) * (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) + paramAnonymousInt >= WebViewSmileyGrid.e(WebViewSmileyGrid.this))
        {
          AppMethodBeat.o(82338);
          return;
        }
        int i = WebViewSmileyGrid.c(WebViewSmileyGrid.this);
        int j = WebViewSmileyGrid.d(WebViewSmileyGrid.this);
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).COW != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).COW;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(e.eXp().vV(i * (j - 1) + paramAnonymousInt));
        }
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.mHK;
  }
  
  public void setPanelManager(c paramc)
  {
    this.COP = paramc;
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
        paramView = z.jD(WebViewSmileyGrid.this.getContext()).inflate(2131496089, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).mHV - a.au(WebViewSmileyGrid.this.getContext(), 2131165490) - a.au(WebViewSmileyGrid.this.getContext(), 2131166250)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label159;
        }
        paramViewGroup.lzC.setImageResource(2131231885);
        paramViewGroup.lzC.setContentDescription(WebViewSmileyGrid.this.getContext().getString(2131758032));
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
          paramViewGroup.lzC.setImageDrawable(null);
        }
        else
        {
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          Drawable localDrawable = e.eXp().vT(paramInt);
          paramViewGroup.lzC.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */