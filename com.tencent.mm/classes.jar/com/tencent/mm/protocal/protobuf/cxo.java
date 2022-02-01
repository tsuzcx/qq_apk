package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxo
  extends cqk
{
  public SKBuiltinBuffer_t ESI;
  public SKBuiltinBuffer_t ESJ;
  public SKBuiltinBuffer_t ESK;
  public int FCh;
  public int FHf;
  public SKBuiltinBuffer_t FHg;
  public SKBuiltinBuffer_t FHh;
  public SKBuiltinBuffer_t FHi;
  public SKBuiltinBuffer_t FHj;
  public SKBuiltinBuffer_t FHk;
  public int FHl;
  public String FHm;
  public int hNR;
  public float hNT;
  
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
      if (this.FHg == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.FHh == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.ESJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.ESK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.FHi == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.FHj == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.FHk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.ESI == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hNR);
      paramVarArgs.aR(3, this.FHf);
      paramVarArgs.x(4, this.hNT);
      if (this.FHg != null)
      {
        paramVarArgs.ln(5, this.FHg.computeSize());
        this.FHg.writeFields(paramVarArgs);
      }
      if (this.FHh != null)
      {
        paramVarArgs.ln(6, this.FHh.computeSize());
        this.FHh.writeFields(paramVarArgs);
      }
      if (this.ESJ != null)
      {
        paramVarArgs.ln(7, this.ESJ.computeSize());
        this.ESJ.writeFields(paramVarArgs);
      }
      if (this.ESK != null)
      {
        paramVarArgs.ln(8, this.ESK.computeSize());
        this.ESK.writeFields(paramVarArgs);
      }
      if (this.FHi != null)
      {
        paramVarArgs.ln(9, this.FHi.computeSize());
        this.FHi.writeFields(paramVarArgs);
      }
      if (this.FHj != null)
      {
        paramVarArgs.ln(10, this.FHj.computeSize());
        this.FHj.writeFields(paramVarArgs);
      }
      if (this.FHk != null)
      {
        paramVarArgs.ln(11, this.FHk.computeSize());
        this.FHk.writeFields(paramVarArgs);
      }
      if (this.ESI != null)
      {
        paramVarArgs.ln(12, this.ESI.computeSize());
        this.ESI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.FCh);
      paramVarArgs.aR(14, this.FHl);
      if (this.FHm != null) {
        paramVarArgs.d(15, this.FHm);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.hNR) + f.a.a.b.b.a.bx(3, this.FHf) + (f.a.a.b.b.a.fK(4) + 4);
      paramInt = i;
      if (this.FHg != null) {
        paramInt = i + f.a.a.a.lm(5, this.FHg.computeSize());
      }
      i = paramInt;
      if (this.FHh != null) {
        i = paramInt + f.a.a.a.lm(6, this.FHh.computeSize());
      }
      paramInt = i;
      if (this.ESJ != null) {
        paramInt = i + f.a.a.a.lm(7, this.ESJ.computeSize());
      }
      i = paramInt;
      if (this.ESK != null) {
        i = paramInt + f.a.a.a.lm(8, this.ESK.computeSize());
      }
      paramInt = i;
      if (this.FHi != null) {
        paramInt = i + f.a.a.a.lm(9, this.FHi.computeSize());
      }
      i = paramInt;
      if (this.FHj != null) {
        i = paramInt + f.a.a.a.lm(10, this.FHj.computeSize());
      }
      paramInt = i;
      if (this.FHk != null) {
        paramInt = i + f.a.a.a.lm(11, this.FHk.computeSize());
      }
      i = paramInt;
      if (this.ESI != null) {
        i = paramInt + f.a.a.a.lm(12, this.ESI.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(13, this.FCh) + f.a.a.b.b.a.bx(14, this.FHl);
      paramInt = i;
      if (this.FHm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FHm);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.FHg == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.FHh == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.ESJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.ESK == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.FHi == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.FHj == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.FHk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.ESI == null)
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
        cxo localcxo = (cxo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localcxo.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localcxo.FHf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localcxo.hNT = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.FHg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.FHh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.ESJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.ESK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.FHi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.FHj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.FHk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxo.ESI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localcxo.FCh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localcxo.FHl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32445);
          return 0;
        }
        localcxo.FHm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxo
 * JD-Core Version:    0.7.0.1
 */