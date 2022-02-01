package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jr
  extends dyy
{
  public int CqR;
  public LinkedList<String> RNs;
  public com.tencent.mm.cd.b RPl;
  public LinkedList<aji> RPm;
  public LinkedList<Boolean> RPn;
  public int lVs;
  
  public jr()
  {
    AppMethodBeat.i(104757);
    this.RNs = new LinkedList();
    this.RPm = new LinkedList();
    this.RPn = new LinkedList();
    AppMethodBeat.o(104757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104758);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CqR);
      paramVarArgs.e(3, 1, this.RNs);
      paramVarArgs.aY(4, this.lVs);
      paramVarArgs.e(5, 8, this.RPm);
      if (this.RPl != null) {
        paramVarArgs.c(6, this.RPl);
      }
      paramVarArgs.e(7, 7, this.RPn);
      AppMethodBeat.o(104758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CqR) + g.a.a.a.c(3, 1, this.RNs) + g.a.a.b.b.a.bM(4, this.lVs) + g.a.a.a.c(5, 8, this.RPm);
      paramInt = i;
      if (this.RPl != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.RPl);
      }
      i = g.a.a.a.c(7, 7, this.RPn);
      AppMethodBeat.o(104758);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNs.clear();
        this.RPm.clear();
        this.RPn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104758);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jr localjr = (jr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104758);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localjr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104758);
          return 0;
        case 2: 
          localjr.CqR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104758);
          return 0;
        case 3: 
          localjr.RNs.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(104758);
          return 0;
        case 4: 
          localjr.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104758);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aji)localObject2).parseFrom((byte[])localObject1);
            }
            localjr.RPm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104758);
          return 0;
        case 6: 
          localjr.RPl = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(104758);
          return 0;
        }
        localjr.RPn.add(Boolean.valueOf(((g.a.a.a.a)localObject1).abFh.AB()));
        AppMethodBeat.o(104758);
        return 0;
      }
      AppMethodBeat.o(104758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jr
 * JD-Core Version:    0.7.0.1
 */