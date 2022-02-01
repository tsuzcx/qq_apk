package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqa
  extends dop
{
  public String LAt;
  public aov LBM;
  public String LBN;
  public long LBO;
  public long LBP;
  public String LBQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209366);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      if (this.LAt != null) {
        paramVarArgs.e(3, this.LAt);
      }
      if (this.LBN != null) {
        paramVarArgs.e(4, this.LBN);
      }
      paramVarArgs.bb(5, this.LBO);
      paramVarArgs.bb(6, this.LBP);
      if (this.LBQ != null) {
        paramVarArgs.e(7, this.LBQ);
      }
      AppMethodBeat.o(209366);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LAt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LAt);
      }
      paramInt = i;
      if (this.LBN != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LBN);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.LBO) + g.a.a.b.b.a.r(6, this.LBP);
      paramInt = i;
      if (this.LBQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LBQ);
      }
      AppMethodBeat.o(209366);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209366);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqa localaqa = (aqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209366);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209366);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqa.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209366);
          return 0;
        case 3: 
          localaqa.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209366);
          return 0;
        case 4: 
          localaqa.LBN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209366);
          return 0;
        case 5: 
          localaqa.LBO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209366);
          return 0;
        case 6: 
          localaqa.LBP = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209366);
          return 0;
        }
        localaqa.LBQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209366);
        return 0;
      }
      AppMethodBeat.o(209366);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqa
 * JD-Core Version:    0.7.0.1
 */