package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cve
  extends cvp
{
  public String FMk;
  public dn Hnk;
  public int dlw;
  public String paA;
  public String thm;
  public String uJF;
  public String xSA;
  public String xSB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
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
      if (this.thm != null) {
        paramVarArgs.d(4, this.thm);
      }
      if (this.FMk != null) {
        paramVarArgs.d(5, this.FMk);
      }
      if (this.xSA != null) {
        paramVarArgs.d(6, this.xSA);
      }
      if (this.xSB != null) {
        paramVarArgs.d(7, this.xSB);
      }
      if (this.uJF != null) {
        paramVarArgs.d(8, this.uJF);
      }
      if (this.Hnk != null)
      {
        paramVarArgs.lC(9, this.Hnk.computeSize());
        this.Hnk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.thm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.thm);
      }
      paramInt = i;
      if (this.FMk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FMk);
      }
      i = paramInt;
      if (this.xSA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xSA);
      }
      paramInt = i;
      if (this.xSB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xSB);
      }
      i = paramInt;
      if (this.uJF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uJF);
      }
      paramInt = i;
      if (this.Hnk != null) {
        paramInt = i + f.a.a.a.lB(9, this.Hnk.computeSize());
      }
      AppMethodBeat.o(72582);
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
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cve localcve = (cve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localcve.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localcve.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localcve.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localcve.thm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localcve.FMk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localcve.xSA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localcve.xSB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localcve.uJF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcve.Hnk = ((dn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cve
 * JD-Core Version:    0.7.0.1
 */