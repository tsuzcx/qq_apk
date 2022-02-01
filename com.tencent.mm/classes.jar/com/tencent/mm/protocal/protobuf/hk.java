package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hk
  extends cvc
{
  public int FqH;
  public SKBuiltinBuffer_t FyU;
  public ix FzF;
  public String FzG;
  public int FzH;
  public String FzI;
  public String FzJ;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public String jdf;
  public String nDs;
  public String qeh;
  public String qei;
  public String uEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FyU == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FzF != null)
      {
        paramVarArgs.lC(2, this.FzF.computeSize());
        this.FzF.writeFields(paramVarArgs);
      }
      if (this.FyU != null)
      {
        paramVarArgs.lC(3, this.FyU.computeSize());
        this.FyU.writeFields(paramVarArgs);
      }
      if (this.uEK != null) {
        paramVarArgs.d(4, this.uEK);
      }
      if (this.FzG != null) {
        paramVarArgs.d(5, this.FzG);
      }
      paramVarArgs.aS(6, this.FzH);
      if (this.FzI != null) {
        paramVarArgs.d(7, this.FzI);
      }
      if (this.jdf != null) {
        paramVarArgs.d(8, this.jdf);
      }
      if (this.nDs != null) {
        paramVarArgs.d(9, this.nDs);
      }
      if (this.FzJ != null) {
        paramVarArgs.d(10, this.FzJ);
      }
      if (this.qei != null) {
        paramVarArgs.d(11, this.qei);
      }
      if (this.qeh != null) {
        paramVarArgs.d(12, this.qeh);
      }
      paramVarArgs.aS(13, this.FqH);
      if (this.FzK != null)
      {
        paramVarArgs.lC(14, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(15, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1562;
      }
    }
    label1562:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FzF != null) {
        paramInt = i + f.a.a.a.lB(2, this.FzF.computeSize());
      }
      i = paramInt;
      if (this.FyU != null) {
        i = paramInt + f.a.a.a.lB(3, this.FyU.computeSize());
      }
      paramInt = i;
      if (this.uEK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uEK);
      }
      i = paramInt;
      if (this.FzG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FzG);
      }
      i += f.a.a.b.b.a.bz(6, this.FzH);
      paramInt = i;
      if (this.FzI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FzI);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jdf);
      }
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nDs);
      }
      i = paramInt;
      if (this.FzJ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FzJ);
      }
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.qei);
      }
      i = paramInt;
      if (this.qeh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.qeh);
      }
      i += f.a.a.b.b.a.bz(13, this.FqH);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(14, this.FzK.computeSize());
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(15, this.FzL.computeSize());
      }
      AppMethodBeat.o(133146);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FyU == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hk localhk = (hk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FzF = ((ix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FyU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localhk.uEK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localhk.FzG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localhk.FzH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localhk.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localhk.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localhk.nDs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localhk.FzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localhk.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localhk.qeh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localhk.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhk.FzL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */