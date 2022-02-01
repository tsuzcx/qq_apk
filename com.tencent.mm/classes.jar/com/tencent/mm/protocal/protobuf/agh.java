package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agh
  extends com.tencent.mm.bw.a
{
  public LinkedList<ja> GrR;
  public int GwA;
  public int GwB;
  public String Gwn;
  public int Gwo;
  public int Gwp;
  public int Gwq;
  public int Gwr;
  public int Gws;
  public dkb Gwt;
  public int Gwu;
  public long Gwv;
  public LinkedList<String> Gww;
  public com.tencent.mm.bw.b Gwx;
  public int Gwy;
  public int Gwz;
  public boolean aXj;
  public long endTime;
  public int hku;
  public String hoZ;
  public boolean hwD;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  public int xOV;
  public boolean xOY;
  public csx xPR;
  
  public agh()
  {
    AppMethodBeat.i(101528);
    this.GrR = new LinkedList();
    this.Gww = new LinkedList();
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
      paramVarArgs.aZ(2, this.startTime);
      paramVarArgs.aZ(3, this.endTime);
      if (this.Gwn != null) {
        paramVarArgs.d(4, this.Gwn);
      }
      paramVarArgs.aS(5, this.hku);
      if (this.thumbPath != null) {
        paramVarArgs.d(6, this.thumbPath);
      }
      if (this.hoZ != null) {
        paramVarArgs.d(7, this.hoZ);
      }
      paramVarArgs.aS(8, this.xOV);
      if (this.musicUrl != null) {
        paramVarArgs.d(9, this.musicUrl);
      }
      paramVarArgs.bC(10, this.aXj);
      paramVarArgs.bC(11, this.xOY);
      paramVarArgs.aS(12, this.Gwo);
      paramVarArgs.aS(13, this.Gwp);
      paramVarArgs.aS(14, this.Gwq);
      paramVarArgs.aS(15, this.Gwr);
      paramVarArgs.e(16, 8, this.GrR);
      paramVarArgs.aZ(17, this.timeStamp);
      paramVarArgs.aS(18, this.Gws);
      paramVarArgs.bC(19, this.hwD);
      if (this.xPR != null)
      {
        paramVarArgs.lJ(20, this.xPR.computeSize());
        this.xPR.writeFields(paramVarArgs);
      }
      if (this.Gwt != null)
      {
        paramVarArgs.lJ(21, this.Gwt.computeSize());
        this.Gwt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.Gwu);
      paramVarArgs.aZ(23, this.Gwv);
      paramVarArgs.e(24, 1, this.Gww);
      if (this.Gwx != null) {
        paramVarArgs.c(25, this.Gwx);
      }
      paramVarArgs.aS(26, this.Gwy);
      paramVarArgs.aS(27, this.Gwz);
      paramVarArgs.aS(28, this.GwA);
      paramVarArgs.aS(29, this.GwB);
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1974;
      }
    }
    label1974:
    for (paramInt = f.a.a.b.b.a.e(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.endTime);
      paramInt = i;
      if (this.Gwn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gwn);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.hku);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbPath);
      }
      i = paramInt;
      if (this.hoZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hoZ);
      }
      i += f.a.a.b.b.a.bz(8, this.xOV);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.musicUrl);
      }
      i = paramInt + f.a.a.b.b.a.amF(10) + f.a.a.b.b.a.amF(11) + f.a.a.b.b.a.bz(12, this.Gwo) + f.a.a.b.b.a.bz(13, this.Gwp) + f.a.a.b.b.a.bz(14, this.Gwq) + f.a.a.b.b.a.bz(15, this.Gwr) + f.a.a.a.c(16, 8, this.GrR) + f.a.a.b.b.a.p(17, this.timeStamp) + f.a.a.b.b.a.bz(18, this.Gws) + f.a.a.b.b.a.amF(19);
      paramInt = i;
      if (this.xPR != null) {
        paramInt = i + f.a.a.a.lI(20, this.xPR.computeSize());
      }
      i = paramInt;
      if (this.Gwt != null) {
        i = paramInt + f.a.a.a.lI(21, this.Gwt.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(22, this.Gwu) + f.a.a.b.b.a.p(23, this.Gwv) + f.a.a.a.c(24, 1, this.Gww);
      paramInt = i;
      if (this.Gwx != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.Gwx);
      }
      i = f.a.a.b.b.a.bz(26, this.Gwy);
      int j = f.a.a.b.b.a.bz(27, this.Gwz);
      int k = f.a.a.b.b.a.bz(28, this.GwA);
      int m = f.a.a.b.b.a.bz(29, this.GwB);
      AppMethodBeat.o(101529);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GrR.clear();
        this.Gww.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        agh localagh = (agh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localagh.videoPath = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localagh.startTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localagh.endTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localagh.Gwn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localagh.hku = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localagh.thumbPath = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localagh.hoZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localagh.xOV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localagh.musicUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localagh.aXj = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localagh.xOY = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localagh.Gwo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localagh.Gwp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localagh.Gwq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localagh.Gwr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagh.GrR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localagh.timeStamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localagh.Gws = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localagh.hwD = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagh.xPR = ((csx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagh.Gwt = ((dkb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localagh.Gwu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localagh.Gwv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localagh.Gww.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(101529);
          return 0;
        case 25: 
          localagh.Gwx = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(101529);
          return 0;
        case 26: 
          localagh.Gwy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 27: 
          localagh.Gwz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 28: 
          localagh.GwA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101529);
          return 0;
        }
        localagh.GwB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */