package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.storage.bk;
import java.util.LinkedList;

public final class o
  implements n
{
  public final TimeLineObject GZ(String paramString)
  {
    AppMethodBeat.i(94913);
    paramString = h.GZ(paramString);
    AppMethodBeat.o(94913);
    return paramString;
  }
  
  public final void a(long paramLong, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(94915);
    Object localObject = ah.dXE().AG(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(94915);
      return;
    }
    localObject = ((p)localObject).ebP();
    if (((TimeLineObject)localObject).HUG.Gtx.size() > 0)
    {
      localObject = (bzh)((TimeLineObject)localObject).HUG.Gtx.get(0);
      Bitmap localBitmap = ah.dXB().a((bzh)localObject);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(94915);
        return;
      }
      ah.dXB().b((bzh)localObject, paramImageView, paramInt, bk.JgC);
    }
    AppMethodBeat.o(94915);
  }
  
  public final boolean zI(long paramLong)
  {
    AppMethodBeat.i(94914);
    p localp = ah.dXE().AG(paramLong);
    if (localp == null)
    {
      AppMethodBeat.o(94914);
      return false;
    }
    if (localp.ebP().HUG.Gtx.size() > 0)
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