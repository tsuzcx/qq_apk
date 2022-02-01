package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ads
  extends com.tencent.mm.bw.a
{
  public String ActivityID;
  public String AesKey;
  public String EncryptUrl;
  public String Ewv;
  public String Eww;
  public String Ewx;
  public String Ewy;
  public String ExternMd5;
  public String ExternUrl;
  public String Md5;
  public String ProductID;
  public String ThumbUrl;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(104759);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      if (this.Ewv != null) {
        paramVarArgs.d(4, this.Ewv);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.d(5, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(6, this.AesKey);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(7, this.ProductID);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.d(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.d(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.d(10, this.ActivityID);
      }
      if (this.Eww != null) {
        paramVarArgs.d(11, this.Eww);
      }
      if (this.Ewx != null) {
        paramVarArgs.d(12, this.Ewx);
      }
      if (this.Ewy != null) {
        paramVarArgs.d(13, this.Ewy);
      }
      AppMethodBeat.o(104759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.b.b.a.e(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.Ewv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ewv);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ProductID);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ActivityID);
      }
      i = paramInt;
      if (this.Eww != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Eww);
      }
      paramInt = i;
      if (this.Ewx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Ewx);
      }
      i = paramInt;
      if (this.Ewy != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Ewy);
      }
      AppMethodBeat.o(104759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(104759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104759);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ads localads = (ads)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104759);
          return -1;
        case 1: 
          localads.Md5 = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 2: 
          localads.Url = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 3: 
          localads.ThumbUrl = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 4: 
          localads.Ewv = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 5: 
          localads.EncryptUrl = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 6: 
          localads.AesKey = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 7: 
          localads.ProductID = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 8: 
          localads.ExternUrl = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 9: 
          localads.ExternMd5 = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 10: 
          localads.ActivityID = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 11: 
          localads.Eww = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 12: 
          localads.Ewx = locala.LVo.readString();
          AppMethodBeat.o(104759);
          return 0;
        }
        localads.Ewy = locala.LVo.readString();
        AppMethodBeat.o(104759);
        return 0;
      }
      AppMethodBeat.o(104759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ads
 * JD-Core Version:    0.7.0.1
 */