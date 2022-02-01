package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acq
  extends com.tencent.mm.bx.a
{
  public String DcZ;
  public int Dda;
  public int Ddb;
  public int Ddc;
  public int Ddd;
  public LinkedList<in> Dde;
  public int Ddf;
  public cyh Ddg;
  public int Ddh;
  public long Ddi;
  public LinkedList<String> Ddj;
  public com.tencent.mm.bx.b Ddk;
  public boolean aMb;
  public long endTime;
  public boolean gBl;
  public int gmX;
  public String gtC;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public boolean viC;
  public String videoPath;
  public int viz;
  public chx vjt;
  
  public acq()
  {
    AppMethodBeat.i(101528);
    this.Dde = new LinkedList();
    this.Ddj = new LinkedList();
    AppMethodBeat.o(101528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: videoPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.d(1, this.videoPath);
      }
      paramVarArgs.aG(2, this.startTime);
      paramVarArgs.aG(3, this.endTime);
      if (this.DcZ != null) {
        paramVarArgs.d(4, this.DcZ);
      }
      paramVarArgs.aR(5, this.gmX);
      if (this.thumbPath != null) {
        paramVarArgs.d(6, this.thumbPath);
      }
      if (this.gtC != null) {
        paramVarArgs.d(7, this.gtC);
      }
      paramVarArgs.aR(8, this.viz);
      if (this.musicUrl != null) {
        paramVarArgs.d(9, this.musicUrl);
      }
      paramVarArgs.bg(10, this.aMb);
      paramVarArgs.bg(11, this.viC);
      paramVarArgs.aR(12, this.Dda);
      paramVarArgs.aR(13, this.Ddb);
      paramVarArgs.aR(14, this.Ddc);
      paramVarArgs.aR(15, this.Ddd);
      paramVarArgs.e(16, 8, this.Dde);
      paramVarArgs.aG(17, this.timeStamp);
      paramVarArgs.aR(18, this.Ddf);
      paramVarArgs.bg(19, this.gBl);
      if (this.vjt != null)
      {
        paramVarArgs.kX(20, this.vjt.computeSize());
        this.vjt.writeFields(paramVarArgs);
      }
      if (this.Ddg != null)
      {
        paramVarArgs.kX(21, this.Ddg.computeSize());
        this.Ddg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.Ddh);
      paramVarArgs.aG(23, this.Ddi);
      paramVarArgs.e(24, 1, this.Ddj);
      if (this.Ddk != null) {
        paramVarArgs.c(25, this.Ddk);
      }
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1790;
      }
    }
    label1790:
    for (paramInt = f.a.a.b.b.a.e(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.startTime) + f.a.a.b.b.a.q(3, this.endTime);
      paramInt = i;
      if (this.DcZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DcZ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.gmX);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbPath);
      }
      i = paramInt;
      if (this.gtC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gtC);
      }
      i += f.a.a.b.b.a.bA(8, this.viz);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.musicUrl);
      }
      i = paramInt + (f.a.a.b.b.a.fY(10) + 1) + (f.a.a.b.b.a.fY(11) + 1) + f.a.a.b.b.a.bA(12, this.Dda) + f.a.a.b.b.a.bA(13, this.Ddb) + f.a.a.b.b.a.bA(14, this.Ddc) + f.a.a.b.b.a.bA(15, this.Ddd) + f.a.a.a.c(16, 8, this.Dde) + f.a.a.b.b.a.q(17, this.timeStamp) + f.a.a.b.b.a.bA(18, this.Ddf) + (f.a.a.b.b.a.fY(19) + 1);
      paramInt = i;
      if (this.vjt != null) {
        paramInt = i + f.a.a.a.kW(20, this.vjt.computeSize());
      }
      i = paramInt;
      if (this.Ddg != null) {
        i = paramInt + f.a.a.a.kW(21, this.Ddg.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(22, this.Ddh) + f.a.a.b.b.a.q(23, this.Ddi) + f.a.a.a.c(24, 1, this.Ddj);
      paramInt = i;
      if (this.Ddk != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.Ddk);
      }
      AppMethodBeat.o(101529);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dde.clear();
        this.Ddj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: videoPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acq localacq = (acq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localacq.videoPath = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localacq.startTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localacq.endTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localacq.DcZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localacq.gmX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localacq.thumbPath = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localacq.gtC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localacq.viz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localacq.musicUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localacq.aMb = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localacq.viC = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localacq.Dda = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localacq.Ddb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localacq.Ddc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localacq.Ddd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new in();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((in)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacq.Dde.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localacq.timeStamp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localacq.Ddf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localacq.gBl = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacq.vjt = ((chx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacq.Ddg = ((cyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localacq.Ddh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localacq.Ddi = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localacq.Ddj.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(101529);
          return 0;
        }
        localacq.Ddk = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */