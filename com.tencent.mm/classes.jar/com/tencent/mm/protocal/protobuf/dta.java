package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dta
  extends com.tencent.mm.bx.a
{
  public String MUO;
  public String aaXV;
  public int aaYA;
  public long aaYB;
  public String aaYC;
  public dsy aaYx;
  public String aaYy;
  public String aaYz;
  public int createtime;
  public long hCz;
  public String mdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259572);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaYx != null)
      {
        paramVarArgs.qD(2, this.aaYx.computeSize());
        this.aaYx.writeFields(paramVarArgs);
      }
      if (this.aaYy != null) {
        paramVarArgs.g(3, this.aaYy);
      }
      if (this.aaYz != null) {
        paramVarArgs.g(4, this.aaYz);
      }
      paramVarArgs.bv(5, this.hCz);
      if (this.MUO != null) {
        paramVarArgs.g(6, this.MUO);
      }
      if (this.aaXV != null) {
        paramVarArgs.g(7, this.aaXV);
      }
      paramVarArgs.bS(9, this.createtime);
      paramVarArgs.bS(13, this.aaYA);
      paramVarArgs.bv(14, this.aaYB);
      if (this.mdD != null) {
        paramVarArgs.g(15, this.mdD);
      }
      if (this.aaYC != null) {
        paramVarArgs.g(16, this.aaYC);
      }
      AppMethodBeat.o(259572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaYx == null) {
        break label848;
      }
    }
    label848:
    for (int i = i.a.a.a.qC(2, this.aaYx.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaYy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaYy);
      }
      i = paramInt;
      if (this.aaYz != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaYz);
      }
      i += i.a.a.b.b.a.q(5, this.hCz);
      paramInt = i;
      if (this.MUO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.MUO);
      }
      i = paramInt;
      if (this.aaXV != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaXV);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.createtime) + i.a.a.b.b.a.cJ(13, this.aaYA) + i.a.a.b.b.a.q(14, this.aaYB);
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.mdD);
      }
      i = paramInt;
      if (this.aaYC != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.aaYC);
      }
      AppMethodBeat.o(259572);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(259572);
          return -1;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dsy localdsy = new dsy();
            if ((localObject != null) && (localObject.length > 0)) {
              localdsy.parseFrom((byte[])localObject);
            }
            localdta.aaYx = localdsy;
            paramInt += 1;
          }
          AppMethodBeat.o(259572);
          return 0;
        case 3: 
          localdta.aaYy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259572);
          return 0;
        case 4: 
          localdta.aaYz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259572);
          return 0;
        case 5: 
          localdta.hCz = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259572);
          return 0;
        case 6: 
          localdta.MUO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259572);
          return 0;
        case 7: 
          localdta.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259572);
          return 0;
        case 9: 
          localdta.createtime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259572);
          return 0;
        case 13: 
          localdta.aaYA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259572);
          return 0;
        case 14: 
          localdta.aaYB = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259572);
          return 0;
        case 15: 
          localdta.mdD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259572);
          return 0;
        }
        localdta.aaYC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259572);
        return 0;
      }
      AppMethodBeat.o(259572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */