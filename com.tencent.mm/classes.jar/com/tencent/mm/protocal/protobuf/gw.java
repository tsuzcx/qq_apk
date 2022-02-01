package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gw
  extends esc
{
  public com.tencent.mm.bx.b YIp;
  public int YIv;
  public int YIw;
  public hb YIx;
  public gx YIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIv);
      paramVarArgs.bS(3, this.YIw);
      if (this.YIp != null) {
        paramVarArgs.d(4, this.YIp);
      }
      if (this.YIx != null)
      {
        paramVarArgs.qD(5, this.YIx.computeSize());
        this.YIx.writeFields(paramVarArgs);
      }
      if (this.YIy != null)
      {
        paramVarArgs.qD(6, this.YIy.computeSize());
        this.YIy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIv) + i.a.a.b.b.a.cJ(3, this.YIw);
      paramInt = i;
      if (this.YIp != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YIp);
      }
      i = paramInt;
      if (this.YIx != null) {
        i = paramInt + i.a.a.a.qC(5, this.YIx.computeSize());
      }
      paramInt = i;
      if (this.YIy != null) {
        paramInt = i + i.a.a.a.qC(6, this.YIy.computeSize());
      }
      AppMethodBeat.o(32119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gw localgw = (gw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localgw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localgw.YIv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localgw.YIw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localgw.YIp = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hb)localObject2).parseFrom((byte[])localObject1);
            }
            localgw.YIx = ((hb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gx)localObject2).parseFrom((byte[])localObject1);
          }
          localgw.YIy = ((gx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gw
 * JD-Core Version:    0.7.0.1
 */