package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byx
  extends com.tencent.mm.bw.a
{
  public String Ecn;
  public int FnS;
  public int FnT;
  public String FnU;
  public int FnV;
  public String hhs;
  public int tfK;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ecn != null) {
        paramVarArgs.d(1, this.Ecn);
      }
      paramVarArgs.aR(2, this.FnS);
      paramVarArgs.aR(3, this.tfK);
      paramVarArgs.aR(4, this.FnT);
      paramVarArgs.aR(5, this.type);
      if (this.hhs != null) {
        paramVarArgs.d(6, this.hhs);
      }
      if (this.FnU != null) {
        paramVarArgs.d(7, this.FnU);
      }
      paramVarArgs.aR(8, this.FnV);
      AppMethodBeat.o(6412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ecn == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ecn) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FnS) + f.a.a.b.b.a.bx(3, this.tfK) + f.a.a.b.b.a.bx(4, this.FnT) + f.a.a.b.b.a.bx(5, this.type);
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hhs);
      }
      i = paramInt;
      if (this.FnU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FnU);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.FnV);
      AppMethodBeat.o(6412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6412);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byx localbyx = (byx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6412);
          return -1;
        case 1: 
          localbyx.Ecn = locala.LVo.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 2: 
          localbyx.FnS = locala.LVo.xF();
          AppMethodBeat.o(6412);
          return 0;
        case 3: 
          localbyx.tfK = locala.LVo.xF();
          AppMethodBeat.o(6412);
          return 0;
        case 4: 
          localbyx.FnT = locala.LVo.xF();
          AppMethodBeat.o(6412);
          return 0;
        case 5: 
          localbyx.type = locala.LVo.xF();
          AppMethodBeat.o(6412);
          return 0;
        case 6: 
          localbyx.hhs = locala.LVo.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 7: 
          localbyx.FnU = locala.LVo.readString();
          AppMethodBeat.o(6412);
          return 0;
        }
        localbyx.FnV = locala.LVo.xF();
        AppMethodBeat.o(6412);
        return 0;
      }
      AppMethodBeat.o(6412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */