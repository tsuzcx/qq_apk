package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnc
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public int Privated;
  public int aaPu;
  public String aaTE;
  public int aaTG;
  public int aaTH;
  public int aaTP;
  public String aaTQ;
  public dmu aaUe;
  public int aaUf;
  public LinkedList<dmu> aaUg;
  public String aaUh;
  public String aaUi;
  public String aaUj;
  public dmb aaUk;
  public int aaUl;
  public String appid;
  public int cIh;
  public int hGM;
  public String md5;
  public int nrQ;
  public String token;
  public String videoPath;
  
  public dnc()
  {
    AppMethodBeat.i(125747);
    this.aaUg = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaTG);
      paramVarArgs.bS(2, this.aaTH);
      paramVarArgs.bS(3, this.Privated);
      if (this.aaUe != null)
      {
        paramVarArgs.qD(4, this.aaUe.computeSize());
        this.aaUe.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aaUf);
      paramVarArgs.e(6, 8, this.aaUg);
      paramVarArgs.bS(7, this.nrQ);
      paramVarArgs.bS(8, this.aaPu);
      if (this.IGG != null) {
        paramVarArgs.g(9, this.IGG);
      }
      if (this.aaUh != null) {
        paramVarArgs.g(10, this.aaUh);
      }
      if (this.token != null) {
        paramVarArgs.g(11, this.token);
      }
      if (this.aaTQ != null) {
        paramVarArgs.g(12, this.aaTQ);
      }
      paramVarArgs.bS(13, this.aaTP);
      if (this.videoPath != null) {
        paramVarArgs.g(14, this.videoPath);
      }
      if (this.aaUi != null) {
        paramVarArgs.g(15, this.aaUi);
      }
      if (this.aaUj != null) {
        paramVarArgs.g(16, this.aaUj);
      }
      if (this.md5 != null) {
        paramVarArgs.g(17, this.md5);
      }
      if (this.appid != null) {
        paramVarArgs.g(18, this.appid);
      }
      paramVarArgs.bS(19, this.cIh);
      paramVarArgs.bS(20, this.hGM);
      if (this.aaTE != null) {
        paramVarArgs.g(21, this.aaTE);
      }
      if (this.aaUk != null)
      {
        paramVarArgs.qD(22, this.aaUk.computeSize());
        this.aaUk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.aaUl);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaTG) + 0 + i.a.a.b.b.a.cJ(2, this.aaTH) + i.a.a.b.b.a.cJ(3, this.Privated);
      paramInt = i;
      if (this.aaUe != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaUe.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaUf) + i.a.a.a.c(6, 8, this.aaUg) + i.a.a.b.b.a.cJ(7, this.nrQ) + i.a.a.b.b.a.cJ(8, this.aaPu);
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.IGG);
      }
      i = paramInt;
      if (this.aaUh != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaUh);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.token);
      }
      i = paramInt;
      if (this.aaTQ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaTQ);
      }
      i += i.a.a.b.b.a.cJ(13, this.aaTP);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.videoPath);
      }
      i = paramInt;
      if (this.aaUi != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaUi);
      }
      paramInt = i;
      if (this.aaUj != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaUj);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.md5);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.appid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.cIh) + i.a.a.b.b.a.cJ(20, this.hGM);
      paramInt = i;
      if (this.aaTE != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aaTE);
      }
      i = paramInt;
      if (this.aaUk != null) {
        i = paramInt + i.a.a.a.qC(22, this.aaUk.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(23, this.aaUl);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaUg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dnc localdnc = (dnc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localdnc.aaTG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localdnc.aaTH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localdnc.Privated = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmu)localObject2).parseFrom((byte[])localObject1);
          }
          localdnc.aaUe = ((dmu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localdnc.aaUf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmu)localObject2).parseFrom((byte[])localObject1);
          }
          localdnc.aaUg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localdnc.nrQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localdnc.aaPu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localdnc.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localdnc.aaUh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localdnc.token = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localdnc.aaTQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localdnc.aaTP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localdnc.videoPath = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localdnc.aaUi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localdnc.aaUj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localdnc.md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localdnc.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localdnc.cIh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localdnc.hGM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localdnc.aaTE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmb)localObject2).parseFrom((byte[])localObject1);
          }
          localdnc.aaUk = ((dmb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localdnc.aaUl = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnc
 * JD-Core Version:    0.7.0.1
 */