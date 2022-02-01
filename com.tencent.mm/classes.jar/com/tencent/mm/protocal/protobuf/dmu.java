package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmu
  extends com.tencent.mm.bw.a
{
  public int HUe;
  public String HUf;
  public String HUg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HUe);
      if (this.HUf != null) {
        paramVarArgs.d(2, this.HUf);
      }
      if (this.HUg != null) {
        paramVarArgs.d(3, this.HUg);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HUe) + 0;
      paramInt = i;
      if (this.HUf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HUf);
      }
      i = paramInt;
      if (this.HUg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HUg);
      }
      AppMethodBeat.o(117933);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmu localdmu = (dmu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localdmu.HUe = locala.OmT.zc();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localdmu.HUf = locala.OmT.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localdmu.HUg = locala.OmT.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmu
 * JD-Core Version:    0.7.0.1
 */