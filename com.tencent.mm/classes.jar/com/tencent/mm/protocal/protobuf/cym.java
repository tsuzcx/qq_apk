package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cym
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FHH;
  public LinkedList<String> FHI;
  public LinkedList<Integer> FHJ;
  public LinkedList<Integer> FHK;
  
  public cym()
  {
    AppMethodBeat.i(114079);
    this.FHH = new LinkedList();
    this.FHI = new LinkedList();
    this.FHJ = new LinkedList();
    this.FHK = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FHH);
      paramVarArgs.e(2, 1, this.FHI);
      paramVarArgs.e(3, 2, this.FHJ);
      paramVarArgs.e(4, 2, this.FHK);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.FHH);
      int i = f.a.a.a.c(2, 1, this.FHI);
      int j = f.a.a.a.c(3, 2, this.FHJ);
      int k = f.a.a.a.c(4, 2, this.FHK);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHH.clear();
      this.FHI.clear();
      this.FHJ.clear();
      this.FHK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cym localcym = (cym)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localcym.FHH.add(locala.LVo.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localcym.FHI.add(locala.LVo.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localcym.FHJ.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localcym.FHK.add(Integer.valueOf(locala.LVo.xF()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */