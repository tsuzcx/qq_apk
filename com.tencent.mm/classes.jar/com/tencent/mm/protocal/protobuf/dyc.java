package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dyc
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public String MD5;
  public String SAx;
  public String TPM;
  public String TPN;
  public String UcN;
  public String UdI;
  public float UdJ;
  public String UdK;
  public String UdL;
  public String UdM;
  public String UdN;
  public String UdO;
  public float UdP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SAx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.AesKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.TPM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.TPN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.UdK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.UdM == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.UdN == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.UdO == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
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
      if (this.UdI != null) {
        paramVarArgs.f(4, this.UdI);
      }
      paramVarArgs.i(5, this.UdJ);
      if (this.TPM != null) {
        paramVarArgs.f(6, this.TPM);
      }
      if (this.TPN != null) {
        paramVarArgs.f(7, this.TPN);
      }
      if (this.UdK != null) {
        paramVarArgs.f(8, this.UdK);
      }
      if (this.UcN != null) {
        paramVarArgs.f(9, this.UcN);
      }
      if (this.UdL != null) {
        paramVarArgs.f(10, this.UdL);
      }
      if (this.UdM != null) {
        paramVarArgs.f(11, this.UdM);
      }
      if (this.UdN != null) {
        paramVarArgs.f(12, this.UdN);
      }
      if (this.UdO != null) {
        paramVarArgs.f(13, this.UdO);
      }
      paramVarArgs.i(14, this.UdP);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SAx == null) {
        break label1368;
      }
    }
    label1368:
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
      if (this.UdI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UdI);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 4);
      paramInt = i;
      if (this.TPM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TPM);
      }
      i = paramInt;
      if (this.TPN != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TPN);
      }
      paramInt = i;
      if (this.UdK != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UdK);
      }
      i = paramInt;
      if (this.UcN != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UcN);
      }
      paramInt = i;
      if (this.UdL != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.UdL);
      }
      i = paramInt;
      if (this.UdM != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.UdM);
      }
      paramInt = i;
      if (this.UdN != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UdN);
      }
      i = paramInt;
      if (this.UdO != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.UdO);
      }
      paramInt = g.a.a.b.b.a.gL(14);
      AppMethodBeat.o(115967);
      return i + (paramInt + 4);
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
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.AesKey == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.TPM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.TPN == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.UdK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.UdM == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.UdN == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.UdO == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115967);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyc localdyc = (dyc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localdyc.SAx = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localdyc.AesKey = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localdyc.MD5 = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localdyc.UdI = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localdyc.UdJ = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localdyc.TPM = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localdyc.TPN = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localdyc.UdK = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localdyc.UcN = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localdyc.UdL = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localdyc.UdM = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localdyc.UdN = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localdyc.UdO = locala.abFh.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localdyc.UdP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyc
 * JD-Core Version:    0.7.0.1
 */