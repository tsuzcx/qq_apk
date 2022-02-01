package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqx
  extends erp
{
  public String Vbl;
  public String ZlW;
  public fmx aaXa;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72523);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.time_stamp);
      if (this.ZlW != null) {
        paramVarArgs.g(3, this.ZlW);
      }
      if (this.aaXa != null)
      {
        paramVarArgs.qD(4, this.aaXa.computeSize());
        this.aaXa.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(72523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.time_stamp);
      paramInt = i;
      if (this.ZlW != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZlW);
      }
      i = paramInt;
      if (this.aaXa != null) {
        i = paramInt + i.a.a.a.qC(4, this.aaXa.computeSize());
      }
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(72523);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dqx localdqx = (dqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72523);
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
            localdqx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        case 2: 
          localdqx.time_stamp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72523);
          return 0;
        case 3: 
          localdqx.ZlW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72523);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmx)localObject2).parseFrom((byte[])localObject1);
            }
            localdqx.aaXa = ((fmx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        }
        localdqx.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72523);
        return 0;
      }
      AppMethodBeat.o(72523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqx
 * JD-Core Version:    0.7.0.1
 */