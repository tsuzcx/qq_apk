package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chw
  extends cvp
{
  public String AesKey;
  public String Gjr;
  public int HbA;
  public String HbB;
  public int HbC;
  public String Hbw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(195476);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hbw != null) {
        paramVarArgs.d(2, this.Hbw);
      }
      if (this.Gjr != null) {
        paramVarArgs.d(3, this.Gjr);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(4, this.AesKey);
      }
      paramVarArgs.aS(6, this.HbA);
      if (this.HbB != null) {
        paramVarArgs.d(8, this.HbB);
      }
      paramVarArgs.aS(9, this.HbC);
      AppMethodBeat.o(195476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hbw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hbw);
      }
      i = paramInt;
      if (this.Gjr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gjr);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.AesKey);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HbA);
      paramInt = i;
      if (this.HbB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HbB);
      }
      i = f.a.a.b.b.a.bz(9, this.HbC);
      AppMethodBeat.o(195476);
      return paramInt + i;
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
          AppMethodBeat.o(195476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chw localchw = (chw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(195476);
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
            localchw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195476);
          return 0;
        case 2: 
          localchw.Hbw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(195476);
          return 0;
        case 3: 
          localchw.Gjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(195476);
          return 0;
        case 4: 
          localchw.AesKey = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(195476);
          return 0;
        case 6: 
          localchw.HbA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(195476);
          return 0;
        case 8: 
          localchw.HbB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(195476);
          return 0;
        }
        localchw.HbC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(195476);
        return 0;
      }
      AppMethodBeat.o(195476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chw
 * JD-Core Version:    0.7.0.1
 */