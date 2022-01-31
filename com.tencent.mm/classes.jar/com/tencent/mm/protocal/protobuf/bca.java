package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bca
  extends com.tencent.mm.bv.a
{
  public String fjJ;
  public String fjL;
  public String title;
  public String xrf;
  public String xrg;
  public String xrh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14732);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.fjL != null) {
        paramVarArgs.e(2, this.fjL);
      }
      if (this.fjJ != null) {
        paramVarArgs.e(3, this.fjJ);
      }
      if (this.xrf != null) {
        paramVarArgs.e(4, this.xrf);
      }
      if (this.xrg != null) {
        paramVarArgs.e(5, this.xrg);
      }
      if (this.xrh != null) {
        paramVarArgs.e(6, this.xrh);
      }
      AppMethodBeat.o(14732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label530;
      }
    }
    label530:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fjL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fjL);
      }
      i = paramInt;
      if (this.fjJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fjJ);
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xrf);
      }
      i = paramInt;
      if (this.xrg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xrg);
      }
      paramInt = i;
      if (this.xrh != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xrh);
      }
      AppMethodBeat.o(14732);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14732);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bca localbca = (bca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14732);
          return -1;
        case 1: 
          localbca.title = locala.CLY.readString();
          AppMethodBeat.o(14732);
          return 0;
        case 2: 
          localbca.fjL = locala.CLY.readString();
          AppMethodBeat.o(14732);
          return 0;
        case 3: 
          localbca.fjJ = locala.CLY.readString();
          AppMethodBeat.o(14732);
          return 0;
        case 4: 
          localbca.xrf = locala.CLY.readString();
          AppMethodBeat.o(14732);
          return 0;
        case 5: 
          localbca.xrg = locala.CLY.readString();
          AppMethodBeat.o(14732);
          return 0;
        }
        localbca.xrh = locala.CLY.readString();
        AppMethodBeat.o(14732);
        return 0;
      }
      AppMethodBeat.o(14732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bca
 * JD-Core Version:    0.7.0.1
 */