package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chf
  extends com.tencent.mm.bv.a
{
  public boolean arq;
  public int eRn;
  public String eXm;
  public long endTime;
  public boolean fbp;
  public String musicUrl;
  public chj sPS;
  public long startTime;
  public int swp;
  public boolean sws;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  public String xRY;
  public int xRZ;
  public int xSa;
  public int xSb;
  public int xSc;
  public LinkedList<hp> xSd;
  public int xSe;
  public che xSf;
  public int xSg;
  public long xSh;
  public LinkedList<String> xSi;
  
  public chf()
  {
    AppMethodBeat.i(56513);
    this.xSd = new LinkedList();
    this.xSi = new LinkedList();
    AppMethodBeat.o(56513);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56514);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoPath");
        AppMethodBeat.o(56514);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(56514);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.e(1, this.videoPath);
      }
      paramVarArgs.am(2, this.startTime);
      paramVarArgs.am(3, this.endTime);
      if (this.xRY != null) {
        paramVarArgs.e(4, this.xRY);
      }
      paramVarArgs.aO(5, this.eRn);
      if (this.thumbPath != null) {
        paramVarArgs.e(6, this.thumbPath);
      }
      if (this.eXm != null) {
        paramVarArgs.e(7, this.eXm);
      }
      paramVarArgs.aO(8, this.swp);
      if (this.musicUrl != null) {
        paramVarArgs.e(9, this.musicUrl);
      }
      paramVarArgs.aS(10, this.arq);
      paramVarArgs.aS(11, this.sws);
      paramVarArgs.aO(12, this.xRZ);
      paramVarArgs.aO(13, this.xSa);
      paramVarArgs.aO(14, this.xSb);
      paramVarArgs.aO(15, this.xSc);
      paramVarArgs.e(16, 8, this.xSd);
      paramVarArgs.am(17, this.timeStamp);
      paramVarArgs.aO(18, this.xSe);
      paramVarArgs.aS(19, this.fbp);
      if (this.sPS != null)
      {
        paramVarArgs.iQ(20, this.sPS.computeSize());
        this.sPS.writeFields(paramVarArgs);
      }
      if (this.xSf != null)
      {
        paramVarArgs.iQ(21, this.xSf.computeSize());
        this.xSf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(22, this.xSg);
      paramVarArgs.am(23, this.xSh);
      paramVarArgs.e(24, 1, this.xSi);
      AppMethodBeat.o(56514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1734;
      }
    }
    label1734:
    for (paramInt = e.a.a.b.b.a.f(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.startTime) + e.a.a.b.b.a.p(3, this.endTime);
      paramInt = i;
      if (this.xRY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xRY);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.eRn);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.thumbPath);
      }
      i = paramInt;
      if (this.eXm != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.eXm);
      }
      i += e.a.a.b.b.a.bl(8, this.swp);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.musicUrl);
      }
      i = paramInt + (e.a.a.b.b.a.eW(10) + 1) + (e.a.a.b.b.a.eW(11) + 1) + e.a.a.b.b.a.bl(12, this.xRZ) + e.a.a.b.b.a.bl(13, this.xSa) + e.a.a.b.b.a.bl(14, this.xSb) + e.a.a.b.b.a.bl(15, this.xSc) + e.a.a.a.c(16, 8, this.xSd) + e.a.a.b.b.a.p(17, this.timeStamp) + e.a.a.b.b.a.bl(18, this.xSe) + (e.a.a.b.b.a.eW(19) + 1);
      paramInt = i;
      if (this.sPS != null) {
        paramInt = i + e.a.a.a.iP(20, this.sPS.computeSize());
      }
      i = paramInt;
      if (this.xSf != null) {
        i = paramInt + e.a.a.a.iP(21, this.xSf.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(22, this.xSg);
      int j = e.a.a.b.b.a.p(23, this.xSh);
      int k = e.a.a.a.c(24, 1, this.xSi);
      AppMethodBeat.o(56514);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xSd.clear();
        this.xSi.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoPath");
          AppMethodBeat.o(56514);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(56514);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56514);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chf localchf = (chf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56514);
          return -1;
        case 1: 
          localchf.videoPath = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56514);
          return 0;
        case 2: 
          localchf.startTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56514);
          return 0;
        case 3: 
          localchf.endTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56514);
          return 0;
        case 4: 
          localchf.xRY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56514);
          return 0;
        case 5: 
          localchf.eRn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 6: 
          localchf.thumbPath = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56514);
          return 0;
        case 7: 
          localchf.eXm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56514);
          return 0;
        case 8: 
          localchf.swp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 9: 
          localchf.musicUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56514);
          return 0;
        case 10: 
          localchf.arq = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56514);
          return 0;
        case 11: 
          localchf.sws = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56514);
          return 0;
        case 12: 
          localchf.xRZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 13: 
          localchf.xSa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 14: 
          localchf.xSb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 15: 
          localchf.xSc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchf.xSd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56514);
          return 0;
        case 17: 
          localchf.timeStamp = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56514);
          return 0;
        case 18: 
          localchf.xSe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 19: 
          localchf.fbp = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56514);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchf.sPS = ((chj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56514);
          return 0;
        case 21: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new che();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchf.xSf = ((che)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56514);
          return 0;
        case 22: 
          localchf.xSg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56514);
          return 0;
        case 23: 
          localchf.xSh = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56514);
          return 0;
        }
        localchf.xSi.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(56514);
        return 0;
      }
      AppMethodBeat.o(56514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chf
 * JD-Core Version:    0.7.0.1
 */