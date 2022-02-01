package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdz
  extends com.tencent.mm.bw.a
{
  public String KGX;
  public String KHk;
  public int KSa;
  public int Nzs;
  public String Username;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.xut != null) {
        paramVarArgs.e(2, this.xut);
      }
      paramVarArgs.aM(3, this.KSa);
      if (this.KGX != null) {
        paramVarArgs.e(4, this.KGX);
      }
      paramVarArgs.aM(5, this.Nzs);
      if (this.KHk != null) {
        paramVarArgs.e(6, this.KHk);
      }
      AppMethodBeat.o(117959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xut);
      }
      i += g.a.a.b.b.a.bu(3, this.KSa);
      paramInt = i;
      if (this.KGX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KGX);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Nzs);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHk);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fdz localfdz = (fdz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localfdz.Username = locala.UbS.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localfdz.xut = locala.UbS.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localfdz.KSa = locala.UbS.zi();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localfdz.KGX = locala.UbS.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localfdz.Nzs = locala.UbS.zi();
          AppMethodBeat.o(117959);
          return 0;
        }
        localfdz.KHk = locala.UbS.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdz
 * JD-Core Version:    0.7.0.1
 */