package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzp
  extends cvw
{
  public int GqB;
  public int Gxq;
  public long Gxr;
  public int HPZ;
  public String HzT;
  public int Hzx;
  public ead Idl;
  public ead Idm;
  public long Idp;
  public int Idq;
  public int Idr;
  public LinkedList<ccp> Ids;
  public int Iel;
  public int Iex;
  public LinkedList<cxn> Iey;
  public int Iez;
  
  public dzp()
  {
    AppMethodBeat.i(115883);
    this.Iey = new LinkedList();
    this.Ids = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Idl == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.Idm == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      paramVarArgs.aS(3, this.Iex);
      paramVarArgs.e(4, 8, this.Iey);
      if (this.Idl != null)
      {
        paramVarArgs.lJ(6, this.Idl.computeSize());
        this.Idl.writeFields(paramVarArgs);
      }
      if (this.Idm != null)
      {
        paramVarArgs.lJ(7, this.Idm.computeSize());
        this.Idm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GqB);
      paramVarArgs.aS(9, this.HPZ);
      paramVarArgs.aS(10, this.Gxq);
      paramVarArgs.aZ(11, this.Gxr);
      paramVarArgs.aS(12, this.Iel);
      paramVarArgs.aZ(13, this.Idp);
      paramVarArgs.aS(14, this.Iez);
      paramVarArgs.aS(15, this.Hzx);
      paramVarArgs.aS(16, this.Idq);
      paramVarArgs.aS(17, this.Idr);
      paramVarArgs.e(18, 8, this.Ids);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1586;
      }
    }
    label1586:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Iex) + f.a.a.a.c(4, 8, this.Iey);
      paramInt = i;
      if (this.Idl != null) {
        paramInt = i + f.a.a.a.lI(6, this.Idl.computeSize());
      }
      i = paramInt;
      if (this.Idm != null) {
        i = paramInt + f.a.a.a.lI(7, this.Idm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(8, this.GqB);
      int j = f.a.a.b.b.a.bz(9, this.HPZ);
      int k = f.a.a.b.b.a.bz(10, this.Gxq);
      int m = f.a.a.b.b.a.p(11, this.Gxr);
      int n = f.a.a.b.b.a.bz(12, this.Iel);
      int i1 = f.a.a.b.b.a.p(13, this.Idp);
      int i2 = f.a.a.b.b.a.bz(14, this.Iez);
      int i3 = f.a.a.b.b.a.bz(15, this.Hzx);
      int i4 = f.a.a.b.b.a.bz(16, this.Idq);
      int i5 = f.a.a.b.b.a.bz(17, this.Idr);
      int i6 = f.a.a.a.c(18, 8, this.Ids);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iey.clear();
        this.Ids.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Idl == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.Idm == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzp localdzp = (dzp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
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
            localdzp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localdzp.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localdzp.Iex = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzp.Iey.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localdzp.Idl = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ead();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ead)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzp.Idm = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localdzp.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localdzp.HPZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localdzp.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localdzp.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localdzp.Iel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localdzp.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localdzp.Iez = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localdzp.Hzx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localdzp.Idq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localdzp.Idr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115884);
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
          localdzp.Ids.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */