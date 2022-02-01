package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wb
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Eqt;
  public String Equ;
  public long Eqv;
  public int ndI;
  
  public wb()
  {
    AppMethodBeat.i(6401);
    this.Eqt = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      paramVarArgs.e(2, 1, this.Eqt);
      if (this.Equ != null) {
        paramVarArgs.d(3, this.Equ);
      }
      paramVarArgs.aO(4, this.Eqv);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ndI) + 0 + f.a.a.a.c(2, 1, this.Eqt);
      paramInt = i;
      if (this.Equ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Equ);
      }
      i = f.a.a.b.b.a.p(4, this.Eqv);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eqt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      wb localwb = (wb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localwb.ndI = locala.LVo.xF();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localwb.Eqt.add(locala.LVo.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localwb.Equ = locala.LVo.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localwb.Eqv = locala.LVo.xG();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wb
 * JD-Core Version:    0.7.0.1
 */