package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "", "userName", "", "angle", "", "mirror", "videoBitmap", "Landroid/graphics/Bitmap;", "avatarBitmap", "(Ljava/lang/String;IILandroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "getAngle", "()I", "setAngle", "(I)V", "getAvatarBitmap", "()Landroid/graphics/Bitmap;", "setAvatarBitmap", "(Landroid/graphics/Bitmap;)V", "getMirror", "setMirror", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "getVideoBitmap", "setVideoBitmap", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class ab$a
{
  public int angle;
  Bitmap joW;
  public int mirror;
  String userName;
  public Bitmap wdv;
  
  private ab$a(String paramString)
  {
    AppMethodBeat.i(206695);
    this.userName = paramString;
    this.angle = 0;
    this.mirror = 0;
    this.wdv = null;
    this.joW = null;
    AppMethodBeat.o(206695);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206698);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.userName, paramObject.userName)) || (this.angle != paramObject.angle) || (this.mirror != paramObject.mirror) || (!p.i(this.wdv, paramObject.wdv)) || (!p.i(this.joW, paramObject.joW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(206698);
      return true;
    }
    AppMethodBeat.o(206698);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(206697);
    Object localObject = this.userName;
    int i;
    int m;
    int n;
    if (localObject != null)
    {
      i = localObject.hashCode();
      m = this.angle;
      n = this.mirror;
      localObject = this.wdv;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.joW;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(206697);
      return (j + ((i * 31 + m) * 31 + n) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206696);
    String str = "BitmapHolder(userName=" + this.userName + ", angle=" + this.angle + ", mirror=" + this.mirror + ", videoBitmap=" + this.wdv + ", avatarBitmap=" + this.joW + ")";
    AppMethodBeat.o(206696);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ab.a
 * JD-Core Version:    0.7.0.1
 */