package com.tencent.mm.plugin.textstatus.f.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "username", "", "headerType", "", "(Ljava/lang/String;I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getHeaderType", "()I", "getUsername", "()Ljava/lang/String;", "getAvatarDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getItemId", "", "getItemType", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public Bitmap bitmap;
  public final String username;
  private final int xnH;
  
  public a(String paramString, int paramInt)
  {
    this.username = paramString;
    this.xnH = paramInt;
  }
  
  public final int cxn()
  {
    return this.xnH;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(216237);
    long l = hashCode();
    AppMethodBeat.o(216237);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.d.a
 * JD-Core Version:    0.7.0.1
 */