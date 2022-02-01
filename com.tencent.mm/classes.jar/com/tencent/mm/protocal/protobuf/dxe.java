package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dxe
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public String MD5;
  public String SAx;
  public String UcL;
  public String UcM;
  public String UcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115963);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SAx == null)
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
      if (this.UcL == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginFileID");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.UcM == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginAesKey");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.UcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginMD5");
        AppMethodBeat.o(115963);
        throw paramVarArgs;
      }
      if (this.SAx != null) {
        paramVarArgs.f(1, this.SAx);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(3, this.MD5);
      }
      if (this.UcL != null) {
        paramVarArgs.f(4, this.UcL);
      }
      if (this.UcM != null) {
        paramVarArgs.f(5, this.UcM);
      }
      if (this.UcN != null) {
        paramVarArgs.f(6, this.UcN);
      }
      AppMethodBeat.o(115963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SAx == null) {
        break label806;
      }
    }
    label806:
    for (int i = g.a.a.b.b.a.g(1, this.SAx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MD5);
      }
      paramInt = i;
      if (this.UcL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UcL);
      }
      i = paramInt;
      if (this.UcM != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UcM);
      }
      paramInt = i;
      if (this.UcN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UcN);
      }
      AppMethodBeat.o(115963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SAx == null)
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
        if (this.UcL == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginFileID");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.UcM == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginAesKey");
          AppMethodBeat.o(115963);
          throw paramVarArgs;
        }
        if (this.UcN == null)
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
        dxe localdxe = (dxe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115963);
          return -1;
        case 1: 
          localdxe.SAx = locala.abFh.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 2: 
          localdxe.AesKey = locala.abFh.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 3: 
          localdxe.MD5 = locala.abFh.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 4: 
          localdxe.UcL = locala.abFh.readString();
          AppMethodBeat.o(115963);
          return 0;
        case 5: 
          localdxe.UcM = locala.abFh.readString();
          AppMethodBeat.o(115963);
          return 0;
        }
        localdxe.UcN = locala.abFh.readString();
        AppMethodBeat.o(115963);
        return 0;
      }
      AppMethodBeat.o(115963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */