package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgg
  extends cwj
{
  public String FNF;
  public LinkedList<SnsObject> FUY;
  public int HNB;
  public int HNC;
  public dhk HND;
  public String HNx;
  public int Hor;
  
  public dgg()
  {
    AppMethodBeat.i(125776);
    this.FUY = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.HND == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      paramVarArgs.aS(3, this.Hor);
      paramVarArgs.e(4, 8, this.FUY);
      paramVarArgs.aS(5, this.HNB);
      if (this.FNF != null) {
        paramVarArgs.d(6, this.FNF);
      }
      paramVarArgs.aS(7, this.HNC);
      if (this.HND != null)
      {
        paramVarArgs.lJ(8, this.HND.computeSize());
        this.HND.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Hor) + f.a.a.a.c(4, 8, this.FUY) + f.a.a.b.b.a.bz(5, this.HNB);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNF);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HNC);
      paramInt = i;
      if (this.HND != null) {
        paramInt = i + f.a.a.a.lI(8, this.HND.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.HND == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgg localdgg = (dgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localdgg.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localdgg.Hor = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgg.FUY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localdgg.HNB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localdgg.FNF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localdgg.HNC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgg.HND = ((dhk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      AppMethodBeat.o(125777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgg
 * JD-Core Version:    0.7.0.1
 */