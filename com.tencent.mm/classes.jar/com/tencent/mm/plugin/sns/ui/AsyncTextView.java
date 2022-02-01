package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.aq;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private Context context;
  private int oIb;
  private String userName;
  private String zOL;
  private boolean zOM;
  private String zON;
  private p.a zOO;
  private boolean zOP;
  private com.tencent.mm.o.b zOQ;
  private int zOR;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97770);
    this.zOQ = null;
    this.zOR = 0;
    init(paramContext);
    AppMethodBeat.o(97770);
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97769);
    this.zOQ = null;
    this.zOR = 0;
    init(paramContext);
    AppMethodBeat.o(97769);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97771);
    this.context = paramContext;
    this.zOR = aq.fromDPToPix(paramContext, 14);
    AppMethodBeat.o(97771);
  }
  
  public final void a(String paramString1, String paramString2, p.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(97772);
    this.userName = paramString1;
    this.zOL = paramString2;
    this.oIb = paramInt;
    this.zOM = paramBoolean1;
    this.zON = paramString3;
    this.zOO = parama;
    this.zOP = paramBoolean2;
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
      if ((!bt.V(new String[] { localObject1, this.userName })) && (!this.zOM) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(97773);
        return;
      }
    }
    int j;
    int i;
    if ((this.zOQ != null) && (am.aSQ(this.zOQ.field_username)) && ("3552365301".equals(this.zOQ.field_openImAppid)))
    {
      j = this.zOL.length();
      localObject1 = " @" + ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bC(this.zOQ.field_openImAppid, this.zOQ.field_descWordingId);
      this.zOL += (String)localObject1;
      i = ((String)localObject1).length() + j;
    }
    for (;;)
    {
      if (this.oIb == 10) {}
      for (int k = 3;; k = 2)
      {
        localObject1 = new p(new a(this.zOM, this.userName, this.zON, 1), this.zOO, k);
        Object localObject2 = getContext();
        String str = this.zOL;
        getTextSize();
        localObject2 = new l(k.c((Context)localObject2, str, k));
        ((l)localObject2).a(localObject1, this.zOL);
        if ((j != i) && (i > j) && (j >= 0)) {
          ((l)localObject2).setSpan(((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).f(this.context, this.zOQ.field_openImAppid, this.zOR), j, i, 33);
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
  
  public void setContactInfo(com.tencent.mm.o.b paramb)
  {
    this.zOQ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */