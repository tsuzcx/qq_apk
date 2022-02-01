package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ij
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public cmc Cvq;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.Cvq != null)
      {
        paramVarArgs.kX(2, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      if (this.CDW != null) {
        paramVarArgs.d(3, this.CDW);
      }
      AppMethodBeat.o(91360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cvq != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cvq.computeSize());
      }
      i = paramInt;
      if (this.CDW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CDW);
      }
      AppMethodBeat.o(91360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ij localij = (ij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91360);
          return -1;
        case 1: 
          localij.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91360);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localij.Cvq = ((cmc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91360);
          return 0;
        }
        localij.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91360);
        return 0;
      }
      AppMethodBeat.o(91360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ij
 * JD-Core Version:    0.7.0.1
 */