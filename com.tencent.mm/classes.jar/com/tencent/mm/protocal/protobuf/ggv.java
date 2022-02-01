package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggv
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IMg;
  public String YFJ;
  public int aaVx;
  public int acdh;
  public int vgN;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMg != null) {
        paramVarArgs.g(1, this.IMg);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.vgN);
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(5, this.aaVx);
      if (this.YFJ != null) {
        paramVarArgs.g(6, this.YFJ);
      }
      paramVarArgs.bS(7, this.acdh);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMg == null) {
        break label503;
      }
    }
    label503:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMg) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.vgN) + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(5, this.aaVx);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YFJ);
      }
      i = i.a.a.b.b.a.cJ(7, this.acdh);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggv localggv = (ggv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localggv.IMg = locala.ajGk.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localggv.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localggv.vgN = locala.ajGk.aar();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localggv.CreateTime = locala.ajGk.aar();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localggv.aaVx = locala.ajGk.aar();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localggv.YFJ = locala.ajGk.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localggv.acdh = locala.ajGk.aar();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggv
 * JD-Core Version:    0.7.0.1
 */