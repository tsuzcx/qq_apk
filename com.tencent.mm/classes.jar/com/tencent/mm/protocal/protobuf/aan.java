package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aan
  extends dop
{
  public String KHq;
  public int KRg;
  public String KSV;
  public int LlO;
  public String LlP;
  public LinkedList<aam> LlQ;
  public dvm LlR;
  public dws LlS;
  public int scene;
  
  public aan()
  {
    AppMethodBeat.i(124474);
    this.LlQ = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LlO);
      if (this.LlP != null) {
        paramVarArgs.e(3, this.LlP);
      }
      if (this.KSV != null) {
        paramVarArgs.e(4, this.KSV);
      }
      if (this.KHq != null) {
        paramVarArgs.e(5, this.KHq);
      }
      paramVarArgs.e(6, 8, this.LlQ);
      paramVarArgs.aM(7, this.scene);
      paramVarArgs.aM(8, this.KRg);
      if (this.LlR != null)
      {
        paramVarArgs.ni(9, this.LlR.computeSize());
        this.LlR.writeFields(paramVarArgs);
      }
      if (this.LlS != null)
      {
        paramVarArgs.ni(10, this.LlS.computeSize());
        this.LlS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LlO);
      paramInt = i;
      if (this.LlP != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LlP);
      }
      i = paramInt;
      if (this.KSV != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KSV);
      }
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KHq);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.LlQ) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.KRg);
      paramInt = i;
      if (this.LlR != null) {
        paramInt = i + g.a.a.a.nh(9, this.LlR.computeSize());
      }
      i = paramInt;
      if (this.LlS != null) {
        i = paramInt + g.a.a.a.nh(10, this.LlS.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LlQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aan localaan = (aan)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
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
            localaan.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localaan.LlO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localaan.LlP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localaan.KSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localaan.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aam();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aam)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaan.LlQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localaan.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localaan.KRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaan.LlR = ((dvm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dws();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaan.LlS = ((dws)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aan
 * JD-Core Version:    0.7.0.1
 */