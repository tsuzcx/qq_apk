package com.tencent.mm.timelineedit.a;

import com.google.b.bw.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.a.a.k;
import com.tencent.mm.timelineedit.a.a.u;
import com.tencent.mm.timelineedit.a.a.u.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/model/EditorConfig;", "Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Lcom/tencent/mm/timelineedit/model/pb/TimelineEditorConfig;", "Lcom/tencent/mm/timelineedit/model/pb/TimelineEditorConfig$Builder;", "()V", "value", "", "defaultImageDuration", "getDefaultImageDuration", "()J", "setDefaultImageDuration", "(J)V", "", "dragHorizontalTrack", "getDragHorizontalTrack", "()Z", "setDragHorizontalTrack", "(Z)V", "dragVerticalTrack", "getDragVerticalTrack", "setDragVerticalTrack", "", "editorDefaultPointX", "getEditorDefaultPointX", "()I", "setEditorDefaultPointX", "(I)V", "editorDefaultPointY", "getEditorDefaultPointY", "setEditorDefaultPointY", "", "editorMaxScale", "getEditorMaxScale", "()F", "setEditorMaxScale", "(F)V", "editorMinScale", "getEditorMinScale", "setEditorMinScale", "editorOutSideType", "getEditorOutSideType", "setEditorOutSideType", "enableOriginAudio", "getEnableOriginAudio", "setEnableOriginAudio", "trackMaxScale", "getTrackMaxScale", "setTrackMaxScale", "trackOutSideType", "getTrackOutSideType", "setTrackOutSideType", "parseFrom", "", "data", "", "timelinelib_release"})
public final class c
  extends d<u, u.a>
{
  public c()
  {
    AppMethodBeat.i(262053);
    u.a locala = u.hDU();
    p.j(locala, "TimelineEditorConfig.newBuilder()");
    a((bw.a)locala);
    ((u.a)hCw()).Fc(true);
    ((u.a)hCw()).Fb(true);
    ((u.a)hCw()).cy(0.5F);
    ((u.a)hCw()).cz(3.0F);
    ((u.a)hCw()).cx(3.0F);
    ((u.a)hCw()).a(k.VMp);
    ((u.a)hCw()).b(k.VMp);
    ((u.a)hCw()).Vk(4000L);
    AppMethodBeat.o(262053);
  }
  
  public final void EX(boolean paramBoolean)
  {
    AppMethodBeat.i(262051);
    ((u.a)hCw()).Fd(paramBoolean);
    AppMethodBeat.o(262051);
  }
  
  public final void atd(int paramInt)
  {
    AppMethodBeat.i(262048);
    ((u.a)hCw()).ats(paramInt);
    AppMethodBeat.o(262048);
  }
  
  public final void ate(int paramInt)
  {
    AppMethodBeat.i(262050);
    ((u.a)hCw()).att(paramInt);
    AppMethodBeat.o(262050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.c
 * JD-Core Version:    0.7.0.1
 */