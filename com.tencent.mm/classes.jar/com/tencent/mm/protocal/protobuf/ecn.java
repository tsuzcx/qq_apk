package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ecn
  extends com.tencent.mm.cd.a
{
  public int CQK;
  public String SessionId;
  public int TVM;
  public String Tkx;
  public String Tky;
  public String Uhd;
  public b Uhe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211953);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SessionId != null) {
        paramVarArgs.f(1, this.SessionId);
      }
      if (this.Tky != null) {
        paramVarArgs.f(2, this.Tky);
      }
      if (this.Tkx != null) {
        paramVarArgs.f(3, this.Tkx);
      }
      paramVarArgs.aY(4, this.CQK);
      paramVarArgs.aY(5, this.TVM);
      if (this.Uhd != null) {
        paramVarArgs.f(6, this.Uhd);
      }
      if (this.Uhe != null) {
        paramVarArgs.c(7, this.Uhe);
      }
      AppMethodBeat.o(211953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SessionId == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.g(1, this.SessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tky);
      }
      i = paramInt;
      if (this.Tkx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tkx);
      }
      i = i + g.a.a.b.b.a.bM(4, this.CQK) + g.a.a.b.b.a.bM(5, this.TVM);
      paramInt = i;
      if (this.Uhd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uhd);
      }
      i = paramInt;
      if (this.Uhe != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.Uhe);
      }
      AppMethodBeat.o(211953);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211953);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecn localecn = (ecn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211953);
          return -1;
        case 1: 
          localecn.SessionId = locala.abFh.readString();
          AppMethodBeat.o(211953);
          return 0;
        case 2: 
          localecn.Tky = locala.abFh.readString();
          AppMethodBeat.o(211953);
          return 0;
        case 3: 
          localecn.Tkx = locala.abFh.readString();
          AppMethodBeat.o(211953);
          return 0;
        case 4: 
          localecn.CQK = locala.abFh.AK();
          AppMethodBeat.o(211953);
          return 0;
        case 5: 
          localecn.TVM = locala.abFh.AK();
          AppMethodBeat.o(211953);
          return 0;
        case 6: 
          localecn.Uhd = locala.abFh.readString();
          AppMethodBeat.o(211953);
          return 0;
        }
        localecn.Uhe = locala.abFh.iUw();
        AppMethodBeat.o(211953);
        return 0;
      }
      AppMethodBeat.o(211953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecn
 * JD-Core Version:    0.7.0.1
 */