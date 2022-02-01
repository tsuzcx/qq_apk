package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cbv
  extends com.tencent.mm.bw.a
{
  public cbw FpR;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FpR == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(43119);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.FpR != null)
      {
        paramVarArgs.ln(2, this.FpR.computeSize());
        this.FpR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.FpR != null) {
        paramInt = i + f.a.a.a.lm(2, this.FpR.computeSize());
      }
      AppMethodBeat.o(43119);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FpR == null)
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
      cbv localcbv = (cbv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43119);
        return -1;
      case 1: 
        localcbv.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43119);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbw();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cbw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcbv.FpR = ((cbw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    AppMethodBeat.o(43119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */