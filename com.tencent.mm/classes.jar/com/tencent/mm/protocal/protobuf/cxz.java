package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxz
  extends com.tencent.mm.bw.a
{
  public String APx;
  public LinkedList<cxy> MCQ;
  public int MCR;
  public int MCS;
  public doy MCT;
  public int MCU;
  public LinkedList<cxx> MCV;
  public boolean MCW;
  public LinkedList<doy> MCX;
  public int state;
  
  public cxz()
  {
    AppMethodBeat.i(117544);
    this.MCQ = new LinkedList();
    this.MCV = new LinkedList();
    this.MCX = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.APx == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.APx != null) {
        paramVarArgs.e(1, this.APx);
      }
      paramVarArgs.aM(2, this.state);
      paramVarArgs.e(3, 8, this.MCQ);
      paramVarArgs.aM(4, this.MCR);
      paramVarArgs.aM(5, this.MCS);
      if (this.MCT != null)
      {
        paramVarArgs.ni(6, this.MCT.computeSize());
        this.MCT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.MCU);
      paramVarArgs.e(8, 8, this.MCV);
      paramVarArgs.cc(9, this.MCW);
      paramVarArgs.e(10, 8, this.MCX);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.APx == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = g.a.a.b.b.a.f(1, this.APx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.state) + g.a.a.a.c(3, 8, this.MCQ) + g.a.a.b.b.a.bu(4, this.MCR) + g.a.a.b.b.a.bu(5, this.MCS);
      paramInt = i;
      if (this.MCT != null) {
        paramInt = i + g.a.a.a.nh(6, this.MCT.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.MCU);
      int j = g.a.a.a.c(8, 8, this.MCV);
      int k = g.a.a.b.b.a.fS(9);
      int m = g.a.a.a.c(10, 8, this.MCX);
      AppMethodBeat.o(117545);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MCQ.clear();
        this.MCV.clear();
        this.MCX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.APx == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxz localcxz = (cxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localcxz.APx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localcxz.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxz.MCQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localcxz.MCR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localcxz.MCS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxz.MCT = ((doy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localcxz.MCU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxz.MCV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localcxz.MCW = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcxz.MCX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxz
 * JD-Core Version:    0.7.0.1
 */