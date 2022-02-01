package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class n
  extends dop
{
  public long gTC;
  public String gTk;
  public String gTl;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gTk != null) {
        paramVarArgs.e(2, this.gTk);
      }
      paramVarArgs.aM(3, this.source);
      paramVarArgs.bb(4, this.gTC);
      if (this.gTl != null) {
        paramVarArgs.e(5, this.gTl);
      }
      AppMethodBeat.o(194686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gTk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.gTk);
      }
      i = i + g.a.a.b.b.a.bu(3, this.source) + g.a.a.b.b.a.r(4, this.gTC);
      paramInt = i;
      if (this.gTl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.gTl);
      }
      AppMethodBeat.o(194686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194686);
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
            localn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194686);
          return 0;
        case 2: 
          localn.gTk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194686);
          return 0;
        case 3: 
          localn.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(194686);
          return 0;
        case 4: 
          localn.gTC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(194686);
          return 0;
        }
        localn.gTl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194686);
        return 0;
      }
      AppMethodBeat.o(194686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.n
 * JD-Core Version:    0.7.0.1
 */