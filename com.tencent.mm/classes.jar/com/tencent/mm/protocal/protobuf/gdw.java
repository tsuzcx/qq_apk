package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gdw
  extends com.tencent.mm.bx.a
{
  public b acbB;
  public String description;
  public String title;
  public String ytZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260129);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytZ != null) {
        paramVarArgs.g(1, this.ytZ);
      }
      if (this.acbB != null) {
        paramVarArgs.d(2, this.acbB);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.g(4, this.description);
      }
      AppMethodBeat.o(260129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytZ == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.ytZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acbB != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.acbB);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.description);
      }
      AppMethodBeat.o(260129);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260129);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdw localgdw = (gdw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260129);
          return -1;
        case 1: 
          localgdw.ytZ = locala.ajGk.readString();
          AppMethodBeat.o(260129);
          return 0;
        case 2: 
          localgdw.acbB = locala.ajGk.kFX();
          AppMethodBeat.o(260129);
          return 0;
        case 3: 
          localgdw.title = locala.ajGk.readString();
          AppMethodBeat.o(260129);
          return 0;
        }
        localgdw.description = locala.ajGk.readString();
        AppMethodBeat.o(260129);
        return 0;
      }
      AppMethodBeat.o(260129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdw
 * JD-Core Version:    0.7.0.1
 */