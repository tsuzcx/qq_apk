package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abd
  extends dop
{
  public String KDQ;
  public String KDR;
  public String KDS;
  public String Lmn;
  public long hyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207465);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.hyH);
      if (this.KDQ != null) {
        paramVarArgs.e(3, this.KDQ);
      }
      if (this.KDR != null) {
        paramVarArgs.e(4, this.KDR);
      }
      if (this.KDS != null) {
        paramVarArgs.e(5, this.KDS);
      }
      if (this.Lmn != null) {
        paramVarArgs.e(6, this.Lmn);
      }
      AppMethodBeat.o(207465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.hyH);
      paramInt = i;
      if (this.KDQ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KDQ);
      }
      i = paramInt;
      if (this.KDR != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KDR);
      }
      paramInt = i;
      if (this.KDS != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KDS);
      }
      i = paramInt;
      if (this.Lmn != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Lmn);
      }
      AppMethodBeat.o(207465);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        abd localabd = (abd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207465);
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
            localabd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207465);
          return 0;
        case 2: 
          localabd.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(207465);
          return 0;
        case 3: 
          localabd.KDQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207465);
          return 0;
        case 4: 
          localabd.KDR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207465);
          return 0;
        case 5: 
          localabd.KDS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207465);
          return 0;
        }
        localabd.Lmn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207465);
        return 0;
      }
      AppMethodBeat.o(207465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abd
 * JD-Core Version:    0.7.0.1
 */