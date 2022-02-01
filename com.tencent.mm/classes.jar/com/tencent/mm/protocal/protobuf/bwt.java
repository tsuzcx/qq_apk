package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bwt
  extends com.tencent.mm.bw.a
{
  public dww GhB;
  public LinkedList<bwu> HjJ;
  
  public bwt()
  {
    AppMethodBeat.i(140928);
    this.HjJ = new LinkedList();
    AppMethodBeat.o(140928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140929);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.HjJ);
      if (this.GhB != null)
      {
        paramVarArgs.lJ(2, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140929);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.HjJ) + 0;
      paramInt = i;
      if (this.GhB != null) {
        paramInt = i + f.a.a.a.lI(2, this.GhB.computeSize());
      }
      AppMethodBeat.o(140929);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HjJ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      AppMethodBeat.o(140929);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bwt localbwt = (bwt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(140929);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwt.HjJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(140929);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dww();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbwt.GhB = ((dww)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(140929);
      return 0;
    }
    AppMethodBeat.o(140929);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwt
 * JD-Core Version:    0.7.0.1
 */