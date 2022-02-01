package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cir
  extends com.tencent.mm.bx.a
{
  public int FCp;
  public String HcA;
  public String HcB;
  public String HcC;
  public String Hcx;
  public String Hcy;
  public String Hcz;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hcx != null) {
        paramVarArgs.d(1, this.Hcx);
      }
      paramVarArgs.aS(2, this.nDG);
      if (this.Hcy != null) {
        paramVarArgs.d(3, this.Hcy);
      }
      if (this.Hcz != null) {
        paramVarArgs.d(4, this.Hcz);
      }
      if (this.HcA != null) {
        paramVarArgs.d(5, this.HcA);
      }
      paramVarArgs.aS(6, this.FCp);
      if (this.HcB != null) {
        paramVarArgs.d(7, this.HcB);
      }
      if (this.HcC != null) {
        paramVarArgs.d(8, this.HcC);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hcx == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hcx) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDG);
      paramInt = i;
      if (this.Hcy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hcy);
      }
      i = paramInt;
      if (this.Hcz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hcz);
      }
      paramInt = i;
      if (this.HcA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HcA);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FCp);
      paramInt = i;
      if (this.HcB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HcB);
      }
      i = paramInt;
      if (this.HcC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HcC);
      }
      AppMethodBeat.o(91577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cir localcir = (cir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localcir.Hcx = locala.NPN.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localcir.nDG = locala.NPN.zc();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localcir.Hcy = locala.NPN.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localcir.Hcz = locala.NPN.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localcir.HcA = locala.NPN.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localcir.FCp = locala.NPN.zc();
          AppMethodBeat.o(91577);
          return 0;
        case 7: 
          localcir.HcB = locala.NPN.readString();
          AppMethodBeat.o(91577);
          return 0;
        }
        localcir.HcC = locala.NPN.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */