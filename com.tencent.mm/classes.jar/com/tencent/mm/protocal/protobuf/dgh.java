package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgh
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public String DWw;
  public ccn FEc;
  public bld FPE;
  public LinkedList<dhb> FPF;
  public LinkedList<dhb> FPG;
  public bld FPH;
  public cnc FPI;
  public cri FPJ;
  
  public dgh()
  {
    AppMethodBeat.i(91707);
    this.FPF = new LinkedList();
    this.FPG = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPE != null)
      {
        paramVarArgs.ln(1, this.FPE.computeSize());
        this.FPE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FPF);
      paramVarArgs.e(3, 8, this.FPG);
      if (this.FPH != null)
      {
        paramVarArgs.ln(4, this.FPH.computeSize());
        this.FPH.writeFields(paramVarArgs);
      }
      if (this.FPI != null)
      {
        paramVarArgs.ln(5, this.FPI.computeSize());
        this.FPI.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(6, this.DWw);
      }
      if (this.FEc != null)
      {
        paramVarArgs.ln(7, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.DNL != null)
      {
        paramVarArgs.ln(8, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      if (this.FPJ != null)
      {
        paramVarArgs.ln(9, this.FPJ.computeSize());
        this.FPJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPE == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lm(1, this.FPE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FPF) + f.a.a.a.c(3, 8, this.FPG);
      paramInt = i;
      if (this.FPH != null) {
        paramInt = i + f.a.a.a.lm(4, this.FPH.computeSize());
      }
      i = paramInt;
      if (this.FPI != null) {
        i = paramInt + f.a.a.a.lm(5, this.FPI.computeSize());
      }
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DWw);
      }
      i = paramInt;
      if (this.FEc != null) {
        i = paramInt + f.a.a.a.lm(7, this.FEc.computeSize());
      }
      paramInt = i;
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(8, this.DNL.computeSize());
      }
      i = paramInt;
      if (this.FPJ != null) {
        i = paramInt + f.a.a.a.lm(9, this.FPJ.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPF.clear();
        this.FPG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgh localdgh = (dgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FPE = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FPF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FPG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FPH = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FPI = ((cnc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localdgh.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.FEc = ((ccn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.DNL = ((crj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cri();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cri)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgh.FPJ = ((cri)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      AppMethodBeat.o(91708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgh
 * JD-Core Version:    0.7.0.1
 */