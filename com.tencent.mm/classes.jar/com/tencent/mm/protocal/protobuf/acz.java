package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acz
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public boolean wSv = false;
  public boolean wSw = false;
  public boolean wUX = false;
  public boolean wUY = false;
  
  public final acz aow(String paramString)
  {
    this.title = paramString;
    this.wSv = true;
    return this;
  }
  
  public final acz aox(String paramString)
  {
    this.desc = paramString;
    this.wSw = true;
    return this;
  }
  
  public final acz aoy(String paramString)
  {
    this.thumbUrl = paramString;
    this.wUX = true;
    return this;
  }
  
  public final acz aoz(String paramString)
  {
    this.info = paramString;
    this.wUY = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51415);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
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
      AppMethodBeat.o(51415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label418;
      }
    }
    label418:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.info != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.info);
      }
      AppMethodBeat.o(51415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51415);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        acz localacz = (acz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51415);
          return -1;
        case 1: 
          localacz.title = locala.CLY.readString();
          localacz.wSv = true;
          AppMethodBeat.o(51415);
          return 0;
        case 2: 
          localacz.desc = locala.CLY.readString();
          localacz.wSw = true;
          AppMethodBeat.o(51415);
          return 0;
        case 3: 
          localacz.thumbUrl = locala.CLY.readString();
          localacz.wUX = true;
          AppMethodBeat.o(51415);
          return 0;
        }
        localacz.info = locala.CLY.readString();
        localacz.wUY = true;
        AppMethodBeat.o(51415);
        return 0;
      }
      AppMethodBeat.o(51415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acz
 * JD-Core Version:    0.7.0.1
 */