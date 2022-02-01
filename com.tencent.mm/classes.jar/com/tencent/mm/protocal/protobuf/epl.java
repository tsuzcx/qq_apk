package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class epl
  extends com.tencent.mm.cd.a
{
  public int CNg;
  public b SaN;
  public String TPZ;
  public String TSb;
  public String Usj;
  public b Usk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117930);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSb != null) {
        paramVarArgs.f(1, this.TSb);
      }
      if (this.TPZ != null) {
        paramVarArgs.f(2, this.TPZ);
      }
      if (this.SaN != null) {
        paramVarArgs.c(3, this.SaN);
      }
      if (this.Usj != null) {
        paramVarArgs.f(4, this.Usj);
      }
      paramVarArgs.aY(5, this.CNg);
      if (this.Usk != null) {
        paramVarArgs.c(6, this.Usk);
      }
      AppMethodBeat.o(117930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSb == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.TSb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPZ);
      }
      i = paramInt;
      if (this.SaN != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SaN);
      }
      paramInt = i;
      if (this.Usj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Usj);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.CNg);
      paramInt = i;
      if (this.Usk != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.Usk);
      }
      AppMethodBeat.o(117930);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117930);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        epl localepl = (epl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117930);
          return -1;
        case 1: 
          localepl.TSb = locala.abFh.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 2: 
          localepl.TPZ = locala.abFh.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 3: 
          localepl.SaN = locala.abFh.iUw();
          AppMethodBeat.o(117930);
          return 0;
        case 4: 
          localepl.Usj = locala.abFh.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 5: 
          localepl.CNg = locala.abFh.AK();
          AppMethodBeat.o(117930);
          return 0;
        }
        localepl.Usk = locala.abFh.iUw();
        AppMethodBeat.o(117930);
        return 0;
      }
      AppMethodBeat.o(117930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epl
 * JD-Core Version:    0.7.0.1
 */