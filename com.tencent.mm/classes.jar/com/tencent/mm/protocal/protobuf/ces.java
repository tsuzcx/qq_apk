package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ces
  extends com.tencent.mm.bw.a
{
  public dol GKT;
  public String GKU;
  public boolean GKX = false;
  public boolean Hce = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKT != null)
      {
        paramVarArgs.lJ(1, this.GKT.computeSize());
        this.GKT.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.GKX);
      paramVarArgs.bC(3, this.Hce);
      if (this.GKU != null) {
        paramVarArgs.d(4, this.GKU);
      }
      AppMethodBeat.o(122520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKT == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lI(1, this.GKT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GKU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKU);
      }
      AppMethodBeat.o(122520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ces localces = (ces)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122520);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localces.GKT = ((dol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122520);
          return 0;
        case 2: 
          localces.GKX = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122520);
          return 0;
        case 3: 
          localces.Hce = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122520);
          return 0;
        }
        localces.GKU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122520);
        return 0;
      }
      AppMethodBeat.o(122520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ces
 * JD-Core Version:    0.7.0.1
 */