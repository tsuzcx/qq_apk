package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eag
  extends com.tencent.mm.bx.a
{
  public LinkedList<dzi> HMK;
  public dzb HMV;
  public int HNi;
  
  public eag()
  {
    AppMethodBeat.i(147818);
    this.HMK = new LinkedList();
    AppMethodBeat.o(147818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147819);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMV == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147819);
        throw paramVarArgs;
      }
      if (this.HMV != null)
      {
        paramVarArgs.lC(1, this.HMV.computeSize());
        this.HMV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.HMK);
      paramVarArgs.aS(3, this.HNi);
      AppMethodBeat.o(147819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMV == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.a.lB(1, this.HMV.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.HMK);
      int j = f.a.a.b.b.a.bz(3, this.HNi);
      AppMethodBeat.o(147819);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HMK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HMV == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147819);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eag localeag = (eag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147819);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeag.HMV = ((dzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeag.HMK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        }
        localeag.HNi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147819);
        return 0;
      }
      AppMethodBeat.o(147819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eag
 * JD-Core Version:    0.7.0.1
 */