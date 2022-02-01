package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdh
  extends cwj
{
  public LinkedList<dqx> GSo;
  public com.tencent.mm.bw.b GTq;
  public float HpO;
  public String HpP;
  public String HpQ;
  public String HpR;
  public int ijY;
  
  public cdh()
  {
    AppMethodBeat.i(120958);
    this.GSo = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ijY);
      paramVarArgs.e(3, 8, this.GSo);
      if (this.GTq != null) {
        paramVarArgs.c(4, this.GTq);
      }
      paramVarArgs.y(5, this.HpO);
      if (this.HpP != null) {
        paramVarArgs.d(6, this.HpP);
      }
      if (this.HpQ != null) {
        paramVarArgs.d(7, this.HpQ);
      }
      if (this.HpR != null) {
        paramVarArgs.d(8, this.HpR);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label829;
      }
    }
    label829:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ijY) + f.a.a.a.c(3, 8, this.GSo);
      paramInt = i;
      if (this.GTq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GTq);
      }
      i = paramInt + f.a.a.b.b.a.amE(5);
      paramInt = i;
      if (this.HpP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HpP);
      }
      i = paramInt;
      if (this.HpQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HpQ);
      }
      paramInt = i;
      if (this.HpR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HpR);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GSo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdh localcdh = (cdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
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
            localcdh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localcdh.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdh.GSo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localcdh.GTq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localcdh.HpO = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localcdh.HpP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localcdh.HpQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localcdh.HpR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */