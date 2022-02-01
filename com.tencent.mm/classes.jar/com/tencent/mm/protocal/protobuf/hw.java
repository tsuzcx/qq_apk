package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class hw
  extends com.tencent.mm.bx.a
{
  public String YCe;
  public gol YJA;
  public gol YJB;
  public int YJC;
  public all YJh;
  public gol YJi;
  public gol YJj;
  public int YJk;
  public gol YJl;
  public gdq YJm;
  public gjq YJn;
  public gol YJo;
  public gol YJp;
  public String YJq;
  public gol YJr;
  public String YJs;
  public fck YJt;
  public String YJu;
  public int YJv;
  public int YJw;
  public int YJx;
  public int YJy;
  public int YJz;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJi == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJj == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.yth);
      if (this.YJh != null)
      {
        paramVarArgs.qD(2, this.YJh.computeSize());
        this.YJh.writeFields(paramVarArgs);
      }
      if (this.YJi != null)
      {
        paramVarArgs.qD(3, this.YJi.computeSize());
        this.YJi.writeFields(paramVarArgs);
      }
      if (this.YJj != null)
      {
        paramVarArgs.qD(4, this.YJj.computeSize());
        this.YJj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.YJk);
      if (this.YJl != null)
      {
        paramVarArgs.qD(6, this.YJl.computeSize());
        this.YJl.writeFields(paramVarArgs);
      }
      if (this.YJm != null)
      {
        paramVarArgs.qD(7, this.YJm.computeSize());
        this.YJm.writeFields(paramVarArgs);
      }
      if (this.YJn != null)
      {
        paramVarArgs.qD(8, this.YJn.computeSize());
        this.YJn.writeFields(paramVarArgs);
      }
      if (this.YJo != null)
      {
        paramVarArgs.qD(9, this.YJo.computeSize());
        this.YJo.writeFields(paramVarArgs);
      }
      if (this.YJp != null)
      {
        paramVarArgs.qD(10, this.YJp.computeSize());
        this.YJp.writeFields(paramVarArgs);
      }
      if (this.YJq != null) {
        paramVarArgs.g(11, this.YJq);
      }
      if (this.YJr != null)
      {
        paramVarArgs.qD(12, this.YJr.computeSize());
        this.YJr.writeFields(paramVarArgs);
      }
      if (this.YJs != null) {
        paramVarArgs.g(14, this.YJs);
      }
      if (this.YJt != null)
      {
        paramVarArgs.qD(15, this.YJt.computeSize());
        this.YJt.writeFields(paramVarArgs);
      }
      if (this.YJu != null) {
        paramVarArgs.g(16, this.YJu);
      }
      paramVarArgs.bS(17, this.YJv);
      paramVarArgs.bS(18, this.YJw);
      paramVarArgs.bS(19, this.YJx);
      if (this.YCe != null) {
        paramVarArgs.g(20, this.YCe);
      }
      paramVarArgs.bS(21, this.YJy);
      paramVarArgs.bS(22, this.YJz);
      if (this.YJA != null)
      {
        paramVarArgs.qD(23, this.YJA.computeSize());
        this.YJA.writeFields(paramVarArgs);
      }
      if (this.YJB != null)
      {
        paramVarArgs.qD(24, this.YJB.computeSize());
        this.YJB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(25, this.YJC);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.yth) + 0;
      paramInt = i;
      if (this.YJh != null) {
        paramInt = i + i.a.a.a.qC(2, this.YJh.computeSize());
      }
      i = paramInt;
      if (this.YJi != null) {
        i = paramInt + i.a.a.a.qC(3, this.YJi.computeSize());
      }
      paramInt = i;
      if (this.YJj != null) {
        paramInt = i + i.a.a.a.qC(4, this.YJj.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YJk);
      paramInt = i;
      if (this.YJl != null) {
        paramInt = i + i.a.a.a.qC(6, this.YJl.computeSize());
      }
      i = paramInt;
      if (this.YJm != null) {
        i = paramInt + i.a.a.a.qC(7, this.YJm.computeSize());
      }
      paramInt = i;
      if (this.YJn != null) {
        paramInt = i + i.a.a.a.qC(8, this.YJn.computeSize());
      }
      i = paramInt;
      if (this.YJo != null) {
        i = paramInt + i.a.a.a.qC(9, this.YJo.computeSize());
      }
      paramInt = i;
      if (this.YJp != null) {
        paramInt = i + i.a.a.a.qC(10, this.YJp.computeSize());
      }
      i = paramInt;
      if (this.YJq != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YJq);
      }
      paramInt = i;
      if (this.YJr != null) {
        paramInt = i + i.a.a.a.qC(12, this.YJr.computeSize());
      }
      i = paramInt;
      if (this.YJs != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.YJs);
      }
      paramInt = i;
      if (this.YJt != null) {
        paramInt = i + i.a.a.a.qC(15, this.YJt.computeSize());
      }
      i = paramInt;
      if (this.YJu != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.YJu);
      }
      i = i + i.a.a.b.b.a.cJ(17, this.YJv) + i.a.a.b.b.a.cJ(18, this.YJw) + i.a.a.b.b.a.cJ(19, this.YJx);
      paramInt = i;
      if (this.YCe != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.YCe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(21, this.YJy) + i.a.a.b.b.a.cJ(22, this.YJz);
      paramInt = i;
      if (this.YJA != null) {
        paramInt = i + i.a.a.a.qC(23, this.YJA.computeSize());
      }
      i = paramInt;
      if (this.YJB != null) {
        i = paramInt + i.a.a.a.qC(24, this.YJB.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(25, this.YJC);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJi == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJj == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.YJB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133145);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      hw localhw = (hw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(133145);
        return -1;
      case 1: 
        localhw.yth = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new all();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((all)localObject2).parseFrom((byte[])localObject1);
          }
          localhw.YJh = ((all)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
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
          localhw.YJi = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
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
          localhw.YJj = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localhw.YJk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
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
          localhw.YJl = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gdq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gdq)localObject2).parseFrom((byte[])localObject1);
          }
          localhw.YJm = ((gdq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gjq)localObject2).parseFrom((byte[])localObject1);
          }
          localhw.YJn = ((gjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
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
          localhw.YJo = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
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
          localhw.YJp = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localhw.YJq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 12: 
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
          localhw.YJr = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localhw.YJs = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fck();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fck)localObject2).parseFrom((byte[])localObject1);
          }
          localhw.YJt = ((fck)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localhw.YJu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localhw.YJv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localhw.YJw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localhw.YJx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localhw.YCe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localhw.YJy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localhw.YJz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133145);
        return 0;
      case 23: 
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
          localhw.YJA = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
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
          localhw.YJB = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localhw.YJC = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hw
 * JD-Core Version:    0.7.0.1
 */