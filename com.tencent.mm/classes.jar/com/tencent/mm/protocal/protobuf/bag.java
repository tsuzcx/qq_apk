package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bag
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b ZEQ;
  public long ZJD;
  public int ZLe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260051);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ZJD);
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(4, this.ZEQ);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(5, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.ZLe);
      AppMethodBeat.o(260051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZJD);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YIZ);
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.ZEQ);
      }
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(5, this.YIY.computeSize());
      }
      i = i.a.a.b.b.a.cJ(6, this.ZLe);
      AppMethodBeat.o(260051);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260051);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bag localbag = (bag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260051);
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
            localbag.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260051);
          return 0;
        case 2: 
          localbag.ZJD = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260051);
          return 0;
        case 3: 
          localbag.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260051);
          return 0;
        case 4: 
          localbag.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260051);
          return 0;
        case 5: 
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
            localbag.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260051);
          return 0;
        }
        localbag.ZLe = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260051);
        return 0;
      }
      AppMethodBeat.o(260051);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bag
 * JD-Core Version:    0.7.0.1
 */