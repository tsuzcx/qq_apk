package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcg
  extends cvc
{
  public int GyS;
  public LinkedList<aaw> GyT;
  public String qZY;
  public String qZZ;
  public int scene;
  public String version;
  
  public bcg()
  {
    AppMethodBeat.i(210598);
    this.GyT = new LinkedList();
    AppMethodBeat.o(210598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qZY == null)
      {
        paramVarArgs = new b("Not all required fields were included: rversion");
        AppMethodBeat.o(210599);
        throw paramVarArgs;
      }
      if (this.qZZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: buildTag");
        AppMethodBeat.o(210599);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GyS);
      paramVarArgs.aS(3, this.scene);
      if (this.version != null) {
        paramVarArgs.d(4, this.version);
      }
      if (this.qZY != null) {
        paramVarArgs.d(5, this.qZY);
      }
      if (this.qZZ != null) {
        paramVarArgs.d(6, this.qZZ);
      }
      paramVarArgs.e(7, 8, this.GyT);
      AppMethodBeat.o(210599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GyS) + f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.version);
      }
      i = paramInt;
      if (this.qZY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qZY);
      }
      paramInt = i;
      if (this.qZZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.qZZ);
      }
      i = f.a.a.a.c(7, 8, this.GyT);
      AppMethodBeat.o(210599);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GyT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.qZY == null)
        {
          paramVarArgs = new b("Not all required fields were included: rversion");
          AppMethodBeat.o(210599);
          throw paramVarArgs;
        }
        if (this.qZZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: buildTag");
          AppMethodBeat.o(210599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcg localbcg = (bcg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210599);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210599);
          return 0;
        case 2: 
          localbcg.GyS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210599);
          return 0;
        case 3: 
          localbcg.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210599);
          return 0;
        case 4: 
          localbcg.version = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210599);
          return 0;
        case 5: 
          localbcg.qZY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210599);
          return 0;
        case 6: 
          localbcg.qZZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcg.GyT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(210599);
        return 0;
      }
      AppMethodBeat.o(210599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcg
 * JD-Core Version:    0.7.0.1
 */