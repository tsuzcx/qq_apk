package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aob
  extends com.tencent.mm.cd.a
{
  public boolean SAA = false;
  public boolean SAy = false;
  public boolean SAz = false;
  public boolean SxH = false;
  public boolean SxI = false;
  public String desc;
  public String fTp;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final aob arw(int paramInt)
  {
    this.type = paramInt;
    this.SAA = true;
    return this;
  }
  
  public final aob btq(String paramString)
  {
    this.title = paramString;
    this.SxH = true;
    return this;
  }
  
  public final aob btr(String paramString)
  {
    this.desc = paramString;
    this.SxI = true;
    return this;
  }
  
  public final aob bts(String paramString)
  {
    this.thumbUrl = paramString;
    this.SAy = true;
    return this;
  }
  
  public final aob btt(String paramString)
  {
    this.fTp = paramString;
    this.SAz = true;
    return this;
  }
  
  public final String getInfo()
  {
    return this.fTp;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127472);
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
      if (this.SAA == true) {
        paramVarArgs.aY(5, this.type);
      }
      AppMethodBeat.o(127472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label488;
      }
    }
    label488:
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
      i = paramInt;
      if (this.SAA == true) {
        i = paramInt + g.a.a.b.b.a.bM(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aob localaob = (aob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localaob.title = locala.abFh.readString();
          localaob.SxH = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localaob.desc = locala.abFh.readString();
          localaob.SxI = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localaob.thumbUrl = locala.abFh.readString();
          localaob.SAy = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localaob.fTp = locala.abFh.readString();
          localaob.SAz = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localaob.type = locala.abFh.AK();
        localaob.SAA = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aob
 * JD-Core Version:    0.7.0.1
 */