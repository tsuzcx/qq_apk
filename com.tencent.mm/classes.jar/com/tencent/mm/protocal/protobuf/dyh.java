package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyh
  extends cvw
{
  public int GqB;
  public int Gxq;
  public long Gxr;
  public String HzT;
  public int Idk;
  public ead Idl;
  public ead Idm;
  public String Idn;
  public int Ido;
  public long Idp;
  public int Idq;
  public int Idr;
  public LinkedList<ccp> Ids;
  
  public dyh()
  {
    AppMethodBeat.i(115857);
    this.Ids = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      if (this.HzT != null) {
        paramVarArgs.d(4, this.HzT);
      }
      paramVarArgs.aS(5, this.Idk);
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
      if (this.Idn != null) {
        paramVarArgs.d(9, this.Idn);
      }
      paramVarArgs.aS(10, this.Ido);
      paramVarArgs.aZ(11, this.Idp);
      paramVarArgs.aS(12, this.Idq);
      paramVarArgs.aS(13, this.Idr);
      paramVarArgs.e(14, 8, this.Ids);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr);
      paramInt = i;
      if (this.HzT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HzT);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Idk);
      paramInt = i;
      if (this.Idl != null) {
        paramInt = i + f.a.a.a.lI(6, this.Idl.computeSize());
      }
      i = paramInt;
      if (this.Idm != null) {
        i = paramInt + f.a.a.a.lI(7, this.Idm.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.GqB);
      paramInt = i;
      if (this.Idn != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Idn);
      }
      i = f.a.a.b.b.a.bz(10, this.Ido);
      int j = f.a.a.b.b.a.p(11, this.Idp);
      int k = f.a.a.b.b.a.bz(12, this.Idq);
      int m = f.a.a.b.b.a.bz(13, this.Idr);
      int n = f.a.a.a.c(14, 8, this.Ids);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
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
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyh localdyh = (dyh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localdyh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localdyh.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localdyh.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localdyh.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localdyh.Idk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
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
            localdyh.Idl = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
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
            localdyh.Idm = ((ead)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localdyh.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localdyh.Idn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localdyh.Ido = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localdyh.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localdyh.Idq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localdyh.Idr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115858);
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
          localdyh.Ids.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyh
 * JD-Core Version:    0.7.0.1
 */