package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.storage.bp;
import java.util.LinkedList;

public final class o
  implements com.tencent.mm.plugin.sns.b.o
{
  public final boolean Qf(long paramLong)
  {
    AppMethodBeat.i(94914);
    SnsInfo localSnsInfo = aj.fOI().Rd(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localSnsInfo.getTimeLine().ContentObj.Sqr.size() > 0)
    {
      AppMethodBeat.o(94914);
      return true;
    }
    AppMethodBeat.o(94914);
    return false;
  }
  
  public final TimeLineObject Xk(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = com.tencent.mm.modelsns.o.Xk(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = aj.fOI().Rd(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if (((TimeLineObject)localObject).ContentObj.Sqr.size() > 0)
    {
      localObject = (cvt)((TimeLineObject)localObject).ContentObj.Sqr.get(0);
      Bitmap localBitmap = aj.fOF().a((cvt)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      aj.fOF().b((cvt)localObject, paramImageView, paramInt, bp.VGp);
    }
    AppMethodBeat.o(94915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */