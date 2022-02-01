package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxp
  extends com.tencent.mm.bx.a
{
  public String GRG;
  public String GRH;
  public String GRI;
  public String hDm;
  public String hDo;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hDo != null) {
        paramVarArgs.d(2, this.hDo);
      }
      if (this.hDm != null) {
        paramVarArgs.d(3, this.hDm);
      }
      if (this.GRG != null) {
        paramVarArgs.d(4, this.GRG);
      }
      if (this.GRH != null) {
        paramVarArgs.d(5, this.GRH);
      }
      if (this.GRI != null) {
        paramVarArgs.d(6, this.GRI);
      }
      AppMethodBeat.o(103209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hDo);
      }
      i = paramInt;
      if (this.hDm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDm);
      }
      paramInt = i;
      if (this.GRG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GRG);
      }
      i = paramInt;
      if (this.GRH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GRH);
      }
      paramInt = i;
      if (this.GRI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GRI);
      }
      AppMethodBeat.o(103209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103209);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxp localbxp = (bxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103209);
          return -1;
        case 1: 
          localbxp.title = locala.NPN.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 2: 
          localbxp.hDo = locala.NPN.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 3: 
          localbxp.hDm = locala.NPN.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 4: 
          localbxp.GRG = locala.NPN.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 5: 
          localbxp.GRH = locala.NPN.readString();
          AppMethodBeat.o(103209);
          return 0;
        }
        localbxp.GRI = locala.NPN.readString();
        AppMethodBeat.o(103209);
        return 0;
      }
      AppMethodBeat.o(103209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxp
 * JD-Core Version:    0.7.0.1
 */