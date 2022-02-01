package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xt
  extends dop
{
  public int KKA;
  public long KMg;
  public String KMh;
  public String LbJ;
  public String xNG;
  public String xNH;
  public String xuB;
  public String xuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9586);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      paramVarArgs.bb(4, this.KMg);
      if (this.LbJ != null) {
        paramVarArgs.e(5, this.LbJ);
      }
      if (this.xuB != null) {
        paramVarArgs.e(6, this.xuB);
      }
      paramVarArgs.aM(7, this.KKA);
      if (this.KMh != null) {
        paramVarArgs.e(8, this.KMh);
      }
      if (this.xuz != null) {
        paramVarArgs.e(9, this.xuz);
      }
      AppMethodBeat.o(9586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label781;
      }
    }
    label781:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNG);
      }
      i += g.a.a.b.b.a.r(4, this.KMg);
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LbJ);
      }
      i = paramInt;
      if (this.xuB != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.xuB);
      }
      i += g.a.a.b.b.a.bu(7, this.KKA);
      paramInt = i;
      if (this.KMh != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KMh);
      }
      i = paramInt;
      if (this.xuz != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xuz);
      }
      AppMethodBeat.o(9586);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(9586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        xt localxt = (xt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9586);
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
            localxt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9586);
          return 0;
        case 2: 
          localxt.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 3: 
          localxt.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 4: 
          localxt.KMg = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(9586);
          return 0;
        case 5: 
          localxt.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 6: 
          localxt.xuB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 7: 
          localxt.KKA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9586);
          return 0;
        case 8: 
          localxt.KMh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9586);
          return 0;
        }
        localxt.xuz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(9586);
        return 0;
      }
      AppMethodBeat.o(9586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xt
 * JD-Core Version:    0.7.0.1
 */