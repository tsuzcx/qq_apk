package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dok
  extends com.tencent.mm.bw.a
{
  public String GOi;
  public String HVm;
  public int HVn;
  public String oOW;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HVm != null) {
        paramVarArgs.d(4, this.HVm);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      if (this.oOW != null) {
        paramVarArgs.d(6, this.oOW);
      }
      paramVarArgs.aS(7, this.HVn);
      if (this.GOi != null) {
        paramVarArgs.d(8, this.GOi);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HVm == null) {
        break label446;
      }
    }
    label446:
    for (int i = f.a.a.b.b.a.e(4, this.HVm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sign);
      }
      i = paramInt;
      if (this.oOW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oOW);
      }
      i += f.a.a.b.b.a.bz(7, this.HVn);
      paramInt = i;
      if (this.GOi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GOi);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dok localdok = (dok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localdok.HVm = locala.OmT.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localdok.sign = locala.OmT.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localdok.oOW = locala.OmT.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localdok.HVn = locala.OmT.zc();
          AppMethodBeat.o(91717);
          return 0;
        }
        localdok.GOi = locala.OmT.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dok
 * JD-Core Version:    0.7.0.1
 */