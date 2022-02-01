package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxm
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public String ZQp;
  public String abVc;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257993);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abVc != null) {
        paramVarArgs.g(1, this.abVc);
      }
      if (this.ADE != null) {
        paramVarArgs.g(2, this.ADE);
      }
      if (this.ZQp != null) {
        paramVarArgs.g(3, this.ZQp);
      }
      paramVarArgs.bS(4, this.scene);
      AppMethodBeat.o(257993);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abVc == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.abVc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ADE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ADE);
      }
      i = paramInt;
      if (this.ZQp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZQp);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.scene);
      AppMethodBeat.o(257993);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257993);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fxm localfxm = (fxm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257993);
          return -1;
        case 1: 
          localfxm.abVc = locala.ajGk.readString();
          AppMethodBeat.o(257993);
          return 0;
        case 2: 
          localfxm.ADE = locala.ajGk.readString();
          AppMethodBeat.o(257993);
          return 0;
        case 3: 
          localfxm.ZQp = locala.ajGk.readString();
          AppMethodBeat.o(257993);
          return 0;
        }
        localfxm.scene = locala.ajGk.aar();
        AppMethodBeat.o(257993);
        return 0;
      }
      AppMethodBeat.o(257993);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxm
 * JD-Core Version:    0.7.0.1
 */