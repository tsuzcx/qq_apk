package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvs
  extends com.tencent.mm.cd.a
{
  public LinkedList<bvr> TfA;
  public bvq TfB;
  
  public bvs()
  {
    AppMethodBeat.i(82411);
    this.TfA = new LinkedList();
    AppMethodBeat.o(82411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TfA);
      if (this.TfB != null)
      {
        paramVarArgs.oE(2, this.TfB.computeSize());
        this.TfB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.TfA) + 0;
      paramInt = i;
      if (this.TfB != null) {
        paramInt = i + g.a.a.a.oD(2, this.TfB.computeSize());
      }
      AppMethodBeat.o(82412);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TfA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bvs localbvs = (bvs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82412);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bvr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bvr)localObject2).parseFrom((byte[])localObject1);
          }
          localbvs.TfA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82412);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bvq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bvq)localObject2).parseFrom((byte[])localObject1);
        }
        localbvs.TfB = ((bvq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    AppMethodBeat.o(82412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvs
 * JD-Core Version:    0.7.0.1
 */