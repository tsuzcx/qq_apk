package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dcw
  extends cvp
{
  public String dHY;
  public String hAD;
  public String hzB;
  public String oxM;
  public String oxN;
  public String oxO;
  public int oxQ;
  public int ozA;
  public String oze;
  public String title;
  public int yMp;
  public int yMs;
  public String yMt;
  public String yMu;
  public String yMv;
  public String yMw;
  public String yMx;
  public boolean yMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozA);
      if (this.oxM != null) {
        paramVarArgs.d(3, this.oxM);
      }
      if (this.dHY != null) {
        paramVarArgs.d(4, this.dHY);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.oxN != null) {
        paramVarArgs.d(6, this.oxN);
      }
      if (this.oxO != null) {
        paramVarArgs.d(7, this.oxO);
      }
      if (this.oze != null) {
        paramVarArgs.d(8, this.oze);
      }
      if (this.hzB != null) {
        paramVarArgs.d(9, this.hzB);
      }
      if (this.hAD != null) {
        paramVarArgs.d(10, this.hAD);
      }
      paramVarArgs.aS(11, this.yMp);
      paramVarArgs.aS(12, this.yMs);
      if (this.yMt != null) {
        paramVarArgs.d(13, this.yMt);
      }
      if (this.yMu != null) {
        paramVarArgs.d(14, this.yMu);
      }
      if (this.yMv != null) {
        paramVarArgs.d(19, this.yMv);
      }
      if (this.yMw != null) {
        paramVarArgs.d(21, this.yMw);
      }
      paramVarArgs.aS(22, this.oxQ);
      if (this.yMx != null) {
        paramVarArgs.d(23, this.yMx);
      }
      paramVarArgs.bt(24, this.yMy);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1427;
      }
    }
    label1427:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozA);
      paramInt = i;
      if (this.oxM != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxM);
      }
      i = paramInt;
      if (this.dHY != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dHY);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.oxN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oxN);
      }
      paramInt = i;
      if (this.oxO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.oxO);
      }
      i = paramInt;
      if (this.oze != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oze);
      }
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hzB);
      }
      i = paramInt;
      if (this.hAD != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hAD);
      }
      i = i + f.a.a.b.b.a.bz(11, this.yMp) + f.a.a.b.b.a.bz(12, this.yMs);
      paramInt = i;
      if (this.yMt != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.yMt);
      }
      i = paramInt;
      if (this.yMu != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.yMu);
      }
      paramInt = i;
      if (this.yMv != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.yMv);
      }
      i = paramInt;
      if (this.yMw != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.yMw);
      }
      i += f.a.a.b.b.a.bz(22, this.oxQ);
      paramInt = i;
      if (this.yMx != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.yMx);
      }
      i = f.a.a.b.b.a.alV(24);
      AppMethodBeat.o(32439);
      return paramInt + i;
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
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcw localdcw = (dcw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
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
            localdcw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localdcw.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localdcw.oxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localdcw.dHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localdcw.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localdcw.oxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localdcw.oxO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localdcw.oze = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localdcw.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localdcw.hAD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localdcw.yMp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localdcw.yMs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localdcw.yMt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localdcw.yMu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localdcw.yMv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localdcw.yMw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localdcw.oxQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localdcw.yMx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localdcw.yMy = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcw
 * JD-Core Version:    0.7.0.1
 */