package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtv
  extends com.tencent.mm.bx.a
{
  public String desc;
  public int id;
  public String kzW;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.kzW != null) {
        paramVarArgs.d(3, this.kzW);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      AppMethodBeat.o(123672);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.kzW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kzW);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.desc);
      }
      AppMethodBeat.o(123672);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtv localdtv = (dtv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123672);
        return -1;
      case 1: 
        localdtv.id = locala.NPN.zc();
        AppMethodBeat.o(123672);
        return 0;
      case 2: 
        localdtv.nickname = locala.NPN.readString();
        AppMethodBeat.o(123672);
        return 0;
      case 3: 
        localdtv.kzW = locala.NPN.readString();
        AppMethodBeat.o(123672);
        return 0;
      }
      localdtv.desc = locala.NPN.readString();
      AppMethodBeat.o(123672);
      return 0;
    }
    AppMethodBeat.o(123672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtv
 * JD-Core Version:    0.7.0.1
 */