package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rb
  extends com.tencent.mm.bx.a
{
  public int FKM;
  public String FNa;
  public String duW;
  public String nickname;
  public String username;
  public int version;
  public String vjo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.vjo != null) {
        paramVarArgs.d(3, this.vjo);
      }
      if (this.nickname != null) {
        paramVarArgs.d(4, this.nickname);
      }
      paramVarArgs.aS(5, this.FKM);
      if (this.FNa != null) {
        paramVarArgs.d(6, this.FNa);
      }
      paramVarArgs.aS(7, this.version);
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
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.vjo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vjo);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nickname);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FKM);
      paramInt = i;
      if (this.FNa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNa);
      }
      i = f.a.a.b.b.a.bz(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localrb.username = locala.NPN.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localrb.duW = locala.NPN.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localrb.vjo = locala.NPN.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localrb.nickname = locala.NPN.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localrb.FKM = locala.NPN.zc();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localrb.FNa = locala.NPN.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localrb.version = locala.NPN.zc();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */