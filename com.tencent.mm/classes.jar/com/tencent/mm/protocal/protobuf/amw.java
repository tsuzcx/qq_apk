package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amw
  extends com.tencent.mm.bw.a
{
  public int KGZ;
  public int KHa;
  public int KHb;
  public int KHc;
  public String KHf;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KGZ);
      paramVarArgs.aM(2, this.oTW);
      if (this.KHf != null) {
        paramVarArgs.e(3, this.KHf);
      }
      paramVarArgs.aM(4, this.KHa);
      paramVarArgs.aM(5, this.KHb);
      paramVarArgs.aM(6, this.KHc);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KGZ) + 0 + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.KHf != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KHf);
      }
      i = g.a.a.b.b.a.bu(4, this.KHa);
      int j = g.a.a.b.b.a.bu(5, this.KHb);
      int k = g.a.a.b.b.a.bu(6, this.KHc);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      amw localamw = (amw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localamw.KGZ = locala.UbS.zi();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localamw.oTW = locala.UbS.zi();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localamw.KHf = locala.UbS.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localamw.KHa = locala.UbS.zi();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localamw.KHb = locala.UbS.zi();
        AppMethodBeat.o(127470);
        return 0;
      }
      localamw.KHc = locala.UbS.zi();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amw
 * JD-Core Version:    0.7.0.1
 */