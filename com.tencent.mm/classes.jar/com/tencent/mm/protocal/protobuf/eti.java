package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eti
  extends dop
{
  public long Lta;
  public long MKf;
  public long NeG;
  public int NqC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125509);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.NeG);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.bb(4, this.MKf);
      paramVarArgs.aM(5, this.NqC);
      AppMethodBeat.o(125509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.NeG);
      int j = g.a.a.b.b.a.r(3, this.Lta);
      int k = g.a.a.b.b.a.r(4, this.MKf);
      int m = g.a.a.b.b.a.bu(5, this.NqC);
      AppMethodBeat.o(125509);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eti localeti = (eti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125509);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeti.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125509);
          return 0;
        case 2: 
          localeti.NeG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125509);
          return 0;
        case 3: 
          localeti.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125509);
          return 0;
        case 4: 
          localeti.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125509);
          return 0;
        }
        localeti.NqC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125509);
        return 0;
      }
      AppMethodBeat.o(125509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eti
 * JD-Core Version:    0.7.0.1
 */