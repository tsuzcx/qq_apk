package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhy
  extends erp
{
  public atz ZEc;
  public int ZRf;
  public String finderUsername;
  public long hKN;
  public b lastBuffer;
  public long liveId;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257620);
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
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bv(5, this.liveId);
      paramVarArgs.bv(6, this.hKN);
      if (this.objectNonceId != null) {
        paramVarArgs.g(7, this.objectNonceId);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(8, this.lastBuffer);
      }
      paramVarArgs.bS(9, this.ZRf);
      AppMethodBeat.o(257620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.scene) + i.a.a.b.b.a.q(5, this.liveId) + i.a.a.b.b.a.q(6, this.hKN);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.objectNonceId);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.lastBuffer);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.ZRf);
      AppMethodBeat.o(257620);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhy localbhy = (bhy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257620);
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
            localbhy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257620);
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
            localbhy.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257620);
          return 0;
        case 3: 
          localbhy.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257620);
          return 0;
        case 4: 
          localbhy.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257620);
          return 0;
        case 5: 
          localbhy.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257620);
          return 0;
        case 6: 
          localbhy.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257620);
          return 0;
        case 7: 
          localbhy.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257620);
          return 0;
        case 8: 
          localbhy.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257620);
          return 0;
        }
        localbhy.ZRf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257620);
        return 0;
      }
      AppMethodBeat.o(257620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhy
 * JD-Core Version:    0.7.0.1
 */