package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mz
  extends com.tencent.mm.bx.a
{
  public String FGU;
  public String FGV;
  public int FGW;
  public int FGX;
  public String FGY;
  public String FGZ;
  public int FHa;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGU != null) {
        paramVarArgs.d(1, this.FGU);
      }
      paramVarArgs.aS(2, this.type);
      if (this.FGV != null) {
        paramVarArgs.d(3, this.FGV);
      }
      if (this.name != null) {
        paramVarArgs.d(4, this.name);
      }
      paramVarArgs.aS(5, this.ver);
      paramVarArgs.aS(6, this.FGW);
      paramVarArgs.aS(7, this.FGX);
      if (this.FGY != null) {
        paramVarArgs.d(8, this.FGY);
      }
      if (this.FGZ != null) {
        paramVarArgs.d(9, this.FGZ);
      }
      paramVarArgs.aS(10, this.FHa);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGU == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.b.b.a.e(1, this.FGU) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.FGV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FGV);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.name);
      }
      i = i + f.a.a.b.b.a.bz(5, this.ver) + f.a.a.b.b.a.bz(6, this.FGW) + f.a.a.b.b.a.bz(7, this.FGX);
      paramInt = i;
      if (this.FGY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FGY);
      }
      i = paramInt;
      if (this.FGZ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FGZ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FHa);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mz localmz = (mz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localmz.FGU = locala.NPN.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localmz.type = locala.NPN.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localmz.FGV = locala.NPN.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localmz.name = locala.NPN.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localmz.ver = locala.NPN.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localmz.FGW = locala.NPN.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localmz.FGX = locala.NPN.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localmz.FGY = locala.NPN.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localmz.FGZ = locala.NPN.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localmz.FHa = locala.NPN.zc();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mz
 * JD-Core Version:    0.7.0.1
 */