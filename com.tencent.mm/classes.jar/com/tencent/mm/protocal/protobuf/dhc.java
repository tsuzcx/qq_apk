package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dhc
  extends com.tencent.mm.cd.a
{
  public String TOd;
  public String TOe;
  public String TOf;
  public String TOg;
  public String TOh;
  public String TOi;
  public String TOj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TOd != null) {
        paramVarArgs.f(1, this.TOd);
      }
      if (this.TOe != null) {
        paramVarArgs.f(2, this.TOe);
      }
      if (this.TOf != null) {
        paramVarArgs.f(3, this.TOf);
      }
      if (this.TOg != null) {
        paramVarArgs.f(4, this.TOg);
      }
      if (this.TOh != null) {
        paramVarArgs.f(5, this.TOh);
      }
      if (this.TOi != null) {
        paramVarArgs.f(6, this.TOi);
      }
      if (this.TOj != null) {
        paramVarArgs.f(7, this.TOj);
      }
      AppMethodBeat.o(201331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TOd == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.TOd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TOe != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TOe);
      }
      i = paramInt;
      if (this.TOf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TOf);
      }
      paramInt = i;
      if (this.TOg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TOg);
      }
      i = paramInt;
      if (this.TOh != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TOh);
      }
      paramInt = i;
      if (this.TOi != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TOi);
      }
      i = paramInt;
      if (this.TOj != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TOj);
      }
      AppMethodBeat.o(201331);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201331);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhc localdhc = (dhc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201331);
          return -1;
        case 1: 
          localdhc.TOd = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        case 2: 
          localdhc.TOe = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        case 3: 
          localdhc.TOf = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        case 4: 
          localdhc.TOg = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        case 5: 
          localdhc.TOh = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        case 6: 
          localdhc.TOi = locala.abFh.readString();
          AppMethodBeat.o(201331);
          return 0;
        }
        localdhc.TOj = locala.abFh.readString();
        AppMethodBeat.o(201331);
        return 0;
      }
      AppMethodBeat.o(201331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhc
 * JD-Core Version:    0.7.0.1
 */