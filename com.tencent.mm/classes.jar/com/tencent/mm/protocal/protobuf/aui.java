package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aui
  extends dop
{
  public apc LAv;
  public aov LBM;
  public avk LDR;
  public b LDs;
  public int LFc;
  public bdd LFd;
  public LinkedList<cmm> LFe;
  public LinkedList<bdv> LFf;
  public axj LFg;
  public auk LFh;
  public float dTj;
  public int eaQ;
  public float latitude;
  
  public aui()
  {
    AppMethodBeat.i(209473);
    this.LFe = new LinkedList();
    this.LFf = new LinkedList();
    AppMethodBeat.o(209473);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.E(4, this.dTj);
      paramVarArgs.E(5, this.latitude);
      if (this.LAv != null)
      {
        paramVarArgs.ni(6, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      if (this.LDR != null)
      {
        paramVarArgs.ni(7, this.LDR.computeSize());
        this.LDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.LFc);
      if (this.LFd != null)
      {
        paramVarArgs.ni(9, this.LFd.computeSize());
        this.LFd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.LFe);
      paramVarArgs.e(11, 8, this.LFf);
      if (this.LFg != null)
      {
        paramVarArgs.ni(12, this.LFg.computeSize());
        this.LFg.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.eaQ);
      if (this.LFh != null)
      {
        paramVarArgs.ni(14, this.LFh.computeSize());
        this.LFh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1768;
      }
    }
    label1768:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDs);
      }
      i = i + (g.a.a.b.b.a.fS(4) + 4) + (g.a.a.b.b.a.fS(5) + 4);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(6, this.LAv.computeSize());
      }
      i = paramInt;
      if (this.LDR != null) {
        i = paramInt + g.a.a.a.nh(7, this.LDR.computeSize());
      }
      i += g.a.a.b.b.a.bu(8, this.LFc);
      paramInt = i;
      if (this.LFd != null) {
        paramInt = i + g.a.a.a.nh(9, this.LFd.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.LFe) + g.a.a.a.c(11, 8, this.LFf);
      paramInt = i;
      if (this.LFg != null) {
        paramInt = i + g.a.a.a.nh(12, this.LFg.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.eaQ);
      paramInt = i;
      if (this.LFh != null) {
        paramInt = i + g.a.a.a.nh(14, this.LFh.computeSize());
      }
      AppMethodBeat.o(209474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LFe.clear();
        this.LFf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209474);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 3: 
          localaui.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209474);
          return 0;
        case 4: 
          localaui.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209474);
          return 0;
        case 5: 
          localaui.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209474);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LDR = ((avk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 8: 
          localaui.LFc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209474);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LFd = ((bdd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LFe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LFf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaui.LFg = ((axj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209474);
          return 0;
        case 13: 
          localaui.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209474);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaui.LFh = ((auk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209474);
        return 0;
      }
      AppMethodBeat.o(209474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */