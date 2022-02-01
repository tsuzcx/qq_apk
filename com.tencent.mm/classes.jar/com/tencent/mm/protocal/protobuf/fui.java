package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fui
  extends erp
{
  public String IMg;
  public String IMh;
  public int Njs;
  public long Njv;
  public gol NkQ;
  public String YFJ;
  public String YHk;
  public int YTh;
  public int YWB;
  public int YYs;
  public String ZaR;
  public int Zsp;
  public int ZtS;
  public int aaSO;
  public int abSA;
  public int abSB;
  public String abSC;
  public String aesKey;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh != null) {
        paramVarArgs.g(1, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(2, this.IMg);
      }
      paramVarArgs.bS(3, this.YYs);
      paramVarArgs.bS(4, this.YTh);
      if (this.YHk != null) {
        paramVarArgs.g(5, this.YHk);
      }
      paramVarArgs.bS(6, this.Njs);
      paramVarArgs.bS(7, this.YWB);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(8, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.oOu);
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.Zsp);
      if (this.YFJ != null) {
        paramVarArgs.g(12, this.YFJ);
      }
      paramVarArgs.bS(13, this.aaSO);
      paramVarArgs.bS(14, this.abSA);
      paramVarArgs.bS(15, this.abSB);
      paramVarArgs.bv(16, this.Njv);
      paramVarArgs.bS(17, this.ZtS);
      if (this.ZaR != null) {
        paramVarArgs.g(19, this.ZaR);
      }
      if (this.aesKey != null) {
        paramVarArgs.g(20, this.aesKey);
      }
      if (this.abSC != null) {
        paramVarArgs.g(21, this.abSC);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMh == null) {
        break label1342;
      }
    }
    label1342:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IMg);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.YYs) + i.a.a.b.b.a.cJ(4, this.YTh);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YHk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.Njs) + i.a.a.b.b.a.cJ(7, this.YWB);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(8, this.NkQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.oOu);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + i.a.a.a.qC(10, this.BaseRequest.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.Zsp);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YFJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aaSO) + i.a.a.b.b.a.cJ(14, this.abSA) + i.a.a.b.b.a.cJ(15, this.abSB) + i.a.a.b.b.a.q(16, this.Njv) + i.a.a.b.b.a.cJ(17, this.ZtS);
      paramInt = i;
      if (this.ZaR != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ZaR);
      }
      i = paramInt;
      if (this.aesKey != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.aesKey);
      }
      paramInt = i;
      if (this.abSC != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.abSC);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fui localfui = (fui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localfui.IMh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localfui.IMg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localfui.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localfui.YTh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localfui.YHk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localfui.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localfui.YWB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfui.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localfui.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfui.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localfui.Zsp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localfui.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localfui.aaSO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localfui.abSA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localfui.abSB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localfui.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localfui.ZtS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148661);
          return 0;
        case 19: 
          localfui.ZaR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 20: 
          localfui.aesKey = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148661);
          return 0;
        }
        localfui.abSC = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fui
 * JD-Core Version:    0.7.0.1
 */