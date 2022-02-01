package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwu
  extends esc
{
  public int YQB;
  public dzz aaBR;
  public LinkedList<dqz> aaBX;
  public String aaBY;
  public String aaBZ;
  public String aaCa;
  public String aaCb;
  public String aaCc;
  public LinkedList<glv> aaCd;
  public int aaqo;
  public String appid;
  public String hOQ;
  public int ret;
  public String url;
  public String xlt;
  
  public cwu()
  {
    AppMethodBeat.i(123588);
    this.aaBX = new LinkedList();
    this.aaCd = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ret);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      paramVarArgs.bS(4, this.aaqo);
      if (this.hOQ != null) {
        paramVarArgs.g(5, this.hOQ);
      }
      if (this.aaBR != null)
      {
        paramVarArgs.qD(6, this.aaBR.computeSize());
        this.aaBR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.aaBX);
      if (this.aaBY != null) {
        paramVarArgs.g(8, this.aaBY);
      }
      if (this.xlt != null) {
        paramVarArgs.g(9, this.xlt);
      }
      paramVarArgs.bS(10, this.YQB);
      if (this.appid != null) {
        paramVarArgs.g(11, this.appid);
      }
      if (this.aaBZ != null) {
        paramVarArgs.g(12, this.aaBZ);
      }
      if (this.aaCa != null) {
        paramVarArgs.g(13, this.aaCa);
      }
      if (this.aaCb != null) {
        paramVarArgs.g(14, this.aaCb);
      }
      if (this.aaCc != null) {
        paramVarArgs.g(15, this.aaCc);
      }
      paramVarArgs.e(16, 8, this.aaCd);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1394;
      }
    }
    label1394:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aaqo);
      paramInt = i;
      if (this.hOQ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hOQ);
      }
      i = paramInt;
      if (this.aaBR != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaBR.computeSize());
      }
      i += i.a.a.a.c(7, 8, this.aaBX);
      paramInt = i;
      if (this.aaBY != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaBY);
      }
      i = paramInt;
      if (this.xlt != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.xlt);
      }
      i += i.a.a.b.b.a.cJ(10, this.YQB);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.appid);
      }
      i = paramInt;
      if (this.aaBZ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaBZ);
      }
      paramInt = i;
      if (this.aaCa != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aaCa);
      }
      i = paramInt;
      if (this.aaCb != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaCb);
      }
      paramInt = i;
      if (this.aaCc != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaCc);
      }
      i = i.a.a.a.c(16, 8, this.aaCd);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaBX.clear();
        this.aaCd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwu localcwu = (cwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
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
            localcwu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localcwu.ret = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localcwu.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localcwu.aaqo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localcwu.hOQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwu.aaBR = ((dzz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwu.aaBX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localcwu.aaBY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localcwu.xlt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localcwu.YQB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localcwu.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localcwu.aaBZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localcwu.aaCa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localcwu.aaCb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localcwu.aaCc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new glv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((glv)localObject2).parseFrom((byte[])localObject1);
          }
          localcwu.aaCd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwu
 * JD-Core Version:    0.7.0.1
 */