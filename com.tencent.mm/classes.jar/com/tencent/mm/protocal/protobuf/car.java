package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class car
  extends com.tencent.mm.bw.a
{
  public acn MfU;
  public float height;
  public String thumbUrl;
  public float width;
  public String xve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.thumbUrl != null) {
        paramVarArgs.e(1, this.thumbUrl);
      }
      paramVarArgs.E(2, this.width);
      paramVarArgs.E(3, this.height);
      if (this.MfU != null)
      {
        paramVarArgs.ni(4, this.MfU.computeSize());
        this.MfU.writeFields(paramVarArgs);
      }
      if (this.xve != null) {
        paramVarArgs.e(5, this.xve);
      }
      AppMethodBeat.o(209722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thumbUrl == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.b.b.a.f(1, this.thumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 4) + (g.a.a.b.b.a.fS(3) + 4);
      paramInt = i;
      if (this.MfU != null) {
        paramInt = i + g.a.a.a.nh(4, this.MfU.computeSize());
      }
      i = paramInt;
      if (this.xve != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xve);
      }
      AppMethodBeat.o(209722);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        car localcar = (car)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209722);
          return -1;
        case 1: 
          localcar.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209722);
          return 0;
        case 2: 
          localcar.width = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209722);
          return 0;
        case 3: 
          localcar.height = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209722);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((acn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcar.MfU = ((acn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209722);
          return 0;
        }
        localcar.xve = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209722);
        return 0;
      }
      AppMethodBeat.o(209722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.car
 * JD-Core Version:    0.7.0.1
 */