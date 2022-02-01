package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", "method", "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"})
public final class a
{
  public static final a FEC;
  
  static
  {
    AppMethodBeat.i(203506);
    FEC = new a();
    AppMethodBeat.o(203506);
  }
  
  public static int ab(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(203501);
    if (paramBoolean) {}
    for (;;)
    {
      paramInt = io(22, paramInt);
      if (paramInt >= 0) {
        break;
      }
      AppMethodBeat.o(203501);
      return -1;
      paramInt = -1;
    }
    AppMethodBeat.o(203501);
    return paramInt;
  }
  
  public static void eZz()
  {
    boolean bool = false;
    AppMethodBeat.i(203499);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)0);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    Object localObject = ad.eYc();
    p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject).eXb() != null)
    {
      localObject = ad.eYc();
      p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      localObject = ((q)localObject).eXb().ilf();
      bool = ad.eYc().aQj((String)localObject);
    }
    if (bool)
    {
      localObject = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(39, localByteBuffer.array(), 6);
      AppMethodBeat.o(203499);
      return;
    }
    localObject = ad.eYb();
    p.j(localObject, "SubCoreMultiTalk.getMultiEngine()");
    ((com.tencent.mm.plugin.multitalk.model.o)localObject).eWv().setAppCmd(39, localByteBuffer.array(), 6);
    AppMethodBeat.o(203499);
  }
  
  public static int io(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203503);
    boolean bool = false;
    Object localObject1 = ad.eYc();
    p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).eXb() != null)
    {
      localObject1 = ad.eYc();
      p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      localObject1 = ((q)localObject1).eXb().ilf();
      bool = ad.eYc().aQj((String)localObject1);
    }
    localObject1 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt2);
    if (bool)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.b.o.Fne;
      paramInt1 = com.tencent.mm.plugin.multitalk.b.o.f(paramInt1, ((ByteBuffer)localObject1).array(), 4);
      AppMethodBeat.o(203503);
      return paramInt1;
    }
    Object localObject2 = ad.eYb();
    p.j(localObject2, "SubCoreMultiTalk.getMultiEngine()");
    paramInt1 = ((com.tencent.mm.plugin.multitalk.model.o)localObject2).eWv().setAppCmd(paramInt1, ((ByteBuffer)localObject1).array(), 4);
    AppMethodBeat.o(203503);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.a
 * JD-Core Version:    0.7.0.1
 */