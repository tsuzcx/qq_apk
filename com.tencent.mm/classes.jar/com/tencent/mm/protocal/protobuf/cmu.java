package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cmu
  extends com.tencent.mm.bw.a
{
  public crm FAd;
  public int FAe;
  public LinkedList<cti> FAf;
  
  public cmu()
  {
    AppMethodBeat.i(6420);
    this.FAf = new LinkedList();
    AppMethodBeat.o(6420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAd == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupName");
        AppMethodBeat.o(6421);
        throw paramVarArgs;
      }
      if (this.FAd != null)
      {
        paramVarArgs.ln(1, this.FAd.computeSize());
        this.FAd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FAe);
      paramVarArgs.e(3, 8, this.FAf);
      AppMethodBeat.o(6421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FAd == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.a.lm(1, this.FAd.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FAe);
      int j = f.a.a.a.c(3, 8, this.FAf);
      AppMethodBeat.o(6421);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FAd == null)
        {
          paramVarArgs = new b("Not all required fields were included: GroupName");
          AppMethodBeat.o(6421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmu localcmu = (cmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmu.FAd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6421);
          return 0;
        case 2: 
          localcmu.FAe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6421);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cti();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmu.FAf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6421);
        return 0;
      }
      AppMethodBeat.o(6421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmu
 * JD-Core Version:    0.7.0.1
 */