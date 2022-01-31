package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

final class f$13
  implements Runnable
{
  f$13(f paramf, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(53951);
    String str2 = this.oTQ.Bhl;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = this.oTQ.Bhm;
    }
    p.bTE().oTa.Un(str1);
    AppMethodBeat.o(53951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.13
 * JD-Core Version:    0.7.0.1
 */