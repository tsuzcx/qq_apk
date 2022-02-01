package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bjx
  extends com.tencent.mm.cd.a
{
  public b DgQ;
  public int SEl;
  public LinkedList<ddp> SGi;
  
  public bjx()
  {
    AppMethodBeat.i(198270);
    this.SGi = new LinkedList();
    AppMethodBeat.o(198270);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198287);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SGi);
      paramVarArgs.aY(2, this.SEl);
      if (this.DgQ != null) {
        paramVarArgs.c(3, this.DgQ);
      }
      AppMethodBeat.o(198287);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SGi) + 0 + g.a.a.b.b.a.bM(2, this.SEl);
      paramInt = i;
      if (this.DgQ != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.DgQ);
      }
      AppMethodBeat.o(198287);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SGi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198287);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bjx localbjx = (bjx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198287);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ddp localddp = new ddp();
          if ((localObject != null) && (localObject.length > 0)) {
            localddp.parseFrom((byte[])localObject);
          }
          localbjx.SGi.add(localddp);
          paramInt += 1;
        }
        AppMethodBeat.o(198287);
        return 0;
      case 2: 
        localbjx.SEl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198287);
        return 0;
      }
      localbjx.DgQ = ((g.a.a.a.a)localObject).abFh.iUw();
      AppMethodBeat.o(198287);
      return 0;
    }
    AppMethodBeat.o(198287);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjx
 * JD-Core Version:    0.7.0.1
 */