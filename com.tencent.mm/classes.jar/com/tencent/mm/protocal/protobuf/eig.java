package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eig
  extends com.tencent.mm.bw.a
{
  public String GaP;
  public String Nhw;
  public int Nhx;
  public String qcK;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nhw != null) {
        paramVarArgs.e(4, this.Nhw);
      }
      if (this.sign != null) {
        paramVarArgs.e(5, this.sign);
      }
      if (this.qcK != null) {
        paramVarArgs.e(6, this.qcK);
      }
      paramVarArgs.aM(7, this.Nhx);
      if (this.GaP != null) {
        paramVarArgs.e(8, this.GaP);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nhw == null) {
        break label446;
      }
    }
    label446:
    for (int i = g.a.a.b.b.a.f(4, this.Nhw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.sign);
      }
      i = paramInt;
      if (this.qcK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.qcK);
      }
      i += g.a.a.b.b.a.bu(7, this.Nhx);
      paramInt = i;
      if (this.GaP != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.GaP);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eig localeig = (eig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localeig.Nhw = locala.UbS.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localeig.sign = locala.UbS.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localeig.qcK = locala.UbS.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localeig.Nhx = locala.UbS.zi();
          AppMethodBeat.o(91717);
          return 0;
        }
        localeig.GaP = locala.UbS.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eig
 * JD-Core Version:    0.7.0.1
 */