package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class se
  extends com.tencent.mm.bw.a
{
  public int KXC;
  public String KZQ;
  public String dNI;
  public String nickname;
  public String username;
  public int version;
  public String yPH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.yPH != null) {
        paramVarArgs.e(3, this.yPH);
      }
      if (this.nickname != null) {
        paramVarArgs.e(4, this.nickname);
      }
      paramVarArgs.aM(5, this.KXC);
      if (this.KZQ != null) {
        paramVarArgs.e(6, this.KZQ);
      }
      paramVarArgs.aM(7, this.version);
      AppMethodBeat.o(56244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.yPH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yPH);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.nickname);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KXC);
      paramInt = i;
      if (this.KZQ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KZQ);
      }
      i = g.a.a.b.b.a.bu(7, this.version);
      AppMethodBeat.o(56244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(56244);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56244);
          return -1;
        case 1: 
          localse.username = locala.UbS.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 2: 
          localse.dNI = locala.UbS.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 3: 
          localse.yPH = locala.UbS.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 4: 
          localse.nickname = locala.UbS.readString();
          AppMethodBeat.o(56244);
          return 0;
        case 5: 
          localse.KXC = locala.UbS.zi();
          AppMethodBeat.o(56244);
          return 0;
        case 6: 
          localse.KZQ = locala.UbS.readString();
          AppMethodBeat.o(56244);
          return 0;
        }
        localse.version = locala.UbS.zi();
        AppMethodBeat.o(56244);
        return 0;
      }
      AppMethodBeat.o(56244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */