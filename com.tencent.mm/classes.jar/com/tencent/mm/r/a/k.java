package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class k
  extends erp
{
  public String appId;
  public String mdN;
  public String mdO;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231422);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.g(2, this.appId);
      }
      if (this.mdN != null) {
        paramVarArgs.g(3, this.mdN);
      }
      if (this.uxInfo != null) {
        paramVarArgs.g(4, this.uxInfo);
      }
      if (this.mdO != null) {
        paramVarArgs.g(5, this.mdO);
      }
      AppMethodBeat.o(231422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appId);
      }
      i = paramInt;
      if (this.mdN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdN);
      }
      paramInt = i;
      if (this.uxInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.uxInfo);
      }
      i = paramInt;
      if (this.mdO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mdO);
      }
      AppMethodBeat.o(231422);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231422);
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
            localk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(231422);
          return 0;
        case 2: 
          localk.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231422);
          return 0;
        case 3: 
          localk.mdN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231422);
          return 0;
        case 4: 
          localk.uxInfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231422);
          return 0;
        }
        localk.mdO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(231422);
        return 0;
      }
      AppMethodBeat.o(231422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.k
 * JD-Core Version:    0.7.0.1
 */