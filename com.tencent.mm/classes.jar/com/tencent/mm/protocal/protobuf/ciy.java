package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciy
  extends cwj
{
  public String HkY;
  public String HvA;
  public dly HvB;
  public String HvC;
  public dly Hvw;
  public LinkedList<qz> Hvx;
  public String Hvy;
  public String Hvz;
  
  public ciy()
  {
    AppMethodBeat.i(117890);
    this.Hvx = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HkY != null) {
        paramVarArgs.d(2, this.HkY);
      }
      if (this.Hvw != null)
      {
        paramVarArgs.lJ(3, this.Hvw.computeSize());
        this.Hvw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Hvx);
      if (this.Hvy != null) {
        paramVarArgs.d(5, this.Hvy);
      }
      if (this.Hvz != null) {
        paramVarArgs.d(6, this.Hvz);
      }
      if (this.HvA != null) {
        paramVarArgs.d(7, this.HvA);
      }
      if (this.HvB != null)
      {
        paramVarArgs.lJ(8, this.HvB.computeSize());
        this.HvB.writeFields(paramVarArgs);
      }
      if (this.HvC != null) {
        paramVarArgs.d(9, this.HvC);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HkY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HkY);
      }
      i = paramInt;
      if (this.Hvw != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hvw.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.Hvx);
      paramInt = i;
      if (this.Hvy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hvy);
      }
      i = paramInt;
      if (this.Hvz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hvz);
      }
      paramInt = i;
      if (this.HvA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HvA);
      }
      i = paramInt;
      if (this.HvB != null) {
        i = paramInt + f.a.a.a.lI(8, this.HvB.computeSize());
      }
      paramInt = i;
      if (this.HvC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HvC);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hvx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciy localciy = (ciy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
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
            localciy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localciy.HkY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciy.Hvw = ((dly)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciy.Hvx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localciy.Hvy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localciy.Hvz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localciy.HvA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciy.HvB = ((dly)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localciy.HvC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciy
 * JD-Core Version:    0.7.0.1
 */