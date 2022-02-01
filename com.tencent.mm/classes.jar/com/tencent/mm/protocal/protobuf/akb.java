package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akb
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String ProductID;
  public String SuH;
  public String Suv;
  public int TOG;
  public int TOH;
  public String Tev;
  public String Tew;
  public String Tex;
  public int Tey;
  public LinkedList<eaf> Ufw;
  public String Ufx;
  public String VHB;
  public String VHC;
  public String VHD;
  public String VHE;
  public int VHF;
  public LinkedList<dhm> VHG;
  public String VHH;
  public String VHI;
  public String VHJ;
  public aka VHK;
  public dkv VHL;
  public int Vdr;
  public int rWt;
  
  public akb()
  {
    AppMethodBeat.i(104776);
    this.Ufw = new LinkedList();
    this.VHG = new LinkedList();
    AppMethodBeat.o(104776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.f(1, this.ProductID);
      }
      if (this.CNj != null) {
        paramVarArgs.f(2, this.CNj);
      }
      if (this.Suv != null) {
        paramVarArgs.f(3, this.Suv);
      }
      if (this.Tev != null) {
        paramVarArgs.f(4, this.Tev);
      }
      if (this.Tew != null) {
        paramVarArgs.f(5, this.Tew);
      }
      if (this.Tex != null) {
        paramVarArgs.f(6, this.Tex);
      }
      paramVarArgs.aY(7, this.Tey);
      paramVarArgs.aY(8, this.TOG);
      paramVarArgs.aY(9, this.TOH);
      paramVarArgs.e(10, 8, this.Ufw);
      if (this.Ufx != null) {
        paramVarArgs.f(11, this.Ufx);
      }
      paramVarArgs.aY(12, this.Vdr);
      if (this.VHB != null) {
        paramVarArgs.f(13, this.VHB);
      }
      if (this.VHC != null) {
        paramVarArgs.f(14, this.VHC);
      }
      if (this.SuH != null) {
        paramVarArgs.f(15, this.SuH);
      }
      if (this.VHD != null) {
        paramVarArgs.f(16, this.VHD);
      }
      if (this.VHE != null) {
        paramVarArgs.f(17, this.VHE);
      }
      paramVarArgs.aY(18, this.VHF);
      paramVarArgs.e(19, 8, this.VHG);
      paramVarArgs.aY(20, this.rWt);
      if (this.VHH != null) {
        paramVarArgs.f(21, this.VHH);
      }
      if (this.VHI != null) {
        paramVarArgs.f(22, this.VHI);
      }
      if (this.VHJ != null) {
        paramVarArgs.f(23, this.VHJ);
      }
      if (this.VHK != null)
      {
        paramVarArgs.oE(24, this.VHK.computeSize());
        this.VHK.writeFields(paramVarArgs);
      }
      if (this.VHL != null)
      {
        paramVarArgs.oE(25, this.VHL.computeSize());
        this.VHL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label1850;
      }
    }
    label1850:
    for (int i = g.a.a.b.b.a.g(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNj);
      }
      i = paramInt;
      if (this.Suv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Suv);
      }
      paramInt = i;
      if (this.Tev != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tev);
      }
      i = paramInt;
      if (this.Tew != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tew);
      }
      paramInt = i;
      if (this.Tex != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tex);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Tey) + g.a.a.b.b.a.bM(8, this.TOG) + g.a.a.b.b.a.bM(9, this.TOH) + g.a.a.a.c(10, 8, this.Ufw);
      paramInt = i;
      if (this.Ufx != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Ufx);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Vdr);
      paramInt = i;
      if (this.VHB != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.VHB);
      }
      i = paramInt;
      if (this.VHC != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.VHC);
      }
      paramInt = i;
      if (this.SuH != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.SuH);
      }
      i = paramInt;
      if (this.VHD != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.VHD);
      }
      paramInt = i;
      if (this.VHE != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.VHE);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.VHF) + g.a.a.a.c(19, 8, this.VHG) + g.a.a.b.b.a.bM(20, this.rWt);
      paramInt = i;
      if (this.VHH != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.VHH);
      }
      i = paramInt;
      if (this.VHI != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.VHI);
      }
      paramInt = i;
      if (this.VHJ != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.VHJ);
      }
      i = paramInt;
      if (this.VHK != null) {
        i = paramInt + g.a.a.a.oD(24, this.VHK.computeSize());
      }
      paramInt = i;
      if (this.VHL != null) {
        paramInt = i + g.a.a.a.oD(25, this.VHL.computeSize());
      }
      AppMethodBeat.o(104777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ufw.clear();
        this.VHG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        akb localakb = (akb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104777);
          return -1;
        case 1: 
          localakb.ProductID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 2: 
          localakb.CNj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 3: 
          localakb.Suv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 4: 
          localakb.Tev = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 5: 
          localakb.Tew = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 6: 
          localakb.Tex = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 7: 
          localakb.Tey = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 8: 
          localakb.TOG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 9: 
          localakb.TOH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localakb.Ufw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 11: 
          localakb.Ufx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 12: 
          localakb.Vdr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 13: 
          localakb.VHB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 14: 
          localakb.VHC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 15: 
          localakb.SuH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 16: 
          localakb.VHD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 17: 
          localakb.VHE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 18: 
          localakb.VHF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhm)localObject2).parseFrom((byte[])localObject1);
            }
            localakb.VHG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 20: 
          localakb.rWt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104777);
          return 0;
        case 21: 
          localakb.VHH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 22: 
          localakb.VHI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 23: 
          localakb.VHJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aka();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aka)localObject2).parseFrom((byte[])localObject1);
            }
            localakb.VHK = ((aka)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dkv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dkv)localObject2).parseFrom((byte[])localObject1);
          }
          localakb.VHL = ((dkv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      AppMethodBeat.o(104777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akb
 * JD-Core Version:    0.7.0.1
 */