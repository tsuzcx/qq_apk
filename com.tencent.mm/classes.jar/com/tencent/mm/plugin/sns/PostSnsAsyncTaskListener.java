package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.sdk.event.IListener;

public class PostSnsAsyncTaskListener
  extends IListener<se>
{
  public PostSnsAsyncTaskListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160635);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(160635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.PostSnsAsyncTaskListener
 * JD-Core Version:    0.7.0.1
 */