package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class eqi
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String MD5;
  public String ZBp;
  public String abuf;
  public String abug;
  public String abuh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZBp == null)
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
      if (this.abuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.abug == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.abuh == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.ZBp != null) {
        paramVarArgs.g(1, this.ZBp);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(3, this.MD5);
      }
      if (this.abuf != null) {
        paramVarArgs.g(4, this.abuf);
      }
      if (this.abug != null) {
        paramVarArgs.g(5, this.abug);
      }
      if (this.abuh != null) {
        paramVarArgs.g(6, this.abuh);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZBp == null) {
        break label802;
      }
    }
    label802:
    for (int i = i.a.a.b.b.a.h(1, this.ZBp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MD5);
      }
      paramInt = i;
      if (this.abuf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abuf);
      }
      i = paramInt;
      if (this.abug != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abug);
      }
      paramInt = i;
      if (this.abuh != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abuh);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZBp == null)
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
        if (this.abuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.abug == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.abuh == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eqi localeqi = (eqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localeqi.ZBp = locala.ajGk.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localeqi.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localeqi.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localeqi.abuf = locala.ajGk.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localeqi.abug = locala.ajGk.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localeqi.abuh = locala.ajGk.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqi
 * JD-Core Version:    0.7.0.1
 */