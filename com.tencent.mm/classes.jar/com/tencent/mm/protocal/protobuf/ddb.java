package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddb
  extends cvp
{
  public SKBuiltinBuffer_t GCb;
  public SKBuiltinBuffer_t GCc;
  public SKBuiltinBuffer_t GCd;
  public int Hmw;
  public int HrN;
  public SKBuiltinBuffer_t HrO;
  public SKBuiltinBuffer_t HrP;
  public SKBuiltinBuffer_t HrQ;
  public SKBuiltinBuffer_t HrR;
  public SKBuiltinBuffer_t HrS;
  public int HrT;
  public String HrU;
  public int ihf;
  public float ihh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HrO == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HrP == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GCc == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GCd == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HrQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HrR == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HrS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GCb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ihf);
      paramVarArgs.aS(3, this.HrN);
      paramVarArgs.z(4, this.ihh);
      if (this.HrO != null)
      {
        paramVarArgs.lC(5, this.HrO.computeSize());
        this.HrO.writeFields(paramVarArgs);
      }
      if (this.HrP != null)
      {
        paramVarArgs.lC(6, this.HrP.computeSize());
        this.HrP.writeFields(paramVarArgs);
      }
      if (this.GCc != null)
      {
        paramVarArgs.lC(7, this.GCc.computeSize());
        this.GCc.writeFields(paramVarArgs);
      }
      if (this.GCd != null)
      {
        paramVarArgs.lC(8, this.GCd.computeSize());
        this.GCd.writeFields(paramVarArgs);
      }
      if (this.HrQ != null)
      {
        paramVarArgs.lC(9, this.HrQ.computeSize());
        this.HrQ.writeFields(paramVarArgs);
      }
      if (this.HrR != null)
      {
        paramVarArgs.lC(10, this.HrR.computeSize());
        this.HrR.writeFields(paramVarArgs);
      }
      if (this.HrS != null)
      {
        paramVarArgs.lC(11, this.HrS.computeSize());
        this.HrS.writeFields(paramVarArgs);
      }
      if (this.GCb != null)
      {
        paramVarArgs.lC(12, this.GCb.computeSize());
        this.GCb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.Hmw);
      paramVarArgs.aS(14, this.HrT);
      if (this.HrU != null) {
        paramVarArgs.d(15, this.HrU);
      }
      AppMethodBeat.o(32445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2306;
      }
    }
    label2306:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ihf) + f.a.a.b.b.a.bz(3, this.HrN) + f.a.a.b.b.a.alU(4);
      paramInt = i;
      if (this.HrO != null) {
        paramInt = i + f.a.a.a.lB(5, this.HrO.computeSize());
      }
      i = paramInt;
      if (this.HrP != null) {
        i = paramInt + f.a.a.a.lB(6, this.HrP.computeSize());
      }
      paramInt = i;
      if (this.GCc != null) {
        paramInt = i + f.a.a.a.lB(7, this.GCc.computeSize());
      }
      i = paramInt;
      if (this.GCd != null) {
        i = paramInt + f.a.a.a.lB(8, this.GCd.computeSize());
      }
      paramInt = i;
      if (this.HrQ != null) {
        paramInt = i + f.a.a.a.lB(9, this.HrQ.computeSize());
      }
      i = paramInt;
      if (this.HrR != null) {
        i = paramInt + f.a.a.a.lB(10, this.HrR.computeSize());
      }
      paramInt = i;
      if (this.HrS != null) {
        paramInt = i + f.a.a.a.lB(11, this.HrS.computeSize());
      }
      i = paramInt;
      if (this.GCb != null) {
        i = paramInt + f.a.a.a.lB(12, this.GCb.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(13, this.Hmw) + f.a.a.b.b.a.bz(14, this.HrT);
      paramInt = i;
      if (this.HrU != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HrU);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HrO == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HrP == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GCc == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GCd == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HrQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HrR == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HrS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GCb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongLyric");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddb localddb = (ddb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localddb.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localddb.HrN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localddb.ihh = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.HrO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.HrP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.GCc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.GCd = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.HrQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.HrR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.HrS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddb.GCb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localddb.Hmw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localddb.HrT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32445);
          return 0;
        }
        localddb.HrU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddb
 * JD-Core Version:    0.7.0.1
 */