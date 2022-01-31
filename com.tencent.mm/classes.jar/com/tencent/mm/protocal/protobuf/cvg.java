package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cvg
  extends com.tencent.mm.bv.a
{
  public String wwk;
  public String wwl;
  public SKBuiltinBuffer_t wwo;
  public String ydL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58939);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wwo == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(58939);
        throw paramVarArgs;
      }
      if (this.wwk != null) {
        paramVarArgs.e(1, this.wwk);
      }
      if (this.wwl != null) {
        paramVarArgs.e(2, this.wwl);
      }
      if (this.ydL != null) {
        paramVarArgs.e(3, this.ydL);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(4, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wwk == null) {
        break label538;
      }
    }
    label538:
    for (int i = e.a.a.b.b.a.f(1, this.wwk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wwl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wwl);
      }
      i = paramInt;
      if (this.ydL != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ydL);
      }
      paramInt = i;
      if (this.wwo != null) {
        paramInt = i + e.a.a.a.iP(4, this.wwo.computeSize());
      }
      AppMethodBeat.o(58939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wwo == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(58939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58939);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvg localcvg = (cvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58939);
          return -1;
        case 1: 
          localcvg.wwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58939);
          return 0;
        case 2: 
          localcvg.wwl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58939);
          return 0;
        case 3: 
          localcvg.ydL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58939);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcvg.wwo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58939);
        return 0;
      }
      AppMethodBeat.o(58939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvg
 * JD-Core Version:    0.7.0.1
 */