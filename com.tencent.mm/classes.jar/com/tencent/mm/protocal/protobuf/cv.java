package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public cxn FNG;
  public cxn FNH;
  public cxn FNI;
  public int FNJ;
  public SKBuiltinBuffer_t FNK;
  public String FNL;
  public String FNM;
  public int FNN;
  public int nJb;
  public int urJ;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.xri);
      if (this.FNG != null)
      {
        paramVarArgs.lJ(2, this.FNG.computeSize());
        this.FNG.writeFields(paramVarArgs);
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(3, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.urJ);
      if (this.FNI != null)
      {
        paramVarArgs.lJ(5, this.FNI.computeSize());
        this.FNI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.nJb);
      paramVarArgs.aS(7, this.FNJ);
      if (this.FNK != null)
      {
        paramVarArgs.lJ(8, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.CreateTime);
      if (this.FNL != null) {
        paramVarArgs.d(10, this.FNL);
      }
      if (this.FNM != null) {
        paramVarArgs.d(11, this.FNM);
      }
      paramVarArgs.aZ(12, this.xrk);
      paramVarArgs.aS(13, this.FNN);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xri) + 0;
      paramInt = i;
      if (this.FNG != null) {
        paramInt = i + f.a.a.a.lI(2, this.FNG.computeSize());
      }
      i = paramInt;
      if (this.FNH != null) {
        i = paramInt + f.a.a.a.lI(3, this.FNH.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.urJ);
      paramInt = i;
      if (this.FNI != null) {
        paramInt = i + f.a.a.a.lI(5, this.FNI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.nJb) + f.a.a.b.b.a.bz(7, this.FNJ);
      paramInt = i;
      if (this.FNK != null) {
        paramInt = i + f.a.a.a.lI(8, this.FNK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.CreateTime);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FNL);
      }
      i = paramInt;
      if (this.FNM != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FNM);
      }
      paramInt = f.a.a.b.b.a.p(12, this.xrk);
      int j = f.a.a.b.b.a.bz(13, this.FNN);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cv localcv = (cv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localcv.xri = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.FNG = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.FNH = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localcv.urJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.FNI = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localcv.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localcv.FNJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.FNK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localcv.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localcv.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localcv.FNM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localcv.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(133143);
        return 0;
      }
      localcv.FNN = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */