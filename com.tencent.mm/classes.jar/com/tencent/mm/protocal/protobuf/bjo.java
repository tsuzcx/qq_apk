package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bjo
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public bfk ZGx;
  public long mMJ;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260042);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.ZGx != null)
      {
        paramVarArgs.qD(4, this.ZGx.computeSize());
        this.ZGx.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      paramVarArgs.bv(6, this.mMJ);
      paramVarArgs.bv(7, this.object_id);
      AppMethodBeat.o(260042);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      paramInt = i;
      if (this.ZGx != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZGx.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.YJa);
      }
      paramInt = i.a.a.b.b.a.q(6, this.mMJ);
      int j = i.a.a.b.b.a.q(7, this.object_id);
      AppMethodBeat.o(260042);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260042);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bjo localbjo = (bjo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260042);
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
            localbjo.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260042);
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
            localbjo.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260042);
          return 0;
        case 3: 
          localbjo.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260042);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfk)localObject2).parseFrom((byte[])localObject1);
            }
            localbjo.ZGx = ((bfk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260042);
          return 0;
        case 5: 
          localbjo.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260042);
          return 0;
        case 6: 
          localbjo.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260042);
          return 0;
        }
        localbjo.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260042);
        return 0;
      }
      AppMethodBeat.o(260042);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjo
 * JD-Core Version:    0.7.0.1
 */