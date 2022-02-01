package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aio
  extends cvp
{
  public cra FTQ;
  public int dNN;
  public int dNO;
  public int dlw;
  public int dnL;
  public String paA;
  public String vkl;
  public String vlA;
  public int vls;
  public int vlu;
  public String vlv;
  public String vlw;
  public String vlx;
  public int vly;
  public String vlz;
  public String voz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.aS(4, this.dnL);
      if (this.vkl != null) {
        paramVarArgs.d(5, this.vkl);
      }
      paramVarArgs.aS(6, this.dNN);
      paramVarArgs.aS(7, this.dNO);
      if (this.voz != null) {
        paramVarArgs.d(8, this.voz);
      }
      paramVarArgs.aS(9, this.vls);
      if (this.FTQ != null)
      {
        paramVarArgs.lC(10, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.vlu);
      if (this.vlv != null) {
        paramVarArgs.d(12, this.vlv);
      }
      if (this.vlw != null) {
        paramVarArgs.d(13, this.vlw);
      }
      if (this.vlx != null) {
        paramVarArgs.d(14, this.vlx);
      }
      paramVarArgs.aS(15, this.vly);
      if (this.vlz != null) {
        paramVarArgs.d(16, this.vlz);
      }
      if (this.vlA != null) {
        paramVarArgs.d(17, this.vlA);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1322;
      }
    }
    label1322:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.dnL);
      paramInt = i;
      if (this.vkl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vkl);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.dNN) + f.a.a.b.b.a.bz(7, this.dNO);
      paramInt = i;
      if (this.voz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.voz);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.vls);
      paramInt = i;
      if (this.FTQ != null) {
        paramInt = i + f.a.a.a.lB(10, this.FTQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.vlu);
      paramInt = i;
      if (this.vlv != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vlv);
      }
      i = paramInt;
      if (this.vlw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vlw);
      }
      paramInt = i;
      if (this.vlx != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vlx);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.vly);
      paramInt = i;
      if (this.vlz != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vlz);
      }
      i = paramInt;
      if (this.vlA != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.vlA);
      }
      AppMethodBeat.o(91453);
      return i;
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
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aio localaio = (aio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
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
            localaio.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localaio.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localaio.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localaio.dnL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localaio.vkl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localaio.dNN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localaio.dNO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localaio.voz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localaio.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaio.FTQ = ((cra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localaio.vlu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localaio.vlv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localaio.vlw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localaio.vlx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localaio.vly = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localaio.vlz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        localaio.vlA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */