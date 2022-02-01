package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwh
  extends cvc
{
  public int FMu;
  public int Fyv;
  public int Fyy;
  public String HFt;
  public int HFu;
  public int HFv;
  public int HIM;
  public int HIN;
  public LinkedList<cwt> HIO;
  public LinkedList<SKBuiltinBuffer_t> HIP;
  public int ihf;
  public String nDo;
  public SKBuiltinBuffer_t xcN;
  
  public dwh()
  {
    AppMethodBeat.i(148663);
    this.HIO = new LinkedList();
    this.HIP = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.xcN != null)
      {
        paramVarArgs.lC(3, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FMu);
      if (this.HFt != null) {
        paramVarArgs.d(5, this.HFt);
      }
      paramVarArgs.aS(6, this.ihf);
      paramVarArgs.aS(7, this.HFu);
      paramVarArgs.aS(8, this.Fyy);
      paramVarArgs.aS(9, this.HFv);
      paramVarArgs.aS(10, this.Fyv);
      paramVarArgs.aS(11, this.HIM);
      paramVarArgs.aS(12, this.HIN);
      paramVarArgs.e(13, 8, this.HIO);
      paramVarArgs.e(14, 8, this.HIP);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.xcN != null) {
        i = paramInt + f.a.a.a.lB(3, this.xcN.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.FMu);
      paramInt = i;
      if (this.HFt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HFt);
      }
      i = f.a.a.b.b.a.bz(6, this.ihf);
      int j = f.a.a.b.b.a.bz(7, this.HFu);
      int k = f.a.a.b.b.a.bz(8, this.Fyy);
      int m = f.a.a.b.b.a.bz(9, this.HFv);
      int n = f.a.a.b.b.a.bz(10, this.Fyv);
      int i1 = f.a.a.b.b.a.bz(11, this.HIM);
      int i2 = f.a.a.b.b.a.bz(12, this.HIN);
      int i3 = f.a.a.a.c(13, 8, this.HIO);
      int i4 = f.a.a.a.c(14, 8, this.HIP);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HIO.clear();
        this.HIP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwh localdwh = (dwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
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
            localdwh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localdwh.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148664);
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
            localdwh.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localdwh.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localdwh.HFt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localdwh.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localdwh.HFu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localdwh.Fyy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localdwh.HFv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localdwh.Fyv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localdwh.HIM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localdwh.HIN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.HIO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
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
          localdwh.HIP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwh
 * JD-Core Version:    0.7.0.1
 */