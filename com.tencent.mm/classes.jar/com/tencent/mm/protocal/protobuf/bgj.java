package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgj
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public int jJS;
  public int wBX;
  public SKBuiltinBuffer_t wFR;
  public ue wFU;
  public int xvH;
  public int xvI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58923);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(58923);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(58923);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.wFU != null)
      {
        paramVarArgs.iQ(2, this.wFU.computeSize());
        this.wFU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wBX);
      if (this.wFR != null)
      {
        paramVarArgs.iQ(4, this.wFR.computeSize());
        this.wFR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.jJS);
      paramVarArgs.aO(6, this.xvH);
      paramVarArgs.aO(7, this.xvI);
      AppMethodBeat.o(58923);
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
      i = paramInt + e.a.a.b.b.a.bl(3, this.wBX);
      paramInt = i;
      if (this.wFR != null) {
        paramInt = i + e.a.a.a.iP(4, this.wFR.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.jJS);
      int j = e.a.a.b.b.a.bl(6, this.xvH);
      int k = e.a.a.b.b.a.bl(7, this.xvI);
      AppMethodBeat.o(58923);
      return paramInt + i + j + k;
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
        AppMethodBeat.o(58923);
        throw paramVarArgs;
      }
      if (this.wFR == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(58923);
        throw paramVarArgs;
      }
      AppMethodBeat.o(58923);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bgj localbgj = (bgj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(58923);
        return -1;
      case 1: 
        localbgj.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58923);
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
          localbgj.wFU = ((ue)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58923);
        return 0;
      case 3: 
        localbgj.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58923);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbgj.wFR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58923);
        return 0;
      case 5: 
        localbgj.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58923);
        return 0;
      case 6: 
        localbgj.xvH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58923);
        return 0;
      }
      localbgj.xvI = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(58923);
      return 0;
    }
    AppMethodBeat.o(58923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgj
 * JD-Core Version:    0.7.0.1
 */