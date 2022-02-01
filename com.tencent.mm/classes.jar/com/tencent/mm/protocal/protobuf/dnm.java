package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dnm
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String LxW;
  public String MD5;
  public String MQE;
  public String MQF;
  public String MQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LxW == null)
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
      if (this.MQE == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.MQF == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.MQG == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.LxW != null) {
        paramVarArgs.e(1, this.LxW);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      if (this.MQE != null) {
        paramVarArgs.e(4, this.MQE);
      }
      if (this.MQF != null) {
        paramVarArgs.e(5, this.MQF);
      }
      if (this.MQG != null) {
        paramVarArgs.e(6, this.MQG);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LxW == null) {
        break label806;
      }
    }
    label806:
    for (int i = g.a.a.b.b.a.f(1, this.LxW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MD5);
      }
      paramInt = i;
      if (this.MQE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MQE);
      }
      i = paramInt;
      if (this.MQF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MQF);
      }
      paramInt = i;
      if (this.MQG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MQG);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LxW == null)
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
        if (this.MQE == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.MQF == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.MQG == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dnm localdnm = (dnm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localdnm.LxW = locala.UbS.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localdnm.AesKey = locala.UbS.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localdnm.MD5 = locala.UbS.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localdnm.MQE = locala.UbS.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localdnm.MQF = locala.UbS.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localdnm.MQG = locala.UbS.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnm
 * JD-Core Version:    0.7.0.1
 */