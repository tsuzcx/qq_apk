package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aol
  extends com.tencent.mm.cd.a
{
  public boolean SAy = false;
  public boolean SAz = false;
  public boolean SxH = false;
  public boolean SxI = false;
  public String desc;
  public String fTp;
  public String thumbUrl;
  public String title;
  
  public final aol btG(String paramString)
  {
    this.title = paramString;
    this.SxH = true;
    return this;
  }
  
  public final aol btH(String paramString)
  {
    this.desc = paramString;
    this.SxI = true;
    return this;
  }
  
  public final aol btI(String paramString)
  {
    this.thumbUrl = paramString;
    this.SAy = true;
    return this;
  }
  
  public final aol btJ(String paramString)
  {
    this.fTp = paramString;
    this.SAz = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(3, this.thumbUrl);
      }
      if (this.fTp != null) {
        paramVarArgs.f(4, this.fTp);
      }
      AppMethodBeat.o(127484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label418;
      }
    }
    label418:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.fTp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fTp);
      }
      AppMethodBeat.o(127484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127484);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aol localaol = (aol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127484);
          return -1;
        case 1: 
          localaol.title = locala.abFh.readString();
          localaol.SxH = true;
          AppMethodBeat.o(127484);
          return 0;
        case 2: 
          localaol.desc = locala.abFh.readString();
          localaol.SxI = true;
          AppMethodBeat.o(127484);
          return 0;
        case 3: 
          localaol.thumbUrl = locala.abFh.readString();
          localaol.SAy = true;
          AppMethodBeat.o(127484);
          return 0;
        }
        localaol.fTp = locala.abFh.readString();
        localaol.SAz = true;
        AppMethodBeat.o(127484);
        return 0;
      }
      AppMethodBeat.o(127484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aol
 * JD-Core Version:    0.7.0.1
 */