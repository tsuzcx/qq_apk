package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckz
  extends com.tencent.mm.bx.a
{
  public String CIj;
  public String CNU;
  public String CzQ;
  public String CzR;
  public String Hem;
  public String dxD;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      paramVarArgs.aS(2, this.type);
      if (this.CNU != null) {
        paramVarArgs.d(3, this.CNU);
      }
      if (this.CzQ != null) {
        paramVarArgs.d(4, this.CzQ);
      }
      if (this.CzR != null) {
        paramVarArgs.d(5, this.CzR);
      }
      if (this.Hem != null) {
        paramVarArgs.d(6, this.Hem);
      }
      if (this.CIj != null) {
        paramVarArgs.d(7, this.CIj);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.dxD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CNU);
      }
      i = paramInt;
      if (this.CzQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CzQ);
      }
      paramInt = i;
      if (this.CzR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CzR);
      }
      i = paramInt;
      if (this.Hem != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hem);
      }
      paramInt = i;
      if (this.CIj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CIj);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckz localckz = (ckz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localckz.dxD = locala.NPN.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localckz.type = locala.NPN.zc();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localckz.CNU = locala.NPN.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localckz.CzQ = locala.NPN.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localckz.CzR = locala.NPN.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localckz.Hem = locala.NPN.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localckz.CIj = locala.NPN.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */