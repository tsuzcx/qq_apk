package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class md
  extends com.tencent.mm.bx.a
{
  public String CIJ;
  public String CIK;
  public int CIL;
  public int CIM;
  public String CIN;
  public String CIO;
  public int CIP;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIJ != null) {
        paramVarArgs.d(1, this.CIJ);
      }
      paramVarArgs.aR(2, this.type);
      if (this.CIK != null) {
        paramVarArgs.d(3, this.CIK);
      }
      if (this.name != null) {
        paramVarArgs.d(4, this.name);
      }
      paramVarArgs.aR(5, this.ver);
      paramVarArgs.aR(6, this.CIL);
      paramVarArgs.aR(7, this.CIM);
      if (this.CIN != null) {
        paramVarArgs.d(8, this.CIN);
      }
      if (this.CIO != null) {
        paramVarArgs.d(9, this.CIO);
      }
      paramVarArgs.aR(10, this.CIP);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIJ == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.CIK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CIK);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.name);
      }
      i = i + f.a.a.b.b.a.bA(5, this.ver) + f.a.a.b.b.a.bA(6, this.CIL) + f.a.a.b.b.a.bA(7, this.CIM);
      paramInt = i;
      if (this.CIN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CIN);
      }
      i = paramInt;
      if (this.CIO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CIO);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.CIP);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localmd.CIJ = locala.KhF.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localmd.type = locala.KhF.xS();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localmd.CIK = locala.KhF.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localmd.name = locala.KhF.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localmd.ver = locala.KhF.xS();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localmd.CIL = locala.KhF.xS();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localmd.CIM = locala.KhF.xS();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localmd.CIN = locala.KhF.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localmd.CIO = locala.KhF.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localmd.CIP = locala.KhF.xS();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.md
 * JD-Core Version:    0.7.0.1
 */