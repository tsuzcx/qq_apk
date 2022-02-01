package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ada
  extends com.tencent.mm.cd.a
{
  public long SoR;
  public ahm SoS;
  public ahp SoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoR);
      if (this.SoS != null)
      {
        paramVarArgs.oE(2, this.SoS.computeSize());
        this.SoS.writeFields(paramVarArgs);
      }
      if (this.SoT != null)
      {
        paramVarArgs.oE(3, this.SoT.computeSize());
        this.SoT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.SoR) + 0;
      paramInt = i;
      if (this.SoS != null) {
        paramInt = i + g.a.a.a.oD(2, this.SoS.computeSize());
      }
      i = paramInt;
      if (this.SoT != null) {
        i = paramInt + g.a.a.a.oD(3, this.SoT.computeSize());
      }
      AppMethodBeat.o(90958);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ada localada = (ada)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localada.SoR = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahm)localObject2).parseFrom((byte[])localObject1);
          }
          localada.SoS = ((ahm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ahp();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ahp)localObject2).parseFrom((byte[])localObject1);
        }
        localada.SoT = ((ahp)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ada
 * JD-Core Version:    0.7.0.1
 */