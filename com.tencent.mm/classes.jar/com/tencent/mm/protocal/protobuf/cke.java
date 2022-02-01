package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cke
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b ZEQ;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258328);
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
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(4, this.YIZ);
      }
      paramVarArgs.l(5, this.longitude);
      paramVarArgs.l(6, this.latitude);
      AppMethodBeat.o(258328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIZ);
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(258328);
      return paramInt + (i + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258328);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cke localcke = (cke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258328);
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
            localcke.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258328);
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
            localcke.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258328);
          return 0;
        case 3: 
          localcke.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258328);
          return 0;
        case 4: 
          localcke.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258328);
          return 0;
        case 5: 
          localcke.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258328);
          return 0;
        }
        localcke.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(258328);
        return 0;
      }
      AppMethodBeat.o(258328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cke
 * JD-Core Version:    0.7.0.1
 */