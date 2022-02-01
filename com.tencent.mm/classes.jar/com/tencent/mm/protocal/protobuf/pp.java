package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pp
  extends com.tencent.mm.bx.a
{
  public int CLK;
  public String CNZ;
  public String dlB;
  public String nickname;
  public String sYq;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.sYq != null) {
        paramVarArgs.d(3, this.sYq);
      }
      if (this.nickname != null) {
        paramVarArgs.d(4, this.nickname);
      }
      paramVarArgs.aR(5, this.CLK);
      if (this.CNZ != null) {
        paramVarArgs.d(6, this.CNZ);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(56244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.sYq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sYq);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nickname);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CLK);
      paramInt = i;
      if (this.CNZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CNZ);
      }
      i = f.a.a.b.b.a.bA(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pp localpp = (pp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localpp.username = locala.KhF.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localpp.dlB = locala.KhF.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localpp.sYq = locala.KhF.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localpp.nickname = locala.KhF.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localpp.CLK = locala.KhF.xS();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localpp.CNZ = locala.KhF.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localpp.version = locala.KhF.xS();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pp
 * JD-Core Version:    0.7.0.1
 */