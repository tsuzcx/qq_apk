package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayu
  extends erp
{
  public atz ZEc;
  public String finderUsername;
  public long hKN;
  public b lastBuffer;
  public b likeBuffer;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259286);
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
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      paramVarArgs.bv(6, this.hKN);
      if (this.objectNonceId != null) {
        paramVarArgs.g(7, this.objectNonceId);
      }
      if (this.likeBuffer != null) {
        paramVarArgs.d(8, this.likeBuffer);
      }
      AppMethodBeat.o(259286);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
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
      i += i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.hKN);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.objectNonceId);
      }
      i = paramInt;
      if (this.likeBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.likeBuffer);
      }
      AppMethodBeat.o(259286);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259286);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayu localayu = (ayu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259286);
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
            localayu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259286);
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
            localayu.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259286);
          return 0;
        case 3: 
          localayu.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259286);
          return 0;
        case 4: 
          localayu.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259286);
          return 0;
        case 5: 
          localayu.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259286);
          return 0;
        case 6: 
          localayu.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259286);
          return 0;
        case 7: 
          localayu.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259286);
          return 0;
        }
        localayu.likeBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(259286);
        return 0;
      }
      AppMethodBeat.o(259286);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayu
 * JD-Core Version:    0.7.0.1
 */