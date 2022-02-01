package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.ao;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private Context context;
  private int nBH;
  private String userName;
  private String xkH;
  private boolean xkI;
  private String xkJ;
  private p.a xkK;
  private boolean xkL;
  private com.tencent.mm.n.b xkM;
  private int xkN;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97770);
    this.xkM = null;
    this.xkN = 0;
    init(paramContext);
    AppMethodBeat.o(97770);
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97769);
    this.xkM = null;
    this.xkN = 0;
    init(paramContext);
    AppMethodBeat.o(97769);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97771);
    this.context = paramContext;
    this.xkN = ao.fromDPToPix(paramContext, 14);
    AppMethodBeat.o(97771);
  }
  
  public final void a(String paramString1, String paramString2, p.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(97772);
    this.userName = paramString1;
    this.xkH = paramString2;
    this.nBH = paramInt;
    this.xkI = paramBoolean1;
    this.xkJ = paramString3;
    this.xkK = parama;
    this.xkL = paramBoolean2;
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
      ad.printErrStackTrace("MicroMsg.AsyncTextView", paramCanvas, "", new Object[0]);
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
      if ((!bt.T(new String[] { localObject1, this.userName })) && (!this.xkI) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(97773);
        return;
      }
    }
    int j;
    int i;
    if ((this.xkM != null) && (af.aHH(this.xkM.field_username)) && ("3552365301".equals(this.xkM.field_openImAppid)))
    {
      j = this.xkH.length();
      localObject1 = " @" + ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(this.xkM.field_openImAppid, this.xkM.field_descWordingId);
      this.xkH += (String)localObject1;
      i = ((String)localObject1).length() + j;
    }
    for (;;)
    {
      if (this.nBH == 10) {}
      for (int k = 3;; k = 2)
      {
        localObject1 = new p(new a(this.xkI, this.userName, this.xkJ, 1), this.xkK, k);
        Object localObject2 = getContext();
        String str = this.xkH;
        getTextSize();
        localObject2 = new l(k.c((Context)localObject2, str, k));
        ((l)localObject2).a(localObject1, this.xkH, 0);
        if ((j != i) && (i > j) && (j >= 0)) {
          ((l)localObject2).setSpan(((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).f(this.context, this.xkM.field_openImAppid, this.xkN), j, i, 33);
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
  
  public void setContactInfo(com.tencent.mm.n.b paramb)
  {
    this.xkM = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */