package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;
import java.util.LinkedList;

public final class o
  implements com.tencent.mm.plugin.sns.b.n
{
  public final boolean IM(long paramLong)
  {
    AppMethodBeat.i(94914);
    SnsInfo localSnsInfo = aj.faO().JJ(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localSnsInfo.getTimeLine().ContentObj.LoV.size() > 0)
    {
      AppMethodBeat.o(94914);
      return true;
    }
    AppMethodBeat.o(94914);
    return false;
  }
  
  public final TimeLineObject PM(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = com.tencent.mm.modelsns.n.PM(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = aj.faO().JJ(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if (((TimeLineObject)localObject).ContentObj.LoV.size() > 0)
    {
      localObject = (cnb)((TimeLineObject)localObject).ContentObj.LoV.get(0);
      Bitmap localBitmap = aj.faL().b((cnb)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      aj.faL().b((cnb)localObject, paramImageView, paramInt, bp.Oqt);
    }
    AppMethodBeat.o(94915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.o
 * JD-Core Version:    0.7.0.1
 */