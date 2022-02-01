package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cps
  extends esc
{
  public String IGG;
  public String IGU;
  public gol YGU;
  public LinkedList<amn> YMz;
  public String YNd;
  public String ZuK;
  public LinkedList<cjb> Zvf;
  public String aawl;
  public ajy aawm;
  
  public cps()
  {
    AppMethodBeat.i(104811);
    this.Zvf = new LinkedList();
    this.YMz = new LinkedList();
    AppMethodBeat.o(104811);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104812);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.aawl == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.IGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.IGG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.ZuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.YNd == null)
      {
        paramVarArgs = new b("Not all required fields were included: BizName");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.YGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aawl != null) {
        paramVarArgs.g(2, this.aawl);
      }
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.ZuK != null) {
        paramVarArgs.g(5, this.ZuK);
      }
      if (this.YNd != null) {
        paramVarArgs.g(6, this.YNd);
      }
      paramVarArgs.e(7, 8, this.Zvf);
      if (this.YGU != null)
      {
        paramVarArgs.qD(8, this.YGU.computeSize());
        this.YGU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.YMz);
      if (this.aawm != null)
      {
        paramVarArgs.qD(10, this.aawm.computeSize());
        this.aawm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1432;
      }
    }
    label1432:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aawl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aawl);
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGU);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.ZuK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZuK);
      }
      paramInt = i;
      if (this.YNd != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YNd);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.Zvf);
      paramInt = i;
      if (this.YGU != null) {
        paramInt = i + i.a.a.a.qC(8, this.YGU.computeSize());
      }
      i = paramInt + i.a.a.a.c(9, 8, this.YMz);
      paramInt = i;
      if (this.aawm != null) {
        paramInt = i + i.a.a.a.qC(10, this.aawm.computeSize());
      }
      AppMethodBeat.o(104812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zvf.clear();
        this.YMz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.aawl == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.IGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.IGG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.ZuK == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.YNd == null)
        {
          paramVarArgs = new b("Not all required fields were included: BizName");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.YGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cps localcps = (cps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104812);
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
            localcps.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 2: 
          localcps.aawl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 3: 
          localcps.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 4: 
          localcps.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 5: 
          localcps.ZuK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 6: 
          localcps.YNd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjb)localObject2).parseFrom((byte[])localObject1);
            }
            localcps.Zvf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcps.YGU = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amn)localObject2).parseFrom((byte[])localObject1);
            }
            localcps.YMz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajy)localObject2).parseFrom((byte[])localObject1);
          }
          localcps.aawm = ((ajy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      AppMethodBeat.o(104812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cps
 * JD-Core Version:    0.7.0.1
 */