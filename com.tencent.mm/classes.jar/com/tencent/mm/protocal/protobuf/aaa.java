package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aaa
  extends dop
{
  public int Brl;
  public long Brn;
  public int BsF;
  public String KXr;
  public esg Llj;
  public int Scene;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KXr != null) {
        paramVarArgs.e(2, this.KXr);
      }
      paramVarArgs.aM(3, this.BsF);
      paramVarArgs.aM(4, this.Brl);
      if (this.Llj != null)
      {
        paramVarArgs.ni(5, this.Llj.computeSize());
        this.Llj.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.Brn);
      paramVarArgs.aM(7, this.Scene);
      if (this.xNH != null) {
        paramVarArgs.e(8, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(9, this.xNG);
      }
      AppMethodBeat.o(32166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXr != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KXr);
      }
      i = i + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.Brl);
      paramInt = i;
      if (this.Llj != null) {
        paramInt = i + g.a.a.a.nh(5, this.Llj.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.Brn) + g.a.a.b.b.a.bu(7, this.Scene);
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xNG);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aaa localaaa = (aaa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
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
            localaaa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localaaa.KXr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localaaa.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localaaa.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaaa.Llj = ((esg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localaaa.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localaaa.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localaaa.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localaaa.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaa
 * JD-Core Version:    0.7.0.1
 */