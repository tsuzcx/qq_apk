package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ene
  extends com.tencent.mm.bx.a
{
  public String YSF;
  public LinkedList<String> YVA;
  public String YVK;
  public int Zwh;
  public String Zxq;
  public String Zxr;
  public LinkedList<enp> abrC;
  public int abrD;
  public String abrE;
  public ens abrF;
  public LinkedList<String> abrG;
  public String abrH;
  public int abrI;
  public int abrJ;
  public int bcb;
  
  public ene()
  {
    AppMethodBeat.i(259971);
    this.abrC = new LinkedList();
    this.YVA = new LinkedList();
    this.abrG = new LinkedList();
    AppMethodBeat.o(259971);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259979);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVK != null) {
        paramVarArgs.g(1, this.YVK);
      }
      paramVarArgs.e(2, 8, this.abrC);
      paramVarArgs.bS(3, this.bcb);
      paramVarArgs.bS(4, this.abrD);
      if (this.YSF != null) {
        paramVarArgs.g(5, this.YSF);
      }
      paramVarArgs.e(6, 1, this.YVA);
      if (this.Zxr != null) {
        paramVarArgs.g(7, this.Zxr);
      }
      if (this.Zxq != null) {
        paramVarArgs.g(8, this.Zxq);
      }
      if (this.abrE != null) {
        paramVarArgs.g(9, this.abrE);
      }
      if (this.abrF != null)
      {
        paramVarArgs.qD(10, this.abrF.computeSize());
        this.abrF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.Zwh);
      paramVarArgs.e(12, 1, this.abrG);
      if (this.abrH != null) {
        paramVarArgs.g(13, this.abrH);
      }
      paramVarArgs.bS(14, this.abrI);
      paramVarArgs.bS(15, this.abrJ);
      AppMethodBeat.o(259979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVK == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = i.a.a.b.b.a.h(1, this.YVK) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.abrC) + i.a.a.b.b.a.cJ(3, this.bcb) + i.a.a.b.b.a.cJ(4, this.abrD);
      paramInt = i;
      if (this.YSF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YSF);
      }
      i = paramInt + i.a.a.a.c(6, 1, this.YVA);
      paramInt = i;
      if (this.Zxr != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zxr);
      }
      i = paramInt;
      if (this.Zxq != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Zxq);
      }
      paramInt = i;
      if (this.abrE != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abrE);
      }
      i = paramInt;
      if (this.abrF != null) {
        i = paramInt + i.a.a.a.qC(10, this.abrF.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(11, this.Zwh) + i.a.a.a.c(12, 1, this.abrG);
      paramInt = i;
      if (this.abrH != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abrH);
      }
      i = i.a.a.b.b.a.cJ(14, this.abrI);
      int j = i.a.a.b.b.a.cJ(15, this.abrJ);
      AppMethodBeat.o(259979);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abrC.clear();
        this.YVA.clear();
        this.abrG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ene localene = (ene)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259979);
          return -1;
        case 1: 
          localene.YVK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enp)localObject2).parseFrom((byte[])localObject1);
            }
            localene.abrC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259979);
          return 0;
        case 3: 
          localene.bcb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259979);
          return 0;
        case 4: 
          localene.abrD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259979);
          return 0;
        case 5: 
          localene.YSF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 6: 
          localene.YVA.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259979);
          return 0;
        case 7: 
          localene.Zxr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 8: 
          localene.Zxq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 9: 
          localene.abrE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ens();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ens)localObject2).parseFrom((byte[])localObject1);
            }
            localene.abrF = ((ens)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259979);
          return 0;
        case 11: 
          localene.Zwh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259979);
          return 0;
        case 12: 
          localene.abrG.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259979);
          return 0;
        case 13: 
          localene.abrH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259979);
          return 0;
        case 14: 
          localene.abrI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259979);
          return 0;
        }
        localene.abrJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259979);
        return 0;
      }
      AppMethodBeat.o(259979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ene
 * JD-Core Version:    0.7.0.1
 */