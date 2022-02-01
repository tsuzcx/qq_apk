package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int BKM;
  public static int BKN;
  public static int KbB = 0;
  public static int KbC = 1;
  public static int KbD;
  public static int KbE;
  public static int KbF;
  public static int KbG;
  public static int KbH;
  public static int KbI;
  public static int KbJ;
  public static int KbK;
  public static int KbL;
  public static int KbM;
  public static int KbN;
  public static int KbO = 14;
  public static int KbP = 15;
  public static int tvw;
  protected int IFI;
  protected f KbA;
  protected ChatFooterPanel.a Kbz;
  
  static
  {
    BKM = 2;
    KbD = 3;
    KbE = 4;
    KbF = 5;
    KbG = 6;
    BKN = KbB;
    KbH = 12;
    KbI = 7;
    KbJ = 8;
    KbK = 9;
    KbL = 10;
    KbM = 11;
    KbN = 12;
    tvw = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destroy() {}
  
  public abstract void goC();
  
  @Deprecated
  public abstract void goD();
  
  @Deprecated
  public abstract void goE();
  
  public abstract void goF();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.KbA = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.IFI = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.Kbz = parama;
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
  
  @Deprecated
  public abstract void zN(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */