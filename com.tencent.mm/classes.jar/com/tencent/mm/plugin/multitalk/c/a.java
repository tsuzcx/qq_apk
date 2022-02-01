package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.pb.talkroom.sdk.d;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", "method", "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"})
public final class a
{
  public static final a why;
  
  static
  {
    AppMethodBeat.i(206760);
    why = new a();
    AppMethodBeat.o(206760);
  }
  
  public static int L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(206758);
    if (paramBoolean) {}
    for (;;)
    {
      paramInt = gG(22, paramInt);
      if (paramInt >= 0) {
        break;
      }
      AppMethodBeat.o(206758);
      return -1;
      paramInt = -1;
    }
    AppMethodBeat.o(206758);
    return paramInt;
  }
  
  public static void dqZ()
  {
    AppMethodBeat.i(206757);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)0);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    m localm = z.dqw();
    p.g(localm, "SubCoreMultiTalk.getMultiEngine()");
    localm.dpi().setAppCmd(39, localByteBuffer.array(), 6);
    AppMethodBeat.o(206757);
  }
  
  public static int gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206759);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt2);
    m localm = z.dqw();
    p.g(localm, "SubCoreMultiTalk.getMultiEngine()");
    paramInt1 = localm.dpi().setAppCmd(paramInt1, localByteBuffer.array(), 4);
    AppMethodBeat.o(206759);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.a
 * JD-Core Version:    0.7.0.1
 */