package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class awx
  extends com.tencent.mm.bx.a
{
  public String ZIb;
  public String ZIc;
  public String ZId;
  public String ZIe;
  public String ZIf;
  public boolean ZIg;
  public boolean ZIh;
  public String ZIi;
  public String ZIj;
  public String ZIk;
  public String ZIl;
  public String ZIm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259963);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZIb != null) {
        paramVarArgs.g(1, this.ZIb);
      }
      if (this.ZIc != null) {
        paramVarArgs.g(2, this.ZIc);
      }
      if (this.ZId != null) {
        paramVarArgs.g(3, this.ZId);
      }
      if (this.ZIe != null) {
        paramVarArgs.g(4, this.ZIe);
      }
      if (this.ZIf != null) {
        paramVarArgs.g(5, this.ZIf);
      }
      paramVarArgs.di(6, this.ZIg);
      paramVarArgs.di(7, this.ZIh);
      if (this.ZIi != null) {
        paramVarArgs.g(8, this.ZIi);
      }
      if (this.ZIj != null) {
        paramVarArgs.g(9, this.ZIj);
      }
      if (this.ZIk != null) {
        paramVarArgs.g(10, this.ZIk);
      }
      if (this.ZIl != null) {
        paramVarArgs.g(11, this.ZIl);
      }
      if (this.ZIm != null) {
        paramVarArgs.g(12, this.ZIm);
      }
      AppMethodBeat.o(259963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZIb == null) {
        break label846;
      }
    }
    label846:
    for (int i = i.a.a.b.b.a.h(1, this.ZIb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZIc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZIc);
      }
      i = paramInt;
      if (this.ZId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZId);
      }
      paramInt = i;
      if (this.ZIe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZIe);
      }
      i = paramInt;
      if (this.ZIf != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZIf);
      }
      i = i + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.ZIi != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZIi);
      }
      i = paramInt;
      if (this.ZIj != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZIj);
      }
      paramInt = i;
      if (this.ZIk != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZIk);
      }
      i = paramInt;
      if (this.ZIl != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZIl);
      }
      paramInt = i;
      if (this.ZIm != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZIm);
      }
      AppMethodBeat.o(259963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259963);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        awx localawx = (awx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259963);
          return -1;
        case 1: 
          localawx.ZIb = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 2: 
          localawx.ZIc = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 3: 
          localawx.ZId = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 4: 
          localawx.ZIe = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 5: 
          localawx.ZIf = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 6: 
          localawx.ZIg = locala.ajGk.aai();
          AppMethodBeat.o(259963);
          return 0;
        case 7: 
          localawx.ZIh = locala.ajGk.aai();
          AppMethodBeat.o(259963);
          return 0;
        case 8: 
          localawx.ZIi = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 9: 
          localawx.ZIj = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 10: 
          localawx.ZIk = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        case 11: 
          localawx.ZIl = locala.ajGk.readString();
          AppMethodBeat.o(259963);
          return 0;
        }
        localawx.ZIm = locala.ajGk.readString();
        AppMethodBeat.o(259963);
        return 0;
      }
      AppMethodBeat.o(259963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awx
 * JD-Core Version:    0.7.0.1
 */