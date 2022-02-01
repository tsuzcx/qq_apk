package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efk
  extends com.tencent.mm.bx.a
{
  public int abkN;
  public LinkedList<fkg> abkO;
  public int muC;
  
  public efk()
  {
    AppMethodBeat.i(152661);
    this.abkO = new LinkedList();
    AppMethodBeat.o(152661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152662);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.muC);
      paramVarArgs.bS(2, this.abkN);
      paramVarArgs.e(3, 8, this.abkO);
      AppMethodBeat.o(152662);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.muC);
      i = i.a.a.b.b.a.cJ(2, this.abkN);
      int j = i.a.a.a.c(3, 8, this.abkO);
      AppMethodBeat.o(152662);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abkO.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      efk localefk = (efk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152662);
        return -1;
      case 1: 
        localefk.muC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152662);
        return 0;
      case 2: 
        localefk.abkN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152662);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fkg localfkg = new fkg();
        if ((localObject != null) && (localObject.length > 0)) {
          localfkg.parseFrom((byte[])localObject);
        }
        localefk.abkO.add(localfkg);
        paramInt += 1;
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    AppMethodBeat.o(152662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efk
 * JD-Core Version:    0.7.0.1
 */