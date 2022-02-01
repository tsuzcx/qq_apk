package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class il
  extends com.tencent.mm.cd.a
{
  public String ODt;
  public String Ooe;
  public String Oof;
  public int jump_type;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      paramVarArgs.aY(2, this.jump_type);
      if (this.ODt != null) {
        paramVarArgs.f(3, this.ODt);
      }
      if (this.Ooe != null) {
        paramVarArgs.f(4, this.Ooe);
      }
      if (this.Oof != null) {
        paramVarArgs.f(5, this.Oof);
      }
      AppMethodBeat.o(91354);
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
      int i = paramInt + g.a.a.b.b.a.bM(2, this.jump_type);
      paramInt = i;
      if (this.ODt != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ODt);
      }
      i = paramInt;
      if (this.Ooe != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Ooe);
      }
      paramInt = i;
      if (this.Oof != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Oof);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        il localil = (il)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localil.title = locala.abFh.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localil.jump_type = locala.abFh.AK();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localil.ODt = locala.abFh.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localil.Ooe = locala.abFh.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localil.Oof = locala.abFh.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.il
 * JD-Core Version:    0.7.0.1
 */