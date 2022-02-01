package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akm
  extends com.tencent.mm.bw.a
{
  public boolean GCb = false;
  public boolean GCc = false;
  public boolean GCd = false;
  public boolean Gzt = false;
  public boolean Gzu = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final akm aQv(String paramString)
  {
    this.title = paramString;
    this.Gzt = true;
    return this;
  }
  
  public final akm aQw(String paramString)
  {
    this.desc = paramString;
    this.Gzu = true;
    return this;
  }
  
  public final akm aQx(String paramString)
  {
    this.thumbUrl = paramString;
    this.GCb = true;
    return this;
  }
  
  public final akm aQy(String paramString)
  {
    this.info = paramString;
    this.GCc = true;
    return this;
  }
  
  public final akm aau(int paramInt)
  {
    this.type = paramInt;
    this.GCd = true;
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
      if (this.GCd == true) {
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
      if (this.GCd == true) {
        i = paramInt + f.a.a.b.b.a.bz(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akm localakm = (akm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localakm.title = locala.OmT.readString();
          localakm.Gzt = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localakm.desc = locala.OmT.readString();
          localakm.Gzu = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localakm.thumbUrl = locala.OmT.readString();
          localakm.GCb = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localakm.info = locala.OmT.readString();
          localakm.GCc = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localakm.type = locala.OmT.zc();
        localakm.GCd = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akm
 * JD-Core Version:    0.7.0.1
 */