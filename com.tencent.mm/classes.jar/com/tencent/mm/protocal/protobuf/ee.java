package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bx.a
{
  public String IIu;
  public String UserName;
  public String YGl;
  public String YGm;
  public String pSg;
  public String pSh;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pSo != null) {
        paramVarArgs.g(1, this.pSo);
      }
      if (this.pSg != null) {
        paramVarArgs.g(2, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(3, this.pSh);
      }
      if (this.IIu != null) {
        paramVarArgs.g(4, this.IIu);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      if (this.YGl != null) {
        paramVarArgs.g(6, this.YGl);
      }
      if (this.YGm != null) {
        paramVarArgs.g(7, this.YGm);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pSo == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.pSo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSh);
      }
      paramInt = i;
      if (this.IIu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IIu);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      paramInt = i;
      if (this.YGl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YGl);
      }
      i = paramInt;
      if (this.YGm != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YGm);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ee localee = (ee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localee.pSo = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localee.pSg = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localee.pSh = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localee.IIu = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localee.UserName = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localee.YGl = locala.ajGk.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localee.YGm = locala.ajGk.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */