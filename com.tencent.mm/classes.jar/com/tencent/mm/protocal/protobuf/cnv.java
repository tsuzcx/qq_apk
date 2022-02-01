package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnv
  extends com.tencent.mm.bx.a
{
  public int aavd;
  public LinkedList<cnu> aave;
  
  public cnv()
  {
    AppMethodBeat.i(115840);
    this.aave = new LinkedList();
    AppMethodBeat.o(115840);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aavd);
      paramVarArgs.e(2, 8, this.aave);
      AppMethodBeat.o(115841);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aavd);
      i = i.a.a.a.c(2, 8, this.aave);
      AppMethodBeat.o(115841);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aave.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115841);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cnv localcnv = (cnv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115841);
        return -1;
      case 1: 
        localcnv.aavd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115841);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cnu localcnu = new cnu();
        if ((localObject != null) && (localObject.length > 0)) {
          localcnu.parseFrom((byte[])localObject);
        }
        localcnv.aave.add(localcnu);
        paramInt += 1;
      }
      AppMethodBeat.o(115841);
      return 0;
    }
    AppMethodBeat.o(115841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnv
 * JD-Core Version:    0.7.0.1
 */