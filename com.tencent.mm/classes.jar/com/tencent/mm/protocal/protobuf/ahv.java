package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahv
  extends com.tencent.mm.cd.a
{
  public int SsF;
  public LinkedList<ahu> SsG;
  
  public ahv()
  {
    AppMethodBeat.i(115837);
    this.SsG = new LinkedList();
    AppMethodBeat.o(115837);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SsF);
      paramVarArgs.e(2, 8, this.SsG);
      AppMethodBeat.o(115838);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SsF);
      i = g.a.a.a.c(2, 8, this.SsG);
      AppMethodBeat.o(115838);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SsG.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ahv localahv = (ahv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115838);
        return -1;
      case 1: 
        localahv.SsF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115838);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ahu localahu = new ahu();
        if ((localObject != null) && (localObject.length > 0)) {
          localahu.parseFrom((byte[])localObject);
        }
        localahv.SsG.add(localahu);
        paramInt += 1;
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    AppMethodBeat.o(115838);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahv
 * JD-Core Version:    0.7.0.1
 */