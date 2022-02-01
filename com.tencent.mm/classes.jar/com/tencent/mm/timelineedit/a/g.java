package com.tencent.mm.timelineedit.a;

import android.graphics.Rect;
import com.google.b.bw.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.a.a.aa;
import com.tencent.mm.timelineedit.a.a.aa.a;
import com.tencent.mm.timelineedit.a.a.i;
import com.tencent.mm.timelineedit.a.a.i.a;
import com.tencent.mm.timelineedit.a.a.o;
import com.tencent.mm.timelineedit.a.a.q;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/model/Track;", "Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Lcom/tencent/mm/timelineedit/model/pb/TrackInfoProto;", "Lcom/tencent/mm/timelineedit/model/pb/TrackInfoProto$Builder;", "()V", "value", "", "contentCrop", "getContentCrop", "()I", "setContentCrop", "(I)V", "cropInfoBuilder", "Lcom/tencent/mm/timelineedit/model/pb/CropInfoProto$Builder;", "kotlin.jvm.PlatformType", "Landroid/graphics/Rect;", "displayRect", "getDisplayRect", "()Landroid/graphics/Rect;", "setDisplayRect", "(Landroid/graphics/Rect;)V", "", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "Lcom/tencent/mm/timelineedit/model/Size;", "resolution", "getResolution", "()Lcom/tencent/mm/timelineedit/model/Size;", "setResolution", "(Lcom/tencent/mm/timelineedit/model/Size;)V", "rotate", "getRotate", "setRotate", "", "sourceDuration", "getSourceDuration", "()J", "setSourceDuration", "(J)V", "Lcom/tencent/mm/timelineedit/model/TimeRange;", "sourceRange", "getSourceRange", "()Lcom/tencent/mm/timelineedit/model/TimeRange;", "setSourceRange", "(Lcom/tencent/mm/timelineedit/model/TimeRange;)V", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackId", "getTrackId", "setTrackId", "trackRange", "getTrackRange", "setTrackRange", "trackType", "getTrackType", "setTrackType", "volume", "getVolume", "setVolume", "parseFrom", "", "data", "", "toString", "timelinelib_release"})
public final class g
  extends d<aa, aa.a>
{
  private i.a VLz;
  
  public g()
  {
    AppMethodBeat.i(262119);
    this.VLz = i.hDz();
    aa.a locala = aa.hEv();
    kotlin.g.b.p.j(locala, "TrackInfoProto.newBuilder()");
    a((bw.a)locala);
    AppMethodBeat.o(262119);
  }
  
  public final void A(Rect paramRect)
  {
    AppMethodBeat.i(262114);
    kotlin.g.b.p.k(paramRect, "value");
    i.a locala = this.VLz;
    kotlin.g.b.p.j(locala, "cropInfoBuilder");
    locala.f(a.z(paramRect));
    ((aa.a)hCw()).d(this.VLz.hDC());
    AppMethodBeat.o(262114);
  }
  
  public final void B(Rect paramRect)
  {
    AppMethodBeat.i(262116);
    kotlin.g.b.p.k(paramRect, "value");
    i.a locala = this.VLz;
    kotlin.g.b.p.j(locala, "cropInfoBuilder");
    locala.h(a.z(paramRect));
    ((aa.a)hCw()).d(this.VLz.hDC());
    AppMethodBeat.o(262116);
  }
  
  public final void Vd(long paramLong)
  {
    AppMethodBeat.i(262090);
    ((aa.a)hCw()).Vm(paramLong);
    AppMethodBeat.o(262090);
  }
  
  public final void Ve(long paramLong)
  {
    AppMethodBeat.i(262111);
    ((aa.a)hCw()).Vr(paramLong);
    AppMethodBeat.o(262111);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(262112);
    kotlin.g.b.p.k(parame, "value");
    ((aa.a)hCw()).atw(parame.width);
    ((aa.a)hCw()).atx(parame.height);
    AppMethodBeat.o(262112);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(262102);
    kotlin.g.b.p.k(paramf, "value");
    ((aa.a)hCw()).Vn(paramf.startTimeMs);
    ((aa.a)hCw()).Vo(paramf.endTimeMs);
    AppMethodBeat.o(262102);
  }
  
  public final void atf(int paramInt)
  {
    AppMethodBeat.i(262098);
    aa.a locala = (aa.a)hCw();
    o localo;
    switch (paramInt)
    {
    default: 
      localo = o.VMD;
    }
    for (;;)
    {
      locala.b(localo);
      AppMethodBeat.o(262098);
      return;
      localo = o.VMF;
      continue;
      localo = o.VMG;
      continue;
      localo = o.VME;
    }
  }
  
  public final void atg(int paramInt)
  {
    AppMethodBeat.i(262113);
    aa.a locala = (aa.a)hCw();
    com.tencent.mm.timelineedit.a.a.p localp;
    switch (paramInt)
    {
    default: 
      localp = com.tencent.mm.timelineedit.a.a.p.VMN;
    }
    for (;;)
    {
      locala.b(localp);
      AppMethodBeat.o(262113);
      return;
      localp = com.tencent.mm.timelineedit.a.a.p.VML;
      continue;
      localp = com.tencent.mm.timelineedit.a.a.p.VMM;
      continue;
      localp = com.tencent.mm.timelineedit.a.a.p.VMK;
    }
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(262104);
    kotlin.g.b.p.k(paramf, "value");
    ((aa.a)hCw()).Vp(paramf.startTimeMs);
    ((aa.a)hCw()).Vq(paramf.endTimeMs);
    AppMethodBeat.o(262104);
  }
  
  public final void dg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262117);
    kotlin.g.b.p.k(paramArrayOfByte, "data");
    paramArrayOfByte = aa.dj(paramArrayOfByte).hEw();
    kotlin.g.b.p.j(paramArrayOfByte, "TrackInfoProto.parseFrom(data).toBuilder()");
    a((bw.a)paramArrayOfByte);
    this.VLz = ((aa.a)hCw()).hEp().hDA();
    AppMethodBeat.o(262117);
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(262093);
    String str = ((aa.a)hCw()).getPath();
    kotlin.g.b.p.j(str, "innerBuilder.path");
    AppMethodBeat.o(262093);
    return str;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(262110);
    long l = ((aa.a)hCw()).getSourceDuration();
    AppMethodBeat.o(262110);
    return l;
  }
  
  public final int getTrackType()
  {
    AppMethodBeat.i(262096);
    o localo = ((aa.a)hCw()).hEl();
    kotlin.g.b.p.j(localo, "innerBuilder.type");
    int i = a.a(localo);
    AppMethodBeat.o(262096);
    return i;
  }
  
  public final f hCy()
  {
    AppMethodBeat.i(262100);
    f localf = new f(((aa.a)hCw()).getStartTimeMs(), ((aa.a)hCw()).getEndTimeMs());
    AppMethodBeat.o(262100);
    return localf;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(262094);
    kotlin.g.b.p.k(paramString, "value");
    ((aa.a)hCw()).byd(paramString);
    AppMethodBeat.o(262094);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(262105);
    ((aa.a)hCw()).cD(paramFloat);
    AppMethodBeat.o(262105);
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(262107);
    ((aa.a)hCw()).cC(paramFloat);
    AppMethodBeat.o(262107);
  }
  
  public final void tm(int paramInt)
  {
    AppMethodBeat.i(262108);
    ((aa.a)hCw()).aty(paramInt);
    AppMethodBeat.o(262108);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262118);
    Object localObject1 = new StringBuilder("Track(trackId:").append(((aa.a)hCw()).getId()).append(" path:").append(getPath()).append(" trackType:").append(getTrackType()).append(" source:").append(hCy()).append("  track:").append(new f(((aa.a)hCw()).hEm(), ((aa.a)hCw()).hEn())).append(" playRate:").append(((aa.a)hCw()).getPlayRate()).append(" volume:").append(((aa.a)hCw()).getVolume()).append(" rotate:").append(((aa.a)hCw()).aVr()).append(" resolution:").append(new e(((aa.a)hCw()).hEB(), ((aa.a)hCw()).hEC())).append(" contentCrop:");
    Object localObject2 = ((aa.a)hCw()).hEs();
    kotlin.g.b.p.j(localObject2, "innerBuilder.contentCrop");
    localObject1 = ((StringBuilder)localObject1).append(a.a((com.tencent.mm.timelineedit.a.a.p)localObject2)).append(" displayRect:");
    localObject2 = ((aa.a)hCw()).hEp();
    kotlin.g.b.p.j(localObject2, "innerBuilder.cropInfo");
    localObject2 = ((i)localObject2).hDy();
    kotlin.g.b.p.j(localObject2, "innerBuilder.cropInfo.displayRect");
    localObject1 = a.a((q)localObject2) + ')';
    AppMethodBeat.o(262118);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.g
 * JD-Core Version:    0.7.0.1
 */