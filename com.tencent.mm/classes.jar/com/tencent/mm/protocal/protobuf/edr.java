package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edr
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String Fvn;
  public int GUe;
  public int HPd;
  public int nDi;
  public int nEf;
  public String uki;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uki != null) {
        paramVarArgs.d(1, this.uki);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.nDi);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.GUe);
      if (this.Fvn != null) {
        paramVarArgs.d(6, this.Fvn);
      }
      paramVarArgs.aS(7, this.HPd);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uki == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = f.a.a.b.b.a.e(1, this.uki) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.nDi) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.GUe);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvn);
      }
      i = f.a.a.b.b.a.bz(7, this.HPd);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edr localedr = (edr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localedr.uki = locala.NPN.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localedr.nEf = locala.NPN.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localedr.nDi = locala.NPN.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localedr.CreateTime = locala.NPN.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localedr.GUe = locala.NPN.zc();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localedr.Fvn = locala.NPN.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localedr.HPd = locala.NPN.zc();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edr
 * JD-Core Version:    0.7.0.1
 */