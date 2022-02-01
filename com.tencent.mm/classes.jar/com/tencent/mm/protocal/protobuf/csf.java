package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csf
  extends cld
{
  public SKBuiltinBuffer_t Dxm;
  public SKBuiltinBuffer_t Dxn;
  public SKBuiltinBuffer_t Dxo;
  public int Efh;
  public int Ekh;
  public SKBuiltinBuffer_t Eki;
  public SKBuiltinBuffer_t Ekj;
  public SKBuiltinBuffer_t Ekk;
  public SKBuiltinBuffer_t Ekl;
  public SKBuiltinBuffer_t Ekm;
  public int Ekn;
  public String Eko;
  public int hno;
  public float hnq;
  
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
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ekj == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Dxn == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Dxo == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ekk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ekl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ekm == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Dxm == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hno);
      paramVarArgs.aR(3, this.Ekh);
      paramVarArgs.x(4, this.hnq);
      if (this.Eki != null)
      {
        paramVarArgs.kX(5, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      if (this.Ekj != null)
      {
        paramVarArgs.kX(6, this.Ekj.computeSize());
        this.Ekj.writeFields(paramVarArgs);
      }
      if (this.Dxn != null)
      {
        paramVarArgs.kX(7, this.Dxn.computeSize());
        this.Dxn.writeFields(paramVarArgs);
      }
      if (this.Dxo != null)
      {
        paramVarArgs.kX(8, this.Dxo.computeSize());
        this.Dxo.writeFields(paramVarArgs);
      }
      if (this.Ekk != null)
      {
        paramVarArgs.kX(9, this.Ekk.computeSize());
        this.Ekk.writeFields(paramVarArgs);
      }
      if (this.Ekl != null)
      {
        paramVarArgs.kX(10, this.Ekl.computeSize());
        this.Ekl.writeFields(paramVarArgs);
      }
      if (this.Ekm != null)
      {
        paramVarArgs.kX(11, this.Ekm.computeSize());
        this.Ekm.writeFields(paramVarArgs);
      }
      if (this.Dxm != null)
      {
        paramVarArgs.kX(12, this.Dxm.computeSize());
        this.Dxm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.Efh);
      paramVarArgs.aR(14, this.Ekn);
      if (this.Eko != null) {
        paramVarArgs.d(15, this.Eko);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.hno) + f.a.a.b.b.a.bA(3, this.Ekh) + (f.a.a.b.b.a.fY(4) + 4);
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.kW(5, this.Eki.computeSize());
      }
      i = paramInt;
      if (this.Ekj != null) {
        i = paramInt + f.a.a.a.kW(6, this.Ekj.computeSize());
      }
      paramInt = i;
      if (this.Dxn != null) {
        paramInt = i + f.a.a.a.kW(7, this.Dxn.computeSize());
      }
      i = paramInt;
      if (this.Dxo != null) {
        i = paramInt + f.a.a.a.kW(8, this.Dxo.computeSize());
      }
      paramInt = i;
      if (this.Ekk != null) {
        paramInt = i + f.a.a.a.kW(9, this.Ekk.computeSize());
      }
      i = paramInt;
      if (this.Ekl != null) {
        i = paramInt + f.a.a.a.kW(10, this.Ekl.computeSize());
      }
      paramInt = i;
      if (this.Ekm != null) {
        paramInt = i + f.a.a.a.kW(11, this.Ekm.computeSize());
      }
      i = paramInt;
      if (this.Dxm != null) {
        i = paramInt + f.a.a.a.kW(12, this.Dxm.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(13, this.Efh) + f.a.a.b.b.a.bA(14, this.Ekn);
      paramInt = i;
      if (this.Eko != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Eko);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Eki == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ekj == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Dxn == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Dxo == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ekk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ekl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ekm == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Dxm == null)
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
        csf localcsf = (csf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localcsf.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localcsf.Ekh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localcsf.hnq = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Eki = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Ekj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Dxn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Dxo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Ekk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Ekl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Ekm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsf.Dxm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localcsf.Efh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localcsf.Ekn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32445);
          return 0;
        }
        localcsf.Eko = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */