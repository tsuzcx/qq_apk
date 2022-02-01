package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aru
  extends com.tencent.mm.bx.a
{
  public boolean ZBq = false;
  public boolean ZBr = false;
  public boolean ZBs = false;
  public boolean ZyA = false;
  public boolean Zyz = false;
  public String desc;
  public String hZn;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final aru axE(int paramInt)
  {
    this.type = paramInt;
    this.ZBs = true;
    return this;
  }
  
  public final aru bth(String paramString)
  {
    this.title = paramString;
    this.Zyz = true;
    return this;
  }
  
  public final aru bti(String paramString)
  {
    this.desc = paramString;
    this.ZyA = true;
    return this;
  }
  
  public final aru btj(String paramString)
  {
    this.thumbUrl = paramString;
    this.ZBq = true;
    return this;
  }
  
  public final aru btk(String paramString)
  {
    this.hZn = paramString;
    this.ZBr = true;
    return this;
  }
  
  public final String getInfo()
  {
    return this.hZn;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(3, this.thumbUrl);
      }
      if (this.hZn != null) {
        paramVarArgs.g(4, this.hZn);
      }
      if (this.ZBs == true) {
        paramVarArgs.bS(5, this.type);
      }
      AppMethodBeat.o(127472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label484;
      }
    }
    label484:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.hZn != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hZn);
      }
      i = paramInt;
      if (this.ZBs == true) {
        i = paramInt + i.a.a.b.b.a.cJ(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aru localaru = (aru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localaru.title = locala.ajGk.readString();
          localaru.Zyz = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localaru.desc = locala.ajGk.readString();
          localaru.ZyA = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localaru.thumbUrl = locala.ajGk.readString();
          localaru.ZBq = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localaru.hZn = locala.ajGk.readString();
          localaru.ZBr = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localaru.type = locala.ajGk.aar();
        localaru.ZBs = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aru
 * JD-Core Version:    0.7.0.1
 */