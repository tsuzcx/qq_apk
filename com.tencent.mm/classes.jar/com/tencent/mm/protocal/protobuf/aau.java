package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aau
  extends com.tencent.mm.bx.a
{
  public long FZD;
  public long FZE;
  public LinkedList<aat> Fvu;
  public int Gao;
  public int Gap;
  
  public aau()
  {
    AppMethodBeat.i(90962);
    this.Fvu = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FZD);
      paramVarArgs.aY(2, this.FZE);
      paramVarArgs.e(3, 8, this.Fvu);
      paramVarArgs.aS(4, this.Gao);
      paramVarArgs.aS(5, this.Gap);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FZD);
      i = f.a.a.b.b.a.p(2, this.FZE);
      int j = f.a.a.a.c(3, 8, this.Fvu);
      int k = f.a.a.b.b.a.bz(4, this.Gao);
      int m = f.a.a.b.b.a.bz(5, this.Gap);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fvu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aau localaau = (aau)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localaau.FZD = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localaau.FZE = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(90963);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aat();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaau.Fvu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90963);
        return 0;
      case 4: 
        localaau.Gao = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(90963);
        return 0;
      }
      localaau.Gap = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */