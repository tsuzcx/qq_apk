package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxx
  extends com.tencent.mm.bx.a
{
  public ebn LwW;
  public float LwX;
  public LinkedList<Integer> LwY;
  public int audioBitrate;
  public int audioSampleRate;
  public int fps;
  public int gnH;
  public int gnh;
  public int gni;
  public int hbW;
  public int hcj;
  public String oLh;
  public int vNE;
  public int vNF;
  public int videoBitrate;
  
  public dxx()
  {
    AppMethodBeat.i(203587);
    this.LwY = new LinkedList();
    AppMethodBeat.o(203587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203588);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oLh != null) {
        paramVarArgs.d(1, this.oLh);
      }
      paramVarArgs.aR(4, this.vNE);
      paramVarArgs.aR(5, this.vNF);
      if (this.LwW != null)
      {
        paramVarArgs.kX(6, this.LwW.computeSize());
        this.LwW.writeFields(paramVarArgs);
      }
      paramVarArgs.x(7, this.LwX);
      paramVarArgs.aR(8, this.gnh);
      paramVarArgs.aR(9, this.gni);
      paramVarArgs.aR(10, this.videoBitrate);
      paramVarArgs.aR(11, this.fps);
      paramVarArgs.aR(12, this.hbW);
      paramVarArgs.aR(13, this.audioBitrate);
      paramVarArgs.aR(14, this.audioSampleRate);
      paramVarArgs.aR(15, this.gnH);
      paramVarArgs.e(16, 2, this.LwY);
      paramVarArgs.aR(17, this.hcj);
      AppMethodBeat.o(203588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oLh == null) {
        break label1012;
      }
    }
    label1012:
    for (paramInt = f.a.a.b.b.a.e(1, this.oLh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(4, this.vNE) + f.a.a.b.b.a.bA(5, this.vNF);
      paramInt = i;
      if (this.LwW != null) {
        paramInt = i + f.a.a.a.kW(6, this.LwW.computeSize());
      }
      i = f.a.a.b.b.a.fY(7);
      int j = f.a.a.b.b.a.bA(8, this.gnh);
      int k = f.a.a.b.b.a.bA(9, this.gni);
      int m = f.a.a.b.b.a.bA(10, this.videoBitrate);
      int n = f.a.a.b.b.a.bA(11, this.fps);
      int i1 = f.a.a.b.b.a.bA(12, this.hbW);
      int i2 = f.a.a.b.b.a.bA(13, this.audioBitrate);
      int i3 = f.a.a.b.b.a.bA(14, this.audioSampleRate);
      int i4 = f.a.a.b.b.a.bA(15, this.gnH);
      int i5 = f.a.a.a.c(16, 2, this.LwY);
      int i6 = f.a.a.b.b.a.bA(17, this.hcj);
      AppMethodBeat.o(203588);
      return paramInt + (i + 4) + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LwY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203588);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxx localdxx = (dxx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(203588);
          return -1;
        case 1: 
          localdxx.oLh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203588);
          return 0;
        case 4: 
          localdxx.vNE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 5: 
          localdxx.vNF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxx.LwW = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203588);
          return 0;
        case 7: 
          localdxx.LwX = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(203588);
          return 0;
        case 8: 
          localdxx.gnh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 9: 
          localdxx.gni = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 10: 
          localdxx.videoBitrate = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 11: 
          localdxx.fps = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 12: 
          localdxx.hbW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 13: 
          localdxx.audioBitrate = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 14: 
          localdxx.audioSampleRate = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 15: 
          localdxx.gnH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203588);
          return 0;
        case 16: 
          localdxx.LwY.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(203588);
          return 0;
        }
        localdxx.hcj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203588);
        return 0;
      }
      AppMethodBeat.o(203588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxx
 * JD-Core Version:    0.7.0.1
 */