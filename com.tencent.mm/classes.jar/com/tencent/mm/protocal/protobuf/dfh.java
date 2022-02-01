package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfh
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public cte FvG;
  public String GeH;
  public String Hgt;
  public String HtE;
  public String HtF;
  public int HtG;
  public int HtH;
  public long HtI;
  public long HtJ;
  public SKBuiltinBuffer_t HtK;
  public int HtL;
  public LinkedList<dft> HtM;
  public int HtN;
  public int IsNotRichText;
  public String hDa;
  public int nEf;
  public int tRT;
  
  public dfh()
  {
    AppMethodBeat.i(125770);
    this.HtM = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hgt != null) {
        paramVarArgs.d(1, this.Hgt);
      }
      if (this.GeH != null) {
        paramVarArgs.d(2, this.GeH);
      }
      if (this.HtE != null) {
        paramVarArgs.d(3, this.HtE);
      }
      if (this.HtF != null) {
        paramVarArgs.d(4, this.HtF);
      }
      paramVarArgs.aS(5, this.nEf);
      paramVarArgs.aS(6, this.tRT);
      paramVarArgs.aS(7, this.CreateTime);
      if (this.hDa != null) {
        paramVarArgs.d(8, this.hDa);
      }
      paramVarArgs.aS(9, this.HtG);
      paramVarArgs.aS(10, this.HtH);
      paramVarArgs.aS(11, this.IsNotRichText);
      paramVarArgs.aY(12, this.HtI);
      paramVarArgs.aY(13, this.HtJ);
      if (this.HtK != null)
      {
        paramVarArgs.lC(14, this.HtK.computeSize());
        this.HtK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.HtL);
      if (this.FvG != null)
      {
        paramVarArgs.lC(16, this.FvG.computeSize());
        this.FvG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.HtM);
      paramVarArgs.aS(18, this.HtN);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hgt == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = f.a.a.b.b.a.e(1, this.Hgt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GeH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GeH);
      }
      i = paramInt;
      if (this.HtE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HtE);
      }
      paramInt = i;
      if (this.HtF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HtF);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nEf) + f.a.a.b.b.a.bz(6, this.tRT) + f.a.a.b.b.a.bz(7, this.CreateTime);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HtG) + f.a.a.b.b.a.bz(10, this.HtH) + f.a.a.b.b.a.bz(11, this.IsNotRichText) + f.a.a.b.b.a.p(12, this.HtI) + f.a.a.b.b.a.p(13, this.HtJ);
      paramInt = i;
      if (this.HtK != null) {
        paramInt = i + f.a.a.a.lB(14, this.HtK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.HtL);
      paramInt = i;
      if (this.FvG != null) {
        paramInt = i + f.a.a.a.lB(16, this.FvG.computeSize());
      }
      i = f.a.a.a.c(17, 8, this.HtM);
      int j = f.a.a.b.b.a.bz(18, this.HtN);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HtM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfh localdfh = (dfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localdfh.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localdfh.GeH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localdfh.HtE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localdfh.HtF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localdfh.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localdfh.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localdfh.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localdfh.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localdfh.HtG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localdfh.HtH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localdfh.IsNotRichText = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localdfh.HtI = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localdfh.HtJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125771);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfh.HtK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localdfh.HtL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cte();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfh.FvG = ((cte)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dft();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dft)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfh.HtM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localdfh.HtN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfh
 * JD-Core Version:    0.7.0.1
 */