package com.tencent.mm.plugin.shake.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.shake.model.f;
import com.tencent.mm.plugin.shake.model.g;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static void a(ImageView paramImageView, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28577);
    if (paramImageView == null)
    {
      AppMethodBeat.o(28577);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).fullPath = m.Ol(paramString);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nqa = true;
      ((c.a)localObject).nrc = paramBoolean;
      if (paramInt != 0) {
        ((c.a)localObject).oKE = paramInt;
      }
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(28577);
  }
  
  public static String gYf()
  {
    AppMethodBeat.i(28578);
    Object localObject2 = m.gXe().gWU();
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append(((f)((Iterator)localObject2).next()).field_reserved1);
      ((StringBuilder)localObject1).append("|");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(28578);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.e
 * JD-Core Version:    0.7.0.1
 */