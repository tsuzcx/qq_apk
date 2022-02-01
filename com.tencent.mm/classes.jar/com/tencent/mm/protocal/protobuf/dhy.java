package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhy
  extends com.tencent.mm.bw.a
{
  public String ELF;
  public String FQT;
  public int FQU;
  public String ofa;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQT != null) {
        paramVarArgs.d(4, this.FQT);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      if (this.ofa != null) {
        paramVarArgs.d(6, this.ofa);
      }
      paramVarArgs.aR(7, this.FQU);
      if (this.ELF != null) {
        paramVarArgs.d(8, this.ELF);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQT == null) {
        break label446;
      }
    }
    label446:
    for (int i = f.a.a.b.b.a.e(4, this.FQT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sign);
      }
      i = paramInt;
      if (this.ofa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ofa);
      }
      i += f.a.a.b.b.a.bx(7, this.FQU);
      paramInt = i;
      if (this.ELF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ELF);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhy localdhy = (dhy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localdhy.FQT = locala.LVo.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localdhy.sign = locala.LVo.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localdhy.ofa = locala.LVo.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localdhy.FQU = locala.LVo.xF();
          AppMethodBeat.o(91717);
          return 0;
        }
        localdhy.ELF = locala.LVo.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhy
 * JD-Core Version:    0.7.0.1
 */