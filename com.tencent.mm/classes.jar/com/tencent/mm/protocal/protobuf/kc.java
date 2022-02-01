package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kc
  extends dyl
{
  public LinkedList<btu> RPC;
  public ack RPD;
  public int scene;
  
  public kc()
  {
    AppMethodBeat.i(175240);
    this.RPC = new LinkedList();
    AppMethodBeat.o(175240);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175241);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RPC);
      paramVarArgs.aY(3, this.scene);
      if (this.RPD != null)
      {
        paramVarArgs.oE(4, this.RPD.computeSize());
        this.RPD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(175241);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RPC) + g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.RPD != null) {
        paramInt = i + g.a.a.a.oD(4, this.RPD.computeSize());
      }
      AppMethodBeat.o(175241);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(175241);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        kc localkc = (kc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175241);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localkc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175241);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btu)localObject2).parseFrom((byte[])localObject1);
            }
            localkc.RPC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175241);
          return 0;
        case 3: 
          localkc.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(175241);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ack();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ack)localObject2).parseFrom((byte[])localObject1);
          }
          localkc.RPD = ((ack)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(175241);
        return 0;
      }
      AppMethodBeat.o(175241);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kc
 * JD-Core Version:    0.7.0.1
 */