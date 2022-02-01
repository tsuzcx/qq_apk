package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqj
  extends cvw
{
  public String GmU;
  public String HWW;
  public String HXn;
  public String dwj;
  public String yoT;
  public String yoZ;
  public String ypa;
  public long yrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72605);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwj == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.ypa == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.yoZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.yoT == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwj != null) {
        paramVarArgs.d(2, this.dwj);
      }
      if (this.ypa != null) {
        paramVarArgs.d(3, this.ypa);
      }
      if (this.yoZ != null) {
        paramVarArgs.d(4, this.yoZ);
      }
      if (this.yoT != null) {
        paramVarArgs.d(5, this.yoT);
      }
      paramVarArgs.aZ(6, this.yrf);
      if (this.GmU != null) {
        paramVarArgs.d(7, this.GmU);
      }
      if (this.HWW != null) {
        paramVarArgs.d(8, this.HWW);
      }
      if (this.HXn != null) {
        paramVarArgs.d(9, this.HXn);
      }
      AppMethodBeat.o(72605);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwj);
      }
      i = paramInt;
      if (this.ypa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ypa);
      }
      paramInt = i;
      if (this.yoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yoZ);
      }
      i = paramInt;
      if (this.yoT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.yoT);
      }
      i += f.a.a.b.b.a.p(6, this.yrf);
      paramInt = i;
      if (this.GmU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GmU);
      }
      i = paramInt;
      if (this.HWW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HWW);
      }
      paramInt = i;
      if (this.HXn != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HXn);
      }
      AppMethodBeat.o(72605);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.dwj == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.ypa == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.yoZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.yoT == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72605);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqj localdqj = (dqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72605);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72605);
          return 0;
        case 2: 
          localdqj.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 3: 
          localdqj.ypa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 4: 
          localdqj.yoZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 5: 
          localdqj.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 6: 
          localdqj.yrf = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72605);
          return 0;
        case 7: 
          localdqj.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 8: 
          localdqj.HWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72605);
          return 0;
        }
        localdqj.HXn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72605);
        return 0;
      }
      AppMethodBeat.o(72605);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqj
 * JD-Core Version:    0.7.0.1
 */