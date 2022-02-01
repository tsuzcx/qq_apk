package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alp
  extends dop
{
  public int Bbl;
  public int Luu;
  public int egY;
  public double latitude;
  public double longitude;
  public int qwe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.qwe);
      paramVarArgs.aM(3, this.Bbl);
      paramVarArgs.aM(4, this.egY);
      paramVarArgs.aM(5, this.Luu);
      paramVarArgs.e(6, this.latitude);
      paramVarArgs.e(7, this.longitude);
      AppMethodBeat.o(91456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.qwe);
      int j = g.a.a.b.b.a.bu(3, this.Bbl);
      int k = g.a.a.b.b.a.bu(4, this.egY);
      int m = g.a.a.b.b.a.bu(5, this.Luu);
      int n = g.a.a.b.b.a.fS(6);
      int i1 = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(91456);
      return paramInt + i + j + k + m + (n + 8) + (i1 + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alp localalp = (alp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91456);
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
            localalp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91456);
          return 0;
        case 2: 
          localalp.qwe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91456);
          return 0;
        case 3: 
          localalp.Bbl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91456);
          return 0;
        case 4: 
          localalp.egY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91456);
          return 0;
        case 5: 
          localalp.Luu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91456);
          return 0;
        case 6: 
          localalp.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91456);
          return 0;
        }
        localalp.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91456);
        return 0;
      }
      AppMethodBeat.o(91456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alp
 * JD-Core Version:    0.7.0.1
 */