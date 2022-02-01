package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bms
  extends com.tencent.mm.bx.a
{
  public String Gcm;
  public int Gcn;
  public String uJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gcm != null) {
        paramVarArgs.d(1, this.Gcm);
      }
      paramVarArgs.aS(2, this.Gcn);
      if (this.uJK != null) {
        paramVarArgs.d(3, this.uJK);
      }
      AppMethodBeat.o(147769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gcm == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gcm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gcn);
      paramInt = i;
      if (this.uJK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uJK);
      }
      AppMethodBeat.o(147769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147769);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bms localbms = (bms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147769);
          return -1;
        case 1: 
          localbms.Gcm = locala.NPN.readString();
          AppMethodBeat.o(147769);
          return 0;
        case 2: 
          localbms.Gcn = locala.NPN.zc();
          AppMethodBeat.o(147769);
          return 0;
        }
        localbms.uJK = locala.NPN.readString();
        AppMethodBeat.o(147769);
        return 0;
      }
      AppMethodBeat.o(147769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bms
 * JD-Core Version:    0.7.0.1
 */