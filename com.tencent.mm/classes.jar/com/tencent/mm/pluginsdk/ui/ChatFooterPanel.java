package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel
  extends LinearLayout
{
  public static int BUT = 0;
  public static int BUU = 1;
  public static int BUV;
  public static int BUW;
  public static int BUX;
  public static int BUY;
  public static int BUZ;
  public static int BVa;
  public static int BVb;
  public static int BVc;
  public static int BVd;
  public static int BVe;
  public static int BVf;
  public static int Lwx = 14;
  public static int qpk;
  public static int vei = 2;
  public static int vej;
  protected int AHD;
  protected a BUR;
  protected f BUS;
  
  static
  {
    BUV = 3;
    BUW = 4;
    BUX = 5;
    BUY = 6;
    vej = BUT;
    BUZ = 12;
    BVa = 7;
    BVb = 8;
    BVc = 9;
    BVd = 10;
    BVe = 11;
    BVf = 12;
    qpk = 13;
  }
  
  public ChatFooterPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destroy() {}
  
  public abstract void exm();
  
  @Deprecated
  public abstract void exn();
  
  @Deprecated
  public abstract void exo();
  
  @Deprecated
  public abstract void exp();
  
  public abstract void exq();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public void setCallback(f paramf)
  {
    this.BUS = paramf;
  }
  
  public abstract void setDefaultEmojiByDetail(String paramString);
  
  public abstract void setEntranceScene(int paramInt);
  
  public void setFooterType(int paramInt)
  {
    this.AHD = paramInt;
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.BUR = parama;
  }
  
  @Deprecated
  public abstract void setPortHeightPx(int paramInt);
  
  public abstract void setSendButtonEnable(boolean paramBoolean);
  
  public abstract void setShowClose(boolean paramBoolean);
  
  public abstract void setShowSend(boolean paramBoolean);
  
  public abstract void setShowSmiley(boolean paramBoolean);
  
  public abstract void setShowStore(boolean paramBoolean);
  
  public abstract void setTalkerName(String paramString);
  
  public static abstract class RecommendView
    extends LinearLayout
  {
    public RecommendView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public RecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public abstract void setProductID(String paramString);
  }
  
  public static abstract interface a
  {
    public abstract void append(String paramString);
    
    public abstract void btF();
    
    public abstract void cqY();
    
    public abstract void lf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ChatFooterPanel
 * JD-Core Version:    0.7.0.1
 */