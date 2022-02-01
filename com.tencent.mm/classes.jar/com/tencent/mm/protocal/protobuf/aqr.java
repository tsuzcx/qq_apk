package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqr
  extends ckq
{
  public String Adv;
  public String CLS;
  public String DaJ;
  public String DrB;
  public String DrC;
  public String nCc;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DaJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.DrB == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.Adv == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.nCc == null)
      {
        paramVarArgs = new b("Not all required fields were included: nonce_str");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.signature == null)
      {
        paramVarArgs = new b("Not all required fields were included: signature");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.CLS == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DaJ != null) {
        paramVarArgs.d(2, this.DaJ);
      }
      if (this.DrB != null) {
        paramVarArgs.d(3, this.DrB);
      }
      if (this.Adv != null) {
        paramVarArgs.d(4, this.Adv);
      }
      if (this.nCc != null) {
        paramVarArgs.d(5, this.nCc);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.CLS != null) {
        paramVarArgs.d(7, this.CLS);
      }
      if (this.DrC != null) {
        paramVarArgs.d(8, this.DrC);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DaJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DaJ);
      }
      i = paramInt;
      if (this.DrB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DrB);
      }
      paramInt = i;
      if (this.Adv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Adv);
      }
      i = paramInt;
      if (this.nCc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nCc);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.CLS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CLS);
      }
      paramInt = i;
      if (this.DrC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DrC);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DaJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.DrB == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.Adv == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.nCc == null)
        {
          paramVarArgs = new b("Not all required fields were included: nonce_str");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.signature == null)
        {
          paramVarArgs = new b("Not all required fields were included: signature");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.CLS == null)
        {
          paramVarArgs = new b("Not all required fields were included: from_url");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqr localaqr = (aqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localaqr.DaJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localaqr.DrB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localaqr.Adv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localaqr.nCc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localaqr.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localaqr.CLS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localaqr.DrC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqr
 * JD-Core Version:    0.7.0.1
 */