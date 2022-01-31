package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class acw
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
  public String wVj;
  public boolean wVk = false;
  
  public final acw MR(int paramInt)
  {
    this.cpG = paramInt;
    this.wUv = true;
    return this;
  }
  
  public final acw aon(String paramString)
  {
    this.czp = paramString;
    this.wUw = true;
    return this;
  }
  
  public final acw aoo(String paramString)
  {
    this.toUser = paramString;
    this.wUx = true;
    return this;
  }
  
  public final acw aop(String paramString)
  {
    this.wVj = paramString;
    this.wVk = true;
    return this;
  }
  
  public final acw aoq(String paramString)
  {
    this.wUA = paramString;
    this.wUB = true;
    return this;
  }
  
  public final acw aor(String paramString)
  {
    this.cDC = paramString;
    this.wUC = true;
    return this;
  }
  
  public final acw aos(String paramString)
  {
    this.cJG = paramString;
    this.wUD = true;
    return this;
  }
  
  public final acw aot(String paramString)
  {
    this.appId = paramString;
    this.wUE = true;
    return this;
  }
  
  public final acw aou(String paramString)
  {
    this.link = paramString;
    this.wUF = true;
    return this;
  }
  
  public final acw aov(String paramString)
  {
    this.cmx = paramString;
    this.wUI = true;
    return this;
  }
  
  public final acw nI(long paramLong)
  {
    this.createTime = paramLong;
    this.fEg = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51412);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (!this.wUv)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(51412);
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
      if (this.wVj != null) {
        paramVarArgs.e(4, this.wVj);
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
      AppMethodBeat.o(51412);
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
      if (this.wVj != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wVj);
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
      AppMethodBeat.o(51412);
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
          AppMethodBeat.o(51412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(51412);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        acw localacw = (acw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51412);
          return -1;
        case 1: 
          localacw.cpG = locala.CLY.sl();
          localacw.wUv = true;
          AppMethodBeat.o(51412);
          return 0;
        case 2: 
          localacw.czp = locala.CLY.readString();
          localacw.wUw = true;
          AppMethodBeat.o(51412);
          return 0;
        case 3: 
          localacw.toUser = locala.CLY.readString();
          localacw.wUx = true;
          AppMethodBeat.o(51412);
          return 0;
        case 4: 
          localacw.wVj = locala.CLY.readString();
          localacw.wVk = true;
          AppMethodBeat.o(51412);
          return 0;
        case 5: 
          localacw.wUA = locala.CLY.readString();
          localacw.wUB = true;
          AppMethodBeat.o(51412);
          return 0;
        case 6: 
          localacw.createTime = locala.CLY.sm();
          localacw.fEg = true;
          AppMethodBeat.o(51412);
          return 0;
        case 7: 
          localacw.cDC = locala.CLY.readString();
          localacw.wUC = true;
          AppMethodBeat.o(51412);
          return 0;
        case 8: 
          localacw.cJG = locala.CLY.readString();
          localacw.wUD = true;
          AppMethodBeat.o(51412);
          return 0;
        case 9: 
          localacw.appId = locala.CLY.readString();
          localacw.wUE = true;
          AppMethodBeat.o(51412);
          return 0;
        case 10: 
          localacw.link = locala.CLY.readString();
          localacw.wUF = true;
          AppMethodBeat.o(51412);
          return 0;
        case 11: 
          localacw.wUG = locala.CLY.readString();
          localacw.wUH = true;
          AppMethodBeat.o(51412);
          return 0;
        }
        localacw.cmx = locala.CLY.readString();
        localacw.wUI = true;
        AppMethodBeat.o(51412);
        return 0;
      }
      AppMethodBeat.o(51412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */