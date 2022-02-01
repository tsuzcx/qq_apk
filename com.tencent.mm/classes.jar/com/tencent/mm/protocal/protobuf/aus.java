package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aus
  extends erp
{
  public bdm CER;
  public atz YIY;
  public String YIZ;
  public b YJa;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257802);
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
      if (this.YJa != null) {
        paramVarArgs.d(3, this.YJa);
      }
      if (this.CER != null)
      {
        paramVarArgs.qD(4, this.CER.computeSize());
        this.CER.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.mMJ);
      paramVarArgs.bv(6, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(7, this.object_nonce_id);
      }
      paramVarArgs.bS(8, this.scene);
      if (this.YIZ != null) {
        paramVarArgs.g(9, this.YIZ);
      }
      AppMethodBeat.o(257802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label868;
      }
    }
    label868:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YJa);
      }
      paramInt = i;
      if (this.CER != null) {
        paramInt = i + i.a.a.a.qC(4, this.CER.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.mMJ) + i.a.a.b.b.a.q(6, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.object_nonce_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YIZ);
      }
      AppMethodBeat.o(257802);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aus localaus = (aus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257802);
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
            localaus.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257802);
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
            localaus.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257802);
          return 0;
        case 3: 
          localaus.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257802);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localaus.CER = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257802);
          return 0;
        case 5: 
          localaus.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257802);
          return 0;
        case 6: 
          localaus.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257802);
          return 0;
        case 7: 
          localaus.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257802);
          return 0;
        case 8: 
          localaus.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257802);
          return 0;
        }
        localaus.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257802);
        return 0;
      }
      AppMethodBeat.o(257802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aus
 * JD-Core Version:    0.7.0.1
 */