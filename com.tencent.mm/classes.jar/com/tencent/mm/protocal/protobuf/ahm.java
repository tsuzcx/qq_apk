package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahm
  extends com.tencent.mm.bw.a
{
  public boolean EBG = false;
  public boolean EBH = false;
  public boolean EBI = false;
  public boolean EyY = false;
  public boolean EyZ = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final ahm XS(int paramInt)
  {
    this.type = paramInt;
    this.EBI = true;
    return this;
  }
  
  public final ahm aJv(String paramString)
  {
    this.title = paramString;
    this.EyY = true;
    return this;
  }
  
  public final ahm aJw(String paramString)
  {
    this.desc = paramString;
    this.EyZ = true;
    return this;
  }
  
  public final ahm aJx(String paramString)
  {
    this.thumbUrl = paramString;
    this.EBG = true;
    return this;
  }
  
  public final ahm aJy(String paramString)
  {
    this.info = paramString;
    this.EBH = true;
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
      if (this.EBI == true) {
        paramVarArgs.aR(5, this.type);
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
      if (this.EBI == true) {
        i = paramInt + f.a.a.b.b.a.bx(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahm localahm = (ahm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localahm.title = locala.LVo.readString();
          localahm.EyY = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localahm.desc = locala.LVo.readString();
          localahm.EyZ = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localahm.thumbUrl = locala.LVo.readString();
          localahm.EBG = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localahm.info = locala.LVo.readString();
          localahm.EBH = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localahm.type = locala.LVo.xF();
        localahm.EBI = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */