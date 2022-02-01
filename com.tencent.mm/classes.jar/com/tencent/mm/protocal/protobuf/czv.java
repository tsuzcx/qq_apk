package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czv
  extends cwj
{
  public LinkedList<ejp> FQQ;
  public boolean GUq;
  public int HFW;
  public ejg HJp;
  public int HJq;
  public com.tencent.mm.bw.b HJr;
  public String HJs;
  public int Hzh;
  public String Title;
  public int nID;
  public int nJA;
  public int nJd;
  public int qkQ;
  
  public czv()
  {
    AppMethodBeat.i(117922);
    this.FQQ = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJd);
      paramVarArgs.aS(3, this.nJA);
      paramVarArgs.aS(4, this.Hzh);
      paramVarArgs.aS(5, this.nID);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.HJp != null)
      {
        paramVarArgs.lJ(7, this.HJp.computeSize());
        this.HJp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.FQQ);
      paramVarArgs.aS(9, this.HFW);
      paramVarArgs.aS(10, this.HJq);
      paramVarArgs.bC(11, this.GUq);
      if (this.HJr != null) {
        paramVarArgs.c(12, this.HJr);
      }
      paramVarArgs.aS(13, this.qkQ);
      if (this.HJs != null) {
        paramVarArgs.d(14, this.HJs);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJd) + f.a.a.b.b.a.bz(3, this.nJA) + f.a.a.b.b.a.bz(4, this.Hzh) + f.a.a.b.b.a.bz(5, this.nID);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt;
      if (this.HJp != null) {
        i = paramInt + f.a.a.a.lI(7, this.HJp.computeSize());
      }
      i = i + f.a.a.a.c(8, 8, this.FQQ) + f.a.a.b.b.a.bz(9, this.HFW) + f.a.a.b.b.a.bz(10, this.HJq) + f.a.a.b.b.a.amF(11);
      paramInt = i;
      if (this.HJr != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.HJr);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.qkQ);
      paramInt = i;
      if (this.HJs != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HJs);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FQQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czv localczv = (czv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
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
            localczv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localczv.nJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localczv.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localczv.Hzh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localczv.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localczv.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczv.HJp = ((ejg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczv.FQQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localczv.HFW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localczv.HJq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localczv.GUq = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localczv.HJr = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localczv.qkQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117923);
          return 0;
        }
        localczv.HJs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czv
 * JD-Core Version:    0.7.0.1
 */