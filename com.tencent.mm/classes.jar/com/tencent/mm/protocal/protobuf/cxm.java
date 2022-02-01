package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxm
  extends ckq
{
  public String CyF;
  public int EpA;
  public LinkedList<cxo> EpB;
  public cxl EpC;
  public int EpD;
  public LinkedList<cxl> EpE;
  public int Epz;
  public String sdP;
  public String sdQ;
  
  public cxm()
  {
    AppMethodBeat.i(152697);
    this.EpB = new LinkedList();
    this.EpE = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Epz);
      if (this.sdQ != null) {
        paramVarArgs.d(3, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(4, this.sdP);
      }
      if (this.CyF != null) {
        paramVarArgs.d(5, this.CyF);
      }
      paramVarArgs.aR(6, this.EpA);
      paramVarArgs.e(7, 8, this.EpB);
      if (this.EpC != null)
      {
        paramVarArgs.kX(8, this.EpC.computeSize());
        this.EpC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.EpD);
      paramVarArgs.e(10, 8, this.EpE);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Epz);
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sdP);
      }
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CyF);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.EpA) + f.a.a.a.c(7, 8, this.EpB);
      paramInt = i;
      if (this.EpC != null) {
        paramInt = i + f.a.a.a.kW(8, this.EpC.computeSize());
      }
      i = f.a.a.b.b.a.bA(9, this.EpD);
      int j = f.a.a.a.c(10, 8, this.EpE);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EpB.clear();
        this.EpE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxm localcxm = (cxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxm.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localcxm.Epz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localcxm.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localcxm.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localcxm.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localcxm.EpA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxm.EpB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxm.EpC = ((cxl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localcxm.EpD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxm.EpE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxm
 * JD-Core Version:    0.7.0.1
 */