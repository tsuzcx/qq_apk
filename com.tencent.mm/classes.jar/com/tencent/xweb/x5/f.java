package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.Log;

public final class f
  implements IJsRuntime
{
  private X5JsCore MuQ;
  private Context mContext;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(153843);
    this.mContext = paramContext;
    Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
    AppMethodBeat.o(153843);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(153844);
    this.MuQ = new X5JsCore(this.mContext);
    AppMethodBeat.o(153844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.f
 * JD-Core Version:    0.7.0.1
 */