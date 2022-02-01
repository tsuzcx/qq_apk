package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddv
  extends cwj
{
  public SKBuiltinBuffer_t GVB;
  public SKBuiltinBuffer_t GVC;
  public SKBuiltinBuffer_t GVD;
  public int HFW;
  public int HLp;
  public SKBuiltinBuffer_t HLq;
  public SKBuiltinBuffer_t HLr;
  public SKBuiltinBuffer_t HLs;
  public SKBuiltinBuffer_t HLt;
  public SKBuiltinBuffer_t HLu;
  public int HLv;
  public String HLw;
  public int ijY;
  public float ika;
  
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
      if (this.HLq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HLr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GVD == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HLs == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HLt == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.HLu == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.GVB == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ijY);
      paramVarArgs.aS(3, this.HLp);
      paramVarArgs.y(4, this.ika);
      if (this.HLq != null)
      {
        paramVarArgs.lJ(5, this.HLq.computeSize());
        this.HLq.writeFields(paramVarArgs);
      }
      if (this.HLr != null)
      {
        paramVarArgs.lJ(6, this.HLr.computeSize());
        this.HLr.writeFields(paramVarArgs);
      }
      if (this.GVC != null)
      {
        paramVarArgs.lJ(7, this.GVC.computeSize());
        this.GVC.writeFields(paramVarArgs);
      }
      if (this.GVD != null)
      {
        paramVarArgs.lJ(8, this.GVD.computeSize());
        this.GVD.writeFields(paramVarArgs);
      }
      if (this.HLs != null)
      {
        paramVarArgs.lJ(9, this.HLs.computeSize());
        this.HLs.writeFields(paramVarArgs);
      }
      if (this.HLt != null)
      {
        paramVarArgs.lJ(10, this.HLt.computeSize());
        this.HLt.writeFields(paramVarArgs);
      }
      if (this.HLu != null)
      {
        paramVarArgs.lJ(11, this.HLu.computeSize());
        this.HLu.writeFields(paramVarArgs);
      }
      if (this.GVB != null)
      {
        paramVarArgs.lJ(12, this.GVB.computeSize());
        this.GVB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.HFW);
      paramVarArgs.aS(14, this.HLv);
      if (this.HLw != null) {
        paramVarArgs.d(15, this.HLw);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ijY) + f.a.a.b.b.a.bz(3, this.HLp) + f.a.a.b.b.a.amE(4);
      paramInt = i;
      if (this.HLq != null) {
        paramInt = i + f.a.a.a.lI(5, this.HLq.computeSize());
      }
      i = paramInt;
      if (this.HLr != null) {
        i = paramInt + f.a.a.a.lI(6, this.HLr.computeSize());
      }
      paramInt = i;
      if (this.GVC != null) {
        paramInt = i + f.a.a.a.lI(7, this.GVC.computeSize());
      }
      i = paramInt;
      if (this.GVD != null) {
        i = paramInt + f.a.a.a.lI(8, this.GVD.computeSize());
      }
      paramInt = i;
      if (this.HLs != null) {
        paramInt = i + f.a.a.a.lI(9, this.HLs.computeSize());
      }
      i = paramInt;
      if (this.HLt != null) {
        i = paramInt + f.a.a.a.lI(10, this.HLt.computeSize());
      }
      paramInt = i;
      if (this.HLu != null) {
        paramInt = i + f.a.a.a.lI(11, this.HLu.computeSize());
      }
      i = paramInt;
      if (this.GVB != null) {
        i = paramInt + f.a.a.a.lI(12, this.GVB.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(13, this.HFW) + f.a.a.b.b.a.bz(14, this.HLv);
      paramInt = i;
      if (this.HLw != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.HLw);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HLq == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HLr == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GVD == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HLs == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HLt == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.HLu == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.GVB == null)
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
        ddv localddv = (ddv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localddv.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localddv.HLp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localddv.ika = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.HLq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.HLr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.GVC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.GVD = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.HLs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.HLt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.HLu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddv.GVB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localddv.HFW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localddv.HLv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32445);
          return 0;
        }
        localddv.HLw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddv
 * JD-Core Version:    0.7.0.1
 */