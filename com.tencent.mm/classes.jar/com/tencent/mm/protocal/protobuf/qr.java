package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qr
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public qu GeK;
  public qv GeL;
  public qo GeM;
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
      if (this.GeK == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.GeM == null)
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
      if (this.GeK != null)
      {
        paramVarArgs.lJ(4, this.GeK.computeSize());
        this.GeK.writeFields(paramVarArgs);
      }
      if (this.GeL != null)
      {
        paramVarArgs.lJ(5, this.GeL.computeSize());
        this.GeL.writeFields(paramVarArgs);
      }
      if (this.GeM != null)
      {
        paramVarArgs.lJ(6, this.GeM.computeSize());
        this.GeM.writeFields(paramVarArgs);
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
      if (this.GeK != null) {
        paramInt = i + f.a.a.a.lI(4, this.GeK.computeSize());
      }
      i = paramInt;
      if (this.GeL != null) {
        i = paramInt + f.a.a.a.lI(5, this.GeL.computeSize());
      }
      paramInt = i;
      if (this.GeM != null) {
        paramInt = i + f.a.a.a.lI(6, this.GeM.computeSize());
      }
      AppMethodBeat.o(117840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        if (this.GeK == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.GeM == null)
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
        qr localqr = (qr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117840);
          return -1;
        case 1: 
          localqr.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 2: 
          localqr.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 3: 
          localqr.ThumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqr.GeK = ((qu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqr.GeL = ((qv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqr.GeM = ((qo)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qr
 * JD-Core Version:    0.7.0.1
 */