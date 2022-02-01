package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wn
  extends com.tencent.mm.bx.a
{
  public int CYF;
  public int CYG;
  public String dlB;
  public String lpA;
  public String lpv;
  public String lpw;
  public String lpx;
  public String lpy;
  public int lpz;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.lpv != null) {
        paramVarArgs.d(2, this.lpv);
      }
      paramVarArgs.aR(3, this.CYF);
      paramVarArgs.aR(4, this.CYG);
      if (this.lpw != null) {
        paramVarArgs.d(5, this.lpw);
      }
      if (this.dlB != null) {
        paramVarArgs.d(6, this.dlB);
      }
      if (this.lpx != null) {
        paramVarArgs.d(7, this.lpx);
      }
      if (this.lpy != null) {
        paramVarArgs.d(8, this.lpy);
      }
      paramVarArgs.aR(9, this.lpz);
      if (this.lpA != null) {
        paramVarArgs.d(10, this.lpA);
      }
      paramVarArgs.aR(11, this.position);
      AppMethodBeat.o(50083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lpv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.lpv);
      }
      i = i + f.a.a.b.b.a.bA(3, this.CYF) + f.a.a.b.b.a.bA(4, this.CYG);
      paramInt = i;
      if (this.lpw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lpw);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dlB);
      }
      paramInt = i;
      if (this.lpx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.lpx);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.lpy);
      }
      i += f.a.a.b.b.a.bA(9, this.lpz);
      paramInt = i;
      if (this.lpA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.lpA);
      }
      i = f.a.a.b.b.a.bA(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wn localwn = (wn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localwn.username = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localwn.lpv = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localwn.CYF = locala.KhF.xS();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localwn.CYG = locala.KhF.xS();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localwn.lpw = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localwn.dlB = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localwn.lpx = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localwn.lpy = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localwn.lpz = locala.KhF.xS();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localwn.lpA = locala.KhF.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localwn.position = locala.KhF.xS();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wn
 * JD-Core Version:    0.7.0.1
 */