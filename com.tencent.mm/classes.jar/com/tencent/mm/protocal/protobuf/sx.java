package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sx
  extends com.tencent.mm.bx.a
{
  public String FQA;
  public tg FQB;
  public String FQy;
  public int FQz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQy != null) {
        paramVarArgs.d(1, this.FQy);
      }
      paramVarArgs.aS(2, this.FQz);
      if (this.FQA != null) {
        paramVarArgs.d(3, this.FQA);
      }
      if (this.FQB != null)
      {
        paramVarArgs.lC(4, this.FQB.computeSize());
        this.FQB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQy == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.FQy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FQz);
      paramInt = i;
      if (this.FQA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FQA);
      }
      i = paramInt;
      if (this.FQB != null) {
        i = paramInt + f.a.a.a.lB(4, this.FQB.computeSize());
      }
      AppMethodBeat.o(113956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localsx.FQy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localsx.FQz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localsx.FQA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113956);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsx.FQB = ((tg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */