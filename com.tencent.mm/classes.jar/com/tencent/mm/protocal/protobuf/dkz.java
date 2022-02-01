package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkz
  extends com.tencent.mm.bx.a
{
  public int EAI;
  public int EAJ;
  public SKBuiltinBuffer_t EAK;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EAK == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.uKR);
      paramVarArgs.aR(2, this.EAI);
      paramVarArgs.aR(3, this.EAJ);
      if (this.EAK != null)
      {
        paramVarArgs.kX(4, this.EAK.computeSize());
        this.EAK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uKR) + 0 + f.a.a.b.b.a.bA(2, this.EAI) + f.a.a.b.b.a.bA(3, this.EAJ);
      paramInt = i;
      if (this.EAK != null) {
        paramInt = i + f.a.a.a.kW(4, this.EAK.computeSize());
      }
      AppMethodBeat.o(32499);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.EAK == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkz localdkz = (dkz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localdkz.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localdkz.EAI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localdkz.EAJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32499);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkz.EAK = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    AppMethodBeat.o(32499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */