package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

final class p$a
  implements Comparable
{
  MultiTalkGroupMember FAz;
  int tQm;
  
  p$a(p paramp, MultiTalkGroupMember paramMultiTalkGroupMember, int paramInt)
  {
    this.FAz = paramMultiTalkGroupMember;
    this.tQm = paramInt;
  }
  
  public final int compareTo(Object paramObject)
  {
    AppMethodBeat.i(205394);
    paramObject = (a)paramObject;
    int i = Integer.compare(this.tQm, paramObject.tQm);
    AppMethodBeat.o(205394);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205393);
    String str = this.FAz + ":" + this.tQm;
    AppMethodBeat.o(205393);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.p.a
 * JD-Core Version:    0.7.0.1
 */