package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aor
  extends com.tencent.mm.cd.a
{
  public boolean SAy = false;
  public String SBc;
  public boolean SBd = false;
  public int SBe;
  public boolean SBf = false;
  public boolean SBg = false;
  public String SBh;
  public boolean SBi = false;
  public boolean SBj = false;
  public boolean SxH = false;
  public boolean SxI = false;
  public boolean SyR = false;
  public String canvasPageXml;
  public int contentattr;
  public String desc;
  public int mjT;
  public String thumbUrl;
  public String title;
  
  public final aor arA(int paramInt)
  {
    this.SBe = paramInt;
    this.SBf = true;
    return this;
  }
  
  public final aor arB(int paramInt)
  {
    this.contentattr = paramInt;
    this.SBg = true;
    return this;
  }
  
  public final aor arC(int paramInt)
  {
    this.mjT = paramInt;
    this.SBj = true;
    return this;
  }
  
  public final aor btK(String paramString)
  {
    this.title = paramString;
    this.SxH = true;
    return this;
  }
  
  public final aor btL(String paramString)
  {
    this.desc = paramString;
    this.SxI = true;
    return this;
  }
  
  public final aor btM(String paramString)
  {
    this.SBc = paramString;
    this.SBd = true;
    return this;
  }
  
  public final aor btN(String paramString)
  {
    this.thumbUrl = paramString;
    this.SAy = true;
    return this;
  }
  
  public final aor btO(String paramString)
  {
    this.canvasPageXml = paramString;
    this.SyR = true;
    return this;
  }
  
  public final aor btP(String paramString)
  {
    this.SBh = paramString;
    this.SBi = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.SBc != null) {
        paramVarArgs.f(3, this.SBc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(4, this.thumbUrl);
      }
      if (this.SBf == true) {
        paramVarArgs.aY(5, this.SBe);
      }
      if (this.SBg == true) {
        paramVarArgs.aY(6, this.contentattr);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.f(7, this.canvasPageXml);
      }
      if (this.SBh != null) {
        paramVarArgs.f(8, this.SBh);
      }
      if (this.SBj == true) {
        paramVarArgs.aY(9, this.mjT);
      }
      AppMethodBeat.o(127493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label764;
      }
    }
    label764:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.SBc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SBc);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.SBf == true) {
        i = paramInt + g.a.a.b.b.a.bM(5, this.SBe);
      }
      paramInt = i;
      if (this.SBg == true) {
        paramInt = i + g.a.a.b.b.a.bM(6, this.contentattr);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.SBh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SBh);
      }
      i = paramInt;
      if (this.SBj == true) {
        i = paramInt + g.a.a.b.b.a.bM(9, this.mjT);
      }
      AppMethodBeat.o(127493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aor localaor = (aor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localaor.title = locala.abFh.readString();
          localaor.SxH = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localaor.desc = locala.abFh.readString();
          localaor.SxI = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localaor.SBc = locala.abFh.readString();
          localaor.SBd = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localaor.thumbUrl = locala.abFh.readString();
          localaor.SAy = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localaor.SBe = locala.abFh.AK();
          localaor.SBf = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localaor.contentattr = locala.abFh.AK();
          localaor.SBg = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localaor.canvasPageXml = locala.abFh.readString();
          localaor.SyR = true;
          AppMethodBeat.o(127493);
          return 0;
        case 8: 
          localaor.SBh = locala.abFh.readString();
          localaor.SBi = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localaor.mjT = locala.abFh.AK();
        localaor.SBj = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aor
 * JD-Core Version:    0.7.0.1
 */