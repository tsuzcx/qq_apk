package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gn
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String token;
  public String username;
  public int wsT;
  public bnh wsU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114949);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aO(2, this.wsT);
      if (this.wsU != null)
      {
        paramVarArgs.iQ(3, this.wsU.computeSize());
        this.wsU.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.e(4, this.token);
      }
      if (this.cwc != null) {
        paramVarArgs.e(5, this.cwc);
      }
      AppMethodBeat.o(114949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsT);
      paramInt = i;
      if (this.wsU != null) {
        paramInt = i + e.a.a.a.iP(3, this.wsU.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.token);
      }
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cwc);
      }
      AppMethodBeat.o(114949);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gn localgn = (gn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114949);
          return -1;
        case 1: 
          localgn.username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114949);
          return 0;
        case 2: 
          localgn.wsT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(114949);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bnh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgn.wsU = ((bnh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114949);
          return 0;
        case 4: 
          localgn.token = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114949);
          return 0;
        }
        localgn.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(114949);
        return 0;
      }
      AppMethodBeat.o(114949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gn
 * JD-Core Version:    0.7.0.1
 */