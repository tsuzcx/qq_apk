package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baq
  extends com.tencent.mm.cd.a
{
  public String SKx;
  public String SMy;
  public String id;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200028);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.SKx != null) {
        paramVarArgs.f(2, this.SKx);
      }
      if (this.SMy != null) {
        paramVarArgs.f(3, this.SMy);
      }
      paramVarArgs.aY(4, this.status);
      AppMethodBeat.o(200028);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SKx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SKx);
      }
      i = paramInt;
      if (this.SMy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SMy);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.status);
      AppMethodBeat.o(200028);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200028);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        baq localbaq = (baq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200028);
          return -1;
        case 1: 
          localbaq.id = locala.abFh.readString();
          AppMethodBeat.o(200028);
          return 0;
        case 2: 
          localbaq.SKx = locala.abFh.readString();
          AppMethodBeat.o(200028);
          return 0;
        case 3: 
          localbaq.SMy = locala.abFh.readString();
          AppMethodBeat.o(200028);
          return 0;
        }
        localbaq.status = locala.abFh.AK();
        AppMethodBeat.o(200028);
        return 0;
      }
      AppMethodBeat.o(200028);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baq
 * JD-Core Version:    0.7.0.1
 */