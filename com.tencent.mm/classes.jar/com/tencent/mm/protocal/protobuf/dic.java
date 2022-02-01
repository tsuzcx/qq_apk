package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dic
  extends cwj
{
  public LinkedList<SnsObject> FUY;
  public int HNB;
  public dhk HND;
  public int HNY;
  public LinkedList<die> HNZ;
  public String HNx;
  public int HOS;
  public int HPp;
  public long HPq;
  public long HPr;
  public String HPs;
  public boolean HPt;
  public dia HhA;
  public int Hor;
  
  public dic()
  {
    AppMethodBeat.i(125836);
    this.FUY = new LinkedList();
    this.HNZ = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      paramVarArgs.aS(3, this.Hor);
      paramVarArgs.e(4, 8, this.FUY);
      paramVarArgs.aS(5, this.HPp);
      if (this.HhA != null)
      {
        paramVarArgs.lJ(6, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.HOS);
      paramVarArgs.aS(8, this.HNB);
      if (this.HND != null)
      {
        paramVarArgs.lJ(9, this.HND.computeSize());
        this.HND.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(10, this.HPq);
      paramVarArgs.aZ(11, this.HPr);
      if (this.HPs != null) {
        paramVarArgs.d(12, this.HPs);
      }
      paramVarArgs.aS(13, this.HNY);
      paramVarArgs.e(14, 8, this.HNZ);
      paramVarArgs.bC(15, this.HPt);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1430;
      }
    }
    label1430:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Hor) + f.a.a.a.c(4, 8, this.FUY) + f.a.a.b.b.a.bz(5, this.HPp);
      paramInt = i;
      if (this.HhA != null) {
        paramInt = i + f.a.a.a.lI(6, this.HhA.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HOS) + f.a.a.b.b.a.bz(8, this.HNB);
      paramInt = i;
      if (this.HND != null) {
        paramInt = i + f.a.a.a.lI(9, this.HND.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.HPq) + f.a.a.b.b.a.p(11, this.HPr);
      paramInt = i;
      if (this.HPs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HPs);
      }
      i = f.a.a.b.b.a.bz(13, this.HNY);
      int j = f.a.a.a.c(14, 8, this.HNZ);
      int k = f.a.a.b.b.a.amF(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUY.clear();
        this.HNZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localdic.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localdic.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localdic.Hor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.FUY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localdic.HPp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localdic.HOS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localdic.HNB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.HND = ((dhk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localdic.HPq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localdic.HPr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localdic.HPs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localdic.HNY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new die();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((die)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.HNZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localdic.HPt = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */