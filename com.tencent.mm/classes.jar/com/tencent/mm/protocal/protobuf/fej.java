package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class fej
  extends dop
{
  public b NzD;
  public String NzE;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.status);
      if (this.NzD != null) {
        paramVarArgs.c(3, this.NzD);
      }
      if (this.NzE != null) {
        paramVarArgs.e(4, this.NzE);
      }
      AppMethodBeat.o(194402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.status);
      paramInt = i;
      if (this.NzD != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.NzD);
      }
      i = paramInt;
      if (this.NzE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.NzE);
      }
      AppMethodBeat.o(194402);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fej localfej = (fej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194402);
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
            localfej.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194402);
          return 0;
        case 2: 
          localfej.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(194402);
          return 0;
        case 3: 
          localfej.NzD = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(194402);
          return 0;
        }
        localfej.NzE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194402);
        return 0;
      }
      AppMethodBeat.o(194402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fej
 * JD-Core Version:    0.7.0.1
 */