package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akm
  extends com.tencent.mm.bx.a
{
  public boolean GgK = false;
  public boolean GgL = false;
  public boolean Gjs = false;
  public boolean Gjt = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  
  public final akm aPo(String paramString)
  {
    this.title = paramString;
    this.GgK = true;
    return this;
  }
  
  public final akm aPp(String paramString)
  {
    this.desc = paramString;
    this.GgL = true;
    return this;
  }
  
  public final akm aPq(String paramString)
  {
    this.thumbUrl = paramString;
    this.Gjs = true;
    return this;
  }
  
  public final akm aPr(String paramString)
  {
    this.info = paramString;
    this.Gjt = true;
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
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127484);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akm localakm = (akm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127484);
          return -1;
        case 1: 
          localakm.title = locala.NPN.readString();
          localakm.GgK = true;
          AppMethodBeat.o(127484);
          return 0;
        case 2: 
          localakm.desc = locala.NPN.readString();
          localakm.GgL = true;
          AppMethodBeat.o(127484);
          return 0;
        case 3: 
          localakm.thumbUrl = locala.NPN.readString();
          localakm.Gjs = true;
          AppMethodBeat.o(127484);
          return 0;
        }
        localakm.info = locala.NPN.readString();
        localakm.Gjt = true;
        AppMethodBeat.o(127484);
        return 0;
      }
      AppMethodBeat.o(127484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akm
 * JD-Core Version:    0.7.0.1
 */