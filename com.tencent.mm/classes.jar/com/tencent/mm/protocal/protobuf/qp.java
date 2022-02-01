package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qp
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public qs FMl;
  public qt FMm;
  public qm FMn;
  public String ThumbUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      if (this.FMl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.FMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActionInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      if (this.FMl != null)
      {
        paramVarArgs.lC(4, this.FMl.computeSize());
        this.FMl.writeFields(paramVarArgs);
      }
      if (this.FMm != null)
      {
        paramVarArgs.lC(5, this.FMm.computeSize());
        this.FMm.writeFields(paramVarArgs);
      }
      if (this.FMn != null)
      {
        paramVarArgs.lC(6, this.FMn.computeSize());
        this.FMn.writeFields(paramVarArgs);
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
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.FMl != null) {
        paramInt = i + f.a.a.a.lB(4, this.FMl.computeSize());
      }
      i = paramInt;
      if (this.FMm != null) {
        i = paramInt + f.a.a.a.lB(5, this.FMm.computeSize());
      }
      paramInt = i;
      if (this.FMn != null) {
        paramInt = i + f.a.a.a.lB(6, this.FMn.computeSize());
      }
      AppMethodBeat.o(117840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        if (this.FMl == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.FMn == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qp localqp = (qp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117840);
          return -1;
        case 1: 
          localqp.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 2: 
          localqp.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 3: 
          localqp.ThumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqp.FMl = ((qs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqp.FMm = ((qt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqp.FMn = ((qm)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qp
 * JD-Core Version:    0.7.0.1
 */