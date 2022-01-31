package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chk
  extends com.tencent.mm.bv.a
{
  public int swp;
  public String ubk;
  public int xSg;
  public long xSm;
  public boolean xSn;
  public LinkedList<String> xSo;
  public LinkedList<String> xSp;
  
  public chk()
  {
    AppMethodBeat.i(56525);
    this.xSo = new LinkedList();
    this.xSp = new LinkedList();
    AppMethodBeat.o(56525);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56526);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xSm);
      paramVarArgs.aO(2, this.swp);
      paramVarArgs.aO(3, this.xSg);
      paramVarArgs.aS(4, this.xSn);
      paramVarArgs.e(5, 1, this.xSo);
      paramVarArgs.e(6, 1, this.xSp);
      if (this.ubk != null) {
        paramVarArgs.e(7, this.ubk);
      }
      AppMethodBeat.o(56526);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.xSm) + 0 + e.a.a.b.b.a.bl(2, this.swp) + e.a.a.b.b.a.bl(3, this.xSg) + (e.a.a.b.b.a.eW(4) + 1) + e.a.a.a.c(5, 1, this.xSo) + e.a.a.a.c(6, 1, this.xSp);
      paramInt = i;
      if (this.ubk != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.ubk);
      }
      AppMethodBeat.o(56526);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xSo.clear();
      this.xSp.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56526);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      chk localchk = (chk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56526);
        return -1;
      case 1: 
        localchk.xSm = locala.CLY.sm();
        AppMethodBeat.o(56526);
        return 0;
      case 2: 
        localchk.swp = locala.CLY.sl();
        AppMethodBeat.o(56526);
        return 0;
      case 3: 
        localchk.xSg = locala.CLY.sl();
        AppMethodBeat.o(56526);
        return 0;
      case 4: 
        localchk.xSn = locala.CLY.emu();
        AppMethodBeat.o(56526);
        return 0;
      case 5: 
        localchk.xSo.add(locala.CLY.readString());
        AppMethodBeat.o(56526);
        return 0;
      case 6: 
        localchk.xSp.add(locala.CLY.readString());
        AppMethodBeat.o(56526);
        return 0;
      }
      localchk.ubk = locala.CLY.readString();
      AppMethodBeat.o(56526);
      return 0;
    }
    AppMethodBeat.o(56526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chk
 * JD-Core Version:    0.7.0.1
 */