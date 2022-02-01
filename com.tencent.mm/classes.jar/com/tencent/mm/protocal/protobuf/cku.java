package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cku
  extends cld
{
  public String DSY;
  public int DTa;
  public String DTl;
  public int Ega;
  public int Egb;
  public String rcq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.rcq != null) {
        paramVarArgs.d(2, this.rcq);
      }
      if (this.DSY != null) {
        paramVarArgs.d(3, this.DSY);
      }
      paramVarArgs.aR(4, this.Ega);
      paramVarArgs.aR(5, this.Egb);
      paramVarArgs.aR(6, this.DTa);
      if (this.DTl != null) {
        paramVarArgs.d(7, this.DTl);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rcq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rcq);
      }
      i = paramInt;
      if (this.DSY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSY);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Ega) + f.a.a.b.b.a.bA(5, this.Egb) + f.a.a.b.b.a.bA(6, this.DTa);
      paramInt = i;
      if (this.DTl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DTl);
      }
      AppMethodBeat.o(91672);
      return paramInt;
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
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cku localcku = (cku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
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
            localcku.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localcku.rcq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localcku.DSY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localcku.Ega = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localcku.Egb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localcku.DTa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91672);
          return 0;
        }
        localcku.DTl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cku
 * JD-Core Version:    0.7.0.1
 */