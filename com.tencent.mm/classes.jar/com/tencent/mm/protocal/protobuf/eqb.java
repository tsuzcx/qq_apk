package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqb
  extends com.tencent.mm.bx.a
{
  public int PJy;
  public int abtZ;
  public int abua;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String vYj;
  public String vhx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhx != null) {
        paramVarArgs.g(1, this.vhx);
      }
      paramVarArgs.bS(2, this.abtZ);
      if (this.mut != null) {
        paramVarArgs.g(3, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(4, this.muu);
      }
      paramVarArgs.bS(5, this.PJy);
      paramVarArgs.bS(6, this.abua);
      if (this.muv != null) {
        paramVarArgs.g(7, this.muv);
      }
      if (this.muw != null) {
        paramVarArgs.g(8, this.muw);
      }
      if (this.vYj != null) {
        paramVarArgs.g(9, this.vYj);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhx == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.b.b.a.h(1, this.vhx) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abtZ);
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.mut);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.muu);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.PJy) + i.a.a.b.b.a.cJ(6, this.abua);
      paramInt = i;
      if (this.muv != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.muv);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.muw);
      }
      paramInt = i;
      if (this.vYj != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.vYj);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eqb localeqb = (eqb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localeqb.vhx = locala.ajGk.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localeqb.abtZ = locala.ajGk.aar();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localeqb.mut = locala.ajGk.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localeqb.muu = locala.ajGk.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localeqb.PJy = locala.ajGk.aar();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localeqb.abua = locala.ajGk.aar();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localeqb.muv = locala.ajGk.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localeqb.muw = locala.ajGk.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localeqb.vYj = locala.ajGk.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqb
 * JD-Core Version:    0.7.0.1
 */