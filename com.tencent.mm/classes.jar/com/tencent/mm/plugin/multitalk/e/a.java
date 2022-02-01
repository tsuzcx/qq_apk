package com.tencent.mm.plugin.multitalk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", "method", "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LAn;
  
  static
  {
    AppMethodBeat.i(284615);
    LAn = new a();
    AppMethodBeat.o(284615);
  }
  
  public static int ad(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(284609);
    if (paramBoolean) {}
    for (;;)
    {
      paramInt = jS(22, paramInt);
      if (paramInt >= 0) {
        break;
      }
      AppMethodBeat.o(284609);
      return -1;
      paramInt = -1;
    }
    AppMethodBeat.o(284609);
    return paramInt;
  }
  
  public static void giA()
  {
    boolean bool = false;
    AppMethodBeat.i(284605);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)0);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    Object localObject;
    if (ac.ggS().Lol != null)
    {
      localObject = ac.ggS().Lol.LiU;
      bool = ac.ggS().aNe((String)localObject);
    }
    if (bool)
    {
      localObject = o.Ljn;
      o.e(39, localByteBuffer.array(), 6);
      AppMethodBeat.o(284605);
      return;
    }
    ac.ggR().LnJ.setAppCmd(39, localByteBuffer.array(), 6);
    AppMethodBeat.o(284605);
  }
  
  public static int jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284613);
    boolean bool = false;
    if (ac.ggS().Lol != null)
    {
      localObject = ac.ggS().Lol.LiU;
      bool = ac.ggS().aNe((String)localObject);
    }
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt2);
    if (bool)
    {
      o localo = o.Ljn;
      paramInt1 = o.e(paramInt1, ((ByteBuffer)localObject).array(), 4);
      AppMethodBeat.o(284613);
      return paramInt1;
    }
    paramInt1 = ac.ggR().LnJ.setAppCmd(paramInt1, ((ByteBuffer)localObject).array(), 4);
    AppMethodBeat.o(284613);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.a
 * JD-Core Version:    0.7.0.1
 */