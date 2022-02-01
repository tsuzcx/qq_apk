package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int Dnj = 0;
  public static int Dnk = 1;
  public static int Dnl;
  public static int Dnm;
  public static int Dnn;
  public static int Dno;
  public static int Dnp;
  public static int Dnq;
  public static int Dnr;
  public static int Dns;
  public static int Dnt;
  public static int Dnu;
  public static int Dnv;
  public static int Dnw = 14;
  public static int qYg;
  public static int wmX = 2;
  public static int wmY;
  protected int BZU;
  protected ChatFooterPanel.a Dnh;
  protected f Dni;
  
  static
  {
    Dnl = 3;
    Dnm = 4;
    Dnn = 5;
    Dno = 6;
    wmY = Dnj;
    Dnp = 12;
    Dnq = 7;
    Dnr = 8;
    Dns = 9;
    Dnt = 10;
    Dnu = 11;
    Dnv = 12;
    qYg = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destroy() {}
  
  public abstract void eMG();
  
  @Deprecated
  public abstract void eMH();
  
  @Deprecated
  public abstract void eMI();
  
  @Deprecated
  public abstract void eMJ();
  
  public abstract void eMK();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.Dni = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.BZU = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.Dnh = parama;
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