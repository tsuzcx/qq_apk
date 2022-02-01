package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eha
  extends dyy
{
  public eae Tjo;
  public eae Tjp;
  public eae Tjq;
  public int Udm;
  public String UjA;
  public int Ujt;
  public eae Uju;
  public eae Ujv;
  public eae Ujw;
  public eae Ujx;
  public eae Ujy;
  public int Ujz;
  public int lVs;
  public float lVu;
  
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
      if (this.Uju == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongName");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ujv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongSinger");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Tjp == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbum");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Tjq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ujw == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ujx == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Ujy == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongWebUrl");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.Tjo == null)
      {
        paramVarArgs = new b("Not all required fields were included: SongLyric");
        AppMethodBeat.o(32445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lVs);
      paramVarArgs.aY(3, this.Ujt);
      paramVarArgs.i(4, this.lVu);
      if (this.Uju != null)
      {
        paramVarArgs.oE(5, this.Uju.computeSize());
        this.Uju.writeFields(paramVarArgs);
      }
      if (this.Ujv != null)
      {
        paramVarArgs.oE(6, this.Ujv.computeSize());
        this.Ujv.writeFields(paramVarArgs);
      }
      if (this.Tjp != null)
      {
        paramVarArgs.oE(7, this.Tjp.computeSize());
        this.Tjp.writeFields(paramVarArgs);
      }
      if (this.Tjq != null)
      {
        paramVarArgs.oE(8, this.Tjq.computeSize());
        this.Tjq.writeFields(paramVarArgs);
      }
      if (this.Ujw != null)
      {
        paramVarArgs.oE(9, this.Ujw.computeSize());
        this.Ujw.writeFields(paramVarArgs);
      }
      if (this.Ujx != null)
      {
        paramVarArgs.oE(10, this.Ujx.computeSize());
        this.Ujx.writeFields(paramVarArgs);
      }
      if (this.Ujy != null)
      {
        paramVarArgs.oE(11, this.Ujy.computeSize());
        this.Ujy.writeFields(paramVarArgs);
      }
      if (this.Tjo != null)
      {
        paramVarArgs.oE(12, this.Tjo.computeSize());
        this.Tjo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.Udm);
      paramVarArgs.aY(14, this.Ujz);
      if (this.UjA != null) {
        paramVarArgs.f(15, this.UjA);
      }
      AppMethodBeat.o(32445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2112;
      }
    }
    label2112:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lVs) + g.a.a.b.b.a.bM(3, this.Ujt) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.Uju != null) {
        paramInt = i + g.a.a.a.oD(5, this.Uju.computeSize());
      }
      i = paramInt;
      if (this.Ujv != null) {
        i = paramInt + g.a.a.a.oD(6, this.Ujv.computeSize());
      }
      paramInt = i;
      if (this.Tjp != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tjp.computeSize());
      }
      i = paramInt;
      if (this.Tjq != null) {
        i = paramInt + g.a.a.a.oD(8, this.Tjq.computeSize());
      }
      paramInt = i;
      if (this.Ujw != null) {
        paramInt = i + g.a.a.a.oD(9, this.Ujw.computeSize());
      }
      i = paramInt;
      if (this.Ujx != null) {
        i = paramInt + g.a.a.a.oD(10, this.Ujx.computeSize());
      }
      paramInt = i;
      if (this.Ujy != null) {
        paramInt = i + g.a.a.a.oD(11, this.Ujy.computeSize());
      }
      i = paramInt;
      if (this.Tjo != null) {
        i = paramInt + g.a.a.a.oD(12, this.Tjo.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(13, this.Udm) + g.a.a.b.b.a.bM(14, this.Ujz);
      paramInt = i;
      if (this.UjA != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.UjA);
      }
      AppMethodBeat.o(32445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Uju == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongName");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ujv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongSinger");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Tjp == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbum");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Tjq == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongAlbumUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ujw == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWifiUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ujx == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWapLinkUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Ujy == null)
        {
          paramVarArgs = new b("Not all required fields were included: SongWebUrl");
          AppMethodBeat.o(32445);
          throw paramVarArgs;
        }
        if (this.Tjo == null)
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
        eha localeha = (eha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32445);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localeha.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 2: 
          localeha.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32445);
          return 0;
        case 3: 
          localeha.Ujt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32445);
          return 0;
        case 4: 
          localeha.lVu = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(32445);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Uju = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Ujv = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Tjp = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Tjq = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Ujw = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Ujx = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Ujy = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeha.Tjo = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32445);
          return 0;
        case 13: 
          localeha.Udm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32445);
          return 0;
        case 14: 
          localeha.Ujz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32445);
          return 0;
        }
        localeha.UjA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32445);
        return 0;
      }
      AppMethodBeat.o(32445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eha
 * JD-Core Version:    0.7.0.1
 */