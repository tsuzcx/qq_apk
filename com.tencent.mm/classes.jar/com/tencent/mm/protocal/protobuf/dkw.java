package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkw
  extends cvp
{
  public com.tencent.mm.bx.b Buffer;
  public String HzA;
  public int HzB;
  public int HzC;
  public int HzD;
  public String HzE;
  public boolean HzF;
  public String HzG;
  public String HzH;
  public int HzI;
  public dkx HzJ;
  public int Hzl;
  public dkz Hzt;
  public String Hzu;
  public String Hzv;
  public int Hzw;
  public int Hzx;
  public int Hzy;
  public boolean Hzz;
  public LinkedList<dku> ufw;
  
  public dkw()
  {
    AppMethodBeat.i(152706);
    this.ufw = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ufw);
      if (this.Hzt != null)
      {
        paramVarArgs.lC(3, this.Hzt.computeSize());
        this.Hzt.writeFields(paramVarArgs);
      }
      if (this.Hzu != null) {
        paramVarArgs.d(4, this.Hzu);
      }
      if (this.Hzv != null) {
        paramVarArgs.d(5, this.Hzv);
      }
      paramVarArgs.aS(6, this.Hzw);
      paramVarArgs.aS(9, this.Hzx);
      paramVarArgs.aS(10, this.Hzy);
      paramVarArgs.aS(11, this.Hzl);
      paramVarArgs.bt(12, this.Hzz);
      if (this.HzA != null) {
        paramVarArgs.d(13, this.HzA);
      }
      paramVarArgs.aS(14, this.HzB);
      paramVarArgs.aS(15, this.HzC);
      if (this.Buffer != null) {
        paramVarArgs.c(16, this.Buffer);
      }
      paramVarArgs.aS(17, this.HzD);
      if (this.HzE != null) {
        paramVarArgs.d(18, this.HzE);
      }
      paramVarArgs.bt(19, this.HzF);
      if (this.HzG != null) {
        paramVarArgs.d(20, this.HzG);
      }
      if (this.HzH != null) {
        paramVarArgs.d(21, this.HzH);
      }
      paramVarArgs.aS(22, this.HzI);
      if (this.HzJ != null)
      {
        paramVarArgs.lC(23, this.HzJ.computeSize());
        this.HzJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1690;
      }
    }
    label1690:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.ufw);
      paramInt = i;
      if (this.Hzt != null) {
        paramInt = i + f.a.a.a.lB(3, this.Hzt.computeSize());
      }
      i = paramInt;
      if (this.Hzu != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hzu);
      }
      paramInt = i;
      if (this.Hzv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hzv);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Hzw) + f.a.a.b.b.a.bz(9, this.Hzx) + f.a.a.b.b.a.bz(10, this.Hzy) + f.a.a.b.b.a.bz(11, this.Hzl) + f.a.a.b.b.a.alV(12);
      paramInt = i;
      if (this.HzA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HzA);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.HzB) + f.a.a.b.b.a.bz(15, this.HzC);
      paramInt = i;
      if (this.Buffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.Buffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.HzD);
      paramInt = i;
      if (this.HzE != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HzE);
      }
      i = paramInt + f.a.a.b.b.a.alV(19);
      paramInt = i;
      if (this.HzG != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HzG);
      }
      i = paramInt;
      if (this.HzH != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HzH);
      }
      i += f.a.a.b.b.a.bz(22, this.HzI);
      paramInt = i;
      if (this.HzJ != null) {
        paramInt = i + f.a.a.a.lB(23, this.HzJ.computeSize());
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ufw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkw localdkw = (dkw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dku();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.ufw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.Hzt = ((dkz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localdkw.Hzu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localdkw.Hzv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localdkw.Hzw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localdkw.Hzx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localdkw.Hzy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localdkw.Hzl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localdkw.Hzz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localdkw.HzA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localdkw.HzB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localdkw.HzC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localdkw.Buffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localdkw.HzD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localdkw.HzE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localdkw.HzF = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localdkw.HzG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localdkw.HzH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localdkw.HzI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152707);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkw.HzJ = ((dkx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkw
 * JD-Core Version:    0.7.0.1
 */