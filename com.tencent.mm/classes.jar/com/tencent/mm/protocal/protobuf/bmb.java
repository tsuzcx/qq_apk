package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmb
  extends com.tencent.mm.cd.a
{
  public String CSe;
  public int CreateTime;
  public String RIA;
  public String RIC;
  public int SXb;
  public String SXc;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIA != null) {
        paramVarArgs.f(1, this.RIA);
      }
      paramVarArgs.aY(2, this.CreateTime);
      paramVarArgs.aY(3, this.SXb);
      if (this.RIC != null) {
        paramVarArgs.f(4, this.RIC);
      }
      if (this.SXc != null) {
        paramVarArgs.f(5, this.SXc);
      }
      if (this.UserName != null) {
        paramVarArgs.f(6, this.UserName);
      }
      if (this.CSe != null) {
        paramVarArgs.f(7, this.CSe);
      }
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIA == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.b.b.a.g(1, this.RIA) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CreateTime) + g.a.a.b.b.a.bM(3, this.SXb);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RIC);
      }
      i = paramInt;
      if (this.SXc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SXc);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UserName);
      }
      i = paramInt;
      if (this.CSe != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CSe);
      }
      AppMethodBeat.o(149139);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bmb localbmb = (bmb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localbmb.RIA = locala.abFh.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localbmb.CreateTime = locala.abFh.AK();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localbmb.SXb = locala.abFh.AK();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localbmb.RIC = locala.abFh.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localbmb.SXc = locala.abFh.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localbmb.UserName = locala.abFh.readString();
          AppMethodBeat.o(149139);
          return 0;
        }
        localbmb.CSe = locala.abFh.readString();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmb
 * JD-Core Version:    0.7.0.1
 */