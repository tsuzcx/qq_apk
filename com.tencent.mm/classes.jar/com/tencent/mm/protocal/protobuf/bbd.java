package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbd
  extends cvp
{
  public String FWx;
  public float Gyi;
  public String Gyj;
  public String action_data;
  public int ozR;
  public String ozS;
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.person_id != null) {
        paramVarArgs.d(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(5, this.action_data);
      }
      paramVarArgs.z(6, this.Gyi);
      if (this.FWx != null) {
        paramVarArgs.d(7, this.FWx);
      }
      if (this.Gyj != null) {
        paramVarArgs.d(8, this.Gyj);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.action_data);
      }
      i = paramInt + f.a.a.b.b.a.alU(6);
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWx);
      }
      i = paramInt;
      if (this.Gyj != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gyj);
      }
      AppMethodBeat.o(104370);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        bbd localbbd = (bbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localbbd.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localbbd.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localbbd.person_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localbbd.action_data = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localbbd.Gyi = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localbbd.FWx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104370);
          return 0;
        }
        localbbd.Gyj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbd
 * JD-Core Version:    0.7.0.1
 */