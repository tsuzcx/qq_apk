package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class drk
  extends com.tencent.mm.bw.a
{
  public long Exg;
  public long FOh;
  public int FZa;
  public int FZb;
  public int FZc;
  public int FZd;
  public b FZe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FOh);
      paramVarArgs.aO(2, this.Exg);
      paramVarArgs.aR(3, this.FZa);
      paramVarArgs.aR(4, this.FZb);
      paramVarArgs.aR(5, this.FZc);
      paramVarArgs.aR(6, this.FZd);
      if (this.FZe != null) {
        paramVarArgs.c(7, this.FZe);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FOh) + 0 + f.a.a.b.b.a.p(2, this.Exg) + f.a.a.b.b.a.bx(3, this.FZa) + f.a.a.b.b.a.bx(4, this.FZb) + f.a.a.b.b.a.bx(5, this.FZc) + f.a.a.b.b.a.bx(6, this.FZd);
      paramInt = i;
      if (this.FZe != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.FZe);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drk localdrk = (drk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localdrk.FOh = locala.LVo.xG();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localdrk.Exg = locala.LVo.xG();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localdrk.FZa = locala.LVo.xF();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localdrk.FZb = locala.LVo.xF();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localdrk.FZc = locala.LVo.xF();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localdrk.FZd = locala.LVo.xF();
        AppMethodBeat.o(125501);
        return 0;
      }
      localdrk.FZe = locala.LVo.gfk();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drk
 * JD-Core Version:    0.7.0.1
 */