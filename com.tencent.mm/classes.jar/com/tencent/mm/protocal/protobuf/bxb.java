package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bxb
  extends com.tencent.mm.bx.a
{
  public bxc DTv;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(43119);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.DTv != null)
      {
        paramVarArgs.kX(2, this.DTv.computeSize());
        this.DTv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.DTv != null) {
        paramInt = i + f.a.a.a.kW(2, this.DTv.computeSize());
      }
      AppMethodBeat.o(43119);
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
      if (this.DTv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(43119);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxb localbxb = (bxb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43119);
        return -1;
      case 1: 
        localbxb.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43119);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bxc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bxc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbxb.DTv = ((bxc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    AppMethodBeat.o(43119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxb
 * JD-Core Version:    0.7.0.1
 */