package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avu
  extends cpx
{
  public LinkedList<crm> DPy;
  public int ENJ;
  public int ENK;
  public LinkedList<crm> ENL;
  public int ENM;
  public LinkedList<crm> ENN;
  public int ENO;
  public crm ENP;
  
  public avu()
  {
    AppMethodBeat.i(32232);
    this.DPy = new LinkedList();
    this.ENL = new LinkedList();
    this.ENN = new LinkedList();
    AppMethodBeat.o(32232);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32233);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ENJ);
      paramVarArgs.e(3, 8, this.DPy);
      paramVarArgs.aR(4, this.ENK);
      paramVarArgs.e(5, 8, this.ENL);
      paramVarArgs.aR(6, this.ENM);
      paramVarArgs.e(7, 8, this.ENN);
      paramVarArgs.aR(8, this.ENO);
      if (this.ENP != null)
      {
        paramVarArgs.ln(9, this.ENP.computeSize());
        this.ENP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32233);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ENJ) + f.a.a.a.c(3, 8, this.DPy) + f.a.a.b.b.a.bx(4, this.ENK) + f.a.a.a.c(5, 8, this.ENL) + f.a.a.b.b.a.bx(6, this.ENM) + f.a.a.a.c(7, 8, this.ENN) + f.a.a.b.b.a.bx(8, this.ENO);
      paramInt = i;
      if (this.ENP != null) {
        paramInt = i + f.a.a.a.lm(9, this.ENP.computeSize());
      }
      AppMethodBeat.o(32233);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPy.clear();
        this.ENL.clear();
        this.ENN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avu localavu = (avu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32233);
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
            localavu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 2: 
          localavu.ENJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32233);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavu.DPy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 4: 
          localavu.ENK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32233);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavu.ENL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 6: 
          localavu.ENM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32233);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavu.ENN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 8: 
          localavu.ENO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32233);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavu.ENP = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      AppMethodBeat.o(32233);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avu
 * JD-Core Version:    0.7.0.1
 */