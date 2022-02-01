package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpo
  extends com.tencent.mm.bw.a
{
  public float Hdf;
  public float Hdg;
  public float Hdh;
  public String Hdi;
  public String Label;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.Hdf);
      paramVarArgs.y(2, this.Hdg);
      paramVarArgs.y(3, this.Hdh);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      if (this.Hdi != null) {
        paramVarArgs.d(5, this.Hdi);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amE(1) + 0 + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.amE(3);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt;
      if (this.Hdi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hdi);
      }
      AppMethodBeat.o(32326);
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
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpo localbpo = (bpo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localbpo.Hdf = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localbpo.Hdg = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localbpo.Hdh = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localbpo.Label = locala.OmT.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localbpo.Hdi = locala.OmT.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpo
 * JD-Core Version:    0.7.0.1
 */