package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dvc
  extends cvc
{
  public int FAt;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public String GDx;
  public int HHC;
  public LinkedList<duz> HHD;
  public int HHE;
  public LinkedList<Integer> HHF;
  public int HHG;
  public LinkedList<dvb> HHH;
  public int HHI;
  
  public dvc()
  {
    AppMethodBeat.i(152726);
    this.HHD = new LinkedList();
    this.HHF = new LinkedList();
    this.HHH = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FAt);
      paramVarArgs.aS(3, this.HHC);
      paramVarArgs.e(4, 8, this.HHD);
      if (this.GDx != null) {
        paramVarArgs.d(5, this.GDx);
      }
      paramVarArgs.aS(6, this.HHE);
      paramVarArgs.f(7, 2, this.HHF);
      paramVarArgs.aS(8, this.HHG);
      paramVarArgs.e(9, 8, this.HHH);
      if (this.FzK != null)
      {
        paramVarArgs.lC(10, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(11, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.HHI);
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAt) + f.a.a.b.b.a.bz(3, this.HHC) + f.a.a.a.c(4, 8, this.HHD);
      paramInt = i;
      if (this.GDx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GDx);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HHE) + f.a.a.a.d(7, 2, this.HHF) + f.a.a.b.b.a.bz(8, this.HHG) + f.a.a.a.c(9, 8, this.HHH);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(10, this.FzK.computeSize());
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(11, this.FzL.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(12, this.HHI);
      AppMethodBeat.o(152727);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HHD.clear();
        this.HHF.clear();
        this.HHH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvc localdvc = (dvc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
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
            localdvc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localdvc.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localdvc.HHC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvc.HHD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localdvc.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localdvc.HHE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localdvc.HHF = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localdvc.HHG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvc.HHH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvc.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvc.FzL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        }
        localdvc.HHI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvc
 * JD-Core Version:    0.7.0.1
 */