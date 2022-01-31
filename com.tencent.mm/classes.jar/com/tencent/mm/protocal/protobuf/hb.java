package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hb
  extends com.tencent.mm.bv.a
{
  public int pdt;
  public String title;
  public String uaJ;
  public String uaL;
  public String ugl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56707);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.aO(2, this.pdt);
      if (this.uaJ != null) {
        paramVarArgs.e(3, this.uaJ);
      }
      if (this.ugl != null) {
        paramVarArgs.e(4, this.ugl);
      }
      if (this.uaL != null) {
        paramVarArgs.e(5, this.uaL);
      }
      AppMethodBeat.o(56707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pdt);
      paramInt = i;
      if (this.uaJ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.uaJ);
      }
      i = paramInt;
      if (this.ugl != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ugl);
      }
      paramInt = i;
      if (this.uaL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.uaL);
      }
      AppMethodBeat.o(56707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56707);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hb localhb = (hb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56707);
          return -1;
        case 1: 
          localhb.title = locala.CLY.readString();
          AppMethodBeat.o(56707);
          return 0;
        case 2: 
          localhb.pdt = locala.CLY.sl();
          AppMethodBeat.o(56707);
          return 0;
        case 3: 
          localhb.uaJ = locala.CLY.readString();
          AppMethodBeat.o(56707);
          return 0;
        case 4: 
          localhb.ugl = locala.CLY.readString();
          AppMethodBeat.o(56707);
          return 0;
        }
        localhb.uaL = locala.CLY.readString();
        AppMethodBeat.o(56707);
        return 0;
      }
      AppMethodBeat.o(56707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hb
 * JD-Core Version:    0.7.0.1
 */