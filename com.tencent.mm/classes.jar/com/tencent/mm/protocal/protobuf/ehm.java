package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehm
  extends com.tencent.mm.cd.a
{
  public String CQT;
  public String MD5;
  public String RIC;
  public String URL;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.f(1, this.URL);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.RIC != null) {
        paramVarArgs.f(3, this.RIC);
      }
      if (this.CQT != null) {
        paramVarArgs.f(4, this.CQT);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label465;
      }
    }
    label465:
    for (int i = g.a.a.b.b.a.g(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.RIC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RIC);
      }
      paramInt = i;
      if (this.CQT != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQT);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.MD5);
      }
      AppMethodBeat.o(32451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32451);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehm localehm = (ehm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32451);
          return -1;
        case 1: 
          localehm.URL = locala.abFh.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 2: 
          localehm.fwr = locala.abFh.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 3: 
          localehm.RIC = locala.abFh.readString();
          AppMethodBeat.o(32451);
          return 0;
        case 4: 
          localehm.CQT = locala.abFh.readString();
          AppMethodBeat.o(32451);
          return 0;
        }
        localehm.MD5 = locala.abFh.readString();
        AppMethodBeat.o(32451);
        return 0;
      }
      AppMethodBeat.o(32451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehm
 * JD-Core Version:    0.7.0.1
 */