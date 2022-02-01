package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class drd
  extends com.tencent.mm.bw.a
{
  public b MTL;
  public b MTM;
  public b MTN;
  public b MTO;
  public dre MTP;
  public int lHz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.lHz);
      if (this.MTL != null) {
        paramVarArgs.c(2, this.MTL);
      }
      if (this.MTM != null) {
        paramVarArgs.c(3, this.MTM);
      }
      if (this.MTN != null) {
        paramVarArgs.c(4, this.MTN);
      }
      if (this.MTO != null) {
        paramVarArgs.c(5, this.MTO);
      }
      if (this.MTP != null)
      {
        paramVarArgs.ni(6, this.MTP.computeSize());
        this.MTP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(225296);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.lHz) + 0;
      paramInt = i;
      if (this.MTL != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MTL);
      }
      i = paramInt;
      if (this.MTM != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.MTM);
      }
      paramInt = i;
      if (this.MTN != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.MTN);
      }
      i = paramInt;
      if (this.MTO != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.MTO);
      }
      paramInt = i;
      if (this.MTP != null) {
        paramInt = i + g.a.a.a.nh(6, this.MTP.computeSize());
      }
      AppMethodBeat.o(225296);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(225296);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      drd localdrd = (drd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(225296);
        return -1;
      case 1: 
        localdrd.lHz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225296);
        return 0;
      case 2: 
        localdrd.MTL = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225296);
        return 0;
      case 3: 
        localdrd.MTM = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225296);
        return 0;
      case 4: 
        localdrd.MTN = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225296);
        return 0;
      case 5: 
        localdrd.MTO = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225296);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dre();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dre)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdrd.MTP = ((dre)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(225296);
      return 0;
    }
    AppMethodBeat.o(225296);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drd
 * JD-Core Version:    0.7.0.1
 */