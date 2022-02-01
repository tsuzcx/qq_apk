package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcc
  extends com.tencent.mm.bw.a
{
  public int FVr;
  public String Kib;
  public String LLm;
  public String LLn;
  public int LLo;
  public String LLp;
  public String LLq;
  public atv LLr;
  public atp LLs;
  public int jjN;
  public String qfq;
  public int recommendType;
  public bda ttR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209670);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qfq != null) {
        paramVarArgs.e(1, this.qfq);
      }
      if (this.LLm != null) {
        paramVarArgs.e(2, this.LLm);
      }
      if (this.LLn != null) {
        paramVarArgs.e(3, this.LLn);
      }
      paramVarArgs.aM(4, this.FVr);
      paramVarArgs.aM(5, this.LLo);
      if (this.LLp != null) {
        paramVarArgs.e(6, this.LLp);
      }
      if (this.LLq != null) {
        paramVarArgs.e(7, this.LLq);
      }
      if (this.Kib != null) {
        paramVarArgs.e(8, this.Kib);
      }
      paramVarArgs.aM(9, this.jjN);
      if (this.LLr != null)
      {
        paramVarArgs.ni(10, this.LLr.computeSize());
        this.LLr.writeFields(paramVarArgs);
      }
      if (this.ttR != null)
      {
        paramVarArgs.ni(11, this.ttR.computeSize());
        this.ttR.writeFields(paramVarArgs);
      }
      if (this.LLs != null)
      {
        paramVarArgs.ni(12, this.LLs.computeSize());
        this.LLs.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.recommendType);
      AppMethodBeat.o(209670);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qfq == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = g.a.a.b.b.a.f(1, this.qfq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LLm != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LLm);
      }
      i = paramInt;
      if (this.LLn != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LLn);
      }
      i = i + g.a.a.b.b.a.bu(4, this.FVr) + g.a.a.b.b.a.bu(5, this.LLo);
      paramInt = i;
      if (this.LLp != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LLp);
      }
      i = paramInt;
      if (this.LLq != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LLq);
      }
      paramInt = i;
      if (this.Kib != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Kib);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.jjN);
      paramInt = i;
      if (this.LLr != null) {
        paramInt = i + g.a.a.a.nh(10, this.LLr.computeSize());
      }
      i = paramInt;
      if (this.ttR != null) {
        i = paramInt + g.a.a.a.nh(11, this.ttR.computeSize());
      }
      paramInt = i;
      if (this.LLs != null) {
        paramInt = i + g.a.a.a.nh(12, this.LLs.computeSize());
      }
      i = g.a.a.b.b.a.bu(13, this.recommendType);
      AppMethodBeat.o(209670);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209670);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcc localbcc = (bcc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209670);
          return -1;
        case 1: 
          localbcc.qfq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 2: 
          localbcc.LLm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 3: 
          localbcc.LLn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 4: 
          localbcc.FVr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209670);
          return 0;
        case 5: 
          localbcc.LLo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209670);
          return 0;
        case 6: 
          localbcc.LLp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 7: 
          localbcc.LLq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 8: 
          localbcc.Kib = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209670);
          return 0;
        case 9: 
          localbcc.jjN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209670);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcc.LLr = ((atv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209670);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bda();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bda)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcc.ttR = ((bda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209670);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcc.LLs = ((atp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209670);
          return 0;
        }
        localbcc.recommendType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209670);
        return 0;
      }
      AppMethodBeat.o(209670);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcc
 * JD-Core Version:    0.7.0.1
 */