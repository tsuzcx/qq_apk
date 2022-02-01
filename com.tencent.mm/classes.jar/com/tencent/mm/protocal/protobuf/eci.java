package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eci
  extends com.tencent.mm.bw.a
{
  public String LOY;
  public String LPa;
  public boolean LPb = false;
  public eih Mhd;
  public eih Mhe;
  public String Mhf;
  public String Mhg;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mhd != null)
      {
        paramVarArgs.ni(1, this.Mhd.computeSize());
        this.Mhd.writeFields(paramVarArgs);
      }
      if (this.Mhe != null)
      {
        paramVarArgs.ni(2, this.Mhe.computeSize());
        this.Mhe.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(3, this.LPb);
      if (this.LOY != null) {
        paramVarArgs.e(4, this.LOY);
      }
      paramVarArgs.aM(5, this.flags);
      if (this.LPa != null) {
        paramVarArgs.e(6, this.LPa);
      }
      if (this.Mhf != null) {
        paramVarArgs.e(7, this.Mhf);
      }
      if (this.Mhg != null) {
        paramVarArgs.e(8, this.Mhg);
      }
      paramVarArgs.bb(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mhd == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.a.nh(1, this.Mhd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mhe != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mhe.computeSize());
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.LOY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LOY);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.flags);
      paramInt = i;
      if (this.LPa != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LPa);
      }
      i = paramInt;
      if (this.Mhf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mhf);
      }
      paramInt = i;
      if (this.Mhg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mhg);
      }
      i = g.a.a.b.b.a.r(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eci localeci = (eci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeci.Mhd = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeci.Mhe = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localeci.LPb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localeci.LOY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localeci.flags = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localeci.LPa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localeci.Mhf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localeci.Mhg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localeci.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eci
 * JD-Core Version:    0.7.0.1
 */