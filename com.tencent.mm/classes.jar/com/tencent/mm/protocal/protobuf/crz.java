package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class crz
  extends com.tencent.mm.bx.a
{
  public String FKK;
  public String FxN;
  public b GzP;
  public b GzQ;
  public String Hkv;
  public b Hkw;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKK != null) {
        paramVarArgs.d(1, this.FKK);
      }
      if (this.Hkv != null) {
        paramVarArgs.d(2, this.Hkv);
      }
      if (this.FxN != null) {
        paramVarArgs.d(3, this.FxN);
      }
      if (this.GzQ != null) {
        paramVarArgs.c(4, this.GzQ);
      }
      if (this.GzP != null) {
        paramVarArgs.c(5, this.GzP);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.Hkw != null) {
        paramVarArgs.c(7, this.Hkw);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKK == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.FKK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hkv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hkv);
      }
      i = paramInt;
      if (this.FxN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FxN);
      }
      paramInt = i;
      if (this.GzQ != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GzQ);
      }
      i = paramInt;
      if (this.GzP != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.GzP);
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.Hkw != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Hkw);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crz localcrz = (crz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localcrz.FKK = locala.NPN.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localcrz.Hkv = locala.NPN.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localcrz.FxN = locala.NPN.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localcrz.GzQ = locala.NPN.gxI();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localcrz.GzP = locala.NPN.gxI();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localcrz.Scene = locala.NPN.zc();
          AppMethodBeat.o(104831);
          return 0;
        }
        localcrz.Hkw = locala.NPN.gxI();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crz
 * JD-Core Version:    0.7.0.1
 */