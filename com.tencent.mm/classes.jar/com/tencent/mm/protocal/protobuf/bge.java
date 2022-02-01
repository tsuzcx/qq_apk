package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bge
  extends dop
{
  public String LPT;
  public LinkedList<String> LPU;
  public String xLl;
  
  public bge()
  {
    AppMethodBeat.i(42633);
    this.LPU = new LinkedList();
    AppMethodBeat.o(42633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LPT != null) {
        paramVarArgs.e(2, this.LPT);
      }
      paramVarArgs.e(3, 1, this.LPU);
      if (this.xLl != null) {
        paramVarArgs.e(4, this.xLl);
      }
      AppMethodBeat.o(42634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LPT != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LPT);
      }
      i += g.a.a.a.c(3, 1, this.LPU);
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xLl);
      }
      AppMethodBeat.o(42634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LPU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(42634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bge localbge = (bge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42634);
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
            localbge.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42634);
          return 0;
        case 2: 
          localbge.LPT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42634);
          return 0;
        case 3: 
          localbge.LPU.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(42634);
          return 0;
        }
        localbge.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(42634);
        return 0;
      }
      AppMethodBeat.o(42634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bge
 * JD-Core Version:    0.7.0.1
 */