package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class api
  extends esc
{
  public apl Zwl;
  public apf Zwm;
  public apg Zwn;
  public String Zwo;
  public int Zwp;
  public int Zwq;
  public String Zwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zwl != null)
      {
        paramVarArgs.qD(2, this.Zwl.computeSize());
        this.Zwl.writeFields(paramVarArgs);
      }
      if (this.Zwm != null)
      {
        paramVarArgs.qD(3, this.Zwm.computeSize());
        this.Zwm.writeFields(paramVarArgs);
      }
      if (this.Zwn != null)
      {
        paramVarArgs.qD(4, this.Zwn.computeSize());
        this.Zwn.writeFields(paramVarArgs);
      }
      if (this.Zwo != null) {
        paramVarArgs.g(5, this.Zwo);
      }
      paramVarArgs.bS(6, this.Zwp);
      paramVarArgs.bS(7, this.Zwq);
      if (this.Zwr != null) {
        paramVarArgs.g(8, this.Zwr);
      }
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label956;
      }
    }
    label956:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zwl != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zwl.computeSize());
      }
      i = paramInt;
      if (this.Zwm != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zwm.computeSize());
      }
      paramInt = i;
      if (this.Zwn != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zwn.computeSize());
      }
      i = paramInt;
      if (this.Zwo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zwo);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.Zwp) + i.a.a.b.b.a.cJ(7, this.Zwq);
      paramInt = i;
      if (this.Zwr != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zwr);
      }
      AppMethodBeat.o(32202);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        api localapi = (api)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localapi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apl)localObject2).parseFrom((byte[])localObject1);
            }
            localapi.Zwl = ((apl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apf)localObject2).parseFrom((byte[])localObject1);
            }
            localapi.Zwm = ((apf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apg)localObject2).parseFrom((byte[])localObject1);
            }
            localapi.Zwn = ((apg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localapi.Zwo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localapi.Zwp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32202);
          return 0;
        case 7: 
          localapi.Zwq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32202);
          return 0;
        }
        localapi.Zwr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.api
 * JD-Core Version:    0.7.0.1
 */