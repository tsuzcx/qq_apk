package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", "method", "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"})
public final class a
{
  public static final a zYP;
  
  static
  {
    AppMethodBeat.i(240091);
    zYP = new a();
    AppMethodBeat.o(240091);
  }
  
  public static int R(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(240089);
    if (paramBoolean) {}
    for (;;)
    {
      paramInt = hj(22, paramInt);
      if (paramInt >= 0) {
        break;
      }
      AppMethodBeat.o(240089);
      return -1;
      paramInt = -1;
    }
    AppMethodBeat.o(240089);
    return paramInt;
  }
  
  public static void epL()
  {
    boolean bool = false;
    AppMethodBeat.i(240088);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)0);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    Object localObject = ac.eom();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject).enn() != null)
    {
      localObject = ac.eom();
      kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      localObject = ((q)localObject).enn().hjv();
      bool = ac.eom().aFW((String)localObject);
    }
    if (bool)
    {
      localObject = com.tencent.mm.plugin.multitalk.b.p.zHS;
      com.tencent.mm.plugin.multitalk.b.p.f(39, localByteBuffer.array(), 6);
      AppMethodBeat.o(240088);
      return;
    }
    localObject = ac.eol();
    kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiEngine()");
    ((o)localObject).emG().setAppCmd(39, localByteBuffer.array(), 6);
    AppMethodBeat.o(240088);
  }
  
  public static int hj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240090);
    boolean bool = false;
    Object localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((q)localObject1).enn() != null)
    {
      localObject1 = ac.eom();
      kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      localObject1 = ((q)localObject1).enn().hjv();
      bool = ac.eom().aFW((String)localObject1);
    }
    localObject1 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt2);
    if (bool)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.b.p.zHS;
      paramInt1 = com.tencent.mm.plugin.multitalk.b.p.f(paramInt1, ((ByteBuffer)localObject1).array(), 4);
      AppMethodBeat.o(240090);
      return paramInt1;
    }
    Object localObject2 = ac.eol();
    kotlin.g.b.p.g(localObject2, "SubCoreMultiTalk.getMultiEngine()");
    paramInt1 = ((o)localObject2).emG().setAppCmd(paramInt1, ((ByteBuffer)localObject1).array(), 4);
    AppMethodBeat.o(240090);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.a
 * JD-Core Version:    0.7.0.1
 */