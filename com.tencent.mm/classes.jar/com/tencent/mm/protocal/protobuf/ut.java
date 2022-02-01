package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ut
  extends dop
{
  public float dTj;
  public String eaO;
  public float latitude;
  public String pRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pRX != null) {
        paramVarArgs.e(2, this.pRX);
      }
      paramVarArgs.E(3, this.dTj);
      paramVarArgs.E(4, this.latitude);
      if (this.eaO != null) {
        paramVarArgs.e(5, this.eaO);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pRX != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pRX);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 4) + (g.a.a.b.b.a.fS(4) + 4);
      paramInt = i;
      if (this.eaO != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.eaO);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
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
            localut.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localut.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localut.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localut.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(113970);
          return 0;
        }
        localut.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */