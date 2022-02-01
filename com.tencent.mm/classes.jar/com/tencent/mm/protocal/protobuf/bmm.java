package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmm
  extends com.tencent.mm.bx.a
{
  public String FDu;
  public String GGR;
  public String GGS;
  public String Guj;
  public int Ret;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDu != null) {
        paramVarArgs.d(1, this.FDu);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.GGR != null) {
        paramVarArgs.d(3, this.GGR);
      }
      if (this.GGS != null) {
        paramVarArgs.d(4, this.GGS);
      }
      paramVarArgs.aS(5, this.Ret);
      if (this.nEt != null) {
        paramVarArgs.d(6, this.nEt);
      }
      if (this.Guj != null) {
        paramVarArgs.d(7, this.Guj);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDu == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.FDu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.GGR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GGR);
      }
      paramInt = i;
      if (this.GGS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GGS);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Ret);
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nEt);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Guj);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmm localbmm = (bmm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localbmm.FDu = locala.NPN.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localbmm.nDo = locala.NPN.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localbmm.GGR = locala.NPN.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localbmm.GGS = locala.NPN.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localbmm.Ret = locala.NPN.zc();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localbmm.nEt = locala.NPN.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localbmm.Guj = locala.NPN.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmm
 * JD-Core Version:    0.7.0.1
 */