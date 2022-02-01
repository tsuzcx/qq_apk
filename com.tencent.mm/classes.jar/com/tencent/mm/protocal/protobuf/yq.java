package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yq
  extends dop
{
  public String LjI;
  public String LjJ;
  public String LjK;
  public String LjL;
  public String LjM;
  public long LjN;
  public String LjO;
  public String LjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LjI != null) {
        paramVarArgs.e(2, this.LjI);
      }
      if (this.LjJ != null) {
        paramVarArgs.e(3, this.LjJ);
      }
      if (this.LjK != null) {
        paramVarArgs.e(4, this.LjK);
      }
      if (this.LjL != null) {
        paramVarArgs.e(5, this.LjL);
      }
      if (this.LjM != null) {
        paramVarArgs.e(6, this.LjM);
      }
      paramVarArgs.bb(7, this.LjN);
      if (this.LjO != null) {
        paramVarArgs.e(8, this.LjO);
      }
      if (this.LjP != null) {
        paramVarArgs.e(9, this.LjP);
      }
      AppMethodBeat.o(32161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LjI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LjI);
      }
      i = paramInt;
      if (this.LjJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LjJ);
      }
      paramInt = i;
      if (this.LjK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LjK);
      }
      i = paramInt;
      if (this.LjL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LjL);
      }
      paramInt = i;
      if (this.LjM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LjM);
      }
      i = paramInt + g.a.a.b.b.a.r(7, this.LjN);
      paramInt = i;
      if (this.LjO != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LjO);
      }
      i = paramInt;
      if (this.LjP != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LjP);
      }
      AppMethodBeat.o(32161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yq localyq = (yq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32161);
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
            localyq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32161);
          return 0;
        case 2: 
          localyq.LjI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 3: 
          localyq.LjJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 4: 
          localyq.LjK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 5: 
          localyq.LjL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 6: 
          localyq.LjM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 7: 
          localyq.LjN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32161);
          return 0;
        case 8: 
          localyq.LjO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32161);
          return 0;
        }
        localyq.LjP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32161);
        return 0;
      }
      AppMethodBeat.o(32161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yq
 * JD-Core Version:    0.7.0.1
 */