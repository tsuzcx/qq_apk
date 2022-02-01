package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class arf
  extends com.tencent.mm.cd.a
{
  public long SEj;
  public int SEk;
  public int SEl;
  public cxh SEm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202907);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SEj);
      paramVarArgs.aY(2, this.SEk);
      paramVarArgs.aY(3, this.SEl);
      if (this.SEm != null)
      {
        paramVarArgs.oE(4, this.SEm.computeSize());
        this.SEm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(202907);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.SEj) + 0 + g.a.a.b.b.a.bM(2, this.SEk) + g.a.a.b.b.a.bM(3, this.SEl);
      paramInt = i;
      if (this.SEm != null) {
        paramInt = i + g.a.a.a.oD(4, this.SEm.computeSize());
      }
      AppMethodBeat.o(202907);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(202907);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      arf localarf = (arf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(202907);
        return -1;
      case 1: 
        localarf.SEj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(202907);
        return 0;
      case 2: 
        localarf.SEk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(202907);
        return 0;
      case 3: 
        localarf.SEl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(202907);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cxh localcxh = new cxh();
        if ((localObject != null) && (localObject.length > 0)) {
          localcxh.parseFrom((byte[])localObject);
        }
        localarf.SEm = localcxh;
        paramInt += 1;
      }
      AppMethodBeat.o(202907);
      return 0;
    }
    AppMethodBeat.o(202907);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arf
 * JD-Core Version:    0.7.0.1
 */