package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class asi
  extends cwj
{
  public String GJn;
  public String GJo;
  public int GJp;
  public int GJq;
  public int GJr;
  public amm GJs;
  public int GJt;
  public asw GJu;
  public aly GJv;
  public String GJw;
  public asg GJx;
  public String GJy;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public arc preloadInfo;
  public arv rRJ;
  public int sjJ;
  public asf sjP;
  
  public asi()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.liveObjects = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.GJn != null) {
        paramVarArgs.d(4, this.GJn);
      }
      if (this.GJo != null) {
        paramVarArgs.d(5, this.GJo);
      }
      paramVarArgs.aS(6, this.sjJ);
      paramVarArgs.aS(7, this.GJp);
      paramVarArgs.aS(8, this.GJq);
      paramVarArgs.aS(9, this.GJr);
      if (this.preloadInfo != null)
      {
        paramVarArgs.lJ(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.GJs != null)
      {
        paramVarArgs.lJ(11, this.GJs.computeSize());
        this.GJs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.GJt);
      paramVarArgs.e(13, 8, this.liveObjects);
      if (this.GJu != null)
      {
        paramVarArgs.lJ(14, this.GJu.computeSize());
        this.GJu.writeFields(paramVarArgs);
      }
      if (this.GJv != null)
      {
        paramVarArgs.lJ(15, this.GJv.computeSize());
        this.GJv.writeFields(paramVarArgs);
      }
      if (this.GJw != null) {
        paramVarArgs.d(16, this.GJw);
      }
      if (this.rRJ != null)
      {
        paramVarArgs.lJ(17, this.rRJ.computeSize());
        this.rRJ.writeFields(paramVarArgs);
      }
      if (this.GJx != null)
      {
        paramVarArgs.lJ(18, this.GJx.computeSize());
        this.GJx.writeFields(paramVarArgs);
      }
      if (this.sjP != null)
      {
        paramVarArgs.lJ(19, this.sjP.computeSize());
        this.sjP.writeFields(paramVarArgs);
      }
      if (this.GJy != null) {
        paramVarArgs.d(20, this.GJy);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2258;
      }
    }
    label2258:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.GJn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GJn);
      }
      paramInt = i;
      if (this.GJo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GJo);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.sjJ) + f.a.a.b.b.a.bz(7, this.GJp) + f.a.a.b.b.a.bz(8, this.GJq) + f.a.a.b.b.a.bz(9, this.GJr);
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + f.a.a.a.lI(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.GJs != null) {
        i = paramInt + f.a.a.a.lI(11, this.GJs.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(12, this.GJt) + f.a.a.a.c(13, 8, this.liveObjects);
      paramInt = i;
      if (this.GJu != null) {
        paramInt = i + f.a.a.a.lI(14, this.GJu.computeSize());
      }
      i = paramInt;
      if (this.GJv != null) {
        i = paramInt + f.a.a.a.lI(15, this.GJv.computeSize());
      }
      paramInt = i;
      if (this.GJw != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GJw);
      }
      i = paramInt;
      if (this.rRJ != null) {
        i = paramInt + f.a.a.a.lI(17, this.rRJ.computeSize());
      }
      paramInt = i;
      if (this.GJx != null) {
        paramInt = i + f.a.a.a.lI(18, this.GJx.computeSize());
      }
      i = paramInt;
      if (this.sjP != null) {
        i = paramInt + f.a.a.a.lI(19, this.sjP.computeSize());
      }
      paramInt = i;
      if (this.GJy != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.GJy);
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.liveObjects.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asi localasi = (asi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localasi.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localasi.GJn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localasi.GJo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localasi.sjJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localasi.GJp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localasi.GJq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localasi.GJr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.preloadInfo = ((arc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.GJs = ((amm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localasi.GJt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.liveObjects.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.GJu = ((asw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.GJv = ((aly)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localasi.GJw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.rRJ = ((arv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.GJx = ((asg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasi.sjP = ((asf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        localasi.GJy = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asi
 * JD-Core Version:    0.7.0.1
 */