package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azy
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b ZEQ;
  public int ZKO;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258953);
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
      paramVarArgs.bv(3, this.mMJ);
      if (this.YIZ != null) {
        paramVarArgs.g(4, this.YIZ);
      }
      paramVarArgs.bv(5, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(6, this.object_nonce_id);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(7, this.ZEQ);
      }
      paramVarArgs.bS(8, this.ZKO);
      AppMethodBeat.o(258953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.mMJ);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIZ);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.object_nonce_id);
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.ZEQ);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.ZKO);
      AppMethodBeat.o(258953);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azy localazy = (azy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258953);
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
            localazy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258953);
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
            localazy.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258953);
          return 0;
        case 3: 
          localazy.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258953);
          return 0;
        case 4: 
          localazy.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258953);
          return 0;
        case 5: 
          localazy.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258953);
          return 0;
        case 6: 
          localazy.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258953);
          return 0;
        case 7: 
          localazy.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258953);
          return 0;
        }
        localazy.ZKO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258953);
        return 0;
      }
      AppMethodBeat.o(258953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azy
 * JD-Core Version:    0.7.0.1
 */