package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ale
  extends com.tencent.mm.bx.a
{
  public alb Dmy;
  public String desc;
  public String dqA;
  public String iconUrl;
  public int qSS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dqA != null) {
        paramVarArgs.d(1, this.dqA);
      }
      paramVarArgs.aR(2, this.qSS);
      if (this.iconUrl != null) {
        paramVarArgs.d(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.Dmy != null)
      {
        paramVarArgs.kX(5, this.Dmy.computeSize());
        this.Dmy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dqA == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.dqA) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.qSS);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      paramInt = i;
      if (this.Dmy != null) {
        paramInt = i + f.a.a.a.kW(5, this.Dmy.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ale localale = (ale)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localale.dqA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localale.qSS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localale.iconUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localale.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localale.Dmy = ((alb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ale
 * JD-Core Version:    0.7.0.1
 */