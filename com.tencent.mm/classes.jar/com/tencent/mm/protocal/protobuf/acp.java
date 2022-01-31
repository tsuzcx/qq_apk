package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acp
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String info;
  public String thumbUrl;
  public String title;
  public int type;
  public boolean wSv = false;
  public boolean wSw = false;
  public boolean wUX = false;
  public boolean wUY = false;
  public boolean wUZ = false;
  
  public final acp MO(int paramInt)
  {
    this.type = paramInt;
    this.wUZ = true;
    return this;
  }
  
  public final acp aog(String paramString)
  {
    this.title = paramString;
    this.wSv = true;
    return this;
  }
  
  public final acp aoh(String paramString)
  {
    this.desc = paramString;
    this.wSw = true;
    return this;
  }
  
  public final acp aoi(String paramString)
  {
    this.thumbUrl = paramString;
    this.wUX = true;
    return this;
  }
  
  public final acp aoj(String paramString)
  {
    this.info = paramString;
    this.wUY = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51403);
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
      if (this.wUZ == true) {
        paramVarArgs.aO(5, this.type);
      }
      AppMethodBeat.o(51403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label488;
      }
    }
    label488:
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
      i = paramInt;
      if (this.wUZ == true) {
        i = paramInt + e.a.a.b.b.a.bl(5, this.type);
      }
      AppMethodBeat.o(51403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51403);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        acp localacp = (acp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51403);
          return -1;
        case 1: 
          localacp.title = locala.CLY.readString();
          localacp.wSv = true;
          AppMethodBeat.o(51403);
          return 0;
        case 2: 
          localacp.desc = locala.CLY.readString();
          localacp.wSw = true;
          AppMethodBeat.o(51403);
          return 0;
        case 3: 
          localacp.thumbUrl = locala.CLY.readString();
          localacp.wUX = true;
          AppMethodBeat.o(51403);
          return 0;
        case 4: 
          localacp.info = locala.CLY.readString();
          localacp.wUY = true;
          AppMethodBeat.o(51403);
          return 0;
        }
        localacp.type = locala.CLY.sl();
        localacp.wUZ = true;
        AppMethodBeat.o(51403);
        return 0;
      }
      AppMethodBeat.o(51403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acp
 * JD-Core Version:    0.7.0.1
 */