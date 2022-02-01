package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anq
  extends com.tencent.mm.bw.a
{
  public boolean Lvh = false;
  public boolean Lvi = false;
  public boolean Lws = false;
  public boolean LxX = false;
  public String LyC;
  public boolean LyD = false;
  public int LyE;
  public boolean LyF = false;
  public boolean LyG = false;
  public String LyH;
  public boolean LyI = false;
  public String canvasPageXml;
  public int contentattr;
  public String desc;
  public String thumbUrl;
  public String title;
  
  public final anq ajn(int paramInt)
  {
    this.LyE = paramInt;
    this.LyF = true;
    return this;
  }
  
  public final anq ajo(int paramInt)
  {
    this.contentattr = paramInt;
    this.LyG = true;
    return this;
  }
  
  public final anq bhs(String paramString)
  {
    this.title = paramString;
    this.Lvh = true;
    return this;
  }
  
  public final anq bht(String paramString)
  {
    this.desc = paramString;
    this.Lvi = true;
    return this;
  }
  
  public final anq bhu(String paramString)
  {
    this.LyC = paramString;
    this.LyD = true;
    return this;
  }
  
  public final anq bhv(String paramString)
  {
    this.thumbUrl = paramString;
    this.LxX = true;
    return this;
  }
  
  public final anq bhw(String paramString)
  {
    this.canvasPageXml = paramString;
    this.Lws = true;
    return this;
  }
  
  public final anq bhx(String paramString)
  {
    this.LyH = paramString;
    this.LyI = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.LyC != null) {
        paramVarArgs.e(3, this.LyC);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(4, this.thumbUrl);
      }
      if (this.LyF == true) {
        paramVarArgs.aM(5, this.LyE);
      }
      if (this.LyG == true) {
        paramVarArgs.aM(6, this.contentattr);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.e(7, this.canvasPageXml);
      }
      if (this.LyH != null) {
        paramVarArgs.e(8, this.LyH);
      }
      AppMethodBeat.o(127493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label694;
      }
    }
    label694:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.LyC != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LyC);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.LyF == true) {
        i = paramInt + g.a.a.b.b.a.bu(5, this.LyE);
      }
      paramInt = i;
      if (this.LyG == true) {
        paramInt = i + g.a.a.b.b.a.bu(6, this.contentattr);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.LyH != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LyH);
      }
      AppMethodBeat.o(127493);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anq localanq = (anq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localanq.title = locala.UbS.readString();
          localanq.Lvh = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localanq.desc = locala.UbS.readString();
          localanq.Lvi = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localanq.LyC = locala.UbS.readString();
          localanq.LyD = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localanq.thumbUrl = locala.UbS.readString();
          localanq.LxX = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localanq.LyE = locala.UbS.zi();
          localanq.LyF = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localanq.contentattr = locala.UbS.zi();
          localanq.LyG = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localanq.canvasPageXml = locala.UbS.readString();
          localanq.Lws = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localanq.LyH = locala.UbS.readString();
        localanq.LyI = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anq
 * JD-Core Version:    0.7.0.1
 */