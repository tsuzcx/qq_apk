package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class atx
  extends cld
{
  public String CWC;
  public float DtT;
  public String DtU;
  public String action_data;
  public int ntx;
  public String nty;
  public String person_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.person_id != null) {
        paramVarArgs.d(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(5, this.action_data);
      }
      paramVarArgs.x(6, this.DtT);
      if (this.CWC != null) {
        paramVarArgs.d(7, this.CWC);
      }
      if (this.DtU != null) {
        paramVarArgs.d(8, this.DtU);
      }
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label753;
      }
    }
    label753:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.action_data);
      }
      i = paramInt + (f.a.a.b.b.a.fY(6) + 4);
      paramInt = i;
      if (this.CWC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CWC);
      }
      i = paramInt;
      if (this.DtU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DtU);
      }
      AppMethodBeat.o(104370);
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
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atx localatx = (atx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
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
            localatx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localatx.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localatx.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localatx.person_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localatx.action_data = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localatx.DtT = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localatx.CWC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104370);
          return 0;
        }
        localatx.DtU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atx
 * JD-Core Version:    0.7.0.1
 */