package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bdw
  extends dop
{
  public String LNB;
  public b LrK;
  public int bNu;
  public int iKP;
  public int scene;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169068);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.iKP);
      paramVarArgs.aM(3, this.bNu);
      if (this.LrK != null) {
        paramVarArgs.c(4, this.LrK);
      }
      if (this.LNB != null) {
        paramVarArgs.e(5, this.LNB);
      }
      paramVarArgs.aM(6, this.scene);
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.iKP) + g.a.a.b.b.a.bu(3, this.bNu);
      paramInt = i;
      if (this.LrK != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LrK);
      }
      i = paramInt;
      if (this.LNB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LNB);
      }
      i += g.a.a.b.b.a.bu(6, this.scene);
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(7, this.uli.computeSize());
      }
      AppMethodBeat.o(169068);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdw localbdw = (bdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169068);
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
            localbdw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169068);
          return 0;
        case 2: 
          localbdw.iKP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169068);
          return 0;
        case 3: 
          localbdw.bNu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169068);
          return 0;
        case 4: 
          localbdw.LrK = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169068);
          return 0;
        case 5: 
          localbdw.LNB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169068);
          return 0;
        case 6: 
          localbdw.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169068);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aov();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbdw.uli = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      AppMethodBeat.o(169068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdw
 * JD-Core Version:    0.7.0.1
 */