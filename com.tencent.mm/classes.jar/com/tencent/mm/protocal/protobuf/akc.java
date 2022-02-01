package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akc
  extends com.tencent.mm.bx.a
{
  public boolean GgK = false;
  public boolean GgL = false;
  public boolean Gjs = false;
  public boolean Gjt = false;
  public boolean Gju = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final akc ZO(int paramInt)
  {
    this.type = paramInt;
    this.Gju = true;
    return this;
  }
  
  public final akc aOY(String paramString)
  {
    this.title = paramString;
    this.GgK = true;
    return this;
  }
  
  public final akc aOZ(String paramString)
  {
    this.desc = paramString;
    this.GgL = true;
    return this;
  }
  
  public final akc aPa(String paramString)
  {
    this.thumbUrl = paramString;
    this.Gjs = true;
    return this;
  }
  
  public final akc aPb(String paramString)
  {
    this.info = paramString;
    this.Gjt = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127472);
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
      if (this.Gju == true) {
        paramVarArgs.aS(5, this.type);
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
      i = paramInt;
      if (this.Gju == true) {
        i = paramInt + f.a.a.b.b.a.bz(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akc localakc = (akc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localakc.title = locala.NPN.readString();
          localakc.GgK = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localakc.desc = locala.NPN.readString();
          localakc.GgL = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localakc.thumbUrl = locala.NPN.readString();
          localakc.Gjs = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localakc.info = locala.NPN.readString();
          localakc.Gjt = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localakc.type = locala.NPN.zc();
        localakc.Gju = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akc
 * JD-Core Version:    0.7.0.1
 */