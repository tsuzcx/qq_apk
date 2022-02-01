package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zz
  extends com.tencent.mm.bx.a
{
  public int DbB;
  public cmf Dby;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43091);
        throw paramVarArgs;
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(1, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DbB);
      paramVarArgs.aG(3, this.uKZ);
      AppMethodBeat.o(43091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.kW(1, this.Dby.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DbB);
      int j = f.a.a.b.b.a.q(3, this.uKZ);
      AppMethodBeat.o(43091);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dby == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zz localzz = (zz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43091);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzz.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43091);
          return 0;
        case 2: 
          localzz.DbB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43091);
          return 0;
        }
        localzz.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(43091);
        return 0;
      }
      AppMethodBeat.o(43091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zz
 * JD-Core Version:    0.7.0.1
 */