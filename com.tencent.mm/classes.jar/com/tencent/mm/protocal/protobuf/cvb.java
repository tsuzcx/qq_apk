package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvb
  extends com.tencent.mm.bx.a
{
  public int FKM;
  public String GDK;
  public int GDN;
  public String duW;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.GDK != null) {
        paramVarArgs.d(3, this.GDK);
      }
      paramVarArgs.aS(4, this.GDN);
      paramVarArgs.aS(5, this.FKM);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.duW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.GDK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GDK);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GDN);
      int j = f.a.a.b.b.a.bz(5, this.FKM);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvb localcvb = (cvb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localcvb.duW = locala.NPN.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localcvb.username = locala.NPN.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localcvb.GDK = locala.NPN.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localcvb.GDN = locala.NPN.zc();
          AppMethodBeat.o(175247);
          return 0;
        }
        localcvb.FKM = locala.NPN.zc();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvb
 * JD-Core Version:    0.7.0.1
 */