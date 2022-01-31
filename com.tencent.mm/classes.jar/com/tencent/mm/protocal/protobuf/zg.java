package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class zg
  extends com.tencent.mm.bv.a
{
  public String ActivityID;
  public String AesKey;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String Md5;
  public String ProductID;
  public String ThumbUrl;
  public String Url;
  public String wQg;
  public String wQh;
  public String wQi;
  public String wQj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62523);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(62523);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.wQg != null) {
        paramVarArgs.e(4, this.wQg);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.e(5, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(6, this.AesKey);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(7, this.ProductID);
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
      if (this.wQh != null) {
        paramVarArgs.e(11, this.wQh);
      }
      if (this.wQi != null) {
        paramVarArgs.e(12, this.wQi);
      }
      if (this.wQj != null) {
        paramVarArgs.e(13, this.wQj);
      }
      AppMethodBeat.o(62523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label998;
      }
    }
    label998:
    for (int i = e.a.a.b.b.a.f(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.wQg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wQg);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.ProductID);
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
      i = paramInt;
      if (this.wQh != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wQh);
      }
      paramInt = i;
      if (this.wQi != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wQi);
      }
      i = paramInt;
      if (this.wQj != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wQj);
      }
      AppMethodBeat.o(62523);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(62523);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62523);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        zg localzg = (zg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62523);
          return -1;
        case 1: 
          localzg.Md5 = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 2: 
          localzg.Url = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 3: 
          localzg.ThumbUrl = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 4: 
          localzg.wQg = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 5: 
          localzg.EncryptUrl = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 6: 
          localzg.AesKey = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 7: 
          localzg.ProductID = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 8: 
          localzg.ExternUrl = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 9: 
          localzg.ExternMd5 = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 10: 
          localzg.ActivityID = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 11: 
          localzg.wQh = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        case 12: 
          localzg.wQi = locala.CLY.readString();
          AppMethodBeat.o(62523);
          return 0;
        }
        localzg.wQj = locala.CLY.readString();
        AppMethodBeat.o(62523);
        return 0;
      }
      AppMethodBeat.o(62523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zg
 * JD-Core Version:    0.7.0.1
 */