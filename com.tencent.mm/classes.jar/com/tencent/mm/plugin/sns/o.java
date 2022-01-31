package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class o
  implements m
{
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    Object localObject = af.bDF().gt(paramLong);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((n)localObject).bGe();
    } while (((bxk)localObject).tNr.sPJ.size() <= 0);
    localObject = (awd)((bxk)localObject).tNr.sPJ.get(0);
    Bitmap localBitmap = af.bDC().b((awd)localObject);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    af.bDC().b((awd)localObject, paramImageView, paramInt, az.uBK);
  }
  
  public final boolean fE(long paramLong)
  {
    n localn = af.bDF().gt(paramLong);
    if (localn == null) {}
    while (localn.bGe().tNr.sPJ.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public final bxk nn(String paramString)
  {
    return e.nn(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */