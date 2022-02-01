package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqh
  extends ckq
{
  public LinkedList<Integer> EGc;
  public String dlB;
  public int id;
  public String query;
  
  public dqh()
  {
    AppMethodBeat.i(121118);
    this.EGc = new LinkedList();
    AppMethodBeat.o(121118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.aR(3, this.id);
      paramVarArgs.e(4, 2, this.EGc);
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      AppMethodBeat.o(121119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = i + f.a.a.b.b.a.bA(3, this.id) + f.a.a.a.c(4, 2, this.EGc);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.query);
      }
      AppMethodBeat.o(121119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EGc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(121119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqh localdqh = (dqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121119);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121119);
          return 0;
        case 2: 
          localdqh.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(121119);
          return 0;
        case 3: 
          localdqh.id = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(121119);
          return 0;
        case 4: 
          localdqh.EGc.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(121119);
          return 0;
        }
        localdqh.query = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(121119);
        return 0;
      }
      AppMethodBeat.o(121119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqh
 * JD-Core Version:    0.7.0.1
 */