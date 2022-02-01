package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aot
  extends com.tencent.mm.bx.a
{
  public int Gnn;
  public long Gno;
  public String bVF;
  public String dul;
  public String hDQ;
  public int likeFlag;
  public long rHI;
  public int unreadFlag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bVF != null) {
        paramVarArgs.d(1, this.bVF);
      }
      if (this.hDQ != null) {
        paramVarArgs.d(2, this.hDQ);
      }
      paramVarArgs.aY(3, this.rHI);
      paramVarArgs.aS(4, this.likeFlag);
      paramVarArgs.aS(5, this.Gnn);
      if (this.dul != null) {
        paramVarArgs.d(6, this.dul);
      }
      paramVarArgs.aY(7, this.Gno);
      paramVarArgs.aS(8, this.unreadFlag);
      AppMethodBeat.o(209325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bVF == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.b.b.a.e(1, this.bVF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hDQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hDQ);
      }
      i = i + f.a.a.b.b.a.p(3, this.rHI) + f.a.a.b.b.a.bz(4, this.likeFlag) + f.a.a.b.b.a.bz(5, this.Gnn);
      paramInt = i;
      if (this.dul != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dul);
      }
      i = f.a.a.b.b.a.p(7, this.Gno);
      int j = f.a.a.b.b.a.bz(8, this.unreadFlag);
      AppMethodBeat.o(209325);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209325);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aot localaot = (aot)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209325);
          return -1;
        case 1: 
          localaot.bVF = locala.NPN.readString();
          AppMethodBeat.o(209325);
          return 0;
        case 2: 
          localaot.hDQ = locala.NPN.readString();
          AppMethodBeat.o(209325);
          return 0;
        case 3: 
          localaot.rHI = locala.NPN.zd();
          AppMethodBeat.o(209325);
          return 0;
        case 4: 
          localaot.likeFlag = locala.NPN.zc();
          AppMethodBeat.o(209325);
          return 0;
        case 5: 
          localaot.Gnn = locala.NPN.zc();
          AppMethodBeat.o(209325);
          return 0;
        case 6: 
          localaot.dul = locala.NPN.readString();
          AppMethodBeat.o(209325);
          return 0;
        case 7: 
          localaot.Gno = locala.NPN.zd();
          AppMethodBeat.o(209325);
          return 0;
        }
        localaot.unreadFlag = locala.NPN.zc();
        AppMethodBeat.o(209325);
        return 0;
      }
      AppMethodBeat.o(209325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aot
 * JD-Core Version:    0.7.0.1
 */