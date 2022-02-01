package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class axc
  extends com.tencent.mm.cd.a
{
  public int SJA;
  public int SJB;
  public int SJy;
  public String SJz;
  public String nickname;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.ueX != null) {
        paramVarArgs.f(2, this.ueX);
      }
      paramVarArgs.aY(3, this.SJy);
      if (this.SJz != null) {
        paramVarArgs.f(4, this.SJz);
      }
      paramVarArgs.aY(5, this.SJA);
      paramVarArgs.aY(6, this.SJB);
      AppMethodBeat.o(202404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.g(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueX != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ueX);
      }
      i += g.a.a.b.b.a.bM(3, this.SJy);
      paramInt = i;
      if (this.SJz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SJz);
      }
      i = g.a.a.b.b.a.bM(5, this.SJA);
      int j = g.a.a.b.b.a.bM(6, this.SJB);
      AppMethodBeat.o(202404);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202404);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axc localaxc = (axc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202404);
          return -1;
        case 1: 
          localaxc.nickname = locala.abFh.readString();
          AppMethodBeat.o(202404);
          return 0;
        case 2: 
          localaxc.ueX = locala.abFh.readString();
          AppMethodBeat.o(202404);
          return 0;
        case 3: 
          localaxc.SJy = locala.abFh.AK();
          AppMethodBeat.o(202404);
          return 0;
        case 4: 
          localaxc.SJz = locala.abFh.readString();
          AppMethodBeat.o(202404);
          return 0;
        case 5: 
          localaxc.SJA = locala.abFh.AK();
          AppMethodBeat.o(202404);
          return 0;
        }
        localaxc.SJB = locala.abFh.AK();
        AppMethodBeat.o(202404);
        return 0;
      }
      AppMethodBeat.o(202404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axc
 * JD-Core Version:    0.7.0.1
 */