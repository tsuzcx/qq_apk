package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eah
  extends cvw
{
  public LinkedList<dio> GSq;
  public double Gax;
  public double Gay;
  public int GqB;
  public int Gxq;
  public long Gxr;
  public long Igi;
  public cxn Igj;
  public cxn Igk;
  public int Igl;
  
  public eah()
  {
    AppMethodBeat.i(115913);
    this.GSq = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Igj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.Igk == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.Igi);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.GqB);
      if (this.Igj != null)
      {
        paramVarArgs.lJ(5, this.Igj.computeSize());
        this.Igj.writeFields(paramVarArgs);
      }
      if (this.Igk != null)
      {
        paramVarArgs.lJ(6, this.Igk.computeSize());
        this.Igk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.Gax);
      paramVarArgs.e(8, this.Gay);
      paramVarArgs.aS(9, this.Gxq);
      paramVarArgs.aS(10, this.Igl);
      paramVarArgs.e(11, 8, this.GSq);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1176;
      }
    }
    label1176:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Igi) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.GqB);
      paramInt = i;
      if (this.Igj != null) {
        paramInt = i + f.a.a.a.lI(5, this.Igj.computeSize());
      }
      i = paramInt;
      if (this.Igk != null) {
        i = paramInt + f.a.a.a.lI(6, this.Igk.computeSize());
      }
      paramInt = f.a.a.b.b.a.amD(7);
      int j = f.a.a.b.b.a.amD(8);
      int k = f.a.a.b.b.a.bz(9, this.Gxq);
      int m = f.a.a.b.b.a.bz(10, this.Igl);
      int n = f.a.a.a.c(11, 8, this.GSq);
      AppMethodBeat.o(115914);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GSq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Igj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.Igk == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eah localeah = (eah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
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
            localeah.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localeah.Igi = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localeah.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localeah.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115914);
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
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeah.Igj = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeah.Igk = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localeah.Gax = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localeah.Gay = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localeah.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localeah.Igl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dio();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeah.GSq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eah
 * JD-Core Version:    0.7.0.1
 */