package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aem
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Name;
  public String fKw;
  public String nqb;
  public String wNM;
  public aev wXr;
  public String wXs;
  public int wzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112420);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(112420);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(112420);
        throw paramVarArgs;
      }
      if (this.wNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(112420);
        throw paramVarArgs;
      }
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(112420);
        throw paramVarArgs;
      }
      if (this.wXr == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(112420);
        throw paramVarArgs;
      }
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.wNM != null) {
        paramVarArgs.e(3, this.wNM);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(4, this.IconUrl);
      }
      if (this.nqb != null) {
        paramVarArgs.e(5, this.nqb);
      }
      if (this.wXr != null)
      {
        paramVarArgs.iQ(6, this.wXr.computeSize());
        this.wXr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wzE);
      if (this.wXs != null) {
        paramVarArgs.e(8, this.wXs);
      }
      AppMethodBeat.o(112420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label962;
      }
    }
    label962:
    for (int i = e.a.a.b.b.a.f(1, this.fKw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.wNM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wNM);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.IconUrl);
      }
      i = paramInt;
      if (this.nqb != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nqb);
      }
      paramInt = i;
      if (this.wXr != null) {
        paramInt = i + e.a.a.a.iP(6, this.wXr.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wzE);
      paramInt = i;
      if (this.wXs != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wXs);
      }
      AppMethodBeat.o(112420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.fKw == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(112420);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(112420);
          throw paramVarArgs;
        }
        if (this.wNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(112420);
          throw paramVarArgs;
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(112420);
          throw paramVarArgs;
        }
        if (this.wXr == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(112420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aem localaem = (aem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112420);
          return -1;
        case 1: 
          localaem.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112420);
          return 0;
        case 2: 
          localaem.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112420);
          return 0;
        case 3: 
          localaem.wNM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112420);
          return 0;
        case 4: 
          localaem.IconUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112420);
          return 0;
        case 5: 
          localaem.nqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112420);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aev();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aev)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaem.wXr = ((aev)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112420);
          return 0;
        case 7: 
          localaem.wzE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(112420);
          return 0;
        }
        localaem.wXs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(112420);
        return 0;
      }
      AppMethodBeat.o(112420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */