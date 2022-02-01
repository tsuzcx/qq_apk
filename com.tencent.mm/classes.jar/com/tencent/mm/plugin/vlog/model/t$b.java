package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import d.g.a.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "plugin-vlog_release"})
public final class t$b
{
  final long Aoq;
  final CMTime cmTime;
  final m<Long, Bitmap, y> fPF;
  
  private t$b(long paramLong, m<? super Long, ? super Bitmap, y> paramm, CMTime paramCMTime)
  {
    AppMethodBeat.i(207605);
    this.Aoq = paramLong;
    this.fPF = paramm;
    this.cmTime = paramCMTime;
    AppMethodBeat.o(207605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t.b
 * JD-Core Version:    0.7.0.1
 */