package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyd
  extends dyy
{
  public int CreateTime;
  public int HlE;
  public long HlH;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eaf RID;
  public eaf RIE;
  public String RII;
  public String RNi;
  public String ScV;
  public int Sda;
  public eaf Uym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152720);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.Uym == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HlE);
      if (this.Uym != null)
      {
        paramVarArgs.oE(3, this.Uym.computeSize());
        this.Uym.writeFields(paramVarArgs);
      }
      if (this.RID != null)
      {
        paramVarArgs.oE(4, this.RID.computeSize());
        this.RID.writeFields(paramVarArgs);
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(5, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.HmZ);
      paramVarArgs.aY(7, this.Hna);
      paramVarArgs.aY(8, this.Hnb);
      paramVarArgs.aY(9, this.CreateTime);
      paramVarArgs.bm(10, this.HlH);
      if (this.ScV != null) {
        paramVarArgs.f(11, this.ScV);
      }
      if (this.RNi != null) {
        paramVarArgs.f(12, this.RNi);
      }
      if (this.RII != null) {
        paramVarArgs.f(13, this.RII);
      }
      paramVarArgs.aY(14, this.Sda);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1374;
      }
    }
    label1374:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.HlE);
      paramInt = i;
      if (this.Uym != null) {
        paramInt = i + g.a.a.a.oD(3, this.Uym.computeSize());
      }
      i = paramInt;
      if (this.RID != null) {
        i = paramInt + g.a.a.a.oD(4, this.RID.computeSize());
      }
      paramInt = i;
      if (this.RIE != null) {
        paramInt = i + g.a.a.a.oD(5, this.RIE.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.HmZ) + g.a.a.b.b.a.bM(7, this.Hna) + g.a.a.b.b.a.bM(8, this.Hnb) + g.a.a.b.b.a.bM(9, this.CreateTime) + g.a.a.b.b.a.p(10, this.HlH);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ScV);
      }
      i = paramInt;
      if (this.RNi != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RNi);
      }
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RII);
      }
      i = g.a.a.b.b.a.bM(14, this.Sda);
      AppMethodBeat.o(152720);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.Uym == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.RID == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.RIE == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyd localeyd = (eyd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localeyd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localeyd.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyd.Uym = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyd.RID = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyd.RIE = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localeyd.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localeyd.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localeyd.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localeyd.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localeyd.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localeyd.ScV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localeyd.RNi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localeyd.RII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localeyd.Sda = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyd
 * JD-Core Version:    0.7.0.1
 */