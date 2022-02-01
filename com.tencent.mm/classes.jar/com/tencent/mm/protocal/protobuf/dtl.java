package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtl
  extends dop
{
  public int KUh;
  public String MVB;
  public int MyL;
  public String UserName;
  public String iAc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.iAc != null) {
        paramVarArgs.e(3, this.iAc);
      }
      paramVarArgs.aM(4, this.MyL);
      paramVarArgs.aM(5, this.KUh);
      if (this.MVB != null) {
        paramVarArgs.e(6, this.MVB);
      }
      AppMethodBeat.o(152688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAc);
      }
      i = i + g.a.a.b.b.a.bu(4, this.MyL) + g.a.a.b.b.a.bu(5, this.KUh);
      paramInt = i;
      if (this.MVB != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MVB);
      }
      AppMethodBeat.o(152688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dtl localdtl = (dtl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152688);
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
            localdtl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152688);
          return 0;
        case 2: 
          localdtl.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 3: 
          localdtl.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 4: 
          localdtl.MyL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152688);
          return 0;
        case 5: 
          localdtl.KUh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152688);
          return 0;
        }
        localdtl.MVB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152688);
        return 0;
      }
      AppMethodBeat.o(152688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtl
 * JD-Core Version:    0.7.0.1
 */