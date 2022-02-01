package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fee
  extends dyy
{
  public int CreateTime;
  public int Svu;
  public long Svv;
  public int UDF;
  public String UDO;
  public LinkedList<ffg> UDP;
  public int iWB;
  
  public fee()
  {
    AppMethodBeat.i(115879);
    this.UDP = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(6, this.iWB);
      paramVarArgs.e(7, 8, this.UDP);
      if (this.UDO != null) {
        paramVarArgs.f(8, this.UDO);
      }
      paramVarArgs.aY(9, this.UDF);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(6, this.iWB) + g.a.a.a.c(7, 8, this.UDP);
      paramInt = i;
      if (this.UDO != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UDO);
      }
      i = g.a.a.b.b.a.bM(9, this.UDF);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UDP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fee localfee = (fee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
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
            localfee.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localfee.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localfee.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localfee.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localfee.iWB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffg)localObject2).parseFrom((byte[])localObject1);
            }
            localfee.UDP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localfee.UDO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localfee.UDF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fee
 * JD-Core Version:    0.7.0.1
 */