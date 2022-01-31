package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

public class ConversationOverscrollListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, am.a
{
  private static final boolean vQU = d.gH(10);
  private AdapterView.OnItemClickListener aeW;
  private AdapterView.OnItemSelectedListener aeX;
  private am fjC;
  private Rect mRect = new Rect();
  private int qQ = 0;
  private ConversationOverscrollListView.c vQV = new ConversationOverscrollListView.c();
  private ConversationOverscrollListView.a vQW;
  private boolean vQX = false;
  private int vQY = 0;
  private int vQZ = 0;
  private float vRa = 0.0F;
  private long vRb = 1L;
  private final float vRc = 3.5F;
  private final float vRd = 13.5F;
  private float vRe = 0.0F;
  private ConversationOverscrollListView.b vRf = new ConversationOverscrollListView.b(this);
  private final int vRg = 50;
  private AdapterView.OnItemLongClickListener vRh;
  
  public ConversationOverscrollListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    this.fjC = new am(this, false);
  }
  
  private float getSpeed()
  {
    float f = (this.vRe - this.vRa) / (float)Math.max(1L, System.currentTimeMillis() - this.vRb);
    y.d("MicroMsg.ConversationOverscrollListView", "speed: %f", new Object[] { Float.valueOf(f) });
    return f;
  }
  
  @TargetApi(11)
  protected void onFinishInflate() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.vQX = true;
    if (this.aeW != null) {
      this.aeW.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.vQX = true;
    if (this.vRh != null) {
      return this.vRh.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.vQX = true;
    if (this.aeX != null) {
      this.aeX.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    if (this.aeX != null) {
      this.aeX.onNothingSelected(paramAdapterView);
    }
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.aeW = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.vRh = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.aeX = paramOnItemSelectedListener;
  }
  
  public void setOverScrollCallback(ConversationOverscrollListView.a parama)
  {
    this.vQW = parama;
  }
  
  public final boolean tC()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationOverscrollListView
 * JD-Core Version:    0.7.0.1
 */