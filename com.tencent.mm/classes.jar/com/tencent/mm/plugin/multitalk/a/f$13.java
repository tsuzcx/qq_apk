package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

final class f$13
  implements Runnable
{
  f$13(f paramf, MultiTalkGroup paramMultiTalkGroup) {}
  
  public final void run()
  {
    String str2 = this.muc.wJL;
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = this.muc.wJM;
    }
    p.blE().mtp.Iy(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.13
 * JD-Core Version:    0.7.0.1
 */