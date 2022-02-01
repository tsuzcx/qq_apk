package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cai
  extends com.tencent.mm.bw.a
{
  public int MfA;
  public String MfB;
  public long Mfy;
  public long Mfz;
  public String nickname;
  public String username;
  public String yPH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Mfy);
      paramVarArgs.bb(2, this.Mfz);
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.yPH != null) {
        paramVarArgs.e(4, this.yPH);
      }
      paramVarArgs.aM(5, this.MfA);
      if (this.username != null) {
        paramVarArgs.e(6, this.username);
      }
      if (this.MfB != null) {
        paramVarArgs.e(7, this.MfB);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Mfy) + 0 + g.a.a.b.b.a.r(2, this.Mfz);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nickname);
      }
      i = paramInt;
      if (this.yPH != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yPH);
      }
      i += g.a.a.b.b.a.bu(5, this.MfA);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.username);
      }
      i = paramInt;
      if (this.MfB != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MfB);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cai localcai = (cai)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localcai.Mfy = locala.UbS.zl();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localcai.Mfz = locala.UbS.zl();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localcai.nickname = locala.UbS.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localcai.yPH = locala.UbS.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localcai.MfA = locala.UbS.zi();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localcai.username = locala.UbS.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localcai.MfB = locala.UbS.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cai
 * JD-Core Version:    0.7.0.1
 */