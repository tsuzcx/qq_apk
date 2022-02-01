package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cww
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public String FUn;
  public dnl Gtc;
  public int HHE;
  public int HHF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HHE);
      paramVarArgs.aS(2, this.HHF);
      if (this.FLp != null)
      {
        paramVarArgs.lJ(3, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      if (this.Gtc != null)
      {
        paramVarArgs.lJ(4, this.Gtc.computeSize());
        this.Gtc.writeFields(paramVarArgs);
      }
      if (this.FUn != null) {
        paramVarArgs.d(5, this.FUn);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HHE) + 0 + f.a.a.b.b.a.bz(2, this.HHF);
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(3, this.FLp.computeSize());
      }
      i = paramInt;
      if (this.Gtc != null) {
        i = paramInt + f.a.a.a.lI(4, this.Gtc.computeSize());
      }
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUn);
      }
      AppMethodBeat.o(91674);
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
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cww localcww = (cww)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localcww.HHE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localcww.HHF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcww.FLp = ((cxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcww.Gtc = ((dnl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localcww.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cww
 * JD-Core Version:    0.7.0.1
 */