package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pf
  extends erp
{
  public String DVu;
  public LinkedList<pv> YSB;
  public int YSC;
  public String YSD;
  public long YSE;
  public String YSF;
  public vv YSG;
  public pe YSH;
  public gd YSI;
  public String YSJ;
  public int bcb;
  public LinkedList<eny> lPK;
  
  public pf()
  {
    AppMethodBeat.i(258415);
    this.YSB = new LinkedList();
    this.lPK = new LinkedList();
    AppMethodBeat.o(258415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YSB);
      paramVarArgs.bS(3, this.YSC);
      paramVarArgs.bS(4, this.bcb);
      if (this.YSD != null) {
        paramVarArgs.g(5, this.YSD);
      }
      paramVarArgs.bv(6, this.YSE);
      if (this.YSF != null) {
        paramVarArgs.g(7, this.YSF);
      }
      if (this.YSG != null)
      {
        paramVarArgs.qD(8, this.YSG.computeSize());
        this.YSG.writeFields(paramVarArgs);
      }
      if (this.YSH != null)
      {
        paramVarArgs.qD(9, this.YSH.computeSize());
        this.YSH.writeFields(paramVarArgs);
      }
      if (this.YSI != null)
      {
        paramVarArgs.qD(10, this.YSI.computeSize());
        this.YSI.writeFields(paramVarArgs);
      }
      if (this.YSJ != null) {
        paramVarArgs.g(11, this.YSJ);
      }
      if (this.DVu != null) {
        paramVarArgs.g(12, this.DVu);
      }
      paramVarArgs.e(13, 8, this.lPK);
      AppMethodBeat.o(258425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1302;
      }
    }
    label1302:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YSB) + i.a.a.b.b.a.cJ(3, this.YSC) + i.a.a.b.b.a.cJ(4, this.bcb);
      paramInt = i;
      if (this.YSD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YSD);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.YSE);
      paramInt = i;
      if (this.YSF != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YSF);
      }
      i = paramInt;
      if (this.YSG != null) {
        i = paramInt + i.a.a.a.qC(8, this.YSG.computeSize());
      }
      paramInt = i;
      if (this.YSH != null) {
        paramInt = i + i.a.a.a.qC(9, this.YSH.computeSize());
      }
      i = paramInt;
      if (this.YSI != null) {
        i = paramInt + i.a.a.a.qC(10, this.YSI.computeSize());
      }
      paramInt = i;
      if (this.YSJ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YSJ);
      }
      i = paramInt;
      if (this.DVu != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.DVu);
      }
      paramInt = i.a.a.a.c(13, 8, this.lPK);
      AppMethodBeat.o(258425);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YSB.clear();
        this.lPK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        pf localpf = (pf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258425);
          return -1;
        case 1: 
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
            localpf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258425);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pv)localObject2).parseFrom((byte[])localObject1);
            }
            localpf.YSB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258425);
          return 0;
        case 3: 
          localpf.YSC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258425);
          return 0;
        case 4: 
          localpf.bcb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258425);
          return 0;
        case 5: 
          localpf.YSD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258425);
          return 0;
        case 6: 
          localpf.YSE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258425);
          return 0;
        case 7: 
          localpf.YSF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258425);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vv)localObject2).parseFrom((byte[])localObject1);
            }
            localpf.YSG = ((vv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258425);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pe)localObject2).parseFrom((byte[])localObject1);
            }
            localpf.YSH = ((pe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258425);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gd)localObject2).parseFrom((byte[])localObject1);
            }
            localpf.YSI = ((gd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258425);
          return 0;
        case 11: 
          localpf.YSJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258425);
          return 0;
        case 12: 
          localpf.DVu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258425);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eny();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eny)localObject2).parseFrom((byte[])localObject1);
          }
          localpf.lPK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258425);
        return 0;
      }
      AppMethodBeat.o(258425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */