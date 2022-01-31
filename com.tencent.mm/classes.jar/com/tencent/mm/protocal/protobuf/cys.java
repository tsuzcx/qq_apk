package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cys
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String wxa;
  public int yfN;
  public int yfO;
  public cyv yfP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63696);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(63696);
        throw paramVarArgs;
      }
      if (this.wxa == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(63696);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.wxa != null) {
        paramVarArgs.e(2, this.wxa);
      }
      paramVarArgs.aO(3, this.yfN);
      paramVarArgs.aO(4, this.yfO);
      if (this.yfP != null)
      {
        paramVarArgs.iQ(5, this.yfP.computeSize());
        this.yfP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = e.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxa != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wxa);
      }
      i = i + e.a.a.b.b.a.bl(3, this.yfN) + e.a.a.b.b.a.bl(4, this.yfO);
      paramInt = i;
      if (this.yfP != null) {
        paramInt = i + e.a.a.a.iP(5, this.yfP.computeSize());
      }
      AppMethodBeat.o(63696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(63696);
          throw paramVarArgs;
        }
        if (this.wxa == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(63696);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cys localcys = (cys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63696);
          return -1;
        case 1: 
          localcys.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63696);
          return 0;
        case 2: 
          localcys.wxa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63696);
          return 0;
        case 3: 
          localcys.yfN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(63696);
          return 0;
        case 4: 
          localcys.yfO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(63696);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cyv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcys.yfP = ((cyv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63696);
        return 0;
      }
      AppMethodBeat.o(63696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cys
 * JD-Core Version:    0.7.0.1
 */