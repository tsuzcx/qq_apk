package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdf
  extends com.tencent.mm.bw.a
{
  public String MiW;
  public String MiX;
  public agx MiY;
  public agx MiZ;
  public String Mja;
  public String Mjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MiW != null) {
        paramVarArgs.e(1, this.MiW);
      }
      if (this.MiX != null) {
        paramVarArgs.e(2, this.MiX);
      }
      if (this.MiY != null)
      {
        paramVarArgs.ni(3, this.MiY.computeSize());
        this.MiY.writeFields(paramVarArgs);
      }
      if (this.MiZ != null)
      {
        paramVarArgs.ni(4, this.MiZ.computeSize());
        this.MiZ.writeFields(paramVarArgs);
      }
      if (this.Mja != null) {
        paramVarArgs.e(5, this.Mja);
      }
      if (this.Mjb != null) {
        paramVarArgs.e(6, this.Mjb);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MiW == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.b.b.a.f(1, this.MiW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MiX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MiX);
      }
      i = paramInt;
      if (this.MiY != null) {
        i = paramInt + g.a.a.a.nh(3, this.MiY.computeSize());
      }
      paramInt = i;
      if (this.MiZ != null) {
        paramInt = i + g.a.a.a.nh(4, this.MiZ.computeSize());
      }
      i = paramInt;
      if (this.Mja != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mja);
      }
      paramInt = i;
      if (this.Mjb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mjb);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdf localcdf = (cdf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localcdf.MiW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localcdf.MiX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdf.MiY = ((agx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdf.MiZ = ((agx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localcdf.Mja = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localcdf.Mjb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdf
 * JD-Core Version:    0.7.0.1
 */