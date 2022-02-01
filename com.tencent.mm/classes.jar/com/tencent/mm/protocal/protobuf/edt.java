package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edt
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String MEp;
  public String Ocp;
  public String UZA;
  public String UZB;
  public int UZF;
  public String UZG;
  public foy abiR;
  public drc abiS;
  public dov abiT;
  public int day;
  public String hAk;
  public long ihV;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.day);
      paramVarArgs.bv(2, this.ihV);
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      if (this.MEp != null) {
        paramVarArgs.g(4, this.MEp);
      }
      if (this.UZA != null) {
        paramVarArgs.g(5, this.UZA);
      }
      if (this.UZB != null) {
        paramVarArgs.g(6, this.UZB);
      }
      if (this.abiR != null)
      {
        paramVarArgs.qD(7, this.abiR.computeSize());
        this.abiR.writeFields(paramVarArgs);
      }
      if (this.abiS != null)
      {
        paramVarArgs.qD(8, this.abiS.computeSize());
        this.abiS.writeFields(paramVarArgs);
      }
      if (this.abiT != null)
      {
        paramVarArgs.qD(9, this.abiT.computeSize());
        this.abiT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.UZF);
      paramVarArgs.bS(11, this.state);
      if (this.JFk != null) {
        paramVarArgs.g(12, this.JFk);
      }
      if (this.Ocp != null) {
        paramVarArgs.g(13, this.Ocp);
      }
      if (this.UZG != null) {
        paramVarArgs.g(14, this.UZG);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.day) + 0 + i.a.a.b.b.a.q(2, this.ihV);
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hAk);
      }
      i = paramInt;
      if (this.MEp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.MEp);
      }
      paramInt = i;
      if (this.UZA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.UZA);
      }
      i = paramInt;
      if (this.UZB != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.UZB);
      }
      paramInt = i;
      if (this.abiR != null) {
        paramInt = i + i.a.a.a.qC(7, this.abiR.computeSize());
      }
      i = paramInt;
      if (this.abiS != null) {
        i = paramInt + i.a.a.a.qC(8, this.abiS.computeSize());
      }
      paramInt = i;
      if (this.abiT != null) {
        paramInt = i + i.a.a.a.qC(9, this.abiT.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.UZF) + i.a.a.b.b.a.cJ(11, this.state);
      paramInt = i;
      if (this.JFk != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.JFk);
      }
      i = paramInt;
      if (this.Ocp != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Ocp);
      }
      paramInt = i;
      if (this.UZG != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.UZG);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      edt localedt = (edt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localedt.day = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localedt.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localedt.hAk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localedt.MEp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localedt.UZA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localedt.UZB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new foy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((foy)localObject2).parseFrom((byte[])localObject1);
          }
          localedt.abiR = ((foy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new drc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((drc)localObject2).parseFrom((byte[])localObject1);
          }
          localedt.abiS = ((drc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dov();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dov)localObject2).parseFrom((byte[])localObject1);
          }
          localedt.abiT = ((dov)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localedt.UZF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localedt.state = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localedt.JFk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localedt.Ocp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localedt.UZG = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edt
 * JD-Core Version:    0.7.0.1
 */