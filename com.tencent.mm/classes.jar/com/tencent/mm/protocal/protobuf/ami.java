package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ami
  extends com.tencent.mm.bx.a
{
  public int NID;
  public boolean NIG;
  public enw NJF;
  public LinkedList<jy> Znd;
  public String Ztf;
  public int Ztg;
  public int Zth;
  public int Zti;
  public int Ztj;
  public int Ztk;
  public fin Ztl;
  public int Ztm;
  public long Ztn;
  public LinkedList<String> Zto;
  public com.tencent.mm.bx.b Ztp;
  public int Ztq;
  public int Ztr;
  public int Zts;
  public int Ztt;
  public boolean cached;
  public long endTime;
  public String musicUrl;
  public String nBT;
  public boolean nJW;
  public int nxj;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  
  public ami()
  {
    AppMethodBeat.i(101528);
    this.Znd = new LinkedList();
    this.Zto = new LinkedList();
    AppMethodBeat.o(101528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101529);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: videoPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.g(1, this.videoPath);
      }
      paramVarArgs.bv(2, this.startTime);
      paramVarArgs.bv(3, this.endTime);
      if (this.Ztf != null) {
        paramVarArgs.g(4, this.Ztf);
      }
      paramVarArgs.bS(5, this.nxj);
      if (this.thumbPath != null) {
        paramVarArgs.g(6, this.thumbPath);
      }
      if (this.nBT != null) {
        paramVarArgs.g(7, this.nBT);
      }
      paramVarArgs.bS(8, this.NID);
      if (this.musicUrl != null) {
        paramVarArgs.g(9, this.musicUrl);
      }
      paramVarArgs.di(10, this.cached);
      paramVarArgs.di(11, this.NIG);
      paramVarArgs.bS(12, this.Ztg);
      paramVarArgs.bS(13, this.Zth);
      paramVarArgs.bS(14, this.Zti);
      paramVarArgs.bS(15, this.Ztj);
      paramVarArgs.e(16, 8, this.Znd);
      paramVarArgs.bv(17, this.timeStamp);
      paramVarArgs.bS(18, this.Ztk);
      paramVarArgs.di(19, this.nJW);
      if (this.NJF != null)
      {
        paramVarArgs.qD(20, this.NJF.computeSize());
        this.NJF.writeFields(paramVarArgs);
      }
      if (this.Ztl != null)
      {
        paramVarArgs.qD(21, this.Ztl.computeSize());
        this.Ztl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.Ztm);
      paramVarArgs.bv(23, this.Ztn);
      paramVarArgs.e(24, 1, this.Zto);
      if (this.Ztp != null) {
        paramVarArgs.d(25, this.Ztp);
      }
      paramVarArgs.bS(26, this.Ztq);
      paramVarArgs.bS(27, this.Ztr);
      paramVarArgs.bS(28, this.Zts);
      paramVarArgs.bS(29, this.Ztt);
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1908;
      }
    }
    label1908:
    for (paramInt = i.a.a.b.b.a.h(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.startTime) + i.a.a.b.b.a.q(3, this.endTime);
      paramInt = i;
      if (this.Ztf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Ztf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.nxj);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.thumbPath);
      }
      i = paramInt;
      if (this.nBT != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.nBT);
      }
      i += i.a.a.b.b.a.cJ(8, this.NID);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.musicUrl);
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 1) + (i.a.a.b.b.a.ko(11) + 1) + i.a.a.b.b.a.cJ(12, this.Ztg) + i.a.a.b.b.a.cJ(13, this.Zth) + i.a.a.b.b.a.cJ(14, this.Zti) + i.a.a.b.b.a.cJ(15, this.Ztj) + i.a.a.a.c(16, 8, this.Znd) + i.a.a.b.b.a.q(17, this.timeStamp) + i.a.a.b.b.a.cJ(18, this.Ztk) + (i.a.a.b.b.a.ko(19) + 1);
      paramInt = i;
      if (this.NJF != null) {
        paramInt = i + i.a.a.a.qC(20, this.NJF.computeSize());
      }
      i = paramInt;
      if (this.Ztl != null) {
        i = paramInt + i.a.a.a.qC(21, this.Ztl.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(22, this.Ztm) + i.a.a.b.b.a.q(23, this.Ztn) + i.a.a.a.c(24, 1, this.Zto);
      paramInt = i;
      if (this.Ztp != null) {
        paramInt = i + i.a.a.b.b.a.c(25, this.Ztp);
      }
      i = i.a.a.b.b.a.cJ(26, this.Ztq);
      int j = i.a.a.b.b.a.cJ(27, this.Ztr);
      int k = i.a.a.b.b.a.cJ(28, this.Zts);
      int m = i.a.a.b.b.a.cJ(29, this.Ztt);
      AppMethodBeat.o(101529);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Znd.clear();
        this.Zto.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: videoPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ami localami = (ami)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localami.videoPath = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localami.startTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localami.endTime = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localami.Ztf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localami.nxj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localami.thumbPath = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localami.nBT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localami.NID = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localami.musicUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localami.cached = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localami.NIG = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localami.Ztg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localami.Zth = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localami.Zti = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localami.Ztj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jy)localObject2).parseFrom((byte[])localObject1);
            }
            localami.Znd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localami.timeStamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localami.Ztk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localami.nJW = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enw)localObject2).parseFrom((byte[])localObject1);
            }
            localami.NJF = ((enw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fin();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fin)localObject2).parseFrom((byte[])localObject1);
            }
            localami.Ztl = ((fin)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localami.Ztm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localami.Ztn = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localami.Zto.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(101529);
          return 0;
        case 25: 
          localami.Ztp = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(101529);
          return 0;
        case 26: 
          localami.Ztq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 27: 
          localami.Ztr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        case 28: 
          localami.Zts = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101529);
          return 0;
        }
        localami.Ztt = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ami
 * JD-Core Version:    0.7.0.1
 */