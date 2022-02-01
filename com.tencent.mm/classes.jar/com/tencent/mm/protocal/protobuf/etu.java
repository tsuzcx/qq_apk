package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etu
  extends dop
{
  public int LsZ;
  public long Lta;
  public long NpN;
  public int NqU;
  public int Timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115881);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.Timestamp);
      paramVarArgs.bb(5, this.NpN);
      paramVarArgs.aM(6, this.NqU);
      AppMethodBeat.o(115881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LsZ);
      int j = g.a.a.b.b.a.r(3, this.Lta);
      int k = g.a.a.b.b.a.bu(4, this.Timestamp);
      int m = g.a.a.b.b.a.r(5, this.NpN);
      int n = g.a.a.b.b.a.bu(6, this.NqU);
      AppMethodBeat.o(115881);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etu localetu = (etu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115881);
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
            localetu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115881);
          return 0;
        case 2: 
          localetu.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115881);
          return 0;
        case 3: 
          localetu.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115881);
          return 0;
        case 4: 
          localetu.Timestamp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115881);
          return 0;
        case 5: 
          localetu.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115881);
          return 0;
        }
        localetu.NqU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115881);
        return 0;
      }
      AppMethodBeat.o(115881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etu
 * JD-Core Version:    0.7.0.1
 */