package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ano
  extends com.tencent.mm.cd.a
{
  public boolean SAa = false;
  public String SAb;
  public boolean SAc = false;
  public boolean SAd = false;
  public boolean SAe = false;
  public boolean SAf = false;
  public boolean SAg = false;
  public String SAh;
  public boolean SAi = false;
  public boolean SAj = false;
  public boolean SzX = false;
  public boolean SzY = false;
  public boolean SzZ = false;
  public String appId;
  public long createTime;
  public String fLi;
  public String fXM;
  public String fuO;
  public boolean lOb = false;
  public String link;
  public String msgId;
  public String sourceId;
  public int sourceType;
  public String toUser;
  
  public final ano Ub(long paramLong)
  {
    this.createTime = paramLong;
    this.lOb = true;
    return this;
  }
  
  public final ano aru(int paramInt)
  {
    this.sourceType = paramInt;
    this.SzX = true;
    return this;
  }
  
  public final ano btg(String paramString)
  {
    this.fLi = paramString;
    this.SzY = true;
    return this;
  }
  
  public final ano bth(String paramString)
  {
    this.toUser = paramString;
    this.SzZ = true;
    return this;
  }
  
  public final ano bti(String paramString)
  {
    this.sourceId = paramString;
    this.SAa = true;
    return this;
  }
  
  public final ano btj(String paramString)
  {
    this.SAb = paramString;
    this.SAc = true;
    return this;
  }
  
  public final ano btk(String paramString)
  {
    this.msgId = paramString;
    this.SAd = true;
    return this;
  }
  
  public final ano btl(String paramString)
  {
    this.appId = paramString;
    this.SAf = true;
    return this;
  }
  
  public final ano btm(String paramString)
  {
    this.link = paramString;
    this.SAg = true;
    return this;
  }
  
  public final ano btn(String paramString)
  {
    this.fuO = paramString;
    this.SAj = true;
    return this;
  }
  
  public final String getFromUser()
  {
    return this.fLi;
  }
  
  public final String hpC()
  {
    return this.SAb;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (!this.SzX)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127459);
        throw paramVarArgs;
      }
      if (this.SzX == true) {
        paramVarArgs.aY(1, this.sourceType);
      }
      if (this.fLi != null) {
        paramVarArgs.f(2, this.fLi);
      }
      if (this.toUser != null) {
        paramVarArgs.f(3, this.toUser);
      }
      if (this.sourceId != null) {
        paramVarArgs.f(4, this.sourceId);
      }
      if (this.SAb != null) {
        paramVarArgs.f(5, this.SAb);
      }
      if (this.lOb == true) {
        paramVarArgs.bm(6, this.createTime);
      }
      if (this.msgId != null) {
        paramVarArgs.f(7, this.msgId);
      }
      if (this.fXM != null) {
        paramVarArgs.f(8, this.fXM);
      }
      if (this.appId != null) {
        paramVarArgs.f(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.f(10, this.link);
      }
      if (this.SAh != null) {
        paramVarArgs.f(11, this.SAh);
      }
      if (this.fuO != null) {
        paramVarArgs.f(12, this.fuO);
      }
      AppMethodBeat.o(127459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SzX != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = g.a.a.b.b.a.bM(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fLi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fLi);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.toUser);
      }
      paramInt = i;
      if (this.sourceId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sourceId);
      }
      i = paramInt;
      if (this.SAb != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SAb);
      }
      paramInt = i;
      if (this.lOb == true) {
        paramInt = i + g.a.a.b.b.a.p(6, this.createTime);
      }
      i = paramInt;
      if (this.msgId != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.msgId);
      }
      paramInt = i;
      if (this.fXM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.fXM);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.appId);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.link);
      }
      i = paramInt;
      if (this.SAh != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SAh);
      }
      paramInt = i;
      if (this.fuO != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.fuO);
      }
      AppMethodBeat.o(127459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (!this.SzX)
        {
          paramVarArgs = new b("Not all required fields were included: sourceType");
          AppMethodBeat.o(127459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127459);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ano localano = (ano)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127459);
          return -1;
        case 1: 
          localano.sourceType = locala.abFh.AK();
          localano.SzX = true;
          AppMethodBeat.o(127459);
          return 0;
        case 2: 
          localano.fLi = locala.abFh.readString();
          localano.SzY = true;
          AppMethodBeat.o(127459);
          return 0;
        case 3: 
          localano.toUser = locala.abFh.readString();
          localano.SzZ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 4: 
          localano.sourceId = locala.abFh.readString();
          localano.SAa = true;
          AppMethodBeat.o(127459);
          return 0;
        case 5: 
          localano.SAb = locala.abFh.readString();
          localano.SAc = true;
          AppMethodBeat.o(127459);
          return 0;
        case 6: 
          localano.createTime = locala.abFh.AN();
          localano.lOb = true;
          AppMethodBeat.o(127459);
          return 0;
        case 7: 
          localano.msgId = locala.abFh.readString();
          localano.SAd = true;
          AppMethodBeat.o(127459);
          return 0;
        case 8: 
          localano.fXM = locala.abFh.readString();
          localano.SAe = true;
          AppMethodBeat.o(127459);
          return 0;
        case 9: 
          localano.appId = locala.abFh.readString();
          localano.SAf = true;
          AppMethodBeat.o(127459);
          return 0;
        case 10: 
          localano.link = locala.abFh.readString();
          localano.SAg = true;
          AppMethodBeat.o(127459);
          return 0;
        case 11: 
          localano.SAh = locala.abFh.readString();
          localano.SAi = true;
          AppMethodBeat.o(127459);
          return 0;
        }
        localano.fuO = locala.abFh.readString();
        localano.SAj = true;
        AppMethodBeat.o(127459);
        return 0;
      }
      AppMethodBeat.o(127459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */