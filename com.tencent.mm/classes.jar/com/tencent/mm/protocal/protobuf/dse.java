package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dse
  extends cvp
{
  public int CreateTime;
  public String HEY;
  public String iht;
  public String ihw;
  public String nDo;
  public int xcK;
  public int xcL;
  public int xcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.ihw != null) {
        paramVarArgs.d(3, this.ihw);
      }
      if (this.HEY != null) {
        paramVarArgs.d(4, this.HEY);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      paramVarArgs.aS(6, this.xcK);
      paramVarArgs.aS(7, this.xcL);
      paramVarArgs.aS(8, this.xcM);
      paramVarArgs.aS(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.ihw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ihw);
      }
      paramInt = i;
      if (this.HEY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HEY);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.xcK);
      int j = f.a.a.b.b.a.bz(7, this.xcL);
      int k = f.a.a.b.b.a.bz(8, this.xcM);
      int m = f.a.a.b.b.a.bz(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dse localdse = (dse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
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
            localdse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localdse.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localdse.ihw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localdse.HEY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localdse.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localdse.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localdse.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localdse.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32485);
          return 0;
        }
        localdse.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dse
 * JD-Core Version:    0.7.0.1
 */