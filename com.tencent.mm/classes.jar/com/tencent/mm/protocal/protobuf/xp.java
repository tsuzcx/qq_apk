package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xp
  extends dop
{
  public String KBt;
  public String dNI;
  public String qcM;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.KBt != null) {
        paramVarArgs.e(3, this.KBt);
      }
      if (this.qcM != null) {
        paramVarArgs.e(4, this.qcM);
      }
      if (this.signature != null) {
        paramVarArgs.e(5, this.signature);
      }
      AppMethodBeat.o(194541);
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
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.KBt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KBt);
      }
      paramInt = i;
      if (this.qcM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qcM);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.signature);
      }
      AppMethodBeat.o(194541);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        xp localxp = (xp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194541);
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
            localxp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194541);
          return 0;
        case 2: 
          localxp.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194541);
          return 0;
        case 3: 
          localxp.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194541);
          return 0;
        case 4: 
          localxp.qcM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194541);
          return 0;
        }
        localxp.signature = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194541);
        return 0;
      }
      AppMethodBeat.o(194541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xp
 * JD-Core Version:    0.7.0.1
 */