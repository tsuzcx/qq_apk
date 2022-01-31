package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.y;

public class SmileyGrid
  extends GridView
{
  public static int wvH = 1;
  public ListAdapter NK;
  private int fzn = ChatFooterPanel.rZu;
  private int hxF;
  public int hxH;
  private AdapterView.OnItemClickListener idL = new SmileyGrid.1(this);
  private j sgJ;
  private int wvI = 20;
  public int wvJ = 0;
  private int wvK = 0;
  private ChatFooterPanel.a wvL;
  private boolean wvM;
  public AdapterView.OnItemClickListener wvN = new SmileyGrid.2(this);
  
  public SmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void cLw()
  {
    setOnItemClickListener(this.idL);
  }
  
  public int getSmileyType()
  {
    return this.wvI;
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    y.v("MicroMsg.emoji.SmileyGrid", "type:" + paramInt1 + " itemsPerPage:" + paramInt4 + " totalPage:" + paramInt5 + " curPage:" + this.hxH);
    setOnItemClickListener(this.idL);
    this.wvI = paramInt1;
    this.hxH = paramInt2;
    this.hxF = paramInt3;
    this.wvJ = paramInt4;
    this.wvK = paramInt5;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void release()
  {
    this.wvL = null;
    this.sgJ = null;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.NK = paramListAdapter;
  }
  
  public void setCallback(j paramj)
  {
    this.sgJ = paramj;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.wvL = parama;
  }
  
  public void setScene(int paramInt)
  {
    this.fzn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid
 * JD-Core Version:    0.7.0.1
 */