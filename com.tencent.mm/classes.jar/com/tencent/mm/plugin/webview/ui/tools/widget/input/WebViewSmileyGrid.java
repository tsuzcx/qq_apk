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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.cd.e;
import com.tencent.mm.ui.y;

public class WebViewSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener ajR = new WebViewSmileyGrid.1(this);
  int hxF;
  int hxG = 0;
  int hxH;
  int hxI = 0;
  int hxJ = 0;
  int hxK = 0;
  private c rDq;
  a rDr;
  
  public WebViewSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  int getRowSpacing()
  {
    return this.hxI;
  }
  
  public void setPanelManager(c paramc)
  {
    this.rDq = paramc;
  }
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return WebViewSmileyGrid.d(WebViewSmileyGrid.this);
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
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = y.gt(WebViewSmileyGrid.this.getContext()).inflate(R.i.webview_smiley_grid_item, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (WebViewSmileyGrid.b(WebViewSmileyGrid.this).hxU - a.aa(WebViewSmileyGrid.this.getContext(), R.f.LittlePadding) - a.aa(WebViewSmileyGrid.this.getContext(), R.f.emoji_panel_tab_height)) / WebViewSmileyGrid.f(WebViewSmileyGrid.this)));
        paramViewGroup = new WebViewSmileyGrid.b(paramView);
        paramView.setTag(paramViewGroup);
      }
      while (paramInt == getCount() - 1)
      {
        paramViewGroup.gSx.setImageResource(R.g.del_btn);
        paramViewGroup.gSx.setContentDescription(WebViewSmileyGrid.this.getContext().getString(R.l.delete_btn));
        return paramView;
        paramViewGroup = (WebViewSmileyGrid.b)paramView.getTag();
      }
      paramInt = (WebViewSmileyGrid.d(WebViewSmileyGrid.this) - 1) * WebViewSmileyGrid.c(WebViewSmileyGrid.this) + paramInt;
      if (paramInt > WebViewSmileyGrid.e(WebViewSmileyGrid.this) - 1)
      {
        paramViewGroup.gSx.setImageDrawable(null);
        return paramView;
      }
      Drawable localDrawable = e.csH().mW(paramInt);
      paramViewGroup.gSx.setImageDrawable(localDrawable);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid
 * JD-Core Version:    0.7.0.1
 */