package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class f
{
  public v2protocal UBn;
  public int UMs;
  public boolean UNZ;
  public int UOa;
  public int UOb;
  public ArrayList<a> mCallbackList;
  
  public f()
  {
    AppMethodBeat.i(115701);
    this.UNZ = false;
    this.UMs = 0;
    this.mCallbackList = new ArrayList();
    this.UBn = new v2protocal(new MMHandler(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.mCallbackList.contains(parama)) {
      this.mCallbackList.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  public final class b
  {
    public int UOc;
    public int UOd;
    public int UOe;
    public int UOf;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.UOc), Integer.valueOf(this.UOd), Integer.valueOf(this.UOe), Integer.valueOf(this.UOf) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.f
 * JD-Core Version:    0.7.0.1
 */