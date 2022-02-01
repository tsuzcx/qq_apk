package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class am
  extends dop
{
  public String KDf;
  public String KDg;
  public int KDh;
  public int KDi;
  public eck KDj;
  public String eaO;
  public String eaP;
  public int eaQ;
  public String pPy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pPy != null) {
        paramVarArgs.e(2, this.pPy);
      }
      paramVarArgs.aM(3, this.eaQ);
      if (this.eaO != null) {
        paramVarArgs.e(4, this.eaO);
      }
      if (this.eaP != null) {
        paramVarArgs.e(5, this.eaP);
      }
      if (this.KDf != null) {
        paramVarArgs.e(6, this.KDf);
      }
      if (this.KDg != null) {
        paramVarArgs.e(7, this.KDg);
      }
      paramVarArgs.aM(8, this.KDh);
      paramVarArgs.aM(9, this.KDi);
      if (this.KDj != null)
      {
        paramVarArgs.ni(10, this.KDj.computeSize());
        this.KDj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pPy != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pPy);
      }
      i += g.a.a.b.b.a.bu(3, this.eaQ);
      paramInt = i;
      if (this.eaO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.eaO);
      }
      i = paramInt;
      if (this.eaP != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.eaP);
      }
      paramInt = i;
      if (this.KDf != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KDf);
      }
      i = paramInt;
      if (this.KDg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KDg);
      }
      i = i + g.a.a.b.b.a.bu(8, this.KDh) + g.a.a.b.b.a.bu(9, this.KDi);
      paramInt = i;
      if (this.KDj != null) {
        paramInt = i + g.a.a.a.nh(10, this.KDj.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.eaO == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
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
            localam.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localam.pPy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localam.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localam.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localam.eaP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localam.KDf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localam.KDg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localam.KDh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localam.KDi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eck();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eck)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localam.KDj = ((eck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */