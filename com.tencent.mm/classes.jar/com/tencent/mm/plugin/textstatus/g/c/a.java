package com.tencent.mm.plugin.textstatus.g.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "username", "", "headerType", "", "(Ljava/lang/String;I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getHeaderType", "()I", "getUsername", "()Ljava/lang/String;", "getAvatarDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getItemId", "", "getItemType", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  private final int BZZ;
  public Bitmap bitmap;
  public final String username;
  
  public a(String paramString, int paramInt)
  {
    this.username = paramString;
    this.BZZ = paramInt;
  }
  
  public final int bAQ()
  {
    return this.BZZ;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(235894);
    long l = hashCode();
    AppMethodBeat.o(235894);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.c.a
 * JD-Core Version:    0.7.0.1
 */