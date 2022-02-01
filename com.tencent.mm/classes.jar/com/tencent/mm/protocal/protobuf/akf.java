package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akf
  extends com.tencent.mm.bw.a
{
  public String FUw;
  public akg GBW;
  public String dpP;
  public int duration;
  public int hBV = -1;
  public int hBW;
  public int hBX = 0;
  public int hBY;
  public int hBZ;
  public String hCa;
  public String hFW;
  public String hGe;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hBV);
      paramVarArgs.aS(2, this.hBX);
      paramVarArgs.aS(3, this.videoWidth);
      paramVarArgs.aS(4, this.videoHeight);
      paramVarArgs.aS(5, this.hBW);
      paramVarArgs.aS(6, this.duration);
      if (this.hCa != null) {
        paramVarArgs.d(7, this.hCa);
      }
      if (this.dpP != null) {
        paramVarArgs.d(8, this.dpP);
      }
      if (this.hFW != null) {
        paramVarArgs.d(9, this.hFW);
      }
      paramVarArgs.aS(10, this.hBZ);
      if (this.GBW != null)
      {
        paramVarArgs.lJ(11, this.GBW.computeSize());
        this.GBW.writeFields(paramVarArgs);
      }
      if (this.hGe != null) {
        paramVarArgs.d(12, this.hGe);
      }
      if (this.FUw != null) {
        paramVarArgs.d(13, this.FUw);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(14, this.videoUrl);
      }
      paramVarArgs.aS(15, this.hBY);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.hBV) + 0 + f.a.a.b.b.a.bz(2, this.hBX) + f.a.a.b.b.a.bz(3, this.videoWidth) + f.a.a.b.b.a.bz(4, this.videoHeight) + f.a.a.b.b.a.bz(5, this.hBW) + f.a.a.b.b.a.bz(6, this.duration);
      paramInt = i;
      if (this.hCa != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hCa);
      }
      i = paramInt;
      if (this.dpP != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dpP);
      }
      paramInt = i;
      if (this.hFW != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hFW);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.hBZ);
      paramInt = i;
      if (this.GBW != null) {
        paramInt = i + f.a.a.a.lI(11, this.GBW.computeSize());
      }
      i = paramInt;
      if (this.hGe != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hGe);
      }
      paramInt = i;
      if (this.FUw != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FUw);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.videoUrl);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.hBY);
      AppMethodBeat.o(127467);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akf localakf = (akf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localakf.hBV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localakf.hBX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localakf.videoWidth = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localakf.videoHeight = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localakf.hBW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localakf.duration = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localakf.hCa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localakf.dpP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localakf.hFW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localakf.hBZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakf.GBW = ((akg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localakf.hGe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localakf.FUw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localakf.videoUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localakf.hBY = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */