package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int ACC;
  public static int NEu;
  public static int NEv;
  public static int XYA = 16;
  public static int XYl = 0;
  public static int XYm = 1;
  public static int XYn;
  public static int XYo;
  public static int XYp;
  public static int XYq;
  public static int XYr;
  public static int XYs;
  public static int XYt;
  public static int XYu;
  public static int XYv;
  public static int XYw;
  public static int XYx;
  public static int XYy;
  public static int XYz;
  protected int Wqp;
  protected ChatFooterPanel.a XYj;
  protected f XYk;
  
  static
  {
    NEu = 2;
    XYn = 3;
    XYo = 4;
    XYp = 5;
    XYq = 6;
    NEv = XYl;
    XYr = 12;
    XYs = 7;
    XYt = 8;
    XYu = 9;
    XYv = 10;
    XYw = 11;
    XYx = 12;
    ACC = 13;
    XYy = 14;
    XYz = 15;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public abstract void JA(boolean paramBoolean);
  
  public abstract void Jy(boolean paramBoolean);
  
  public abstract void Jz(boolean paramBoolean);
  
  public abstract void bDL();
  
  public void destroy() {}
  
  public abstract void iKg();
  
  @Deprecated
  public abstract void iKh();
  
  @Deprecated
  public abstract void iKi();
  
  public abstract void iKj();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.XYk = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.Wqp = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.XYj = parama;
  }
  
  @Deprecated
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setShowClose(boolean paramBoolean);
  
  public void setShowGame(boolean paramBoolean) {}
  
  public abstract void setShowSearch(boolean paramBoolean);
  
  public abstract void setShowSend(boolean paramBoolean);
  
  public abstract void setShowSmiley(boolean paramBoolean);
  
  public abstract void setShowStore(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
  
  public abstract void setToSendText(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */