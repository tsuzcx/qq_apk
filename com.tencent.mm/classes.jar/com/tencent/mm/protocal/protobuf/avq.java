package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avq
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String Url;
  public int jKs;
  public String ntp;
  public String wKR;
  public String xlc;
  public String xld;
  public String xle;
  public String xlf;
  public int xlg;
  public String xlh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28527);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.xlc != null) {
        paramVarArgs.e(2, this.xlc);
      }
      paramVarArgs.aO(3, this.jKs);
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      if (this.xld != null) {
        paramVarArgs.e(5, this.xld);
      }
      if (this.wKR != null) {
        paramVarArgs.e(6, this.wKR);
      }
      if (this.xle != null) {
        paramVarArgs.e(7, this.xle);
      }
      if (this.ntp != null) {
        paramVarArgs.e(8, this.ntp);
      }
      if (this.xlf != null) {
        paramVarArgs.e(9, this.xlf);
      }
      paramVarArgs.aO(10, this.xlg);
      if (this.xlh != null) {
        paramVarArgs.e(11, this.xlh);
      }
      AppMethodBeat.o(28527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xlc);
      }
      i += e.a.a.b.b.a.bl(3, this.jKs);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Url);
      }
      i = paramInt;
      if (this.xld != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xld);
      }
      paramInt = i;
      if (this.wKR != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKR);
      }
      i = paramInt;
      if (this.xle != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xle);
      }
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ntp);
      }
      i = paramInt;
      if (this.xlf != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xlf);
      }
      i += e.a.a.b.b.a.bl(10, this.xlg);
      paramInt = i;
      if (this.xlh != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xlh);
      }
      AppMethodBeat.o(28527);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28527);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avq localavq = (avq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28527);
          return -1;
        case 1: 
          localavq.Title = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 2: 
          localavq.xlc = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 3: 
          localavq.jKs = locala.CLY.sl();
          AppMethodBeat.o(28527);
          return 0;
        case 4: 
          localavq.Url = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 5: 
          localavq.xld = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 6: 
          localavq.wKR = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 7: 
          localavq.xle = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 8: 
          localavq.ntp = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 9: 
          localavq.xlf = locala.CLY.readString();
          AppMethodBeat.o(28527);
          return 0;
        case 10: 
          localavq.xlg = locala.CLY.sl();
          AppMethodBeat.o(28527);
          return 0;
        }
        localavq.xlh = locala.CLY.readString();
        AppMethodBeat.o(28527);
        return 0;
      }
      AppMethodBeat.o(28527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avq
 * JD-Core Version:    0.7.0.1
 */