package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agx
  extends com.tencent.mm.bx.a
{
  public boolean DfS = false;
  public boolean DfT = false;
  public boolean DiA = false;
  public boolean DiB = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  
  public final agx aEu(String paramString)
  {
    this.title = paramString;
    this.DfS = true;
    return this;
  }
  
  public final agx aEv(String paramString)
  {
    this.desc = paramString;
    this.DfT = true;
    return this;
  }
  
  public final agx aEw(String paramString)
  {
    this.thumbUrl = paramString;
    this.DiA = true;
    return this;
  }
  
  public final agx aEx(String paramString)
  {
    this.info = paramString;
    this.DiB = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(3, this.thumbUrl);
      }
      if (this.info != null) {
        paramVarArgs.d(4, this.info);
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
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.info != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.info);
      }
      AppMethodBeat.o(127484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127484);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agx localagx = (agx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127484);
          return -1;
        case 1: 
          localagx.title = locala.KhF.readString();
          localagx.DfS = true;
          AppMethodBeat.o(127484);
          return 0;
        case 2: 
          localagx.desc = locala.KhF.readString();
          localagx.DfT = true;
          AppMethodBeat.o(127484);
          return 0;
        case 3: 
          localagx.thumbUrl = locala.KhF.readString();
          localagx.DiA = true;
          AppMethodBeat.o(127484);
          return 0;
        }
        localagx.info = locala.KhF.readString();
        localagx.DiB = true;
        AppMethodBeat.o(127484);
        return 0;
      }
      AppMethodBeat.o(127484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */