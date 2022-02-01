package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atu
  extends erp
{
  public int YSN;
  public atz ZEc;
  public String ZEm;
  public boolean enable;
  public long hKN;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258061);
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
      if (this.ZEm != null) {
        paramVarArgs.g(5, this.ZEm);
      }
      paramVarArgs.bS(6, this.scene);
      paramVarArgs.di(7, this.enable);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      paramVarArgs.bS(9, this.YSN);
      AppMethodBeat.o(258061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.liveId) + i.a.a.b.b.a.q(4, this.hKN);
      paramInt = i;
      if (this.ZEm != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZEm);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.scene) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = i.a.a.b.b.a.cJ(9, this.YSN);
      AppMethodBeat.o(258061);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        atu localatu = (atu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258061);
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
            localatu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258061);
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
            localatu.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258061);
          return 0;
        case 3: 
          localatu.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258061);
          return 0;
        case 4: 
          localatu.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258061);
          return 0;
        case 5: 
          localatu.ZEm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258061);
          return 0;
        case 6: 
          localatu.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258061);
          return 0;
        case 7: 
          localatu.enable = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258061);
          return 0;
        case 8: 
          localatu.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258061);
          return 0;
        }
        localatu.YSN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258061);
        return 0;
      }
      AppMethodBeat.o(258061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atu
 * JD-Core Version:    0.7.0.1
 */