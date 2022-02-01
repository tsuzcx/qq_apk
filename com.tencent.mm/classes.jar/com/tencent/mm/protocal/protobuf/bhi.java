package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhi
  extends erp
{
  public atz ZEc;
  public long hKN;
  public long liveId;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257811);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.liveId);
      paramVarArgs.bv(4, this.hKN);
      if (this.username != null) {
        paramVarArgs.g(5, this.username);
      }
      paramVarArgs.bS(6, this.scene);
      AppMethodBeat.o(257811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.liveId) + i.a.a.b.b.a.q(4, this.hKN);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.username);
      }
      i = i.a.a.b.b.a.cJ(6, this.scene);
      AppMethodBeat.o(257811);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257811);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhi localbhi = (bhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257811);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbhi.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257811);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbhi.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257811);
          return 0;
        case 3: 
          localbhi.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257811);
          return 0;
        case 4: 
          localbhi.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257811);
          return 0;
        case 5: 
          localbhi.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257811);
          return 0;
        }
        localbhi.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257811);
        return 0;
      }
      AppMethodBeat.o(257811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */