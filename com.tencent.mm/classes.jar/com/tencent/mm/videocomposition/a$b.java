package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a$b
{
  final long GvM;
  final CMTime GvN;
  final m<Long, Bitmap, ah> mgM;
  
  private a$b(long paramLong, m<? super Long, ? super Bitmap, ah> paramm, CMTime paramCMTime)
  {
    AppMethodBeat.i(233468);
    this.GvM = paramLong;
    this.mgM = paramm;
    this.GvN = paramCMTime;
    AppMethodBeat.o(233468);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(233505);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label80;
      }
      paramObject = (b)paramObject;
      if (this.GvM != paramObject.GvM) {
        break label75;
      }
    }
    label75:
    for (int i = 1; (i != 0) && (s.p(this.mgM, paramObject.mgM)) && (s.p(this.GvN, paramObject.GvN)); i = 0)
    {
      AppMethodBeat.o(233505);
      return true;
    }
    label80:
    AppMethodBeat.o(233505);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(233493);
    long l = this.GvM;
    int k = (int)(l ^ l >>> 32);
    Object localObject = this.mgM;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.GvN;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(233493);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(233486);
    String str = "Request(timeMs=" + this.GvM + ", callback=" + this.mgM + ", cmTime=" + this.GvN + ")";
    AppMethodBeat.o(233486);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a.b
 * JD-Core Version:    0.7.0.1
 */