package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efn
  extends com.tencent.mm.bx.a
{
  public String HQM;
  public String HjZ;
  public String dxD;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HjZ != null) {
        paramVarArgs.d(1, this.HjZ);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.pinyin != null) {
        paramVarArgs.d(3, this.pinyin);
      }
      if (this.HQM != null) {
        paramVarArgs.d(4, this.HQM);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HjZ == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.HjZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.pinyin != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pinyin);
      }
      paramInt = i;
      if (this.HQM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HQM);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efn localefn = (efn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localefn.HjZ = locala.NPN.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localefn.dxD = locala.NPN.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localefn.pinyin = locala.NPN.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localefn.HQM = locala.NPN.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efn
 * JD-Core Version:    0.7.0.1
 */