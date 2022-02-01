package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csh
  extends com.tencent.mm.bx.a
{
  public int HkD;
  public String hzA;
  public String hzB;
  public String hzC;
  public boolean hzD;
  public int hzE;
  public String hzr;
  public String hzs;
  public String hzt;
  public String hzu;
  public String hzv;
  public String hzw;
  public String hzx;
  public String hzy;
  public String hzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hzr != null) {
        paramVarArgs.d(1, this.hzr);
      }
      if (this.hzs != null) {
        paramVarArgs.d(2, this.hzs);
      }
      if (this.hzt != null) {
        paramVarArgs.d(3, this.hzt);
      }
      if (this.hzu != null) {
        paramVarArgs.d(4, this.hzu);
      }
      if (this.hzv != null) {
        paramVarArgs.d(5, this.hzv);
      }
      if (this.hzw != null) {
        paramVarArgs.d(6, this.hzw);
      }
      if (this.hzx != null) {
        paramVarArgs.d(7, this.hzx);
      }
      if (this.hzy != null) {
        paramVarArgs.d(8, this.hzy);
      }
      if (this.hzz != null) {
        paramVarArgs.d(9, this.hzz);
      }
      if (this.hzA != null) {
        paramVarArgs.d(10, this.hzA);
      }
      paramVarArgs.aS(11, this.HkD);
      if (this.hzB != null) {
        paramVarArgs.d(12, this.hzB);
      }
      if (this.hzC != null) {
        paramVarArgs.d(13, this.hzC);
      }
      paramVarArgs.bt(14, this.hzD);
      paramVarArgs.aS(15, this.hzE);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hzr == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.b.b.a.e(1, this.hzr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hzs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hzs);
      }
      i = paramInt;
      if (this.hzt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hzt);
      }
      paramInt = i;
      if (this.hzu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hzu);
      }
      i = paramInt;
      if (this.hzv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hzv);
      }
      paramInt = i;
      if (this.hzw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hzw);
      }
      i = paramInt;
      if (this.hzx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hzx);
      }
      paramInt = i;
      if (this.hzy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hzy);
      }
      i = paramInt;
      if (this.hzz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hzz);
      }
      paramInt = i;
      if (this.hzA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hzA);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HkD);
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hzB);
      }
      i = paramInt;
      if (this.hzC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hzC);
      }
      paramInt = f.a.a.b.b.a.alV(14);
      int j = f.a.a.b.b.a.bz(15, this.hzE);
      AppMethodBeat.o(169219);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csh localcsh = (csh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localcsh.hzr = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localcsh.hzs = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localcsh.hzt = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localcsh.hzu = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localcsh.hzv = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localcsh.hzw = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localcsh.hzx = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localcsh.hzy = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localcsh.hzz = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localcsh.hzA = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localcsh.HkD = locala.NPN.zc();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localcsh.hzB = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localcsh.hzC = locala.NPN.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localcsh.hzD = locala.NPN.grw();
          AppMethodBeat.o(169219);
          return 0;
        }
        localcsh.hzE = locala.NPN.zc();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csh
 * JD-Core Version:    0.7.0.1
 */