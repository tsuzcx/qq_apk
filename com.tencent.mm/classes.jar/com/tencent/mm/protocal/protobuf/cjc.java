package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjc
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t HvH;
  public int HvI;
  public SKBuiltinBuffer_t HvJ;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.version);
      if (this.HvH != null)
      {
        paramVarArgs.lJ(3, this.HvH.computeSize());
        this.HvH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HvI);
      if (this.HvJ != null)
      {
        paramVarArgs.lJ(5, this.HvJ.computeSize());
        this.HvJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.HvH != null) {
        paramInt = i + f.a.a.a.lI(3, this.HvH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HvI);
      paramInt = i;
      if (this.HvJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.HvJ.computeSize());
      }
      AppMethodBeat.o(129972);
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
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cjc localcjc = (cjc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localcjc.uin = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localcjc.version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(129972);
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
          localcjc.HvH = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localcjc.HvI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(129972);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcjc.HvJ = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    AppMethodBeat.o(129972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjc
 * JD-Core Version:    0.7.0.1
 */