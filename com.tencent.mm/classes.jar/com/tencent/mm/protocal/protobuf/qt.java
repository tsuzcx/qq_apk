package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qt
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public String KXB;
  public String Url;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXA != null) {
        paramVarArgs.e(1, this.KXA);
      }
      if (this.KXB != null) {
        paramVarArgs.e(2, this.KXB);
      }
      if (this.Url != null) {
        paramVarArgs.e(3, this.Url);
      }
      paramVarArgs.aM(4, this.oUv);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXA == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.KXA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KXB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KXB);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Url);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.oUv);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qt localqt = (qt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localqt.KXA = locala.UbS.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localqt.KXB = locala.UbS.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localqt.Url = locala.UbS.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localqt.oUv = locala.UbS.zi();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qt
 * JD-Core Version:    0.7.0.1
 */