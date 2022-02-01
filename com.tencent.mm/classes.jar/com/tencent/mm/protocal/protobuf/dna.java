package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dna
  extends com.tencent.mm.cd.a
{
  public String TUk;
  public String TUl;
  public String TUm;
  public String TUn;
  public String TUo;
  public String TUp;
  public String TUq;
  public String desc;
  public String icon;
  public String title;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208192);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.icon != null) {
        paramVarArgs.f(2, this.icon);
      }
      if (this.desc != null) {
        paramVarArgs.f(3, this.desc);
      }
      paramVarArgs.aY(4, this.type);
      if (this.value != null) {
        paramVarArgs.f(5, this.value);
      }
      if (this.TUk != null) {
        paramVarArgs.f(6, this.TUk);
      }
      if (this.TUl != null) {
        paramVarArgs.f(7, this.TUl);
      }
      if (this.TUm != null) {
        paramVarArgs.f(8, this.TUm);
      }
      if (this.TUn != null) {
        paramVarArgs.f(9, this.TUn);
      }
      if (this.TUo != null) {
        paramVarArgs.f(10, this.TUo);
      }
      if (this.TUp != null) {
        paramVarArgs.f(11, this.TUp);
      }
      if (this.TUq != null) {
        paramVarArgs.f(12, this.TUq);
      }
      AppMethodBeat.o(208192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label874;
      }
    }
    label874:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.icon);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.desc);
      }
      i += g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.value);
      }
      i = paramInt;
      if (this.TUk != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TUk);
      }
      paramInt = i;
      if (this.TUl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TUl);
      }
      i = paramInt;
      if (this.TUm != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TUm);
      }
      paramInt = i;
      if (this.TUn != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TUn);
      }
      i = paramInt;
      if (this.TUo != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TUo);
      }
      paramInt = i;
      if (this.TUp != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TUp);
      }
      i = paramInt;
      if (this.TUq != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TUq);
      }
      AppMethodBeat.o(208192);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208192);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dna localdna = (dna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208192);
          return -1;
        case 1: 
          localdna.title = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 2: 
          localdna.icon = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 3: 
          localdna.desc = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 4: 
          localdna.type = locala.abFh.AK();
          AppMethodBeat.o(208192);
          return 0;
        case 5: 
          localdna.value = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 6: 
          localdna.TUk = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 7: 
          localdna.TUl = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 8: 
          localdna.TUm = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 9: 
          localdna.TUn = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 10: 
          localdna.TUo = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        case 11: 
          localdna.TUp = locala.abFh.readString();
          AppMethodBeat.o(208192);
          return 0;
        }
        localdna.TUq = locala.abFh.readString();
        AppMethodBeat.o(208192);
        return 0;
      }
      AppMethodBeat.o(208192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */