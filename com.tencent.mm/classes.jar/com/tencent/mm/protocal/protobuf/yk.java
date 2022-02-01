package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yk
  extends com.tencent.mm.cd.a
{
  public boolean Skv;
  public String desc;
  public String result;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186197);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.result != null) {
        paramVarArgs.f(3, this.result);
      }
      paramVarArgs.co(4, this.Skv);
      AppMethodBeat.o(186197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.result != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.result);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(186197);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186197);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186197);
          return -1;
        case 1: 
          localyk.title = locala.abFh.readString();
          AppMethodBeat.o(186197);
          return 0;
        case 2: 
          localyk.desc = locala.abFh.readString();
          AppMethodBeat.o(186197);
          return 0;
        case 3: 
          localyk.result = locala.abFh.readString();
          AppMethodBeat.o(186197);
          return 0;
        }
        localyk.Skv = locala.abFh.AB();
        AppMethodBeat.o(186197);
        return 0;
      }
      AppMethodBeat.o(186197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yk
 * JD-Core Version:    0.7.0.1
 */