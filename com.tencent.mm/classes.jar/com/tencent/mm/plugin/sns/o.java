package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.plugin.sns.c.n;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.storage.bc;
import java.util.LinkedList;

public final class o
  implements n
{
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = af.dtu().th(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((p)localObject).dxy();
    if (((TimeLineObject)localObject).Etm.DaC.size() > 0)
    {
      localObject = (bpi)((TimeLineObject)localObject).Etm.DaC.get(0);
      Bitmap localBitmap = af.dtr().a((bpi)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      af.dtr().b((bpi)localObject, paramImageView, paramInt, bc.FzF);
    }
    AppMethodBeat.o(94915);
  }
  
  public final boolean sh(long paramLong)
  {
    AppMethodBeat.i(94914);
    p localp = af.dtu().th(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localp.dxy().Etm.DaC.size() > 0)
    {
      AppMethodBeat.o(94914);
      return true;
    }
    AppMethodBeat.o(94914);
    return false;
  }
  
  public final TimeLineObject zn(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = g.zn(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */