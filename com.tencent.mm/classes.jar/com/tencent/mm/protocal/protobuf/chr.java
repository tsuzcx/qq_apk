package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chr
  extends com.tencent.mm.bx.a
{
  public cmf Edh;
  public int Edi;
  public LinkedList<cob> Edj;
  
  public chr()
  {
    AppMethodBeat.i(6420);
    this.Edj = new LinkedList();
    AppMethodBeat.o(6420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Edh == null)
      {
        paramVarArgs = new b("Not all required fields were included: GroupName");
        AppMethodBeat.o(6421);
        throw paramVarArgs;
      }
      if (this.Edh != null)
      {
        paramVarArgs.kX(1, this.Edh.computeSize());
        this.Edh.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Edi);
      paramVarArgs.e(3, 8, this.Edj);
      AppMethodBeat.o(6421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Edh == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.a.kW(1, this.Edh.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.Edi);
      int j = f.a.a.a.c(3, 8, this.Edj);
      AppMethodBeat.o(6421);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Edj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Edh == null)
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
        chr localchr = (chr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchr.Edh = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6421);
          return 0;
        case 2: 
          localchr.Edi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6421);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchr.Edj.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chr
 * JD-Core Version:    0.7.0.1
 */