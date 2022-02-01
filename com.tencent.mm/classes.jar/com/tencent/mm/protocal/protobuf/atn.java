package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atn
  extends com.tencent.mm.bw.a
{
  public bou GKr;
  public int GKs = -1;
  public int GKt = -1;
  public boolean GKu = false;
  public int GKv = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.GKr != null)
      {
        paramVarArgs.lJ(2, this.GKr.computeSize());
        this.GKr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GKs);
      paramVarArgs.aS(4, this.GKt);
      paramVarArgs.bC(5, this.GKu);
      paramVarArgs.aS(6, this.GKv);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GKr != null) {
        paramInt = i + f.a.a.a.lI(2, this.GKr.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.GKs);
      int j = f.a.a.b.b.a.bz(4, this.GKt);
      int k = f.a.a.b.b.a.amF(5);
      int m = f.a.a.b.b.a.bz(6, this.GKv);
      AppMethodBeat.o(122490);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      atn localatn = (atn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localatn.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bou();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bou)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localatn.GKr = ((bou)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localatn.GKs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localatn.GKt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localatn.GKu = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122490);
        return 0;
      }
      localatn.GKv = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atn
 * JD-Core Version:    0.7.0.1
 */