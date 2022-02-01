package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyl
  extends cvw
{
  public int GqB;
  public int Gxq;
  public long Gxr;
  public String HzT;
  public int IdC;
  public int IdD;
  public ead Idl;
  public ead Idm;
  public long Idp;
  public int Idq;
  public int Idr;
  public LinkedList<ccp> Ids;
  
  public dyl()
  {
    AppMethodBeat.i(115863);
    this.Ids = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      paramVarArgs.aS(3, this.Gxq);
      paramVarArgs.aS(4, this.IdC);
      if (this.Idl != null)
      {
        paramVarArgs.lJ(5, this.Idl.computeSize());
        this.Idl.writeFields(paramVarArgs);
      }
      if (this.Idm != null)
      {
        paramVarArgs.lJ(6, this.Idm.computeSize());
        this.Idm.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(7, this.Gxr);
      paramVarArgs.aS(8, this.GqB);
      paramVarArgs.aZ(9, this.Idp);
      paramVarArgs.aS(10, this.IdD);
      paramVarArgs.aS(11, this.Idq);
      paramVarArgs.aS(12, this.Idr);
      paramVarArgs.e(13, 8, this.Ids);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Gxq) + f.a.a.b.b.a.bz(4, this.IdC);
      paramInt = i;
      if (this.Idl != null) {
        paramInt = i + f.a.a.a.lI(5, this.Idl.computeSize());
      }
      i = paramInt;
      if (this.Idm != null) {
        i = paramInt + f.a.a.a.lI(6, this.Idm.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(7, this.Gxr);
      int j = f.a.a.b.b.a.bz(8, this.GqB);
      int k = f.a.a.b.b.a.p(9, this.Idp);
      int m = f.a.a.b.b.a.bz(10, this.IdD);
      int n = f.a.a.b.b.a.bz(11, this.Idq);
      int i1 = f.a.a.b.b.a.bz(12, this.Idr);
      int i2 = f.a.a.a.c(13, 8, this.Ids);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ids.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyl localdyl = (dyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localdyl.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localdyl.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localdyl.IdC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ead();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ead)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.Idl = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ead();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ead)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.Idm = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localdyl.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localdyl.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localdyl.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localdyl.IdD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localdyl.Idq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localdyl.Idr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115864);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyl.Ids.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyl
 * JD-Core Version:    0.7.0.1
 */