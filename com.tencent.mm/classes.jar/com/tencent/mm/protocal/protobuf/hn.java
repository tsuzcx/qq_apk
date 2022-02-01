package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hn
  extends com.tencent.mm.bw.a
{
  public String DPF;
  public int DUS;
  public String DUT;
  public String DUU;
  public String iJW;
  public String ncR;
  public String ndW;
  public int suv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPF != null) {
        paramVarArgs.d(1, this.DPF);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      paramVarArgs.aR(4, this.DUS);
      if (this.DUT != null) {
        paramVarArgs.d(5, this.DUT);
      }
      if (this.iJW != null) {
        paramVarArgs.d(6, this.iJW);
      }
      if (this.DUU != null) {
        paramVarArgs.d(7, this.DUU);
      }
      paramVarArgs.aR(8, this.suv);
      AppMethodBeat.o(32127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPF == null) {
        break label624;
      }
    }
    label624:
    for (int i = f.a.a.b.b.a.e(1, this.DPF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      i += f.a.a.b.b.a.bx(4, this.DUS);
      paramInt = i;
      if (this.DUT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DUT);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.iJW);
      }
      paramInt = i;
      if (this.DUU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DUU);
      }
      i = f.a.a.b.b.a.bx(8, this.suv);
      AppMethodBeat.o(32127);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hn localhn = (hn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32127);
          return -1;
        case 1: 
          localhn.DPF = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 2: 
          localhn.ndW = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 3: 
          localhn.ncR = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 4: 
          localhn.DUS = locala.LVo.xF();
          AppMethodBeat.o(32127);
          return 0;
        case 5: 
          localhn.DUT = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 6: 
          localhn.iJW = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 7: 
          localhn.DUU = locala.LVo.readString();
          AppMethodBeat.o(32127);
          return 0;
        }
        localhn.suv = locala.LVo.xF();
        AppMethodBeat.o(32127);
        return 0;
      }
      AppMethodBeat.o(32127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */