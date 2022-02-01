package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fme
  extends com.tencent.mm.bx.a
{
  public LinkedList<bt> abMA;
  public boolean abMz;
  
  public fme()
  {
    AppMethodBeat.i(122551);
    this.abMz = false;
    this.abMA = new LinkedList();
    AppMethodBeat.o(122551);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122552);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.abMz);
      paramVarArgs.e(2, 8, this.abMA);
      AppMethodBeat.o(122552);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      i = i.a.a.a.c(2, 8, this.abMA);
      AppMethodBeat.o(122552);
      return paramInt + 1 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abMA.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122552);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fme localfme = (fme)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122552);
        return -1;
      case 1: 
        localfme.abMz = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(122552);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bt localbt = new bt();
        if ((localObject != null) && (localObject.length > 0)) {
          localbt.parseFrom((byte[])localObject);
        }
        localfme.abMA.add(localbt);
        paramInt += 1;
      }
      AppMethodBeat.o(122552);
      return 0;
    }
    AppMethodBeat.o(122552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fme
 * JD-Core Version:    0.7.0.1
 */