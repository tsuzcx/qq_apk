package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ddo
  extends dop
{
  public String KDQ;
  public String KDR;
  public b LFp;
  public String content;
  public long hyH;
  public int ybm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LFp != null) {
        paramVarArgs.c(2, this.LFp);
      }
      paramVarArgs.aM(3, this.ybm);
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      paramVarArgs.bb(5, this.hyH);
      if (this.KDQ != null) {
        paramVarArgs.e(6, this.KDQ);
      }
      if (this.KDR != null) {
        paramVarArgs.e(7, this.KDR);
      }
      AppMethodBeat.o(207510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LFp != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.LFp);
      }
      i += g.a.a.b.b.a.bu(3, this.ybm);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.content);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.hyH);
      paramInt = i;
      if (this.KDQ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KDQ);
      }
      i = paramInt;
      if (this.KDR != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KDR);
      }
      AppMethodBeat.o(207510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddo localddo = (ddo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207510);
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
            localddo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207510);
          return 0;
        case 2: 
          localddo.LFp = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(207510);
          return 0;
        case 3: 
          localddo.ybm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(207510);
          return 0;
        case 4: 
          localddo.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207510);
          return 0;
        case 5: 
          localddo.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(207510);
          return 0;
        case 6: 
          localddo.KDQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207510);
          return 0;
        }
        localddo.KDR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207510);
        return 0;
      }
      AppMethodBeat.o(207510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddo
 * JD-Core Version:    0.7.0.1
 */