package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ix
  extends com.tencent.mm.bw.a
{
  public String ANo;
  public String HQc;
  public String KNr;
  public String KNs;
  public String KNt;
  public String KNu;
  public String dDj;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNr != null) {
        paramVarArgs.e(1, this.KNr);
      }
      if (this.HQc != null) {
        paramVarArgs.e(2, this.HQc);
      }
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      if (this.ANo != null) {
        paramVarArgs.e(4, this.ANo);
      }
      if (this.ynT != null) {
        paramVarArgs.e(5, this.ynT);
      }
      if (this.KNs != null) {
        paramVarArgs.e(6, this.KNs);
      }
      if (this.KNt != null) {
        paramVarArgs.e(7, this.KNt);
      }
      if (this.KNu != null) {
        paramVarArgs.e(8, this.KNu);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNr == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.f(1, this.KNr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HQc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.HQc);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dDj);
      }
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ANo);
      }
      i = paramInt;
      if (this.ynT != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ynT);
      }
      paramInt = i;
      if (this.KNs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNs);
      }
      i = paramInt;
      if (this.KNt != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KNt);
      }
      paramInt = i;
      if (this.KNu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KNu);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ix localix = (ix)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localix.KNr = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localix.HQc = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localix.dDj = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localix.ANo = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localix.ynT = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localix.KNs = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localix.KNt = locala.UbS.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localix.KNu = locala.UbS.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ix
 * JD-Core Version:    0.7.0.1
 */