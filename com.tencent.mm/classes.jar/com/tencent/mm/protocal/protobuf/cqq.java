package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqq
  extends com.tencent.mm.cd.a
{
  public int TxZ = 0;
  public dcf Tya;
  public cqs Tyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TxZ);
      if (this.Tya != null)
      {
        paramVarArgs.oE(2, this.Tya.computeSize());
        this.Tya.writeFields(paramVarArgs);
      }
      if (this.Tyb != null)
      {
        paramVarArgs.oE(3, this.Tyb.computeSize());
        this.Tyb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(251114);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TxZ) + 0;
      paramInt = i;
      if (this.Tya != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tya.computeSize());
      }
      i = paramInt;
      if (this.Tyb != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tyb.computeSize());
      }
      AppMethodBeat.o(251114);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(251114);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cqq localcqq = (cqq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(251114);
        return -1;
      case 1: 
        localcqq.TxZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(251114);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcf)localObject2).parseFrom((byte[])localObject1);
          }
          localcqq.Tya = ((dcf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251114);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cqs();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cqs)localObject2).parseFrom((byte[])localObject1);
        }
        localcqq.Tyb = ((cqs)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(251114);
      return 0;
    }
    AppMethodBeat.o(251114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqq
 * JD-Core Version:    0.7.0.1
 */