package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int HGX;
  public static int HGY;
  public static int Rcg = 0;
  public static int Rch = 1;
  public static int Rci;
  public static int Rcj;
  public static int Rck;
  public static int Rcl;
  public static int Rcm;
  public static int Rcn;
  public static int Rco;
  public static int Rcp;
  public static int Rcq;
  public static int Rcr;
  public static int Rcs;
  public static int Rct = 14;
  public static int Rcu = 15;
  public static int xde;
  protected int PAa;
  protected ChatFooterPanel.a Rce;
  protected f Rcf;
  
  static
  {
    HGX = 2;
    Rci = 3;
    Rcj = 4;
    Rck = 5;
    Rcl = 6;
    HGY = Rcg;
    Rcm = 12;
    Rcn = 7;
    Rco = 8;
    Rcp = 9;
    Rcq = 10;
    Rcr = 11;
    Rcs = 12;
    xde = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public abstract void DS(boolean paramBoolean);
  
  public void destroy() {}
  
  public abstract void hjm();
  
  public abstract void hjn();
  
  public abstract void hjo();
  
  @Deprecated
  public abstract void hjp();
  
  @Deprecated
  public abstract void hjq();
  
  public abstract void hjr();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.Rcf = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.PAa = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.Rce = parama;
  }
  
  @Deprecated
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setShowClose(boolean paramBoolean);
  
  public abstract void setShowSend(boolean paramBoolean);
  
  public abstract void setShowSmiley(boolean paramBoolean);
  
  public abstract void setShowStore(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
  
  public abstract void setToSendText(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */