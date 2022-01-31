package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.c.g;
import org.xwalk.core.Log;

public final class f
  implements g
{
  private X5JsCore BHV;
  private Context mContext;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(84808);
    this.mContext = paramContext;
    Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
    AppMethodBeat.o(84808);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(84809);
    this.BHV = new X5JsCore(this.mContext);
    AppMethodBeat.o(84809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.f
 * JD-Core Version:    0.7.0.1
 */