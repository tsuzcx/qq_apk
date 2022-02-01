package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public double BgK;
  public LinkedList<t> BgM;
  public double BgR;
  public double BgS;
  public int BgT;
  public String BgU;
  public String BgV;
  public b Bha;
  public String Bhb;
  public double Bhc;
  public LinkedList<f> Bhd;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.Bhd = new LinkedList();
    this.BgM = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Bhb != null) {
        paramVarArgs.d(1, this.Bhb);
      }
      paramVarArgs.e(2, this.Bhc);
      paramVarArgs.e(3, this.BgK);
      paramVarArgs.e(4, 8, this.Bhd);
      paramVarArgs.e(5, 8, this.BgM);
      paramVarArgs.e(6, this.BgR);
      paramVarArgs.e(7, this.BgS);
      paramVarArgs.aR(8, this.BgT);
      if (this.BgU != null) {
        paramVarArgs.d(9, this.BgU);
      }
      if (this.BgV != null) {
        paramVarArgs.d(10, this.BgV);
      }
      if (this.Bha != null) {
        paramVarArgs.c(11, this.Bha);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bhb == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.b.b.a.e(1, this.Bhb) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 8) + (f.a.a.b.b.a.fK(3) + 8) + f.a.a.a.c(4, 8, this.Bhd) + f.a.a.a.c(5, 8, this.BgM) + (f.a.a.b.b.a.fK(6) + 8) + (f.a.a.b.b.a.fK(7) + 8) + f.a.a.b.b.a.bx(8, this.BgT);
      paramInt = i;
      if (this.BgU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.BgU);
      }
      i = paramInt;
      if (this.BgV != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.BgV);
      }
      paramInt = i;
      if (this.Bha != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.Bha);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Bhd.clear();
        this.BgM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91297);
          return -1;
        case 1: 
          localj.Bhb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.Bhc = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.BgK = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.Bhd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.BgM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.BgR = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.BgS = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.BgT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.BgU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.BgV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.Bha = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */