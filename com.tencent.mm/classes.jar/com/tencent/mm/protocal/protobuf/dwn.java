package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwn
  extends cvc
{
  public int FKZ;
  public int FMu;
  public String HFt;
  public int HFv;
  public int HIV;
  public LinkedList<cwt> HIW;
  public int HIX;
  public cwt Hnc;
  public int Scene;
  public int ihf;
  public SKBuiltinBuffer_t xcN;
  
  public dwn()
  {
    AppMethodBeat.i(148668);
    this.HIW = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xcN != null)
      {
        paramVarArgs.lC(2, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FMu);
      if (this.HFt != null) {
        paramVarArgs.d(4, this.HFt);
      }
      paramVarArgs.aS(5, this.ihf);
      paramVarArgs.aS(6, this.HFv);
      paramVarArgs.aS(7, this.FKZ);
      paramVarArgs.aS(8, this.HIV);
      paramVarArgs.e(9, 8, this.HIW);
      if (this.Hnc != null)
      {
        paramVarArgs.lC(10, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.HIX);
      paramVarArgs.aS(12, this.Scene);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xcN != null) {
        i = paramInt + f.a.a.a.lB(2, this.xcN.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FMu);
      paramInt = i;
      if (this.HFt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HFt);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ihf) + f.a.a.b.b.a.bz(6, this.HFv) + f.a.a.b.b.a.bz(7, this.FKZ) + f.a.a.b.b.a.bz(8, this.HIV) + f.a.a.a.c(9, 8, this.HIW);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + f.a.a.a.lB(10, this.Hnc.computeSize());
      }
      i = f.a.a.b.b.a.bz(11, this.HIX);
      int j = f.a.a.b.b.a.bz(12, this.Scene);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HIW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwn localdwn = (dwn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
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
            localdwn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwn.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localdwn.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localdwn.HFt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localdwn.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localdwn.HFv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localdwn.FKZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localdwn.HIV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwn.HIW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwn.Hnc = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localdwn.HIX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148669);
          return 0;
        }
        localdwn.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwn
 * JD-Core Version:    0.7.0.1
 */