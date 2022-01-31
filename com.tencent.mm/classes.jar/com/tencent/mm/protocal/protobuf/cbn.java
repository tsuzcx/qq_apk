package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbn
  extends bvk
{
  public int fKi;
  public float fKk;
  public int xHS;
  public int xMj;
  public SKBuiltinBuffer_t xMk;
  public SKBuiltinBuffer_t xMl;
  public SKBuiltinBuffer_t xMm;
  public SKBuiltinBuffer_t xMn;
  public SKBuiltinBuffer_t xMo;
  public int xMp;
  public String xMq;
  public SKBuiltinBuffer_t xew;
  public SKBuiltinBuffer_t xex;
  public SKBuiltinBuffer_t xey;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28647);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xMk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xMl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xex == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xey == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xMm == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.xew == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(28647);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.fKi);
      paramVarArgs.aO(3, this.xMj);
      paramVarArgs.q(4, this.fKk);
      if (this.xMk != null)
      {
        paramVarArgs.iQ(5, this.xMk.computeSize());
        this.xMk.writeFields(paramVarArgs);
      }
      if (this.xMl != null)
      {
        paramVarArgs.iQ(6, this.xMl.computeSize());
        this.xMl.writeFields(paramVarArgs);
      }
      if (this.xex != null)
      {
        paramVarArgs.iQ(7, this.xex.computeSize());
        this.xex.writeFields(paramVarArgs);
      }
      if (this.xey != null)
      {
        paramVarArgs.iQ(8, this.xey.computeSize());
        this.xey.writeFields(paramVarArgs);
      }
      if (this.xMm != null)
      {
        paramVarArgs.iQ(9, this.xMm.computeSize());
        this.xMm.writeFields(paramVarArgs);
      }
      if (this.xMn != null)
      {
        paramVarArgs.iQ(10, this.xMn.computeSize());
        this.xMn.writeFields(paramVarArgs);
      }
      if (this.xMo != null)
      {
        paramVarArgs.iQ(11, this.xMo.computeSize());
        this.xMo.writeFields(paramVarArgs);
      }
      if (this.xew != null)
      {
        paramVarArgs.iQ(12, this.xew.computeSize());
        this.xew.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(13, this.xHS);
      paramVarArgs.aO(14, this.xMp);
      if (this.xMq != null) {
        paramVarArgs.e(15, this.xMq);
      }
      AppMethodBeat.o(28647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2310;
      }
    }
    label2310:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.fKi) + e.a.a.b.b.a.bl(3, this.xMj) + (e.a.a.b.b.a.eW(4) + 4);
      paramInt = i;
      if (this.xMk != null) {
        paramInt = i + e.a.a.a.iP(5, this.xMk.computeSize());
      }
      i = paramInt;
      if (this.xMl != null) {
        i = paramInt + e.a.a.a.iP(6, this.xMl.computeSize());
      }
      paramInt = i;
      if (this.xex != null) {
        paramInt = i + e.a.a.a.iP(7, this.xex.computeSize());
      }
      i = paramInt;
      if (this.xey != null) {
        i = paramInt + e.a.a.a.iP(8, this.xey.computeSize());
      }
      paramInt = i;
      if (this.xMm != null) {
        paramInt = i + e.a.a.a.iP(9, this.xMm.computeSize());
      }
      i = paramInt;
      if (this.xMn != null) {
        i = paramInt + e.a.a.a.iP(10, this.xMn.computeSize());
      }
      paramInt = i;
      if (this.xMo != null) {
        paramInt = i + e.a.a.a.iP(11, this.xMo.computeSize());
      }
      i = paramInt;
      if (this.xew != null) {
        i = paramInt + e.a.a.a.iP(12, this.xew.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(13, this.xHS) + e.a.a.b.b.a.bl(14, this.xMp);
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.xMq);
      }
      AppMethodBeat.o(28647);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xMk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xMl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xex == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xey == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xMm == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xMn == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xMo == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        if (this.xew == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongLyric");
          AppMethodBeat.o(28647);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28647);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbn localcbn = (cbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28647);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 2: 
          localcbn.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28647);
          return 0;
        case 3: 
          localcbn.xMj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28647);
          return 0;
        case 4: 
          localcbn.fKk = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28647);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xMk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xMl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xex = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xey = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xMm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xMn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xMo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbn.xew = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28647);
          return 0;
        case 13: 
          localcbn.xHS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28647);
          return 0;
        case 14: 
          localcbn.xMp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28647);
          return 0;
        }
        localcbn.xMq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28647);
        return 0;
      }
      AppMethodBeat.o(28647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbn
 * JD-Core Version:    0.7.0.1
 */