package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwj
  extends com.tencent.mm.bw.a
{
  public int IbE;
  public dwn IbF;
  public dwl IbG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176153);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IbE);
      if (this.IbF != null)
      {
        paramVarArgs.lJ(2, this.IbF.computeSize());
        this.IbF.writeFields(paramVarArgs);
      }
      if (this.IbG != null)
      {
        paramVarArgs.lJ(3, this.IbG.computeSize());
        this.IbG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.IbE) + 0;
      paramInt = i;
      if (this.IbF != null) {
        paramInt = i + f.a.a.a.lI(2, this.IbF.computeSize());
      }
      i = paramInt;
      if (this.IbG != null) {
        i = paramInt + f.a.a.a.lI(3, this.IbG.computeSize());
      }
      AppMethodBeat.o(176153);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwj localdwj = (dwj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176153);
        return -1;
      case 1: 
        localdwj.IbE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(176153);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwj.IbF = ((dwn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176153);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dwl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdwj.IbG = ((dwl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    AppMethodBeat.o(176153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwj
 * JD-Core Version:    0.7.0.1
 */