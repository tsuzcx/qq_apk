package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ctz
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Gjr;
  public String HlU;
  public String HlV;
  public String HlW;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gjr == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.AesKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.HlU == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.HlV == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.HlW == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.Gjr != null) {
        paramVarArgs.d(1, this.Gjr);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.HlU != null) {
        paramVarArgs.d(4, this.HlU);
      }
      if (this.HlV != null) {
        paramVarArgs.d(5, this.HlV);
      }
      if (this.HlW != null) {
        paramVarArgs.d(6, this.HlW);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gjr == null) {
        break label806;
      }
    }
    label806:
    for (int i = f.a.a.b.b.a.e(1, this.Gjr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = i;
      if (this.HlU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HlU);
      }
      i = paramInt;
      if (this.HlV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HlV);
      }
      paramInt = i;
      if (this.HlW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HlW);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gjr == null)
        {
          paramVarArgs = new b("Not all required fields were included: FileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.AesKey == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.HlU == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.HlV == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.HlW == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginMD5");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115963);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctz localctz = (ctz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localctz.Gjr = locala.NPN.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localctz.AesKey = locala.NPN.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localctz.MD5 = locala.NPN.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localctz.HlU = locala.NPN.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localctz.HlV = locala.NPN.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localctz.HlW = locala.NPN.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctz
 * JD-Core Version:    0.7.0.1
 */