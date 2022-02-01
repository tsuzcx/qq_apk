package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhm
  extends erp
{
  public int Tps;
  public atz YIY;
  public String YIZ;
  public b YJa;
  public b ZQU;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257699);
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
      if (this.YJa != null) {
        paramVarArgs.d(4, this.YJa);
      }
      paramVarArgs.bv(5, this.object_id);
      paramVarArgs.bv(6, this.mMJ);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(7, this.object_nonce_id);
      }
      paramVarArgs.bS(8, this.Tps);
      if (this.ZQU != null) {
        paramVarArgs.d(9, this.ZQU);
      }
      AppMethodBeat.o(257699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
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
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YJa);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.object_id) + i.a.a.b.b.a.q(6, this.mMJ);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.object_nonce_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.Tps);
      paramInt = i;
      if (this.ZQU != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.ZQU);
      }
      AppMethodBeat.o(257699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257699);
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
            localbhm.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257699);
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
            localbhm.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257699);
          return 0;
        case 3: 
          localbhm.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257699);
          return 0;
        case 4: 
          localbhm.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257699);
          return 0;
        case 5: 
          localbhm.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257699);
          return 0;
        case 6: 
          localbhm.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257699);
          return 0;
        case 7: 
          localbhm.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257699);
          return 0;
        case 8: 
          localbhm.Tps = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257699);
          return 0;
        }
        localbhm.ZQU = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257699);
        return 0;
      }
      AppMethodBeat.o(257699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhm
 * JD-Core Version:    0.7.0.1
 */