package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bca
  extends dop
{
  public b LLg;
  public String dPI;
  public int offset;
  public String query;
  public int scene;
  public b tVM;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.e(2, this.query);
      }
      paramVarArgs.aM(3, this.offset);
      if (this.tVM != null) {
        paramVarArgs.c(4, this.tVM);
      }
      paramVarArgs.aM(5, this.scene);
      if (this.dPI != null) {
        paramVarArgs.e(6, this.dPI);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.LLg != null) {
        paramVarArgs.c(8, this.LLg);
      }
      AppMethodBeat.o(169048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.query);
      }
      i += g.a.a.b.b.a.bu(3, this.offset);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.tVM);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.scene);
      paramInt = i;
      if (this.dPI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dPI);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(7, this.uli.computeSize());
      }
      paramInt = i;
      if (this.LLg != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.LLg);
      }
      AppMethodBeat.o(169048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bca localbca = (bca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
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
            localbca.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localbca.query = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localbca.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localbca.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localbca.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localbca.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbca.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        }
        localbca.LLg = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(169048);
        return 0;
      }
      AppMethodBeat.o(169048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bca
 * JD-Core Version:    0.7.0.1
 */