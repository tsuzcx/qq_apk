package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzg
  extends com.tencent.mm.bx.a
{
  public String aaiu;
  public String aaiv;
  public String aaiw;
  public String feedId;
  public String mxQ;
  public String nonceId;
  public String zDJ;
  public String zSx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257598);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.g(1, this.feedId);
      }
      if (this.nonceId != null) {
        paramVarArgs.g(2, this.nonceId);
      }
      if (this.zDJ != null) {
        paramVarArgs.g(3, this.zDJ);
      }
      if (this.aaiu != null) {
        paramVarArgs.g(4, this.aaiu);
      }
      if (this.aaiv != null) {
        paramVarArgs.g(5, this.aaiv);
      }
      if (this.mxQ != null) {
        paramVarArgs.g(6, this.mxQ);
      }
      if (this.aaiw != null) {
        paramVarArgs.g(7, this.aaiw);
      }
      if (this.zSx != null) {
        paramVarArgs.g(8, this.zSx);
      }
      AppMethodBeat.o(257598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label638;
      }
    }
    label638:
    for (int i = i.a.a.b.b.a.h(1, this.feedId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nonceId);
      }
      i = paramInt;
      if (this.zDJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.zDJ);
      }
      paramInt = i;
      if (this.aaiu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaiu);
      }
      i = paramInt;
      if (this.aaiv != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaiv);
      }
      paramInt = i;
      if (this.mxQ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mxQ);
      }
      i = paramInt;
      if (this.aaiw != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaiw);
      }
      paramInt = i;
      if (this.zSx != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.zSx);
      }
      AppMethodBeat.o(257598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257598);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bzg localbzg = (bzg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257598);
          return -1;
        case 1: 
          localbzg.feedId = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 2: 
          localbzg.nonceId = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 3: 
          localbzg.zDJ = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 4: 
          localbzg.aaiu = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 5: 
          localbzg.aaiv = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 6: 
          localbzg.mxQ = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        case 7: 
          localbzg.aaiw = locala.ajGk.readString();
          AppMethodBeat.o(257598);
          return 0;
        }
        localbzg.zSx = locala.ajGk.readString();
        AppMethodBeat.o(257598);
        return 0;
      }
      AppMethodBeat.o(257598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzg
 * JD-Core Version:    0.7.0.1
 */