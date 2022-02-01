package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lz;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;

public class GetSnsTimeLineObjectListener
  extends IListener<lz>
{
  private SnsInfo PJQ;
  private String PJT;
  private TimeLineObject PJU;
  
  public GetSnsTimeLineObjectListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160634);
    this.__eventId = lz.class.getName().hashCode();
    AppMethodBeat.o(160634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.GetSnsTimeLineObjectListener
 * JD-Core Version:    0.7.0.1
 */