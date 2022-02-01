package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhm
  extends com.tencent.mm.cd.a
{
  public String ActivityID;
  public String AesKey;
  public String CMB;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String Md5;
  public String ThumbUrl;
  public String WxE;
  public String Xsf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.WxE != null) {
        paramVarArgs.f(1, this.WxE);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(3, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(4, this.AesKey);
      }
      if (this.Xsf != null) {
        paramVarArgs.f(5, this.Xsf);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(6, this.ThumbUrl);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.f(7, this.EncryptUrl);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.f(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.f(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.f(10, this.ActivityID);
      }
      AppMethodBeat.o(104824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.WxE == null) {
        break label766;
      }
    }
    label766:
    for (int i = g.a.a.b.b.a.g(1, this.WxE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Md5);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.AesKey);
      }
      i = paramInt;
      if (this.Xsf != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Xsf);
      }
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ThumbUrl);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.EncryptUrl);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ActivityID);
      }
      AppMethodBeat.o(104824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104824);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhm localdhm = (dhm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104824);
          return -1;
        case 1: 
          localdhm.WxE = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 2: 
          localdhm.CMB = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 3: 
          localdhm.Md5 = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 4: 
          localdhm.AesKey = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 5: 
          localdhm.Xsf = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 6: 
          localdhm.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 7: 
          localdhm.EncryptUrl = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 8: 
          localdhm.ExternUrl = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        case 9: 
          localdhm.ExternMd5 = locala.abFh.readString();
          AppMethodBeat.o(104824);
          return 0;
        }
        localdhm.ActivityID = locala.abFh.readString();
        AppMethodBeat.o(104824);
        return 0;
      }
      AppMethodBeat.o(104824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhm
 * JD-Core Version:    0.7.0.1
 */