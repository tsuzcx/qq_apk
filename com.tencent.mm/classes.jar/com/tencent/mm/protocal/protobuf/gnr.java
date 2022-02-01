package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gnr
  extends com.tencent.mm.bx.a
{
  public LinkedList<gnq> aciG;
  public int vgN;
  
  public gnr()
  {
    AppMethodBeat.i(259627);
    this.aciG = new LinkedList();
    AppMethodBeat.o(259627);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259632);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgN);
      paramVarArgs.e(2, 8, this.aciG);
      AppMethodBeat.o(259632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vgN);
      i = i.a.a.a.c(2, 8, this.aciG);
      AppMethodBeat.o(259632);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aciG.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gnr localgnr = (gnr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259632);
        return -1;
      case 1: 
        localgnr.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259632);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gnq localgnq = new gnq();
        if ((localObject != null) && (localObject.length > 0)) {
          localgnq.parseFrom((byte[])localObject);
        }
        localgnr.aciG.add(localgnq);
        paramInt += 1;
      }
      AppMethodBeat.o(259632);
      return 0;
    }
    AppMethodBeat.o(259632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnr
 * JD-Core Version:    0.7.0.1
 */