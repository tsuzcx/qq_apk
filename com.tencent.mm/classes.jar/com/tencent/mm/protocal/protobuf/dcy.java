package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcy
  extends cpx
{
  public String DRb;
  public int FMB;
  public int FMC;
  public LinkedList<dda> FMD;
  public dcx FME;
  public int FMF;
  public LinkedList<dcx> FMG;
  public String tlJ;
  public String tlK;
  
  public dcy()
  {
    AppMethodBeat.i(152697);
    this.FMD = new LinkedList();
    this.FMG = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FMB);
      if (this.tlK != null) {
        paramVarArgs.d(3, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(4, this.tlJ);
      }
      if (this.DRb != null) {
        paramVarArgs.d(5, this.DRb);
      }
      paramVarArgs.aR(6, this.FMC);
      paramVarArgs.e(7, 8, this.FMD);
      if (this.FME != null)
      {
        paramVarArgs.ln(8, this.FME.computeSize());
        this.FME.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.FMF);
      paramVarArgs.e(10, 8, this.FMG);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FMB);
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tlJ);
      }
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DRb);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FMC) + f.a.a.a.c(7, 8, this.FMD);
      paramInt = i;
      if (this.FME != null) {
        paramInt = i + f.a.a.a.lm(8, this.FME.computeSize());
      }
      i = f.a.a.b.b.a.bx(9, this.FMF);
      int j = f.a.a.a.c(10, 8, this.FMG);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FMD.clear();
        this.FMG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcy localdcy = (dcy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localdcy.FMB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localdcy.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localdcy.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localdcy.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localdcy.FMC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dda();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.FMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcy.FME = ((dcx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localdcy.FMF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcy.FMG.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcy
 * JD-Core Version:    0.7.0.1
 */