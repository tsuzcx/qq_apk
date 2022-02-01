package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bda
  extends cvp
{
  public int FMr;
  public String FMt;
  public SKBuiltinBuffer_t GzA;
  public int GzF;
  public LinkedList<cwt> GzG;
  public int GzH;
  public LinkedList<btl> GzI;
  public String GzJ;
  public int GzK;
  public int GzL;
  public btm GzM;
  public String GzN;
  public String jde;
  
  public bda()
  {
    AppMethodBeat.i(32251);
    this.GzG = new LinkedList();
    this.GzI = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.GzA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GzA != null)
      {
        paramVarArgs.lC(2, this.GzA.computeSize());
        this.GzA.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GzF);
      paramVarArgs.e(4, 8, this.GzG);
      paramVarArgs.aS(5, this.GzH);
      paramVarArgs.e(6, 8, this.GzI);
      paramVarArgs.aS(7, this.FMr);
      if (this.GzJ != null) {
        paramVarArgs.d(8, this.GzJ);
      }
      if (this.FMt != null) {
        paramVarArgs.d(9, this.FMt);
      }
      paramVarArgs.aS(10, this.GzK);
      if (this.jde != null) {
        paramVarArgs.d(11, this.jde);
      }
      paramVarArgs.aS(12, this.GzL);
      if (this.GzM != null)
      {
        paramVarArgs.lC(13, this.GzM.computeSize());
        this.GzM.writeFields(paramVarArgs);
      }
      if (this.GzN != null) {
        paramVarArgs.d(14, this.GzN);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GzA != null) {
        i = paramInt + f.a.a.a.lB(2, this.GzA.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.GzF) + f.a.a.a.c(4, 8, this.GzG) + f.a.a.b.b.a.bz(5, this.GzH) + f.a.a.a.c(6, 8, this.GzI) + f.a.a.b.b.a.bz(7, this.FMr);
      paramInt = i;
      if (this.GzJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GzJ);
      }
      i = paramInt;
      if (this.FMt != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FMt);
      }
      i += f.a.a.b.b.a.bz(10, this.GzK);
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jde);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.GzL);
      paramInt = i;
      if (this.GzM != null) {
        paramInt = i + f.a.a.a.lB(13, this.GzM.computeSize());
      }
      i = paramInt;
      if (this.GzN != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GzN);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GzG.clear();
        this.GzI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.GzA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bda localbda = (bda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localbda.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbda.GzA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localbda.GzF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbda.GzG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localbda.GzH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbda.GzI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localbda.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localbda.GzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localbda.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localbda.GzK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localbda.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localbda.GzL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbda.GzM = ((btm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localbda.GzN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bda
 * JD-Core Version:    0.7.0.1
 */