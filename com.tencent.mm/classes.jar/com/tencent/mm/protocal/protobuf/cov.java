package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cov
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> aavL;
  public String app_id;
  public String language;
  public int subtype;
  
  public cov()
  {
    AppMethodBeat.i(152582);
    this.aavL = new LinkedList();
    AppMethodBeat.o(152582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152583);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.language != null) {
        paramVarArgs.g(1, this.language);
      }
      if (this.app_id != null) {
        paramVarArgs.g(2, this.app_id);
      }
      paramVarArgs.e(3, 1, this.aavL);
      paramVarArgs.bS(4, this.subtype);
      AppMethodBeat.o(152583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.language == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = i.a.a.b.b.a.h(1, this.language) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.app_id);
      }
      paramInt = i.a.a.a.c(3, 1, this.aavL);
      int j = i.a.a.b.b.a.cJ(4, this.subtype);
      AppMethodBeat.o(152583);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aavL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152583);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cov localcov = (cov)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152583);
          return -1;
        case 1: 
          localcov.language = locala.ajGk.readString();
          AppMethodBeat.o(152583);
          return 0;
        case 2: 
          localcov.app_id = locala.ajGk.readString();
          AppMethodBeat.o(152583);
          return 0;
        case 3: 
          localcov.aavL.add(locala.ajGk.readString());
          AppMethodBeat.o(152583);
          return 0;
        }
        localcov.subtype = locala.ajGk.aar();
        AppMethodBeat.o(152583);
        return 0;
      }
      AppMethodBeat.o(152583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cov
 * JD-Core Version:    0.7.0.1
 */