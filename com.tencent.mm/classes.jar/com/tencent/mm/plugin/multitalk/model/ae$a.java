package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "", "userName", "", "angle", "", "mirror", "dataBitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;IILandroid/graphics/Bitmap;)V", "getAngle", "()I", "setAngle", "(I)V", "getDataBitmap", "()Landroid/graphics/Bitmap;", "setDataBitmap", "(Landroid/graphics/Bitmap;)V", "getMirror", "setMirror", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class ae$a
{
  int angle;
  int mirror;
  private String userName;
  Bitmap zPl;
  
  private ae$a(String paramString)
  {
    AppMethodBeat.i(239677);
    this.userName = paramString;
    this.angle = 0;
    this.mirror = 0;
    this.zPl = null;
    AppMethodBeat.o(239677);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(239680);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.userName, paramObject.userName)) || (this.angle != paramObject.angle) || (this.mirror != paramObject.mirror) || (!p.j(this.zPl, paramObject.zPl))) {}
      }
    }
    else
    {
      AppMethodBeat.o(239680);
      return true;
    }
    AppMethodBeat.o(239680);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(239679);
    Object localObject = this.userName;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.angle;
      int m = this.mirror;
      localObject = this.zPl;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(239679);
      return ((i * 31 + k) * 31 + m) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239678);
    String str = "BitmapHolder(userName=" + this.userName + ", angle=" + this.angle + ", mirror=" + this.mirror + ", dataBitmap=" + this.zPl + ")";
    AppMethodBeat.o(239678);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ae.a
 * JD-Core Version:    0.7.0.1
 */