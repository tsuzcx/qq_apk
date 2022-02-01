package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzs
  extends com.tencent.mm.bx.a
{
  public LinkedList<dro> abeR;
  public int type;
  
  public dzs()
  {
    AppMethodBeat.i(117542);
    this.abeR = new LinkedList();
    AppMethodBeat.o(117542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117543);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.e(2, 8, this.abeR);
      AppMethodBeat.o(117543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      i = i.a.a.a.c(2, 8, this.abeR);
      AppMethodBeat.o(117543);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abeR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dzs localdzs = (dzs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117543);
        return -1;
      case 1: 
        localdzs.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117543);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dro localdro = new dro();
        if ((localObject != null) && (localObject.length > 0)) {
          localdro.parseFrom((byte[])localObject);
        }
        localdzs.abeR.add(localdro);
        paramInt += 1;
      }
      AppMethodBeat.o(117543);
      return 0;
    }
    AppMethodBeat.o(117543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzs
 * JD-Core Version:    0.7.0.1
 */