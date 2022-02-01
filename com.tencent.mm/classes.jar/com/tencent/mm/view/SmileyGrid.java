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
  public static int Jyx = 1;
  private j DyS;
  public ListAdapter EN;
  private int JyA;
  private ChatFooterPanel.a JyB;
  private int Jyy;
  public int Jyz;
  private int mScene;
  
  public SmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105175);
    this.Jyy = 20;
    this.Jyz = 0;
    this.JyA = 0;
    this.mScene = ChatFooterPanel.Dnj;
    AppMethodBeat.o(105175);
  }
  
  public int getSmileyType()
  {
    return this.Jyy;
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
    this.JyB = null;
    this.DyS = null;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(105180);
    super.setAdapter(paramListAdapter);
    this.EN = paramListAdapter;
    AppMethodBeat.o(105180);
  }
  
  public void setCallback(j paramj)
  {
    this.DyS = paramj;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.JyB = parama;
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