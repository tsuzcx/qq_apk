package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xm
  extends com.tencent.mm.cd.a
{
  public LinkedList<xn> SjE;
  public int SjF;
  public eaf SjG;
  public int iWB;
  
  public xm()
  {
    AppMethodBeat.i(43085);
    this.SjE = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.iWB);
      paramVarArgs.e(2, 8, this.SjE);
      paramVarArgs.aY(3, this.SjF);
      if (this.SjG != null)
      {
        paramVarArgs.oE(4, this.SjG.computeSize());
        this.SjG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.iWB) + 0 + g.a.a.a.c(2, 8, this.SjE) + g.a.a.b.b.a.bM(3, this.SjF);
      paramInt = i;
      if (this.SjG != null) {
        paramInt = i + g.a.a.a.oD(4, this.SjG.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SjE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      xm localxm = (xm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localxm.iWB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new xn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((xn)localObject2).parseFrom((byte[])localObject1);
          }
          localxm.SjE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localxm.SjF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eaf();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eaf)localObject2).de((byte[])localObject1);
        }
        localxm.SjG = ((eaf)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xm
 * JD-Core Version:    0.7.0.1
 */