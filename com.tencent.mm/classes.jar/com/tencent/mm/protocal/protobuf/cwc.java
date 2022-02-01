package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwc
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public cwq FsR;
  public dmo Gav;
  public int Hoe;
  public int Hof;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hoe);
      paramVarArgs.aS(2, this.Hof);
      if (this.FsR != null)
      {
        paramVarArgs.lC(3, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      if (this.Gav != null)
      {
        paramVarArgs.lC(4, this.Gav.computeSize());
        this.Gav.writeFields(paramVarArgs);
      }
      if (this.FBS != null) {
        paramVarArgs.d(5, this.FBS);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hoe) + 0 + f.a.a.b.b.a.bz(2, this.Hof);
      paramInt = i;
      if (this.FsR != null) {
        paramInt = i + f.a.a.a.lB(3, this.FsR.computeSize());
      }
      i = paramInt;
      if (this.Gav != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gav.computeSize());
      }
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FBS);
      }
      AppMethodBeat.o(91674);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwc localcwc = (cwc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localcwc.Hoe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localcwc.Hof = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwc.FsR = ((cwq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwc.Gav = ((dmo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localcwc.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwc
 * JD-Core Version:    0.7.0.1
 */