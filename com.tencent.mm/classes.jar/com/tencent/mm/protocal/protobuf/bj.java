package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bj
  extends com.tencent.mm.cd.a
{
  public String Ooe;
  public String Oof;
  public String Pap;
  public int Paq;
  public String icon;
  public String title;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.icon != null) {
        paramVarArgs.f(3, this.icon);
      }
      if (this.Pap != null) {
        paramVarArgs.f(4, this.Pap);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      if (this.Ooe != null) {
        paramVarArgs.f(6, this.Ooe);
      }
      if (this.Oof != null) {
        paramVarArgs.f(7, this.Oof);
      }
      paramVarArgs.aY(8, this.Paq);
      AppMethodBeat.o(91345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.g(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.icon);
      }
      paramInt = i;
      if (this.Pap != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Pap);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.title);
      }
      paramInt = i;
      if (this.Ooe != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ooe);
      }
      i = paramInt;
      if (this.Oof != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Oof);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.Paq);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbj.url = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbj.wording = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbj.icon = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbj.Pap = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbj.title = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbj.Ooe = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbj.Oof = locala.abFh.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbj.Paq = locala.abFh.AK();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */