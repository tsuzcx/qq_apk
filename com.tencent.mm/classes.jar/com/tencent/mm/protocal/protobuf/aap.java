package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aap
  extends com.tencent.mm.bw.a
{
  public int LlU;
  public int LlV;
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
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nHd != null) {
        paramVarArgs.e(2, this.nHd);
      }
      paramVarArgs.aM(3, this.LlU);
      paramVarArgs.aM(4, this.LlV);
      if (this.nHe != null) {
        paramVarArgs.e(5, this.nHe);
      }
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
      AppMethodBeat.o(50083);
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
      int i = paramInt;
      if (this.nHd != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.nHd);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LlU) + g.a.a.b.b.a.bu(4, this.LlV);
      paramInt = i;
      if (this.nHe != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.nHe);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.dNI);
      }
      paramInt = i;
      if (this.nHf != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.nHf);
      }
      i = paramInt;
      if (this.nHg != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.nHg);
      }
      i += g.a.a.b.b.a.bu(9, this.nHh);
      paramInt = i;
      if (this.nHi != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.nHi);
      }
      i = g.a.a.b.b.a.bu(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aap localaap = (aap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localaap.username = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localaap.nHd = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localaap.LlU = locala.UbS.zi();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localaap.LlV = locala.UbS.zi();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localaap.nHe = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localaap.dNI = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localaap.nHf = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localaap.nHg = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localaap.nHh = locala.UbS.zi();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localaap.nHi = locala.UbS.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localaap.position = locala.UbS.zi();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aap
 * JD-Core Version:    0.7.0.1
 */