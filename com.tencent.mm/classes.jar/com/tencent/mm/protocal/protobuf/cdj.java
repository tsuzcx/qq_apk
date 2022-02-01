package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdj
  extends com.tencent.mm.bx.a
{
  public int aanJ;
  public LinkedList<aoq> aanK;
  public int aanL;
  public int eQp;
  
  public cdj()
  {
    AppMethodBeat.i(153145);
    this.aanK = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aanJ);
      paramVarArgs.e(2, 8, this.aanK);
      paramVarArgs.bS(3, this.aanL);
      paramVarArgs.bS(4, this.eQp);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aanJ);
      i = i.a.a.a.c(2, 8, this.aanK);
      int j = i.a.a.b.b.a.cJ(3, this.aanL);
      int k = i.a.a.b.b.a.cJ(4, this.eQp);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aanK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cdj localcdj = (cdj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localcdj.aanJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aoq localaoq = new aoq();
          if ((localObject != null) && (localObject.length > 0)) {
            localaoq.parseFrom((byte[])localObject);
          }
          localcdj.aanK.add(localaoq);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localcdj.aanL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153146);
        return 0;
      }
      localcdj.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdj
 * JD-Core Version:    0.7.0.1
 */