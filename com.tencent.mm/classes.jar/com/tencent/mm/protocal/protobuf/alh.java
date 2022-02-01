package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alh
  extends erp
{
  public String appid;
  public String key;
  public String query;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123568);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.key != null) {
        paramVarArgs.g(2, this.key);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.query != null) {
        paramVarArgs.g(4, this.query);
      }
      paramVarArgs.bS(5, this.scene);
      if (this.url != null) {
        paramVarArgs.g(6, this.url);
      }
      AppMethodBeat.o(123568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.key != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.key);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.query);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.url);
      }
      AppMethodBeat.o(123568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        alh localalh = (alh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123568);
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
            localalh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123568);
          return 0;
        case 2: 
          localalh.key = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 3: 
          localalh.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 4: 
          localalh.query = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 5: 
          localalh.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123568);
          return 0;
        }
        localalh.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123568);
        return 0;
      }
      AppMethodBeat.o(123568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alh
 * JD-Core Version:    0.7.0.1
 */