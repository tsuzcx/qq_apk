package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class brc
  extends bly
{
  public int euw;
  public float euy;
  public int tHR;
  public bmk tHS;
  public bmk tHT;
  public bmk tHU;
  public bmk tHV;
  public bmk tHW;
  public int tHX;
  public int tHY;
  public String tHZ;
  public bmk tfX;
  public bmk tfY;
  public bmk tfZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tHS == null) {
        throw new b("Not all required fields were included: SongName");
      }
      if (this.tHT == null) {
        throw new b("Not all required fields were included: SongSinger");
      }
      if (this.tfY == null) {
        throw new b("Not all required fields were included: SongAlbum");
      }
      if (this.tfZ == null) {
        throw new b("Not all required fields were included: SongAlbumUrl");
      }
      if (this.tHU == null) {
        throw new b("Not all required fields were included: SongWifiUrl");
      }
      if (this.tHV == null) {
        throw new b("Not all required fields were included: SongWapLinkUrl");
      }
      if (this.tHW == null) {
        throw new b("Not all required fields were included: SongWebUrl");
      }
      if (this.tfX == null) {
        throw new b("Not all required fields were included: SongLyric");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.euw);
      paramVarArgs.gB(3, this.tHR);
      paramVarArgs.m(4, this.euy);
      if (this.tHS != null)
      {
        paramVarArgs.gD(5, this.tHS.btq());
        this.tHS.a(paramVarArgs);
      }
      if (this.tHT != null)
      {
        paramVarArgs.gD(6, this.tHT.btq());
        this.tHT.a(paramVarArgs);
      }
      if (this.tfY != null)
      {
        paramVarArgs.gD(7, this.tfY.btq());
        this.tfY.a(paramVarArgs);
      }
      if (this.tfZ != null)
      {
        paramVarArgs.gD(8, this.tfZ.btq());
        this.tfZ.a(paramVarArgs);
      }
      if (this.tHU != null)
      {
        paramVarArgs.gD(9, this.tHU.btq());
        this.tHU.a(paramVarArgs);
      }
      if (this.tHV != null)
      {
        paramVarArgs.gD(10, this.tHV.btq());
        this.tHV.a(paramVarArgs);
      }
      if (this.tHW != null)
      {
        paramVarArgs.gD(11, this.tHW.btq());
        this.tHW.a(paramVarArgs);
      }
      if (this.tfX != null)
      {
        paramVarArgs.gD(12, this.tfX.btq());
        this.tfX.a(paramVarArgs);
      }
      paramVarArgs.gB(13, this.tHX);
      paramVarArgs.gB(14, this.tHY);
      if (this.tHZ != null) {
        paramVarArgs.d(15, this.tHZ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label2015;
      }
    }
    label2015:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.euw) + d.a.a.a.gy(3, this.tHR) + (d.a.a.b.b.a.dQ(4) + 4);
      paramInt = i;
      if (this.tHS != null) {
        paramInt = i + d.a.a.a.gA(5, this.tHS.btq());
      }
      i = paramInt;
      if (this.tHT != null) {
        i = paramInt + d.a.a.a.gA(6, this.tHT.btq());
      }
      paramInt = i;
      if (this.tfY != null) {
        paramInt = i + d.a.a.a.gA(7, this.tfY.btq());
      }
      i = paramInt;
      if (this.tfZ != null) {
        i = paramInt + d.a.a.a.gA(8, this.tfZ.btq());
      }
      paramInt = i;
      if (this.tHU != null) {
        paramInt = i + d.a.a.a.gA(9, this.tHU.btq());
      }
      i = paramInt;
      if (this.tHV != null) {
        i = paramInt + d.a.a.a.gA(10, this.tHV.btq());
      }
      paramInt = i;
      if (this.tHW != null) {
        paramInt = i + d.a.a.a.gA(11, this.tHW.btq());
      }
      i = paramInt;
      if (this.tfX != null) {
        i = paramInt + d.a.a.a.gA(12, this.tfX.btq());
      }
      i = i + d.a.a.a.gy(13, this.tHX) + d.a.a.a.gy(14, this.tHY);
      paramInt = i;
      if (this.tHZ != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.tHZ);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tHS == null) {
          throw new b("Not all required fields were included: SongName");
        }
        if (this.tHT == null) {
          throw new b("Not all required fields were included: SongSinger");
        }
        if (this.tfY == null) {
          throw new b("Not all required fields were included: SongAlbum");
        }
        if (this.tfZ == null) {
          throw new b("Not all required fields were included: SongAlbumUrl");
        }
        if (this.tHU == null) {
          throw new b("Not all required fields were included: SongWifiUrl");
        }
        if (this.tHV == null) {
          throw new b("Not all required fields were included: SongWapLinkUrl");
        }
        if (this.tHW == null) {
          throw new b("Not all required fields were included: SongWebUrl");
        }
        if (this.tfX != null) {
          break;
        }
        throw new b("Not all required fields were included: SongLyric");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        brc localbrc = (brc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbrc.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbrc.tHR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbrc.euy = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tHS = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tHT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tfY = ((bmk)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tfZ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tHU = ((bmk)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tHV = ((bmk)localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tHW = ((bmk)localObject1);
            paramInt += 1;
          }
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbrc.tfX = ((bmk)localObject1);
            paramInt += 1;
          }
        case 13: 
          localbrc.tHX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localbrc.tHY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbrc.tHZ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brc
 * JD-Core Version:    0.7.0.1
 */