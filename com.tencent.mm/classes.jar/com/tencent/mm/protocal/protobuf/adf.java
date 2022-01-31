package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adf
  extends com.tencent.mm.bv.a
{
  public String canvasPageXml;
  public String desc;
  public int fgB;
  public String thumbUrl;
  public String title;
  public boolean wSv = false;
  public boolean wSw = false;
  public boolean wTH = false;
  public boolean wUX = false;
  public String wVF;
  public boolean wVG = false;
  public int wVH;
  public boolean wVI = false;
  public boolean wVJ = false;
  
  public final adf MS(int paramInt)
  {
    this.wVH = paramInt;
    this.wVI = true;
    return this;
  }
  
  public final adf MT(int paramInt)
  {
    this.fgB = paramInt;
    this.wVJ = true;
    return this;
  }
  
  public final adf aoA(String paramString)
  {
    this.title = paramString;
    this.wSv = true;
    return this;
  }
  
  public final adf aoB(String paramString)
  {
    this.desc = paramString;
    this.wSw = true;
    return this;
  }
  
  public final adf aoC(String paramString)
  {
    this.wVF = paramString;
    this.wVG = true;
    return this;
  }
  
  public final adf aoD(String paramString)
  {
    this.thumbUrl = paramString;
    this.wUX = true;
    return this;
  }
  
  public final adf aoE(String paramString)
  {
    this.canvasPageXml = paramString;
    this.wTH = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51424);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.wVF != null) {
        paramVarArgs.e(3, this.wVF);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(4, this.thumbUrl);
      }
      if (this.wVI == true) {
        paramVarArgs.aO(5, this.wVH);
      }
      if (this.wVJ == true) {
        paramVarArgs.aO(6, this.fgB);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.e(7, this.canvasPageXml);
      }
      AppMethodBeat.o(51424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label624;
      }
    }
    label624:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.wVF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wVF);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.wVI == true) {
        i = paramInt + e.a.a.b.b.a.bl(5, this.wVH);
      }
      paramInt = i;
      if (this.wVJ == true) {
        paramInt = i + e.a.a.b.b.a.bl(6, this.fgB);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.canvasPageXml);
      }
      AppMethodBeat.o(51424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51424);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        adf localadf = (adf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51424);
          return -1;
        case 1: 
          localadf.title = locala.CLY.readString();
          localadf.wSv = true;
          AppMethodBeat.o(51424);
          return 0;
        case 2: 
          localadf.desc = locala.CLY.readString();
          localadf.wSw = true;
          AppMethodBeat.o(51424);
          return 0;
        case 3: 
          localadf.wVF = locala.CLY.readString();
          localadf.wVG = true;
          AppMethodBeat.o(51424);
          return 0;
        case 4: 
          localadf.thumbUrl = locala.CLY.readString();
          localadf.wUX = true;
          AppMethodBeat.o(51424);
          return 0;
        case 5: 
          localadf.wVH = locala.CLY.sl();
          localadf.wVI = true;
          AppMethodBeat.o(51424);
          return 0;
        case 6: 
          localadf.fgB = locala.CLY.sl();
          localadf.wVJ = true;
          AppMethodBeat.o(51424);
          return 0;
        }
        localadf.canvasPageXml = locala.CLY.readString();
        localadf.wTH = true;
        AppMethodBeat.o(51424);
        return 0;
      }
      AppMethodBeat.o(51424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adf
 * JD-Core Version:    0.7.0.1
 */