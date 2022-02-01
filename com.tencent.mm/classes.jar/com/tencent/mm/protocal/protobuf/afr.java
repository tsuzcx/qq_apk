package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afr
  extends com.tencent.mm.bw.a
{
  public dqi Lqk;
  public LinkedList<Integer> Lqq;
  public int oTz;
  
  public afr()
  {
    AppMethodBeat.i(43092);
    this.Lqq = new LinkedList();
    AppMethodBeat.o(43092);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43093);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43093);
        throw paramVarArgs;
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(1, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.f(3, 2, this.Lqq);
      AppMethodBeat.o(43093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = g.a.a.a.nh(1, this.Lqk.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTz);
      int j = g.a.a.a.d(3, 2, this.Lqq);
      AppMethodBeat.o(43093);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lqq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
          AppMethodBeat.o(43093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        afr localafr = (afr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43093);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localafr.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43093);
          return 0;
        case 2: 
          localafr.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43093);
          return 0;
        }
        localafr.Lqq = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
        AppMethodBeat.o(43093);
        return 0;
      }
      AppMethodBeat.o(43093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afr
 * JD-Core Version:    0.7.0.1
 */