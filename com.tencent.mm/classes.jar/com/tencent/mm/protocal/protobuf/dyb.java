package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyb
  extends com.tencent.mm.bw.a
{
  public int IcZ;
  public int Ida;
  public SKBuiltinBuffer_t Idb;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Idb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.xsC);
      paramVarArgs.aS(2, this.IcZ);
      paramVarArgs.aS(3, this.Ida);
      if (this.Idb != null)
      {
        paramVarArgs.lJ(4, this.Idb.computeSize());
        this.Idb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xsC) + 0 + f.a.a.b.b.a.bz(2, this.IcZ) + f.a.a.b.b.a.bz(3, this.Ida);
      paramInt = i;
      if (this.Idb != null) {
        paramInt = i + f.a.a.a.lI(4, this.Idb.computeSize());
      }
      AppMethodBeat.o(32499);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Idb == null)
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
      dyb localdyb = (dyb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localdyb.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localdyb.IcZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localdyb.Ida = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32499);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdyb.Idb = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyb
 * JD-Core Version:    0.7.0.1
 */