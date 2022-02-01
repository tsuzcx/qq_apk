package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfp
  extends com.tencent.mm.bw.a
{
  public long feedId;
  public String objectNonceId;
  public int scene;
  public String sessionBuffer;
  public bbn ttO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.feedId);
      if (this.objectNonceId != null) {
        paramVarArgs.e(2, this.objectNonceId);
      }
      paramVarArgs.aM(3, this.scene);
      if (this.ttO != null)
      {
        paramVarArgs.ni(4, this.ttO.computeSize());
        this.ttO.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(209719);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.feedId) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.ttO != null) {
        paramInt = i + g.a.a.a.nh(4, this.ttO.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.sessionBuffer);
      }
      AppMethodBeat.o(209719);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209719);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bfp localbfp = (bfp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209719);
        return -1;
      case 1: 
        localbfp.feedId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209719);
        return 0;
      case 2: 
        localbfp.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209719);
        return 0;
      case 3: 
        localbfp.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209719);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbfp.ttO = ((bbn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209719);
        return 0;
      }
      localbfp.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209719);
      return 0;
    }
    AppMethodBeat.o(209719);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfp
 * JD-Core Version:    0.7.0.1
 */