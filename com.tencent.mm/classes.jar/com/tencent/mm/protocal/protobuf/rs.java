package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rs
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public rv KZb;
  public rw KZc;
  public rp KZd;
  public String ThumbUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.KZb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.KZd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActionInfo");
        AppMethodBeat.o(117840);
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
      if (this.KZb != null)
      {
        paramVarArgs.ni(4, this.KZb.computeSize());
        this.KZb.writeFields(paramVarArgs);
      }
      if (this.KZc != null)
      {
        paramVarArgs.ni(5, this.KZc.computeSize());
        this.KZc.writeFields(paramVarArgs);
      }
      if (this.KZd != null)
      {
        paramVarArgs.ni(6, this.KZd.computeSize());
        this.KZd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label1042;
      }
    }
    label1042:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.KZb != null) {
        paramInt = i + g.a.a.a.nh(4, this.KZb.computeSize());
      }
      i = paramInt;
      if (this.KZc != null) {
        i = paramInt + g.a.a.a.nh(5, this.KZc.computeSize());
      }
      paramInt = i;
      if (this.KZd != null) {
        paramInt = i + g.a.a.a.nh(6, this.KZd.computeSize());
      }
      AppMethodBeat.o(117840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.KZb == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.KZd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActionInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117840);
          return -1;
        case 1: 
          localrs.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 2: 
          localrs.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 3: 
          localrs.ThumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrs.KZb = ((rv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrs.KZc = ((rw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localrs.KZd = ((rp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      AppMethodBeat.o(117840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */