package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cft
  extends erp
{
  public String TpV;
  public String VEW;
  public String YWS;
  public String ZpC;
  public String aapj;
  public String signature;
  public String wDg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZpC == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.TpV == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.VEW == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.wDg == null)
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
      if (this.YWS == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZpC != null) {
        paramVarArgs.g(2, this.ZpC);
      }
      if (this.TpV != null) {
        paramVarArgs.g(3, this.TpV);
      }
      if (this.VEW != null) {
        paramVarArgs.g(4, this.VEW);
      }
      if (this.wDg != null) {
        paramVarArgs.g(5, this.wDg);
      }
      if (this.signature != null) {
        paramVarArgs.g(6, this.signature);
      }
      if (this.YWS != null) {
        paramVarArgs.g(7, this.YWS);
      }
      if (this.aapj != null) {
        paramVarArgs.g(8, this.aapj);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1000;
      }
    }
    label1000:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZpC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZpC);
      }
      i = paramInt;
      if (this.TpV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.TpV);
      }
      paramInt = i;
      if (this.VEW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VEW);
      }
      i = paramInt;
      if (this.wDg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wDg);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.signature);
      }
      i = paramInt;
      if (this.YWS != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YWS);
      }
      paramInt = i;
      if (this.aapj != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aapj);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZpC == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.TpV == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.VEW == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.wDg == null)
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
        if (this.YWS == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cft localcft = (cft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcft.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localcft.ZpC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localcft.TpV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localcft.VEW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localcft.wDg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localcft.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localcft.YWS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localcft.aapj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cft
 * JD-Core Version:    0.7.0.1
 */