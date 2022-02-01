package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class ba
  extends erp
{
  public String ToK;
  public String TpK;
  public int Tqd;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289926);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TpK != null) {
        paramVarArgs.g(2, this.TpK);
      }
      if (this.ToK != null) {
        paramVarArgs.g(3, this.ToK);
      }
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      paramVarArgs.bS(5, this.Tqd);
      paramVarArgs.bS(6, this.type);
      AppMethodBeat.o(289926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TpK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.TpK);
      }
      i = paramInt;
      if (this.ToK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToK);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = i.a.a.b.b.a.cJ(5, this.Tqd);
      int j = i.a.a.b.b.a.cJ(6, this.type);
      AppMethodBeat.o(289926);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289926);
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
            localba.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(289926);
          return 0;
        case 2: 
          localba.TpK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289926);
          return 0;
        case 3: 
          localba.ToK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289926);
          return 0;
        case 4: 
          localba.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289926);
          return 0;
        case 5: 
          localba.Tqd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289926);
          return 0;
        }
        localba.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(289926);
        return 0;
      }
      AppMethodBeat.o(289926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ba
 * JD-Core Version:    0.7.0.1
 */