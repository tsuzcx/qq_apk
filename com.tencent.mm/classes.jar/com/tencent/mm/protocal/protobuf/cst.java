package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cst
  extends com.tencent.mm.bx.a
{
  public String GUr;
  public String HkZ;
  public String Hla;
  public String Hlb;
  public String nEt;
  public String qeh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEt != null) {
        paramVarArgs.d(1, this.nEt);
      }
      if (this.HkZ != null) {
        paramVarArgs.d(2, this.HkZ);
      }
      if (this.GUr != null) {
        paramVarArgs.d(3, this.GUr);
      }
      if (this.Hla != null) {
        paramVarArgs.d(4, this.Hla);
      }
      if (this.qeh != null) {
        paramVarArgs.d(5, this.qeh);
      }
      if (this.Hlb != null) {
        paramVarArgs.d(6, this.Hlb);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEt == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.nEt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HkZ);
      }
      i = paramInt;
      if (this.GUr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GUr);
      }
      paramInt = i;
      if (this.Hla != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hla);
      }
      i = paramInt;
      if (this.qeh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qeh);
      }
      paramInt = i;
      if (this.Hlb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hlb);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cst localcst = (cst)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localcst.nEt = locala.NPN.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localcst.HkZ = locala.NPN.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localcst.GUr = locala.NPN.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localcst.Hla = locala.NPN.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localcst.qeh = locala.NPN.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localcst.Hlb = locala.NPN.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cst
 * JD-Core Version:    0.7.0.1
 */