package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hz
  extends com.tencent.mm.bv.a
{
  public int ReqType;
  public int wsX;
  public int wux;
  public LinkedList<String> wuy;
  
  public hz()
  {
    AppMethodBeat.i(62519);
    this.wuy = new LinkedList();
    AppMethodBeat.o(62519);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62520);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wux);
      paramVarArgs.aO(2, this.ReqType);
      paramVarArgs.e(3, 1, this.wuy);
      paramVarArgs.aO(4, this.wsX);
      AppMethodBeat.o(62520);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wux);
      int i = e.a.a.b.b.a.bl(2, this.ReqType);
      int j = e.a.a.a.c(3, 1, this.wuy);
      int k = e.a.a.b.b.a.bl(4, this.wsX);
      AppMethodBeat.o(62520);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wuy.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62520);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      hz localhz = (hz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62520);
        return -1;
      case 1: 
        localhz.wux = locala.CLY.sl();
        AppMethodBeat.o(62520);
        return 0;
      case 2: 
        localhz.ReqType = locala.CLY.sl();
        AppMethodBeat.o(62520);
        return 0;
      case 3: 
        localhz.wuy.add(locala.CLY.readString());
        AppMethodBeat.o(62520);
        return 0;
      }
      localhz.wsX = locala.CLY.sl();
      AppMethodBeat.o(62520);
      return 0;
    }
    AppMethodBeat.o(62520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hz
 * JD-Core Version:    0.7.0.1
 */