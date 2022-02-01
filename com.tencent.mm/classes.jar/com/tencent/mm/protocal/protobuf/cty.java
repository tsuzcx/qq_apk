package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cty
  extends com.tencent.mm.bw.a
{
  public int HEU;
  public SKBuiltinBuffer_t HEV;
  public SKBuiltinBuffer_t HEW;
  public SKBuiltinBuffer_t HEX;
  public SKBuiltinBuffer_t HEY;
  public long HEZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HEU);
      if (this.HEV != null)
      {
        paramVarArgs.lJ(2, this.HEV.computeSize());
        this.HEV.writeFields(paramVarArgs);
      }
      if (this.HEW != null)
      {
        paramVarArgs.lJ(3, this.HEW.computeSize());
        this.HEW.writeFields(paramVarArgs);
      }
      if (this.HEX != null)
      {
        paramVarArgs.lJ(4, this.HEX.computeSize());
        this.HEX.writeFields(paramVarArgs);
      }
      if (this.HEY != null)
      {
        paramVarArgs.lJ(5, this.HEY.computeSize());
        this.HEY.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.HEZ);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HEU) + 0;
      paramInt = i;
      if (this.HEV != null) {
        paramInt = i + f.a.a.a.lI(2, this.HEV.computeSize());
      }
      i = paramInt;
      if (this.HEW != null) {
        i = paramInt + f.a.a.a.lI(3, this.HEW.computeSize());
      }
      paramInt = i;
      if (this.HEX != null) {
        paramInt = i + f.a.a.a.lI(4, this.HEX.computeSize());
      }
      i = paramInt;
      if (this.HEY != null) {
        i = paramInt + f.a.a.a.lI(5, this.HEY.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.HEZ);
      AppMethodBeat.o(125760);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cty localcty = (cty)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localcty.HEU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.HEV = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.HEW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.HEX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcty.HEY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localcty.HEZ = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cty
 * JD-Core Version:    0.7.0.1
 */