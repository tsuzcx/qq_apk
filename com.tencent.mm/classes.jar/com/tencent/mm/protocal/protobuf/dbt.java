package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbt
  extends com.tencent.mm.bw.a
{
  public String AOk;
  public String CiX;
  public String Htm;
  public String Htn;
  public int Htr;
  public String Hts;
  public ejl MGF;
  public cre MGG;
  public cpa MGH;
  public String dDj;
  public long eht;
  public int grV;
  public int state;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.grV);
      paramVarArgs.bb(2, this.eht);
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      if (this.AOk != null) {
        paramVarArgs.e(4, this.AOk);
      }
      if (this.Htm != null) {
        paramVarArgs.e(5, this.Htm);
      }
      if (this.Htn != null) {
        paramVarArgs.e(6, this.Htn);
      }
      if (this.MGF != null)
      {
        paramVarArgs.ni(7, this.MGF.computeSize());
        this.MGF.writeFields(paramVarArgs);
      }
      if (this.MGG != null)
      {
        paramVarArgs.ni(8, this.MGG.computeSize());
        this.MGG.writeFields(paramVarArgs);
      }
      if (this.MGH != null)
      {
        paramVarArgs.ni(9, this.MGH.computeSize());
        this.MGH.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.Htr);
      paramVarArgs.aM(11, this.state);
      if (this.ynT != null) {
        paramVarArgs.e(12, this.ynT);
      }
      if (this.CiX != null) {
        paramVarArgs.e(13, this.CiX);
      }
      if (this.Hts != null) {
        paramVarArgs.e(14, this.Hts);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.grV) + 0 + g.a.a.b.b.a.r(2, this.eht);
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dDj);
      }
      i = paramInt;
      if (this.AOk != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.AOk);
      }
      paramInt = i;
      if (this.Htm != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Htm);
      }
      i = paramInt;
      if (this.Htn != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Htn);
      }
      paramInt = i;
      if (this.MGF != null) {
        paramInt = i + g.a.a.a.nh(7, this.MGF.computeSize());
      }
      i = paramInt;
      if (this.MGG != null) {
        i = paramInt + g.a.a.a.nh(8, this.MGG.computeSize());
      }
      paramInt = i;
      if (this.MGH != null) {
        paramInt = i + g.a.a.a.nh(9, this.MGH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.Htr) + g.a.a.b.b.a.bu(11, this.state);
      paramInt = i;
      if (this.ynT != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ynT);
      }
      i = paramInt;
      if (this.CiX != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.CiX);
      }
      paramInt = i;
      if (this.Hts != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Hts);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dbt localdbt = (dbt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localdbt.grV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localdbt.eht = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localdbt.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localdbt.AOk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localdbt.Htm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localdbt.Htn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbt.MGF = ((ejl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cre();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cre)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbt.MGG = ((cre)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpa();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbt.MGH = ((cpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localdbt.Htr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localdbt.state = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localdbt.ynT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localdbt.CiX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localdbt.Hts = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */