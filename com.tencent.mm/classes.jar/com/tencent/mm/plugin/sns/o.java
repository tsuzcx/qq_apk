package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;

public final class o
  implements n
{
  public final TimeLineObject Gx(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = h.Gx(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = ag.dUe().Ai(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((p)localObject).dYl();
    if (((TimeLineObject)localObject).HAT.GaQ.size() > 0)
    {
      localObject = (byn)((TimeLineObject)localObject).HAT.GaQ.get(0);
      Bitmap localBitmap = ag.dUb().a((byn)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      ag.dUb().b((byn)localObject, paramImageView, paramInt, bj.ILV);
    }
    AppMethodBeat.o(94915);
  }
  
  public final boolean zk(long paramLong)
  {
    AppMethodBeat.i(94914);
    p localp = ag.dUe().Ai(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localp.dYl().HAT.GaQ.size() > 0)
    {
      AppMethodBeat.o(94914);
      return true;
    }
    AppMethodBeat.o(94914);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */