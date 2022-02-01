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
import com.tencent.mm.cd.a;
import com.tencent.mm.cg.e;
import com.tencent.mm.ui.y;

public class WebViewSmileyGrid
  extends GridView
{
  private c BwH;
  a BwI;
  AdapterView.OnItemClickListener atG;
  int mfI;
  int mfJ;
  int mfK;
  int mfL;
  int mfM;
  int mfN;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82342);
    this.mfJ = 0;
    this.mfL = 0;
    this.mfM = 0;
    this.mfN = 0;
    this.atG = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(82338);
        if (paramAnonymousInt == WebViewSmileyGrid.a(WebViewSmileyGrid.this).getCount() - 1)
        {
          if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).BwO != null) {
            WebViewSmileyGrid.b(WebViewSmileyGrid.this).BwO.btF();
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
        if (WebViewSmileyGrid.b(WebViewSmileyGrid.this).BwO != null)
        {
          paramAnonymousAdapterView = WebViewSmileyGrid.b(WebViewSmileyGrid.this).BwO;
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          paramAnonymousAdapterView.append(e.eHT().ve(i * (j - 1) + paramAnonymousInt));
        }
        AppMethodBeat.o(82338);
      }
    };
    AppMethodBeat.o(82342);
  }
  
  int getRowSpacing()
  {
    return this.mfL;
  }
  
  public void setPanelManager(c paramc)
  {
    this.BwH = paramc;
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
        paramView = y.js(WebViewSmileyGrid.this.getContext()).inflate(2131496089, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).mfW - a.ao(WebViewSmileyGrid.this.getContext(), 2131165490) - a.ao(WebViewSmileyGrid.this.getContext(), 2131166250)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label159;
        }
        paramViewGroup.kXS.setImageResource(2131231885);
        paramViewGroup.kXS.setContentDescription(WebViewSmileyGrid.this.getContext().getString(2131758032));
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
          paramViewGroup.kXS.setImageDrawable(null);
        }
        else
        {
          WebViewSmileyGrid.b(WebViewSmileyGrid.this);
          Drawable localDrawable = e.eHT().vc(paramInt);
          paramViewGroup.kXS.setImageDrawable(localDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */