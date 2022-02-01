package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftw
  extends esc
{
  public int CreateTime;
  public int Njs;
  public long Njv;
  public int NkN;
  public int NkO;
  public int NkP;
  public etl YFE;
  public etl YFF;
  public String YFJ;
  public String YKw;
  public String ZaN;
  public int ZaS;
  public etl abRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152720);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.abRT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Njs);
      if (this.abRT != null)
      {
        paramVarArgs.qD(3, this.abRT.computeSize());
        this.abRT.writeFields(paramVarArgs);
      }
      if (this.YFE != null)
      {
        paramVarArgs.qD(4, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(5, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.NkN);
      paramVarArgs.bS(7, this.NkO);
      paramVarArgs.bS(8, this.NkP);
      paramVarArgs.bS(9, this.CreateTime);
      paramVarArgs.bv(10, this.Njv);
      if (this.ZaN != null) {
        paramVarArgs.g(11, this.ZaN);
      }
      if (this.YKw != null) {
        paramVarArgs.g(12, this.YKw);
      }
      if (this.YFJ != null) {
        paramVarArgs.g(13, this.YFJ);
      }
      paramVarArgs.bS(14, this.ZaS);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1370;
      }
    }
    label1370:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Njs);
      paramInt = i;
      if (this.abRT != null) {
        paramInt = i + i.a.a.a.qC(3, this.abRT.computeSize());
      }
      i = paramInt;
      if (this.YFE != null) {
        i = paramInt + i.a.a.a.qC(4, this.YFE.computeSize());
      }
      paramInt = i;
      if (this.YFF != null) {
        paramInt = i + i.a.a.a.qC(5, this.YFF.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.NkN) + i.a.a.b.b.a.cJ(7, this.NkO) + i.a.a.b.b.a.cJ(8, this.NkP) + i.a.a.b.b.a.cJ(9, this.CreateTime) + i.a.a.b.b.a.q(10, this.Njv);
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZaN);
      }
      i = paramInt;
      if (this.YKw != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YKw);
      }
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YFJ);
      }
      i = i.a.a.b.b.a.cJ(14, this.ZaS);
      AppMethodBeat.o(152720);
      return paramInt + i;
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
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.abRT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.YFE == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.YFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftw localftw = (ftw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
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
            localftw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localftw.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftw.abRT = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftw.YFE = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localftw.YFF = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localftw.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localftw.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localftw.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localftw.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localftw.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localftw.ZaN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localftw.YKw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localftw.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localftw.ZaS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftw
 * JD-Core Version:    0.7.0.1
 */