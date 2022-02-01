package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abf
  extends com.tencent.mm.bw.a
{
  public crm EuE;
  public LinkedList<Integer> EuK;
  public int ncL;
  
  public abf()
  {
    AppMethodBeat.i(43092);
    this.EuK = new LinkedList();
    AppMethodBeat.o(43092);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43093);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43093);
        throw paramVarArgs;
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(1, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ncL);
      paramVarArgs.f(3, 2, this.EuK);
      AppMethodBeat.o(43093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = f.a.a.a.lm(1, this.EuE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.ncL);
      int j = f.a.a.a.d(3, 2, this.EuK);
      AppMethodBeat.o(43093);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EuK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
          AppMethodBeat.o(43093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abf localabf = (abf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43093);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabf.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43093);
          return 0;
        case 2: 
          localabf.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43093);
          return 0;
        }
        localabf.EuK = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(43093);
        return 0;
      }
      AppMethodBeat.o(43093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abf
 * JD-Core Version:    0.7.0.1
 */