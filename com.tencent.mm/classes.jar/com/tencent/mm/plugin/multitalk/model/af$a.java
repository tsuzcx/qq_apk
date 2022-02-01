package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "", "userName", "", "angle", "", "mirror", "dataBitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;IILandroid/graphics/Bitmap;)V", "getAngle", "()I", "setAngle", "(I)V", "getDataBitmap", "()Landroid/graphics/Bitmap;", "setDataBitmap", "(Landroid/graphics/Bitmap;)V", "getMirror", "setMirror", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class af$a
{
  int Frq;
  Bitmap FuK;
  int mirror;
  private String userName;
  
  private af$a(String paramString)
  {
    AppMethodBeat.i(196814);
    this.userName = paramString;
    this.Frq = 0;
    this.mirror = 0;
    this.FuK = null;
    AppMethodBeat.o(196814);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196819);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.userName, paramObject.userName)) || (this.Frq != paramObject.Frq) || (this.mirror != paramObject.mirror) || (!p.h(this.FuK, paramObject.FuK))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196819);
      return true;
    }
    AppMethodBeat.o(196819);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(196817);
    Object localObject = this.userName;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.Frq;
      int m = this.mirror;
      localObject = this.FuK;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(196817);
      return ((i * 31 + k) * 31 + m) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196816);
    String str = "BitmapHolder(userName=" + this.userName + ", angle=" + this.Frq + ", mirror=" + this.mirror + ", dataBitmap=" + this.FuK + ")";
    AppMethodBeat.o(196816);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.af.a
 * JD-Core Version:    0.7.0.1
 */