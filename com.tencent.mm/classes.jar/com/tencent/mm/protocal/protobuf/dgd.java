package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgd
  extends com.tencent.mm.bw.a
{
  public int DPI;
  public String FPw;
  public String FPx;
  public String iJW;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      paramVarArgs.aR(3, this.DPI);
      if (this.FPw != null) {
        paramVarArgs.d(4, this.FPw);
      }
      if (this.iJW != null) {
        paramVarArgs.d(5, this.iJW);
      }
      if (this.FPx != null) {
        paramVarArgs.d(6, this.FPx);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ndW);
      }
      i += f.a.a.b.b.a.bx(3, this.DPI);
      paramInt = i;
      if (this.FPw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPw);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iJW);
      }
      paramInt = i;
      if (this.FPx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FPx);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dgd localdgd = (dgd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localdgd.ncR = locala.LVo.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localdgd.ndW = locala.LVo.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localdgd.DPI = locala.LVo.xF();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localdgd.FPw = locala.LVo.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localdgd.iJW = locala.LVo.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localdgd.FPx = locala.LVo.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgd
 * JD-Core Version:    0.7.0.1
 */