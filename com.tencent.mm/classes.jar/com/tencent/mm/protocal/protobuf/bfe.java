package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bfe
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public int ZPk;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258447);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZPk);
      paramVarArgs.bv(3, this.object_id);
      if (this.YIY != null)
      {
        paramVarArgs.qD(4, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(6, this.YIZ);
      }
      AppMethodBeat.o(258447);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZPk) + i.a.a.b.b.a.q(3, this.object_id);
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(4, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.YJa);
      }
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YIZ);
      }
      AppMethodBeat.o(258447);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bfe localbfe = (bfe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258447);
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
            localbfe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258447);
          return 0;
        case 2: 
          localbfe.ZPk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258447);
          return 0;
        case 3: 
          localbfe.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258447);
          return 0;
        case 4: 
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
            localbfe.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258447);
          return 0;
        case 5: 
          localbfe.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258447);
          return 0;
        }
        localbfe.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258447);
        return 0;
      }
      AppMethodBeat.o(258447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfe
 * JD-Core Version:    0.7.0.1
 */