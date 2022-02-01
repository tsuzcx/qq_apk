package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "", "userName", "", "angle", "", "mirror", "dataBitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;IILandroid/graphics/Bitmap;)V", "getAngle", "()I", "setAngle", "(I)V", "getDataBitmap", "()Landroid/graphics/Bitmap;", "setDataBitmap", "(Landroid/graphics/Bitmap;)V", "getMirror", "setMirror", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae$a
{
  int LnD;
  Bitmap Lrc;
  int mirror;
  private String userName;
  
  private ae$a(String paramString)
  {
    AppMethodBeat.i(284946);
    this.userName = paramString;
    this.LnD = 0;
    this.mirror = 0;
    this.Lrc = null;
    AppMethodBeat.o(284946);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(284960);
    if (this == paramObject)
    {
      AppMethodBeat.o(284960);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(284960);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(284960);
      return false;
    }
    if (this.LnD != paramObject.LnD)
    {
      AppMethodBeat.o(284960);
      return false;
    }
    if (this.mirror != paramObject.mirror)
    {
      AppMethodBeat.o(284960);
      return false;
    }
    if (!s.p(this.Lrc, paramObject.Lrc))
    {
      AppMethodBeat.o(284960);
      return false;
    }
    AppMethodBeat.o(284960);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(284957);
    int j = this.userName.hashCode();
    int k = this.LnD;
    int m = this.mirror;
    if (this.Lrc == null) {}
    for (int i = 0;; i = this.Lrc.hashCode())
    {
      AppMethodBeat.o(284957);
      return i + ((j * 31 + k) * 31 + m) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(284955);
    String str = "BitmapHolder(userName=" + this.userName + ", angle=" + this.LnD + ", mirror=" + this.mirror + ", dataBitmap=" + this.Lrc + ')';
    AppMethodBeat.o(284955);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ae.a
 * JD-Core Version:    0.7.0.1
 */