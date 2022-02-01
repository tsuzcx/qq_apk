package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int jTs;
  public int jTt;
  public int jTu;
  public long jTv;
  public long jTw;
  public String jTx;
  public String jTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.jTs);
      paramVarArgs.aM(2, this.jTt);
      paramVarArgs.aM(3, this.jTu);
      paramVarArgs.bb(4, this.jTv);
      paramVarArgs.bb(5, this.jTw);
      if (this.jTx != null) {
        paramVarArgs.e(6, this.jTx);
      }
      if (this.jTy != null) {
        paramVarArgs.e(7, this.jTy);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.jTs) + 0 + g.a.a.b.b.a.bu(2, this.jTt) + g.a.a.b.b.a.bu(3, this.jTu) + g.a.a.b.b.a.r(4, this.jTv) + g.a.a.b.b.a.r(5, this.jTw);
      paramInt = i;
      if (this.jTx != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jTx);
      }
      i = paramInt;
      if (this.jTy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.jTy);
      }
      AppMethodBeat.o(91323);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        localn.jTs = locala.UbS.zi();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        localn.jTt = locala.UbS.zi();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        localn.jTu = locala.UbS.zi();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        localn.jTv = locala.UbS.zl();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        localn.jTw = locala.UbS.zl();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        localn.jTx = locala.UbS.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      localn.jTy = locala.UbS.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */