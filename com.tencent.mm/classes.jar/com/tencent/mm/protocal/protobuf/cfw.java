package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfw
  extends com.tencent.mm.bv.a
{
  public int wLO;
  public int wQP;
  public int xQo;
  public int xQp;
  public int xQq;
  public int xQr;
  public int xQs;
  public LinkedList<Integer> xQt;
  public int xQu;
  public int xQv;
  public LinkedList<Integer> xQw;
  public int xQx;
  public int xQy;
  
  public cfw()
  {
    AppMethodBeat.i(5221);
    this.xQt = new LinkedList();
    this.xQw = new LinkedList();
    AppMethodBeat.o(5221);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5222);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wQP);
      paramVarArgs.aO(2, this.xQo);
      paramVarArgs.aO(3, this.wLO);
      paramVarArgs.aO(4, this.xQp);
      paramVarArgs.aO(5, this.xQq);
      paramVarArgs.aO(6, this.xQr);
      paramVarArgs.aO(7, this.xQs);
      paramVarArgs.e(8, 2, this.xQt);
      paramVarArgs.aO(9, this.xQu);
      paramVarArgs.aO(10, this.xQv);
      paramVarArgs.e(11, 2, this.xQw);
      paramVarArgs.aO(12, this.xQx);
      paramVarArgs.aO(13, this.xQy);
      AppMethodBeat.o(5222);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wQP);
      int i = e.a.a.b.b.a.bl(2, this.xQo);
      int j = e.a.a.b.b.a.bl(3, this.wLO);
      int k = e.a.a.b.b.a.bl(4, this.xQp);
      int m = e.a.a.b.b.a.bl(5, this.xQq);
      int n = e.a.a.b.b.a.bl(6, this.xQr);
      int i1 = e.a.a.b.b.a.bl(7, this.xQs);
      int i2 = e.a.a.a.c(8, 2, this.xQt);
      int i3 = e.a.a.b.b.a.bl(9, this.xQu);
      int i4 = e.a.a.b.b.a.bl(10, this.xQv);
      int i5 = e.a.a.a.c(11, 2, this.xQw);
      int i6 = e.a.a.b.b.a.bl(12, this.xQx);
      int i7 = e.a.a.b.b.a.bl(13, this.xQy);
      AppMethodBeat.o(5222);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xQt.clear();
      this.xQw.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(5222);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cfw localcfw = (cfw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5222);
        return -1;
      case 1: 
        localcfw.wQP = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 2: 
        localcfw.xQo = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 3: 
        localcfw.wLO = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 4: 
        localcfw.xQp = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 5: 
        localcfw.xQq = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 6: 
        localcfw.xQr = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 7: 
        localcfw.xQs = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 8: 
        localcfw.xQt.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(5222);
        return 0;
      case 9: 
        localcfw.xQu = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 10: 
        localcfw.xQv = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      case 11: 
        localcfw.xQw.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(5222);
        return 0;
      case 12: 
        localcfw.xQx = locala.CLY.sl();
        AppMethodBeat.o(5222);
        return 0;
      }
      localcfw.xQy = locala.CLY.sl();
      AppMethodBeat.o(5222);
      return 0;
    }
    AppMethodBeat.o(5222);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfw
 * JD-Core Version:    0.7.0.1
 */