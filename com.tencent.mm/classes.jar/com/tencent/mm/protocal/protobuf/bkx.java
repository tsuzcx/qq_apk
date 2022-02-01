package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkx
  extends com.tencent.mm.bx.a
{
  public String ZTY;
  public String description;
  public String mdZ;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.description != null) {
        paramVarArgs.g(2, this.description);
      }
      if (this.mdZ != null) {
        paramVarArgs.g(3, this.mdZ);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      if (this.ZTY != null) {
        paramVarArgs.g(5, this.ZTY);
      }
      AppMethodBeat.o(259434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.description);
      }
      i = paramInt;
      if (this.mdZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdZ);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt;
      if (this.ZTY != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZTY);
      }
      AppMethodBeat.o(259434);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259434);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bkx localbkx = (bkx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259434);
          return -1;
        case 1: 
          localbkx.title = locala.ajGk.readString();
          AppMethodBeat.o(259434);
          return 0;
        case 2: 
          localbkx.description = locala.ajGk.readString();
          AppMethodBeat.o(259434);
          return 0;
        case 3: 
          localbkx.mdZ = locala.ajGk.readString();
          AppMethodBeat.o(259434);
          return 0;
        case 4: 
          localbkx.url = locala.ajGk.readString();
          AppMethodBeat.o(259434);
          return 0;
        }
        localbkx.ZTY = locala.ajGk.readString();
        AppMethodBeat.o(259434);
        return 0;
      }
      AppMethodBeat.o(259434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkx
 * JD-Core Version:    0.7.0.1
 */