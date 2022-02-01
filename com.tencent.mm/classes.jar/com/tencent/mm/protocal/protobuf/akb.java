package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akb
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Gjr;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.Gjr != null) {
        paramVarArgs.d(3, this.Gjr);
      }
      AppMethodBeat.o(127471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AesKey);
      }
      i = paramInt;
      if (this.Gjr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gjr);
      }
      AppMethodBeat.o(127471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127471);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akb localakb = (akb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127471);
          return -1;
        case 1: 
          localakb.Md5 = locala.NPN.readString();
          AppMethodBeat.o(127471);
          return 0;
        case 2: 
          localakb.AesKey = locala.NPN.readString();
          AppMethodBeat.o(127471);
          return 0;
        }
        localakb.Gjr = locala.NPN.readString();
        AppMethodBeat.o(127471);
        return 0;
      }
      AppMethodBeat.o(127471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akb
 * JD-Core Version:    0.7.0.1
 */