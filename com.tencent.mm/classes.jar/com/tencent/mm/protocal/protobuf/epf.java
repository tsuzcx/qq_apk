package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epf
  extends com.tencent.mm.bx.a
{
  public int abtq;
  public LinkedList<epe> abtr;
  
  public epf()
  {
    AppMethodBeat.i(115849);
    this.abtr = new LinkedList();
    AppMethodBeat.o(115849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115850);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abtq);
      paramVarArgs.e(2, 8, this.abtr);
      AppMethodBeat.o(115850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abtq);
      i = i.a.a.a.c(2, 8, this.abtr);
      AppMethodBeat.o(115850);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abtr.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      epf localepf = (epf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115850);
        return -1;
      case 1: 
        localepf.abtq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115850);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        epe localepe = new epe();
        if ((localObject != null) && (localObject.length > 0)) {
          localepe.parseFrom((byte[])localObject);
        }
        localepf.abtr.add(localepe);
        paramInt += 1;
      }
      AppMethodBeat.o(115850);
      return 0;
    }
    AppMethodBeat.o(115850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epf
 * JD-Core Version:    0.7.0.1
 */