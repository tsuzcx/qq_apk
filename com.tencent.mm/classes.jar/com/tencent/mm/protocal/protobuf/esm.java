package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esm
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int Cqs;
  public int RKI;
  public String SWP;
  public String TPZ;
  public String Tkx;
  public String Tky;
  public String Udz;
  public String Uul;
  public String Uum;
  public String fwr;
  public String lpy;
  public String sSY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tkx != null) {
        paramVarArgs.f(1, this.Tkx);
      }
      if (this.TPZ != null) {
        paramVarArgs.f(2, this.TPZ);
      }
      if (this.lpy != null) {
        paramVarArgs.f(3, this.lpy);
      }
      if (this.Uul != null) {
        paramVarArgs.f(4, this.Uul);
      }
      if (this.Uum != null) {
        paramVarArgs.f(5, this.Uum);
      }
      if (this.SWP != null) {
        paramVarArgs.f(6, this.SWP);
      }
      if (this.fwr != null) {
        paramVarArgs.f(7, this.fwr);
      }
      if (this.Tky != null) {
        paramVarArgs.f(8, this.Tky);
      }
      paramVarArgs.aY(9, this.CPw);
      paramVarArgs.aY(10, this.RKI);
      if (this.Udz != null) {
        paramVarArgs.f(11, this.Udz);
      }
      if (this.sSY != null) {
        paramVarArgs.f(12, this.sSY);
      }
      paramVarArgs.aY(13, this.Cqs);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tkx == null) {
        break label902;
      }
    }
    label902:
    for (int i = g.a.a.b.b.a.g(1, this.Tkx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPZ);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpy);
      }
      paramInt = i;
      if (this.Uul != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uul);
      }
      i = paramInt;
      if (this.Uum != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Uum);
      }
      paramInt = i;
      if (this.SWP != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SWP);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fwr);
      }
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tky);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.CPw) + g.a.a.b.b.a.bM(10, this.RKI);
      paramInt = i;
      if (this.Udz != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Udz);
      }
      i = paramInt;
      if (this.sSY != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.sSY);
      }
      paramInt = g.a.a.b.b.a.bM(13, this.Cqs);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esm localesm = (esm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localesm.Tkx = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localesm.TPZ = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localesm.lpy = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localesm.Uul = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localesm.Uum = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localesm.SWP = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localesm.fwr = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localesm.Tky = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localesm.CPw = locala.abFh.AK();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localesm.RKI = locala.abFh.AK();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localesm.Udz = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localesm.sSY = locala.abFh.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localesm.Cqs = locala.abFh.AK();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esm
 * JD-Core Version:    0.7.0.1
 */