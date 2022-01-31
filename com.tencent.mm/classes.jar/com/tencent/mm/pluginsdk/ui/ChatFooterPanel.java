package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int vQl = 0;
  public static int vQm = 1;
  public static int vQn = 2;
  public static int vQo = 3;
  public static int vQp = 4;
  public static int vQq = 5;
  public static int vQr = 6;
  public static int vQs = 7;
  public static int vQt = 8;
  public static int vQu = 9;
  public static int vQv = 10;
  public static int vQw = 11;
  public static int vQx = 5;
  public static int vQy = 12;
  protected int uKC;
  protected ChatFooterPanel.a vQj;
  protected f vQk;
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract void AA();
  
  public abstract void AB();
  
  public abstract void AC();
  
  public abstract void AD();
  
  public abstract void Ay();
  
  public abstract void Az();
  
  public abstract void bo(boolean paramBoolean);
  
  public void destroy() {}
  
  public abstract void j(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void refresh();
  
  public void setCallback(f paramf)
  {
    this.vQk = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.uKC = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.vQj = parama;
  }
  
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */