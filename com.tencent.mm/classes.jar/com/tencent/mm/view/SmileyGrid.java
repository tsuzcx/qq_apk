package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;

public class SmileyGrid
  extends GridView
{
  public static int LOp = 1;
  private j Fwz;
  public ListAdapter GE;
  private int LOq;
  public int LOr;
  private int LOs;
  private ChatFooterPanel.a LOt;
  private int mScene;
  
  public SmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105175);
    this.LOq = 20;
    this.LOr = 0;
    this.LOs = 0;
    this.mScene = ChatFooterPanel.FkJ;
    AppMethodBeat.o(105175);
  }
  
  public int getSmileyType()
  {
    return this.LOq;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(105177);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(105177);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105176);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(105176);
  }
  
  public void release()
  {
    this.LOt = null;
    this.Fwz = null;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(105180);
    super.setAdapter(paramListAdapter);
    this.GE = paramListAdapter;
    AppMethodBeat.o(105180);
  }
  
  public void setCallback(j paramj)
  {
    this.Fwz = paramj;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.LOt = parama;
  }
  
  public void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid
 * JD-Core Version:    0.7.0.1
 */