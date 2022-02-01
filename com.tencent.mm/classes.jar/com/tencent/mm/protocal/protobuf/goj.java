package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class goj
  extends com.tencent.mm.bx.a
{
  public String ActivityID;
  public String AesKey;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String IGG;
  public String Md5;
  public String ThumbUrl;
  public String aklj;
  public String aklk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104824);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aklj != null) {
        paramVarArgs.g(1, this.aklj);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(3, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(4, this.AesKey);
      }
      if (this.aklk != null) {
        paramVarArgs.g(5, this.aklk);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(6, this.ThumbUrl);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.g(7, this.EncryptUrl);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.g(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.g(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.g(10, this.ActivityID);
      }
      AppMethodBeat.o(104824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aklj == null) {
        break label762;
      }
    }
    label762:
    for (int i = i.a.a.b.b.a.h(1, this.aklj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Md5);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.AesKey);
      }
      i = paramInt;
      if (this.aklk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aklk);
      }
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ThumbUrl);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.EncryptUrl);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ActivityID);
      }
      AppMethodBeat.o(104824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104824);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        goj localgoj = (goj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104824);
          return -1;
        case 1: 
          localgoj.aklj = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 2: 
          localgoj.IGG = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 3: 
          localgoj.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 4: 
          localgoj.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 5: 
          localgoj.aklk = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 6: 
          localgoj.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 7: 
          localgoj.EncryptUrl = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 8: 
          localgoj.ExternUrl = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 9: 
          localgoj.ExternMd5 = locala.ajGk.readString();
          AppMethodBeat.o(104824);
          return 0;
        }
        localgoj.ActivityID = locala.ajGk.readString();
        AppMethodBeat.o(104824);
        return 0;
      }
      AppMethodBeat.o(104824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.goj
 * JD-Core Version:    0.7.0.1
 */