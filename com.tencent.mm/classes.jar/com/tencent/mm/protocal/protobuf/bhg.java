package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhg
  extends erp
{
  public int YAN;
  public atz YIY;
  public String YIZ;
  public String ZQS;
  public String app_id;
  public String hFb;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257794);
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
      if (this.ZQS != null) {
        paramVarArgs.g(4, this.ZQS);
      }
      if (this.hFb != null) {
        paramVarArgs.g(5, this.hFb);
      }
      if (this.app_id != null) {
        paramVarArgs.g(6, this.app_id);
      }
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bS(8, this.YAN);
      AppMethodBeat.o(257794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
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
      if (this.ZQS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZQS);
      }
      i = paramInt;
      if (this.hFb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hFb);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.app_id);
      }
      i = i.a.a.b.b.a.cJ(7, this.scene);
      int j = i.a.a.b.b.a.cJ(8, this.YAN);
      AppMethodBeat.o(257794);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhg localbhg = (bhg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257794);
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
            localbhg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257794);
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
            localbhg.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257794);
          return 0;
        case 3: 
          localbhg.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257794);
          return 0;
        case 4: 
          localbhg.ZQS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257794);
          return 0;
        case 5: 
          localbhg.hFb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257794);
          return 0;
        case 6: 
          localbhg.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257794);
          return 0;
        case 7: 
          localbhg.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257794);
          return 0;
        }
        localbhg.YAN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257794);
        return 0;
      }
      AppMethodBeat.o(257794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhg
 * JD-Core Version:    0.7.0.1
 */