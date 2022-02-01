package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public int YyR;
  public LinkedList<a> YyS;
  public int nettype;
  public int uin;
  
  public b()
  {
    AppMethodBeat.i(143940);
    this.YyS = new LinkedList();
    AppMethodBeat.o(143940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.uin);
      paramVarArgs.bS(2, this.YyR);
      paramVarArgs.e(3, 8, this.YyS);
      paramVarArgs.bS(4, this.nettype);
      AppMethodBeat.o(143941);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.uin);
      i = i.a.a.b.b.a.cJ(2, this.YyR);
      int j = i.a.a.a.c(3, 8, this.YyS);
      int k = i.a.a.b.b.a.cJ(4, this.nettype);
      AppMethodBeat.o(143941);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YyS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143941);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143941);
        return -1;
      case 1: 
        localb.uin = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143941);
        return 0;
      case 2: 
        localb.YyR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143941);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          a locala = new a();
          if ((localObject != null) && (localObject.length > 0)) {
            locala.parseFrom((byte[])localObject);
          }
          localb.YyS.add(locala);
          paramInt += 1;
        }
        AppMethodBeat.o(143941);
        return 0;
      }
      localb.nettype = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143941);
      return 0;
    }
    AppMethodBeat.o(143941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.b
 * JD-Core Version:    0.7.0.1
 */