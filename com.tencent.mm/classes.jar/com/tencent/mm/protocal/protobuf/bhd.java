package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhd
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public cbu ZQC;
  public long mMJ;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257747);
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
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.mMJ);
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(6, this.YIZ);
      }
      paramVarArgs.bS(7, this.scene);
      if (this.ZQC != null)
      {
        paramVarArgs.qD(9, this.ZQC.computeSize());
        this.ZQC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label808;
      }
    }
    label808:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.object_id) + i.a.a.b.b.a.q(4, this.mMJ);
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YJa);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YIZ);
      }
      i += i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.ZQC != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZQC.computeSize());
      }
      AppMethodBeat.o(257747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257747);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhd localbhd = (bhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 8: 
        default: 
          AppMethodBeat.o(257747);
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
            localbhd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257747);
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
            localbhd.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257747);
          return 0;
        case 3: 
          localbhd.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257747);
          return 0;
        case 4: 
          localbhd.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257747);
          return 0;
        case 5: 
          localbhd.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257747);
          return 0;
        case 6: 
          localbhd.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257747);
          return 0;
        case 7: 
          localbhd.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257747);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cbu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cbu)localObject2).parseFrom((byte[])localObject1);
          }
          localbhd.ZQC = ((cbu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257747);
        return 0;
      }
      AppMethodBeat.o(257747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhd
 * JD-Core Version:    0.7.0.1
 */