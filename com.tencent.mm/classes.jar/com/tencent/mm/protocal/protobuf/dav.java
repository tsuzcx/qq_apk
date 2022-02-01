package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dav
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public cmc Cvq;
  public bxs Ehd;
  public bhl EsC;
  public LinkedList<dbp> EsD;
  public LinkedList<dbp> EsE;
  public bhl EsF;
  public chy EsG;
  public cmb EsH;
  
  public dav()
  {
    AppMethodBeat.i(91707);
    this.EsD = new LinkedList();
    this.EsE = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EsC != null)
      {
        paramVarArgs.kX(1, this.EsC.computeSize());
        this.EsC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EsD);
      paramVarArgs.e(3, 8, this.EsE);
      if (this.EsF != null)
      {
        paramVarArgs.kX(4, this.EsF.computeSize());
        this.EsF.writeFields(paramVarArgs);
      }
      if (this.EsG != null)
      {
        paramVarArgs.kX(5, this.EsG.computeSize());
        this.EsG.writeFields(paramVarArgs);
      }
      if (this.CDW != null) {
        paramVarArgs.d(6, this.CDW);
      }
      if (this.Ehd != null)
      {
        paramVarArgs.kX(7, this.Ehd.computeSize());
        this.Ehd.writeFields(paramVarArgs);
      }
      if (this.Cvq != null)
      {
        paramVarArgs.kX(8, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      if (this.EsH != null)
      {
        paramVarArgs.kX(9, this.EsH.computeSize());
        this.EsH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EsC == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.kW(1, this.EsC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EsD) + f.a.a.a.c(3, 8, this.EsE);
      paramInt = i;
      if (this.EsF != null) {
        paramInt = i + f.a.a.a.kW(4, this.EsF.computeSize());
      }
      i = paramInt;
      if (this.EsG != null) {
        i = paramInt + f.a.a.a.kW(5, this.EsG.computeSize());
      }
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDW);
      }
      i = paramInt;
      if (this.Ehd != null) {
        i = paramInt + f.a.a.a.kW(7, this.Ehd.computeSize());
      }
      paramInt = i;
      if (this.Cvq != null) {
        paramInt = i + f.a.a.a.kW(8, this.Cvq.computeSize());
      }
      i = paramInt;
      if (this.EsH != null) {
        i = paramInt + f.a.a.a.kW(9, this.EsH.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EsD.clear();
        this.EsE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dav localdav = (dav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.EsC = ((bhl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.EsD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.EsE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.EsF = ((bhl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.EsG = ((chy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localdav.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.Ehd = ((bxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdav.Cvq = ((cmc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdav.EsH = ((cmb)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dav
 * JD-Core Version:    0.7.0.1
 */