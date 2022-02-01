package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcy
  extends cvp
{
  public String CKD;
  public boolean Gzt;
  public boolean Gzu;
  public String Gzv;
  public String Gzw;
  public int Gzx;
  public String Gzy;
  public int Gzz;
  public String dHY;
  public String hAD;
  public String hzB;
  public String oxM;
  public String oxN;
  public String oxO;
  public int oxQ;
  public String oze;
  public String title;
  public int yMs;
  public String yMt;
  public String yMu;
  public String yMv;
  public String yMx;
  public boolean yMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.Gzt);
      paramVarArgs.bt(3, this.Gzu);
      if (this.Gzv != null) {
        paramVarArgs.d(4, this.Gzv);
      }
      if (this.Gzw != null) {
        paramVarArgs.d(5, this.Gzw);
      }
      paramVarArgs.aS(6, this.Gzx);
      if (this.Gzy != null) {
        paramVarArgs.d(7, this.Gzy);
      }
      paramVarArgs.aS(8, this.Gzz);
      if (this.oxM != null) {
        paramVarArgs.d(9, this.oxM);
      }
      if (this.dHY != null) {
        paramVarArgs.d(10, this.dHY);
      }
      if (this.title != null) {
        paramVarArgs.d(11, this.title);
      }
      if (this.oxN != null) {
        paramVarArgs.d(12, this.oxN);
      }
      if (this.oxO != null) {
        paramVarArgs.d(13, this.oxO);
      }
      if (this.oze != null) {
        paramVarArgs.d(14, this.oze);
      }
      if (this.hzB != null) {
        paramVarArgs.d(15, this.hzB);
      }
      if (this.hAD != null) {
        paramVarArgs.d(16, this.hAD);
      }
      paramVarArgs.aS(17, this.yMs);
      if (this.yMt != null) {
        paramVarArgs.d(18, this.yMt);
      }
      if (this.yMu != null) {
        paramVarArgs.d(19, this.yMu);
      }
      if (this.yMv != null) {
        paramVarArgs.d(20, this.yMv);
      }
      paramVarArgs.aS(21, this.oxQ);
      if (this.yMx != null) {
        paramVarArgs.d(22, this.yMx);
      }
      if (this.CKD != null) {
        paramVarArgs.d(23, this.CKD);
      }
      paramVarArgs.bt(24, this.yMy);
      AppMethodBeat.o(32248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1684;
      }
    }
    label1684:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.Gzv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gzv);
      }
      i = paramInt;
      if (this.Gzw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gzw);
      }
      i += f.a.a.b.b.a.bz(6, this.Gzx);
      paramInt = i;
      if (this.Gzy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gzy);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Gzz);
      paramInt = i;
      if (this.oxM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oxM);
      }
      i = paramInt;
      if (this.dHY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dHY);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.title);
      }
      i = paramInt;
      if (this.oxN != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.oxN);
      }
      paramInt = i;
      if (this.oxO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.oxO);
      }
      i = paramInt;
      if (this.oze != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.oze);
      }
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.hzB);
      }
      i = paramInt;
      if (this.hAD != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.hAD);
      }
      i += f.a.a.b.b.a.bz(17, this.yMs);
      paramInt = i;
      if (this.yMt != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.yMt);
      }
      i = paramInt;
      if (this.yMu != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.yMu);
      }
      paramInt = i;
      if (this.yMv != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.yMv);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.oxQ);
      paramInt = i;
      if (this.yMx != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.yMx);
      }
      i = paramInt;
      if (this.CKD != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.CKD);
      }
      paramInt = f.a.a.b.b.a.alV(24);
      AppMethodBeat.o(32248);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcy localbcy = (bcy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32248);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32248);
          return 0;
        case 2: 
          localbcy.Gzt = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32248);
          return 0;
        case 3: 
          localbcy.Gzu = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32248);
          return 0;
        case 4: 
          localbcy.Gzv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 5: 
          localbcy.Gzw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 6: 
          localbcy.Gzx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 7: 
          localbcy.Gzy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 8: 
          localbcy.Gzz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 9: 
          localbcy.oxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 10: 
          localbcy.dHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 11: 
          localbcy.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 12: 
          localbcy.oxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 13: 
          localbcy.oxO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 14: 
          localbcy.oze = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 15: 
          localbcy.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 16: 
          localbcy.hAD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 17: 
          localbcy.yMs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 18: 
          localbcy.yMt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 19: 
          localbcy.yMu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 20: 
          localbcy.yMv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 21: 
          localbcy.oxQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 22: 
          localbcy.yMx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 23: 
          localbcy.CKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32248);
          return 0;
        }
        localbcy.yMy = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(32248);
        return 0;
      }
      AppMethodBeat.o(32248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcy
 * JD-Core Version:    0.7.0.1
 */