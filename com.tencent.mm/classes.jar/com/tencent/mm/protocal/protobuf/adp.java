package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adp
  extends com.tencent.mm.bw.a
{
  public LinkedList<it> Esi;
  public String Ewg;
  public int Ewh;
  public int Ewi;
  public int Ewj;
  public int Ewk;
  public int Ewl;
  public ddt Ewm;
  public int Ewn;
  public long Ewo;
  public LinkedList<String> Ewp;
  public com.tencent.mm.bw.b Ewq;
  public boolean aMR;
  public long endTime;
  public int gNK;
  public String gUk;
  public boolean hbH;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  public int wri;
  public boolean wrl;
  public cna wse;
  
  public adp()
  {
    AppMethodBeat.i(101528);
    this.Esi = new LinkedList();
    this.Ewp = new LinkedList();
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
      paramVarArgs.aO(2, this.startTime);
      paramVarArgs.aO(3, this.endTime);
      if (this.Ewg != null) {
        paramVarArgs.d(4, this.Ewg);
      }
      paramVarArgs.aR(5, this.gNK);
      if (this.thumbPath != null) {
        paramVarArgs.d(6, this.thumbPath);
      }
      if (this.gUk != null) {
        paramVarArgs.d(7, this.gUk);
      }
      paramVarArgs.aR(8, this.wri);
      if (this.musicUrl != null) {
        paramVarArgs.d(9, this.musicUrl);
      }
      paramVarArgs.bl(10, this.aMR);
      paramVarArgs.bl(11, this.wrl);
      paramVarArgs.aR(12, this.Ewh);
      paramVarArgs.aR(13, this.Ewi);
      paramVarArgs.aR(14, this.Ewj);
      paramVarArgs.aR(15, this.Ewk);
      paramVarArgs.e(16, 8, this.Esi);
      paramVarArgs.aO(17, this.timeStamp);
      paramVarArgs.aR(18, this.Ewl);
      paramVarArgs.bl(19, this.hbH);
      if (this.wse != null)
      {
        paramVarArgs.ln(20, this.wse.computeSize());
        this.wse.writeFields(paramVarArgs);
      }
      if (this.Ewm != null)
      {
        paramVarArgs.ln(21, this.Ewm.computeSize());
        this.Ewm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.Ewn);
      paramVarArgs.aO(23, this.Ewo);
      paramVarArgs.e(24, 1, this.Ewp);
      if (this.Ewq != null) {
        paramVarArgs.c(25, this.Ewq);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.endTime);
      paramInt = i;
      if (this.Ewg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ewg);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.gNK);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbPath);
      }
      i = paramInt;
      if (this.gUk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gUk);
      }
      i += f.a.a.b.b.a.bx(8, this.wri);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.musicUrl);
      }
      i = paramInt + (f.a.a.b.b.a.fK(10) + 1) + (f.a.a.b.b.a.fK(11) + 1) + f.a.a.b.b.a.bx(12, this.Ewh) + f.a.a.b.b.a.bx(13, this.Ewi) + f.a.a.b.b.a.bx(14, this.Ewj) + f.a.a.b.b.a.bx(15, this.Ewk) + f.a.a.a.c(16, 8, this.Esi) + f.a.a.b.b.a.p(17, this.timeStamp) + f.a.a.b.b.a.bx(18, this.Ewl) + (f.a.a.b.b.a.fK(19) + 1);
      paramInt = i;
      if (this.wse != null) {
        paramInt = i + f.a.a.a.lm(20, this.wse.computeSize());
      }
      i = paramInt;
      if (this.Ewm != null) {
        i = paramInt + f.a.a.a.lm(21, this.Ewm.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(22, this.Ewn) + f.a.a.b.b.a.p(23, this.Ewo) + f.a.a.a.c(24, 1, this.Ewp);
      paramInt = i;
      if (this.Ewq != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.Ewq);
      }
      AppMethodBeat.o(101529);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Esi.clear();
        this.Ewp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        adp localadp = (adp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localadp.videoPath = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localadp.startTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localadp.endTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localadp.Ewg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localadp.gNK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localadp.thumbPath = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localadp.gUk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localadp.wri = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localadp.musicUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localadp.aMR = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localadp.wrl = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localadp.Ewh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localadp.Ewi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localadp.Ewj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localadp.Ewk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new it();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((it)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadp.Esi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localadp.timeStamp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localadp.Ewl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localadp.hbH = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cna();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadp.wse = ((cna)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadp.Ewm = ((ddt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localadp.Ewn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localadp.Ewo = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localadp.Ewp.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(101529);
          return 0;
        }
        localadp.Ewq = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adp
 * JD-Core Version:    0.7.0.1
 */