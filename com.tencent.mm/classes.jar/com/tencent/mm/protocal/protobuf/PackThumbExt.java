package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PackThumbExt
  extends com.tencent.mm.bv.a
{
  public String ActivityID;
  public String AesKey;
  public String CDNUrl;
  public String Desc;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String Md5;
  public String PreviewUrl;
  public String ThumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62577);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.PreviewUrl != null) {
        paramVarArgs.e(1, this.PreviewUrl);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(3, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(4, this.AesKey);
      }
      if (this.CDNUrl != null) {
        paramVarArgs.e(5, this.CDNUrl);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(6, this.ThumbUrl);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.e(7, this.EncryptUrl);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.e(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.e(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.e(10, this.ActivityID);
      }
      AppMethodBeat.o(62577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.PreviewUrl == null) {
        break label766;
      }
    }
    label766:
    for (int i = e.a.a.b.b.a.f(1, this.PreviewUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Md5);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.AesKey);
      }
      i = paramInt;
      if (this.CDNUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.CDNUrl);
      }
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ThumbUrl);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.EncryptUrl);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.ActivityID);
      }
      AppMethodBeat.o(62577);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62577);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        PackThumbExt localPackThumbExt = (PackThumbExt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62577);
          return -1;
        case 1: 
          localPackThumbExt.PreviewUrl = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 2: 
          localPackThumbExt.Desc = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 3: 
          localPackThumbExt.Md5 = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 4: 
          localPackThumbExt.AesKey = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 5: 
          localPackThumbExt.CDNUrl = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 6: 
          localPackThumbExt.ThumbUrl = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 7: 
          localPackThumbExt.EncryptUrl = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 8: 
          localPackThumbExt.ExternUrl = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        case 9: 
          localPackThumbExt.ExternMd5 = locala.CLY.readString();
          AppMethodBeat.o(62577);
          return 0;
        }
        localPackThumbExt.ActivityID = locala.CLY.readString();
        AppMethodBeat.o(62577);
        return 0;
      }
      AppMethodBeat.o(62577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.PackThumbExt
 * JD-Core Version:    0.7.0.1
 */