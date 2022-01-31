package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class o
  implements m
{
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(35639);
    Object localObject = ag.cpf().lZ(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(35639);
      return;
    }
    localObject = ((n)localObject).csh();
    if (((TimeLineObject)localObject).xTS.wOa.size() > 0)
    {
      localObject = (bcs)((TimeLineObject)localObject).xTS.wOa.get(0);
      Bitmap localBitmap = ag.cpc().b((bcs)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(35639);
        return;
      }
      ag.cpc().b((bcs)localObject, paramImageView, paramInt, az.yNU);
    }
    AppMethodBeat.o(35639);
  }
  
  public final boolean lh(long paramLong)
  {
    AppMethodBeat.i(35638);
    n localn = ag.cpf().lZ(paramLong);
    if (localn == null)
    {
      AppMethodBeat.o(35638);
      return false;
    }
    if (localn.csh().xTS.wOa.size() > 0)
    {
      AppMethodBeat.o(35638);
      return true;
    }
    AppMethodBeat.o(35638);
    return false;
  }
  
  public final TimeLineObject uA(String paramString)
  {
    AppMethodBeat.i(35637);
    paramString = e.uA(paramString);
    AppMethodBeat.o(35637);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */