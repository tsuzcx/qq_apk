package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egh
  extends com.tencent.mm.bw.a
{
  public String Ngm;
  public String Ngn;
  public int Ngo;
  public String Ngp;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187887);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ngm != null) {
        paramVarArgs.e(1, this.Ngm);
      }
      if (this.Ngn != null) {
        paramVarArgs.e(2, this.Ngn);
      }
      paramVarArgs.aM(3, this.xub);
      paramVarArgs.aM(4, this.Ngo);
      if (this.Ngp != null) {
        paramVarArgs.e(5, this.Ngp);
      }
      AppMethodBeat.o(187887);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ngm == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.Ngm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ngn != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Ngn);
      }
      i = i + g.a.a.b.b.a.bu(3, this.xub) + g.a.a.b.b.a.bu(4, this.Ngo);
      paramInt = i;
      if (this.Ngp != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Ngp);
      }
      AppMethodBeat.o(187887);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187887);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        egh localegh = (egh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187887);
          return -1;
        case 1: 
          localegh.Ngm = locala.UbS.readString();
          AppMethodBeat.o(187887);
          return 0;
        case 2: 
          localegh.Ngn = locala.UbS.readString();
          AppMethodBeat.o(187887);
          return 0;
        case 3: 
          localegh.xub = locala.UbS.zi();
          AppMethodBeat.o(187887);
          return 0;
        case 4: 
          localegh.Ngo = locala.UbS.zi();
          AppMethodBeat.o(187887);
          return 0;
        }
        localegh.Ngp = locala.UbS.readString();
        AppMethodBeat.o(187887);
        return 0;
      }
      AppMethodBeat.o(187887);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egh
 * JD-Core Version:    0.7.0.1
 */