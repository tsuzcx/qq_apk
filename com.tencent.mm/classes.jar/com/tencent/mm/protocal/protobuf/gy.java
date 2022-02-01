package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gy
  extends dop
{
  public String Cjt;
  public String KKG;
  public String dDj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Cjt != null) {
        paramVarArgs.e(2, this.Cjt);
      }
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      if (this.KKG != null) {
        paramVarArgs.e(4, this.KKG);
      }
      AppMethodBeat.o(72417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cjt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Cjt);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dDj);
      }
      paramInt = i;
      if (this.KKG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KKG);
      }
      AppMethodBeat.o(72417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gy localgy = (gy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72417);
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
            localgy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72417);
          return 0;
        case 2: 
          localgy.Cjt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72417);
          return 0;
        case 3: 
          localgy.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72417);
          return 0;
        }
        localgy.KKG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72417);
        return 0;
      }
      AppMethodBeat.o(72417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gy
 * JD-Core Version:    0.7.0.1
 */