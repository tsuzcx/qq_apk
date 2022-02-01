package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coz
  extends cvp
{
  public String Hin;
  public int Hio;
  public String Hip;
  public String Hiq;
  public String Hir;
  public String His;
  public int dlw;
  public String iDt;
  public String paA;
  public int state;
  public int vls;
  public String xSB;
  public String xSC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
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
      paramVarArgs.aS(4, this.state);
      if (this.Hin != null) {
        paramVarArgs.d(5, this.Hin);
      }
      paramVarArgs.aS(6, this.vls);
      paramVarArgs.aS(7, this.Hio);
      if (this.xSB != null) {
        paramVarArgs.d(8, this.xSB);
      }
      if (this.Hip != null) {
        paramVarArgs.d(9, this.Hip);
      }
      if (this.xSC != null) {
        paramVarArgs.d(10, this.xSC);
      }
      if (this.Hiq != null) {
        paramVarArgs.d(11, this.Hiq);
      }
      if (this.Hir != null) {
        paramVarArgs.d(12, this.Hir);
      }
      if (this.His != null) {
        paramVarArgs.d(14, this.His);
      }
      if (this.iDt != null) {
        paramVarArgs.d(15, this.iDt);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.state);
      paramInt = i;
      if (this.Hin != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hin);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.vls) + f.a.a.b.b.a.bz(7, this.Hio);
      paramInt = i;
      if (this.xSB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xSB);
      }
      i = paramInt;
      if (this.Hip != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hip);
      }
      paramInt = i;
      if (this.xSC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xSC);
      }
      i = paramInt;
      if (this.Hiq != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Hiq);
      }
      paramInt = i;
      if (this.Hir != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hir);
      }
      i = paramInt;
      if (this.His != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.His);
      }
      paramInt = i;
      if (this.iDt != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iDt);
      }
      AppMethodBeat.o(72567);
      return paramInt;
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coz localcoz = (coz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localcoz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localcoz.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localcoz.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localcoz.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localcoz.Hin = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localcoz.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localcoz.Hio = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localcoz.xSB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localcoz.Hip = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localcoz.xSC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localcoz.Hiq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localcoz.Hir = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localcoz.His = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localcoz.iDt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coz
 * JD-Core Version:    0.7.0.1
 */