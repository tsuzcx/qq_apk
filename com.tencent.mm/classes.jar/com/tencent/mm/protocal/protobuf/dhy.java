package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhy
  extends cwj
{
  public dge HPk;
  public int Hne;
  public LinkedList<dge> Hnf;
  public long Id;
  public String hFO;
  public int nJA;
  public int xsB;
  public int xsC;
  
  public dhy()
  {
    AppMethodBeat.i(125831);
    this.Hnf = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.HPk == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.hFO != null) {
        paramVarArgs.d(4, this.hFO);
      }
      if (this.HPk != null)
      {
        paramVarArgs.lJ(5, this.HPk.computeSize());
        this.HPk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Hne);
      paramVarArgs.e(7, 8, this.Hnf);
      paramVarArgs.aZ(8, this.Id);
      paramVarArgs.aS(9, this.nJA);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.hFO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFO);
      }
      i = paramInt;
      if (this.HPk != null) {
        i = paramInt + f.a.a.a.lI(5, this.HPk.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Hne);
      int j = f.a.a.a.c(7, 8, this.Hnf);
      int k = f.a.a.b.b.a.p(8, this.Id);
      int m = f.a.a.b.b.a.bz(9, this.nJA);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hnf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.HPk == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhy localdhy = (dhy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localdhy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localdhy.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localdhy.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localdhy.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dge();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dge)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhy.HPk = ((dge)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localdhy.Hne = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dge();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dge)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhy.Hnf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localdhy.Id = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125832);
          return 0;
        }
        localdhy.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhy
 * JD-Core Version:    0.7.0.1
 */