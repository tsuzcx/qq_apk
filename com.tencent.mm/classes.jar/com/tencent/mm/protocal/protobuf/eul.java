package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eul
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String YJg;
  public String YVX;
  public int abxm;
  public String abxn;
  public String auth_desc;
  public String tIs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVX != null) {
        paramVarArgs.g(1, this.YVX);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      paramVarArgs.bS(3, this.abxm);
      if (this.tIs != null) {
        paramVarArgs.g(4, this.tIs);
      }
      if (this.auth_desc != null) {
        paramVarArgs.g(5, this.auth_desc);
      }
      if (this.abxn != null) {
        paramVarArgs.g(6, this.abxn);
      }
      if (this.YJg != null) {
        paramVarArgs.g(7, this.YJg);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVX == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.b.b.a.h(1, this.YVX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGG);
      }
      i += i.a.a.b.b.a.cJ(3, this.abxm);
      paramInt = i;
      if (this.tIs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.tIs);
      }
      i = paramInt;
      if (this.auth_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.auth_desc);
      }
      paramInt = i;
      if (this.abxn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abxn);
      }
      i = paramInt;
      if (this.YJg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YJg);
      }
      AppMethodBeat.o(123643);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eul localeul = (eul)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localeul.YVX = locala.ajGk.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localeul.IGG = locala.ajGk.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localeul.abxm = locala.ajGk.aar();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localeul.tIs = locala.ajGk.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localeul.auth_desc = locala.ajGk.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 6: 
          localeul.abxn = locala.ajGk.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localeul.YJg = locala.ajGk.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eul
 * JD-Core Version:    0.7.0.1
 */