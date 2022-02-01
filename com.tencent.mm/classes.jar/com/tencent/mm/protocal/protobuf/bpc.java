package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bpc
  extends dpc
{
  public boolean DhA;
  public int Dhu;
  public String Dhv;
  public String Dhw;
  public String Dhx;
  public String Dhz;
  public String HHX;
  public boolean LXf;
  public boolean LXg;
  public String LXh;
  public String LXi;
  public int LXj;
  public String LXk;
  public int LXl;
  public String eaP;
  public String gTG;
  public String iwv;
  public String ixw;
  public String pRX;
  public String pRY;
  public String pRZ;
  public int pSb;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32248);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.LXf);
      paramVarArgs.cc(3, this.LXg);
      if (this.LXh != null) {
        paramVarArgs.e(4, this.LXh);
      }
      if (this.LXi != null) {
        paramVarArgs.e(5, this.LXi);
      }
      paramVarArgs.aM(6, this.LXj);
      if (this.LXk != null) {
        paramVarArgs.e(7, this.LXk);
      }
      paramVarArgs.aM(8, this.LXl);
      if (this.pRX != null) {
        paramVarArgs.e(9, this.pRX);
      }
      if (this.eaP != null) {
        paramVarArgs.e(10, this.eaP);
      }
      if (this.title != null) {
        paramVarArgs.e(11, this.title);
      }
      if (this.pRY != null) {
        paramVarArgs.e(12, this.pRY);
      }
      if (this.pRZ != null) {
        paramVarArgs.e(13, this.pRZ);
      }
      if (this.gTG != null) {
        paramVarArgs.e(14, this.gTG);
      }
      if (this.iwv != null) {
        paramVarArgs.e(15, this.iwv);
      }
      if (this.ixw != null) {
        paramVarArgs.e(16, this.ixw);
      }
      paramVarArgs.aM(17, this.Dhu);
      if (this.Dhv != null) {
        paramVarArgs.e(18, this.Dhv);
      }
      if (this.Dhw != null) {
        paramVarArgs.e(19, this.Dhw);
      }
      if (this.Dhx != null) {
        paramVarArgs.e(20, this.Dhx);
      }
      paramVarArgs.aM(21, this.pSb);
      if (this.Dhz != null) {
        paramVarArgs.e(22, this.Dhz);
      }
      if (this.HHX != null) {
        paramVarArgs.e(23, this.HHX);
      }
      paramVarArgs.cc(24, this.DhA);
      AppMethodBeat.o(32248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1688;
      }
    }
    label1688:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.LXh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LXh);
      }
      i = paramInt;
      if (this.LXi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LXi);
      }
      i += g.a.a.b.b.a.bu(6, this.LXj);
      paramInt = i;
      if (this.LXk != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LXk);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.LXl);
      paramInt = i;
      if (this.pRX != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.pRX);
      }
      i = paramInt;
      if (this.eaP != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.eaP);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.title);
      }
      i = paramInt;
      if (this.pRY != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.pRY);
      }
      paramInt = i;
      if (this.pRZ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.pRZ);
      }
      i = paramInt;
      if (this.gTG != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.gTG);
      }
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.iwv);
      }
      i = paramInt;
      if (this.ixw != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.ixw);
      }
      i += g.a.a.b.b.a.bu(17, this.Dhu);
      paramInt = i;
      if (this.Dhv != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Dhv);
      }
      i = paramInt;
      if (this.Dhw != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.Dhw);
      }
      paramInt = i;
      if (this.Dhx != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.Dhx);
      }
      i = paramInt + g.a.a.b.b.a.bu(21, this.pSb);
      paramInt = i;
      if (this.Dhz != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.Dhz);
      }
      i = paramInt;
      if (this.HHX != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.HHX);
      }
      paramInt = g.a.a.b.b.a.fS(24);
      AppMethodBeat.o(32248);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bpc localbpc = (bpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32248);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32248);
          return 0;
        case 2: 
          localbpc.LXf = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32248);
          return 0;
        case 3: 
          localbpc.LXg = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32248);
          return 0;
        case 4: 
          localbpc.LXh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 5: 
          localbpc.LXi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 6: 
          localbpc.LXj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32248);
          return 0;
        case 7: 
          localbpc.LXk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 8: 
          localbpc.LXl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32248);
          return 0;
        case 9: 
          localbpc.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 10: 
          localbpc.eaP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 11: 
          localbpc.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 12: 
          localbpc.pRY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 13: 
          localbpc.pRZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 14: 
          localbpc.gTG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 15: 
          localbpc.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 16: 
          localbpc.ixw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 17: 
          localbpc.Dhu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32248);
          return 0;
        case 18: 
          localbpc.Dhv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 19: 
          localbpc.Dhw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 20: 
          localbpc.Dhx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 21: 
          localbpc.pSb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32248);
          return 0;
        case 22: 
          localbpc.Dhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 23: 
          localbpc.HHX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32248);
          return 0;
        }
        localbpc.DhA = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(32248);
        return 0;
      }
      AppMethodBeat.o(32248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */