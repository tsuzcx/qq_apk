package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ege
  extends com.tencent.mm.bw.a
{
  public long MOC;
  public int MOD;
  public efz NfY;
  public LinkedList<String> NfZ;
  public ale Nga;
  public int Ngb;
  public dkp Ngc;
  public String Ngd;
  public String dSJ;
  public String event;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public ege()
  {
    AppMethodBeat.i(124563);
    this.NfZ = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NfY != null)
      {
        paramVarArgs.ni(1, this.NfY.computeSize());
        this.NfY.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.lastUpdateTime);
      paramVarArgs.aM(3, this.pos);
      paramVarArgs.aM(4, this.weight);
      paramVarArgs.bb(5, this.MOC);
      paramVarArgs.e(6, 1, this.NfZ);
      paramVarArgs.aM(7, this.style);
      if (this.event != null) {
        paramVarArgs.e(8, this.event);
      }
      if (this.Nga != null)
      {
        paramVarArgs.ni(9, this.Nga.computeSize());
        this.Nga.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.Ngb);
      if (this.Ngc != null)
      {
        paramVarArgs.ni(11, this.Ngc.computeSize());
        this.Ngc.writeFields(paramVarArgs);
      }
      if (this.Ngd != null) {
        paramVarArgs.e(12, this.Ngd);
      }
      if (this.dSJ != null) {
        paramVarArgs.e(13, this.dSJ);
      }
      paramVarArgs.aM(14, this.MOD);
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NfY == null) {
        break label1174;
      }
    }
    label1174:
    for (paramInt = g.a.a.a.nh(1, this.NfY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.lastUpdateTime) + g.a.a.b.b.a.bu(3, this.pos) + g.a.a.b.b.a.bu(4, this.weight) + g.a.a.b.b.a.r(5, this.MOC) + g.a.a.a.c(6, 1, this.NfZ) + g.a.a.b.b.a.bu(7, this.style);
      paramInt = i;
      if (this.event != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.event);
      }
      i = paramInt;
      if (this.Nga != null) {
        i = paramInt + g.a.a.a.nh(9, this.Nga.computeSize());
      }
      i += g.a.a.b.b.a.bu(10, this.Ngb);
      paramInt = i;
      if (this.Ngc != null) {
        paramInt = i + g.a.a.a.nh(11, this.Ngc.computeSize());
      }
      i = paramInt;
      if (this.Ngd != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Ngd);
      }
      paramInt = i;
      if (this.dSJ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.dSJ);
      }
      i = g.a.a.b.b.a.bu(14, this.MOD);
      AppMethodBeat.o(124564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NfZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ege localege = (ege)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localege.NfY = ((efz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localege.lastUpdateTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localege.pos = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localege.weight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localege.MOC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localege.NfZ.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124564);
          return 0;
        case 7: 
          localege.style = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124564);
          return 0;
        case 8: 
          localege.event = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ale();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ale)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localege.Nga = ((ale)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 10: 
          localege.Ngb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124564);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localege.Ngc = ((dkp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 12: 
          localege.Ngd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 13: 
          localege.dSJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124564);
          return 0;
        }
        localege.MOD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ege
 * JD-Core Version:    0.7.0.1
 */