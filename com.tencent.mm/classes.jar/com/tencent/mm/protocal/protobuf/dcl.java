package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcl
  extends com.tencent.mm.bx.a
{
  public String DqD;
  public String EtR;
  public int EtS;
  public String nCa;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EtR != null) {
        paramVarArgs.d(4, this.EtR);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      if (this.nCa != null) {
        paramVarArgs.d(6, this.nCa);
      }
      paramVarArgs.aR(7, this.EtS);
      if (this.DqD != null) {
        paramVarArgs.d(8, this.DqD);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EtR == null) {
        break label446;
      }
    }
    label446:
    for (int i = f.a.a.b.b.a.e(4, this.EtR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sign);
      }
      i = paramInt;
      if (this.nCa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nCa);
      }
      i += f.a.a.b.b.a.bA(7, this.EtS);
      paramInt = i;
      if (this.DqD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DqD);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcl localdcl = (dcl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localdcl.EtR = locala.KhF.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localdcl.sign = locala.KhF.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localdcl.nCa = locala.KhF.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localdcl.EtS = locala.KhF.xS();
          AppMethodBeat.o(91717);
          return 0;
        }
        localdcl.DqD = locala.KhF.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcl
 * JD-Core Version:    0.7.0.1
 */