package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class eaj
  extends cvw
{
  public int GqB;
  public int Gxq;
  public int HPZ;
  public int HQa;
  public int HQb;
  public int HQc;
  public int HQd;
  public LinkedList<Integer> HQe;
  public int HQf;
  public int HQg;
  public LinkedList<Integer> HQh;
  public int HQi;
  public int HQj;
  
  public eaj()
  {
    AppMethodBeat.i(115916);
    this.HQe = new LinkedList();
    this.HQh = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aS(3, this.HPZ);
      paramVarArgs.aS(4, this.GqB);
      paramVarArgs.aS(5, this.HQa);
      paramVarArgs.aS(6, this.HQb);
      paramVarArgs.aS(7, this.HQc);
      paramVarArgs.aS(8, this.HQd);
      paramVarArgs.f(9, 2, this.HQe);
      paramVarArgs.aS(10, this.HQf);
      paramVarArgs.aS(11, this.HQg);
      paramVarArgs.f(12, 2, this.HQh);
      paramVarArgs.aS(13, this.HQi);
      paramVarArgs.aS(14, this.HQj);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.bz(3, this.HPZ);
      int k = f.a.a.b.b.a.bz(4, this.GqB);
      int m = f.a.a.b.b.a.bz(5, this.HQa);
      int n = f.a.a.b.b.a.bz(6, this.HQb);
      int i1 = f.a.a.b.b.a.bz(7, this.HQc);
      int i2 = f.a.a.b.b.a.bz(8, this.HQd);
      int i3 = f.a.a.a.d(9, 2, this.HQe);
      int i4 = f.a.a.b.b.a.bz(10, this.HQf);
      int i5 = f.a.a.b.b.a.bz(11, this.HQg);
      int i6 = f.a.a.a.d(12, 2, this.HQh);
      int i7 = f.a.a.b.b.a.bz(13, this.HQi);
      int i8 = f.a.a.b.b.a.bz(14, this.HQj);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HQe.clear();
        this.HQh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eaj localeaj = (eaj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeaj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localeaj.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localeaj.HPZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localeaj.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localeaj.HQa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localeaj.HQb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localeaj.HQc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localeaj.HQd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localeaj.HQe = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localeaj.HQf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localeaj.HQg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localeaj.HQh = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localeaj.HQi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115917);
          return 0;
        }
        localeaj.HQj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */