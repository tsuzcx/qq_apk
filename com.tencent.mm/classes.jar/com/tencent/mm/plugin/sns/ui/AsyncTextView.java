package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.aq;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private String AfS;
  private boolean AfT;
  private String AfU;
  private p.a AfV;
  private boolean AfW;
  private c AfX;
  private int AfY;
  private Context context;
  private int oOD;
  private String userName;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97770);
    this.AfX = null;
    this.AfY = 0;
    init(paramContext);
    AppMethodBeat.o(97770);
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97769);
    this.AfX = null;
    this.AfY = 0;
    init(paramContext);
    AppMethodBeat.o(97769);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97771);
    this.context = paramContext;
    this.AfY = aq.fromDPToPix(paramContext, 14);
    AppMethodBeat.o(97771);
  }
  
  public final void a(String paramString1, String paramString2, p.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(97772);
    this.userName = paramString1;
    this.AfS = paramString2;
    this.oOD = paramInt;
    this.AfT = paramBoolean1;
    this.AfU = paramString3;
    this.AfV = parama;
    this.AfW = paramBoolean2;
    run();
    AppMethodBeat.o(97772);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(97776);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(97776);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(97776);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97775);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(97775);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ae.printErrStackTrace("MicroMsg.AsyncTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(97775);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97774);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(97774);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(97774);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(97777);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(97777);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(97777);
    }
    return true;
  }
  
  public void run()
  {
    AppMethodBeat.i(97773);
    Object localObject1;
    if ((getTag() instanceof String))
    {
      localObject1 = (String)getTag();
      if ((!bu.V(new String[] { localObject1, this.userName })) && (!this.AfT) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(97773);
        return;
      }
    }
    int j;
    int i;
    if ((this.AfX != null) && (an.aUq(this.AfX.field_username)) && ("3552365301".equals(this.AfX.field_openImAppid)))
    {
      j = this.AfS.length();
      localObject1 = " @" + ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(this.AfX.field_openImAppid, this.AfX.field_descWordingId);
      this.AfS += (String)localObject1;
      i = ((String)localObject1).length() + j;
    }
    for (;;)
    {
      if (this.oOD == 10) {}
      for (int k = 3;; k = 2)
      {
        localObject1 = new p(new com.tencent.mm.plugin.sns.data.a(this.AfT, this.userName, this.AfU, 1), this.AfV, k);
        Object localObject2 = getContext();
        String str = this.AfS;
        getTextSize();
        localObject2 = new l(k.c((Context)localObject2, str, k));
        ((l)localObject2).a(localObject1, this.AfS);
        if ((j != i) && (i > j) && (j >= 0)) {
          ((l)localObject2).setSpan(((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).f(this.context, this.AfX.field_openImAppid, this.AfY), j, i, 33);
        }
        setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
        setTag(this.userName);
        AppMethodBeat.o(97773);
        return;
      }
      i = 0;
      j = 0;
    }
  }
  
  public void setContactInfo(c paramc)
  {
    this.AfX = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */