package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int SCENE_SNS = 2;
  public static int rZu = 0;
  public static int rZv = 1;
  public static int rZw = 3;
  public static int rZx = 4;
  protected int qVq;
  public ChatFooterPanel.a rZs;
  public f rZt;
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract void aN(boolean paramBoolean);
  
  public void destroy() {}
  
  public abstract void i(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void refresh();
  
  public void setCallback(f paramf)
  {
    this.rZt = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.qVq = paramInt;
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    this.rZs = parama;
  }
  
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
  
  public abstract void si();
  
  public abstract void sj();
  
  public abstract void sk();
  
  public abstract void sl();
  
  public abstract void sm();
  
  public abstract void sn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */