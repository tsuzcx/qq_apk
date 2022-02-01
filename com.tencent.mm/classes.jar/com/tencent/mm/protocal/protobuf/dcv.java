package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcv
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String KTg;
  public int MHY;
  public LinkedList<dco> MHo;
  public String MIb;
  public String MIc;
  public int MId;
  
  public dcv()
  {
    AppMethodBeat.i(209800);
    this.MHo = new LinkedList();
    AppMethodBeat.o(209800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MIb != null) {
        paramVarArgs.e(1, this.MIb);
      }
      if (this.KTg != null) {
        paramVarArgs.e(2, this.KTg);
      }
      paramVarArgs.aM(3, this.CreateTime);
      paramVarArgs.e(4, 8, this.MHo);
      if (this.MIc != null) {
        paramVarArgs.e(5, this.MIc);
      }
      paramVarArgs.aM(6, this.MHY);
      paramVarArgs.aM(7, this.MId);
      AppMethodBeat.o(209801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MIb == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.b.b.a.f(1, this.MIb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KTg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KTg);
      }
      i = i + g.a.a.b.b.a.bu(3, this.CreateTime) + g.a.a.a.c(4, 8, this.MHo);
      paramInt = i;
      if (this.MIc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MIc);
      }
      i = g.a.a.b.b.a.bu(6, this.MHY);
      int j = g.a.a.b.b.a.bu(7, this.MId);
      AppMethodBeat.o(209801);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MHo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcv localdcv = (dcv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209801);
          return -1;
        case 1: 
          localdcv.MIb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209801);
          return 0;
        case 2: 
          localdcv.KTg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209801);
          return 0;
        case 3: 
          localdcv.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209801);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dco();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dco)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdcv.MHo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209801);
          return 0;
        case 5: 
          localdcv.MIc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209801);
          return 0;
        case 6: 
          localdcv.MHY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209801);
          return 0;
        }
        localdcv.MId = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209801);
        return 0;
      }
      AppMethodBeat.o(209801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcv
 * JD-Core Version:    0.7.0.1
 */