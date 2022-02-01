package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agw
  extends com.tencent.mm.bx.a
  implements ctq
{
  public int CNq;
  public xe CRA;
  public SKBuiltinBuffer_t CRx;
  public int Ret;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CRA == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.CRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.CRA != null)
      {
        paramVarArgs.kX(2, this.CRA.computeSize());
        this.CRA.writeFields(paramVarArgs);
      }
      if (this.CRx != null)
      {
        paramVarArgs.kX(3, this.CRx.computeSize());
        this.CRx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CNq);
      AppMethodBeat.o(127483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.CRA != null) {
        paramInt = i + f.a.a.a.kW(2, this.CRA.computeSize());
      }
      i = paramInt;
      if (this.CRx != null) {
        i = paramInt + f.a.a.a.kW(3, this.CRx.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(4, this.CNq);
      AppMethodBeat.o(127483);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CRA == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.CRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      agw localagw = (agw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127483);
        return -1;
      case 1: 
        localagw.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127483);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagw.CRA = ((xe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
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
          localagw.CRx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      }
      localagw.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(127483);
      return 0;
    }
    AppMethodBeat.o(127483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agw
 * JD-Core Version:    0.7.0.1
 */