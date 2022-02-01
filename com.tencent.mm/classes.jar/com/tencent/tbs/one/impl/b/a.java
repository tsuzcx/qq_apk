package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

public final class a
  extends FrameLayout
{
  private final String a;
  private Handler b;
  private TextView c;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(174167);
    this.b = new Handler(Looper.getMainLooper());
    this.a = paramString;
    this.c = new TextView(paramContext);
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 17;
    addView(this.c, paramString);
    com.tencent.tbs.one.impl.common.a.a(paramContext, new TBSOneCallback()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174160);
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174162);
            a.a(a.this);
            a.a(a.this, "加载调试组件失败，请稍后重试");
            AppMethodBeat.o(174162);
          }
        });
        AppMethodBeat.o(174160);
      }
      
      public final void onProgressChanged(int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(174159);
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174165);
            a.a(a.this, String.format("已加载 %d", new Object[] { Integer.valueOf(paramAnonymousInt2) }));
            AppMethodBeat.o(174165);
          }
        });
        AppMethodBeat.o(174159);
      }
    });
    AppMethodBeat.o(174167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.a
 * JD-Core Version:    0.7.0.1
 */