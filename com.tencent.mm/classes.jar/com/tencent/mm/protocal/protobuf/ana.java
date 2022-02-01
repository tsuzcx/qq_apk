package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ana
  extends com.tencent.mm.bw.a
{
  public boolean Lvh = false;
  public boolean Lvi = false;
  public boolean LxX = false;
  public boolean LxY = false;
  public boolean LxZ = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final ana ajj(int paramInt)
  {
    this.type = paramInt;
    this.LxZ = true;
    return this;
  }
  
  public final ana bgY(String paramString)
  {
    this.title = paramString;
    this.Lvh = true;
    return this;
  }
  
  public final ana bgZ(String paramString)
  {
    this.desc = paramString;
    this.Lvi = true;
    return this;
  }
  
  public final ana bha(String paramString)
  {
    this.thumbUrl = paramString;
    this.LxX = true;
    return this;
  }
  
  public final ana bhb(String paramString)
  {
    this.info = paramString;
    this.LxY = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127472);
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
      if (this.LxZ == true) {
        paramVarArgs.aM(5, this.type);
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
      i = paramInt;
      if (this.LxZ == true) {
        i = paramInt + g.a.a.b.b.a.bu(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ana localana = (ana)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localana.title = locala.UbS.readString();
          localana.Lvh = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localana.desc = locala.UbS.readString();
          localana.Lvi = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localana.thumbUrl = locala.UbS.readString();
          localana.LxX = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localana.info = locala.UbS.readString();
          localana.LxY = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localana.type = locala.UbS.zi();
        localana.LxZ = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ana
 * JD-Core Version:    0.7.0.1
 */