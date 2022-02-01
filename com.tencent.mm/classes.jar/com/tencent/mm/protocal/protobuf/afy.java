package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class afy
  extends erp
{
  public String YJY;
  public String ZoO;
  public String ZoP;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZoO == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.YJY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.ZoP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZoO != null) {
        paramVarArgs.g(2, this.ZoO);
      }
      if (this.YJY != null) {
        paramVarArgs.g(3, this.YJY);
      }
      if (this.ZoP != null) {
        paramVarArgs.g(4, this.ZoP);
      }
      if (this.oOI != null) {
        paramVarArgs.g(5, this.oOI);
      }
      AppMethodBeat.o(32172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label735;
      }
    }
    label735:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZoO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZoO);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YJY);
      }
      paramInt = i;
      if (this.ZoP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZoP);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.oOI);
      }
      AppMethodBeat.o(32172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZoO == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.YJY == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.ZoP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        afy localafy = (afy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32172);
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
            localafy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32172);
          return 0;
        case 2: 
          localafy.ZoO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 3: 
          localafy.YJY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 4: 
          localafy.ZoP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32172);
          return 0;
        }
        localafy.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32172);
        return 0;
      }
      AppMethodBeat.o(32172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afy
 * JD-Core Version:    0.7.0.1
 */