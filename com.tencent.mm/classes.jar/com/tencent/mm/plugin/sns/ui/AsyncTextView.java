package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.u;
import com.tencent.mm.pluginsdk.ui.span.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.bd;

public class AsyncTextView
  extends TextView
  implements Runnable
{
  private String Rbf;
  private boolean Rbg;
  private String Rbh;
  private u.a Rbi;
  private boolean Rbj;
  private com.tencent.mm.contact.d Rbk;
  private int Rbl;
  private Context context;
  private String userName;
  private int viewType;
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97770);
    this.Rbk = null;
    this.Rbl = 0;
    init(paramContext);
    AppMethodBeat.o(97770);
  }
  
  public AsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97769);
    this.Rbk = null;
    this.Rbl = 0;
    init(paramContext);
    AppMethodBeat.o(97769);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97771);
    this.context = paramContext;
    this.Rbl = bd.fromDPToPix(paramContext, 14);
    AppMethodBeat.o(97771);
  }
  
  public final void a(String paramString1, String paramString2, u.a parama, boolean paramBoolean1, String paramString3, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(97772);
    this.userName = paramString1;
    this.Rbf = paramString2;
    this.viewType = paramInt;
    this.Rbg = paramBoolean1;
    this.Rbh = paramString3;
    this.Rbi = parama;
    this.Rbj = paramBoolean2;
    run();
    AppMethodBeat.o(97772);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(97776);
    try
    {
      int i = super.getBaseline();
      return i;
    }
    finally
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
    finally
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
      return;
    }
    finally
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
      return bool;
    }
    finally
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
      if ((!Util.isNullOrNil(new String[] { localObject1, this.userName })) && (!this.Rbg) && (((String)localObject1).equals(this.userName)))
      {
        AppMethodBeat.o(97773);
        return;
      }
    }
    int j;
    int i;
    if ((this.Rbk != null) && (au.bwO(this.Rbk.field_username)) && ("3552365301".equals(this.Rbk.field_openImAppid)))
    {
      j = this.Rbf.length();
      localObject1 = " @" + ((e)h.ax(e.class)).cc(this.Rbk.field_openImAppid, this.Rbk.field_descWordingId);
      this.Rbf += (String)localObject1;
      i = ((String)localObject1).length() + j;
    }
    for (;;)
    {
      if (this.viewType == 10) {}
      for (int k = 3;; k = 2)
      {
        localObject1 = new u(new com.tencent.mm.plugin.sns.data.d(this.Rbg, this.userName, this.Rbh, 1), this.Rbi, k);
        Object localObject2 = getContext();
        String str = this.Rbf;
        getTextSize();
        localObject2 = new q(p.e((Context)localObject2, str, k));
        ((q)localObject2).a(localObject1, this.Rbf, 0);
        if ((this.Rbk != null) && (j != i) && (i > j) && (j >= 0)) {
          ((q)localObject2).setSpan(((e)h.ax(e.class)).a(this.context, this.Rbk.field_openImAppid, this.Rbl, b.c.BW_0_Alpha_0_5), j, i, 33);
        }
        setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
        ((f)h.az(f.class)).setTextWithStatus(this, this.userName, a.b.ThG, a.c.ThP);
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
    this.Rbk = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncTextView
 * JD-Core Version:    0.7.0.1
 */