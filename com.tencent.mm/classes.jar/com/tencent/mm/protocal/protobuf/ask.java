package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ask
  extends com.tencent.mm.bx.a
{
  public String ZBV;
  public boolean ZBW = false;
  public int ZBX;
  public boolean ZBY = false;
  public boolean ZBZ = false;
  public boolean ZBq = false;
  public String ZCa;
  public boolean ZCb = false;
  public boolean ZCc = false;
  public boolean ZyA = false;
  public boolean Zyz = false;
  public boolean ZzJ = false;
  public String canvasPageXml;
  public int contentattr;
  public String desc;
  public int pdq;
  public String thumbUrl;
  public String title;
  
  public final ask axI(int paramInt)
  {
    this.ZBX = paramInt;
    this.ZBY = true;
    return this;
  }
  
  public final ask axJ(int paramInt)
  {
    this.contentattr = paramInt;
    this.ZBZ = true;
    return this;
  }
  
  public final ask axK(int paramInt)
  {
    this.pdq = paramInt;
    this.ZCc = true;
    return this;
  }
  
  public final ask btB(String paramString)
  {
    this.title = paramString;
    this.Zyz = true;
    return this;
  }
  
  public final ask btC(String paramString)
  {
    this.desc = paramString;
    this.ZyA = true;
    return this;
  }
  
  public final ask btD(String paramString)
  {
    this.ZBV = paramString;
    this.ZBW = true;
    return this;
  }
  
  public final ask btE(String paramString)
  {
    this.thumbUrl = paramString;
    this.ZBq = true;
    return this;
  }
  
  public final ask btF(String paramString)
  {
    this.canvasPageXml = paramString;
    this.ZzJ = true;
    return this;
  }
  
  public final ask btG(String paramString)
  {
    this.ZCa = paramString;
    this.ZCb = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.ZBV != null) {
        paramVarArgs.g(3, this.ZBV);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(4, this.thumbUrl);
      }
      if (this.ZBY == true) {
        paramVarArgs.bS(5, this.ZBX);
      }
      if (this.ZBZ == true) {
        paramVarArgs.bS(6, this.contentattr);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.g(7, this.canvasPageXml);
      }
      if (this.ZCa != null) {
        paramVarArgs.g(8, this.ZCa);
      }
      if (this.ZCc == true) {
        paramVarArgs.bS(9, this.pdq);
      }
      AppMethodBeat.o(127493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label760;
      }
    }
    label760:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.ZBV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZBV);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.ZBY == true) {
        i = paramInt + i.a.a.b.b.a.cJ(5, this.ZBX);
      }
      paramInt = i;
      if (this.ZBZ == true) {
        paramInt = i + i.a.a.b.b.a.cJ(6, this.contentattr);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.ZCa != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZCa);
      }
      i = paramInt;
      if (this.ZCc == true) {
        i = paramInt + i.a.a.b.b.a.cJ(9, this.pdq);
      }
      AppMethodBeat.o(127493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ask localask = (ask)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localask.title = locala.ajGk.readString();
          localask.Zyz = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localask.desc = locala.ajGk.readString();
          localask.ZyA = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localask.ZBV = locala.ajGk.readString();
          localask.ZBW = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localask.thumbUrl = locala.ajGk.readString();
          localask.ZBq = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localask.ZBX = locala.ajGk.aar();
          localask.ZBY = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localask.contentattr = locala.ajGk.aar();
          localask.ZBZ = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localask.canvasPageXml = locala.ajGk.readString();
          localask.ZzJ = true;
          AppMethodBeat.o(127493);
          return 0;
        case 8: 
          localask.ZCa = locala.ajGk.readString();
          localask.ZCb = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localask.pdq = locala.ajGk.aar();
        localask.ZCc = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ask
 * JD-Core Version:    0.7.0.1
 */