package com.tencent.mm.plugin.shake.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
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
      ((c.a)localObject).fullPath = m.ON(paramString);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).hZF = true;
      ((c.a)localObject).iaT = paramBoolean;
      if (paramInt != 0) {
        ((c.a)localObject).jbt = paramInt;
      }
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(28577);
  }
  
  public static String eVk()
  {
    AppMethodBeat.i(28578);
    Object localObject2 = m.eUn().eUe();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.e
 * JD-Core Version:    0.7.0.1
 */