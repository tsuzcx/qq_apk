package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfr
  extends dop
{
  public String MlA;
  public LinkedList<String> MlD;
  public LinkedList<Integer> MlE;
  
  public cfr()
  {
    AppMethodBeat.i(124524);
    this.MlD = new LinkedList();
    this.MlE = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MlA != null) {
        paramVarArgs.e(2, this.MlA);
      }
      paramVarArgs.e(3, 1, this.MlD);
      paramVarArgs.e(4, 2, this.MlE);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MlA != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MlA);
      }
      paramInt = g.a.a.a.c(3, 1, this.MlD);
      int j = g.a.a.a.c(4, 2, this.MlE);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MlD.clear();
        this.MlE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfr localcfr = (cfr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
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
            localcfr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localcfr.MlA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localcfr.MlD.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localcfr.MlE.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfr
 * JD-Core Version:    0.7.0.1
 */