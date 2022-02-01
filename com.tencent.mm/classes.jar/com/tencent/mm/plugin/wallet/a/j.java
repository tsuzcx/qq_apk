package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public String zOA;
  public String zOB;
  public b zOG;
  public String zOH;
  public double zOI;
  public LinkedList<f> zOJ;
  public double zOq;
  public LinkedList<t> zOs;
  public double zOx;
  public double zOy;
  public int zOz;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.zOJ = new LinkedList();
    this.zOs = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zOH != null) {
        paramVarArgs.d(1, this.zOH);
      }
      paramVarArgs.e(2, this.zOI);
      paramVarArgs.e(3, this.zOq);
      paramVarArgs.e(4, 8, this.zOJ);
      paramVarArgs.e(5, 8, this.zOs);
      paramVarArgs.e(6, this.zOx);
      paramVarArgs.e(7, this.zOy);
      paramVarArgs.aR(8, this.zOz);
      if (this.zOA != null) {
        paramVarArgs.d(9, this.zOA);
      }
      if (this.zOB != null) {
        paramVarArgs.d(10, this.zOB);
      }
      if (this.zOG != null) {
        paramVarArgs.c(11, this.zOG);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zOH == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.b.b.a.e(1, this.zOH) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 8) + (f.a.a.b.b.a.fY(3) + 8) + f.a.a.a.c(4, 8, this.zOJ) + f.a.a.a.c(5, 8, this.zOs) + (f.a.a.b.b.a.fY(6) + 8) + (f.a.a.b.b.a.fY(7) + 8) + f.a.a.b.b.a.bA(8, this.zOz);
      paramInt = i;
      if (this.zOA != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.zOA);
      }
      i = paramInt;
      if (this.zOB != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.zOB);
      }
      paramInt = i;
      if (this.zOG != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.zOG);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.zOJ.clear();
        this.zOs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localj.zOH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.zOI = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.zOq = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.zOJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.zOs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.zOx = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.zOy = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.zOz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.zOA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.zOB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.zOG = ((f.a.a.a.a)localObject1).KhF.fMu();
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