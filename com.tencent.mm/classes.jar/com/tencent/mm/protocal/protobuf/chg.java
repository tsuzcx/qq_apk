package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chg
  extends com.tencent.mm.bw.a
{
  public chh Htc;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Htc == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(43119);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.Htc != null)
      {
        paramVarArgs.lJ(2, this.Htc.computeSize());
        this.Htc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.Htc != null) {
        paramInt = i + f.a.a.a.lI(2, this.Htc.computeSize());
      }
      AppMethodBeat.o(43119);
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
      if (this.Htc == null)
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
      chg localchg = (chg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43119);
        return -1;
      case 1: 
        localchg.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43119);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new chh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((chh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localchg.Htc = ((chh)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chg
 * JD-Core Version:    0.7.0.1
 */