package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cod
  extends buy
{
  public String jJA;
  public SKBuiltinBuffer_t pIA;
  public int pIx;
  public int pIy;
  public String xWU;
  public int xbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80201);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(80201);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIx);
      paramVarArgs.aO(3, this.pIy);
      paramVarArgs.aO(4, this.xbX);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(5, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      if (this.xWU != null) {
        paramVarArgs.e(6, this.xWU);
      }
      if (this.jJA != null) {
        paramVarArgs.e(7, this.jJA);
      }
      AppMethodBeat.o(80201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIx) + e.a.a.b.b.a.bl(3, this.pIy) + e.a.a.b.b.a.bl(4, this.xbX);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(5, this.pIA.computeSize());
      }
      i = paramInt;
      if (this.xWU != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xWU);
      }
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.jJA);
      }
      AppMethodBeat.o(80201);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(80201);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80201);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cod localcod = (cod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80201);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcod.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80201);
          return 0;
        case 2: 
          localcod.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80201);
          return 0;
        case 3: 
          localcod.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80201);
          return 0;
        case 4: 
          localcod.xbX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80201);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcod.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80201);
          return 0;
        case 6: 
          localcod.xWU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80201);
          return 0;
        }
        localcod.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80201);
        return 0;
      }
      AppMethodBeat.o(80201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cod
 * JD-Core Version:    0.7.0.1
 */