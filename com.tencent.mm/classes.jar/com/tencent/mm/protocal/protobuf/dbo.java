package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dbo
  extends com.tencent.mm.bx.a
{
  public dtr Ddv;
  public long Etc;
  public long Etd;
  public long Ete;
  public long Etf;
  public LinkedList<b> Etg;
  public long begin_time;
  public long duration;
  public String text;
  
  public dbo()
  {
    AppMethodBeat.i(110911);
    this.Etg = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ddv != null)
      {
        paramVarArgs.kX(1, this.Ddv.computeSize());
        this.Ddv.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.begin_time);
      paramVarArgs.aG(3, this.duration);
      if (this.text != null) {
        paramVarArgs.d(4, this.text);
      }
      paramVarArgs.aG(5, this.Etc);
      paramVarArgs.aG(6, this.Etd);
      paramVarArgs.aG(7, this.Ete);
      paramVarArgs.aG(8, this.Etf);
      paramVarArgs.e(9, 6, this.Etg);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddv == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.kW(1, this.Ddv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.begin_time) + f.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.text);
      }
      i = f.a.a.b.b.a.q(5, this.Etc);
      int j = f.a.a.b.b.a.q(6, this.Etd);
      int k = f.a.a.b.b.a.q(7, this.Ete);
      int m = f.a.a.b.b.a.q(8, this.Etf);
      int n = f.a.a.a.c(9, 6, this.Etg);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Etg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbo localdbo = (dbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dtr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.Ddv = ((dtr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localdbo.begin_time = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localdbo.duration = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localdbo.text = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localdbo.Etc = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localdbo.Etd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localdbo.Ete = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localdbo.Etf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110912);
          return 0;
        }
        localdbo.Etg.add(((f.a.a.a.a)localObject1).KhF.fMu());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */