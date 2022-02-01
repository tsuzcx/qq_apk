package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcl
  extends com.tencent.mm.bw.a
{
  public bcg LLB;
  public String LLC;
  public aoi LLD;
  public String dST;
  public String desc;
  public String iconUrl;
  public int tvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dST != null) {
        paramVarArgs.e(1, this.dST);
      }
      paramVarArgs.aM(2, this.tvC);
      if (this.iconUrl != null) {
        paramVarArgs.e(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      if (this.LLB != null)
      {
        paramVarArgs.ni(5, this.LLB.computeSize());
        this.LLB.writeFields(paramVarArgs);
      }
      if (this.LLC != null) {
        paramVarArgs.e(6, this.LLC);
      }
      if (this.LLD != null)
      {
        paramVarArgs.ni(7, this.LLD.computeSize());
        this.LLD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dST == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.b.b.a.f(1, this.dST) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.tvC);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.desc);
      }
      paramInt = i;
      if (this.LLB != null) {
        paramInt = i + g.a.a.a.nh(5, this.LLB.computeSize());
      }
      i = paramInt;
      if (this.LLC != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LLC);
      }
      paramInt = i;
      if (this.LLD != null) {
        paramInt = i + g.a.a.a.nh(7, this.LLD.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcl localbcl = (bcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localbcl.dST = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localbcl.tvC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localbcl.iconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localbcl.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcl.LLB = ((bcg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(164048);
          return 0;
        case 6: 
          localbcl.LLC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcl.LLD = ((aoi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcl
 * JD-Core Version:    0.7.0.1
 */