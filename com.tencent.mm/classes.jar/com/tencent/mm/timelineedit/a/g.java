package com.tencent.mm.timelineedit.a;

import android.graphics.Rect;
import com.google.d.ce.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.a.a.aa;
import com.tencent.mm.timelineedit.a.a.aa.a;
import com.tencent.mm.timelineedit.a.a.i;
import com.tencent.mm.timelineedit.a.a.i.a;
import com.tencent.mm.timelineedit.a.a.o;
import com.tencent.mm.timelineedit.a.a.p;
import com.tencent.mm.timelineedit.a.a.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/Track;", "Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Lcom/tencent/mm/timelineedit/model/pb/TrackInfoProto;", "Lcom/tencent/mm/timelineedit/model/pb/TrackInfoProto$Builder;", "()V", "value", "", "contentCrop", "getContentCrop", "()I", "setContentCrop", "(I)V", "cropInfoBuilder", "Lcom/tencent/mm/timelineedit/model/pb/CropInfoProto$Builder;", "kotlin.jvm.PlatformType", "Landroid/graphics/Rect;", "displayRect", "getDisplayRect", "()Landroid/graphics/Rect;", "setDisplayRect", "(Landroid/graphics/Rect;)V", "", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "Lcom/tencent/mm/timelineedit/model/Size;", "resolution", "getResolution", "()Lcom/tencent/mm/timelineedit/model/Size;", "setResolution", "(Lcom/tencent/mm/timelineedit/model/Size;)V", "rotate", "getRotate", "setRotate", "", "sourceDuration", "getSourceDuration", "()J", "setSourceDuration", "(J)V", "Lcom/tencent/mm/timelineedit/model/TimeRange;", "sourceRange", "getSourceRange", "()Lcom/tencent/mm/timelineedit/model/TimeRange;", "setSourceRange", "(Lcom/tencent/mm/timelineedit/model/TimeRange;)V", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackId", "getTrackId", "setTrackId", "trackRange", "getTrackRange", "setTrackRange", "trackType", "getTrackType", "setTrackType", "volume", "getVolume", "setVolume", "parseFrom", "", "data", "", "toString", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class g
  extends d<aa, aa.a>
{
  private i.a adpE;
  
  public g()
  {
    AppMethodBeat.i(232073);
    this.adpE = i.jfH();
    aa.a locala = aa.jgH();
    s.r(locala, "TrackInfoProto.newBuilder()");
    a((ce.a)locala);
    AppMethodBeat.o(232073);
  }
  
  public final void I(Rect paramRect)
  {
    AppMethodBeat.i(232167);
    s.t(paramRect, "value");
    i.a locala = this.adpE;
    s.r(locala, "cropInfoBuilder");
    locala.f(a.H(paramRect));
    ((aa.a)jeC()).d(this.adpE.jfL());
    AppMethodBeat.o(232167);
  }
  
  public final void J(Rect paramRect)
  {
    AppMethodBeat.i(232172);
    s.t(paramRect, "value");
    i.a locala = this.adpE;
    s.r(locala, "cropInfoBuilder");
    locala.h(a.H(paramRect));
    ((aa.a)jeC()).d(this.adpE.jfL());
    AppMethodBeat.o(232172);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(232153);
    s.t(parame, "value");
    ((aa.a)jeC()).azM(parame.width);
    ((aa.a)jeC()).azN(parame.height);
    AppMethodBeat.o(232153);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(232118);
    s.t(paramf, "value");
    ((aa.a)jeC()).zv(paramf.startTimeMs);
    ((aa.a)jeC()).zw(paramf.endTimeMs);
    AppMethodBeat.o(232118);
  }
  
  public final void azv(int paramInt)
  {
    AppMethodBeat.i(232099);
    aa.a locala = (aa.a)jeC();
    o localo;
    switch (paramInt)
    {
    default: 
      localo = o.adqI;
    }
    for (;;)
    {
      locala.b(localo);
      AppMethodBeat.o(232099);
      return;
      localo = o.adqK;
      continue;
      localo = o.adqL;
      continue;
      localo = o.adqJ;
    }
  }
  
  public final void azw(int paramInt)
  {
    AppMethodBeat.i(232159);
    aa.a locala = (aa.a)jeC();
    p localp;
    switch (paramInt)
    {
    default: 
      localp = p.adqS;
    }
    for (;;)
    {
      locala.b(localp);
      AppMethodBeat.o(232159);
      return;
      localp = p.adqQ;
      continue;
      localp = p.adqR;
      continue;
      localp = p.adqP;
    }
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(232121);
    s.t(paramf, "value");
    ((aa.a)jeC()).zx(paramf.startTimeMs);
    ((aa.a)jeC()).zy(paramf.endTimeMs);
    AppMethodBeat.o(232121);
  }
  
  public final void dj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232178);
    s.t(paramArrayOfByte, "data");
    paramArrayOfByte = aa.dm(paramArrayOfByte).jgI();
    s.r(paramArrayOfByte, "TrackInfoProto.parseFrom(data).toBuilder()");
    a((ce.a)paramArrayOfByte);
    this.adpE = ((aa.a)jeC()).jgB().jfI();
    AppMethodBeat.o(232178);
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(232087);
    String str = ((aa.a)jeC()).getPath();
    s.r(str, "innerBuilder.path");
    AppMethodBeat.o(232087);
    return str;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(232145);
    long l = ((aa.a)jeC()).getSourceDuration();
    AppMethodBeat.o(232145);
    return l;
  }
  
  public final int getTrackType()
  {
    AppMethodBeat.i(232095);
    o localo = ((aa.a)jeC()).jgx();
    s.r(localo, "innerBuilder.type");
    int i = a.a(localo);
    AppMethodBeat.o(232095);
    return i;
  }
  
  public final f jeE()
  {
    AppMethodBeat.i(232110);
    f localf = new f(((aa.a)jeC()).getStartTimeMs(), ((aa.a)jeC()).getEndTimeMs());
    AppMethodBeat.o(232110);
    return localf;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(232092);
    s.t(paramString, "value");
    ((aa.a)jeC()).bzy(paramString);
    AppMethodBeat.o(232092);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(232126);
    ((aa.a)jeC()).dP(paramFloat);
    AppMethodBeat.o(232126);
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(232134);
    ((aa.a)jeC()).dO(paramFloat);
    AppMethodBeat.o(232134);
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(232138);
    ((aa.a)jeC()).azO(paramInt);
    AppMethodBeat.o(232138);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232186);
    Object localObject1 = new StringBuilder("Track(trackId:").append(((aa.a)jeC()).getId()).append(" path:").append(getPath()).append(" trackType:").append(getTrackType()).append(" source:").append(jeE()).append("  track:").append(new f(((aa.a)jeC()).jgy(), ((aa.a)jeC()).jgz())).append(" playRate:").append(((aa.a)jeC()).getPlayRate()).append(" volume:").append(((aa.a)jeC()).getVolume()).append(" rotate:").append(((aa.a)jeC()).hRY()).append(" resolution:").append(new e(((aa.a)jeC()).ejR(), ((aa.a)jeC()).ejS())).append(" contentCrop:");
    Object localObject2 = ((aa.a)jeC()).jgE();
    s.r(localObject2, "innerBuilder.contentCrop");
    localObject1 = ((StringBuilder)localObject1).append(a.a((p)localObject2)).append(" displayRect:");
    localObject2 = ((aa.a)jeC()).jgB();
    s.r(localObject2, "innerBuilder.cropInfo");
    localObject2 = ((i)localObject2).jfG();
    s.r(localObject2, "innerBuilder.cropInfo.displayRect");
    localObject1 = a.a((q)localObject2) + ')';
    AppMethodBeat.o(232186);
    return localObject1;
  }
  
  public final void zl(long paramLong)
  {
    AppMethodBeat.i(232079);
    ((aa.a)jeC()).zu(paramLong);
    AppMethodBeat.o(232079);
  }
  
  public final void zm(long paramLong)
  {
    AppMethodBeat.i(232148);
    ((aa.a)jeC()).zz(paramLong);
    AppMethodBeat.o(232148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.g
 * JD-Core Version:    0.7.0.1
 */