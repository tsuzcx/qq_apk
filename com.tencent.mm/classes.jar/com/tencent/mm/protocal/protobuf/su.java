package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class su
  extends com.tencent.mm.bx.a
{
  public String FQe;
  public String FQf;
  public String FQg;
  public int FQh;
  public tg FQi;
  public int FQj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQe != null) {
        paramVarArgs.d(1, this.FQe);
      }
      if (this.FQf != null) {
        paramVarArgs.d(2, this.FQf);
      }
      if (this.FQg != null) {
        paramVarArgs.d(3, this.FQg);
      }
      paramVarArgs.aS(4, this.FQh);
      if (this.FQi != null)
      {
        paramVarArgs.lC(5, this.FQi.computeSize());
        this.FQi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FQj);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQe == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.FQe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FQf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FQf);
      }
      i = paramInt;
      if (this.FQg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQg);
      }
      i += f.a.a.b.b.a.bz(4, this.FQh);
      paramInt = i;
      if (this.FQi != null) {
        paramInt = i + f.a.a.a.lB(5, this.FQi.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.FQj);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        su localsu = (su)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localsu.FQe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localsu.FQf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localsu.FQg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localsu.FQh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsu.FQi = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localsu.FQj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.su
 * JD-Core Version:    0.7.0.1
 */