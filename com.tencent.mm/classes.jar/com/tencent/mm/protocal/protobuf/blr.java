package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blr
  extends com.tencent.mm.cd.a
{
  public cjp SWJ;
  public int SWK = -1;
  public int SWL = -1;
  public boolean SWM = false;
  public int SWN = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SWJ != null)
      {
        paramVarArgs.oE(2, this.SWJ.computeSize());
        this.SWJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.SWK);
      paramVarArgs.aY(4, this.SWL);
      paramVarArgs.co(5, this.SWM);
      paramVarArgs.aY(6, this.SWN);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SWJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.SWJ.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.SWK);
      int j = g.a.a.b.b.a.bM(4, this.SWL);
      int k = g.a.a.b.b.a.gL(5);
      int m = g.a.a.b.b.a.bM(6, this.SWN);
      AppMethodBeat.o(122490);
      return paramInt + i + j + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      blr localblr = (blr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localblr.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cjp localcjp = new cjp();
          if ((localObject != null) && (localObject.length > 0)) {
            localcjp.parseFrom((byte[])localObject);
          }
          localblr.SWJ = localcjp;
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localblr.SWK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localblr.SWL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localblr.SWM = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(122490);
        return 0;
      }
      localblr.SWN = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blr
 * JD-Core Version:    0.7.0.1
 */