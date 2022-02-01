package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class del
  extends dop
{
  public int APa;
  public String MJA;
  public int MJB;
  public String MJz;
  public String ProductID;
  public String xNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      if (this.MJz != null) {
        paramVarArgs.e(3, this.MJz);
      }
      if (this.MJA != null) {
        paramVarArgs.e(4, this.MJA);
      }
      paramVarArgs.aM(5, this.APa);
      if (this.xNU != null) {
        paramVarArgs.e(7, this.xNU);
      }
      paramVarArgs.aM(8, this.MJB);
      AppMethodBeat.o(91630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ProductID);
      }
      i = paramInt;
      if (this.MJz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MJz);
      }
      paramInt = i;
      if (this.MJA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MJA);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.APa);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xNU);
      }
      i = g.a.a.b.b.a.bu(8, this.MJB);
      AppMethodBeat.o(91630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        del localdel = (del)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91630);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdel.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91630);
          return 0;
        case 2: 
          localdel.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 3: 
          localdel.MJz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 4: 
          localdel.MJA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 5: 
          localdel.APa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91630);
          return 0;
        case 7: 
          localdel.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91630);
          return 0;
        }
        localdel.MJB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91630);
        return 0;
      }
      AppMethodBeat.o(91630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.del
 * JD-Core Version:    0.7.0.1
 */