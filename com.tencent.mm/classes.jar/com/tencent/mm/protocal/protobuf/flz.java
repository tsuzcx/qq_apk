package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class flz
  extends com.tencent.mm.bx.a
{
  public int aaLf;
  public etl abMp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32467);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aaLf);
      if (this.abMp != null)
      {
        paramVarArgs.qD(2, this.abMp.computeSize());
        this.abMp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaLf) + 0;
      paramInt = i;
      if (this.abMp != null) {
        paramInt = i + i.a.a.a.qC(2, this.abMp.computeSize());
      }
      AppMethodBeat.o(32467);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      flz localflz = (flz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32467);
        return -1;
      case 1: 
        localflz.aaLf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32467);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etl localetl = new etl();
        if ((localObject != null) && (localObject.length > 0)) {
          localetl.dh((byte[])localObject);
        }
        localflz.abMp = localetl;
        paramInt += 1;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    AppMethodBeat.o(32467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flz
 * JD-Core Version:    0.7.0.1
 */