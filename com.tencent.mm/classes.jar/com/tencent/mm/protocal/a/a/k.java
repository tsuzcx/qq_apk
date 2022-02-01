package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class k
  extends com.tencent.mm.bx.a
{
  public int Yzn;
  public LinkedList<l> Yzo;
  
  public k()
  {
    AppMethodBeat.i(143953);
    this.Yzo = new LinkedList();
    AppMethodBeat.o(143953);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143954);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Yzn);
      paramVarArgs.e(2, 8, this.Yzo);
      AppMethodBeat.o(143954);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Yzn);
      i = i.a.a.a.c(2, 8, this.Yzo);
      AppMethodBeat.o(143954);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Yzo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143954);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143954);
        return -1;
      case 1: 
        localk.Yzn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143954);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        l locall = new l();
        if ((localObject != null) && (localObject.length > 0)) {
          locall.parseFrom((byte[])localObject);
        }
        localk.Yzo.add(locall);
        paramInt += 1;
      }
      AppMethodBeat.o(143954);
      return 0;
    }
    AppMethodBeat.o(143954);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.k
 * JD-Core Version:    0.7.0.1
 */