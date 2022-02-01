package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class enb
  extends com.tencent.mm.bx.a
{
  public int abrp;
  public String abrq;
  public String abrr;
  public String abrs;
  public double abrt;
  public String abru;
  public cxp abrv;
  public String abrw;
  public String abrx;
  public String met;
  public String recommend_reason;
  public String tNS;
  public String tNT;
  public String tNU;
  public String tNV;
  public int tNW;
  public String tNX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.tNW);
      paramVarArgs.bS(2, this.abrp);
      if (this.met != null) {
        paramVarArgs.g(3, this.met);
      }
      if (this.tNU != null) {
        paramVarArgs.g(4, this.tNU);
      }
      if (this.tNV != null) {
        paramVarArgs.g(5, this.tNV);
      }
      if (this.abrq != null) {
        paramVarArgs.g(6, this.abrq);
      }
      if (this.recommend_reason != null) {
        paramVarArgs.g(7, this.recommend_reason);
      }
      if (this.abrr != null) {
        paramVarArgs.g(8, this.abrr);
      }
      if (this.abrs != null) {
        paramVarArgs.g(9, this.abrs);
      }
      paramVarArgs.d(10, this.abrt);
      if (this.abru != null) {
        paramVarArgs.g(11, this.abru);
      }
      if (this.tNS != null) {
        paramVarArgs.g(12, this.tNS);
      }
      if (this.abrv != null)
      {
        paramVarArgs.qD(14, this.abrv.computeSize());
        this.abrv.writeFields(paramVarArgs);
      }
      if (this.tNT != null) {
        paramVarArgs.g(15, this.tNT);
      }
      if (this.abrw != null) {
        paramVarArgs.g(16, this.abrw);
      }
      if (this.abrx != null) {
        paramVarArgs.g(17, this.abrx);
      }
      if (this.tNX != null) {
        paramVarArgs.g(18, this.tNX);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.tNW) + 0 + i.a.a.b.b.a.cJ(2, this.abrp);
      paramInt = i;
      if (this.met != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.met);
      }
      i = paramInt;
      if (this.tNU != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.tNU);
      }
      paramInt = i;
      if (this.tNV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.tNV);
      }
      i = paramInt;
      if (this.abrq != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abrq);
      }
      paramInt = i;
      if (this.recommend_reason != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.recommend_reason);
      }
      i = paramInt;
      if (this.abrr != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abrr);
      }
      paramInt = i;
      if (this.abrs != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abrs);
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 8);
      paramInt = i;
      if (this.abru != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abru);
      }
      i = paramInt;
      if (this.tNS != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.tNS);
      }
      paramInt = i;
      if (this.abrv != null) {
        paramInt = i + i.a.a.a.qC(14, this.abrv.computeSize());
      }
      i = paramInt;
      if (this.tNT != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.tNT);
      }
      paramInt = i;
      if (this.abrw != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abrw);
      }
      i = paramInt;
      if (this.abrx != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abrx);
      }
      paramInt = i;
      if (this.tNX != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.tNX);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      enb localenb = (enb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localenb.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localenb.abrp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localenb.met = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localenb.tNU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localenb.tNV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localenb.abrq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localenb.recommend_reason = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localenb.abrr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localenb.abrs = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localenb.abrt = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localenb.abru = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localenb.tNS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cxp localcxp = new cxp();
          if ((localObject != null) && (localObject.length > 0)) {
            localcxp.parseFrom((byte[])localObject);
          }
          localenb.abrv = localcxp;
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localenb.tNT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localenb.abrw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localenb.abrx = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localenb.tNX = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enb
 * JD-Core Version:    0.7.0.1
 */