package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cut
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String GCa;
  public String HFu;
  public String HFv;
  public String HFw;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GCa == null)
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
      if (this.HFu == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.HFv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.HFw == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.GCa != null) {
        paramVarArgs.d(1, this.GCa);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.HFu != null) {
        paramVarArgs.d(4, this.HFu);
      }
      if (this.HFv != null) {
        paramVarArgs.d(5, this.HFv);
      }
      if (this.HFw != null) {
        paramVarArgs.d(6, this.HFw);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GCa == null) {
        break label806;
      }
    }
    label806:
    for (int i = f.a.a.b.b.a.e(1, this.GCa) + 0;; i = 0)
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
      if (this.HFu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HFu);
      }
      i = paramInt;
      if (this.HFv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HFv);
      }
      paramInt = i;
      if (this.HFw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HFw);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GCa == null)
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
        if (this.HFu == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.HFv == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.HFw == null)
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
        cut localcut = (cut)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localcut.GCa = locala.OmT.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localcut.AesKey = locala.OmT.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localcut.MD5 = locala.OmT.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localcut.HFu = locala.OmT.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localcut.HFv = locala.OmT.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localcut.HFw = locala.OmT.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cut
 * JD-Core Version:    0.7.0.1
 */