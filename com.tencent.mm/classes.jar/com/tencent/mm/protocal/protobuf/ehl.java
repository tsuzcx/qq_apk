package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehl
  extends com.tencent.mm.bx.a
{
  public int FHr;
  public boolean HSf;
  public String nickname;
  public String vjo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHr);
      if (this.vjo != null) {
        paramVarArgs.d(2, this.vjo);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      paramVarArgs.bt(4, this.HSf);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FHr) + 0;
      paramInt = i;
      if (this.vjo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vjo);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(153328);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehl localehl = (ehl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localehl.FHr = locala.NPN.zc();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localehl.vjo = locala.NPN.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localehl.nickname = locala.NPN.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localehl.HSf = locala.NPN.grw();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehl
 * JD-Core Version:    0.7.0.1
 */