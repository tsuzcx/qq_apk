package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dwz
  extends dpc
{
  public SKBuiltinBuffer_t LZV;
  public SKBuiltinBuffer_t LZW;
  public SKBuiltinBuffer_t LZX;
  public int MRg;
  public int MWY;
  public SKBuiltinBuffer_t MWZ;
  public SKBuiltinBuffer_t MXa;
  public SKBuiltinBuffer_t MXb;
  public SKBuiltinBuffer_t MXc;
  public SKBuiltinBuffer_t MXd;
  public int MXe;
  public String MXf;
  public int jeU;
  public float jeW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.MWZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.MXa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.LZW == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.LZX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.MXb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.MXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.MXd == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.LZV == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.jeU);
      paramVarArgs.aM(3, this.MWY);
      paramVarArgs.E(4, this.jeW);
      if (this.MWZ != null)
      {
        paramVarArgs.ni(5, this.MWZ.computeSize());
        this.MWZ.writeFields(paramVarArgs);
      }
      if (this.MXa != null)
      {
        paramVarArgs.ni(6, this.MXa.computeSize());
        this.MXa.writeFields(paramVarArgs);
      }
      if (this.LZW != null)
      {
        paramVarArgs.ni(7, this.LZW.computeSize());
        this.LZW.writeFields(paramVarArgs);
      }
      if (this.LZX != null)
      {
        paramVarArgs.ni(8, this.LZX.computeSize());
        this.LZX.writeFields(paramVarArgs);
      }
      if (this.MXb != null)
      {
        paramVarArgs.ni(9, this.MXb.computeSize());
        this.MXb.writeFields(paramVarArgs);
      }
      if (this.MXc != null)
      {
        paramVarArgs.ni(10, this.MXc.computeSize());
        this.MXc.writeFields(paramVarArgs);
      }
      if (this.MXd != null)
      {
        paramVarArgs.ni(11, this.MXd.computeSize());
        this.MXd.writeFields(paramVarArgs);
      }
      if (this.LZV != null)
      {
        paramVarArgs.ni(12, this.LZV.computeSize());
        this.LZV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.MRg);
      paramVarArgs.aM(14, this.MXe);
      if (this.MXf != null) {
        paramVarArgs.e(15, this.MXf);
      }
      AppMethodBeat.o(32445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2310;
      }
    }
    label2310:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.jeU) + g.a.a.b.b.a.bu(3, this.MWY) + (g.a.a.b.b.a.fS(4) + 4);
      paramInt = i;
      if (this.MWZ != null) {
        paramInt = i + g.a.a.a.nh(5, this.MWZ.computeSize());
      }
      i = paramInt;
      if (this.MXa != null) {
        i = paramInt + g.a.a.a.nh(6, this.MXa.computeSize());
      }
      paramInt = i;
      if (this.LZW != null) {
        paramInt = i + g.a.a.a.nh(7, this.LZW.computeSize());
      }
      i = paramInt;
      if (this.LZX != null) {
        i = paramInt + g.a.a.a.nh(8, this.LZX.computeSize());
      }
      paramInt = i;
      if (this.MXb != null) {
        paramInt = i + g.a.a.a.nh(9, this.MXb.computeSize());
      }
      i = paramInt;
      if (this.MXc != null) {
        i = paramInt + g.a.a.a.nh(10, this.MXc.computeSize());
      }
      paramInt = i;
      if (this.MXd != null) {
        paramInt = i + g.a.a.a.nh(11, this.MXd.computeSize());
      }
      i = paramInt;
      if (this.LZV != null) {
        i = paramInt + g.a.a.a.nh(12, this.LZV.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(13, this.MRg) + g.a.a.b.b.a.bu(14, this.MXe);
      paramInt = i;
      if (this.MXf != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.MXf);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.MWZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.MXa == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.LZW == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.LZX == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.MXb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.MXc == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.MXd == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.LZV == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dwz localdwz = (dwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localdwz.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localdwz.MWY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localdwz.jeW = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.MWZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.MXa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.LZW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.LZX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.MXb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.MXc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.MXd = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdwz.LZV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localdwz.MRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localdwz.MXe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32445);
          return 0;
        }
        localdwz.MXf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwz
 * JD-Core Version:    0.7.0.1
 */