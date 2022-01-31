package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gv
  extends com.tencent.mm.bv.a
{
  public String ID;
  public int Ret;
  public SKBuiltinBuffer_t wtg;
  public String wth;
  public int wti;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28331);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(28331);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.wtg != null)
      {
        paramVarArgs.iQ(2, this.wtg.computeSize());
        this.wtg.writeFields(paramVarArgs);
      }
      if (this.wth != null) {
        paramVarArgs.e(3, this.wth);
      }
      paramVarArgs.aO(4, this.wti);
      if (this.ID != null) {
        paramVarArgs.e(5, this.ID);
      }
      AppMethodBeat.o(28331);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.wtg != null) {
        paramInt = i + e.a.a.a.iP(2, this.wtg.computeSize());
      }
      i = paramInt;
      if (this.wth != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wth);
      }
      i += e.a.a.b.b.a.bl(4, this.wti);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ID);
      }
      AppMethodBeat.o(28331);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wtg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(28331);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28331);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      gv localgv = (gv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28331);
        return -1;
      case 1: 
        localgv.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28331);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgv.wtg = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28331);
        return 0;
      case 3: 
        localgv.wth = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28331);
        return 0;
      case 4: 
        localgv.wti = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28331);
        return 0;
      }
      localgv.ID = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(28331);
      return 0;
    }
    AppMethodBeat.o(28331);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gv
 * JD-Core Version:    0.7.0.1
 */