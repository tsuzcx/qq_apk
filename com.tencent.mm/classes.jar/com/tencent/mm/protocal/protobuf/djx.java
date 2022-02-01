package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djx
  extends dop
{
  public String HQc;
  public String HVd;
  public String IaW;
  public String dNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(2, this.dNQ);
      }
      if (this.HQc != null) {
        paramVarArgs.e(3, this.HQc);
      }
      if (this.HVd != null) {
        paramVarArgs.e(4, this.HVd);
      }
      if (this.IaW != null) {
        paramVarArgs.e(5, this.IaW);
      }
      AppMethodBeat.o(174534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNQ);
      }
      i = paramInt;
      if (this.HQc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HQc);
      }
      paramInt = i;
      if (this.HVd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HVd);
      }
      i = paramInt;
      if (this.IaW != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.IaW);
      }
      AppMethodBeat.o(174534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(174534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djx localdjx = (djx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174534);
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
            localdjx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(174534);
          return 0;
        case 2: 
          localdjx.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 3: 
          localdjx.HQc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 4: 
          localdjx.HVd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(174534);
          return 0;
        }
        localdjx.IaW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(174534);
        return 0;
      }
      AppMethodBeat.o(174534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djx
 * JD-Core Version:    0.7.0.1
 */