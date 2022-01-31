package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class acy
  extends com.tencent.mm.bv.a
  implements ccv
{
  public int Ret;
  public int wBX;
  public SKBuiltinBuffer_t wFR;
  public ue wFU;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51414);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(51414);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(51414);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.wFU != null)
      {
        paramVarArgs.iQ(2, this.wFU.computeSize());
        this.wFU.writeFields(paramVarArgs);
      }
      if (this.wFR != null)
      {
        paramVarArgs.iQ(3, this.wFR.computeSize());
        this.wFR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wBX);
      AppMethodBeat.o(51414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.wFU != null) {
        paramInt = i + e.a.a.a.iP(2, this.wFU.computeSize());
      }
      i = paramInt;
      if (this.wFR != null) {
        i = paramInt + e.a.a.a.iP(3, this.wFR.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wBX);
      AppMethodBeat.o(51414);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(51414);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(51414);
        throw paramVarArgs;
      }
      AppMethodBeat.o(51414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      acy localacy = (acy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(51414);
        return -1;
      case 1: 
        localacy.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51414);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ue();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localacy.wFU = ((ue)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51414);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localacy.wFR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51414);
        return 0;
      }
      localacy.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(51414);
      return 0;
    }
    AppMethodBeat.o(51414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acy
 * JD-Core Version:    0.7.0.1
 */