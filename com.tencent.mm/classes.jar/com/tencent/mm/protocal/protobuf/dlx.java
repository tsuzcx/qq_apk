package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlx
  extends com.tencent.mm.cd.a
{
  public String Sqe;
  public String TSQ;
  public String TSR;
  public String TSS;
  public String TST;
  public String URL;
  public String fwr;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.lpy != null) {
        paramVarArgs.f(2, this.lpy);
      }
      if (this.TSQ != null) {
        paramVarArgs.f(3, this.TSQ);
      }
      if (this.TSR != null) {
        paramVarArgs.f(4, this.TSR);
      }
      if (this.TSS != null) {
        paramVarArgs.f(6, this.TSS);
      }
      if (this.Sqe != null) {
        paramVarArgs.f(7, this.Sqe);
      }
      if (this.URL != null) {
        paramVarArgs.f(8, this.URL);
      }
      if (this.TST != null) {
        paramVarArgs.f(9, this.TST);
      }
      AppMethodBeat.o(207868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lpy);
      }
      i = paramInt;
      if (this.TSQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TSQ);
      }
      paramInt = i;
      if (this.TSR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TSR);
      }
      i = paramInt;
      if (this.TSS != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TSS);
      }
      paramInt = i;
      if (this.Sqe != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sqe);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.URL);
      }
      paramInt = i;
      if (this.TST != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TST);
      }
      AppMethodBeat.o(207868);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207868);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlx localdlx = (dlx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 5: 
        default: 
          AppMethodBeat.o(207868);
          return -1;
        case 1: 
          localdlx.fwr = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 2: 
          localdlx.lpy = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 3: 
          localdlx.TSQ = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 4: 
          localdlx.TSR = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 6: 
          localdlx.TSS = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 7: 
          localdlx.Sqe = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        case 8: 
          localdlx.URL = locala.abFh.readString();
          AppMethodBeat.o(207868);
          return 0;
        }
        localdlx.TST = locala.abFh.readString();
        AppMethodBeat.o(207868);
        return 0;
      }
      AppMethodBeat.o(207868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlx
 * JD-Core Version:    0.7.0.1
 */