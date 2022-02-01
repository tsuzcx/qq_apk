package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class esl
  extends dop
{
  public SKBuiltinBuffer_t BsI;
  public int KXP;
  public int KZk;
  public dqi MRM;
  public String Nln;
  public int Nlp;
  public int NpB;
  public LinkedList<dqi> NpC;
  public int NpD;
  public int Scene;
  public int jeU;
  
  public esl()
  {
    AppMethodBeat.i(148668);
    this.NpC = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.BsI != null)
      {
        paramVarArgs.ni(2, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.KZk);
      if (this.Nln != null) {
        paramVarArgs.e(4, this.Nln);
      }
      paramVarArgs.aM(5, this.jeU);
      paramVarArgs.aM(6, this.Nlp);
      paramVarArgs.aM(7, this.KXP);
      paramVarArgs.aM(8, this.NpB);
      paramVarArgs.e(9, 8, this.NpC);
      if (this.MRM != null)
      {
        paramVarArgs.ni(10, this.MRM.computeSize());
        this.MRM.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.NpD);
      paramVarArgs.aM(12, this.Scene);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BsI != null) {
        i = paramInt + g.a.a.a.nh(2, this.BsI.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.KZk);
      paramInt = i;
      if (this.Nln != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nln);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.jeU) + g.a.a.b.b.a.bu(6, this.Nlp) + g.a.a.b.b.a.bu(7, this.KXP) + g.a.a.b.b.a.bu(8, this.NpB) + g.a.a.a.c(9, 8, this.NpC);
      paramInt = i;
      if (this.MRM != null) {
        paramInt = i + g.a.a.a.nh(10, this.MRM.computeSize());
      }
      i = g.a.a.b.b.a.bu(11, this.NpD);
      int j = g.a.a.b.b.a.bu(12, this.Scene);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NpC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esl localesl = (esl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
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
            localesl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesl.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localesl.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localesl.Nln = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localesl.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localesl.Nlp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localesl.KXP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localesl.NpB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesl.NpC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesl.MRM = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localesl.NpD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148669);
          return 0;
        }
        localesl.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esl
 * JD-Core Version:    0.7.0.1
 */