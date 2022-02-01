package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auu
  extends erp
{
  public String ZFi;
  public String finderUsername;
  public long hKN;
  public long liveId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257817);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.liveId);
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      paramVarArgs.bv(4, this.hKN);
      if (this.ZFi != null) {
        paramVarArgs.g(5, this.ZFi);
      }
      paramVarArgs.bS(6, this.scene);
      AppMethodBeat.o(257817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.liveId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.hKN);
      paramInt = i;
      if (this.ZFi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZFi);
      }
      i = i.a.a.b.b.a.cJ(6, this.scene);
      AppMethodBeat.o(257817);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        auu localauu = (auu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257817);
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
            localauu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257817);
          return 0;
        case 2: 
          localauu.liveId = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257817);
          return 0;
        case 3: 
          localauu.finderUsername = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257817);
          return 0;
        case 4: 
          localauu.hKN = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257817);
          return 0;
        case 5: 
          localauu.ZFi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257817);
          return 0;
        }
        localauu.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257817);
        return 0;
      }
      AppMethodBeat.o(257817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auu
 * JD-Core Version:    0.7.0.1
 */