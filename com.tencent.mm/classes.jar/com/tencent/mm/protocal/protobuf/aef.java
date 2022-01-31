package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aef
  extends com.tencent.mm.bv.a
{
  public int fQD = 0;
  public int wXc = 7;
  public long wXd = 0L;
  public int wXe = 0;
  public String wXf = "";
  public String wXg = "";
  public boolean wXh = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73650);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wXc);
      paramVarArgs.am(2, this.wXd);
      paramVarArgs.aO(3, this.wXe);
      if (this.wXf != null) {
        paramVarArgs.e(4, this.wXf);
      }
      if (this.wXg != null) {
        paramVarArgs.e(5, this.wXg);
      }
      paramVarArgs.aO(6, this.fQD);
      paramVarArgs.aS(7, this.wXh);
      AppMethodBeat.o(73650);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wXc) + 0 + e.a.a.b.b.a.p(2, this.wXd) + e.a.a.b.b.a.bl(3, this.wXe);
      paramInt = i;
      if (this.wXf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXf);
      }
      i = paramInt;
      if (this.wXg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wXg);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.fQD);
      int j = e.a.a.b.b.a.eW(7);
      AppMethodBeat.o(73650);
      return i + paramInt + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73650);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aef localaef = (aef)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73650);
        return -1;
      case 1: 
        localaef.wXc = locala.CLY.sl();
        AppMethodBeat.o(73650);
        return 0;
      case 2: 
        localaef.wXd = locala.CLY.sm();
        AppMethodBeat.o(73650);
        return 0;
      case 3: 
        localaef.wXe = locala.CLY.sl();
        AppMethodBeat.o(73650);
        return 0;
      case 4: 
        localaef.wXf = locala.CLY.readString();
        AppMethodBeat.o(73650);
        return 0;
      case 5: 
        localaef.wXg = locala.CLY.readString();
        AppMethodBeat.o(73650);
        return 0;
      case 6: 
        localaef.fQD = locala.CLY.sl();
        AppMethodBeat.o(73650);
        return 0;
      }
      localaef.wXh = locala.CLY.emu();
      AppMethodBeat.o(73650);
      return 0;
    }
    AppMethodBeat.o(73650);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aef
 * JD-Core Version:    0.7.0.1
 */