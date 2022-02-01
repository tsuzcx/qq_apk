package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kn
  extends com.tencent.mm.bw.a
{
  public String FVh;
  public String FVm;
  public caj FVn;
  public bob FVo;
  public int Ret;
  public String nIN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.FVm != null) {
        paramVarArgs.d(2, this.FVm);
      }
      if (this.FVn != null)
      {
        paramVarArgs.lJ(3, this.FVn.computeSize());
        this.FVn.writeFields(paramVarArgs);
      }
      if (this.FVh != null) {
        paramVarArgs.d(4, this.FVh);
      }
      if (this.nIN != null) {
        paramVarArgs.d(5, this.nIN);
      }
      if (this.FVo != null)
      {
        paramVarArgs.lJ(6, this.FVo.computeSize());
        this.FVo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FVm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVm);
      }
      i = paramInt;
      if (this.FVn != null) {
        i = paramInt + f.a.a.a.lI(3, this.FVn.computeSize());
      }
      paramInt = i;
      if (this.FVh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVh);
      }
      i = paramInt;
      if (this.nIN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIN);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.a.lI(6, this.FVo.computeSize());
      }
      AppMethodBeat.o(82393);
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
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      kn localkn = (kn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localkn.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localkn.FVm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new caj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((caj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localkn.FVn = ((caj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localkn.FVh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localkn.nIN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bob();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localkn.FVo = ((bob)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kn
 * JD-Core Version:    0.7.0.1
 */