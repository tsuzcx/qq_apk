package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlt
  extends com.tencent.mm.bw.a
{
  public String MPn;
  public LinkedList<edn> MPo;
  public String MPp;
  public dlr MPq;
  public String MPr;
  public int MPs;
  public String description;
  public String iwu;
  public String iwv;
  public String iww;
  public int pTI;
  public String title;
  public String yUK;
  public String yUL;
  
  public dlt()
  {
    AppMethodBeat.i(168759);
    this.MPo = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.iwv != null) {
        paramVarArgs.e(2, this.iwv);
      }
      if (this.iww != null) {
        paramVarArgs.e(3, this.iww);
      }
      if (this.description != null) {
        paramVarArgs.e(4, this.description);
      }
      if (this.MPn != null) {
        paramVarArgs.e(9, this.MPn);
      }
      paramVarArgs.e(10, 8, this.MPo);
      paramVarArgs.aM(11, this.pTI);
      if (this.yUK != null) {
        paramVarArgs.e(12, this.yUK);
      }
      if (this.yUL != null) {
        paramVarArgs.e(13, this.yUL);
      }
      if (this.MPp != null) {
        paramVarArgs.e(14, this.MPp);
      }
      if (this.iwu != null) {
        paramVarArgs.e(15, this.iwu);
      }
      if (this.MPq != null)
      {
        paramVarArgs.ni(16, this.MPq.computeSize());
        this.MPq.writeFields(paramVarArgs);
      }
      if (this.MPr != null) {
        paramVarArgs.e(17, this.MPr);
      }
      paramVarArgs.aM(18, this.MPs);
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1174;
      }
    }
    label1174:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iwv);
      }
      i = paramInt;
      if (this.iww != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iww);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.description);
      }
      i = paramInt;
      if (this.MPn != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MPn);
      }
      i = i + g.a.a.a.c(10, 8, this.MPo) + g.a.a.b.b.a.bu(11, this.pTI);
      paramInt = i;
      if (this.yUK != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.yUK);
      }
      i = paramInt;
      if (this.yUL != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.yUL);
      }
      paramInt = i;
      if (this.MPp != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MPp);
      }
      i = paramInt;
      if (this.iwu != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.iwu);
      }
      paramInt = i;
      if (this.MPq != null) {
        paramInt = i + g.a.a.a.nh(16, this.MPq.computeSize());
      }
      i = paramInt;
      if (this.MPr != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MPr);
      }
      paramInt = g.a.a.b.b.a.bu(18, this.MPs);
      AppMethodBeat.o(168760);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MPo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlt localdlt = (dlt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localdlt.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localdlt.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localdlt.iww = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localdlt.description = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localdlt.MPn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlt.MPo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localdlt.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localdlt.yUK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localdlt.yUL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localdlt.MPp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localdlt.iwu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlt.MPq = ((dlr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 17: 
          localdlt.MPr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        localdlt.MPs = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlt
 * JD-Core Version:    0.7.0.1
 */