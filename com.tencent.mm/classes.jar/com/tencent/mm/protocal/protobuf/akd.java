package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akd
  extends bvk
{
  public com.tencent.mm.bv.b xbn;
  public int xbo;
  public com.tencent.mm.bv.b xbp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80072);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80072);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xbo);
      if (this.xbp != null) {
        paramVarArgs.c(4, this.xbp);
      }
      if (this.xbn != null) {
        paramVarArgs.c(5, this.xbn);
      }
      AppMethodBeat.o(80072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(3, this.xbo);
      paramInt = i;
      if (this.xbp != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xbp);
      }
      i = paramInt;
      if (this.xbn != null) {
        i = paramInt + e.a.a.b.b.a.b(5, this.xbn);
      }
      AppMethodBeat.o(80072);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80072);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80072);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        akd localakd = (akd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(80072);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localakd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80072);
          return 0;
        case 3: 
          localakd.xbo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80072);
          return 0;
        case 4: 
          localakd.xbp = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(80072);
          return 0;
        }
        localakd.xbn = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(80072);
        return 0;
      }
      AppMethodBeat.o(80072);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akd
 * JD-Core Version:    0.7.0.1
 */