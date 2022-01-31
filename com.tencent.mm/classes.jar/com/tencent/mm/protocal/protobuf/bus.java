package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bus
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public String wQr;
  public String wUW;
  public String xHt;
  public String xIn;
  public float xIo;
  public String xIp;
  public String xIq;
  public String xIr;
  public String xIs;
  public String xIt;
  public String xIu;
  public String xIv;
  public float xIw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(65420);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wUW == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileID");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.AesKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesKey");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIr == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIt == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIu == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(65420);
        throw paramVarArgs;
      }
      if (this.xIv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(65420);
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
      if (this.xIn != null) {
        paramVarArgs.e(4, this.xIn);
      }
      paramVarArgs.q(5, this.xIo);
      if (this.xIp != null) {
        paramVarArgs.e(6, this.xIp);
      }
      if (this.xIq != null) {
        paramVarArgs.e(7, this.xIq);
      }
      if (this.xIr != null) {
        paramVarArgs.e(8, this.xIr);
      }
      if (this.xHt != null) {
        paramVarArgs.e(9, this.xHt);
      }
      if (this.xIs != null) {
        paramVarArgs.e(10, this.xIs);
      }
      if (this.xIt != null) {
        paramVarArgs.e(11, this.xIt);
      }
      if (this.xIu != null) {
        paramVarArgs.e(12, this.xIu);
      }
      if (this.xIv != null) {
        paramVarArgs.e(13, this.xIv);
      }
      paramVarArgs.q(14, this.xIw);
      AppMethodBeat.o(65420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wUW == null) {
        break label1368;
      }
    }
    label1368:
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
      if (this.xIn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xIn);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 4);
      paramInt = i;
      if (this.xIp != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xIp);
      }
      i = paramInt;
      if (this.xIq != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xIq);
      }
      paramInt = i;
      if (this.xIr != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xIr);
      }
      i = paramInt;
      if (this.xHt != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xHt);
      }
      paramInt = i;
      if (this.xIs != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xIs);
      }
      i = paramInt;
      if (this.xIt != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xIt);
      }
      paramInt = i;
      if (this.xIu != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xIu);
      }
      i = paramInt;
      if (this.xIv != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xIv);
      }
      paramInt = e.a.a.b.b.a.eW(14);
      AppMethodBeat.o(65420);
      return i + (paramInt + 4);
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
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.AesKey == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesKey");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIr == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIt == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIu == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        if (this.xIv == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
          AppMethodBeat.o(65420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(65420);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(65420);
          return -1;
        case 1: 
          localbus.wUW = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 2: 
          localbus.AesKey = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 3: 
          localbus.wQr = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 4: 
          localbus.xIn = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 5: 
          localbus.xIo = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(65420);
          return 0;
        case 6: 
          localbus.xIp = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 7: 
          localbus.xIq = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 8: 
          localbus.xIr = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 9: 
          localbus.xHt = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 10: 
          localbus.xIs = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 11: 
          localbus.xIt = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 12: 
          localbus.xIu = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        case 13: 
          localbus.xIv = locala.CLY.readString();
          AppMethodBeat.o(65420);
          return 0;
        }
        localbus.xIw = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(65420);
        return 0;
      }
      AppMethodBeat.o(65420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */