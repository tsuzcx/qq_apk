package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int FkJ = 0;
  public static int FkK = 1;
  public static int FkL;
  public static int FkM;
  public static int FkN;
  public static int FkO;
  public static int FkP;
  public static int FkQ;
  public static int FkR;
  public static int FkS;
  public static int FkT;
  public static int FkU;
  public static int FkV;
  public static int FkW = 14;
  public static int rRG;
  public static int xKI = 2;
  public static int xKJ;
  protected int DUO;
  protected ChatFooterPanel.a FkH;
  protected f FkI;
  
  static
  {
    FkL = 3;
    FkM = 4;
    FkN = 5;
    FkO = 6;
    xKJ = FkJ;
    FkP = 12;
    FkQ = 7;
    FkR = 8;
    FkS = 9;
    FkT = 10;
    FkU = 11;
    FkV = 12;
    rRG = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destroy() {}
  
  public abstract void ffs();
  
  @Deprecated
  public abstract void fft();
  
  @Deprecated
  public abstract void ffu();
  
  @Deprecated
  public abstract void ffv();
  
  public abstract void ffw();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.FkI = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.DUO = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.FkH = parama;
  }
  
  @Deprecated
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setShowClose(boolean paramBoolean);
  
  public abstract void setShowSend(boolean paramBoolean);
  
  public abstract void setShowSmiley(boolean paramBoolean);
  
  public abstract void setShowStore(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */