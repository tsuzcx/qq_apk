package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxv
  extends com.tencent.mm.bx.a
{
  public int Cyr;
  public int DUo;
  public String dlB;
  public String hea;
  public String lpA;
  public String lpv;
  public String lpw;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.lpv != null) {
        paramVarArgs.d(2, this.lpv);
      }
      if (this.hea != null) {
        paramVarArgs.d(3, this.hea);
      }
      if (this.lpw != null) {
        paramVarArgs.d(4, this.lpw);
      }
      if (this.dlB != null) {
        paramVarArgs.d(5, this.dlB);
      }
      if (this.lpA != null) {
        paramVarArgs.d(6, this.lpA);
      }
      paramVarArgs.aR(7, this.position);
      paramVarArgs.aR(8, this.DUo);
      paramVarArgs.aR(9, this.Cyr);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lpv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.lpv);
      }
      i = paramInt;
      if (this.hea != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hea);
      }
      paramInt = i;
      if (this.lpw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lpw);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dlB);
      }
      paramInt = i;
      if (this.lpA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.lpA);
      }
      i = f.a.a.b.b.a.bA(7, this.position);
      int j = f.a.a.b.b.a.bA(8, this.DUo);
      int k = f.a.a.b.b.a.bA(9, this.Cyr);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxv localbxv = (bxv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localbxv.username = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localbxv.lpv = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localbxv.hea = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localbxv.lpw = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localbxv.dlB = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localbxv.lpA = locala.KhF.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localbxv.position = locala.KhF.xS();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localbxv.DUo = locala.KhF.xS();
          AppMethodBeat.o(50096);
          return 0;
        }
        localbxv.Cyr = locala.KhF.xS();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxv
 * JD-Core Version:    0.7.0.1
 */