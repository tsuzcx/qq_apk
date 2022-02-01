package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aw;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private String KBA;
  private q.a KBB;
  private boolean KBC;
  private com.tencent.mm.contact.d KBD;
  private int KBE;
  private String KBy;
  private boolean KBz;
  private Context context;
  private String userName;
  private int viewType;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97770);
    this.KBD = null;
    this.KBE = 0;
    init(paramContext);
    AppMethodBeat.o(97770);
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97769);
    this.KBD = null;
    this.KBE = 0;
    init(paramContext);
    AppMethodBeat.o(97769);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97771);
    this.context = paramContext;
    this.KBE = aw.fromDPToPix(paramContext, 14);
    AppMethodBeat.o(97771);
  }
  
  public final void a(String paramString1, String paramString2, q.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(97772);
    this.userName = paramString1;
    this.KBy = paramString2;
    this.viewType = paramInt;
    this.KBz = paramBoolean1;
    this.KBA = paramString3;
    this.KBB = parama;
    this.KBC = paramBoolean2;
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
      Log.printErrStackTrace("MicroMsg.AsyncTextView", paramCanvas, "", new Object[0]);
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
      if ((!Util.isNullOrNil(new String[] { localObject1, this.userName })) && (!this.KBz) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(97773);
        return;
      }
    }
    int j;
    int i;
    if ((this.KBD != null) && (as.bvK(this.KBD.field_username)) && ("3552365301".equals(this.KBD.field_openImAppid)))
    {
      j = this.KBy.length();
      localObject1 = " @" + ((a)h.ae(a.class)).bR(this.KBD.field_openImAppid, this.KBD.field_descWordingId);
      this.KBy += (String)localObject1;
      i = ((String)localObject1).length() + j;
    }
    for (;;)
    {
      if (this.viewType == 10) {}
      for (int k = 3;; k = 2)
      {
        localObject1 = new q(new com.tencent.mm.plugin.sns.data.d(this.KBz, this.userName, this.KBA, 1), this.KBB, k);
        Object localObject2 = getContext();
        String str = this.KBy;
        getTextSize();
        localObject2 = new m(l.e((Context)localObject2, str, k));
        ((m)localObject2).a(localObject1, this.KBy, 0);
        if ((this.KBD != null) && (j != i) && (i > j) && (j >= 0)) {
          ((m)localObject2).setSpan(((a)h.ae(a.class)).a(this.context, this.KBD.field_openImAppid, this.KBE, i.c.BW_0_Alpha_0_5), j, i, 33);
        }
        setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
        ((com.tencent.mm.plugin.textstatus.a.d)h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(this, this.userName, a.b.MzC, a.c.MzI);
        setTag(this.userName);
        AppMethodBeat.o(97773);
        return;
      }
      i = 0;
      j = 0;
    }
  }
  
  public void setContactInfo(com.tencent.mm.contact.d paramd)
  {
    this.KBD = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */