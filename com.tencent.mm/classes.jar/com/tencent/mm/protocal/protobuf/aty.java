package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aty
  extends com.tencent.mm.bv.a
{
  public String nickname;
  public String oiD;
  public String username;
  public long xiM;
  public long xiN;
  public int xiO;
  public String xiP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56842);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xiM);
      paramVarArgs.am(2, this.xiN);
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.oiD != null) {
        paramVarArgs.e(4, this.oiD);
      }
      paramVarArgs.aO(5, this.xiO);
      if (this.username != null) {
        paramVarArgs.e(6, this.username);
      }
      if (this.xiP != null) {
        paramVarArgs.e(7, this.xiP);
      }
      AppMethodBeat.o(56842);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.xiM) + 0 + e.a.a.b.b.a.p(2, this.xiN);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nickname);
      }
      i = paramInt;
      if (this.oiD != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.oiD);
      }
      i += e.a.a.b.b.a.bl(5, this.xiO);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.username);
      }
      i = paramInt;
      if (this.xiP != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xiP);
      }
      AppMethodBeat.o(56842);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56842);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aty localaty = (aty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56842);
        return -1;
      case 1: 
        localaty.xiM = locala.CLY.sm();
        AppMethodBeat.o(56842);
        return 0;
      case 2: 
        localaty.xiN = locala.CLY.sm();
        AppMethodBeat.o(56842);
        return 0;
      case 3: 
        localaty.nickname = locala.CLY.readString();
        AppMethodBeat.o(56842);
        return 0;
      case 4: 
        localaty.oiD = locala.CLY.readString();
        AppMethodBeat.o(56842);
        return 0;
      case 5: 
        localaty.xiO = locala.CLY.sl();
        AppMethodBeat.o(56842);
        return 0;
      case 6: 
        localaty.username = locala.CLY.readString();
        AppMethodBeat.o(56842);
        return 0;
      }
      localaty.xiP = locala.CLY.readString();
      AppMethodBeat.o(56842);
      return 0;
    }
    AppMethodBeat.o(56842);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aty
 * JD-Core Version:    0.7.0.1
 */