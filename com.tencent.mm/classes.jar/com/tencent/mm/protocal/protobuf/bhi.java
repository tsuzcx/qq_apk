package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhi
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wuq;
  public int xws;
  public String xwt;
  public SKBuiltinBuffer_t xwu;
  public int xwv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28562);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xwu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(28562);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xws);
      if (this.wuq != null) {
        paramVarArgs.c(2, this.wuq);
      }
      if (this.xwt != null) {
        paramVarArgs.e(3, this.xwt);
      }
      if (this.xwu != null)
      {
        paramVarArgs.iQ(4, this.xwu.computeSize());
        this.xwu.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xwv);
      AppMethodBeat.o(28562);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xws) + 0;
      paramInt = i;
      if (this.wuq != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wuq);
      }
      i = paramInt;
      if (this.xwt != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xwt);
      }
      paramInt = i;
      if (this.xwu != null) {
        paramInt = i + e.a.a.a.iP(4, this.xwu.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xwv);
      AppMethodBeat.o(28562);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xwu == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(28562);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28562);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bhi localbhi = (bhi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28562);
        return -1;
      case 1: 
        localbhi.xws = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28562);
        return 0;
      case 2: 
        localbhi.wuq = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(28562);
        return 0;
      case 3: 
        localbhi.xwt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28562);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbhi.xwu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28562);
        return 0;
      }
      localbhi.xwv = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(28562);
      return 0;
    }
    AppMethodBeat.o(28562);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */