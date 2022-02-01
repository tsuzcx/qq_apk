package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cgw
  extends esc
{
  public String aapD;
  public wv aapE;
  public int aapF;
  public ewp aapG;
  public String wuy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wuy != null) {
        paramVarArgs.g(2, this.wuy);
      }
      if (this.aapD != null) {
        paramVarArgs.g(3, this.aapD);
      }
      if (this.aapE != null)
      {
        paramVarArgs.qD(4, this.aapE.computeSize());
        this.aapE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aapF);
      if (this.aapG != null)
      {
        paramVarArgs.qD(6, this.aapG.computeSize());
        this.aapG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label764;
      }
    }
    label764:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wuy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wuy);
      }
      i = paramInt;
      if (this.aapD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aapD);
      }
      paramInt = i;
      if (this.aapE != null) {
        paramInt = i + i.a.a.a.qC(4, this.aapE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aapF);
      paramInt = i;
      if (this.aapG != null) {
        paramInt = i + i.a.a.a.qC(6, this.aapG.computeSize());
      }
      AppMethodBeat.o(114023);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cgw localcgw = (cgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
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
            localcgw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localcgw.wuy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localcgw.aapD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wv)localObject2).parseFrom((byte[])localObject1);
            }
            localcgw.aapE = ((wv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localcgw.aapF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ewp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ewp)localObject2).parseFrom((byte[])localObject1);
          }
          localcgw.aapG = ((ewp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgw
 * JD-Core Version:    0.7.0.1
 */