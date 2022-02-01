package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eno
  extends com.tencent.mm.cd.a
{
  public int Uql;
  public String Uqm;
  public String Uqn;
  public String Uqo;
  public String Uqp;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Uql);
      if (this.Uqm != null) {
        paramVarArgs.f(2, this.Uqm);
      }
      if (this.Uqn != null) {
        paramVarArgs.f(3, this.Uqn);
      }
      paramVarArgs.aY(4, this.height);
      paramVarArgs.aY(5, this.width);
      if (this.Uqo != null) {
        paramVarArgs.f(6, this.Uqo);
      }
      if (this.Uqp != null) {
        paramVarArgs.f(7, this.Uqp);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Uql) + 0;
      paramInt = i;
      if (this.Uqm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uqm);
      }
      i = paramInt;
      if (this.Uqn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uqn);
      }
      i = i + g.a.a.b.b.a.bM(4, this.height) + g.a.a.b.b.a.bM(5, this.width);
      paramInt = i;
      if (this.Uqo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uqo);
      }
      i = paramInt;
      if (this.Uqp != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Uqp);
      }
      AppMethodBeat.o(168761);
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
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eno localeno = (eno)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localeno.Uql = locala.abFh.AK();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localeno.Uqm = locala.abFh.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localeno.Uqn = locala.abFh.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localeno.height = locala.abFh.AK();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localeno.width = locala.abFh.AK();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localeno.Uqo = locala.abFh.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localeno.Uqp = locala.abFh.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eno
 * JD-Core Version:    0.7.0.1
 */