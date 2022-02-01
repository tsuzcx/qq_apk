package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hg
  extends com.tencent.mm.bw.a
{
  public String KCL;
  public EmotionPrice KKQ;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.KKQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Price");
        AppMethodBeat.o(104745);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      if (this.KKQ != null)
      {
        paramVarArgs.ni(2, this.KKQ.computeSize());
        this.KKQ.writeFields(paramVarArgs);
      }
      if (this.KCL != null) {
        paramVarArgs.e(3, this.KCL);
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
    for (int i = g.a.a.b.b.a.f(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KKQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.KKQ.computeSize());
      }
      i = paramInt;
      if (this.KCL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KCL);
      }
      AppMethodBeat.o(104745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104745);
          throw paramVarArgs;
        }
        if (this.KKQ == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hg localhg = (hg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104745);
          return -1;
        case 1: 
          localhg.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104745);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionPrice();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionPrice)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhg.KKQ = ((EmotionPrice)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104745);
          return 0;
        }
        localhg.KCL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104745);
        return 0;
      }
      AppMethodBeat.o(104745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hg
 * JD-Core Version:    0.7.0.1
 */