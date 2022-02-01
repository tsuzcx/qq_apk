package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aio
  extends com.tencent.mm.bw.a
{
  public int BOX;
  public dlg BPU;
  public boolean BPa;
  public LinkedList<jn> Lna;
  public String LrT;
  public int LrU;
  public int LrV;
  public int LrW;
  public int LrX;
  public int LrY;
  public edo LrZ;
  public int Lsa;
  public long Lsb;
  public LinkedList<String> Lsc;
  public com.tencent.mm.bw.b Lsd;
  public int Lse;
  public int Lsf;
  public int Lsg;
  public int Lsh;
  public boolean aXa;
  public long endTime;
  public int idq;
  public String iiv;
  public boolean iqf;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  
  public aio()
  {
    AppMethodBeat.i(101528);
    this.Lna = new LinkedList();
    this.Lsc = new LinkedList();
    AppMethodBeat.o(101528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: videoPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.e(1, this.videoPath);
      }
      paramVarArgs.bb(2, this.startTime);
      paramVarArgs.bb(3, this.endTime);
      if (this.LrT != null) {
        paramVarArgs.e(4, this.LrT);
      }
      paramVarArgs.aM(5, this.idq);
      if (this.thumbPath != null) {
        paramVarArgs.e(6, this.thumbPath);
      }
      if (this.iiv != null) {
        paramVarArgs.e(7, this.iiv);
      }
      paramVarArgs.aM(8, this.BOX);
      if (this.musicUrl != null) {
        paramVarArgs.e(9, this.musicUrl);
      }
      paramVarArgs.cc(10, this.aXa);
      paramVarArgs.cc(11, this.BPa);
      paramVarArgs.aM(12, this.LrU);
      paramVarArgs.aM(13, this.LrV);
      paramVarArgs.aM(14, this.LrW);
      paramVarArgs.aM(15, this.LrX);
      paramVarArgs.e(16, 8, this.Lna);
      paramVarArgs.bb(17, this.timeStamp);
      paramVarArgs.aM(18, this.LrY);
      paramVarArgs.cc(19, this.iqf);
      if (this.BPU != null)
      {
        paramVarArgs.ni(20, this.BPU.computeSize());
        this.BPU.writeFields(paramVarArgs);
      }
      if (this.LrZ != null)
      {
        paramVarArgs.ni(21, this.LrZ.computeSize());
        this.LrZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(22, this.Lsa);
      paramVarArgs.bb(23, this.Lsb);
      paramVarArgs.e(24, 1, this.Lsc);
      if (this.Lsd != null) {
        paramVarArgs.c(25, this.Lsd);
      }
      paramVarArgs.aM(26, this.Lse);
      paramVarArgs.aM(27, this.Lsf);
      paramVarArgs.aM(28, this.Lsg);
      paramVarArgs.aM(29, this.Lsh);
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1978;
      }
    }
    label1978:
    for (paramInt = g.a.a.b.b.a.f(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.startTime) + g.a.a.b.b.a.r(3, this.endTime);
      paramInt = i;
      if (this.LrT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LrT);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.idq);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.thumbPath);
      }
      i = paramInt;
      if (this.iiv != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iiv);
      }
      i += g.a.a.b.b.a.bu(8, this.BOX);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.musicUrl);
      }
      i = paramInt + (g.a.a.b.b.a.fS(10) + 1) + (g.a.a.b.b.a.fS(11) + 1) + g.a.a.b.b.a.bu(12, this.LrU) + g.a.a.b.b.a.bu(13, this.LrV) + g.a.a.b.b.a.bu(14, this.LrW) + g.a.a.b.b.a.bu(15, this.LrX) + g.a.a.a.c(16, 8, this.Lna) + g.a.a.b.b.a.r(17, this.timeStamp) + g.a.a.b.b.a.bu(18, this.LrY) + (g.a.a.b.b.a.fS(19) + 1);
      paramInt = i;
      if (this.BPU != null) {
        paramInt = i + g.a.a.a.nh(20, this.BPU.computeSize());
      }
      i = paramInt;
      if (this.LrZ != null) {
        i = paramInt + g.a.a.a.nh(21, this.LrZ.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(22, this.Lsa) + g.a.a.b.b.a.r(23, this.Lsb) + g.a.a.a.c(24, 1, this.Lsc);
      paramInt = i;
      if (this.Lsd != null) {
        paramInt = i + g.a.a.b.b.a.b(25, this.Lsd);
      }
      i = g.a.a.b.b.a.bu(26, this.Lse);
      int j = g.a.a.b.b.a.bu(27, this.Lsf);
      int k = g.a.a.b.b.a.bu(28, this.Lsg);
      int m = g.a.a.b.b.a.bu(29, this.Lsh);
      AppMethodBeat.o(101529);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lna.clear();
        this.Lsc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: videoPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aio localaio = (aio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localaio.videoPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localaio.startTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localaio.endTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localaio.LrT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localaio.idq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localaio.thumbPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localaio.iiv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localaio.BOX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localaio.musicUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localaio.aXa = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localaio.BPa = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localaio.LrU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localaio.LrV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localaio.LrW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localaio.LrX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaio.Lna.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localaio.timeStamp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localaio.LrY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localaio.iqf = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaio.BPU = ((dlg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaio.LrZ = ((edo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localaio.Lsa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localaio.Lsb = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localaio.Lsc.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(101529);
          return 0;
        case 25: 
          localaio.Lsd = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(101529);
          return 0;
        case 26: 
          localaio.Lse = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 27: 
          localaio.Lsf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        case 28: 
          localaio.Lsg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101529);
          return 0;
        }
        localaio.Lsh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */