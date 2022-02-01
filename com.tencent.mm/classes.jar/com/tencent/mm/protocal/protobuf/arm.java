package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arm
  extends com.tencent.mm.bw.a
{
  public long LCZ;
  public String dNI;
  public String icon;
  public String link;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.icon != null) {
        paramVarArgs.e(2, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.link != null) {
        paramVarArgs.e(4, this.link);
      }
      paramVarArgs.bb(5, this.LCZ);
      AppMethodBeat.o(209394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.icon);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.link);
      }
      i = g.a.a.b.b.a.r(5, this.LCZ);
      AppMethodBeat.o(209394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209394);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        arm localarm = (arm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209394);
          return -1;
        case 1: 
          localarm.dNI = locala.UbS.readString();
          AppMethodBeat.o(209394);
          return 0;
        case 2: 
          localarm.icon = locala.UbS.readString();
          AppMethodBeat.o(209394);
          return 0;
        case 3: 
          localarm.title = locala.UbS.readString();
          AppMethodBeat.o(209394);
          return 0;
        case 4: 
          localarm.link = locala.UbS.readString();
          AppMethodBeat.o(209394);
          return 0;
        }
        localarm.LCZ = locala.UbS.zl();
        AppMethodBeat.o(209394);
        return 0;
      }
      AppMethodBeat.o(209394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arm
 * JD-Core Version:    0.7.0.1
 */