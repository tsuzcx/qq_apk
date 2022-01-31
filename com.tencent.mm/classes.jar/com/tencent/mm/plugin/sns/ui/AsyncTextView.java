package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private Context context;
  private int kwo;
  private String rEW;
  private boolean rEX;
  private String rEY;
  private o.a rEZ;
  private boolean rFa;
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
    AppMethodBeat.i(38144);
    this.userName = paramString1;
    this.rEW = paramString2;
    this.kwo = paramInt;
    this.rEX = paramBoolean1;
    this.rEY = paramString3;
    this.rEZ = parama;
    this.rFa = paramBoolean2;
    run();
    AppMethodBeat.o(38144);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(38148);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(38148);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(38148);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38147);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(38147);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.AsyncTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(38147);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38146);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(38146);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(38146);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(38149);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(38149);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(38149);
    }
    return true;
  }
  
  public void run()
  {
    AppMethodBeat.i(38145);
    Object localObject1;
    if ((getTag() instanceof String))
    {
      localObject1 = (String)getTag();
      if ((!bo.Q(new String[] { localObject1, this.userName })) && (!this.rEX) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(38145);
        return;
      }
    }
    if (this.kwo == 10) {}
    for (int i = 3;; i = 2)
    {
      localObject1 = new o(new a(this.rEX, this.userName, this.rEY, 1), this.rEZ, i);
      Object localObject2 = getContext();
      String str = this.rEW;
      getTextSize();
      localObject2 = new k(j.c((Context)localObject2, str, i));
      ((k)localObject2).a(localObject1, this.rEW, 0);
      setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
      setTag(this.userName);
      AppMethodBeat.o(38145);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */