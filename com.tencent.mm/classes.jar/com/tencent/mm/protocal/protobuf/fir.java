package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fir
  extends com.tencent.mm.cd.a
{
  public String RMK;
  public String UIs;
  public String UIt;
  public String UIu;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String rVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RMK != null) {
        paramVarArgs.f(1, this.RMK);
      }
      if (this.jUc != null) {
        paramVarArgs.f(2, this.jUc);
      }
      if (this.jUb != null) {
        paramVarArgs.f(3, this.jUb);
      }
      if (this.rVG != null) {
        paramVarArgs.f(4, this.rVG);
      }
      if (this.UIs != null) {
        paramVarArgs.f(5, this.UIs);
      }
      if (this.jUd != null) {
        paramVarArgs.f(6, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(7, this.jUe);
      }
      if (this.UIt != null) {
        paramVarArgs.f(8, this.UIt);
      }
      if (this.UIu != null) {
        paramVarArgs.f(9, this.UIu);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RMK == null) {
        break label702;
      }
    }
    label702:
    for (int i = g.a.a.b.b.a.g(1, this.RMK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jUc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUc);
      }
      i = paramInt;
      if (this.jUb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUb);
      }
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rVG);
      }
      i = paramInt;
      if (this.UIs != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UIs);
      }
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jUd);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.jUe);
      }
      paramInt = i;
      if (this.UIt != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UIt);
      }
      i = paramInt;
      if (this.UIu != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UIu);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fir localfir = (fir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localfir.RMK = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localfir.jUc = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localfir.jUb = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localfir.rVG = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localfir.UIs = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localfir.jUd = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localfir.jUe = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localfir.UIt = locala.abFh.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localfir.UIu = locala.abFh.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fir
 * JD-Core Version:    0.7.0.1
 */