package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ru
  extends com.tencent.mm.cd.a
{
  public rm SaP;
  public rl SaQ;
  public long SaR;
  public rs SaS;
  public rw SaT;
  public rr SaU;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      if (this.SaP != null)
      {
        paramVarArgs.oE(2, this.SaP.computeSize());
        this.SaP.writeFields(paramVarArgs);
      }
      if (this.SaQ != null)
      {
        paramVarArgs.oE(3, this.SaQ.computeSize());
        this.SaQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(4, this.SaR);
      if (this.SaS != null)
      {
        paramVarArgs.oE(5, this.SaS.computeSize());
        this.SaS.writeFields(paramVarArgs);
      }
      if (this.SaT != null)
      {
        paramVarArgs.oE(6, this.SaT.computeSize());
        this.SaT.writeFields(paramVarArgs);
      }
      if (this.SaU != null)
      {
        paramVarArgs.oE(7, this.SaU.computeSize());
        this.SaU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.SaP != null) {
        paramInt = i + g.a.a.a.oD(2, this.SaP.computeSize());
      }
      i = paramInt;
      if (this.SaQ != null) {
        i = paramInt + g.a.a.a.oD(3, this.SaQ.computeSize());
      }
      i += g.a.a.b.b.a.p(4, this.SaR);
      paramInt = i;
      if (this.SaS != null) {
        paramInt = i + g.a.a.a.oD(5, this.SaS.computeSize());
      }
      i = paramInt;
      if (this.SaT != null) {
        i = paramInt + g.a.a.a.oD(6, this.SaT.computeSize());
      }
      paramInt = i;
      if (this.SaU != null) {
        paramInt = i + g.a.a.a.oD(7, this.SaU.computeSize());
      }
      AppMethodBeat.o(117850);
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
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ru localru = (ru)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localru.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new rm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((rm)localObject2).parseFrom((byte[])localObject1);
          }
          localru.SaP = ((rm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new rl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((rl)localObject2).parseFrom((byte[])localObject1);
          }
          localru.SaQ = ((rl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localru.SaR = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new rs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((rs)localObject2).parseFrom((byte[])localObject1);
          }
          localru.SaS = ((rs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new rw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((rw)localObject2).parseFrom((byte[])localObject1);
          }
          localru.SaT = ((rw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new rr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((rr)localObject2).parseFrom((byte[])localObject1);
        }
        localru.SaU = ((rr)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */