package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efo
  extends com.tencent.mm.bx.a
{
  public String abkU;
  public String abkV;
  public String abkW;
  public String abkX;
  public String abkY;
  public String abkZ;
  public String abla;
  public String desc;
  public String icon;
  public String title;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259529);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.icon != null) {
        paramVarArgs.g(2, this.icon);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      paramVarArgs.bS(4, this.type);
      if (this.value != null) {
        paramVarArgs.g(5, this.value);
      }
      if (this.abkU != null) {
        paramVarArgs.g(6, this.abkU);
      }
      if (this.abkV != null) {
        paramVarArgs.g(7, this.abkV);
      }
      if (this.abkW != null) {
        paramVarArgs.g(8, this.abkW);
      }
      if (this.abkX != null) {
        paramVarArgs.g(9, this.abkX);
      }
      if (this.abkY != null) {
        paramVarArgs.g(10, this.abkY);
      }
      if (this.abkZ != null) {
        paramVarArgs.g(11, this.abkZ);
      }
      if (this.abla != null) {
        paramVarArgs.g(12, this.abla);
      }
      AppMethodBeat.o(259529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label870;
      }
    }
    label870:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      i += i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.value);
      }
      i = paramInt;
      if (this.abkU != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abkU);
      }
      paramInt = i;
      if (this.abkV != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abkV);
      }
      i = paramInt;
      if (this.abkW != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abkW);
      }
      paramInt = i;
      if (this.abkX != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abkX);
      }
      i = paramInt;
      if (this.abkY != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abkY);
      }
      paramInt = i;
      if (this.abkZ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abkZ);
      }
      i = paramInt;
      if (this.abla != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abla);
      }
      AppMethodBeat.o(259529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259529);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        efo localefo = (efo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259529);
          return -1;
        case 1: 
          localefo.title = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 2: 
          localefo.icon = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 3: 
          localefo.desc = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 4: 
          localefo.type = locala.ajGk.aar();
          AppMethodBeat.o(259529);
          return 0;
        case 5: 
          localefo.value = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 6: 
          localefo.abkU = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 7: 
          localefo.abkV = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 8: 
          localefo.abkW = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 9: 
          localefo.abkX = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 10: 
          localefo.abkY = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        case 11: 
          localefo.abkZ = locala.ajGk.readString();
          AppMethodBeat.o(259529);
          return 0;
        }
        localefo.abla = locala.ajGk.readString();
        AppMethodBeat.o(259529);
        return 0;
      }
      AppMethodBeat.o(259529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efo
 * JD-Core Version:    0.7.0.1
 */