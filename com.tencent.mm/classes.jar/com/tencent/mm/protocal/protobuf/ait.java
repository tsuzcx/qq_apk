package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ait
  extends com.tencent.mm.bw.a
{
  public String ActivityID;
  public String AesKey;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String Lsl;
  public String Lsm;
  public String Lsn;
  public String Lso;
  public String Md5;
  public String ProductID;
  public String ThumbUrl;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104759);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(104759);
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
      if (this.Lsl != null) {
        paramVarArgs.e(4, this.Lsl);
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
      if (this.Lsm != null) {
        paramVarArgs.e(11, this.Lsm);
      }
      if (this.Lsn != null) {
        paramVarArgs.e(12, this.Lsn);
      }
      if (this.Lso != null) {
        paramVarArgs.e(13, this.Lso);
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
    for (int i = g.a.a.b.b.a.f(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.Lsl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lsl);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.ProductID);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.ActivityID);
      }
      i = paramInt;
      if (this.Lsm != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Lsm);
      }
      paramInt = i;
      if (this.Lsn != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Lsn);
      }
      i = paramInt;
      if (this.Lso != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.Lso);
      }
      AppMethodBeat.o(104759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ait localait = (ait)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104759);
          return -1;
        case 1: 
          localait.Md5 = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 2: 
          localait.Url = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 3: 
          localait.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 4: 
          localait.Lsl = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 5: 
          localait.EncryptUrl = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 6: 
          localait.AesKey = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 7: 
          localait.ProductID = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 8: 
          localait.ExternUrl = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 9: 
          localait.ExternMd5 = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 10: 
          localait.ActivityID = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 11: 
          localait.Lsm = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 12: 
          localait.Lsn = locala.UbS.readString();
          AppMethodBeat.o(104759);
          return 0;
        }
        localait.Lso = locala.UbS.readString();
        AppMethodBeat.o(104759);
        return 0;
      }
      AppMethodBeat.o(104759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ait
 * JD-Core Version:    0.7.0.1
 */