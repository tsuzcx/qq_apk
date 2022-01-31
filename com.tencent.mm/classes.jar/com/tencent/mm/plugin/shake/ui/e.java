package com.tencent.mm.plugin.shake.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static void a(ImageView paramImageView, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(24908);
    if (paramImageView == null)
    {
      AppMethodBeat.o(24908);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eNO = m.tr(paramString);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOe = true;
      ((c.a)localObject).eOk = paramBoolean;
      if (paramInt != 0) {
        ((c.a)localObject).eOa = paramInt;
      }
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(24908);
  }
  
  public static String cmo()
  {
    AppMethodBeat.i(24909);
    Object localObject2 = m.clo().clf();
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append(((f)((Iterator)localObject2).next()).field_reserved1);
      ((StringBuilder)localObject1).append("|");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(24909);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.e
 * JD-Core Version:    0.7.0.1
 */