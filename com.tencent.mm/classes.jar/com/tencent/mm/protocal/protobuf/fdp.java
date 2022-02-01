package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdp
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int IcB;
  public int IsNotRichText;
  public epj YGq;
  public String Zvy;
  public String abDe;
  public String abDf;
  public int abDg;
  public int abDh;
  public long abDi;
  public long abDj;
  public gol abDk;
  public int abDl;
  public LinkedList<feb> abDm;
  public int abDn;
  public String abnl;
  public String nUB;
  public int vhJ;
  
  public fdp()
  {
    AppMethodBeat.i(125770);
    this.abDm = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abnl != null) {
        paramVarArgs.g(1, this.abnl);
      }
      if (this.Zvy != null) {
        paramVarArgs.g(2, this.Zvy);
      }
      if (this.abDe != null) {
        paramVarArgs.g(3, this.abDe);
      }
      if (this.abDf != null) {
        paramVarArgs.g(4, this.abDf);
      }
      paramVarArgs.bS(5, this.vhJ);
      paramVarArgs.bS(6, this.IcB);
      paramVarArgs.bS(7, this.CreateTime);
      if (this.nUB != null) {
        paramVarArgs.g(8, this.nUB);
      }
      paramVarArgs.bS(9, this.abDg);
      paramVarArgs.bS(10, this.abDh);
      paramVarArgs.bS(11, this.IsNotRichText);
      paramVarArgs.bv(12, this.abDi);
      paramVarArgs.bv(13, this.abDj);
      if (this.abDk != null)
      {
        paramVarArgs.qD(14, this.abDk.computeSize());
        this.abDk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.abDl);
      if (this.YGq != null)
      {
        paramVarArgs.qD(16, this.YGq.computeSize());
        this.YGq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.abDm);
      paramVarArgs.bS(18, this.abDn);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abnl == null) {
        break label1292;
      }
    }
    label1292:
    for (int i = i.a.a.b.b.a.h(1, this.abnl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zvy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zvy);
      }
      i = paramInt;
      if (this.abDe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abDe);
      }
      paramInt = i;
      if (this.abDf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abDf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.vhJ) + i.a.a.b.b.a.cJ(6, this.IcB) + i.a.a.b.b.a.cJ(7, this.CreateTime);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.abDg) + i.a.a.b.b.a.cJ(10, this.abDh) + i.a.a.b.b.a.cJ(11, this.IsNotRichText) + i.a.a.b.b.a.q(12, this.abDi) + i.a.a.b.b.a.q(13, this.abDj);
      paramInt = i;
      if (this.abDk != null) {
        paramInt = i + i.a.a.a.qC(14, this.abDk.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.abDl);
      paramInt = i;
      if (this.YGq != null) {
        paramInt = i + i.a.a.a.qC(16, this.YGq.computeSize());
      }
      i = i.a.a.a.c(17, 8, this.abDm);
      int j = i.a.a.b.b.a.cJ(18, this.abDn);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abDm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdp localfdp = (fdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localfdp.abnl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localfdp.Zvy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localfdp.abDe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localfdp.abDf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localfdp.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localfdp.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localfdp.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localfdp.nUB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localfdp.abDg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localfdp.abDh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localfdp.IsNotRichText = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localfdp.abDi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localfdp.abDj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
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
            localfdp.abDk = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localfdp.abDl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epj)localObject2).parseFrom((byte[])localObject1);
            }
            localfdp.YGq = ((epj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new feb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((feb)localObject2).parseFrom((byte[])localObject1);
            }
            localfdp.abDm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localfdp.abDn = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdp
 * JD-Core Version:    0.7.0.1
 */