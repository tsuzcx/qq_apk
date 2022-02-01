package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cjn
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Diz;
  public String EeF;
  public String EeG;
  public String EeH;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Diz == null)
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
      if (this.EeF == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.EeG == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.EeH == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.Diz != null) {
        paramVarArgs.d(1, this.Diz);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.EeF != null) {
        paramVarArgs.d(4, this.EeF);
      }
      if (this.EeG != null) {
        paramVarArgs.d(5, this.EeG);
      }
      if (this.EeH != null) {
        paramVarArgs.d(6, this.EeH);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Diz == null) {
        break label806;
      }
    }
    label806:
    for (int i = f.a.a.b.b.a.e(1, this.Diz) + 0;; i = 0)
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
      if (this.EeF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EeF);
      }
      i = paramInt;
      if (this.EeG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EeG);
      }
      paramInt = i;
      if (this.EeH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EeH);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Diz == null)
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
        if (this.EeF == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.EeG == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.EeH == null)
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
        cjn localcjn = (cjn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localcjn.Diz = locala.KhF.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localcjn.AesKey = locala.KhF.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localcjn.MD5 = locala.KhF.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localcjn.EeF = locala.KhF.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localcjn.EeG = locala.KhF.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localcjn.EeH = locala.KhF.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjn
 * JD-Core Version:    0.7.0.1
 */