package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ank
  extends com.tencent.mm.bw.a
{
  public boolean Lvh = false;
  public boolean Lvi = false;
  public boolean LxX = false;
  public boolean LxY = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  
  public final ank bho(String paramString)
  {
    this.title = paramString;
    this.Lvh = true;
    return this;
  }
  
  public final ank bhp(String paramString)
  {
    this.desc = paramString;
    this.Lvi = true;
    return this;
  }
  
  public final ank bhq(String paramString)
  {
    this.thumbUrl = paramString;
    this.LxX = true;
    return this;
  }
  
  public final ank bhr(String paramString)
  {
    this.info = paramString;
    this.LxY = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(3, this.thumbUrl);
      }
      if (this.info != null) {
        paramVarArgs.e(4, this.info);
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
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.info != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.info);
      }
      AppMethodBeat.o(127484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127484);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ank localank = (ank)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127484);
          return -1;
        case 1: 
          localank.title = locala.UbS.readString();
          localank.Lvh = true;
          AppMethodBeat.o(127484);
          return 0;
        case 2: 
          localank.desc = locala.UbS.readString();
          localank.Lvi = true;
          AppMethodBeat.o(127484);
          return 0;
        case 3: 
          localank.thumbUrl = locala.UbS.readString();
          localank.LxX = true;
          AppMethodBeat.o(127484);
          return 0;
        }
        localank.info = locala.UbS.readString();
        localank.LxY = true;
        AppMethodBeat.o(127484);
        return 0;
      }
      AppMethodBeat.o(127484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */