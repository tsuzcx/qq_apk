package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yp
  extends com.tencent.mm.bw.a
{
  public cnb Eso;
  public float Esp;
  public LinkedList<Integer> Esq;
  public int audioBitrate;
  public int audioSampleRate;
  public int fps;
  public int gNU;
  public int gNV;
  public int gOt;
  public int hCL;
  public int hCy;
  public String poB;
  public int videoBitrate;
  public int wXZ;
  public int wYa;
  
  public yp()
  {
    AppMethodBeat.i(206858);
    this.Esq = new LinkedList();
    AppMethodBeat.o(206858);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.poB != null) {
        paramVarArgs.d(1, this.poB);
      }
      paramVarArgs.aR(4, this.wXZ);
      paramVarArgs.aR(5, this.wYa);
      if (this.Eso != null)
      {
        paramVarArgs.ln(6, this.Eso.computeSize());
        this.Eso.writeFields(paramVarArgs);
      }
      paramVarArgs.x(7, this.Esp);
      paramVarArgs.aR(8, this.gNU);
      paramVarArgs.aR(9, this.gNV);
      paramVarArgs.aR(10, this.videoBitrate);
      paramVarArgs.aR(11, this.fps);
      paramVarArgs.aR(12, this.hCy);
      paramVarArgs.aR(13, this.audioBitrate);
      paramVarArgs.aR(14, this.audioSampleRate);
      paramVarArgs.aR(15, this.gOt);
      paramVarArgs.e(16, 2, this.Esq);
      paramVarArgs.aR(17, this.hCL);
      AppMethodBeat.o(206859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.poB == null) {
        break label1012;
      }
    }
    label1012:
    for (paramInt = f.a.a.b.b.a.e(1, this.poB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(4, this.wXZ) + f.a.a.b.b.a.bx(5, this.wYa);
      paramInt = i;
      if (this.Eso != null) {
        paramInt = i + f.a.a.a.lm(6, this.Eso.computeSize());
      }
      i = f.a.a.b.b.a.fK(7);
      int j = f.a.a.b.b.a.bx(8, this.gNU);
      int k = f.a.a.b.b.a.bx(9, this.gNV);
      int m = f.a.a.b.b.a.bx(10, this.videoBitrate);
      int n = f.a.a.b.b.a.bx(11, this.fps);
      int i1 = f.a.a.b.b.a.bx(12, this.hCy);
      int i2 = f.a.a.b.b.a.bx(13, this.audioBitrate);
      int i3 = f.a.a.b.b.a.bx(14, this.audioSampleRate);
      int i4 = f.a.a.b.b.a.bx(15, this.gOt);
      int i5 = f.a.a.a.c(16, 2, this.Esq);
      int i6 = f.a.a.b.b.a.bx(17, this.hCL);
      AppMethodBeat.o(206859);
      return paramInt + (i + 4) + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Esq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(206859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yp localyp = (yp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(206859);
          return -1;
        case 1: 
          localyp.poB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 4: 
          localyp.wXZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 5: 
          localyp.wYa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyp.Eso = ((cnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206859);
          return 0;
        case 7: 
          localyp.Esp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(206859);
          return 0;
        case 8: 
          localyp.gNU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 9: 
          localyp.gNV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 10: 
          localyp.videoBitrate = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 11: 
          localyp.fps = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 12: 
          localyp.hCy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 13: 
          localyp.audioBitrate = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 14: 
          localyp.audioSampleRate = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 15: 
          localyp.gOt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206859);
          return 0;
        case 16: 
          localyp.Esq.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(206859);
          return 0;
        }
        localyp.hCL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(206859);
        return 0;
      }
      AppMethodBeat.o(206859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yp
 * JD-Core Version:    0.7.0.1
 */