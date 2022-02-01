package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bmv
  extends com.tencent.mm.cd.a
{
  public long HlH;
  public b SJd;
  public String SQm;
  public String report_ext_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SQm != null) {
        paramVarArgs.f(1, this.SQm);
      }
      paramVarArgs.bm(2, this.HlH);
      if (this.SJd != null) {
        paramVarArgs.c(3, this.SJd);
      }
      if (this.report_ext_info != null) {
        paramVarArgs.f(4, this.report_ext_info);
      }
      AppMethodBeat.o(206292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SQm == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.SQm) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.HlH);
      paramInt = i;
      if (this.SJd != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SJd);
      }
      i = paramInt;
      if (this.report_ext_info != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.report_ext_info);
      }
      AppMethodBeat.o(206292);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206292);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bmv localbmv = (bmv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206292);
          return -1;
        case 1: 
          localbmv.SQm = locala.abFh.readString();
          AppMethodBeat.o(206292);
          return 0;
        case 2: 
          localbmv.HlH = locala.abFh.AN();
          AppMethodBeat.o(206292);
          return 0;
        case 3: 
          localbmv.SJd = locala.abFh.iUw();
          AppMethodBeat.o(206292);
          return 0;
        }
        localbmv.report_ext_info = locala.abFh.readString();
        AppMethodBeat.o(206292);
        return 0;
      }
      AppMethodBeat.o(206292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmv
 * JD-Core Version:    0.7.0.1
 */