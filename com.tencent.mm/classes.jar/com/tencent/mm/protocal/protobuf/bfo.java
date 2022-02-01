package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bfo
  extends com.tencent.mm.cd.a
{
  public String SQl;
  public String content;
  public String link;
  public int subType;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169020);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      paramVarArgs.aY(3, this.subType);
      if (this.link != null) {
        paramVarArgs.f(4, this.link);
      }
      if (this.SQl != null) {
        paramVarArgs.f(5, this.SQl);
      }
      AppMethodBeat.o(169020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.content);
      }
      i += g.a.a.b.b.a.bM(3, this.subType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.link);
      }
      i = paramInt;
      if (this.SQl != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SQl);
      }
      AppMethodBeat.o(169020);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169020);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfo localbfo = (bfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169020);
          return -1;
        case 1: 
          localbfo.title = locala.abFh.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 2: 
          localbfo.content = locala.abFh.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 3: 
          localbfo.subType = locala.abFh.AK();
          AppMethodBeat.o(169020);
          return 0;
        case 4: 
          localbfo.link = locala.abFh.readString();
          AppMethodBeat.o(169020);
          return 0;
        }
        localbfo.SQl = locala.abFh.readString();
        AppMethodBeat.o(169020);
        return 0;
      }
      AppMethodBeat.o(169020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfo
 * JD-Core Version:    0.7.0.1
 */