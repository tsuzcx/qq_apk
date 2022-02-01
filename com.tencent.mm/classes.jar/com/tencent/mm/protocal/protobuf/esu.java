package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esu
  extends com.tencent.mm.bx.a
{
  public int abwm;
  public LinkedList<est> abwn;
  
  public esu()
  {
    AppMethodBeat.i(258165);
    this.abwn = new LinkedList();
    AppMethodBeat.o(258165);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258176);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abwm);
      paramVarArgs.e(2, 8, this.abwn);
      AppMethodBeat.o(258176);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abwm);
      i = i.a.a.a.c(2, 8, this.abwn);
      AppMethodBeat.o(258176);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abwn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258176);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      esu localesu = (esu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258176);
        return -1;
      case 1: 
        localesu.abwm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258176);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        est localest = new est();
        if ((localObject != null) && (localObject.length > 0)) {
          localest.parseFrom((byte[])localObject);
        }
        localesu.abwn.add(localest);
        paramInt += 1;
      }
      AppMethodBeat.o(258176);
      return 0;
    }
    AppMethodBeat.o(258176);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esu
 * JD-Core Version:    0.7.0.1
 */