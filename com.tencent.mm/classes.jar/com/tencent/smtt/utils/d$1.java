package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

class d$1
  implements d.a
{
  d$1(d paramd, WebView paramWebView, Context paramContext, RelativeLayout paramRelativeLayout, String paramString, TextView paramTextView) {}
  
  public void a()
  {
    AppMethodBeat.i(53870);
    this.a.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(53948);
        Toast.makeText(d.1.this.b, "下载成功", 0).show();
        d.1.this.c.setVisibility(4);
        d.1.this.f.a(d.1.this.d, d.1.this.a, d.1.this.b, d.a());
        AppMethodBeat.o(53948);
      }
    });
    AppMethodBeat.o(53870);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(53871);
    this.a.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(54036);
        d.1.this.e.setText("已下载" + paramInt + "%");
        AppMethodBeat.o(54036);
      }
    });
    AppMethodBeat.o(53871);
  }
  
  public void a(Throwable paramThrowable)
  {
    AppMethodBeat.i(53872);
    this.a.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(53881);
        Toast.makeText(d.1.this.b, "下载失败，请检查网络", 0).show();
        AppMethodBeat.o(53881);
      }
    });
    AppMethodBeat.o(53872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.utils.d.1
 * JD-Core Version:    0.7.0.1
 */