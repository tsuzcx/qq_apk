package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efi
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public String HQD;
  public String HbR;
  public String IconUrl;
  public String gsT;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbR != null) {
        paramVarArgs.d(1, this.HbR);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.gsT != null) {
        paramVarArgs.d(4, this.gsT);
      }
      paramVarArgs.aS(5, this.FFN);
      if (this.HQD != null) {
        paramVarArgs.d(6, this.HQD);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbR == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.HbR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.gsT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gsT);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FFN);
      paramInt = i;
      if (this.HQD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HQD);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efi localefi = (efi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localefi.HbR = locala.NPN.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localefi.nDo = locala.NPN.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localefi.nEt = locala.NPN.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localefi.gsT = locala.NPN.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localefi.FFN = locala.NPN.zc();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localefi.HQD = locala.NPN.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localefi.IconUrl = locala.NPN.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efi
 * JD-Core Version:    0.7.0.1
 */