package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gi
  extends com.tencent.mm.bx.a
{
  public EmotionPrice CAU;
  public String Ctz;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.CAU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Price");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.d(1, this.ProductID);
      }
      if (this.CAU != null)
      {
        paramVarArgs.kX(2, this.CAU.computeSize());
        this.CAU.writeFields(paramVarArgs);
      }
      if (this.Ctz != null) {
        paramVarArgs.d(3, this.Ctz);
      }
      AppMethodBeat.o(104745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.b.b.a.e(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CAU != null) {
        paramInt = i + f.a.a.a.kW(2, this.CAU.computeSize());
      }
      i = paramInt;
      if (this.Ctz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ctz);
      }
      AppMethodBeat.o(104745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        if (this.CAU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Price");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104745);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gi localgi = (gi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104745);
          return -1;
        case 1: 
          localgi.ProductID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104745);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionPrice();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionPrice)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgi.CAU = ((EmotionPrice)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104745);
          return 0;
        }
        localgi.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104745);
        return 0;
      }
      AppMethodBeat.o(104745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gi
 * JD-Core Version:    0.7.0.1
 */