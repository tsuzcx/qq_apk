package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vq
  extends cvw
{
  public String GmU;
  public String dwj;
  public String yoT;
  public String yoZ;
  public String ypa;
  public long yrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwj == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.ypa == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.yoZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.yoT == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72450);
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
      AppMethodBeat.o(72450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label850;
      }
    }
    label850:
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
      AppMethodBeat.o(72450);
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
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.ypa == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.yoZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.yoT == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vq localvq = (vq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72450);
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
            localvq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72450);
          return 0;
        case 2: 
          localvq.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 3: 
          localvq.ypa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 4: 
          localvq.yoZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 5: 
          localvq.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 6: 
          localvq.yrf = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72450);
          return 0;
        }
        localvq.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72450);
        return 0;
      }
      AppMethodBeat.o(72450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vq
 * JD-Core Version:    0.7.0.1
 */