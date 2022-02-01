package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amg
  extends com.tencent.mm.bw.a
{
  public String LuX;
  public String SmallImgUrl;
  public String UserName;
  public int oTW;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.LuX != null) {
        paramVarArgs.e(2, this.LuX);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.e(4, this.SmallImgUrl);
      }
      paramVarArgs.aM(5, this.oTW);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label449;
      }
    }
    label449:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LuX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LuX);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.SmallImgUrl);
      }
      i = g.a.a.b.b.a.bu(5, this.oTW);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amg localamg = (amg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localamg.UserName = locala.UbS.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localamg.LuX = locala.UbS.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localamg.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localamg.SmallImgUrl = locala.UbS.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localamg.oTW = locala.UbS.zi();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amg
 * JD-Core Version:    0.7.0.1
 */