package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayw
  extends erp
{
  public String ACh;
  public atz ZEc;
  public long hKN;
  public b lastBuffer;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259309);
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
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      if (this.ACh != null) {
        paramVarArgs.g(4, this.ACh);
      }
      paramVarArgs.bv(5, this.hKN);
      if (this.objectNonceId != null) {
        paramVarArgs.g(6, this.objectNonceId);
      }
      AppMethodBeat.o(259309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      paramInt = i;
      if (this.ACh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ACh);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.hKN);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.objectNonceId);
      }
      AppMethodBeat.o(259309);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayw localayw = (ayw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259309);
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
            localayw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259309);
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
            localayw.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259309);
          return 0;
        case 3: 
          localayw.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259309);
          return 0;
        case 4: 
          localayw.ACh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259309);
          return 0;
        case 5: 
          localayw.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259309);
          return 0;
        }
        localayw.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259309);
        return 0;
      }
      AppMethodBeat.o(259309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayw
 * JD-Core Version:    0.7.0.1
 */