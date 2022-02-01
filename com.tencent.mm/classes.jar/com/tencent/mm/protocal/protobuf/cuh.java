package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuh
  extends dyy
{
  public long HLI;
  public LinkedList<cum> SKG;
  
  public cuh()
  {
    AppMethodBeat.i(169916);
    this.SKG = new LinkedList();
    AppMethodBeat.o(169916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169917);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.HLI);
      paramVarArgs.e(3, 8, this.SKG);
      AppMethodBeat.o(169917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.HLI);
      int j = g.a.a.a.c(3, 8, this.SKG);
      AppMethodBeat.o(169917);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SKG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuh localcuh = (cuh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169917);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcuh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169917);
          return 0;
        case 2: 
          localcuh.HLI = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169917);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cum();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cum)localObject2).parseFrom((byte[])localObject1);
          }
          localcuh.SKG.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169917);
        return 0;
      }
      AppMethodBeat.o(169917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuh
 * JD-Core Version:    0.7.0.1
 */