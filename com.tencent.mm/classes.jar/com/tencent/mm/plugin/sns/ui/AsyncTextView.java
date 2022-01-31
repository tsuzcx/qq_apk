package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.sdk.platformtools.bk;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private Context context;
  private int ivk;
  private String oNm;
  private boolean oNn;
  private String oNo;
  private o.a oNp;
  private boolean oNq;
  private String userName;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public final void a(String paramString1, String paramString2, o.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    this.userName = paramString1;
    this.oNm = paramString2;
    this.ivk = paramInt;
    this.oNn = paramBoolean1;
    this.oNo = paramString3;
    this.oNp = parama;
    this.oNq = paramBoolean2;
    run();
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean onPreDraw()
  {
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public void run()
  {
    Object localObject1;
    if ((getTag() instanceof String))
    {
      localObject1 = (String)getTag();
      if ((!bk.H(new String[] { localObject1, this.userName })) && (!this.oNn) && (((String)localObject1).equals(this.userName))) {
        return;
      }
    }
    if (this.ivk == 10) {}
    for (int i = 3;; i = 2)
    {
      localObject1 = new o(new a(this.oNn, this.userName, this.oNo, 1), this.oNp, i);
      Object localObject2 = getContext();
      String str = this.oNm;
      getTextSize();
      localObject2 = new k(j.c((Context)localObject2, str, i));
      ((k)localObject2).a(localObject1, this.oNm, 0);
      setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
      setTag(this.userName);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */