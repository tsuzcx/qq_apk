package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eq
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String Url;
  public long wqL;
  public int wqM;
  public String wqN;
  public int wqO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.am(2, this.wqL);
      paramVarArgs.aO(3, this.wqM);
      if (this.wqN != null) {
        paramVarArgs.e(4, this.wqN);
      }
      paramVarArgs.aO(5, this.Scene);
      paramVarArgs.aO(6, this.wqO);
      AppMethodBeat.o(14702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.wqL) + e.a.a.b.b.a.bl(3, this.wqM);
      paramInt = i;
      if (this.wqN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wqN);
      }
      i = e.a.a.b.b.a.bl(5, this.Scene);
      int j = e.a.a.b.b.a.bl(6, this.wqO);
      AppMethodBeat.o(14702);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14702);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14702);
          return -1;
        case 1: 
          localeq.Url = locala.CLY.readString();
          AppMethodBeat.o(14702);
          return 0;
        case 2: 
          localeq.wqL = locala.CLY.sm();
          AppMethodBeat.o(14702);
          return 0;
        case 3: 
          localeq.wqM = locala.CLY.sl();
          AppMethodBeat.o(14702);
          return 0;
        case 4: 
          localeq.wqN = locala.CLY.readString();
          AppMethodBeat.o(14702);
          return 0;
        case 5: 
          localeq.Scene = locala.CLY.sl();
          AppMethodBeat.o(14702);
          return 0;
        }
        localeq.wqO = locala.CLY.sl();
        AppMethodBeat.o(14702);
        return 0;
      }
      AppMethodBeat.o(14702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */