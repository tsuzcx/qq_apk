package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bah
  extends dpc
{
  public String KYV;
  public b LDs;
  public eak LJX;
  public FinderContact contact;
  public LinkedList<FinderObject> object;
  public int tUC;
  
  public bah()
  {
    AppMethodBeat.i(209629);
    this.object = new LinkedList();
    AppMethodBeat.o(209629);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.aM(4, this.tUC);
      if (this.LJX != null)
      {
        paramVarArgs.ni(5, this.LJX.computeSize());
        this.LJX.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.ni(6, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.KYV != null) {
        paramVarArgs.e(7, this.KYV);
      }
      AppMethodBeat.o(209630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.LDs != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LDs);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.tUC);
      paramInt = i;
      if (this.LJX != null) {
        paramInt = i + g.a.a.a.nh(5, this.LJX.computeSize());
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.nh(6, this.contact.computeSize());
      }
      paramInt = i;
      if (this.KYV != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KYV);
      }
      AppMethodBeat.o(209630);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bah localbah = (bah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209630);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbah.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209630);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbah.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209630);
          return 0;
        case 3: 
          localbah.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209630);
          return 0;
        case 4: 
          localbah.tUC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209630);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eak();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbah.LJX = ((eak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209630);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbah.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209630);
          return 0;
        }
        localbah.KYV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209630);
        return 0;
      }
      AppMethodBeat.o(209630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bah
 * JD-Core Version:    0.7.0.1
 */