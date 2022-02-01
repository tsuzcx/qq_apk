package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class i
  extends com.tencent.mm.bx.a
{
  public int YyT;
  public int Yzh;
  public int Yzj;
  public LinkedList<e> Yzk;
  public b Yzl;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.Yzk = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YyT);
      paramVarArgs.bS(2, this.Yzj);
      paramVarArgs.bS(3, this.Yzh);
      paramVarArgs.e(4, 8, this.Yzk);
      if (this.Yzl != null) {
        paramVarArgs.d(5, this.Yzl);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YyT) + 0 + i.a.a.b.b.a.cJ(2, this.Yzj) + i.a.a.b.b.a.cJ(3, this.Yzh) + i.a.a.a.c(4, 8, this.Yzk);
      paramInt = i;
      if (this.Yzl != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.Yzl);
      }
      AppMethodBeat.o(143951);
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
      AppMethodBeat.o(143951);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143951);
        return -1;
      case 1: 
        locali.YyT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.Yzj = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.Yzh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          e locale = new e();
          if ((localObject != null) && (localObject.length > 0)) {
            locale.parseFrom((byte[])localObject);
          }
          locali.Yzk.add(locale);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.Yzl = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */