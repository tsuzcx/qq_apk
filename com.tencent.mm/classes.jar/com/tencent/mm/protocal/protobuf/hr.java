package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class hr
  extends erp
{
  public String Ayi;
  public atz YIY;
  public String YIZ;
  public b YJa;
  public long mMJ;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258003);
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
      paramVarArgs.bv(4, this.object_id);
      paramVarArgs.bv(5, this.mMJ);
      if (this.Ayi != null) {
        paramVarArgs.g(6, this.Ayi);
      }
      if (this.YJa != null) {
        paramVarArgs.d(7, this.YJa);
      }
      paramVarArgs.bS(8, this.scene);
      AppMethodBeat.o(258003);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
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
      i = i + i.a.a.b.b.a.q(4, this.object_id) + i.a.a.b.b.a.q(5, this.mMJ);
      paramInt = i;
      if (this.Ayi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Ayi);
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.YJa);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.scene);
      AppMethodBeat.o(258003);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258003);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        hr localhr = (hr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258003);
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
            localhr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258003);
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
            localhr.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258003);
          return 0;
        case 3: 
          localhr.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258003);
          return 0;
        case 4: 
          localhr.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258003);
          return 0;
        case 5: 
          localhr.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258003);
          return 0;
        case 6: 
          localhr.Ayi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258003);
          return 0;
        case 7: 
          localhr.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258003);
          return 0;
        }
        localhr.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258003);
        return 0;
      }
      AppMethodBeat.o(258003);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hr
 * JD-Core Version:    0.7.0.1
 */