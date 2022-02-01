package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byn
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t DVn;
  public int DVo;
  public SKBuiltinBuffer_t DVp;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.version);
      if (this.DVn != null)
      {
        paramVarArgs.kX(3, this.DVn.computeSize());
        this.DVn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DVo);
      if (this.DVp != null)
      {
        paramVarArgs.kX(5, this.DVp.computeSize());
        this.DVp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uin) + 0 + f.a.a.b.b.a.bA(2, this.version);
      paramInt = i;
      if (this.DVn != null) {
        paramInt = i + f.a.a.a.kW(3, this.DVn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DVo);
      paramInt = i;
      if (this.DVp != null) {
        paramInt = i + f.a.a.a.kW(5, this.DVp.computeSize());
      }
      AppMethodBeat.o(129972);
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
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byn localbyn = (byn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localbyn.uin = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localbyn.version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(129972);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyn.DVn = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localbyn.DVo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(129972);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbyn.DVp = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byn
 * JD-Core Version:    0.7.0.1
 */