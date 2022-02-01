package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyu
  extends cwj
{
  public LinkedList<dyo> FSU;
  public long Gxr;
  public int HRu;
  public long HSD;
  public com.tencent.mm.bw.b HzM;
  public int Iea;
  public int Ieb;
  public int Iec;
  public LinkedList<dyo> Ied;
  public int uXB;
  public int uXq;
  public int uXw;
  public int uXx;
  
  public dyu()
  {
    AppMethodBeat.i(125499);
    this.FSU = new LinkedList();
    this.Ied = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.HSD);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.e(4, 8, this.FSU);
      paramVarArgs.aS(5, this.HRu);
      paramVarArgs.aS(6, this.uXw);
      paramVarArgs.aS(7, this.uXx);
      paramVarArgs.aS(8, this.uXq);
      paramVarArgs.aS(9, this.uXB);
      paramVarArgs.aS(10, this.Iea);
      paramVarArgs.aS(11, this.Ieb);
      if (this.HzM != null) {
        paramVarArgs.c(12, this.HzM);
      }
      paramVarArgs.aS(13, this.Iec);
      paramVarArgs.e(14, 8, this.Ied);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HSD) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.a.c(4, 8, this.FSU) + f.a.a.b.b.a.bz(5, this.HRu) + f.a.a.b.b.a.bz(6, this.uXw) + f.a.a.b.b.a.bz(7, this.uXx) + f.a.a.b.b.a.bz(8, this.uXq) + f.a.a.b.b.a.bz(9, this.uXB) + f.a.a.b.b.a.bz(10, this.Iea) + f.a.a.b.b.a.bz(11, this.Ieb);
      paramInt = i;
      if (this.HzM != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.HzM);
      }
      i = f.a.a.b.b.a.bz(13, this.Iec);
      int j = f.a.a.a.c(14, 8, this.Ied);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSU.clear();
        this.Ied.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyu localdyu = (dyu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
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
            localdyu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localdyu.HSD = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localdyu.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyu.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localdyu.HRu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localdyu.uXw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localdyu.uXx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localdyu.uXq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localdyu.uXB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localdyu.Iea = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localdyu.Ieb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localdyu.HzM = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localdyu.Iec = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyu.Ied.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyu
 * JD-Core Version:    0.7.0.1
 */