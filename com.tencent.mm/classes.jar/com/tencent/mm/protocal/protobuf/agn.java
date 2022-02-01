package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agn
  extends com.tencent.mm.bx.a
{
  public boolean DfS = false;
  public boolean DfT = false;
  public boolean DiA = false;
  public boolean DiB = false;
  public boolean DiC = false;
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final agn VJ(int paramInt)
  {
    this.type = paramInt;
    this.DiC = true;
    return this;
  }
  
  public final agn aEe(String paramString)
  {
    this.title = paramString;
    this.DfS = true;
    return this;
  }
  
  public final agn aEf(String paramString)
  {
    this.desc = paramString;
    this.DfT = true;
    return this;
  }
  
  public final agn aEg(String paramString)
  {
    this.thumbUrl = paramString;
    this.DiA = true;
    return this;
  }
  
  public final agn aEh(String paramString)
  {
    this.info = paramString;
    this.DiB = true;
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
      if (this.DiC == true) {
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
      if (this.DiC == true) {
        i = paramInt + f.a.a.b.b.a.bA(5, this.type);
      }
      AppMethodBeat.o(127472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127472);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agn localagn = (agn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127472);
          return -1;
        case 1: 
          localagn.title = locala.KhF.readString();
          localagn.DfS = true;
          AppMethodBeat.o(127472);
          return 0;
        case 2: 
          localagn.desc = locala.KhF.readString();
          localagn.DfT = true;
          AppMethodBeat.o(127472);
          return 0;
        case 3: 
          localagn.thumbUrl = locala.KhF.readString();
          localagn.DiA = true;
          AppMethodBeat.o(127472);
          return 0;
        case 4: 
          localagn.info = locala.KhF.readString();
          localagn.DiB = true;
          AppMethodBeat.o(127472);
          return 0;
        }
        localagn.type = locala.KhF.xS();
        localagn.DiC = true;
        AppMethodBeat.o(127472);
        return 0;
      }
      AppMethodBeat.o(127472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agn
 * JD-Core Version:    0.7.0.1
 */