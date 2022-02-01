package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uq
  extends com.tencent.mm.bw.a
{
  public String ANo;
  public ehf KEN;
  public dqe KEP;
  public String KNW;
  public ccy Led;
  public LinkedList<ehf> Lee;
  public int Lef;
  public int Leg;
  public String dDj;
  public int state;
  
  public uq()
  {
    AppMethodBeat.i(91394);
    this.Lee = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Led != null)
      {
        paramVarArgs.ni(1, this.Led.computeSize());
        this.Led.writeFields(paramVarArgs);
      }
      if (this.KEN != null)
      {
        paramVarArgs.ni(2, this.KEN.computeSize());
        this.KEN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Lee);
      if (this.ANo != null) {
        paramVarArgs.e(4, this.ANo);
      }
      if (this.dDj != null) {
        paramVarArgs.e(5, this.dDj);
      }
      if (this.KEP != null)
      {
        paramVarArgs.ni(6, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.state);
      paramVarArgs.aM(8, this.Lef);
      paramVarArgs.aM(9, this.Leg);
      if (this.KNW != null) {
        paramVarArgs.e(10, this.KNW);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Led == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = g.a.a.a.nh(1, this.Led.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KEN != null) {
        i = paramInt + g.a.a.a.nh(2, this.KEN.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.Lee);
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ANo);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dDj);
      }
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(6, this.KEP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.state) + g.a.a.b.b.a.bu(8, this.Lef) + g.a.a.b.b.a.bu(9, this.Leg);
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KNW);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lee.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        uq localuq = (uq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
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
            localuq.Led = ((ccy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
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
            localuq.KEN = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
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
            localuq.Lee.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localuq.ANo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localuq.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localuq.KEP = ((dqe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localuq.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localuq.Lef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localuq.Leg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91395);
          return 0;
        }
        localuq.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uq
 * JD-Core Version:    0.7.0.1
 */