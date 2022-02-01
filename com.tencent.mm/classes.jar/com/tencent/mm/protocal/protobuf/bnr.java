package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnr
  extends com.tencent.mm.bw.a
{
  public int HaA;
  public String HaB;
  public long Hay;
  public long Haz;
  public String nickname;
  public String username;
  public String vvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Hay);
      paramVarArgs.aZ(2, this.Haz);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.vvt != null) {
        paramVarArgs.d(4, this.vvt);
      }
      paramVarArgs.aS(5, this.HaA);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      if (this.HaB != null) {
        paramVarArgs.d(7, this.HaB);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Hay) + 0 + f.a.a.b.b.a.p(2, this.Haz);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.vvt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vvt);
      }
      i += f.a.a.b.b.a.bz(5, this.HaA);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      i = paramInt;
      if (this.HaB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HaB);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnr localbnr = (bnr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localbnr.Hay = locala.OmT.zd();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localbnr.Haz = locala.OmT.zd();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localbnr.nickname = locala.OmT.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localbnr.vvt = locala.OmT.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localbnr.HaA = locala.OmT.zc();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localbnr.username = locala.OmT.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localbnr.HaB = locala.OmT.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnr
 * JD-Core Version:    0.7.0.1
 */