package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmy
  extends dop
{
  public int KRg;
  public LinkedList<ot> MQm;
  public int MQn;
  public int MQo;
  public long MQp;
  public int MQq;
  public int scene;
  
  public dmy()
  {
    AppMethodBeat.i(6424);
    this.MQm = new LinkedList();
    AppMethodBeat.o(6424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.MQm);
      paramVarArgs.aM(3, this.MQn);
      paramVarArgs.aM(4, this.MQo);
      paramVarArgs.aM(5, this.KRg);
      paramVarArgs.bb(6, this.MQp);
      paramVarArgs.aM(7, this.scene);
      paramVarArgs.aM(8, this.MQq);
      AppMethodBeat.o(6425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label748;
      }
    }
    label748:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.MQm);
      int j = g.a.a.b.b.a.bu(3, this.MQn);
      int k = g.a.a.b.b.a.bu(4, this.MQo);
      int m = g.a.a.b.b.a.bu(5, this.KRg);
      int n = g.a.a.b.b.a.r(6, this.MQp);
      int i1 = g.a.a.b.b.a.bu(7, this.scene);
      int i2 = g.a.a.b.b.a.bu(8, this.MQq);
      AppMethodBeat.o(6425);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MQm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmy localdmy = (dmy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6425);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ot();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ot)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmy.MQm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6425);
          return 0;
        case 3: 
          localdmy.MQn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6425);
          return 0;
        case 4: 
          localdmy.MQo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6425);
          return 0;
        case 5: 
          localdmy.KRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6425);
          return 0;
        case 6: 
          localdmy.MQp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(6425);
          return 0;
        case 7: 
          localdmy.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6425);
          return 0;
        }
        localdmy.MQq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6425);
        return 0;
      }
      AppMethodBeat.o(6425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmy
 * JD-Core Version:    0.7.0.1
 */