package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsz
  extends cld
{
  public int CNt;
  public String DLy;
  public int EHo;
  public int Efh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DLy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117956);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EHo);
      paramVarArgs.aR(3, this.CNt);
      if (this.DLy != null) {
        paramVarArgs.d(4, this.DLy);
      }
      paramVarArgs.aR(5, this.Efh);
      AppMethodBeat.o(117956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EHo) + f.a.a.b.b.a.bA(3, this.CNt);
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLy);
      }
      i = f.a.a.b.b.a.bA(5, this.Efh);
      AppMethodBeat.o(117956);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DLy == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsz localdsz = (dsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117956);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117956);
          return 0;
        case 2: 
          localdsz.EHo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117956);
          return 0;
        case 3: 
          localdsz.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117956);
          return 0;
        case 4: 
          localdsz.DLy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117956);
          return 0;
        }
        localdsz.Efh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117956);
        return 0;
      }
      AppMethodBeat.o(117956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsz
 * JD-Core Version:    0.7.0.1
 */