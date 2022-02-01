package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ciu
  extends com.tencent.mm.bx.a
{
  public String FRw;
  public int HcH;
  public String HcI;
  public String HcJ;
  public String duW;
  public String hzB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      paramVarArgs.aS(2, this.HcH);
      if (this.HcI != null) {
        paramVarArgs.d(3, this.HcI);
      }
      if (this.HcJ != null) {
        paramVarArgs.d(4, this.HcJ);
      }
      if (this.FRw != null) {
        paramVarArgs.d(5, this.FRw);
      }
      if (this.hzB != null) {
        paramVarArgs.d(6, this.hzB);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HcH);
      paramInt = i;
      if (this.HcI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HcI);
      }
      i = paramInt;
      if (this.HcJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HcJ);
      }
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FRw);
      }
      i = paramInt;
      if (this.hzB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hzB);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ciu localciu = (ciu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localciu.duW = locala.NPN.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localciu.HcH = locala.NPN.zc();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localciu.HcI = locala.NPN.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localciu.HcJ = locala.NPN.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localciu.FRw = locala.NPN.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localciu.hzB = locala.NPN.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciu
 * JD-Core Version:    0.7.0.1
 */