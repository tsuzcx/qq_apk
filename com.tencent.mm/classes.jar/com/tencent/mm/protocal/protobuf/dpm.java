package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpm
  extends cvc
{
  public String FUv;
  public String HDA;
  public String HDj;
  public String dve;
  public String xZb;
  public String xZh;
  public String xZi;
  public long ybo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72605);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dve == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.xZi == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.xZh == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.xZb == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72605);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dve != null) {
        paramVarArgs.d(2, this.dve);
      }
      if (this.xZi != null) {
        paramVarArgs.d(3, this.xZi);
      }
      if (this.xZh != null) {
        paramVarArgs.d(4, this.xZh);
      }
      if (this.xZb != null) {
        paramVarArgs.d(5, this.xZb);
      }
      paramVarArgs.aY(6, this.ybo);
      if (this.FUv != null) {
        paramVarArgs.d(7, this.FUv);
      }
      if (this.HDj != null) {
        paramVarArgs.d(8, this.HDj);
      }
      if (this.HDA != null) {
        paramVarArgs.d(9, this.HDA);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dve != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dve);
      }
      i = paramInt;
      if (this.xZi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xZi);
      }
      paramInt = i;
      if (this.xZh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xZh);
      }
      i = paramInt;
      if (this.xZb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xZb);
      }
      i += f.a.a.b.b.a.p(6, this.ybo);
      paramInt = i;
      if (this.FUv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FUv);
      }
      i = paramInt;
      if (this.HDj != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HDj);
      }
      paramInt = i;
      if (this.HDA != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HDA);
      }
      AppMethodBeat.o(72605);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.dve == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.xZi == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.xZh == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72605);
          throw paramVarArgs;
        }
        if (this.xZb == null)
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
        dpm localdpm = (dpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72605);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72605);
          return 0;
        case 2: 
          localdpm.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 3: 
          localdpm.xZi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 4: 
          localdpm.xZh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 5: 
          localdpm.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 6: 
          localdpm.ybo = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72605);
          return 0;
        case 7: 
          localdpm.FUv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        case 8: 
          localdpm.HDj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72605);
          return 0;
        }
        localdpm.HDA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72605);
        return 0;
      }
      AppMethodBeat.o(72605);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpm
 * JD-Core Version:    0.7.0.1
 */