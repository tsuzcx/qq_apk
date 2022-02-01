package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class g
  extends com.tencent.mm.bx.a
{
  public int YyT;
  public int Yzj;
  public LinkedList<b> Yzk;
  public com.tencent.mm.bx.b Yzl;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.Yzk = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YyT);
      paramVarArgs.bS(2, this.Yzj);
      paramVarArgs.e(3, 8, this.Yzk);
      if (this.Yzl != null) {
        paramVarArgs.d(4, this.Yzl);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YyT) + 0 + i.a.a.b.b.a.cJ(2, this.Yzj) + i.a.a.a.c(3, 8, this.Yzk);
      paramInt = i;
      if (this.Yzl != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.Yzl);
      }
      AppMethodBeat.o(143948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Yzk.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143948);
        return -1;
      case 1: 
        localg.YyT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.Yzj = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          b localb = new b();
          if ((localObject != null) && (localObject.length > 0)) {
            localb.parseFrom((byte[])localObject);
          }
          localg.Yzk.add(localb);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.Yzl = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */