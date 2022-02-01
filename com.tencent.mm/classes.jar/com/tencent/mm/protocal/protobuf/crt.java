package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class crt
  extends com.tencent.mm.bw.a
{
  public String MwB;
  public String MwM;
  public crr MwN;
  public crp MwO;
  public crs MwP;
  public ffq Uub;
  public int dUm;
  public String sGQ;
  public long viC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sGQ != null) {
        paramVarArgs.e(1, this.sGQ);
      }
      paramVarArgs.bb(2, this.viC);
      if (this.MwM != null) {
        paramVarArgs.e(3, this.MwM);
      }
      paramVarArgs.aM(4, this.dUm);
      if (this.MwB != null) {
        paramVarArgs.e(5, this.MwB);
      }
      if (this.MwN != null)
      {
        paramVarArgs.ni(6, this.MwN.computeSize());
        this.MwN.writeFields(paramVarArgs);
      }
      if (this.MwO != null)
      {
        paramVarArgs.ni(7, this.MwO.computeSize());
        this.MwO.writeFields(paramVarArgs);
      }
      if (this.MwP != null)
      {
        paramVarArgs.ni(8, this.MwP.computeSize());
        this.MwP.writeFields(paramVarArgs);
      }
      if (this.Uub != null)
      {
        paramVarArgs.ni(9, this.Uub.computeSize());
        this.Uub.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(208707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGQ == null) {
        break label1050;
      }
    }
    label1050:
    for (paramInt = g.a.a.b.b.a.f(1, this.sGQ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.viC);
      paramInt = i;
      if (this.MwM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MwM);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.dUm);
      paramInt = i;
      if (this.MwB != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MwB);
      }
      i = paramInt;
      if (this.MwN != null) {
        i = paramInt + g.a.a.a.nh(6, this.MwN.computeSize());
      }
      paramInt = i;
      if (this.MwO != null) {
        paramInt = i + g.a.a.a.nh(7, this.MwO.computeSize());
      }
      i = paramInt;
      if (this.MwP != null) {
        i = paramInt + g.a.a.a.nh(8, this.MwP.computeSize());
      }
      paramInt = i;
      if (this.Uub != null) {
        paramInt = i + g.a.a.a.nh(9, this.Uub.computeSize());
      }
      AppMethodBeat.o(208707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        crt localcrt = (crt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208707);
          return -1;
        case 1: 
          localcrt.sGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208707);
          return 0;
        case 2: 
          localcrt.viC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(208707);
          return 0;
        case 3: 
          localcrt.MwM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208707);
          return 0;
        case 4: 
          localcrt.dUm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(208707);
          return 0;
        case 5: 
          localcrt.MwB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208707);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcrt.MwN = ((crr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208707);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcrt.MwO = ((crp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208707);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcrt.MwP = ((crs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208707);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ffq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ffq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcrt.Uub = ((ffq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(208707);
        return 0;
      }
      AppMethodBeat.o(208707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crt
 * JD-Core Version:    0.7.0.1
 */