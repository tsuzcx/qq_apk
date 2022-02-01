package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dck
  extends com.tencent.mm.bw.a
{
  public LinkedList<dcx> MHA;
  public dcd MHl;
  public dcn MHm;
  public dcr MHn;
  public LinkedList<dco> MHo;
  public LinkedList<dcj> MHp;
  public LinkedList<dch> MHq;
  public dcu MHr;
  public dce MHs;
  public dct MHt;
  public dcy MHu;
  public dcc MHv;
  public LinkedList<dcw> MHw;
  public dco MHx;
  public LinkedList<dcs> MHy;
  public dcq MHz;
  
  public dck()
  {
    AppMethodBeat.i(209785);
    this.MHo = new LinkedList();
    this.MHp = new LinkedList();
    this.MHq = new LinkedList();
    this.MHw = new LinkedList();
    this.MHy = new LinkedList();
    this.MHA = new LinkedList();
    AppMethodBeat.o(209785);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209786);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MHl != null)
      {
        paramVarArgs.ni(1, this.MHl.computeSize());
        this.MHl.writeFields(paramVarArgs);
      }
      if (this.MHm != null)
      {
        paramVarArgs.ni(2, this.MHm.computeSize());
        this.MHm.writeFields(paramVarArgs);
      }
      if (this.MHn != null)
      {
        paramVarArgs.ni(3, this.MHn.computeSize());
        this.MHn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.MHo);
      paramVarArgs.e(5, 8, this.MHp);
      paramVarArgs.e(6, 8, this.MHq);
      if (this.MHr != null)
      {
        paramVarArgs.ni(7, this.MHr.computeSize());
        this.MHr.writeFields(paramVarArgs);
      }
      if (this.MHs != null)
      {
        paramVarArgs.ni(8, this.MHs.computeSize());
        this.MHs.writeFields(paramVarArgs);
      }
      if (this.MHt != null)
      {
        paramVarArgs.ni(9, this.MHt.computeSize());
        this.MHt.writeFields(paramVarArgs);
      }
      if (this.MHu != null)
      {
        paramVarArgs.ni(10, this.MHu.computeSize());
        this.MHu.writeFields(paramVarArgs);
      }
      if (this.MHv != null)
      {
        paramVarArgs.ni(11, this.MHv.computeSize());
        this.MHv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 8, this.MHw);
      if (this.MHx != null)
      {
        paramVarArgs.ni(13, this.MHx.computeSize());
        this.MHx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(14, 8, this.MHy);
      if (this.MHz != null)
      {
        paramVarArgs.ni(15, this.MHz.computeSize());
        this.MHz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.MHA);
      AppMethodBeat.o(209786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MHl == null) {
        break label2550;
      }
    }
    label2550:
    for (int i = g.a.a.a.nh(1, this.MHl.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MHm != null) {
        paramInt = i + g.a.a.a.nh(2, this.MHm.computeSize());
      }
      i = paramInt;
      if (this.MHn != null) {
        i = paramInt + g.a.a.a.nh(3, this.MHn.computeSize());
      }
      i = i + g.a.a.a.c(4, 8, this.MHo) + g.a.a.a.c(5, 8, this.MHp) + g.a.a.a.c(6, 8, this.MHq);
      paramInt = i;
      if (this.MHr != null) {
        paramInt = i + g.a.a.a.nh(7, this.MHr.computeSize());
      }
      i = paramInt;
      if (this.MHs != null) {
        i = paramInt + g.a.a.a.nh(8, this.MHs.computeSize());
      }
      paramInt = i;
      if (this.MHt != null) {
        paramInt = i + g.a.a.a.nh(9, this.MHt.computeSize());
      }
      i = paramInt;
      if (this.MHu != null) {
        i = paramInt + g.a.a.a.nh(10, this.MHu.computeSize());
      }
      paramInt = i;
      if (this.MHv != null) {
        paramInt = i + g.a.a.a.nh(11, this.MHv.computeSize());
      }
      i = paramInt + g.a.a.a.c(12, 8, this.MHw);
      paramInt = i;
      if (this.MHx != null) {
        paramInt = i + g.a.a.a.nh(13, this.MHx.computeSize());
      }
      i = paramInt + g.a.a.a.c(14, 8, this.MHy);
      paramInt = i;
      if (this.MHz != null) {
        paramInt = i + g.a.a.a.nh(15, this.MHz.computeSize());
      }
      i = g.a.a.a.c(16, 8, this.MHA);
      AppMethodBeat.o(209786);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MHo.clear();
        this.MHp.clear();
        this.MHq.clear();
        this.MHw.clear();
        this.MHy.clear();
        this.MHA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dck localdck = (dck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209786);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHl = ((dcd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHm = ((dcn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHn = ((dcr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dco();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dco)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dch();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dch)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHr = ((dcu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dce();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dce)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHs = ((dce)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dct();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dct)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHt = ((dct)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHu = ((dcy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHv = ((dcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dco();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dco)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHx = ((dco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdck.MHz = ((dcq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209786);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdck.MHA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209786);
        return 0;
      }
      AppMethodBeat.o(209786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dck
 * JD-Core Version:    0.7.0.1
 */