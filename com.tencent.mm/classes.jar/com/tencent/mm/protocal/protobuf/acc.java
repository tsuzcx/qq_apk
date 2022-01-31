package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class acc
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String cDC;
  public String cJG;
  public String cmx;
  public int cpG;
  public long createTime;
  public String czp;
  public boolean fEg = false;
  public String link;
  public String toUser;
  public String wUA;
  public boolean wUB = false;
  public boolean wUC = false;
  public boolean wUD = false;
  public boolean wUE = false;
  public boolean wUF = false;
  public String wUG;
  public boolean wUH = false;
  public boolean wUI = false;
  public boolean wUv = false;
  public boolean wUw = false;
  public boolean wUx = false;
  public String wUy;
  public boolean wUz = false;
  
  public final acc MM(int paramInt)
  {
    this.cpG = paramInt;
    this.wUv = true;
    return this;
  }
  
  public final acc anW(String paramString)
  {
    this.czp = paramString;
    this.wUw = true;
    return this;
  }
  
  public final acc anX(String paramString)
  {
    this.toUser = paramString;
    this.wUx = true;
    return this;
  }
  
  public final acc anY(String paramString)
  {
    this.wUy = paramString;
    this.wUz = true;
    return this;
  }
  
  public final acc anZ(String paramString)
  {
    this.wUA = paramString;
    this.wUB = true;
    return this;
  }
  
  public final acc aoa(String paramString)
  {
    this.cDC = paramString;
    this.wUC = true;
    return this;
  }
  
  public final acc aob(String paramString)
  {
    this.appId = paramString;
    this.wUE = true;
    return this;
  }
  
  public final acc aoc(String paramString)
  {
    this.link = paramString;
    this.wUF = true;
    return this;
  }
  
  public final acc aod(String paramString)
  {
    this.cmx = paramString;
    this.wUI = true;
    return this;
  }
  
  public final acc nF(long paramLong)
  {
    this.createTime = paramLong;
    this.fEg = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51392);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (!this.wUv)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(51392);
        throw paramVarArgs;
      }
      if (this.wUv == true) {
        paramVarArgs.aO(1, this.cpG);
      }
      if (this.czp != null) {
        paramVarArgs.e(2, this.czp);
      }
      if (this.toUser != null) {
        paramVarArgs.e(3, this.toUser);
      }
      if (this.wUy != null) {
        paramVarArgs.e(4, this.wUy);
      }
      if (this.wUA != null) {
        paramVarArgs.e(5, this.wUA);
      }
      if (this.fEg == true) {
        paramVarArgs.am(6, this.createTime);
      }
      if (this.cDC != null) {
        paramVarArgs.e(7, this.cDC);
      }
      if (this.cJG != null) {
        paramVarArgs.e(8, this.cJG);
      }
      if (this.appId != null) {
        paramVarArgs.e(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.e(10, this.link);
      }
      if (this.wUG != null) {
        paramVarArgs.e(11, this.wUG);
      }
      if (this.cmx != null) {
        paramVarArgs.e(12, this.cmx);
      }
      AppMethodBeat.o(51392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wUv != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = e.a.a.b.b.a.bl(1, this.cpG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.czp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.czp);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.toUser);
      }
      paramInt = i;
      if (this.wUy != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wUy);
      }
      i = paramInt;
      if (this.wUA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wUA);
      }
      paramInt = i;
      if (this.fEg == true) {
        paramInt = i + e.a.a.b.b.a.p(6, this.createTime);
      }
      i = paramInt;
      if (this.cDC != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.cDC);
      }
      paramInt = i;
      if (this.cJG != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.cJG);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.appId);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.link);
      }
      i = paramInt;
      if (this.wUG != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wUG);
      }
      paramInt = i;
      if (this.cmx != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.cmx);
      }
      AppMethodBeat.o(51392);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (!this.wUv)
        {
          paramVarArgs = new b("Not all required fields were included: sourceType");
          AppMethodBeat.o(51392);
          throw paramVarArgs;
        }
        AppMethodBeat.o(51392);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        acc localacc = (acc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51392);
          return -1;
        case 1: 
          localacc.cpG = locala.CLY.sl();
          localacc.wUv = true;
          AppMethodBeat.o(51392);
          return 0;
        case 2: 
          localacc.czp = locala.CLY.readString();
          localacc.wUw = true;
          AppMethodBeat.o(51392);
          return 0;
        case 3: 
          localacc.toUser = locala.CLY.readString();
          localacc.wUx = true;
          AppMethodBeat.o(51392);
          return 0;
        case 4: 
          localacc.wUy = locala.CLY.readString();
          localacc.wUz = true;
          AppMethodBeat.o(51392);
          return 0;
        case 5: 
          localacc.wUA = locala.CLY.readString();
          localacc.wUB = true;
          AppMethodBeat.o(51392);
          return 0;
        case 6: 
          localacc.createTime = locala.CLY.sm();
          localacc.fEg = true;
          AppMethodBeat.o(51392);
          return 0;
        case 7: 
          localacc.cDC = locala.CLY.readString();
          localacc.wUC = true;
          AppMethodBeat.o(51392);
          return 0;
        case 8: 
          localacc.cJG = locala.CLY.readString();
          localacc.wUD = true;
          AppMethodBeat.o(51392);
          return 0;
        case 9: 
          localacc.appId = locala.CLY.readString();
          localacc.wUE = true;
          AppMethodBeat.o(51392);
          return 0;
        case 10: 
          localacc.link = locala.CLY.readString();
          localacc.wUF = true;
          AppMethodBeat.o(51392);
          return 0;
        case 11: 
          localacc.wUG = locala.CLY.readString();
          localacc.wUH = true;
          AppMethodBeat.o(51392);
          return 0;
        }
        localacc.cmx = locala.CLY.readString();
        localacc.wUI = true;
        AppMethodBeat.o(51392);
        return 0;
      }
      AppMethodBeat.o(51392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */