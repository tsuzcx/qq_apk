package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drx
  extends cvc
{
  public int FKM;
  public int HEU;
  public int HEV;
  public int HEW;
  public int reason;
  public int scene;
  public String session_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.HEU);
      paramVarArgs.aS(4, this.FKM);
      paramVarArgs.aS(5, this.HEV);
      paramVarArgs.aS(6, this.HEW);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aS(8, this.reason);
      if (this.session_id != null) {
        paramVarArgs.d(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.HEU) + f.a.a.b.b.a.bz(4, this.FKM) + f.a.a.b.b.a.bz(5, this.HEV) + f.a.a.b.b.a.bz(6, this.HEW);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.reason);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drx localdrx = (drx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123664);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123664);
          return 0;
        case 2: 
          localdrx.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 3: 
          localdrx.HEU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 4: 
          localdrx.FKM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 5: 
          localdrx.HEV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 6: 
          localdrx.HEW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 7: 
          localdrx.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123664);
          return 0;
        case 8: 
          localdrx.reason = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123664);
          return 0;
        }
        localdrx.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123664);
        return 0;
      }
      AppMethodBeat.o(123664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */