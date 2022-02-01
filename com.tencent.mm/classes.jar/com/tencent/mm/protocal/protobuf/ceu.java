package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ceu
  extends com.tencent.mm.bx.a
{
  public int GYQ;
  public String GYR;
  public String GYS;
  public String Gby;
  public String Gbz;
  public String appId;
  public String bVF;
  public String fVj;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.bVF != null) {
        paramVarArgs.d(2, this.bVF);
      }
      if (this.fVj != null) {
        paramVarArgs.d(3, this.fVj);
      }
      if (this.Gby != null) {
        paramVarArgs.d(4, this.Gby);
      }
      if (this.Gbz != null) {
        paramVarArgs.d(5, this.Gbz);
      }
      paramVarArgs.aS(6, this.GYQ);
      if (this.appId != null) {
        paramVarArgs.d(7, this.appId);
      }
      if (this.GYR != null) {
        paramVarArgs.d(8, this.GYR);
      }
      if (this.GYS != null) {
        paramVarArgs.d(9, this.GYS);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bVF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.bVF);
      }
      i = paramInt;
      if (this.fVj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVj);
      }
      paramInt = i;
      if (this.Gby != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gby);
      }
      i = paramInt;
      if (this.Gbz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gbz);
      }
      i += f.a.a.b.b.a.bz(6, this.GYQ);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.appId);
      }
      i = paramInt;
      if (this.GYR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GYR);
      }
      paramInt = i;
      if (this.GYS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYS);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ceu localceu = (ceu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localceu.userName = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localceu.bVF = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localceu.fVj = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localceu.Gby = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localceu.Gbz = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localceu.GYQ = locala.NPN.zc();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localceu.appId = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localceu.GYR = locala.NPN.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localceu.GYS = locala.NPN.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceu
 * JD-Core Version:    0.7.0.1
 */