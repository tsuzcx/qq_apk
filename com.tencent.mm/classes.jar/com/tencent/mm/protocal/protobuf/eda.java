package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eda
  extends com.tencent.mm.bw.a
{
  public String Iie;
  public se Iif;
  public boolean Iig;
  public String Iih;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iie != null) {
        paramVarArgs.d(1, this.Iie);
      }
      if (this.Iif != null)
      {
        paramVarArgs.lJ(2, this.Iif.computeSize());
        this.Iif.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.Iig);
      if (this.Iih != null) {
        paramVarArgs.d(4, this.Iih);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iie == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.Iie) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Iif != null) {
        i = paramInt + f.a.a.a.lI(2, this.Iif.computeSize());
      }
      i += f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.Iih != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Iih);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eda localeda = (eda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localeda.Iie = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new se();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((se)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeda.Iif = ((se)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localeda.Iig = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91731);
          return 0;
        }
        localeda.Iih = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eda
 * JD-Core Version:    0.7.0.1
 */