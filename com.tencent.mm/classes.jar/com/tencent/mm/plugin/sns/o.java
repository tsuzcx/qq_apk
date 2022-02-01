package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.storage.bf;
import java.util.LinkedList;

public final class o
  implements n
{
  public final TimeLineObject Ds(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = g.Ds(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = af.dHR().xK(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((p)localObject).dLV();
    if (((TimeLineObject)localObject).FQo.Etz.size() > 0)
    {
      localObject = (btz)((TimeLineObject)localObject).FQo.Etz.get(0);
      Bitmap localBitmap = af.dHO().a((btz)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      af.dHO().b((btz)localObject, paramImageView, paramInt, bf.GYH);
    }
    AppMethodBeat.o(94915);
  }
  
  public final boolean wK(long paramLong)
  {
    AppMethodBeat.i(94914);
    p localp = af.dHR().xK(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localp.dLV().FQo.Etz.size() > 0)
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