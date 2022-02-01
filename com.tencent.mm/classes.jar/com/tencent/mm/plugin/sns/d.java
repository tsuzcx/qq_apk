package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.c.p;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.storage.br;
import java.util.LinkedList;

public final class d
  implements p
{
  public final TimeLineObject Pm(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = o.Pm(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = al.hgB().vj(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if (((TimeLineObject)localObject).ContentObj.Zpr.size() > 0)
    {
      localObject = (dmz)((TimeLineObject)localObject).ContentObj.Zpr.get(0);
      Bitmap localBitmap = al.hgy().a((dmz)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      al.hgy().b((dmz)localObject, paramImageView, paramInt, br.adkd);
    }
    AppMethodBeat.o(94915);
  }
  
  public final boolean ul(long paramLong)
  {
    AppMethodBeat.i(94914);
    SnsInfo localSnsInfo = al.hgB().vj(paramLong);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localSnsInfo.getTimeLine().ContentObj.Zpr.size() > 0)
    {
      AppMethodBeat.o(94914);
      return true;
    }
    AppMethodBeat.o(94914);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d
 * JD-Core Version:    0.7.0.1
 */