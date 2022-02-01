package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ox
  extends dop
{
  public LinkedList<ow> KVH;
  public int KVI;
  public int KVJ;
  public int KVK;
  public int scene;
  
  public ox()
  {
    AppMethodBeat.i(124438);
    this.KVH = new LinkedList();
    AppMethodBeat.o(124438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KVH);
      paramVarArgs.aM(3, this.scene);
      paramVarArgs.aM(4, this.KVI);
      paramVarArgs.aM(7, this.KVJ);
      paramVarArgs.aM(8, this.KVK);
      AppMethodBeat.o(124439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KVH);
      int j = g.a.a.b.b.a.bu(3, this.scene);
      int k = g.a.a.b.b.a.bu(4, this.KVI);
      int m = g.a.a.b.b.a.bu(7, this.KVJ);
      int n = g.a.a.b.b.a.bu(8, this.KVK);
      AppMethodBeat.o(124439);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KVH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ox localox = (ox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(124439);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localox.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ow();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ow)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localox.KVH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 3: 
          localox.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124439);
          return 0;
        case 4: 
          localox.KVI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124439);
          return 0;
        case 7: 
          localox.KVJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124439);
          return 0;
        }
        localox.KVK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124439);
        return 0;
      }
      AppMethodBeat.o(124439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ox
 * JD-Core Version:    0.7.0.1
 */