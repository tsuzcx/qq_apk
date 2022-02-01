package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public String MFL;
  public long MFM;
  public String nickname;
  public int type;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243775);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.ueX != null) {
        paramVarArgs.f(2, this.ueX);
      }
      if (this.MFL != null) {
        paramVarArgs.f(3, this.MFL);
      }
      paramVarArgs.aY(4, this.type);
      paramVarArgs.aY(5, this.ChC);
      paramVarArgs.bm(6, this.MFM);
      AppMethodBeat.o(243775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label474;
      }
    }
    label474:
    for (int i = g.a.a.b.b.a.g(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ueX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ueX);
      }
      i = paramInt;
      if (this.MFL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MFL);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.type);
      int j = g.a.a.b.b.a.bM(5, this.ChC);
      int k = g.a.a.b.b.a.p(6, this.MFM);
      AppMethodBeat.o(243775);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243775);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243775);
          return -1;
        case 1: 
          localak.nickname = locala.abFh.readString();
          AppMethodBeat.o(243775);
          return 0;
        case 2: 
          localak.ueX = locala.abFh.readString();
          AppMethodBeat.o(243775);
          return 0;
        case 3: 
          localak.MFL = locala.abFh.readString();
          AppMethodBeat.o(243775);
          return 0;
        case 4: 
          localak.type = locala.abFh.AK();
          AppMethodBeat.o(243775);
          return 0;
        case 5: 
          localak.ChC = locala.abFh.AK();
          AppMethodBeat.o(243775);
          return 0;
        }
        localak.MFM = locala.abFh.AN();
        AppMethodBeat.o(243775);
        return 0;
      }
      AppMethodBeat.o(243775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ak
 * JD-Core Version:    0.7.0.1
 */