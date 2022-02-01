package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eor
  extends com.tencent.mm.bw.a
{
  public String desc;
  public int id;
  public String lHM;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123672);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.lHM != null) {
        paramVarArgs.e(3, this.lHM);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      AppMethodBeat.o(123672);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.lHM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.lHM);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.desc);
      }
      AppMethodBeat.o(123672);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123672);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eor localeor = (eor)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123672);
        return -1;
      case 1: 
        localeor.id = locala.UbS.zi();
        AppMethodBeat.o(123672);
        return 0;
      case 2: 
        localeor.nickname = locala.UbS.readString();
        AppMethodBeat.o(123672);
        return 0;
      case 3: 
        localeor.lHM = locala.UbS.readString();
        AppMethodBeat.o(123672);
        return 0;
      }
      localeor.desc = locala.UbS.readString();
      AppMethodBeat.o(123672);
      return 0;
    }
    AppMethodBeat.o(123672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eor
 * JD-Core Version:    0.7.0.1
 */