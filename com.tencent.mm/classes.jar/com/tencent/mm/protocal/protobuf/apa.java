package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class apa
  extends cvw
{
  public b GFN;
  public alw GGl;
  public long GGm;
  public dpd GGn;
  public String dBe;
  public float dBu;
  public int dvm;
  public float dzE;
  public int eRi;
  public arv rRJ;
  public int sXu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GGl != null)
      {
        paramVarArgs.lJ(2, this.GGl.computeSize());
        this.GGl.writeFields(paramVarArgs);
      }
      if (this.GFN != null) {
        paramVarArgs.c(3, this.GFN);
      }
      paramVarArgs.aS(4, this.sXu);
      if (this.dBe != null) {
        paramVarArgs.d(5, this.dBe);
      }
      paramVarArgs.y(6, this.dBu);
      paramVarArgs.y(7, this.dzE);
      paramVarArgs.aZ(8, this.GGm);
      paramVarArgs.aS(9, this.dvm);
      if (this.GGn != null)
      {
        paramVarArgs.lJ(10, this.GGn.computeSize());
        this.GGn.writeFields(paramVarArgs);
      }
      if (this.rRJ != null)
      {
        paramVarArgs.lJ(11, this.rRJ.computeSize());
        this.rRJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.eRi);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1164;
      }
    }
    label1164:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GGl != null) {
        paramInt = i + f.a.a.a.lI(2, this.GGl.computeSize());
      }
      i = paramInt;
      if (this.GFN != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GFN);
      }
      i += f.a.a.b.b.a.bz(4, this.sXu);
      paramInt = i;
      if (this.dBe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dBe);
      }
      i = paramInt + f.a.a.b.b.a.amE(6) + f.a.a.b.b.a.amE(7) + f.a.a.b.b.a.p(8, this.GGm) + f.a.a.b.b.a.bz(9, this.dvm);
      paramInt = i;
      if (this.GGn != null) {
        paramInt = i + f.a.a.a.lI(10, this.GGn.computeSize());
      }
      i = paramInt;
      if (this.rRJ != null) {
        i = paramInt + f.a.a.a.lI(11, this.rRJ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(12, this.eRi);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apa localapa = (apa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
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
            localapa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapa.GGl = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localapa.GFN = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localapa.sXu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localapa.dBe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localapa.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localapa.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localapa.GGm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localapa.dvm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapa.GGn = ((dpd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapa.rRJ = ((arv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        }
        localapa.eRi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apa
 * JD-Core Version:    0.7.0.1
 */