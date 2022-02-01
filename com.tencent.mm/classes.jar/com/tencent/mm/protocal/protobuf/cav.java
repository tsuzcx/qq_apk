package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cav
  extends com.tencent.mm.bx.a
{
  public long aajP;
  public LinkedList<czv> aajQ;
  public LinkedList<fxz> aajR;
  public String name;
  public long startTime;
  
  public cav()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.aajP = 0L;
    this.aajQ = new LinkedList();
    this.aajR = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bv(2, this.startTime);
      paramVarArgs.bv(3, this.aajP);
      paramVarArgs.e(4, 8, this.aajQ);
      paramVarArgs.e(5, 8, this.aajR);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.startTime);
      int j = i.a.a.b.b.a.q(3, this.aajP);
      int k = i.a.a.a.c(4, 8, this.aajQ);
      int m = i.a.a.a.c(5, 8, this.aajR);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajQ.clear();
        this.aajR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cav localcav = (cav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localcav.name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localcav.startTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localcav.aajP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(122500);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czv)localObject2).parseFrom((byte[])localObject1);
            }
            localcav.aajQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fxz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fxz)localObject2).parseFrom((byte[])localObject1);
          }
          localcav.aajR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      AppMethodBeat.o(122500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cav
 * JD-Core Version:    0.7.0.1
 */