package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class any
  extends com.tencent.mm.bx.a
{
  public long CFi;
  public long CFj;
  public boolean CFl;
  public cqb Dpb;
  public long Dpc;
  public long Dpd;
  public long Dpe;
  public long Dpf;
  public long Dpg;
  public long uin;
  public LinkedList<bpb> zcd;
  
  public any()
  {
    AppMethodBeat.i(110895);
    this.zcd = new LinkedList();
    this.Dpc = 10L;
    this.Dpd = 0L;
    this.CFl = false;
    this.Dpe = 0L;
    this.Dpf = 0L;
    this.Dpg = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CFi);
      paramVarArgs.aG(2, this.uin);
      paramVarArgs.aG(3, this.CFj);
      paramVarArgs.e(4, 8, this.zcd);
      if (this.Dpb != null)
      {
        paramVarArgs.kX(5, this.Dpb.computeSize());
        this.Dpb.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.Dpc);
      paramVarArgs.aG(7, this.Dpd);
      paramVarArgs.bg(8, this.CFl);
      paramVarArgs.aG(9, this.Dpe);
      paramVarArgs.aG(10, this.Dpf);
      paramVarArgs.aG(11, this.Dpg);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.CFi) + 0 + f.a.a.b.b.a.q(2, this.uin) + f.a.a.b.b.a.q(3, this.CFj) + f.a.a.a.c(4, 8, this.zcd);
      paramInt = i;
      if (this.Dpb != null) {
        paramInt = i + f.a.a.a.kW(5, this.Dpb.computeSize());
      }
      i = f.a.a.b.b.a.q(6, this.Dpc);
      int j = f.a.a.b.b.a.q(7, this.Dpd);
      int k = f.a.a.b.b.a.fY(8);
      int m = f.a.a.b.b.a.q(9, this.Dpe);
      int n = f.a.a.b.b.a.q(10, this.Dpf);
      int i1 = f.a.a.b.b.a.q(11, this.Dpg);
      AppMethodBeat.o(110896);
      return paramInt + i + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zcd.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      any localany = (any)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localany.CFi = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localany.uin = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localany.CFj = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localany.zcd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localany.Dpb = ((cqb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localany.Dpc = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localany.Dpd = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localany.CFl = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localany.Dpe = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localany.Dpf = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110896);
        return 0;
      }
      localany.Dpg = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.any
 * JD-Core Version:    0.7.0.1
 */