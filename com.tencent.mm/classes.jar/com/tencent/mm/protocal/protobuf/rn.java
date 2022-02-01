package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rn
  extends erp
{
  public int Tps;
  public String YWx;
  public com.tencent.mm.bx.b YWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257573);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWx == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(257573);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YWx != null) {
        paramVarArgs.g(2, this.YWx);
      }
      paramVarArgs.bS(3, this.Tps);
      if (this.YWy != null) {
        paramVarArgs.d(4, this.YWy);
      }
      AppMethodBeat.o(257573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YWx != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YWx);
      }
      i += i.a.a.b.b.a.cJ(3, this.Tps);
      paramInt = i;
      if (this.YWy != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YWy);
      }
      AppMethodBeat.o(257573);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YWx == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(257573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        rn localrn = (rn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257573);
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
            localrn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257573);
          return 0;
        case 2: 
          localrn.YWx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257573);
          return 0;
        case 3: 
          localrn.Tps = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257573);
          return 0;
        }
        localrn.YWy = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257573);
        return 0;
      }
      AppMethodBeat.o(257573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rn
 * JD-Core Version:    0.7.0.1
 */