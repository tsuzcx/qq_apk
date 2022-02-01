package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class yv
  extends com.tencent.mm.bw.a
{
  public int GqC;
  public int GqD;
  public int GqE;
  public LinkedList<yu> GqF;
  public b GqG;
  public bop GqH;
  
  public yv()
  {
    AppMethodBeat.i(143967);
    this.GqF = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GqC);
      paramVarArgs.aS(2, this.GqD);
      paramVarArgs.aS(3, this.GqE);
      paramVarArgs.e(4, 8, this.GqF);
      if (this.GqG != null) {
        paramVarArgs.c(5, this.GqG);
      }
      if (this.GqH != null)
      {
        paramVarArgs.lJ(6, this.GqH.computeSize());
        this.GqH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GqC) + 0 + f.a.a.b.b.a.bz(2, this.GqD) + f.a.a.b.b.a.bz(3, this.GqE) + f.a.a.a.c(4, 8, this.GqF);
      paramInt = i;
      if (this.GqG != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.GqG);
      }
      i = paramInt;
      if (this.GqH != null) {
        i = paramInt + f.a.a.a.lI(6, this.GqH.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GqF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yv localyv = (yv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localyv.GqC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localyv.GqD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localyv.GqE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyv.GqF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localyv.GqG = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bop();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyv.GqH = ((bop)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yv
 * JD-Core Version:    0.7.0.1
 */