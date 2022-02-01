package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jc
  extends com.tencent.mm.bw.a
{
  public String CiX;
  public boolean KNE;
  public String KNF;
  public String KNs;
  public String KNu;
  public String dDj;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ynT != null) {
        paramVarArgs.e(1, this.ynT);
      }
      if (this.CiX != null) {
        paramVarArgs.e(2, this.CiX);
      }
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      paramVarArgs.cc(4, this.KNE);
      if (this.KNu != null) {
        paramVarArgs.e(5, this.KNu);
      }
      if (this.KNs != null) {
        paramVarArgs.e(6, this.KNs);
      }
      if (this.KNF != null) {
        paramVarArgs.e(7, this.KNF);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ynT == null) {
        break label575;
      }
    }
    label575:
    for (int i = g.a.a.b.b.a.f(1, this.ynT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CiX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.CiX);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dDj);
      }
      i += g.a.a.b.b.a.fS(4) + 1;
      paramInt = i;
      if (this.KNu != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KNu);
      }
      i = paramInt;
      if (this.KNs != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KNs);
      }
      paramInt = i;
      if (this.KNF != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KNF);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jc localjc = (jc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localjc.ynT = locala.UbS.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localjc.CiX = locala.UbS.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localjc.dDj = locala.UbS.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localjc.KNE = locala.UbS.yZ();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localjc.KNu = locala.UbS.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localjc.KNs = locala.UbS.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localjc.KNF = locala.UbS.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */