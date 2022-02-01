package com.tencent.mm.timelineedit.a;

import com.google.d.ce.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.a.a.k;
import com.tencent.mm.timelineedit.a.a.u;
import com.tencent.mm.timelineedit.a.a.u.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/EditorConfig;", "Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Lcom/tencent/mm/timelineedit/model/pb/TimelineEditorConfig;", "Lcom/tencent/mm/timelineedit/model/pb/TimelineEditorConfig$Builder;", "()V", "value", "", "defaultImageDuration", "getDefaultImageDuration", "()J", "setDefaultImageDuration", "(J)V", "", "dragHorizontalTrack", "getDragHorizontalTrack", "()Z", "setDragHorizontalTrack", "(Z)V", "dragVerticalTrack", "getDragVerticalTrack", "setDragVerticalTrack", "", "editorDefaultPointX", "getEditorDefaultPointX", "()I", "setEditorDefaultPointX", "(I)V", "editorDefaultPointY", "getEditorDefaultPointY", "setEditorDefaultPointY", "", "editorMaxScale", "getEditorMaxScale", "()F", "setEditorMaxScale", "(F)V", "editorMinScale", "getEditorMinScale", "setEditorMinScale", "editorOutSideType", "getEditorOutSideType", "setEditorOutSideType", "enableOriginAudio", "getEnableOriginAudio", "setEnableOriginAudio", "trackMaxScale", "getTrackMaxScale", "setTrackMaxScale", "trackOutSideType", "getTrackOutSideType", "setTrackOutSideType", "parseFrom", "", "data", "", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class c
  extends d<u, u.a>
{
  public c()
  {
    AppMethodBeat.i(232071);
    u.a locala = u.jge();
    s.r(locala, "TimelineEditorConfig.newBuilder()");
    a((ce.a)locala);
    ((u.a)jeC()).KM(true);
    ((u.a)jeC()).KL(true);
    ((u.a)jeC()).dK(0.5F);
    ((u.a)jeC()).dL(3.0F);
    ((u.a)jeC()).dJ(3.0F);
    ((u.a)jeC()).a(k.adqu);
    ((u.a)jeC()).b(k.adqu);
    ((u.a)jeC()).zs(4000L);
    AppMethodBeat.o(232071);
  }
  
  public final void KH(boolean paramBoolean)
  {
    AppMethodBeat.i(232089);
    ((u.a)jeC()).KN(paramBoolean);
    AppMethodBeat.o(232089);
  }
  
  public final void azt(int paramInt)
  {
    AppMethodBeat.i(232076);
    ((u.a)jeC()).azI(paramInt);
    AppMethodBeat.o(232076);
  }
  
  public final void azu(int paramInt)
  {
    AppMethodBeat.i(232083);
    ((u.a)jeC()).azJ(paramInt);
    AppMethodBeat.o(232083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.c
 * JD-Core Version:    0.7.0.1
 */