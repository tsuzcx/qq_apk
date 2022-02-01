package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dch
  extends com.tencent.mm.bw.a
{
  public String LoI;
  public String MHc;
  public String MHd;
  public String MHe;
  public String MHf;
  public String Title;
  public String URL;
  public String iAc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209783);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(2, this.iAc);
      }
      if (this.MHc != null) {
        paramVarArgs.e(3, this.MHc);
      }
      if (this.MHd != null) {
        paramVarArgs.e(4, this.MHd);
      }
      if (this.MHe != null) {
        paramVarArgs.e(6, this.MHe);
      }
      if (this.LoI != null) {
        paramVarArgs.e(7, this.LoI);
      }
      if (this.URL != null) {
        paramVarArgs.e(8, this.URL);
      }
      if (this.MHf != null) {
        paramVarArgs.e(9, this.MHf);
      }
      AppMethodBeat.o(209783);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iAc);
      }
      i = paramInt;
      if (this.MHc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MHc);
      }
      paramInt = i;
      if (this.MHd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MHd);
      }
      i = paramInt;
      if (this.MHe != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MHe);
      }
      paramInt = i;
      if (this.LoI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LoI);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.URL);
      }
      paramInt = i;
      if (this.MHf != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MHf);
      }
      AppMethodBeat.o(209783);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209783);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dch localdch = (dch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 5: 
        default: 
          AppMethodBeat.o(209783);
          return -1;
        case 1: 
          localdch.Title = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 2: 
          localdch.iAc = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 3: 
          localdch.MHc = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 4: 
          localdch.MHd = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 6: 
          localdch.MHe = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 7: 
          localdch.LoI = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        case 8: 
          localdch.URL = locala.UbS.readString();
          AppMethodBeat.o(209783);
          return 0;
        }
        localdch.MHf = locala.UbS.readString();
        AppMethodBeat.o(209783);
        return 0;
      }
      AppMethodBeat.o(209783);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dch
 * JD-Core Version:    0.7.0.1
 */