package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class brv
  extends cwj
{
  public String FLQ;
  public LinkedList<cyg> GNH;
  public brf HeT;
  public String HeW;
  public String HeX;
  public String HeY;
  public do HeZ;
  public String uuo;
  
  public brv()
  {
    AppMethodBeat.i(123609);
    this.GNH = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HeT != null)
      {
        paramVarArgs.lJ(2, this.HeT.computeSize());
        this.HeT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GNH);
      if (this.uuo != null) {
        paramVarArgs.d(4, this.uuo);
      }
      if (this.FLQ != null) {
        paramVarArgs.d(5, this.FLQ);
      }
      if (this.HeW != null) {
        paramVarArgs.d(6, this.HeW);
      }
      if (this.HeX != null) {
        paramVarArgs.d(7, this.HeX);
      }
      if (this.HeY != null) {
        paramVarArgs.d(8, this.HeY);
      }
      if (this.HeZ != null)
      {
        paramVarArgs.lJ(9, this.HeZ.computeSize());
        this.HeZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HeT != null) {
        i = paramInt + f.a.a.a.lI(2, this.HeT.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.GNH);
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuo);
      }
      i = paramInt;
      if (this.FLQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FLQ);
      }
      paramInt = i;
      if (this.HeW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HeW);
      }
      i = paramInt;
      if (this.HeX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HeX);
      }
      paramInt = i;
      if (this.HeY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HeY);
      }
      i = paramInt;
      if (this.HeZ != null) {
        i = paramInt + f.a.a.a.lI(9, this.HeZ.computeSize());
      }
      AppMethodBeat.o(123610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GNH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brv localbrv = (brv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
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
            localbrv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrv.HeT = ((brf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrv.GNH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localbrv.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localbrv.FLQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localbrv.HeW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localbrv.HeX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localbrv.HeY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123610);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new do();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrv.HeZ = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brv
 * JD-Core Version:    0.7.0.1
 */