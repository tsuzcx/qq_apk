package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egq
  extends erp
{
  public String ZoT;
  public int aarV;
  public long ihV;
  public String request_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259192);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.g(2, this.request_id);
      }
      paramVarArgs.bv(3, this.ihV);
      paramVarArgs.bS(4, this.aarV);
      if (this.ZoT != null) {
        paramVarArgs.g(101, this.ZoT);
      }
      AppMethodBeat.o(259192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.request_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.request_id);
      }
      i = i + i.a.a.b.b.a.q(3, this.ihV) + i.a.a.b.b.a.cJ(4, this.aarV);
      paramInt = i;
      if (this.ZoT != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.ZoT);
      }
      AppMethodBeat.o(259192);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        egq localegq = (egq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259192);
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
            localegq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259192);
          return 0;
        case 2: 
          localegq.request_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259192);
          return 0;
        case 3: 
          localegq.ihV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259192);
          return 0;
        case 4: 
          localegq.aarV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259192);
          return 0;
        }
        localegq.ZoT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259192);
        return 0;
      }
      AppMethodBeat.o(259192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egq
 * JD-Core Version:    0.7.0.1
 */