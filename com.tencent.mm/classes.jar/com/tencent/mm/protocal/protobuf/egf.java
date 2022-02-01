package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egf
  extends com.tencent.mm.bw.a
{
  public dqe KEP;
  public String KNW;
  public cyf MTe;
  public ccy Nge;
  public LinkedList<ehf> Ngf;
  public LinkedList<ehf> Ngg;
  public ccy Ngh;
  public dlp Ngi;
  public dqd Ngj;
  
  public egf()
  {
    AppMethodBeat.i(91707);
    this.Ngf = new LinkedList();
    this.Ngg = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nge != null)
      {
        paramVarArgs.ni(1, this.Nge.computeSize());
        this.Nge.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Ngf);
      paramVarArgs.e(3, 8, this.Ngg);
      if (this.Ngh != null)
      {
        paramVarArgs.ni(4, this.Ngh.computeSize());
        this.Ngh.writeFields(paramVarArgs);
      }
      if (this.Ngi != null)
      {
        paramVarArgs.ni(5, this.Ngi.computeSize());
        this.Ngi.writeFields(paramVarArgs);
      }
      if (this.KNW != null) {
        paramVarArgs.e(6, this.KNW);
      }
      if (this.MTe != null)
      {
        paramVarArgs.ni(7, this.MTe.computeSize());
        this.MTe.writeFields(paramVarArgs);
      }
      if (this.KEP != null)
      {
        paramVarArgs.ni(8, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      if (this.Ngj != null)
      {
        paramVarArgs.ni(9, this.Ngj.computeSize());
        this.Ngj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nge == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = g.a.a.a.nh(1, this.Nge.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Ngf) + g.a.a.a.c(3, 8, this.Ngg);
      paramInt = i;
      if (this.Ngh != null) {
        paramInt = i + g.a.a.a.nh(4, this.Ngh.computeSize());
      }
      i = paramInt;
      if (this.Ngi != null) {
        i = paramInt + g.a.a.a.nh(5, this.Ngi.computeSize());
      }
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNW);
      }
      i = paramInt;
      if (this.MTe != null) {
        i = paramInt + g.a.a.a.nh(7, this.MTe.computeSize());
      }
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(8, this.KEP.computeSize());
      }
      i = paramInt;
      if (this.Ngj != null) {
        i = paramInt + g.a.a.a.nh(9, this.Ngj.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ngf.clear();
        this.Ngg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egf localegf = (egf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.Nge = ((ccy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.Ngf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.Ngg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.Ngh = ((ccy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.Ngi = ((dlp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localegf.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.MTe = ((cyf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegf.KEP = ((dqe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localegf.Ngj = ((dqd)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egf
 * JD-Core Version:    0.7.0.1
 */