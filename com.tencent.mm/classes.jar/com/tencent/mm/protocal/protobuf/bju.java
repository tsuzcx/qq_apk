package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bju
  extends com.tencent.mm.bw.a
{
  public LinkedList<bjv> EJd;
  public LinkedList<bjv> EZl;
  public int count;
  public String dnh;
  public long duration;
  public String qoi;
  public long startTime;
  
  public bju()
  {
    AppMethodBeat.i(122512);
    this.qoi = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.dnh = "";
    this.EJd = new LinkedList();
    this.count = 1;
    this.EZl = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qoi != null) {
        paramVarArgs.d(1, this.qoi);
      }
      paramVarArgs.aO(2, this.startTime);
      paramVarArgs.aO(3, this.duration);
      if (this.dnh != null) {
        paramVarArgs.d(4, this.dnh);
      }
      paramVarArgs.e(5, 8, this.EJd);
      paramVarArgs.aR(6, this.count);
      paramVarArgs.e(7, 8, this.EZl);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qoi == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.b.b.a.e(1, this.qoi) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.dnh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dnh);
      }
      i = f.a.a.a.c(5, 8, this.EJd);
      int j = f.a.a.b.b.a.bx(6, this.count);
      int k = f.a.a.a.c(7, 8, this.EZl);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJd.clear();
        this.EZl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bju localbju = (bju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localbju.qoi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localbju.startTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localbju.duration = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localbju.dnh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbju.EJd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localbju.count = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122513);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbju.EZl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bju
 * JD-Core Version:    0.7.0.1
 */