package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czm
  extends cld
{
  public int CBy;
  public String Dbd;
  public gt Ejf;
  public gx Ero;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123658);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123658);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ejf != null)
      {
        paramVarArgs.kX(2, this.Ejf.computeSize());
        this.Ejf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CBy);
      if (this.Ero != null)
      {
        paramVarArgs.kX(4, this.Ero.computeSize());
        this.Ero.writeFields(paramVarArgs);
      }
      if (this.Dbd != null) {
        paramVarArgs.d(5, this.Dbd);
      }
      AppMethodBeat.o(123658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ejf != null) {
        i = paramInt + f.a.a.a.kW(2, this.Ejf.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.CBy);
      paramInt = i;
      if (this.Ero != null) {
        paramInt = i + f.a.a.a.kW(4, this.Ero.computeSize());
      }
      i = paramInt;
      if (this.Dbd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dbd);
      }
      AppMethodBeat.o(123658);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czm localczm = (czm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123658);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczm.Ejf = ((gt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 3: 
          localczm.CBy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123658);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczm.Ero = ((gx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        }
        localczm.Dbd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123658);
        return 0;
      }
      AppMethodBeat.o(123658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czm
 * JD-Core Version:    0.7.0.1
 */