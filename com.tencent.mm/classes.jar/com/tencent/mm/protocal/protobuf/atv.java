package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class atv
  extends cpx
{
  public String BvP;
  public String EMD;
  public String EME;
  public String Eeu;
  public String EtG;
  public String ofc;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EtG == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.EMD == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BvP == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.ofc == null)
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
      if (this.Eeu == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EtG != null) {
        paramVarArgs.d(2, this.EtG);
      }
      if (this.EMD != null) {
        paramVarArgs.d(3, this.EMD);
      }
      if (this.BvP != null) {
        paramVarArgs.d(4, this.BvP);
      }
      if (this.ofc != null) {
        paramVarArgs.d(5, this.ofc);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.Eeu != null) {
        paramVarArgs.d(7, this.Eeu);
      }
      if (this.EME != null) {
        paramVarArgs.d(8, this.EME);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EtG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EtG);
      }
      i = paramInt;
      if (this.EMD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EMD);
      }
      paramInt = i;
      if (this.BvP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BvP);
      }
      i = paramInt;
      if (this.ofc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ofc);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.Eeu != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Eeu);
      }
      paramInt = i;
      if (this.EME != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EME);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EtG == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.EMD == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.BvP == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.ofc == null)
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
        if (this.Eeu == null)
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
        atv localatv = (atv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localatv.EtG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localatv.EMD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localatv.BvP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localatv.ofc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localatv.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localatv.Eeu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localatv.EME = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atv
 * JD-Core Version:    0.7.0.1
 */