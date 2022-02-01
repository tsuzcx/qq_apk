package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edr
  extends dyl
{
  public ciu RQB;
  public eae TpX;
  public ciy UhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.UhW == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.TpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32428);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQB != null)
      {
        paramVarArgs.oE(2, this.RQB.computeSize());
        this.RQB.writeFields(paramVarArgs);
      }
      if (this.UhW != null)
      {
        paramVarArgs.oE(3, this.UhW.computeSize());
        this.UhW.writeFields(paramVarArgs);
      }
      if (this.TpX != null)
      {
        paramVarArgs.oE(4, this.TpX.computeSize());
        this.TpX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label844;
      }
    }
    label844:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQB != null) {
        paramInt = i + g.a.a.a.oD(2, this.RQB.computeSize());
      }
      i = paramInt;
      if (this.UhW != null) {
        i = paramInt + g.a.a.a.oD(3, this.UhW.computeSize());
      }
      paramInt = i;
      if (this.TpX != null) {
        paramInt = i + g.a.a.a.oD(4, this.TpX.computeSize());
      }
      AppMethodBeat.o(32428);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQB == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.UhW == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceMsg");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        if (this.TpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32428);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edr localedr = (edr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32428);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localedr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ciu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ciu)localObject2).parseFrom((byte[])localObject1);
            }
            localedr.RQB = ((ciu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ciy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ciy)localObject2).parseFrom((byte[])localObject1);
            }
            localedr.UhW = ((ciy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32428);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localedr.TpX = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32428);
        return 0;
      }
      AppMethodBeat.o(32428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edr
 * JD-Core Version:    0.7.0.1
 */