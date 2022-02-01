package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eij
  extends com.tencent.mm.cd.a
{
  public long Ukr;
  public int actionType;
  public String icon;
  public String id;
  public String rsw;
  public String title;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152995);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      paramVarArgs.bm(3, this.Ukr);
      paramVarArgs.aY(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      if (this.rsw != null) {
        paramVarArgs.f(7, this.rsw);
      }
      if (this.icon != null) {
        paramVarArgs.f(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.wording);
      }
      i = i + g.a.a.b.b.a.p(3, this.Ukr) + g.a.a.b.b.a.bM(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.title);
      }
      paramInt = i;
      if (this.rsw != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.rsw);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eij localeij = (eij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localeij.id = locala.abFh.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localeij.wording = locala.abFh.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localeij.Ukr = locala.abFh.AN();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localeij.actionType = locala.abFh.AK();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localeij.url = locala.abFh.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localeij.title = locala.abFh.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localeij.rsw = locala.abFh.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localeij.icon = locala.abFh.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eij
 * JD-Core Version:    0.7.0.1
 */