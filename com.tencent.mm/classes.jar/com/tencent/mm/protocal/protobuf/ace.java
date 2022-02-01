package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ace
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public int KJL;
  public int LmJ;
  public String LmK;
  public int LmL;
  public int LmM;
  public int LmN;
  public int LmO;
  public String content;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.openid != null) {
        paramVarArgs.e(3, this.openid);
      }
      paramVarArgs.aM(4, this.Gaz);
      paramVarArgs.aM(5, this.KJL);
      paramVarArgs.aM(6, this.LmJ);
      if (this.LmK != null) {
        paramVarArgs.e(7, this.LmK);
      }
      paramVarArgs.aM(8, this.LmL);
      paramVarArgs.aM(9, this.LmM);
      paramVarArgs.aM(10, this.LmN);
      paramVarArgs.aM(11, this.LmO);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.b.b.a.f(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.openid != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.openid);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Gaz) + g.a.a.b.b.a.bu(5, this.KJL) + g.a.a.b.b.a.bu(6, this.LmJ);
      paramInt = i;
      if (this.LmK != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LmK);
      }
      i = g.a.a.b.b.a.bu(8, this.LmL);
      int j = g.a.a.b.b.a.bu(9, this.LmM);
      int k = g.a.a.b.b.a.bu(10, this.LmN);
      int m = g.a.a.b.b.a.bu(11, this.LmO);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ace localace = (ace)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localace.content = locala.UbS.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localace.openid = locala.UbS.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localace.Gaz = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localace.KJL = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localace.LmJ = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localace.LmK = locala.UbS.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localace.LmL = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localace.LmM = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localace.LmN = locala.UbS.zi();
          AppMethodBeat.o(103206);
          return 0;
        }
        localace.LmO = locala.UbS.zi();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ace
 * JD-Core Version:    0.7.0.1
 */