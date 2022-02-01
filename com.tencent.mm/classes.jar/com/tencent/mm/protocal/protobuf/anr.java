package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class anr
  extends erp
{
  public b ZoR;
  public b ZoS;
  public String ZoT;
  public String Zvp;
  public int action;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260240);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZoR != null) {
        paramVarArgs.d(2, this.ZoR);
      }
      if (this.ZoS != null) {
        paramVarArgs.d(3, this.ZoS);
      }
      if (this.token != null) {
        paramVarArgs.g(4, this.token);
      }
      if (this.Zvp != null) {
        paramVarArgs.g(5, this.Zvp);
      }
      paramVarArgs.bS(6, this.action);
      if (this.ZoT != null) {
        paramVarArgs.g(101, this.ZoT);
      }
      AppMethodBeat.o(260240);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZoR != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZoR);
      }
      i = paramInt;
      if (this.ZoS != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZoS);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.token);
      }
      i = paramInt;
      if (this.Zvp != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zvp);
      }
      i += i.a.a.b.b.a.cJ(6, this.action);
      paramInt = i;
      if (this.ZoT != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.ZoT);
      }
      AppMethodBeat.o(260240);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260240);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        anr localanr = (anr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260240);
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
            localanr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(260240);
          return 0;
        case 2: 
          localanr.ZoR = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(260240);
          return 0;
        case 3: 
          localanr.ZoS = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(260240);
          return 0;
        case 4: 
          localanr.token = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260240);
          return 0;
        case 5: 
          localanr.Zvp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260240);
          return 0;
        case 6: 
          localanr.action = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260240);
          return 0;
        }
        localanr.ZoT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260240);
        return 0;
      }
      AppMethodBeat.o(260240);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anr
 * JD-Core Version:    0.7.0.1
 */