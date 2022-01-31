package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.e.c;

public class SmileyGrid
  extends GridView
{
  public static int AQH = 1;
  private int AQI;
  public int AQJ;
  private int AQK;
  private ChatFooterPanel.a AQL;
  private boolean AQM;
  public AdapterView.OnItemClickListener AQN;
  private AdapterView.OnItemClickListener jUz;
  private int jpP;
  public int jpR;
  private int mScene;
  private j vZc;
  public ListAdapter xw;
  
  public SmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62913);
    this.AQI = 20;
    this.AQJ = 0;
    this.AQK = 0;
    this.mScene = ChatFooterPanel.vQl;
    this.jUz = new SmileyGrid.1(this);
    this.AQN = new SmileyGrid.9(this);
    AppMethodBeat.o(62913);
  }
  
  public final void dQO()
  {
    AppMethodBeat.i(62916);
    setOnItemClickListener(this.jUz);
    AppMethodBeat.o(62916);
  }
  
  public int getSmileyType()
  {
    return this.AQI;
  }
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(62917);
    ab.v("MicroMsg.emoji.SmileyGrid", "type:" + paramInt1 + " itemsPerPage:" + paramInt4 + " totalPage:" + paramInt5 + " curPage:" + this.jpR);
    setOnItemClickListener(this.jUz);
    this.AQI = paramInt1;
    this.jpR = paramInt2;
    this.jpP = paramInt3;
    this.AQJ = paramInt4;
    this.AQK = paramInt5;
    AppMethodBeat.o(62917);
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(62915);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(62915);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62914);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(62914);
  }
  
  public void release()
  {
    this.AQL = null;
    this.vZc = null;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(62918);
    super.setAdapter(paramListAdapter);
    this.xw = paramListAdapter;
    AppMethodBeat.o(62918);
  }
  
  public void setCallback(j paramj)
  {
    this.vZc = paramj;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.AQL = parama;
  }
  
  public void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid
 * JD-Core Version:    0.7.0.1
 */