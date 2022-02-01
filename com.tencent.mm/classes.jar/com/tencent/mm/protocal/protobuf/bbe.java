package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbe
  extends com.tencent.mm.cd.a
{
  public String SMP;
  public String SMQ;
  public String content;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230220);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SMP != null) {
        paramVarArgs.f(2, this.SMP);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      if (this.SMQ != null) {
        paramVarArgs.f(5, this.SMQ);
      }
      AppMethodBeat.o(230220);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SMP);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.content);
      }
      i = paramInt;
      if (this.SMQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SMQ);
      }
      AppMethodBeat.o(230220);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230220);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbe localbbe = (bbe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230220);
        return -1;
      case 1: 
        localbbe.type = locala.abFh.AK();
        AppMethodBeat.o(230220);
        return 0;
      case 2: 
        localbbe.SMP = locala.abFh.readString();
        AppMethodBeat.o(230220);
        return 0;
      case 3: 
        localbbe.title = locala.abFh.readString();
        AppMethodBeat.o(230220);
        return 0;
      case 4: 
        localbbe.content = locala.abFh.readString();
        AppMethodBeat.o(230220);
        return 0;
      }
      localbbe.SMQ = locala.abFh.readString();
      AppMethodBeat.o(230220);
      return 0;
    }
    AppMethodBeat.o(230220);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbe
 * JD-Core Version:    0.7.0.1
 */