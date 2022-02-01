package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rd
  extends com.tencent.mm.bw.a
{
  public int Gdl;
  public String Gfz;
  public String dwb;
  public String nickname;
  public String username;
  public int version;
  public String vvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.vvt != null) {
        paramVarArgs.d(3, this.vvt);
      }
      if (this.nickname != null) {
        paramVarArgs.d(4, this.nickname);
      }
      paramVarArgs.aS(5, this.Gdl);
      if (this.Gfz != null) {
        paramVarArgs.d(6, this.Gfz);
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
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.vvt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vvt);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nickname);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gdl);
      paramInt = i;
      if (this.Gfz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gfz);
      }
      i = f.a.a.b.b.a.bz(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localrd.username = locala.OmT.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localrd.dwb = locala.OmT.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localrd.vvt = locala.OmT.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localrd.nickname = locala.OmT.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localrd.Gdl = locala.OmT.zc();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localrd.Gfz = locala.OmT.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localrd.version = locala.OmT.zc();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */