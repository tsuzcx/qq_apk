package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sd;
import com.tencent.mm.sdk.event.IListener;

public class PostSnsTagMemberOptionListener
  extends IListener<sd>
{
  public PostSnsTagMemberOptionListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160636);
    this.__eventId = sd.class.getName().hashCode();
    AppMethodBeat.o(160636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PostSnsTagMemberOptionListener
 * JD-Core Version:    0.7.0.1
 */