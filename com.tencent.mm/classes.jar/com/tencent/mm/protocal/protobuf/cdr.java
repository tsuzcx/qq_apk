package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdr
  extends com.tencent.mm.bx.a
{
  public String FIk;
  public int GXB;
  public int GXC;
  public String GXD;
  public int GXE;
  public int GXF;
  public long GXG;
  public int GXK;
  public String hzB;
  public int owy;
  public int type;
  public int udA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIk != null) {
        paramVarArgs.d(1, this.FIk);
      }
      paramVarArgs.aS(2, this.GXB);
      paramVarArgs.aS(3, this.udA);
      paramVarArgs.aS(4, this.GXC);
      paramVarArgs.aS(5, this.owy);
      paramVarArgs.aS(6, this.type);
      if (this.hzB != null) {
        paramVarArgs.d(7, this.hzB);
      }
      if (this.GXD != null) {
        paramVarArgs.d(8, this.GXD);
      }
      paramVarArgs.aS(9, this.GXE);
      paramVarArgs.aS(10, this.GXF);
      paramVarArgs.aS(11, this.GXK);
      paramVarArgs.aY(12, this.GXG);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIk == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = f.a.a.b.b.a.e(1, this.FIk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GXB) + f.a.a.b.b.a.bz(3, this.udA) + f.a.a.b.b.a.bz(4, this.GXC) + f.a.a.b.b.a.bz(5, this.owy) + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hzB);
      }
      i = paramInt;
      if (this.GXD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GXD);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.GXE);
      int j = f.a.a.b.b.a.bz(10, this.GXF);
      int k = f.a.a.b.b.a.bz(11, this.GXK);
      int m = f.a.a.b.b.a.p(12, this.GXG);
      AppMethodBeat.o(6416);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdr localcdr = (cdr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localcdr.FIk = locala.NPN.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localcdr.GXB = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localcdr.udA = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localcdr.GXC = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localcdr.owy = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localcdr.type = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localcdr.hzB = locala.NPN.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localcdr.GXD = locala.NPN.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 9: 
          localcdr.GXE = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 10: 
          localcdr.GXF = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        case 11: 
          localcdr.GXK = locala.NPN.zc();
          AppMethodBeat.o(6416);
          return 0;
        }
        localcdr.GXG = locala.NPN.zd();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdr
 * JD-Core Version:    0.7.0.1
 */