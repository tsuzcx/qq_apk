package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmr
  extends com.tencent.mm.cd.a
{
  public String Eyy;
  public String Oxw;
  public String TTV;
  public String TiP;
  public int Tow;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TiP != null) {
        paramVarArgs.f(1, this.TiP);
      }
      if (this.TTV != null) {
        paramVarArgs.f(2, this.TTV);
      }
      if (this.Oxw != null) {
        paramVarArgs.f(3, this.Oxw);
      }
      if (this.Eyy != null) {
        paramVarArgs.f(4, this.Eyy);
      }
      paramVarArgs.aY(5, this.Tow);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TiP == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.g(1, this.TiP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TTV != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TTV);
      }
      i = paramInt;
      if (this.Oxw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Oxw);
      }
      paramInt = i;
      if (this.Eyy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Eyy);
      }
      i = g.a.a.b.b.a.bM(5, this.Tow);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmr localdmr = (dmr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localdmr.TiP = locala.abFh.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localdmr.TTV = locala.abFh.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localdmr.Oxw = locala.abFh.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localdmr.Eyy = locala.abFh.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localdmr.Tow = locala.abFh.AK();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmr
 * JD-Core Version:    0.7.0.1
 */