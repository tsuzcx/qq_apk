package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmz
  extends com.tencent.mm.bx.a
{
  public long GGW;
  public long GGX;
  public int GGY;
  public String GGZ;
  public String nickname;
  public String username;
  public String vjo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GGW);
      paramVarArgs.aY(2, this.GGX);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.vjo != null) {
        paramVarArgs.d(4, this.vjo);
      }
      paramVarArgs.aS(5, this.GGY);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      if (this.GGZ != null) {
        paramVarArgs.d(7, this.GGZ);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GGW) + 0 + f.a.a.b.b.a.p(2, this.GGX);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.vjo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vjo);
      }
      i += f.a.a.b.b.a.bz(5, this.GGY);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      i = paramInt;
      if (this.GGZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GGZ);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bmz localbmz = (bmz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localbmz.GGW = locala.NPN.zd();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localbmz.GGX = locala.NPN.zd();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localbmz.nickname = locala.NPN.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localbmz.vjo = locala.NPN.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localbmz.GGY = locala.NPN.zc();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localbmz.username = locala.NPN.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localbmz.GGZ = locala.NPN.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmz
 * JD-Core Version:    0.7.0.1
 */