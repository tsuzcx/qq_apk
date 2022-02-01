package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.pb.talkroom.sdk.d;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", "method", "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"})
public final class a
{
  public static final a wxc;
  
  static
  {
    AppMethodBeat.i(191034);
    wxc = new a();
    AppMethodBeat.o(191034);
  }
  
  public static int O(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(191032);
    if (paramBoolean) {}
    for (;;)
    {
      paramInt = gH(22, paramInt);
      if (paramInt >= 0) {
        break;
      }
      AppMethodBeat.o(191032);
      return -1;
      paramInt = -1;
    }
    AppMethodBeat.o(191032);
    return paramInt;
  }
  
  public static void dul()
  {
    AppMethodBeat.i(191031);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)0);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    m localm = z.dtJ();
    p.g(localm, "SubCoreMultiTalk.getMultiEngine()");
    localm.dst().setAppCmd(39, localByteBuffer.array(), 6);
    AppMethodBeat.o(191031);
  }
  
  public static int gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191033);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt2);
    m localm = z.dtJ();
    p.g(localm, "SubCoreMultiTalk.getMultiEngine()");
    paramInt1 = localm.dst().setAppCmd(paramInt1, localByteBuffer.array(), 4);
    AppMethodBeat.o(191033);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.a
 * JD-Core Version:    0.7.0.1
 */