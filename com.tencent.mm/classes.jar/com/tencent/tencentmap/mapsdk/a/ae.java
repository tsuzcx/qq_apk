package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ae
  extends aa
{
  public ae(Context paramContext, ai paramai)
  {
    super(paramContext, paramai);
    AppMethodBeat.i(147095);
    d();
    AppMethodBeat.o(147095);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147096);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      AppMethodBeat.o(147096);
      return;
    }
    super.a(paramObject, paramInt1, paramInt2);
    AppMethodBeat.o(147096);
  }
  
  public final int getMapViewType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ae
 * JD-Core Version:    0.7.0.1
 */