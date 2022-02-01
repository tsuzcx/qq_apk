package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eso
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int Cqs;
  public int RKI;
  public String TPZ;
  public String Tkx;
  public String Tky;
  public String Udz;
  public String Uun;
  public int jUk;
  public String lpy;
  public String sSY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TPZ != null) {
        paramVarArgs.f(1, this.TPZ);
      }
      if (this.Uun != null) {
        paramVarArgs.f(2, this.Uun);
      }
      paramVarArgs.aY(3, this.jUk);
      if (this.Tkx != null) {
        paramVarArgs.f(4, this.Tkx);
      }
      if (this.lpy != null) {
        paramVarArgs.f(5, this.lpy);
      }
      paramVarArgs.aY(6, this.CPw);
      if (this.Tky != null) {
        paramVarArgs.f(7, this.Tky);
      }
      paramVarArgs.aY(8, this.RKI);
      if (this.sSY != null) {
        paramVarArgs.f(9, this.sSY);
      }
      if (this.Udz != null) {
        paramVarArgs.f(10, this.Udz);
      }
      paramVarArgs.aY(11, this.Cqs);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TPZ == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = g.a.a.b.b.a.g(1, this.TPZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uun != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Uun);
      }
      i += g.a.a.b.b.a.bM(3, this.jUk);
      paramInt = i;
      if (this.Tkx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tkx);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lpy);
      }
      i += g.a.a.b.b.a.bM(6, this.CPw);
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Tky);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.RKI);
      paramInt = i;
      if (this.sSY != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.sSY);
      }
      i = paramInt;
      if (this.Udz != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Udz);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.Cqs);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eso localeso = (eso)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localeso.TPZ = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localeso.Uun = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localeso.jUk = locala.abFh.AK();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localeso.Tkx = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localeso.lpy = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localeso.CPw = locala.abFh.AK();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localeso.Tky = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localeso.RKI = locala.abFh.AK();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localeso.sSY = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localeso.Udz = locala.abFh.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localeso.Cqs = locala.abFh.AK();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eso
 * JD-Core Version:    0.7.0.1
 */