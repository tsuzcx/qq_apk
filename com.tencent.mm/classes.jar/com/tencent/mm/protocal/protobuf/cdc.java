package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cdc
  extends com.tencent.mm.bx.a
{
  public String IHZ;
  public String UserName;
  public int ZjF;
  public String aamI;
  public String aamJ;
  public int aamK;
  public String aamL;
  public String aamM;
  public String aamN;
  public int aamO;
  public int aamP;
  public int aamQ;
  public b aamR;
  public LinkedList<dam> aamS;
  public b aamT;
  public String hAP;
  public String nUB;
  
  public cdc()
  {
    AppMethodBeat.i(257612);
    this.aamS = new LinkedList();
    AppMethodBeat.o(257612);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZjF);
      if (this.aamI != null) {
        paramVarArgs.g(2, this.aamI);
      }
      if (this.aamJ != null) {
        paramVarArgs.g(3, this.aamJ);
      }
      paramVarArgs.bS(4, this.aamK);
      if (this.hAP != null) {
        paramVarArgs.g(5, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(6, this.nUB);
      }
      if (this.UserName != null) {
        paramVarArgs.g(7, this.UserName);
      }
      if (this.aamL != null) {
        paramVarArgs.g(8, this.aamL);
      }
      if (this.IHZ != null) {
        paramVarArgs.g(10, this.IHZ);
      }
      if (this.aamM != null) {
        paramVarArgs.g(11, this.aamM);
      }
      if (this.aamN != null) {
        paramVarArgs.g(12, this.aamN);
      }
      paramVarArgs.bS(13, this.aamO);
      paramVarArgs.bS(14, this.aamP);
      paramVarArgs.bS(15, this.aamQ);
      if (this.aamR != null) {
        paramVarArgs.d(16, this.aamR);
      }
      paramVarArgs.e(17, 8, this.aamS);
      if (this.aamT != null) {
        paramVarArgs.d(18, this.aamT);
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZjF) + 0;
      paramInt = i;
      if (this.aamI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aamI);
      }
      i = paramInt;
      if (this.aamJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aamJ);
      }
      i += i.a.a.b.b.a.cJ(4, this.aamK);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hAP);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nUB);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.UserName);
      }
      i = paramInt;
      if (this.aamL != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aamL);
      }
      paramInt = i;
      if (this.IHZ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.IHZ);
      }
      i = paramInt;
      if (this.aamM != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aamM);
      }
      paramInt = i;
      if (this.aamN != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aamN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aamO) + i.a.a.b.b.a.cJ(14, this.aamP) + i.a.a.b.b.a.cJ(15, this.aamQ);
      paramInt = i;
      if (this.aamR != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.aamR);
      }
      i = paramInt + i.a.a.a.c(17, 8, this.aamS);
      paramInt = i;
      if (this.aamT != null) {
        paramInt = i + i.a.a.b.b.a.c(18, this.aamT);
      }
      AppMethodBeat.o(152549);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aamS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cdc localcdc = (cdc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localcdc.ZjF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localcdc.aamI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localcdc.aamJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localcdc.aamK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localcdc.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localcdc.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localcdc.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localcdc.aamL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localcdc.IHZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localcdc.aamM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localcdc.aamN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localcdc.aamO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localcdc.aamP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localcdc.aamQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localcdc.aamR = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(152549);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dam localdam = new dam();
          if ((localObject != null) && (localObject.length > 0)) {
            localdam.parseFrom((byte[])localObject);
          }
          localcdc.aamS.add(localdam);
          paramInt += 1;
        }
        AppMethodBeat.o(152549);
        return 0;
      }
      localcdc.aamT = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdc
 * JD-Core Version:    0.7.0.1
 */