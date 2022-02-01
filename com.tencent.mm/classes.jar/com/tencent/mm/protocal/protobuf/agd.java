package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agd
  extends com.tencent.mm.bx.a
{
  public String IMu;
  public String UserName;
  public gol YFI;
  public String ZoW;
  public String ZoX;
  public int ZoY;
  public int ZoZ;
  public String Zpa;
  public int Zpb;
  public String Zpc;
  public String Zpd;
  public int Zpe;
  public int Zpf;
  public LinkedList<esv> Zpg;
  public String Zph;
  public int Zpi;
  public int Zpj;
  public int Zpk;
  public int Zpl;
  public int pSf;
  public String pSk;
  public String vhX;
  
  public agd()
  {
    AppMethodBeat.i(32174);
    this.Zpg = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.ZoW != null) {
        paramVarArgs.g(3, this.ZoW);
      }
      if (this.ZoX != null) {
        paramVarArgs.g(4, this.ZoX);
      }
      paramVarArgs.bS(5, this.pSf);
      if (this.YFI != null)
      {
        paramVarArgs.qD(6, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.ZoY);
      paramVarArgs.bS(8, this.ZoZ);
      if (this.Zpa != null) {
        paramVarArgs.g(9, this.Zpa);
      }
      paramVarArgs.bS(10, this.Zpb);
      if (this.Zpc != null) {
        paramVarArgs.g(11, this.Zpc);
      }
      if (this.Zpd != null) {
        paramVarArgs.g(12, this.Zpd);
      }
      paramVarArgs.bS(13, this.Zpe);
      paramVarArgs.bS(14, this.Zpf);
      paramVarArgs.e(15, 8, this.Zpg);
      if (this.Zph != null) {
        paramVarArgs.g(16, this.Zph);
      }
      paramVarArgs.bS(17, this.Zpi);
      paramVarArgs.bS(18, this.Zpj);
      if (this.IMu != null) {
        paramVarArgs.g(19, this.IMu);
      }
      paramVarArgs.bS(20, this.Zpk);
      paramVarArgs.bS(21, this.Zpl);
      if (this.pSk != null) {
        paramVarArgs.g(22, this.pSk);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.ZoW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZoW);
      }
      paramInt = i;
      if (this.ZoX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZoX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.pSf);
      paramInt = i;
      if (this.YFI != null) {
        paramInt = i + i.a.a.a.qC(6, this.YFI.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZoY) + i.a.a.b.b.a.cJ(8, this.ZoZ);
      paramInt = i;
      if (this.Zpa != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zpa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.Zpb);
      paramInt = i;
      if (this.Zpc != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Zpc);
      }
      i = paramInt;
      if (this.Zpd != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Zpd);
      }
      i = i + i.a.a.b.b.a.cJ(13, this.Zpe) + i.a.a.b.b.a.cJ(14, this.Zpf) + i.a.a.a.c(15, 8, this.Zpg);
      paramInt = i;
      if (this.Zph != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Zph);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.Zpi) + i.a.a.b.b.a.cJ(18, this.Zpj);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.IMu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.Zpk) + i.a.a.b.b.a.cJ(21, this.Zpl);
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.pSk);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zpg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agd localagd = (agd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localagd.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localagd.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localagd.ZoW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localagd.ZoX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localagd.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
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
            localagd.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localagd.ZoY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localagd.ZoZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localagd.Zpa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localagd.Zpb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localagd.Zpc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localagd.Zpd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localagd.Zpe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localagd.Zpf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esv)localObject2).parseFrom((byte[])localObject1);
            }
            localagd.Zpg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localagd.Zph = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localagd.Zpi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localagd.Zpj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localagd.IMu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localagd.Zpk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localagd.Zpl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32175);
          return 0;
        }
        localagd.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agd
 * JD-Core Version:    0.7.0.1
 */