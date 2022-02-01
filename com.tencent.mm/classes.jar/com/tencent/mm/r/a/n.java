package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public String desc;
  public int mdP;
  public String mdQ;
  public String mdR;
  public int mdS;
  public p mdT;
  public String mdU;
  public int mdV;
  public p mdW;
  public int mdX;
  public String mdY;
  public String mdZ;
  public long mea;
  public o meb;
  public String mec;
  public String med;
  public String mee;
  public String mef;
  public String meg = "fa5151";
  public String meh = "ffffff";
  public String mei = "f2f2f2";
  public String mej = "fa5151";
  public String mek = "C84040";
  public String nickname;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.mdP);
      if (this.mdQ != null) {
        paramVarArgs.g(2, this.mdQ);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      if (this.mdR != null) {
        paramVarArgs.g(7, this.mdR);
      }
      paramVarArgs.bS(8, this.mdS);
      if (this.mdT != null)
      {
        paramVarArgs.qD(9, this.mdT.computeSize());
        this.mdT.writeFields(paramVarArgs);
      }
      if (this.mdU != null) {
        paramVarArgs.g(10, this.mdU);
      }
      paramVarArgs.bS(11, this.mdV);
      if (this.mdW != null)
      {
        paramVarArgs.qD(12, this.mdW.computeSize());
        this.mdW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.mdX);
      if (this.mdY != null) {
        paramVarArgs.g(15, this.mdY);
      }
      if (this.mdZ != null) {
        paramVarArgs.g(16, this.mdZ);
      }
      paramVarArgs.bv(19, this.mea);
      if (this.meb != null)
      {
        paramVarArgs.qD(25, this.meb.computeSize());
        this.meb.writeFields(paramVarArgs);
      }
      if (this.mec != null) {
        paramVarArgs.g(6, this.mec);
      }
      if (this.med != null) {
        paramVarArgs.g(13, this.med);
      }
      if (this.mee != null) {
        paramVarArgs.g(17, this.mee);
      }
      if (this.mef != null) {
        paramVarArgs.g(18, this.mef);
      }
      if (this.meg != null) {
        paramVarArgs.g(20, this.meg);
      }
      if (this.meh != null) {
        paramVarArgs.g(21, this.meh);
      }
      if (this.mei != null) {
        paramVarArgs.g(22, this.mei);
      }
      if (this.mej != null) {
        paramVarArgs.g(23, this.mej);
      }
      if (this.mek != null) {
        paramVarArgs.g(24, this.mek);
      }
      AppMethodBeat.o(231437);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.mdP) + 0;
      paramInt = i;
      if (this.mdQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mdQ);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      paramInt = i;
      if (this.mdR != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.mdR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.mdS);
      paramInt = i;
      if (this.mdT != null) {
        paramInt = i + i.a.a.a.qC(9, this.mdT.computeSize());
      }
      i = paramInt;
      if (this.mdU != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.mdU);
      }
      i += i.a.a.b.b.a.cJ(11, this.mdV);
      paramInt = i;
      if (this.mdW != null) {
        paramInt = i + i.a.a.a.qC(12, this.mdW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.mdX);
      paramInt = i;
      if (this.mdY != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.mdY);
      }
      i = paramInt;
      if (this.mdZ != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.mdZ);
      }
      i += i.a.a.b.b.a.q(19, this.mea);
      paramInt = i;
      if (this.meb != null) {
        paramInt = i + i.a.a.a.qC(25, this.meb.computeSize());
      }
      i = paramInt;
      if (this.mec != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.mec);
      }
      paramInt = i;
      if (this.med != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.med);
      }
      i = paramInt;
      if (this.mee != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.mee);
      }
      paramInt = i;
      if (this.mef != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.mef);
      }
      i = paramInt;
      if (this.meg != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.meg);
      }
      paramInt = i;
      if (this.meh != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.meh);
      }
      i = paramInt;
      if (this.mei != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.mei);
      }
      paramInt = i;
      if (this.mej != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.mej);
      }
      i = paramInt;
      if (this.mek != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.mek);
      }
      AppMethodBeat.o(231437);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(231437);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(231437);
        return -1;
      case 1: 
        localn.mdP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(231437);
        return 0;
      case 2: 
        localn.mdQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 3: 
        localn.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 4: 
        localn.title = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 5: 
        localn.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 7: 
        localn.mdR = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 8: 
        localn.mdS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(231437);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localn.mdT = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(231437);
        return 0;
      case 10: 
        localn.mdU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 11: 
        localn.mdV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(231437);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localn.mdW = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(231437);
        return 0;
      case 14: 
        localn.mdX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(231437);
        return 0;
      case 15: 
        localn.mdY = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 16: 
        localn.mdZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 19: 
        localn.mea = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(231437);
        return 0;
      case 25: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new o();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((o)localObject2).parseFrom((byte[])localObject1);
          }
          localn.meb = ((o)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(231437);
        return 0;
      case 6: 
        localn.mec = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 13: 
        localn.med = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 17: 
        localn.mee = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 18: 
        localn.mef = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 20: 
        localn.meg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 21: 
        localn.meh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 22: 
        localn.mei = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      case 23: 
        localn.mej = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(231437);
        return 0;
      }
      localn.mek = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(231437);
      return 0;
    }
    AppMethodBeat.o(231437);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.n
 * JD-Core Version:    0.7.0.1
 */