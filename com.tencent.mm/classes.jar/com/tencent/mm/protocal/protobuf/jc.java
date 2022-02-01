package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jc
  extends com.tencent.mm.bw.a
{
  public int DUZ;
  public int DWO;
  public LinkedList<String> DWP;
  public int ReqType;
  
  public jc()
  {
    AppMethodBeat.i(104755);
    this.DWP = new LinkedList();
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DWO);
      paramVarArgs.aR(2, this.ReqType);
      paramVarArgs.e(3, 1, this.DWP);
      paramVarArgs.aR(4, this.DUZ);
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DWO);
      int i = f.a.a.b.b.a.bx(2, this.ReqType);
      int j = f.a.a.a.c(3, 1, this.DWP);
      int k = f.a.a.b.b.a.bx(4, this.DUZ);
      AppMethodBeat.o(104756);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DWP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      jc localjc = (jc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localjc.DWO = locala.LVo.xF();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localjc.ReqType = locala.LVo.xF();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localjc.DWP.add(locala.LVo.readString());
        AppMethodBeat.o(104756);
        return 0;
      }
      localjc.DUZ = locala.LVo.xF();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */