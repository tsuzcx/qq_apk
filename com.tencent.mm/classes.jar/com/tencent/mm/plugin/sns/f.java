package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kv;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;

public final class f
  extends IListener<kv>
{
  private SnsInfo Jws;
  private String Jwv;
  private TimeLineObject Jww;
  
  public f()
  {
    AppMethodBeat.i(160634);
    this.__eventId = kv.class.getName().hashCode();
    AppMethodBeat.o(160634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f
 * JD-Core Version:    0.7.0.1
 */