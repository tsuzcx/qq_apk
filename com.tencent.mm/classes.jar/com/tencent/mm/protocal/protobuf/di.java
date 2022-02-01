package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class di
  extends com.tencent.mm.bx.a
{
  public String FvB;
  public String FvC;
  public String jdd;
  public String jde;
  public String jdl;
  public String nDo;
  public String ugo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.jdl != null) {
        paramVarArgs.d(1, this.jdl);
      }
      if (this.jdd != null) {
        paramVarArgs.d(2, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(3, this.jde);
      }
      if (this.ugo != null) {
        paramVarArgs.d(4, this.ugo);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      if (this.FvB != null) {
        paramVarArgs.d(6, this.FvB);
      }
      if (this.FvC != null) {
        paramVarArgs.d(7, this.FvC);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jdl == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.jdl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jde);
      }
      paramInt = i;
      if (this.ugo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ugo);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      paramInt = i;
      if (this.FvB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FvB);
      }
      i = paramInt;
      if (this.FvC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FvC);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdi.jdl = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdi.jdd = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdi.jde = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdi.ugo = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdi.nDo = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdi.FvB = locala.NPN.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdi.FvC = locala.NPN.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.di
 * JD-Core Version:    0.7.0.1
 */