package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azu
  extends erp
{
  public atz ZEc;
  public b ZKu;
  public boolean ZKv;
  public String finderUsername;
  public long hKN;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259070);
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
      if (this.finderUsername != null) {
        paramVarArgs.g(5, this.finderUsername);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.g(6, this.object_nonce_id);
      }
      paramVarArgs.bS(7, this.scene);
      if (this.ZKu != null) {
        paramVarArgs.d(8, this.ZKu);
      }
      paramVarArgs.di(9, this.ZKv);
      AppMethodBeat.o(259070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.liveId) + i.a.a.b.b.a.q(4, this.hKN);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.finderUsername);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.object_nonce_id);
      }
      i += i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.ZKu != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.ZKu);
      }
      i = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(259070);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azu localazu = (azu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259070);
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
            localazu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259070);
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
            localazu.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259070);
          return 0;
        case 3: 
          localazu.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259070);
          return 0;
        case 4: 
          localazu.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259070);
          return 0;
        case 5: 
          localazu.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259070);
          return 0;
        case 6: 
          localazu.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259070);
          return 0;
        case 7: 
          localazu.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259070);
          return 0;
        case 8: 
          localazu.ZKu = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259070);
          return 0;
        }
        localazu.ZKv = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259070);
        return 0;
      }
      AppMethodBeat.o(259070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azu
 * JD-Core Version:    0.7.0.1
 */