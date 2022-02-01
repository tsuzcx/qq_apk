package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int ESA;
  public static int ESB = 14;
  public static int ESo = 0;
  public static int ESp = 1;
  public static int ESq;
  public static int ESr;
  public static int ESs;
  public static int ESt;
  public static int ESu;
  public static int ESv;
  public static int ESw;
  public static int ESx;
  public static int ESy;
  public static int ESz;
  public static int rJs;
  public static int xuL = 2;
  public static int xuM;
  protected int DCQ;
  protected ChatFooterPanel.a ESm;
  protected f ESn;
  
  static
  {
    ESq = 3;
    ESr = 4;
    ESs = 5;
    ESt = 6;
    xuM = ESo;
    ESu = 12;
    ESv = 7;
    ESw = 8;
    ESx = 9;
    ESy = 10;
    ESz = 11;
    ESA = 12;
    rJs = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destroy() {}
  
  public abstract void fbE();
  
  @Deprecated
  public abstract void fbF();
  
  @Deprecated
  public abstract void fbG();
  
  @Deprecated
  public abstract void fbH();
  
  public abstract void fbI();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.ESn = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.DCQ = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.ESm = parama;
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