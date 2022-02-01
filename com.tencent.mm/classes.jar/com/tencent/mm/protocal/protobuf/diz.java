package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diz
  extends com.tencent.mm.bx.a
{
  public int aaOD;
  public int aaOE;
  public int aaOF;
  public int aaOG;
  public int aaOH;
  public int aaOI;
  public int aaOJ;
  public int aaOK;
  public int aaOL;
  public int aaOM;
  public int aaON;
  public int aaOO;
  public int aaOP;
  public int aaOQ;
  public int aaOR;
  public int aaOS;
  public fxp aaOT;
  public fxp aaOU;
  public fxp aaOV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260153);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaOD);
      paramVarArgs.bS(2, this.aaOE);
      paramVarArgs.bS(3, this.aaOF);
      paramVarArgs.bS(4, this.aaOG);
      paramVarArgs.bS(5, this.aaOH);
      paramVarArgs.bS(6, this.aaOI);
      paramVarArgs.bS(7, this.aaOJ);
      paramVarArgs.bS(8, this.aaOK);
      paramVarArgs.bS(9, this.aaOL);
      paramVarArgs.bS(10, this.aaOM);
      paramVarArgs.bS(11, this.aaON);
      paramVarArgs.bS(12, this.aaOO);
      paramVarArgs.bS(13, this.aaOP);
      paramVarArgs.bS(14, this.aaOQ);
      paramVarArgs.bS(15, this.aaOR);
      paramVarArgs.bS(16, this.aaOS);
      if (this.aaOT != null)
      {
        paramVarArgs.qD(23, this.aaOT.computeSize());
        this.aaOT.writeFields(paramVarArgs);
      }
      if (this.aaOU != null)
      {
        paramVarArgs.qD(24, this.aaOU.computeSize());
        this.aaOU.writeFields(paramVarArgs);
      }
      if (this.aaOV != null)
      {
        paramVarArgs.qD(25, this.aaOV.computeSize());
        this.aaOV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaOD) + 0 + i.a.a.b.b.a.cJ(2, this.aaOE) + i.a.a.b.b.a.cJ(3, this.aaOF) + i.a.a.b.b.a.cJ(4, this.aaOG) + i.a.a.b.b.a.cJ(5, this.aaOH) + i.a.a.b.b.a.cJ(6, this.aaOI) + i.a.a.b.b.a.cJ(7, this.aaOJ) + i.a.a.b.b.a.cJ(8, this.aaOK) + i.a.a.b.b.a.cJ(9, this.aaOL) + i.a.a.b.b.a.cJ(10, this.aaOM) + i.a.a.b.b.a.cJ(11, this.aaON) + i.a.a.b.b.a.cJ(12, this.aaOO) + i.a.a.b.b.a.cJ(13, this.aaOP) + i.a.a.b.b.a.cJ(14, this.aaOQ) + i.a.a.b.b.a.cJ(15, this.aaOR) + i.a.a.b.b.a.cJ(16, this.aaOS);
      paramInt = i;
      if (this.aaOT != null) {
        paramInt = i + i.a.a.a.qC(23, this.aaOT.computeSize());
      }
      i = paramInt;
      if (this.aaOU != null) {
        i = paramInt + i.a.a.a.qC(24, this.aaOU.computeSize());
      }
      paramInt = i;
      if (this.aaOV != null) {
        paramInt = i + i.a.a.a.qC(25, this.aaOV.computeSize());
      }
      AppMethodBeat.o(260153);
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
      AppMethodBeat.o(260153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      diz localdiz = (diz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fxp localfxp;
      switch (paramInt)
      {
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      default: 
        AppMethodBeat.o(260153);
        return -1;
      case 1: 
        localdiz.aaOD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 2: 
        localdiz.aaOE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 3: 
        localdiz.aaOF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 4: 
        localdiz.aaOG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 5: 
        localdiz.aaOH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 6: 
        localdiz.aaOI = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 7: 
        localdiz.aaOJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 8: 
        localdiz.aaOK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 9: 
        localdiz.aaOL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 10: 
        localdiz.aaOM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 11: 
        localdiz.aaON = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 12: 
        localdiz.aaOO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 13: 
        localdiz.aaOP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 14: 
        localdiz.aaOQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 15: 
        localdiz.aaOR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 16: 
        localdiz.aaOS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260153);
        return 0;
      case 23: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfxp = new fxp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfxp.parseFrom((byte[])localObject);
          }
          localdiz.aaOT = localfxp;
          paramInt += 1;
        }
        AppMethodBeat.o(260153);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfxp = new fxp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfxp.parseFrom((byte[])localObject);
          }
          localdiz.aaOU = localfxp;
          paramInt += 1;
        }
        AppMethodBeat.o(260153);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localfxp = new fxp();
        if ((localObject != null) && (localObject.length > 0)) {
          localfxp.parseFrom((byte[])localObject);
        }
        localdiz.aaOV = localfxp;
        paramInt += 1;
      }
      AppMethodBeat.o(260153);
      return 0;
    }
    AppMethodBeat.o(260153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diz
 * JD-Core Version:    0.7.0.1
 */