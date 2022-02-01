package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esb
  extends com.tencent.mm.bx.a
{
  public LinkedList<erz> abvU;
  public int vhJ;
  
  public esb()
  {
    AppMethodBeat.i(152675);
    this.abvU = new LinkedList();
    AppMethodBeat.o(152675);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152676);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.e(2, 8, this.abvU);
      AppMethodBeat.o(152676);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vhJ);
      i = i.a.a.a.c(2, 8, this.abvU);
      AppMethodBeat.o(152676);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abvU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152676);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      esb localesb = (esb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152676);
        return -1;
      case 1: 
        localesb.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152676);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        erz localerz = new erz();
        if ((localObject != null) && (localObject.length > 0)) {
          localerz.parseFrom((byte[])localObject);
        }
        localesb.abvU.add(localerz);
        paramInt += 1;
      }
      AppMethodBeat.o(152676);
      return 0;
    }
    AppMethodBeat.o(152676);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esb
 * JD-Core Version:    0.7.0.1
 */