package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bub
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public String wQr;
  public String wUW;
  public String xHr;
  public String xHs;
  public String xHt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(65416);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wUW == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileID");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.AesKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesKey");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.wQr == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.xHr == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.xHs == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.xHt == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(65416);
        throw paramVarArgs;
      }
      if (this.wUW != null) {
        paramVarArgs.e(1, this.wUW);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.wQr != null) {
        paramVarArgs.e(3, this.wQr);
      }
      if (this.xHr != null) {
        paramVarArgs.e(4, this.xHr);
      }
      if (this.xHs != null) {
        paramVarArgs.e(5, this.xHs);
      }
      if (this.xHt != null) {
        paramVarArgs.e(6, this.xHt);
      }
      AppMethodBeat.o(65416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wUW == null) {
        break label806;
      }
    }
    label806:
    for (int i = e.a.a.b.b.a.f(1, this.wUW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.wQr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQr);
      }
      paramInt = i;
      if (this.xHr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xHr);
      }
      i = paramInt;
      if (this.xHs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xHs);
      }
      paramInt = i;
      if (this.xHt != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xHt);
      }
      AppMethodBeat.o(65416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wUW == null)
        {
          paramVarArgs = new b("Not all required fields were included: FileID");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        if (this.AesKey == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesKey");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        if (this.wQr == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        if (this.xHr == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        if (this.xHs == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        if (this.xHt == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginMD5");
          AppMethodBeat.o(65416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(65416);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bub localbub = (bub)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(65416);
          return -1;
        case 1: 
          localbub.wUW = locala.CLY.readString();
          AppMethodBeat.o(65416);
          return 0;
        case 2: 
          localbub.AesKey = locala.CLY.readString();
          AppMethodBeat.o(65416);
          return 0;
        case 3: 
          localbub.wQr = locala.CLY.readString();
          AppMethodBeat.o(65416);
          return 0;
        case 4: 
          localbub.xHr = locala.CLY.readString();
          AppMethodBeat.o(65416);
          return 0;
        case 5: 
          localbub.xHs = locala.CLY.readString();
          AppMethodBeat.o(65416);
          return 0;
        }
        localbub.xHt = locala.CLY.readString();
        AppMethodBeat.o(65416);
        return 0;
      }
      AppMethodBeat.o(65416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bub
 * JD-Core Version:    0.7.0.1
 */