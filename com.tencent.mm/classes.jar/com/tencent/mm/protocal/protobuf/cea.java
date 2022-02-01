package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cea
  extends erp
{
  public int aaog;
  public int aaoh;
  public String aaoi;
  public String aaoj;
  public String aaok;
  public int aaol;
  public String appid;
  public int count;
  public String desc;
  public String ext_info;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.aaoj == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaog);
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      paramVarArgs.bS(5, this.aaoh);
      if (this.aaoi != null) {
        paramVarArgs.g(6, this.aaoi);
      }
      paramVarArgs.bS(7, this.count);
      paramVarArgs.bS(8, this.scene);
      if (this.aaoj != null) {
        paramVarArgs.g(9, this.aaoj);
      }
      if (this.sign != null) {
        paramVarArgs.g(10, this.sign);
      }
      if (this.aaok != null) {
        paramVarArgs.g(11, this.aaok);
      }
      paramVarArgs.bS(12, this.aaol);
      if (this.ext_info != null) {
        paramVarArgs.g(13, this.ext_info);
      }
      AppMethodBeat.o(72476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1036;
      }
    }
    label1036:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaog);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.appid);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.desc);
      }
      i += i.a.a.b.b.a.cJ(5, this.aaoh);
      paramInt = i;
      if (this.aaoi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaoi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.count) + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.aaoj != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaoj);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.sign);
      }
      paramInt = i;
      if (this.aaok != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaok);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.aaol);
      paramInt = i;
      if (this.ext_info != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ext_info);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.aaoj == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
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
            localcea.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localcea.aaog = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localcea.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localcea.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localcea.aaoh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localcea.aaoi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localcea.count = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localcea.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localcea.aaoj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localcea.sign = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 11: 
          localcea.aaok = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 12: 
          localcea.aaol = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72476);
          return 0;
        }
        localcea.ext_info = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */