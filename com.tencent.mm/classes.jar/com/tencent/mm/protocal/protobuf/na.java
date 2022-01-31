package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class na
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String ThumbUrl;
  public String Title;
  public nd wBR;
  public ne wBS;
  public mx wBT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124292);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(124292);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(124292);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(124292);
        throw paramVarArgs;
      }
      if (this.wBR == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(124292);
        throw paramVarArgs;
      }
      if (this.wBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActionInfo");
        AppMethodBeat.o(124292);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.wBR != null)
      {
        paramVarArgs.iQ(4, this.wBR.computeSize());
        this.wBR.writeFields(paramVarArgs);
      }
      if (this.wBS != null)
      {
        paramVarArgs.iQ(5, this.wBS.computeSize());
        this.wBS.writeFields(paramVarArgs);
      }
      if (this.wBT != null)
      {
        paramVarArgs.iQ(6, this.wBT.computeSize());
        this.wBT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label1042;
      }
    }
    label1042:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.wBR != null) {
        paramInt = i + e.a.a.a.iP(4, this.wBR.computeSize());
      }
      i = paramInt;
      if (this.wBS != null) {
        i = paramInt + e.a.a.a.iP(5, this.wBS.computeSize());
      }
      paramInt = i;
      if (this.wBT != null) {
        paramInt = i + e.a.a.a.iP(6, this.wBT.computeSize());
      }
      AppMethodBeat.o(124292);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(124292);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(124292);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(124292);
          throw paramVarArgs;
        }
        if (this.wBR == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(124292);
          throw paramVarArgs;
        }
        if (this.wBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActionInfo");
          AppMethodBeat.o(124292);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        na localna = (na)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124292);
          return -1;
        case 1: 
          localna.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124292);
          return 0;
        case 2: 
          localna.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124292);
          return 0;
        case 3: 
          localna.ThumbUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124292);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localna.wBR = ((nd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124292);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ne();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ne)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localna.wBS = ((ne)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124292);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localna.wBT = ((mx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124292);
        return 0;
      }
      AppMethodBeat.o(124292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */