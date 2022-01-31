package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static void a(ImageView paramImageView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView.setImageBitmap(null);
    } while (bk.bl(paramString));
    Object localObject = new c.a();
    ((c.a)localObject).erh = m.mm(paramString);
    ((c.a)localObject).erf = true;
    ((c.a)localObject).erC = true;
    ((c.a)localObject).erD = paramBoolean;
    if (paramInt != 0) {
      ((c.a)localObject).ery = paramInt;
    }
    localObject = ((c.a)localObject).OV();
    o.ON().a(paramString, paramImageView, (c)localObject);
  }
  
  public static String bAS()
  {
    Object localObject2 = m.bzV();
    Object localObject1 = new ArrayList();
    Object localObject3 = "SELECT * FROM " + ((g)localObject2).getTableName() + " where status != 1";
    localObject2 = ((g)localObject2).dXw.a((String)localObject3, null, 2);
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new f();
        ((f)localObject3).d((Cursor)localObject2);
        ((List)localObject1).add(localObject3);
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new StringBuilder();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject2).append(((f)((Iterator)localObject1).next()).field_reserved1);
      ((StringBuilder)localObject2).append("|");
    }
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.e
 * JD-Core Version:    0.7.0.1
 */