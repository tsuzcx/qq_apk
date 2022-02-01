package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avp
  extends com.tencent.mm.bx.a
{
  public int ZFN;
  public LinkedList<avq> nUC;
  
  public avp()
  {
    AppMethodBeat.i(257547);
    this.nUC = new LinkedList();
    AppMethodBeat.o(257547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257552);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.nUC);
      paramVarArgs.bS(2, this.ZFN);
      AppMethodBeat.o(257552);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.nUC);
      i = i.a.a.b.b.a.cJ(2, this.ZFN);
      AppMethodBeat.o(257552);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257552);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      avp localavp = (avp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257552);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          avq localavq = new avq();
          if ((localObject != null) && (localObject.length > 0)) {
            localavq.parseFrom((byte[])localObject);
          }
          localavp.nUC.add(localavq);
          paramInt += 1;
        }
        AppMethodBeat.o(257552);
        return 0;
      }
      localavp.ZFN = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257552);
      return 0;
    }
    AppMethodBeat.o(257552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avp
 * JD-Core Version:    0.7.0.1
 */