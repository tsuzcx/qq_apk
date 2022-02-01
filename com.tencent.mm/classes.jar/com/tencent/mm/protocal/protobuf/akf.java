package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akf
  extends com.tencent.mm.bw.a
{
  public int Ltp;
  public int count;
  public String dNI;
  public String nHd;
  public String nHe;
  public String nHf;
  public String nHg;
  public int nHh;
  public String nHi;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aM(2, this.count);
      if (this.nHd != null) {
        paramVarArgs.e(3, this.nHd);
      }
      if (this.nHe != null) {
        paramVarArgs.e(4, this.nHe);
      }
      paramVarArgs.aM(5, this.Ltp);
      if (this.dNI != null) {
        paramVarArgs.e(6, this.dNI);
      }
      if (this.nHf != null) {
        paramVarArgs.e(7, this.nHf);
      }
      if (this.nHg != null) {
        paramVarArgs.e(8, this.nHg);
      }
      paramVarArgs.aM(9, this.nHh);
      if (this.nHi != null) {
        paramVarArgs.e(10, this.nHi);
      }
      paramVarArgs.aM(11, this.position);
      AppMethodBeat.o(50085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.count);
      paramInt = i;
      if (this.nHd != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nHd);
      }
      i = paramInt;
      if (this.nHe != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.nHe);
      }
      i += g.a.a.b.b.a.bu(5, this.Ltp);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dNI);
      }
      i = paramInt;
      if (this.nHf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.nHf);
      }
      paramInt = i;
      if (this.nHg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.nHg);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.nHh);
      paramInt = i;
      if (this.nHi != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.nHi);
      }
      i = g.a.a.b.b.a.bu(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akf localakf = (akf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localakf.username = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localakf.count = locala.UbS.zi();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localakf.nHd = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localakf.nHe = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localakf.Ltp = locala.UbS.zi();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localakf.dNI = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localakf.nHf = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localakf.nHg = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localakf.nHh = locala.UbS.zi();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localakf.nHi = locala.UbS.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localakf.position = locala.UbS.zi();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */