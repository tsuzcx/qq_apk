package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnn
  extends com.tencent.mm.bx.a
{
  public String GuJ;
  public int HBA;
  public String HBz;
  public String oIu;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HBz != null) {
        paramVarArgs.d(4, this.HBz);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      if (this.oIu != null) {
        paramVarArgs.d(6, this.oIu);
      }
      paramVarArgs.aS(7, this.HBA);
      if (this.GuJ != null) {
        paramVarArgs.d(8, this.GuJ);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HBz == null) {
        break label446;
      }
    }
    label446:
    for (int i = f.a.a.b.b.a.e(4, this.HBz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sign);
      }
      i = paramInt;
      if (this.oIu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oIu);
      }
      i += f.a.a.b.b.a.bz(7, this.HBA);
      paramInt = i;
      if (this.GuJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GuJ);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnn localdnn = (dnn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localdnn.HBz = locala.NPN.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localdnn.sign = locala.NPN.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localdnn.oIu = locala.NPN.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localdnn.HBA = locala.NPN.zc();
          AppMethodBeat.o(91717);
          return 0;
        }
        localdnn.GuJ = locala.NPN.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnn
 * JD-Core Version:    0.7.0.1
 */