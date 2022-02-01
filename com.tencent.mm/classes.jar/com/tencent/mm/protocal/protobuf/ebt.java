package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebt
  extends cvc
{
  public int DBB;
  public double HOm;
  public double HOn;
  public String HOo;
  public LinkedList<dud> HOp;
  public int scene;
  public String sessionId;
  
  public ebt()
  {
    AppMethodBeat.i(121112);
    this.HOp = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.HOm);
      paramVarArgs.e(3, this.HOn);
      if (this.HOo != null) {
        paramVarArgs.d(4, this.HOo);
      }
      paramVarArgs.aS(5, this.DBB);
      if (this.sessionId != null) {
        paramVarArgs.d(6, this.sessionId);
      }
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.e(8, 8, this.HOp);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label752;
      }
    }
    label752:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alT(2) + f.a.a.b.b.a.alT(3);
      paramInt = i;
      if (this.HOo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HOo);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.DBB);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sessionId);
      }
      i = f.a.a.b.b.a.bz(7, this.scene);
      int j = f.a.a.a.c(8, 8, this.HOp);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HOp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebt localebt = (ebt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
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
            localebt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localebt.HOm = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localebt.HOn = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localebt.HOo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localebt.DBB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localebt.sessionId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localebt.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dud();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localebt.HOp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebt
 * JD-Core Version:    0.7.0.1
 */