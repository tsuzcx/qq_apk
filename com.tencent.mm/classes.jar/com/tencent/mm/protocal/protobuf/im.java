package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class im
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String GGC;
  public String OIl;
  public String ROl;
  public String ROm;
  public String ROn;
  public String ROo;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROl != null) {
        paramVarArgs.f(1, this.ROl);
      }
      if (this.OIl != null) {
        paramVarArgs.f(2, this.OIl);
      }
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      if (this.GGC != null) {
        paramVarArgs.f(4, this.GGC);
      }
      if (this.DNV != null) {
        paramVarArgs.f(5, this.DNV);
      }
      if (this.ROm != null) {
        paramVarArgs.f(6, this.ROm);
      }
      if (this.ROn != null) {
        paramVarArgs.f(7, this.ROn);
      }
      if (this.ROo != null) {
        paramVarArgs.f(8, this.ROo);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROl == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.g(1, this.ROl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OIl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.OIl);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fvP);
      }
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GGC);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.DNV);
      }
      paramInt = i;
      if (this.ROm != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROm);
      }
      i = paramInt;
      if (this.ROn != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.ROn);
      }
      paramInt = i;
      if (this.ROo != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ROo);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        im localim = (im)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localim.ROl = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localim.OIl = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localim.fvP = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localim.GGC = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localim.DNV = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localim.ROm = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localim.ROn = locala.abFh.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localim.ROo = locala.abFh.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.im
 * JD-Core Version:    0.7.0.1
 */