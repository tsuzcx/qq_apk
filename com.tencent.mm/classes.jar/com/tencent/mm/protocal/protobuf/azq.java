package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azq
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b ZEQ;
  public int ZKk;
  public boolean ZKl;
  public String ZKm;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259026);
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
      paramVarArgs.bS(7, this.ZKk);
      paramVarArgs.di(8, this.ZKl);
      paramVarArgs.bS(9, this.scene);
      if (this.ZEQ != null) {
        paramVarArgs.d(10, this.ZEQ);
      }
      if (this.ZKm != null) {
        paramVarArgs.g(11, this.ZKm);
      }
      AppMethodBeat.o(259026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
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
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZKk) + (i.a.a.b.b.a.ko(8) + 1) + i.a.a.b.b.a.cJ(9, this.scene);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.ZEQ);
      }
      i = paramInt;
      if (this.ZKm != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZKm);
      }
      AppMethodBeat.o(259026);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azq localazq = (azq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259026);
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
            localazq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259026);
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
            localazq.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259026);
          return 0;
        case 3: 
          localazq.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259026);
          return 0;
        case 4: 
          localazq.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259026);
          return 0;
        case 5: 
          localazq.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259026);
          return 0;
        case 6: 
          localazq.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259026);
          return 0;
        case 7: 
          localazq.ZKk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259026);
          return 0;
        case 8: 
          localazq.ZKl = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259026);
          return 0;
        case 9: 
          localazq.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259026);
          return 0;
        case 10: 
          localazq.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259026);
          return 0;
        }
        localazq.ZKm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259026);
        return 0;
      }
      AppMethodBeat.o(259026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azq
 * JD-Core Version:    0.7.0.1
 */