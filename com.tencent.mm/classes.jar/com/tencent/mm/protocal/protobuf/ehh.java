package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehh
  extends com.tencent.mm.cd.a
{
  public String REw;
  public String REx;
  public int REy;
  public String comment;
  public String fUL;
  public String fUM;
  public String tnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114073);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      if (this.tnX != null) {
        paramVarArgs.f(2, this.tnX);
      }
      if (this.fUM != null) {
        paramVarArgs.f(3, this.fUM);
      }
      if (this.REw != null) {
        paramVarArgs.f(4, this.REw);
      }
      if (this.REx != null) {
        paramVarArgs.f(5, this.REx);
      }
      paramVarArgs.aY(6, this.REy);
      if (this.comment != null) {
        paramVarArgs.f(7, this.comment);
      }
      AppMethodBeat.o(114073);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.fUL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tnX);
      }
      i = paramInt;
      if (this.fUM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fUM);
      }
      paramInt = i;
      if (this.REw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.REw);
      }
      i = paramInt;
      if (this.REx != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.REx);
      }
      i += g.a.a.b.b.a.bM(6, this.REy);
      paramInt = i;
      if (this.comment != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.comment);
      }
      AppMethodBeat.o(114073);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114073);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehh localehh = (ehh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114073);
          return -1;
        case 1: 
          localehh.fUL = locala.abFh.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 2: 
          localehh.tnX = locala.abFh.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 3: 
          localehh.fUM = locala.abFh.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 4: 
          localehh.REw = locala.abFh.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 5: 
          localehh.REx = locala.abFh.readString();
          AppMethodBeat.o(114073);
          return 0;
        case 6: 
          localehh.REy = locala.abFh.AK();
          AppMethodBeat.o(114073);
          return 0;
        }
        localehh.comment = locala.abFh.readString();
        AppMethodBeat.o(114073);
        return 0;
      }
      AppMethodBeat.o(114073);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehh
 * JD-Core Version:    0.7.0.1
 */