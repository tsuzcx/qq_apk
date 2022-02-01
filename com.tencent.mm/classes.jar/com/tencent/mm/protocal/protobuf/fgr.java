package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgr
  extends com.tencent.mm.bx.a
{
  public String abGA;
  public String abGv;
  public String abGw;
  public String abGx;
  public String abGy;
  public String abGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257667);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abGv != null) {
        paramVarArgs.g(1, this.abGv);
      }
      if (this.abGw != null) {
        paramVarArgs.g(2, this.abGw);
      }
      if (this.abGx != null) {
        paramVarArgs.g(3, this.abGx);
      }
      if (this.abGy != null) {
        paramVarArgs.g(4, this.abGy);
      }
      if (this.abGz != null) {
        paramVarArgs.g(5, this.abGz);
      }
      if (this.abGA != null) {
        paramVarArgs.g(6, this.abGA);
      }
      AppMethodBeat.o(257667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abGv == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.abGv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abGw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abGw);
      }
      i = paramInt;
      if (this.abGx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abGx);
      }
      paramInt = i;
      if (this.abGy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abGy);
      }
      i = paramInt;
      if (this.abGz != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abGz);
      }
      paramInt = i;
      if (this.abGA != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abGA);
      }
      AppMethodBeat.o(257667);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257667);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fgr localfgr = (fgr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257667);
          return -1;
        case 1: 
          localfgr.abGv = locala.ajGk.readString();
          AppMethodBeat.o(257667);
          return 0;
        case 2: 
          localfgr.abGw = locala.ajGk.readString();
          AppMethodBeat.o(257667);
          return 0;
        case 3: 
          localfgr.abGx = locala.ajGk.readString();
          AppMethodBeat.o(257667);
          return 0;
        case 4: 
          localfgr.abGy = locala.ajGk.readString();
          AppMethodBeat.o(257667);
          return 0;
        case 5: 
          localfgr.abGz = locala.ajGk.readString();
          AppMethodBeat.o(257667);
          return 0;
        }
        localfgr.abGA = locala.ajGk.readString();
        AppMethodBeat.o(257667);
        return 0;
      }
      AppMethodBeat.o(257667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgr
 * JD-Core Version:    0.7.0.1
 */