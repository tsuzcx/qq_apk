package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ol
  extends dop
{
  public LinkedList<String> KUr;
  public String KUs;
  public double KUt;
  public double KUu;
  public String ProductID;
  public int Scene;
  
  public ol()
  {
    AppMethodBeat.i(124427);
    this.KUr = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
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
      paramVarArgs.e(3, 1, this.KUr);
      paramVarArgs.aM(4, this.Scene);
      if (this.KUs != null) {
        paramVarArgs.e(5, this.KUs);
      }
      paramVarArgs.e(6, this.KUt);
      paramVarArgs.e(7, this.KUu);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.ProductID);
      }
      i = i + g.a.a.a.c(3, 1, this.KUr) + g.a.a.b.b.a.bu(4, this.Scene);
      paramInt = i;
      if (this.KUs != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KUs);
      }
      i = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(124428);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ol localol = (ol)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
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
            localol.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localol.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localol.KUr.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localol.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localol.KUs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localol.KUt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(124428);
          return 0;
        }
        localol.KUu = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */