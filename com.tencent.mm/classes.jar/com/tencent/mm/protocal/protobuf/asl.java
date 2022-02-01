package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class asl
  extends com.tencent.mm.cd.a
{
  public String link;
  public int style;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.link != null) {
        paramVarArgs.f(1, this.link);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      paramVarArgs.aY(3, this.type);
      paramVarArgs.aY(4, this.style);
      AppMethodBeat.o(168952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.link == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.link) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.type);
      int j = g.a.a.b.b.a.bM(4, this.style);
      AppMethodBeat.o(168952);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168952);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        asl localasl = (asl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168952);
          return -1;
        case 1: 
          localasl.link = locala.abFh.readString();
          AppMethodBeat.o(168952);
          return 0;
        case 2: 
          localasl.title = locala.abFh.readString();
          AppMethodBeat.o(168952);
          return 0;
        case 3: 
          localasl.type = locala.abFh.AK();
          AppMethodBeat.o(168952);
          return 0;
        }
        localasl.style = locala.abFh.AK();
        AppMethodBeat.o(168952);
        return 0;
      }
      AppMethodBeat.o(168952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asl
 * JD-Core Version:    0.7.0.1
 */