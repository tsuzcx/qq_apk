package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ec
  extends com.tencent.mm.bx.a
{
  public int Cyr;
  public String dlB;
  public String hea;
  public String lpA;
  public String lpw;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.hea != null) {
        paramVarArgs.d(2, this.hea);
      }
      if (this.lpw != null) {
        paramVarArgs.d(3, this.lpw);
      }
      if (this.dlB != null) {
        paramVarArgs.d(4, this.dlB);
      }
      if (this.lpA != null) {
        paramVarArgs.d(5, this.lpA);
      }
      paramVarArgs.aR(6, this.position);
      paramVarArgs.aR(7, this.Cyr);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hea != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hea);
      }
      i = paramInt;
      if (this.lpw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.lpw);
      }
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlB);
      }
      i = paramInt;
      if (this.lpA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.lpA);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.position);
      int j = f.a.a.b.b.a.bA(7, this.Cyr);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ec localec = (ec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localec.username = locala.KhF.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localec.hea = locala.KhF.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localec.lpw = locala.KhF.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localec.dlB = locala.KhF.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localec.lpA = locala.KhF.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localec.position = locala.KhF.xS();
          AppMethodBeat.o(50080);
          return 0;
        }
        localec.Cyr = locala.KhF.xS();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ec
 * JD-Core Version:    0.7.0.1
 */