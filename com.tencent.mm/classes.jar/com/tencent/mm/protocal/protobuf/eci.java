package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eci
  extends com.tencent.mm.bx.a
{
  public String MEq;
  public String Oks;
  public String aaGL;
  public int abhR;
  public String abhS;
  public int abhT;
  public String abhU;
  public int abhV;
  public String abhW;
  public long abhX;
  public LinkedList<ebx> abhY;
  public String des;
  
  public eci()
  {
    AppMethodBeat.i(91593);
    this.abhY = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abhR);
      if (this.abhS != null) {
        paramVarArgs.g(2, this.abhS);
      }
      if (this.aaGL != null) {
        paramVarArgs.g(3, this.aaGL);
      }
      paramVarArgs.bS(4, this.abhT);
      if (this.MEq != null) {
        paramVarArgs.g(5, this.MEq);
      }
      if (this.abhU != null) {
        paramVarArgs.g(6, this.abhU);
      }
      if (this.Oks != null) {
        paramVarArgs.g(7, this.Oks);
      }
      paramVarArgs.bS(8, this.abhV);
      if (this.des != null) {
        paramVarArgs.g(9, this.des);
      }
      if (this.abhW != null) {
        paramVarArgs.g(10, this.abhW);
      }
      paramVarArgs.bv(11, this.abhX);
      paramVarArgs.e(12, 8, this.abhY);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abhR) + 0;
      paramInt = i;
      if (this.abhS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abhS);
      }
      i = paramInt;
      if (this.aaGL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaGL);
      }
      i += i.a.a.b.b.a.cJ(4, this.abhT);
      paramInt = i;
      if (this.MEq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.MEq);
      }
      i = paramInt;
      if (this.abhU != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abhU);
      }
      paramInt = i;
      if (this.Oks != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Oks);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abhV);
      paramInt = i;
      if (this.des != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.des);
      }
      i = paramInt;
      if (this.abhW != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abhW);
      }
      paramInt = i.a.a.b.b.a.q(11, this.abhX);
      int j = i.a.a.a.c(12, 8, this.abhY);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abhY.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eci localeci = (eci)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localeci.abhR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localeci.abhS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localeci.aaGL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localeci.abhT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localeci.MEq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localeci.abhU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localeci.Oks = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localeci.abhV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localeci.des = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localeci.abhW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localeci.abhX = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ebx localebx = new ebx();
        if ((localObject != null) && (localObject.length > 0)) {
          localebx.parseFrom((byte[])localObject);
        }
        localeci.abhY.add(localebx);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eci
 * JD-Core Version:    0.7.0.1
 */