package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fa
  extends com.tencent.mm.bw.a
{
  public int FPi;
  public String FPj;
  public int FPk;
  public boolean FPl;
  public int FPm;
  public int FPn;
  public int FPo;
  public int FPp;
  public boolean FPq;
  public LinkedList<dof> FPr;
  public String Url;
  public int hFR;
  public String hFS;
  public int xri;
  
  public fa()
  {
    AppMethodBeat.i(6388);
    this.FPi = 600;
    this.hFR = -1;
    this.FPq = false;
    this.FPr = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      if (this.hFS != null) {
        paramVarArgs.d(2, this.hFS);
      }
      paramVarArgs.aS(3, this.FPi);
      if (this.FPj != null) {
        paramVarArgs.d(4, this.FPj);
      }
      paramVarArgs.aS(5, this.FPk);
      paramVarArgs.bC(6, this.FPl);
      paramVarArgs.aS(7, this.FPm);
      paramVarArgs.aS(8, this.FPn);
      paramVarArgs.aS(9, this.xri);
      paramVarArgs.aS(10, this.FPo);
      paramVarArgs.aS(11, this.FPp);
      paramVarArgs.aS(12, this.hFR);
      paramVarArgs.bC(13, this.FPq);
      paramVarArgs.e(14, 8, this.FPr);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hFS);
      }
      i += f.a.a.b.b.a.bz(3, this.FPi);
      paramInt = i;
      if (this.FPj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPj);
      }
      i = f.a.a.b.b.a.bz(5, this.FPk);
      int j = f.a.a.b.b.a.amF(6);
      int k = f.a.a.b.b.a.bz(7, this.FPm);
      int m = f.a.a.b.b.a.bz(8, this.FPn);
      int n = f.a.a.b.b.a.bz(9, this.xri);
      int i1 = f.a.a.b.b.a.bz(10, this.FPo);
      int i2 = f.a.a.b.b.a.bz(11, this.FPp);
      int i3 = f.a.a.b.b.a.bz(12, this.hFR);
      int i4 = f.a.a.b.b.a.amF(13);
      int i5 = f.a.a.a.c(14, 8, this.FPr);
      AppMethodBeat.o(6389);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localfa.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localfa.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localfa.FPi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localfa.FPj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localfa.FPk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localfa.FPl = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localfa.FPm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localfa.FPn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localfa.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localfa.FPo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localfa.FPp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localfa.hFR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localfa.FPq = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dof();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dof)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localfa.FPr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */