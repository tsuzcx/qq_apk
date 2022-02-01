package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afa
  extends com.tencent.mm.bw.a
{
  public int Gvk;
  public aex Gvl;
  public aex Gvm;
  public int Gvn;
  public int Gvo;
  public int Gvp;
  public int Gvq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gvk);
      if (this.Gvl != null)
      {
        paramVarArgs.lJ(2, this.Gvl.computeSize());
        this.Gvl.writeFields(paramVarArgs);
      }
      if (this.Gvm != null)
      {
        paramVarArgs.lJ(3, this.Gvm.computeSize());
        this.Gvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Gvn);
      paramVarArgs.aS(5, this.Gvo);
      paramVarArgs.aS(6, this.Gvp);
      paramVarArgs.aS(7, this.Gvq);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gvk) + 0;
      paramInt = i;
      if (this.Gvl != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gvl.computeSize());
      }
      i = paramInt;
      if (this.Gvm != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gvm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Gvn);
      int j = f.a.a.b.b.a.bz(5, this.Gvo);
      int k = f.a.a.b.b.a.bz(6, this.Gvp);
      int m = f.a.a.b.b.a.bz(7, this.Gvq);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afa localafa = (afa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localafa.Gvk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aex();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aex)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafa.Gvl = ((aex)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aex();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aex)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafa.Gvm = ((aex)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localafa.Gvn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localafa.Gvo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localafa.Gvp = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(90966);
        return 0;
      }
      localafa.Gvq = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afa
 * JD-Core Version:    0.7.0.1
 */