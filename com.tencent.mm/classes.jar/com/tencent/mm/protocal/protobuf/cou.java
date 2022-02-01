package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cou
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String EBF;
  public String FBF;
  public String FBG;
  public String FBH;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBF == null)
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
      if (this.FBF == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.FBG == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.FBH == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.EBF != null) {
        paramVarArgs.d(1, this.EBF);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.FBF != null) {
        paramVarArgs.d(4, this.FBF);
      }
      if (this.FBG != null) {
        paramVarArgs.d(5, this.FBG);
      }
      if (this.FBH != null) {
        paramVarArgs.d(6, this.FBH);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBF == null) {
        break label806;
      }
    }
    label806:
    for (int i = f.a.a.b.b.a.e(1, this.EBF) + 0;; i = 0)
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
      if (this.FBF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FBF);
      }
      i = paramInt;
      if (this.FBG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FBG);
      }
      paramInt = i;
      if (this.FBH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBH);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EBF == null)
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
        if (this.FBF == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.FBG == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.FBH == null)
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
        cou localcou = (cou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localcou.EBF = locala.LVo.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localcou.AesKey = locala.LVo.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localcou.MD5 = locala.LVo.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localcou.FBF = locala.LVo.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localcou.FBG = locala.LVo.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localcou.FBH = locala.LVo.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */