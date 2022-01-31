package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csi
  extends com.tencent.mm.bv.a
{
  public String num;
  public int wMC;
  public SKBuiltinBuffer_t wMD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5236);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wMD == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(5236);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wMC);
      if (this.wMD != null)
      {
        paramVarArgs.iQ(2, this.wMD.computeSize());
        this.wMD.writeFields(paramVarArgs);
      }
      if (this.num != null) {
        paramVarArgs.e(3, this.num);
      }
      AppMethodBeat.o(5236);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wMC) + 0;
      paramInt = i;
      if (this.wMD != null) {
        paramInt = i + e.a.a.a.iP(2, this.wMD.computeSize());
      }
      i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.num);
      }
      AppMethodBeat.o(5236);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wMD == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(5236);
        throw paramVarArgs;
      }
      AppMethodBeat.o(5236);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      csi localcsi = (csi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(5236);
        return -1;
      case 1: 
        localcsi.wMC = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5236);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcsi.wMD = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5236);
        return 0;
      }
      localcsi.num = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(5236);
      return 0;
    }
    AppMethodBeat.o(5236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csi
 * JD-Core Version:    0.7.0.1
 */