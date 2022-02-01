package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecw
  extends com.tencent.mm.bw.a
{
  public int Ndh;
  public int Ndi;
  public int Ndj;
  public int Ndk;
  public int Ndl;
  public int Ndm;
  public int Timestamp;
  public int oUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUu);
      paramVarArgs.aM(2, this.Timestamp);
      paramVarArgs.aM(3, this.Ndh);
      paramVarArgs.aM(4, this.Ndi);
      paramVarArgs.aM(5, this.Ndj);
      paramVarArgs.aM(6, this.Ndk);
      paramVarArgs.aM(7, this.Ndl);
      paramVarArgs.aM(8, this.Ndm);
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.oUu);
      int i = g.a.a.b.b.a.bu(2, this.Timestamp);
      int j = g.a.a.b.b.a.bu(3, this.Ndh);
      int k = g.a.a.b.b.a.bu(4, this.Ndi);
      int m = g.a.a.b.b.a.bu(5, this.Ndj);
      int n = g.a.a.b.b.a.bu(6, this.Ndk);
      int i1 = g.a.a.b.b.a.bu(7, this.Ndl);
      int i2 = g.a.a.b.b.a.bu(8, this.Ndm);
      AppMethodBeat.o(32457);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ecw localecw = (ecw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localecw.oUu = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localecw.Timestamp = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localecw.Ndh = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localecw.Ndi = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localecw.Ndj = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localecw.Ndk = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localecw.Ndl = locala.UbS.zi();
        AppMethodBeat.o(32457);
        return 0;
      }
      localecw.Ndm = locala.UbS.zi();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecw
 * JD-Core Version:    0.7.0.1
 */