package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coi
  extends cvp
{
  public String Hhn;
  public String Hho;
  public sd Hhp;
  public String Hhq;
  public String Hhr;
  public doo Hhs;
  public String dkR;
  public String hzB;
  public int ozR;
  public String ozS;
  public String wBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.Hhn != null) {
        paramVarArgs.d(4, this.Hhn);
      }
      if (this.hzB != null) {
        paramVarArgs.d(5, this.hzB);
      }
      if (this.Hho != null) {
        paramVarArgs.d(6, this.Hho);
      }
      if (this.Hhp != null)
      {
        paramVarArgs.lC(7, this.Hhp.computeSize());
        this.Hhp.writeFields(paramVarArgs);
      }
      if (this.Hhq != null) {
        paramVarArgs.d(8, this.Hhq);
      }
      if (this.wBI != null) {
        paramVarArgs.d(9, this.wBI);
      }
      if (this.dkR != null) {
        paramVarArgs.d(10, this.dkR);
      }
      if (this.Hhr != null) {
        paramVarArgs.d(11, this.Hhr);
      }
      if (this.Hhs != null)
      {
        paramVarArgs.lC(12, this.Hhs.computeSize());
        this.Hhs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.Hhn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hhn);
      }
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hzB);
      }
      i = paramInt;
      if (this.Hho != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hho);
      }
      paramInt = i;
      if (this.Hhp != null) {
        paramInt = i + f.a.a.a.lB(7, this.Hhp.computeSize());
      }
      i = paramInt;
      if (this.Hhq != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hhq);
      }
      paramInt = i;
      if (this.wBI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wBI);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dkR);
      }
      paramInt = i;
      if (this.Hhr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hhr);
      }
      i = paramInt;
      if (this.Hhs != null) {
        i = paramInt + f.a.a.a.lB(12, this.Hhs.computeSize());
      }
      AppMethodBeat.o(72556);
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
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coi localcoi = (coi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localcoi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localcoi.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localcoi.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localcoi.Hhn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localcoi.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localcoi.Hho = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoi.Hhp = ((sd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localcoi.Hhq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localcoi.wBI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localcoi.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localcoi.Hhr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcoi.Hhs = ((doo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coi
 * JD-Core Version:    0.7.0.1
 */