package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgs
  extends com.tencent.mm.bv.a
{
  public String desc;
  public int id;
  public String nickname;
  public String xeE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10226);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.xeE != null) {
        paramVarArgs.e(3, this.xeE);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      AppMethodBeat.o(10226);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.xeE != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xeE);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.desc);
      }
      AppMethodBeat.o(10226);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(10226);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bgs localbgs = (bgs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(10226);
        return -1;
      case 1: 
        localbgs.id = locala.CLY.sl();
        AppMethodBeat.o(10226);
        return 0;
      case 2: 
        localbgs.nickname = locala.CLY.readString();
        AppMethodBeat.o(10226);
        return 0;
      case 3: 
        localbgs.xeE = locala.CLY.readString();
        AppMethodBeat.o(10226);
        return 0;
      }
      localbgs.desc = locala.CLY.readString();
      AppMethodBeat.o(10226);
      return 0;
    }
    AppMethodBeat.o(10226);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */