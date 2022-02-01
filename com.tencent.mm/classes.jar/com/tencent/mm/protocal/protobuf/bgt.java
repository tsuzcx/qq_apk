package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgt
  extends com.tencent.mm.cd.a
{
  public LinkedList<bio> SRt;
  public long lastUpdateTime;
  
  public bgt()
  {
    AppMethodBeat.i(203325);
    this.SRt = new LinkedList();
    AppMethodBeat.o(203325);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.lastUpdateTime);
      paramVarArgs.e(2, 8, this.SRt);
      AppMethodBeat.o(203348);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.lastUpdateTime);
      i = g.a.a.a.c(2, 8, this.SRt);
      AppMethodBeat.o(203348);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SRt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203348);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bgt localbgt = (bgt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203348);
        return -1;
      case 1: 
        localbgt.lastUpdateTime = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(203348);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bio localbio = new bio();
        if ((localObject != null) && (localObject.length > 0)) {
          localbio.parseFrom((byte[])localObject);
        }
        localbgt.SRt.add(localbio);
        paramInt += 1;
      }
      AppMethodBeat.o(203348);
      return 0;
    }
    AppMethodBeat.o(203348);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgt
 * JD-Core Version:    0.7.0.1
 */