package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpk
  extends dop
{
  public int CreateTime;
  public String KIz;
  public int MSH;
  public int MSI;
  public int MSJ;
  public long MSK;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KIz != null) {
        paramVarArgs.e(2, this.KIz);
      }
      paramVarArgs.aM(3, this.MSH);
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(5, this.MSI);
      if (this.xNH != null) {
        paramVarArgs.e(6, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(7, this.xNG);
      }
      paramVarArgs.aM(8, this.MSJ);
      paramVarArgs.bb(9, this.MSK);
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KIz != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KIz);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MSH) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MSI);
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.xNG);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.MSJ);
      int j = g.a.a.b.b.a.r(9, this.MSK);
      AppMethodBeat.o(32415);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpk localdpk = (dpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localdpk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localdpk.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localdpk.MSH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localdpk.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localdpk.MSI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localdpk.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localdpk.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localdpk.MSJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32415);
          return 0;
        }
        localdpk.MSK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpk
 * JD-Core Version:    0.7.0.1
 */