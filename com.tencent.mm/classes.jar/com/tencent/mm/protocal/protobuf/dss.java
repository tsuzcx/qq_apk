package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dss
  extends dop
{
  public b Mcz;
  public String dDv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dDv != null) {
        paramVarArgs.e(2, this.dDv);
      }
      if (this.Mcz != null) {
        paramVarArgs.c(3, this.Mcz);
      }
      AppMethodBeat.o(74666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dDv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dDv);
      }
      i = paramInt;
      if (this.Mcz != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Mcz);
      }
      AppMethodBeat.o(74666);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dss localdss = (dss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74666);
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
            localdss.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74666);
          return 0;
        case 2: 
          localdss.dDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74666);
          return 0;
        }
        localdss.Mcz = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(74666);
        return 0;
      }
      AppMethodBeat.o(74666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dss
 * JD-Core Version:    0.7.0.1
 */