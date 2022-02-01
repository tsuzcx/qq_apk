package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blo
  extends com.tencent.mm.cd.a
{
  public int SEq;
  public int SEr;
  public bhw SVk;
  public int SWA;
  public int SWB;
  public int SWC;
  public int SWD;
  public int count;
  public String lqp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.count);
      paramVarArgs.aY(2, this.SEq);
      paramVarArgs.aY(3, this.SEr);
      paramVarArgs.aY(4, this.SWA);
      if (this.lqp != null) {
        paramVarArgs.f(5, this.lqp);
      }
      if (this.SVk != null)
      {
        paramVarArgs.oE(6, this.SVk.computeSize());
        this.SVk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.SWB);
      paramVarArgs.aY(8, this.SWC);
      paramVarArgs.aY(9, this.SWD);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.count) + 0 + g.a.a.b.b.a.bM(2, this.SEq) + g.a.a.b.b.a.bM(3, this.SEr) + g.a.a.b.b.a.bM(4, this.SWA);
      paramInt = i;
      if (this.lqp != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.lqp);
      }
      i = paramInt;
      if (this.SVk != null) {
        i = paramInt + g.a.a.a.oD(6, this.SVk.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(7, this.SWB);
      int j = g.a.a.b.b.a.bM(8, this.SWC);
      int k = g.a.a.b.b.a.bM(9, this.SWD);
      AppMethodBeat.o(169077);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      blo localblo = (blo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localblo.count = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localblo.SEq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localblo.SEr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localblo.SWA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localblo.lqp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bhw localbhw = new bhw();
          if ((localObject != null) && (localObject.length > 0)) {
            localbhw.parseFrom((byte[])localObject);
          }
          localblo.SVk = localbhw;
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localblo.SWB = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      case 8: 
        localblo.SWC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169077);
        return 0;
      }
      localblo.SWD = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blo
 * JD-Core Version:    0.7.0.1
 */