package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqk
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public String Tav;
  public String UserName;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.SjI != null) {
        paramVarArgs.f(3, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(4, this.SjJ);
      }
      if (this.Tav != null) {
        paramVarArgs.f(5, this.Tav);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SjJ);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tav);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cqk localcqk = (cqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localcqk.UserName = locala.abFh.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localcqk.rWI = locala.abFh.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localcqk.SjI = locala.abFh.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localcqk.SjJ = locala.abFh.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localcqk.Tav = locala.abFh.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqk
 * JD-Core Version:    0.7.0.1
 */