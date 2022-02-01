package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eor
  extends com.tencent.mm.cd.a
{
  public int SAk;
  public String lor;
  public String lot;
  public String lou;
  public String lov;
  public String low;
  public String lox;
  public String loy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lor != null) {
        paramVarArgs.f(1, this.lor);
      }
      paramVarArgs.aY(2, this.SAk);
      if (this.lou != null) {
        paramVarArgs.f(3, this.lou);
      }
      if (this.lov != null) {
        paramVarArgs.f(4, this.lov);
      }
      if (this.lot != null) {
        paramVarArgs.f(5, this.lot);
      }
      if (this.low != null) {
        paramVarArgs.f(6, this.low);
      }
      if (this.lox != null) {
        paramVarArgs.f(7, this.lox);
      }
      if (this.loy != null) {
        paramVarArgs.f(8, this.loy);
      }
      AppMethodBeat.o(127178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lor == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.g(1, this.lor) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SAk);
      paramInt = i;
      if (this.lou != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.lou);
      }
      i = paramInt;
      if (this.lov != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.lov);
      }
      paramInt = i;
      if (this.lot != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.lot);
      }
      i = paramInt;
      if (this.low != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.low);
      }
      paramInt = i;
      if (this.lox != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lox);
      }
      i = paramInt;
      if (this.loy != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.loy);
      }
      AppMethodBeat.o(127178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127178);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eor localeor = (eor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127178);
          return -1;
        case 1: 
          localeor.lor = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 2: 
          localeor.SAk = locala.abFh.AK();
          AppMethodBeat.o(127178);
          return 0;
        case 3: 
          localeor.lou = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 4: 
          localeor.lov = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 5: 
          localeor.lot = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 6: 
          localeor.low = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 7: 
          localeor.lox = locala.abFh.readString();
          AppMethodBeat.o(127178);
          return 0;
        }
        localeor.loy = locala.abFh.readString();
        AppMethodBeat.o(127178);
        return 0;
      }
      AppMethodBeat.o(127178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eor
 * JD-Core Version:    0.7.0.1
 */