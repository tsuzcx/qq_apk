package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chz
  extends com.tencent.mm.bw.a
{
  public int Exf;
  public long Exg;
  public LinkedList<cii> Fwi;
  public int tJa;
  
  public chz()
  {
    AppMethodBeat.i(32381);
    this.Fwi = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Exf);
      paramVarArgs.aO(2, this.Exg);
      paramVarArgs.e(3, 8, this.Fwi);
      paramVarArgs.aR(4, this.tJa);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Exf);
      i = f.a.a.b.b.a.p(2, this.Exg);
      int j = f.a.a.a.c(3, 8, this.Fwi);
      int k = f.a.a.b.b.a.bx(4, this.tJa);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fwi.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chz localchz = (chz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localchz.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localchz.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cii();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchz.Fwi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localchz.tJa = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */