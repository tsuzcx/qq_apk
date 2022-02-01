package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class k
  extends com.tencent.mm.cd.a
{
  public int RCL;
  public LinkedList<l> RCM;
  
  public k()
  {
    AppMethodBeat.i(143953);
    this.RCM = new LinkedList();
    AppMethodBeat.o(143953);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143954);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCL);
      paramVarArgs.e(2, 8, this.RCM);
      AppMethodBeat.o(143954);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RCL);
      i = g.a.a.a.c(2, 8, this.RCM);
      AppMethodBeat.o(143954);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RCM.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143954);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143954);
        return -1;
      case 1: 
        localk.RCL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143954);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        l locall = new l();
        if ((localObject != null) && (localObject.length > 0)) {
          locall.parseFrom((byte[])localObject);
        }
        localk.RCM.add(locall);
        paramInt += 1;
      }
      AppMethodBeat.o(143954);
      return 0;
    }
    AppMethodBeat.o(143954);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.k
 * JD-Core Version:    0.7.0.1
 */